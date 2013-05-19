package com.baidu.tieba.b;

import android.location.Address;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.bh;
import com.baidu.tieba.a.f;
import com.baidu.tieba.a.i;
import com.baidu.tieba.a.o;
import com.baidu.tieba.a.z;
import com.baidu.tieba.d.ad;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
import com.baidu.tieba.d.t;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static final String a = String.valueOf(i.e) + "c/c/thread/add";
    private static final String b = String.valueOf(i.e) + "c/c/post/add";
    private static final String c = String.valueOf(i.e) + "c/c/img/upload";
    private t d = null;
    private o e;

    public c() {
        this.e = null;
        this.e = new o();
    }

    public String a(bh bhVar, boolean z) {
        String str;
        f fVar;
        long j;
        String str2 = null;
        if (bhVar != null) {
            if (z) {
                try {
                    File c2 = com.baidu.tieba.d.o.c("tieba_resized_image");
                    this.d = new t(c);
                    if (c2.length() <= 102400 || (i.l() == 0 && this.d.e() != null && !this.d.e().equals("2"))) {
                        ae.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                        this.d.a("pic_type", String.valueOf(bhVar.o()));
                        String b2 = this.d.b("tieba_resized_image");
                        if (this.d.b()) {
                            str = b2;
                            JSONObject jSONObject = new JSONObject(str);
                            z zVar = new z();
                            zVar.a(jSONObject.optJSONObject("info"));
                            bhVar.a(zVar);
                        }
                    } else {
                        ae.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                        String a2 = ad.a(com.baidu.tieba.d.o.a(c2));
                        f n = k.n(a2);
                        if (n == null) {
                            ae.e("PostThreadTask", "doInBackground", "upload data is null");
                            f fVar2 = new f();
                            fVar2.a(a2);
                            fVar2.a(0);
                            fVar2.a(c2.length());
                            fVar = fVar2;
                        } else {
                            fVar = n;
                        }
                        if (new com.baidu.tieba.d.f("tieba_resized_image", fVar, String.valueOf(i.e) + "c/c/img/chunkupload").b().a()) {
                            this.d = new t(String.valueOf(i.e) + "c/c/img/finupload");
                            this.d.a("md5", fVar.a());
                            this.d.a("pic_type", String.valueOf(bhVar.o()));
                            String i = this.d.i();
                            if (i == null || !this.d.b()) {
                                long b3 = fVar.b();
                                if (b3 % 102400 == 0) {
                                    j = b3 / 102400;
                                } else {
                                    j = (b3 / 102400) + 1;
                                }
                                fVar.a((int) j);
                                k.a(fVar);
                            } else {
                                k.m(a2);
                                str = i;
                                JSONObject jSONObject2 = new JSONObject(str);
                                z zVar2 = new z();
                                zVar2.a(jSONObject2.optJSONObject("info"));
                                bhVar.a(zVar2);
                            }
                        }
                    }
                } catch (Exception e) {
                    ae.b(getClass().getName(), "doInBackground", e.getMessage());
                }
            }
            this.d = new t();
            this.d.d(true);
            this.d.a("anonymous", "1");
            this.d.a("fid", bhVar.g());
            String str3 = "";
            if (bhVar.k() != null && bhVar.k().a() != null && bhVar.k().a().length() > 0) {
                str3 = String.format("#(pic,%s,%d,%d)", bhVar.k().a(), Integer.valueOf(bhVar.k().b()), Integer.valueOf(bhVar.k().c()));
            }
            this.d.a(PushConstants.EXTRA_CONTENT, String.valueOf(bhVar.d()) + str3);
            if (bhVar.j() != null && bhVar.j().length() > 0) {
                this.d.a("vcode", bhVar.j());
            }
            if (TiebaApplication.d().al() < 3) {
                this.d.a("vcode_tag", "11");
            }
            Address aC = TiebaApplication.d().aC();
            switch (bhVar.b()) {
                case 0:
                    this.d.a(a);
                    this.d.a("kw", bhVar.h());
                    this.d.a("title", bhVar.c());
                    if (aC != null && TiebaApplication.d().o() && !i.f().equals(bhVar.g())) {
                        this.d.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
                        break;
                    }
                    break;
                case 1:
                    this.d.a(b);
                    this.d.a("tid", bhVar.e());
                    this.d.a("kw", bhVar.h());
                    this.d.a("is_ad", bhVar.a() ? "1" : "0");
                    break;
                case 2:
                    this.d.a(b);
                    this.d.a("tid", bhVar.e());
                    this.d.a("kw", bhVar.h());
                    this.d.a("quote_id", String.valueOf(bhVar.f()));
                    this.d.a("floor_num", String.valueOf(bhVar.i()));
                    this.d.a("is_ad", bhVar.a() ? "1" : "0");
                    break;
                case 3:
                    this.d.a(a);
                    this.d.a("thread_type", "7");
                    this.d.a("st_type", "tb_suishoufa");
                    if (aC != null && TiebaApplication.d().o() && !i.f().equals(bhVar.g())) {
                        this.d.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
                        break;
                    }
                    break;
                case 4:
                    this.d.a(b);
                    this.d.a("tid", bhVar.e());
                    this.d.a("kw", bhVar.h());
                    this.d.a("is_ad", bhVar.a() ? "1" : "0");
                    break;
            }
            str2 = this.d.i();
            if (this.d.b()) {
                this.e.b(str2);
            } else {
                this.e.a(this.d.d());
                this.e.a(this.d.f());
            }
        }
        return str2;
    }

    public boolean a() {
        if (this.d == null) {
            return false;
        }
        return this.d.b();
    }

    public int b() {
        if (this.d == null) {
            return -1;
        }
        return this.d.d();
    }

    public String c() {
        if (this.d == null) {
            return null;
        }
        return this.d.f();
    }

    public void d() {
        if (this.d != null) {
            this.d.g();
        }
    }
}
