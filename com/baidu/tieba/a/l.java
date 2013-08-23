package com.baidu.tieba.a;

import android.location.Address;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.r;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.util.p;
import com.baidu.tieba.util.v;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f858a = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/thread/add";
    private static final String b = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/add";
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/upload";
    private v d = null;
    private r e;

    public l() {
        this.e = null;
        this.e = new r();
    }

    public String a(WriteData writeData, boolean z) {
        String str;
        com.baidu.tieba.data.d dVar;
        long j;
        String str2 = null;
        if (writeData != null) {
            if (z) {
                try {
                    File c2 = p.c("tieba_resized_image");
                    this.d = new v(c);
                    if (c2.length() <= 102400 || (com.baidu.tieba.data.g.n() == 0 && this.d.f() != null && !this.d.f().equals("2"))) {
                        aq.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                        this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                        String b2 = this.d.b("tieba_resized_image");
                        if (this.d.c()) {
                            str = b2;
                            JSONObject jSONObject = new JSONObject(str);
                            InfoData infoData = new InfoData();
                            infoData.parserJson(jSONObject.optJSONObject("info"));
                            writeData.setBitmapId(infoData);
                        }
                    } else {
                        aq.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                        String a2 = ap.a(p.a(c2));
                        com.baidu.tieba.data.d o = DatabaseService.o(a2);
                        if (o == null) {
                            aq.e("PostThreadTask", "doInBackground", "upload data is null");
                            com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                            dVar2.a(a2);
                            dVar2.a(0);
                            dVar2.a(c2.length());
                            dVar = dVar2;
                        } else {
                            dVar = o;
                        }
                        if (new com.baidu.tieba.util.f("tieba_resized_image", dVar, String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/chunkupload").b().a()) {
                            this.d = new v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/finupload");
                            this.d.a("md5", dVar.a());
                            this.d.a("pic_type", String.valueOf(writeData.getPicType()));
                            String j2 = this.d.j();
                            if (j2 == null || !this.d.c()) {
                                long b3 = dVar.b();
                                if (b3 % 102400 == 0) {
                                    j = b3 / 102400;
                                } else {
                                    j = (b3 / 102400) + 1;
                                }
                                dVar.a((int) j);
                                DatabaseService.a(dVar);
                            } else {
                                DatabaseService.n(a2);
                                str = j2;
                                JSONObject jSONObject2 = new JSONObject(str);
                                InfoData infoData2 = new InfoData();
                                infoData2.parserJson(jSONObject2.optJSONObject("info"));
                                writeData.setBitmapId(infoData2);
                            }
                        }
                    }
                } catch (Exception e) {
                    aq.b(getClass().getName(), "doInBackground", e.getMessage());
                }
            }
            this.d = new v();
            this.d.e(true);
            this.d.a("anonymous", "1");
            this.d.a("fid", writeData.getForumId());
            String str3 = "";
            if (writeData.getBitmapId() != null && writeData.getBitmapId().getPic_id() != null && writeData.getBitmapId().getPic_id().length() > 0) {
                str3 = String.format("#(pic,%s,%d,%d)", writeData.getBitmapId().getPic_id(), Integer.valueOf(writeData.getBitmapId().getWidth()), Integer.valueOf(writeData.getBitmapId().getHeight()));
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.d.a("vcode", writeData.getVcode());
            }
            if (TiebaApplication.g().aq() < 3) {
                this.d.a("vcode_tag", "11");
            }
            Address aK = TiebaApplication.g().aK();
            this.d.a("new_vcode", "1");
            this.d.a("content", String.valueOf(writeData.getContent()) + str3);
            switch (writeData.getType()) {
                case 0:
                    this.d.a(f858a);
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("title", writeData.getTitle());
                    if (aK != null && TiebaApplication.g().v() && !com.baidu.tieba.data.g.h().equals(writeData.getForumId())) {
                        this.d.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
                        break;
                    }
                    break;
                case 1:
                    this.d.a(b);
                    this.d.a("tid", writeData.getThreadId());
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("is_ad", writeData.getIsAd() ? "1" : "0");
                    break;
                case 2:
                    this.d.a(b);
                    this.d.a("tid", writeData.getThreadId());
                    this.d.a("kw", writeData.getForumName());
                    this.d.a("quote_id", String.valueOf(writeData.getFloor()));
                    this.d.a("floor_num", String.valueOf(writeData.getFloorNum()));
                    this.d.a("is_ad", writeData.getIsAd() ? "1" : "0");
                    break;
            }
            str2 = this.d.j();
            if (this.d.c()) {
                this.e.b(str2);
            } else {
                this.e.a(this.d.e());
                this.e.a(this.d.g());
            }
        }
        return str2;
    }

    public boolean a() {
        if (this.d == null) {
            return false;
        }
        return this.d.c();
    }

    public int b() {
        if (this.d == null) {
            return -1;
        }
        return this.d.e();
    }

    public String c() {
        if (this.d == null) {
            return null;
        }
        return this.d.g();
    }

    public void d() {
        if (this.d != null) {
            this.d.h();
        }
    }
}
