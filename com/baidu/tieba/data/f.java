package com.baidu.tieba.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Integer> r;
    private final boolean a = true;
    private boolean j = true;
    private boolean k = true;
    private int l = 100000;
    private int m = TbConfig.POST_IMAGE_SMALL;
    private int n = 10;
    private int o = 10;
    private int p = 6257;
    private int q = 1000;
    private boolean t = false;
    private int c = 0;
    private int d = 0;
    private int e = 1;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private final BannerData b = new BannerData();
    private com.baidu.tbadk.core.data.f s = new com.baidu.tbadk.core.data.f();

    public f() {
        this.r = null;
        this.r = new HashMap<>();
    }

    public int a() {
        return this.l;
    }

    public int b() {
        return this.q;
    }

    public int c() {
        return this.p;
    }

    public void a(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.b.parserJson(jSONObject.optJSONObject("banner"));
                this.c = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.d = jSONObject.optInt("pb_big_image_width", 0);
                this.f = jSONObject.optString("big_head_image_host");
                this.g = jSONObject.optString("small_head_image_host");
                this.h = jSONObject.optString("yijianfankui_fname");
                this.i = jSONObject.optString("yijianfankui_fid");
                this.e = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.m = jSONObject.optInt("kuainan_vote_cd", TbConfig.POST_IMAGE_SMALL);
                this.n = jSONObject.optInt("kuainan_vote_max", 10);
                this.o = jSONObject.optInt("kuainan_vote_rate", 10);
                this.p = jSONObject.optInt("aladin_port", 6257);
                this.q = jSONObject.optInt("crash_limit_count", 1000);
                int optInt = jSONObject.optInt("app_recommend", -1);
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.a().a(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.a().b(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.a().a(1 == optJSONObject.optInt("ad_show", 1));
                }
                com.baidu.tieba.ai.c().m(this.h);
                if (this.s == null) {
                    this.s = new com.baidu.tbadk.core.data.f();
                }
                this.s.a(jSONObject.optString("photo_strategy"));
                com.baidu.tbadk.core.util.e.a().a(this.s);
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.r.put(optString, valueOf);
                            if ("netlib_type".equals(optString)) {
                                TbadkApplication.m252getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.a.f.a().a(optString, valueOf.intValue());
                                LoginActivity.a();
                            }
                        }
                    }
                }
                if (this.r != null && this.r.size() > 0) {
                    com.baidu.adp.lib.a.f.a().a(this.r);
                }
                this.k = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkApplication.m252getInst().setIsPushServiceOpen(this.k);
                TbadkApplication.m252getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.k) {
                    UtilHelper.stopPushService(com.baidu.tieba.ai.c().d().getApplicationContext());
                }
                TbadkApplication.m252getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.j = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkApplication.m252getInst().setGpuOpen(this.j);
                TbadkApplication.m252getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.t = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.t);
                if (com.baidu.tieba.ai.c().D()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkApplication.m252getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkApplication.m252getInst().setIsAbstractOn(optInt2);
                    }
                    com.baidu.tieba.ai.c().q(false);
                }
                if (optInt == 1) {
                    com.baidu.tieba.ai.c().d(true);
                } else if (optInt == 0) {
                    com.baidu.tieba.ai.c().d(false);
                }
                com.baidu.tieba.ai.c().f(this.m);
                com.baidu.tieba.ai.c().g(this.n);
                com.baidu.tieba.ai.c().h(this.o);
                this.l = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("wifi");
                    if (optJSONObject3 != null) {
                        TbadkApplication.m252getInst().setKeepaliveWifi(optJSONObject3.optInt("switch"));
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("nonwifi");
                    if (optJSONObject4 != null) {
                        TbadkApplication.m252getInst().setKeepaliveNonWifi(optJSONObject4.optInt("switch"));
                    }
                }
                com.baidu.tieba.ai.c().i(a(jSONObject.optJSONArray("lcsReconStrategy")));
                com.baidu.tieba.ai.c().j(a(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                com.baidu.tieba.ai.c().k(a(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject5 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject5 != null) {
                    com.baidu.tieba.ai.c().a(new int[]{optJSONObject5.optInt("2gTo", 0) * 1000, optJSONObject5.optInt("3gTo", 0) * 1000, optJSONObject5.optInt("wifiTo", 0) * 1000});
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                e.a(this.c);
                TbConfig.setBigPhotoAdress(this.f);
                TbConfig.setSmallPhotoAdress(this.g);
                e.a(this.h, this.i);
                e.b(this.e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(jSONArray.get(i));
            if (i < length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
