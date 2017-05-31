package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.UninstallInquirerBySyncMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.j.aa;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.baidu.tieba.play.au;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private long aoS;
    private HashMap<String, Integer> mSwitchs;
    private boolean mGpuOpen = true;
    private boolean aoQ = true;
    private int aoR = 100000;
    private int aoT = 100;
    private boolean aoV = false;
    private int aoX = 1;
    private int aoK = 0;
    private int aoL = 0;
    private int aoM = 1;
    private String aoN = null;
    private String aoO = null;
    private String mYijianfankuiFname = null;
    private String aoP = null;
    private final BannerData aoJ = new BannerData();
    private com.baidu.tbadk.core.data.l aoU = new com.baidu.tbadk.core.data.l();
    private p aoW = new p();

    public j() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public int xC() {
        return this.aoR;
    }

    public int getCrashLimitCount() {
        return this.aoT;
    }

    public p xD() {
        return this.aoW;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.aoJ.parserJson(jSONObject.optJSONObject("banner"));
                this.aoK = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.aoL = jSONObject.optInt("pb_big_image_width", 0);
                this.aoN = jSONObject.optString("big_head_image_host");
                this.aoO = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.aoP = jSONObject.optString("yijianfankui_fid");
                this.aoM = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.aoT = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.aoS = jSONObject.optLong("vip_new_task", 0L);
                this.aoW.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.BW().ep(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.BW().eq(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.BW().bw(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m9getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.aoU == null) {
                    this.aoU = new com.baidu.tbadk.core.data.l();
                }
                this.aoU.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.r.getInstance() != null) {
                    com.baidu.tbadk.core.util.r.getInstance().setmCdnLogData(this.aoU);
                }
                com.baidu.tbadk.e.a aVar = new com.baidu.tbadk.e.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().agx) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.sw(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.sx(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.sv(optJSONObject2.optInt("data_size"));
                }
                aa.FE().Q(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.m9getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.mSwitchs.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new UninstallInquirerBySyncMessage(Boolean.valueOf(valueOf.intValue() != 1)));
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m9getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.e.eZ().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            } else if ("auto_play_video_homepage".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("auto_play_video_homepage", valueOf.intValue());
                            } else if ("auto_play_video_frs".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("auto_play_video_frs", valueOf.intValue());
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m9getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.mSwitchs != null && this.mSwitchs.size() > 0) {
                    com.baidu.adp.lib.b.e.eZ().c(this.mSwitchs);
                }
                au.aYa();
                CustomPlayerSwitchStatic.qR(com.baidu.adp.lib.b.e.eZ().Y("android_custom_player_enabled_2"));
                this.aoQ = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m9getInst().setIsPushServiceOpen(this.aoQ);
                if (!this.aoQ) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m9getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m9getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m9getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.m9getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.aoV = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.aoV);
                if (TbadkCoreApplication.m9getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.m9getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.m9getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.m9getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.m9getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.m9getInst().setIsAppOn(false);
                }
                this.aoR = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m9getInst().setKeepaliveWifi(optJSONObject4.optInt("switch"));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.m9getInst().setKeepaliveNonWifi(optJSONObject5.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m9getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
                TbadkCoreApplication.m9getInst().setSocketReconnStratgy(c(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m9getInst().setSocketHeartBeatStratgy(c(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m9getInst().setSocketGetMsgStratgy(c(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.m9getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.f BF = com.baidu.tbadk.data.f.BF();
                if (optJSONObject7 != null) {
                    BF.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.aoX = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("sync_local_dialog", this.aoX);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.aoK);
                TbConfig.setBigPhotoAdress(this.aoN);
                TbConfig.setSmallPhotoAdress(this.aoO);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.aoP);
                TbConfig.setImgChunkUploadEnable(this.aoM);
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

    public long xE() {
        return this.aoS;
    }
}
