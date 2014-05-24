package com.baidu.tieba.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.switchs.features.LogSwitchStatic;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String j;
    private HashMap<String, Integer> q;
    private final boolean a = true;
    private boolean k = true;
    private boolean l = true;
    private int m = 100000;
    private int n = TbConfig.POST_IMAGE_SMALL;
    private int o = 10;
    private int p = 10;
    private boolean s = false;
    private int c = 0;
    private int d = 0;
    private int e = 1;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private final BannerData b = new BannerData();
    private com.baidu.tbadk.core.data.e r = new com.baidu.tbadk.core.data.e();

    public e() {
        this.q = null;
        this.q = new HashMap<>();
    }

    public int a() {
        return this.m;
    }

    public String b() {
        return this.j;
    }

    public void a(JSONObject jSONObject) {
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
                this.n = jSONObject.optInt("kuainan_vote_cd", TbConfig.POST_IMAGE_SMALL);
                this.o = jSONObject.optInt("kuainan_vote_max", 10);
                this.p = jSONObject.optInt("kuainan_vote_rate", 10);
                this.j = jSONObject.optString("as_downloadurl");
                int optInt = jSONObject.optInt("app_recommend", -1);
                int optInt2 = jSONObject.optInt("use_baidu_statis_gbk", 1);
                if (this.r == null) {
                    this.r = new com.baidu.tbadk.core.data.e();
                }
                this.r.a(jSONObject.optString("photo_strategy"));
                com.baidu.tbadk.core.util.h.a().a(this.r);
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.q.put(optString, valueOf);
                            if ("netlib_type".equals(optString)) {
                                TbadkApplication.m252getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.a.f.a().a(optString, valueOf.intValue());
                                LoginActivity.a();
                            }
                        }
                    }
                }
                if (this.q != null && this.q.size() > 0) {
                    com.baidu.adp.lib.a.f.a().a(this.q);
                    if (com.baidu.adp.lib.a.f.a().b(LogSwitchStatic.LOG) == 0) {
                        com.baidu.tbadk.core.log.a.a(true);
                    } else {
                        com.baidu.tbadk.core.log.a.a(false);
                    }
                }
                this.l = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkApplication.m252getInst().setIsPushServiceOpen(this.l);
                TbadkApplication.m252getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.l) {
                    UtilHelper.stopPushService(com.baidu.tieba.ai.c().d().getApplicationContext());
                }
                TbadkApplication.m252getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.k = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkApplication.m252getInst().setGpuOpen(this.k);
                this.s = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.s);
                if (com.baidu.tieba.ai.c().E()) {
                    int optInt3 = jSONObject.optInt("open_abstract", 0);
                    if (!(optInt3 == 0 || TbadkApplication.m252getInst().getIsAbstractStatus() != 0)) {
                        TbadkApplication.m252getInst().setIsAbstractOn(optInt3);
                    }
                    com.baidu.tieba.ai.c().p(false);
                }
                if (optInt == 1) {
                    com.baidu.tieba.ai.c().d(true);
                } else if (optInt == 0) {
                    com.baidu.tieba.ai.c().d(false);
                }
                com.baidu.tieba.ai.c().f(this.n);
                com.baidu.tieba.ai.c().g(this.o);
                com.baidu.tieba.ai.c().h(this.p);
                this.m = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject = jSONObject.optJSONObject("keepalive");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("wifi");
                    if (optJSONObject2 != null) {
                        TbadkApplication.m252getInst().setKeepaliveWifi(optJSONObject2.optInt("switch"));
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("nonwifi");
                    if (optJSONObject3 != null) {
                        TbadkApplication.m252getInst().setKeepaliveNonWifi(optJSONObject3.optInt("switch"));
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
                    com.baidu.tieba.ai.c().j(str);
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
                    com.baidu.tieba.ai.c().k(str2);
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
                    com.baidu.tieba.ai.c().l(str3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject4 != null) {
                    com.baidu.tieba.ai.c().a(new int[]{optJSONObject4.optInt("2gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("3gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("wifiTo", 0) * LocationClientOption.MIN_SCAN_SPAN});
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2010017));
                TbadkApplication.m252getInst().setIsUseBaiduStatOn(optInt2 == 1);
                d.a(this.c);
                TbConfig.setBigPhotoAdress(this.f);
                TbConfig.setSmallPhotoAdress(this.g);
                d.a(this.h, this.i);
                d.b(this.e);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
