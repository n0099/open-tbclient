package com.baidu.tieba.data;

import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean h = true;
    private boolean i = true;
    private boolean j = true;
    private int k = 0;
    private int m = 100000;
    private boolean n = true;
    private int o = 600;
    private int p = 10;
    private int q = 10;

    /* renamed from: a  reason: collision with root package name */
    private int f1012a = 0;
    private int b = 0;
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private BannerData l = new BannerData();

    public int a() {
        return this.m;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.l.parserJson(jSONObject.optJSONObject("banner"));
                this.f1012a = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.b = jSONObject.optInt("pb_big_image_width", 0);
                this.d = jSONObject.optString("big_head_image_host");
                this.e = jSONObject.optString("small_head_image_host");
                this.f = jSONObject.optString("yijianfankui_fname");
                this.g = jSONObject.optString("yijianfankui_fid");
                this.c = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.o = jSONObject.optInt("kuainan_vote_cd", 600);
                this.p = jSONObject.optInt("kuainan_vote_max", 10);
                this.q = jSONObject.optInt("kuainan_vote_rate", 10);
                int optInt = jSONObject.optInt("open_filter", 1);
                int optInt2 = jSONObject.optInt("app_recommend", -1);
                int optInt3 = jSONObject.optInt("use_baidu_statis_gbk", 1);
                if (optInt == 2) {
                    this.h = false;
                } else {
                    this.h = true;
                }
                this.n = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TiebaApplication.f().h(this.n);
                TiebaApplication.f().g(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.n) {
                    com.baidu.tieba.util.am.h(TiebaApplication.f().getApplicationContext());
                }
                this.j = jSONObject.optInt("gpu_open", 1) == 1;
                TiebaApplication.f().f(this.j);
                if (jSONObject.optInt("open_abstract", 1) == 2) {
                    this.i = false;
                } else {
                    this.i = true;
                }
                if (!this.h) {
                    TiebaApplication.f().e(this.h);
                }
                if (!this.i) {
                    TiebaApplication.f().s(this.i);
                }
                if (optInt2 == 1) {
                    TiebaApplication.f().i(true);
                } else if (optInt2 == 0) {
                    TiebaApplication.f().i(false);
                }
                TiebaApplication.f().m(this.o);
                TiebaApplication.f().n(this.p);
                TiebaApplication.f().o(this.q);
                this.k = jSONObject.optInt("browser_type", 2);
                this.m = jSONObject.optInt("perform_sample_param", 100000);
                TiebaApplication.f().a(this.k);
                TiebaApplication.f().c(optInt3 == 1);
                TiebaApplication.f().t(jSONObject.optInt("open_local_popularize", 0) == 1);
                g.a(this.f1012a);
                g.d(this.d);
                g.c(this.e);
                g.a(this.f, this.g);
                g.b(this.c);
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
