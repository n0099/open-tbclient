package com.baidu.tieba.data;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.UtilHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private HashMap q;
    private boolean h = true;
    private boolean i = true;
    private boolean j = true;
    private int l = 100000;
    private boolean m = true;
    private int n = 600;
    private int o = 10;
    private int p = 10;

    /* renamed from: a  reason: collision with root package name */
    private int f1015a = 0;
    private int b = 0;
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private BannerData k = new BannerData();

    public h() {
        this.q = null;
        this.q = new HashMap();
    }

    public int a() {
        return this.l;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.k.parserJson(jSONObject.optJSONObject("banner"));
                this.f1015a = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.b = jSONObject.optInt("pb_big_image_width", 0);
                this.d = jSONObject.optString("big_head_image_host");
                this.e = jSONObject.optString("small_head_image_host");
                this.f = jSONObject.optString("yijianfankui_fname");
                this.g = jSONObject.optString("yijianfankui_fid");
                this.c = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.n = jSONObject.optInt("kuainan_vote_cd", 600);
                this.o = jSONObject.optInt("kuainan_vote_max", 10);
                this.p = jSONObject.optInt("kuainan_vote_rate", 10);
                int optInt = jSONObject.optInt("app_recommend", -1);
                int optInt2 = jSONObject.optInt("use_baidu_statis_gbk", 1);
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            this.q.put(jSONObject2.optString("name"), Integer.valueOf(jSONObject2.optInt("type", -1)));
                        }
                    }
                }
                if (this.q != null && this.q.size() > 0) {
                    SwitchModel.refreshSwitchManager(this.q);
                }
                this.m = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TiebaApplication.g().g(this.m);
                TiebaApplication.g().f(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.m) {
                    UtilHelper.h(TiebaApplication.g().getApplicationContext());
                }
                this.j = jSONObject.optInt("gpu_open", 1) == 1;
                TiebaApplication.g().e(this.j);
                if (jSONObject.optInt("open_abstract", 1) == 2) {
                    this.i = false;
                } else {
                    this.i = true;
                }
                if (!this.i) {
                    TiebaApplication.g().r(this.i);
                }
                if (optInt == 1) {
                    TiebaApplication.g().h(true);
                } else if (optInt == 0) {
                    TiebaApplication.g().h(false);
                }
                TiebaApplication.g().l(this.n);
                TiebaApplication.g().n(this.o);
                TiebaApplication.g().o(this.p);
                this.l = jSONObject.optInt("perform_sample_param", 100000);
                TiebaApplication.g().c(optInt2 == 1);
                TiebaApplication.g().s(jSONObject.optInt("open_local_popularize", 0) == 1);
                g.a(this.f1015a);
                g.e(this.d);
                g.d(this.e);
                g.a(this.f, this.g);
                g.b(this.c);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
