package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.UninstallInquirer;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.performanceLog.ah;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, Integer> tD;
    private final boolean aaD = true;
    private boolean mGpuOpen = true;
    private boolean aaL = true;
    private int aaM = 100000;
    private int aaN = 6257;
    private int aaO = 100;
    private boolean aaQ = false;
    private int aaF = 0;
    private int aaG = 0;
    private int aaH = 1;
    private String aaI = null;
    private String aaJ = null;
    private String mYijianfankuiFname = null;
    private String aaK = null;
    private final BannerData aaE = new BannerData();
    private com.baidu.tbadk.core.data.h aaP = new com.baidu.tbadk.core.data.h();
    private k aaR = new k();

    public e() {
        this.tD = null;
        this.tD = new HashMap<>();
    }

    public int uA() {
        return this.aaM;
    }

    public int getCrashLimitCount() {
        return this.aaO;
    }

    public int uB() {
        return this.aaN;
    }

    public k uC() {
        return this.aaR;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.aaE.parserJson(jSONObject.optJSONObject("banner"));
                this.aaF = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.aaG = jSONObject.optInt("pb_big_image_width", 0);
                this.aaI = jSONObject.optString("big_head_image_host");
                this.aaJ = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.aaK = jSONObject.optString("yijianfankui_fid");
                this.aaH = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.aaN = jSONObject.optInt("aladin_port", 6257);
                this.aaO = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.aaR.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.yk().dj(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.yk().dk(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.yk().aM(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m411getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.aaP == null) {
                    this.aaP = new com.baidu.tbadk.core.data.h();
                }
                this.aaP.parseJson(jSONObject.optString("photo_strategy"));
                if (r.getInstance() != null) {
                    r.getInstance().setmCdnLogData(this.aaP);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().Wd) {
                        com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                ah.CQ().v(jSONObject.optLong("small_flow_time_out"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.tD.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                UninstallInquirer.getInstance().startProcessBySync(valueOf.intValue() != 1);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m411getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.f.gz().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.act.a.checkPassV6Switch();
                            }
                        }
                    }
                }
                if (this.tD != null && this.tD.size() > 0) {
                    com.baidu.adp.lib.b.f.gz().b(this.tD);
                }
                this.aaL = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setIsPushServiceOpen(this.aaL);
                TbadkCoreApplication.m411getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.aaL) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m411getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m411getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.aaQ = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.aaQ);
                if (TbadkCoreApplication.m411getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.m411getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.m411getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.m411getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.m411getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.m411getInst().setIsAppOn(false);
                }
                this.aaM = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("wifi");
                    if (optJSONObject3 != null) {
                        TbadkCoreApplication.m411getInst().setKeepaliveWifi(optJSONObject3.optInt("switch"));
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("nonwifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m411getInst().setKeepaliveNonWifi(optJSONObject4.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m411getInst().setSocketReconnStratgy(b(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m411getInst().setSocketHeartBeatStratgy(b(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m411getInst().setSocketGetMsgStratgy(b(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject5 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject5 != null) {
                    TbadkCoreApplication.m411getInst().setImTimeOut(new int[]{optJSONObject5.optInt("2gTo", 0) * 1000, optJSONObject5.optInt("3gTo", 0) * 1000, optJSONObject5.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.c xV = com.baidu.tbadk.data.c.xV();
                if (optJSONObject6 != null) {
                    xV.parserJson(optJSONObject6);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setPbListNum(this.aaF);
                TbConfig.setBigPhotoAdress(this.aaI);
                TbConfig.setSmallPhotoAdress(this.aaJ);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.aaK);
                TbConfig.setImgChunkUploadEnable(this.aaH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String b(JSONArray jSONArray) {
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
