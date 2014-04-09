package com.baidu.tieba.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.switchs.features.LogSwitchStatic;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    private HashMap<String, Integer> p;
    private final boolean h = true;
    private boolean i = true;
    private int k = 100000;
    private boolean l = true;
    private int m = 600;
    private int n = 10;
    private int o = 10;
    private boolean r = false;
    private int a = 0;
    private int b = 0;
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private final BannerData j = new BannerData();
    private com.baidu.tbadk.core.data.e q = new com.baidu.tbadk.core.data.e();

    public e() {
        this.p = null;
        this.p = new HashMap<>();
    }

    public final int a() {
        return this.k;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.j.parserJson(jSONObject.optJSONObject("banner"));
                this.a = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.b = jSONObject.optInt("pb_big_image_width", 0);
                this.d = jSONObject.optString("big_head_image_host");
                this.e = jSONObject.optString("small_head_image_host");
                this.f = jSONObject.optString("yijianfankui_fname");
                this.g = jSONObject.optString("yijianfankui_fid");
                this.c = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.m = jSONObject.optInt("kuainan_vote_cd", 600);
                this.n = jSONObject.optInt("kuainan_vote_max", 10);
                this.o = jSONObject.optInt("kuainan_vote_rate", 10);
                int optInt = jSONObject.optInt("app_recommend", -1);
                int optInt2 = jSONObject.optInt("use_baidu_statis_gbk", 1);
                if (this.q == null) {
                    this.q = new com.baidu.tbadk.core.data.e();
                }
                this.q.a(jSONObject.optString("photo_strategy"));
                com.baidu.tbadk.core.util.h.a().a(this.q);
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            if ("netlib_type".equals(optString)) {
                                TbadkApplication.j().c(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            }
                            this.p.put(optString, valueOf);
                        }
                    }
                }
                if (this.p != null && this.p.size() > 0) {
                    com.baidu.adp.lib.a.f.a().a(this.p);
                    com.baidu.adp.lib.a.f.a().b(LogSwitchStatic.LOG);
                    com.baidu.tbadk.core.log.a.a();
                }
                this.l = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkApplication.j().c(this.l);
                boolean z = jSONObject.optInt("is_moplus_open", 1) == 1;
                com.baidu.tieba.p.c();
                com.baidu.tieba.p.c(z);
                if (!this.l) {
                    com.baidu.tieba.p.c();
                    UtilHelper.b(com.baidu.tieba.p.d().getApplicationContext());
                }
                this.i = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkApplication.j().j(this.i);
                this.r = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                boolean z2 = this.r;
                VoiceManager.a();
                com.baidu.tieba.p.c();
                if (com.baidu.tieba.p.C()) {
                    int optInt3 = jSONObject.optInt("open_abstract", 0);
                    if (!(optInt3 == 0 || TbadkApplication.j().k() != 0)) {
                        TbadkApplication.j().a(optInt3);
                    }
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.B();
                }
                if (optInt == 1) {
                    com.baidu.tieba.p.c().d(true);
                } else if (optInt == 0) {
                    com.baidu.tieba.p.c().d(false);
                }
                com.baidu.tieba.p.c();
                com.baidu.tieba.p.f(this.m);
                com.baidu.tieba.p.c();
                com.baidu.tieba.p.g(this.n);
                com.baidu.tieba.p.c();
                com.baidu.tieba.p.h(this.o);
                this.k = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject = jSONObject.optJSONObject("keepalive");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("wifi");
                    if (optJSONObject2 != null) {
                        TbadkApplication.j().e(optJSONObject2.optInt("switch"));
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("nonwifi");
                    if (optJSONObject3 != null) {
                        TbadkApplication.j().f(optJSONObject3.optInt("switch"));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("lcsReconStrategy");
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    String str = "";
                    for (int i2 = 0; i2 < length; i2++) {
                        str = String.valueOf(str) + optJSONArray2.get(i2);
                        if (i2 < length - 1) {
                            str = String.valueOf(str) + ",";
                        }
                    }
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.j(str);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("lcsHeartbeatStrategy");
                if (optJSONArray3 != null) {
                    int length2 = optJSONArray3.length();
                    String str2 = "";
                    for (int i3 = 0; i3 < length2; i3++) {
                        str2 = String.valueOf(str2) + optJSONArray3.get(i3);
                        if (i3 < length2 - 1) {
                            str2 = String.valueOf(str2) + ",";
                        }
                    }
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.k(str2);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("imGetMsgStrategy");
                if (optJSONArray4 != null) {
                    int length3 = optJSONArray4.length();
                    String str3 = "";
                    for (int i4 = 0; i4 < length3; i4++) {
                        str3 = String.valueOf(str3) + optJSONArray4.get(i4);
                        if (i4 < length3 - 1) {
                            str3 = String.valueOf(str3) + ",";
                        }
                    }
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.l(str3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject4 != null) {
                    com.baidu.tieba.p.c().a(new int[]{optJSONObject4.optInt("2gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("3gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("wifiTo", 0) * LocationClientOption.MIN_SCAN_SPAN});
                }
                com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2008017));
                TbadkApplication.j().b(optInt2 == 1);
                d.a(this.a);
                com.baidu.tbadk.core.data.n.f(this.d);
                com.baidu.tbadk.core.data.n.e(this.e);
                d.a(this.f, this.g);
                d.b(this.c);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
