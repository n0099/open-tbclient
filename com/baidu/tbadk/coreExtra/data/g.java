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
    private long agp;
    private HashMap<String, Integer> jY;
    private boolean mGpuOpen = true;
    private boolean agn = true;
    private int ago = 100000;
    private int agq = 100;
    private boolean ags = false;
    private int agu = 1;
    private int agh = 0;
    private int agi = 0;
    private int agj = 1;
    private String agk = null;
    private String agl = null;
    private String mYijianfankuiFname = null;
    private String agm = null;
    private final BannerData agg = new BannerData();
    private com.baidu.tbadk.core.data.j agr = new com.baidu.tbadk.core.data.j();
    private o agt = new o();

    public g() {
        this.jY = null;
        this.jY = new HashMap<>();
    }

    public int wy() {
        return this.ago;
    }

    public int getCrashLimitCount() {
        return this.agq;
    }

    public o wz() {
        return this.agt;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.agg.parserJson(jSONObject.optJSONObject("banner"));
                this.agh = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.agi = jSONObject.optInt("pb_big_image_width", 0);
                this.agk = jSONObject.optString("big_head_image_host");
                this.agl = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.agm = jSONObject.optString("yijianfankui_fid");
                this.agj = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.agq = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.agp = jSONObject.optLong("vip_new_task", 0L);
                this.agt.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.AU().ec(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.AU().ed(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.AU().bq(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m9getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.agr == null) {
                    this.agr = new com.baidu.tbadk.core.data.j();
                }
                this.agr.parseJson(jSONObject.optString("photo_strategy"));
                if (r.getInstance() != null) {
                    r.getInstance().setmCdnLogData(this.agr);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().YX) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.qP(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.qQ(optJSONObject2.optInt("block_size"));
                }
                aa.EW().T(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.m9getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.jY.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new UninstallInquirerBySyncMessage(Boolean.valueOf(valueOf.intValue() != 1)));
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m9getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.c.e.cT().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m9getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.jY != null && this.jY.size() > 0) {
                    com.baidu.adp.lib.c.e.cT().c(this.jY);
                }
                this.agn = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m9getInst().setIsPushServiceOpen(this.agn);
                if (!this.agn) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m9getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m9getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m9getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.m9getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.ags = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.ags);
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
                this.ago = jSONObject.optInt("perform_sample_param", 100000);
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
                com.baidu.tbadk.data.f AI = com.baidu.tbadk.data.f.AI();
                if (optJSONObject7 != null) {
                    AI.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.agu = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.sO().putInt("sync_local_dialog", this.agu);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.agh);
                TbConfig.setBigPhotoAdress(this.agk);
                TbConfig.setSmallPhotoAdress(this.agl);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.agm);
                TbConfig.setImgChunkUploadEnable(this.agj);
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

    public long wA() {
        return this.agp;
    }
}
