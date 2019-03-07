package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private long bWY;
    private HashMap<String, Integer> mSwitchs;
    private boolean mGpuOpen = true;
    private boolean bWW = true;
    private int bWX = 100000;
    private int bWZ = 100;
    private boolean bXb = false;
    private int bXd = 1;
    private String bWT = null;
    private String bWU = null;
    private String mYijianfankuiFname = null;
    private String bWV = null;
    private final BannerData bWS = new BannerData();
    private com.baidu.tbadk.core.data.m bXa = new com.baidu.tbadk.core.data.m();
    private w bXc = new w();

    public n() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public int agq() {
        return this.bWX;
    }

    public int getCrashLimitCount() {
        return this.bWZ;
    }

    public w agr() {
        return this.bXc;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.bWS.parserJson(jSONObject.optJSONObject("banner"));
                this.bWT = jSONObject.optString("big_head_image_host");
                this.bWU = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.bWV = jSONObject.optString("yijianfankui_fid");
                this.bWZ = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.bWY = jSONObject.optLong("vip_new_task", 0L);
                this.bXc.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.alG().jo(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.alG().jp(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.alG().eD(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.bXa == null) {
                    this.bXa = new com.baidu.tbadk.core.data.m();
                }
                this.bXa.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.p.getInstance() != null) {
                    com.baidu.tbadk.core.util.p.getInstance().setmCdnLogData(this.bXa);
                }
                com.baidu.tbadk.i.a aVar = new com.baidu.tbadk.i.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().bLU) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.zF(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.zG(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.zE(optJSONObject2.optInt("data_size"));
                }
                com.baidu.tbadk.o.m.apl().aU(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.mSwitchs.put(optString, valueOf);
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.d.iQ().i(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            } else if ("auto_play_video_homepage".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("auto_play_video_homepage", valueOf.intValue());
                            } else if ("auto_play_video_frs".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("auto_play_video_frs", valueOf.intValue());
                            } else if ("android_safe_sdk_open".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("android_safe_sdk_open", valueOf.intValue());
                            } else if ("android_new_log_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                            } else if ("android_splash_video_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_splash_switch", valueOf.intValue());
                            } else if ("android_abtest_channel_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", valueOf.intValue());
                            } else if ("android_crab_enable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pref_key_crab_sdk_enable", valueOf.intValue());
                            } else if ("android_bigday_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_bigday_sync_switch", valueOf.intValue());
                            } else if ("android_video_player_reuseable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_player_reuse_switch", valueOf.intValue());
                            } else if ("android_mtj_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pref_key_stat_sdk_enable", valueOf.intValue());
                            } else if ("android_jpush_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("pref_key_jpush_sdk_enable", valueOf.intValue());
                            } else if ("lcslog_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lcs_log_switch", valueOf.intValue());
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
                    com.baidu.adp.lib.b.d.iQ().j(this.mSwitchs);
                }
                com.baidu.tieba.play.t.bTJ();
                CustomPlayerSwitchStatic.xk(com.baidu.adp.lib.b.d.iQ().aO("android_custom_player_enabled_2"));
                this.bWW = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.bWW);
                if (!this.bWW) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.bXb = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.bXb);
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
                this.bWX = jSONObject.optInt("perform_sample_param", 100000);
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
                TbadkCoreApplication.getInst().setSocketReconnStratgy(A(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(A(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(A(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.e alp = com.baidu.tbadk.data.e.alp();
                if (optJSONObject7 != null) {
                    alp.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.bXd = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("sync_local_dialog", this.bXd);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt3 = optJSONObject9.optInt("android_flops_dur", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    int optInt4 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt3);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt4);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setBigPhotoAdress(this.bWT);
                TbConfig.setSmallPhotoAdress(this.bWU);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.bWV);
                com.baidu.tbadk.core.util.e.e.adZ().nh(jSONObject.optString("android_preload_conf"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String A(JSONArray jSONArray) throws Exception {
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

    public long ags() {
        return this.bWY;
    }
}
