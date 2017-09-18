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
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private long arG;
    private HashMap<String, Integer> mSwitchs;
    private boolean mGpuOpen = true;
    private boolean arE = true;
    private int arF = 100000;
    private int arH = 100;
    private boolean arJ = false;
    private int arL = 1;
    private int ary = 0;
    private int arz = 0;
    private int arA = 1;
    private String arB = null;
    private String arC = null;
    private String mYijianfankuiFname = null;
    private String arD = null;
    private final BannerData arx = new BannerData();
    private com.baidu.tbadk.core.data.l arI = new com.baidu.tbadk.core.data.l();
    private p arK = new p();

    public j() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public int yp() {
        return this.arF;
    }

    public int getCrashLimitCount() {
        return this.arH;
    }

    public p yq() {
        return this.arK;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.arx.parserJson(jSONObject.optJSONObject("banner"));
                this.ary = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.arz = jSONObject.optInt("pb_big_image_width", 0);
                this.arB = jSONObject.optString("big_head_image_host");
                this.arC = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.arD = jSONObject.optString("yijianfankui_fid");
                this.arA = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.arH = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.arG = jSONObject.optLong("vip_new_task", 0L);
                this.arK.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.CF().ev(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.CF().ew(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.CF().bz(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.arI == null) {
                    this.arI = new com.baidu.tbadk.core.data.l();
                }
                this.arI.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.p.getInstance() != null) {
                    com.baidu.tbadk.core.util.p.getInstance().setmCdnLogData(this.arI);
                }
                com.baidu.tbadk.f.a aVar = new com.baidu.tbadk.f.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().aip) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.tG(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.tH(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.tF(optJSONObject2.optInt("data_size"));
                }
                com.baidu.tbadk.l.r.Gx().R(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
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
                                TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.d.eW().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            } else if ("auto_play_video_homepage".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("auto_play_video_homepage", valueOf.intValue());
                            } else if ("auto_play_video_frs".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("auto_play_video_frs", valueOf.intValue());
                            } else if ("android_safe_sdk_open".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("android_safe_sdk_open", valueOf.intValue());
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.mSwitchs != null && this.mSwitchs.size() > 0) {
                    com.baidu.adp.lib.b.d.eW().c(this.mSwitchs);
                }
                com.baidu.tieba.play.r.bfY();
                CustomPlayerSwitchStatic.rL(com.baidu.adp.lib.b.d.eW().af("android_custom_player_enabled_2"));
                this.arE = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.arE);
                if (!this.arE) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.arJ = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.arJ);
                if (TbadkCoreApplication.getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.getInst().setIsAppOn(false);
                }
                this.arF = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.getInst().setKeepaliveWifi(optJSONObject4.optInt("switch"));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                    if (optJSONObject5 != null) {
                        TbadkCoreApplication.getInst().setKeepaliveNonWifi(optJSONObject5.optInt("switch"));
                    }
                }
                TbadkCoreApplication.getInst().setHybridBridgeTimeout(jSONObject.optInt("hybrid_bridge_timeout", -1));
                TbadkCoreApplication.getInst().setSocketReconnStratgy(b(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(b(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(b(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.g Cp = com.baidu.tbadk.data.g.Cp();
                if (optJSONObject7 != null) {
                    Cp.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.arL = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("sync_local_dialog", this.arL);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.ary);
                TbConfig.setBigPhotoAdress(this.arB);
                TbConfig.setSmallPhotoAdress(this.arC);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.arD);
                TbConfig.setImgChunkUploadEnable(this.arA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String b(JSONArray jSONArray) throws Exception {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(jSONArray.get(i));
            if (i < length - 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return sb.toString();
    }

    public long yr() {
        return this.arG;
    }
}
