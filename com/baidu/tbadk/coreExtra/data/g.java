package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.UninstallInquirerBySyncMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.performanceLog.aa;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private long ahd;
    private HashMap<String, Integer> kE;
    private boolean mGpuOpen = true;
    private boolean ahb = true;
    private int ahc = 100000;
    private int ahe = 100;
    private boolean ahg = false;
    private int ahi = 1;
    private int agV = 0;
    private int agW = 0;
    private int agX = 1;
    private String agY = null;
    private String agZ = null;
    private String mYijianfankuiFname = null;
    private String aha = null;
    private final BannerData agU = new BannerData();
    private com.baidu.tbadk.core.data.k ahf = new com.baidu.tbadk.core.data.k();
    private o ahh = new o();

    public g() {
        this.kE = null;
        this.kE = new HashMap<>();
    }

    public int wy() {
        return this.ahc;
    }

    public int getCrashLimitCount() {
        return this.ahe;
    }

    public o wz() {
        return this.ahh;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.agU.parserJson(jSONObject.optJSONObject("banner"));
                this.agV = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.agW = jSONObject.optInt("pb_big_image_width", 0);
                this.agY = jSONObject.optString("big_head_image_host");
                this.agZ = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.aha = jSONObject.optString("yijianfankui_fid");
                this.agX = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.ahe = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.ahd = jSONObject.optLong("vip_new_task", 0L);
                this.ahh.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.AU().ec(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.AU().ed(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.AU().bt(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m10getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.ahf == null) {
                    this.ahf = new com.baidu.tbadk.core.data.k();
                }
                this.ahf.parseJson(jSONObject.optString("photo_strategy"));
                if (r.getInstance() != null) {
                    r.getInstance().setmCdnLogData(this.ahf);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().ZG) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.rk(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.rl(optJSONObject2.optInt("block_size"));
                }
                aa.EV().O(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.m10getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.kE.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new UninstallInquirerBySyncMessage(Boolean.valueOf(valueOf.intValue() != 1)));
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m10getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.c.e.cS().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m10getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.kE != null && this.kE.size() > 0) {
                    com.baidu.adp.lib.c.e.cS().c(this.kE);
                }
                this.ahb = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m10getInst().setIsPushServiceOpen(this.ahb);
                if (!this.ahb) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m10getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m10getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m10getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m10getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.m10getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.ahg = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.ahg);
                if (TbadkCoreApplication.m10getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.m10getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.m10getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.m10getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.m10getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.m10getInst().setIsAppOn(false);
                }
                this.ahc = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m10getInst().setKeepaliveWifi(optJSONObject4.optInt("switch"));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.m10getInst().setKeepaliveNonWifi(optJSONObject5.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m10getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
                TbadkCoreApplication.m10getInst().setSocketReconnStratgy(c(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m10getInst().setSocketHeartBeatStratgy(c(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m10getInst().setSocketGetMsgStratgy(c(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.m10getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.f AI = com.baidu.tbadk.data.f.AI();
                if (optJSONObject7 != null) {
                    AI.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.ahi = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.sN().putInt("sync_local_dialog", this.ahi);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.agV);
                TbConfig.setBigPhotoAdress(this.agY);
                TbConfig.setSmallPhotoAdress(this.agZ);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.aha);
                TbConfig.setImgChunkUploadEnable(this.agX);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String c(JSONArray jSONArray) throws Exception {
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

    public long wA() {
        return this.ahd;
    }
}
