package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private boolean h = true;
    private boolean i = true;
    private boolean j = true;
    private int k = 0;
    private int m = 100000;
    private int a = 0;
    private int b = 0;
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private c l = new c();

    public int a() {
        return this.m;
    }

    public c b() {
        return this.l;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.l.a(jSONObject.optJSONObject("banner"));
                this.a = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.b = jSONObject.optInt("pb_big_image_width", 0);
                this.d = jSONObject.optString("big_head_image_host");
                this.e = jSONObject.optString("small_head_image_host");
                this.f = jSONObject.optString("yijianfankui_fname");
                this.g = jSONObject.optString("yijianfankui_fid");
                this.c = jSONObject.optInt("img_chunk_upload_enable", 1);
                int optInt = jSONObject.optInt("open_filter", 1);
                int optInt2 = jSONObject.optInt("app_recommend", -1);
                int optInt3 = jSONObject.optInt("use_baidu_statis_gbk", 1);
                if (optInt == 2) {
                    this.h = false;
                } else {
                    this.h = true;
                }
                this.j = jSONObject.optInt("gpu_open", 1) == 1;
                TiebaApplication.e().f(this.j);
                if (jSONObject.optInt("open_abstract", 1) == 2) {
                    this.i = false;
                } else {
                    this.i = true;
                }
                if (!this.h) {
                    TiebaApplication.e().e(this.h);
                }
                if (!this.i) {
                    TiebaApplication.e().r(this.i);
                }
                if (optInt2 == 1) {
                    TiebaApplication.e().g(true);
                } else if (optInt2 == 0) {
                    TiebaApplication.e().g(false);
                }
                this.k = jSONObject.optInt("browser_type", 2);
                this.m = jSONObject.optInt("perform_sample_param", 100000);
                TiebaApplication.e().a(this.k);
                TiebaApplication.e().c(optInt3 == 1);
                TiebaApplication.e().s(jSONObject.optInt("open_local_popularize", 0) == 1);
                i.a(this.a);
                i.d(this.d);
                i.c(this.e);
                i.a(this.f, this.g);
                i.b(this.c);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
