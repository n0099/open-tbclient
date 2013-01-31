package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private boolean h = true;
    private boolean i = true;
    private int j = 0;
    private int a = 0;
    private int b = 0;
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private c k = new c();

    public c a() {
        return this.k;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.k.a(jSONObject.optJSONObject("banner"));
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
                if (jSONObject.optInt("open_abstract", 1) == 2) {
                    this.i = false;
                } else {
                    this.i = true;
                }
                TiebaApplication.b().e(this.h);
                if (!this.i) {
                    TiebaApplication.b().o(this.i);
                }
                if (optInt2 == 1) {
                    TiebaApplication.b().f(true);
                } else if (optInt2 == 0) {
                    TiebaApplication.b().f(false);
                }
                this.j = jSONObject.optInt("browser_type", 2);
                TiebaApplication.b().a(this.j);
                TiebaApplication.b().c(optInt3 == 1);
                i.a(this.a);
                i.d(this.d);
                i.c(this.e);
                i.a(this.f, this.g);
                i.b(this.c);
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
