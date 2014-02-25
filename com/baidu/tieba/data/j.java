package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.switchs.SwitchModel;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private HashMap<String, Integer> p;
    private boolean h = true;
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
    private BannerData j = new BannerData();
    private c q = new c();

    public j() {
        this.p = null;
        this.p = new HashMap<>();
    }

    public int a() {
        return this.k;
    }

    public void a(JSONObject jSONObject) {
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
                    this.q = new c();
                }
                this.q.a(jSONObject.optString("photo_strategy"));
                com.baidu.tieba.util.o.a().a(this.q);
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString(SocialConstants.PARAM_MEDIA_UNAME);
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            if ("netlib_type".equals(optString)) {
                                TiebaApplication.g().k(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            }
                            this.p.put(optString, valueOf);
                        }
                    }
                }
                if (this.p != null && this.p.size() > 0) {
                    SwitchModel.refreshSwitchManager(this.p);
                    if (com.baidu.adp.lib.a.d.a().b(SwitchKey.LOG) == 0) {
                        com.baidu.tieba.log.a.a(true);
                    } else {
                        com.baidu.tieba.log.a.a(false);
                    }
                }
                this.l = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TiebaApplication.g().f(this.l);
                TiebaApplication.g().e(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.l) {
                    UtilHelper.g(TiebaApplication.g().b().getApplicationContext());
                }
                this.i = jSONObject.optInt("gpu_open", 1) == 1;
                TiebaApplication.g().d(this.i);
                this.r = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.a(this.r);
                if (TiebaApplication.g().aH()) {
                    int optInt3 = jSONObject.optInt("open_abstract", 0);
                    if (!(optInt3 == 0 || TiebaApplication.g().aj() != 0)) {
                        TiebaApplication.g().d(optInt3);
                    }
                    TiebaApplication.g().w(false);
                }
                if (optInt == 1) {
                    TiebaApplication.g().g(true);
                } else if (optInt == 0) {
                    TiebaApplication.g().g(false);
                }
                TiebaApplication.g().j(this.m);
                TiebaApplication.g().n(this.n);
                TiebaApplication.g().o(this.o);
                this.k = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject = jSONObject.optJSONObject("keepalive");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("wifi");
                    if (optJSONObject2 != null) {
                        TiebaApplication.g().l(optJSONObject2.optInt("switch"));
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("nonwifi");
                    if (optJSONObject3 != null) {
                        TiebaApplication.g().m(optJSONObject3.optInt("switch"));
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
                    TiebaApplication.g().s(str);
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
                    TiebaApplication.g().t(str2);
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
                    TiebaApplication.g().u(str3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject4 != null) {
                    TiebaApplication.g().a(new int[]{optJSONObject4.optInt("2gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("3gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("wifiTo", 0) * LocationClientOption.MIN_SCAN_SPAN});
                }
                com.baidu.tieba.im.messageCenter.m.a().e();
                com.baidu.tieba.im.b.a.c().d();
                TiebaApplication.g().c(optInt2 == 1);
                i.b(this.a);
                i.f(this.d);
                i.e(this.e);
                i.a(this.f, this.g);
                i.c(this.c);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
