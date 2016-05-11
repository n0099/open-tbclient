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
public class f {
    private long afL;
    private HashMap<String, Integer> kb;
    private boolean mGpuOpen = true;
    private boolean afJ = true;
    private int afK = 100000;
    private int afM = 100;
    private boolean afO = false;
    private int afQ = 1;
    private int afD = 0;
    private int afE = 0;
    private int afF = 1;
    private String afG = null;
    private String afH = null;
    private String mYijianfankuiFname = null;
    private String afI = null;
    private final BannerData afC = new BannerData();
    private com.baidu.tbadk.core.data.j afN = new com.baidu.tbadk.core.data.j();
    private n afP = new n();

    public f() {
        this.kb = null;
        this.kb = new HashMap<>();
    }

    public int wu() {
        return this.afK;
    }

    public int getCrashLimitCount() {
        return this.afM;
    }

    public n wv() {
        return this.afP;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.afC.parserJson(jSONObject.optJSONObject("banner"));
                this.afD = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.afE = jSONObject.optInt("pb_big_image_width", 0);
                this.afG = jSONObject.optString("big_head_image_host");
                this.afH = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.afI = jSONObject.optString("yijianfankui_fid");
                this.afF = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.afM = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.afL = jSONObject.optLong("vip_new_task", 0L);
                this.afP.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.AK().dZ(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.AK().ea(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.AK().bt(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m11getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.afN == null) {
                    this.afN = new com.baidu.tbadk.core.data.j();
                }
                this.afN.parseJson(jSONObject.optString("photo_strategy"));
                if (r.getInstance() != null) {
                    r.getInstance().setmCdnLogData(this.afN);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().YG) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.pA(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.pB(optJSONObject2.optInt("block_size"));
                }
                aa.EM().Q(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.m11getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.kb.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new UninstallInquirerBySyncMessage(Boolean.valueOf(valueOf.intValue() != 1)));
                            }
                            if (TextUtils.equals("forum_mask_stat", optString)) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.xF().bb(valueOf.intValue() == 0);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m11getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.c.e.cS().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m11getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.kb != null && this.kb.size() > 0) {
                    com.baidu.adp.lib.c.e.cS().c(this.kb);
                }
                this.afJ = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m11getInst().setIsPushServiceOpen(this.afJ);
                if (!this.afJ) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m11getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m11getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m11getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m11getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.m11getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.afO = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.afO);
                if (TbadkCoreApplication.m11getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.m11getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.m11getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.m11getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.m11getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.m11getInst().setIsAppOn(false);
                }
                this.afK = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m11getInst().setKeepaliveWifi(optJSONObject4.optInt("switch"));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.m11getInst().setKeepaliveNonWifi(optJSONObject5.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m11getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
                TbadkCoreApplication.m11getInst().setSocketReconnStratgy(c(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m11getInst().setSocketHeartBeatStratgy(c(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m11getInst().setSocketGetMsgStratgy(c(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.m11getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.e Ay = com.baidu.tbadk.data.e.Ay();
                if (optJSONObject7 != null) {
                    Ay.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.afQ = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.sQ().putInt("sync_local_dialog", this.afQ);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.afD);
                TbConfig.setBigPhotoAdress(this.afG);
                TbConfig.setSmallPhotoAdress(this.afH);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.afI);
                TbConfig.setImgChunkUploadEnable(this.afF);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String c(JSONArray jSONArray) {
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

    public long ww() {
        return this.afL;
    }
}
