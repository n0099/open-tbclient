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
    private long ajZ;
    private HashMap<String, Integer> ul;
    private boolean mGpuOpen = true;
    private boolean ajX = true;
    private int ajY = 100000;
    private int aka = 100;
    private boolean akc = false;
    private int ake = 1;
    private int ajR = 0;
    private int ajS = 0;
    private int ajT = 1;
    private String ajU = null;
    private String ajV = null;
    private String mYijianfankuiFname = null;
    private String ajW = null;
    private final BannerData ajQ = new BannerData();
    private com.baidu.tbadk.core.data.j akb = new com.baidu.tbadk.core.data.j();
    private m akd = new m();

    public f() {
        this.ul = null;
        this.ul = new HashMap<>();
    }

    public int yB() {
        return this.ajY;
    }

    public int getCrashLimitCount() {
        return this.aka;
    }

    public m yC() {
        return this.akd;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.ajQ.parserJson(jSONObject.optJSONObject("banner"));
                this.ajR = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.ajS = jSONObject.optInt("pb_big_image_width", 0);
                this.ajU = jSONObject.optString("big_head_image_host");
                this.ajV = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.ajW = jSONObject.optString("yijianfankui_fid");
                this.ajT = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.aka = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.ajZ = jSONObject.optLong("vip_new_task", 0L);
                this.akd.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.CR().et(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.CR().eu(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.CR().bn(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m411getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.akb == null) {
                    this.akb = new com.baidu.tbadk.core.data.j();
                }
                this.akb.parseJson(jSONObject.optString("photo_strategy"));
                if (r.getInstance() != null) {
                    r.getInstance().setmCdnLogData(this.akb);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().adi) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.pF(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.pG(optJSONObject2.optInt("block_size"));
                }
                aa.GU().P(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.m411getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.ul.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new UninstallInquirerBySyncMessage(Boolean.valueOf(valueOf.intValue() != 1)));
                            }
                            if (TextUtils.equals("forum_mask_stat", optString)) {
                                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aV(valueOf.intValue() == 0);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m411getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.c.e.gE().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m411getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.ul != null && this.ul.size() > 0) {
                    com.baidu.adp.lib.c.e.gE().c(this.ul);
                }
                this.ajX = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setIsPushServiceOpen(this.ajX);
                if (!this.ajX) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m411getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m411getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.m411getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.akc = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.akc);
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
                this.ajY = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m411getInst().setKeepaliveWifi(optJSONObject4.optInt("switch"));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.m411getInst().setKeepaliveNonWifi(optJSONObject5.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m411getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
                TbadkCoreApplication.m411getInst().setSocketReconnStratgy(c(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m411getInst().setSocketHeartBeatStratgy(c(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m411getInst().setSocketGetMsgStratgy(c(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.m411getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.d CE = com.baidu.tbadk.data.d.CE();
                if (optJSONObject7 != null) {
                    CE.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.ake = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.vk().putInt("sync_local_dialog", this.ake);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.ajR);
                TbConfig.setBigPhotoAdress(this.ajU);
                TbConfig.setSmallPhotoAdress(this.ajV);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.ajW);
                TbConfig.setImgChunkUploadEnable(this.ajT);
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

    public long yD() {
        return this.ajZ;
    }
}
