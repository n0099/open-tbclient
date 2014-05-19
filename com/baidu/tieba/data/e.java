package com.baidu.tieba.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.switchs.features.LogSwitchStatic;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String p;
    private HashMap<String, Integer> q;
    private final boolean h = true;
    private boolean i = true;
    private int k = 100000;
    private boolean l = true;
    private int m = TbConfig.POST_IMAGE_SMALL;
    private int n = 10;
    private int o = 10;
    private boolean s = false;
    private int a = 0;
    private int b = 0;
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private final BannerData j = new BannerData();
    private com.baidu.tbadk.core.data.e r = new com.baidu.tbadk.core.data.e();

    public e() {
        this.q = null;
        this.q = new HashMap<>();
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
                this.m = jSONObject.optInt("kuainan_vote_cd", TbConfig.POST_IMAGE_SMALL);
                this.n = jSONObject.optInt("kuainan_vote_max", 10);
                this.o = jSONObject.optInt("kuainan_vote_rate", 10);
                this.p = jSONObject.optString("as_downloadurl");
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
                            if ("netlib_type".equals(optString)) {
                                TbadkApplication.m252getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            }
                            this.q.put(optString, valueOf);
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
                    UtilHelper.stopPushService(com.baidu.tieba.ad.c().d().getApplicationContext());
                }
                TbadkApplication.m252getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.i = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkApplication.m252getInst().setGpuOpen(this.i);
                this.s = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.a(this.s);
                if (com.baidu.tieba.ad.c().E()) {
                    int optInt3 = jSONObject.optInt("open_abstract", 0);
                    if (!(optInt3 == 0 || TbadkApplication.m252getInst().getIsAbstractStatus() != 0)) {
                        TbadkApplication.m252getInst().setIsAbstractOn(optInt3);
                    }
                    com.baidu.tieba.ad.c().p(false);
                }
                if (optInt == 1) {
                    com.baidu.tieba.ad.c().d(true);
                } else if (optInt == 0) {
                    com.baidu.tieba.ad.c().d(false);
                }
                com.baidu.tieba.ad.c().f(this.m);
                com.baidu.tieba.ad.c().g(this.n);
                com.baidu.tieba.ad.c().h(this.o);
                this.k = jSONObject.optInt("perform_sample_param", 100000);
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
                    com.baidu.tieba.ad.c().j(str);
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
                    com.baidu.tieba.ad.c().k(str2);
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
                    com.baidu.tieba.ad.c().l(str3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject4 != null) {
                    com.baidu.tieba.ad.c().a(new int[]{optJSONObject4.optInt("2gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("3gTo", 0) * LocationClientOption.MIN_SCAN_SPAN, optJSONObject4.optInt("wifiTo", 0) * LocationClientOption.MIN_SCAN_SPAN});
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2010017));
                TbadkApplication.m252getInst().setIsUseBaiduStatOn(optInt2 == 1);
                d.a(this.a);
                TbConfig.setBigPhotoAdress(this.d);
                TbConfig.setSmallPhotoAdress(this.e);
                d.a(this.f, this.g);
                d.b(this.c);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
