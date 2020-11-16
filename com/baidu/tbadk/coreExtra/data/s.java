package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.CrabSdkSwitch;
import com.baidu.tbadk.switchs.CustomPlayerSwitch;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.switchs.JPushSdkSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private long fcc;
    private String fci;
    private HashMap<String, Integer> mSwitchs;
    private boolean mGpuOpen = true;
    private boolean fca = true;
    private int fcb = 100000;
    private int fcd = 100;
    private boolean fcf = false;
    private int fch = 1;
    private String fbX = null;
    private String fbY = null;
    private String mYijianfankuiFname = null;
    private String fbZ = null;
    private final BannerData fbW = new BannerData();
    private com.baidu.tbadk.core.data.q fce = new com.baidu.tbadk.core.data.q();
    private ag fcg = new ag();

    public s() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public int btZ() {
        return this.fcb;
    }

    public int getCrashLimitCount() {
        return this.fcd;
    }

    public ag bua() {
        return this.fcg;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.fbW.parserJson(jSONObject.optJSONObject("banner"));
                this.fbX = jSONObject.optString("big_head_image_host");
                this.fbY = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.fbZ = jSONObject.optString("yijianfankui_fid");
                this.fcd = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.fcc = jSONObject.optLong("vip_new_task", 0L);
                this.fcg.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.byA().rB(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.byA().rC(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.byA().jY(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.fce == null) {
                    this.fce = new com.baidu.tbadk.core.data.q();
                }
                this.fce.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.r.getInstance() != null) {
                    com.baidu.tbadk.core.util.r.getInstance().setmCdnLogData(this.fce);
                }
                com.baidu.tbadk.i.a aVar = new com.baidu.tbadk.i.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().eNv) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.Ku(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.Kv(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.Kt(optJSONObject2.optInt("data_size"));
                }
                com.baidu.tbadk.n.m.bBK().setSmallFlowInterval(jSONObject.optLong("small_flow_time_out"));
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
                            } else if (LoginPassV6Switch.KEY.equals(optString)) {
                                SwitchManager.getInstance().turn(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            } else if (SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE.equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE, valueOf.intValue());
                            } else if (SharedPrefConfig.AUTO_PLAY_VIDEO_FRS.equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, valueOf.intValue());
                            } else if (SharedPrefConfig.ANDROID_SAFE_SDK_OPEN.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, valueOf.intValue());
                            } else if ("android_new_log_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_LOG_REAL_TIME_UPLOAD_SWITCH, valueOf.intValue());
                            } else if ("android_splash_video_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, valueOf.intValue());
                            } else if ("android_abtest_channel_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, valueOf.intValue());
                            } else if (CrabSdkSwitch.CRAB_SDK_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("pref_key_crab_sdk_enable", valueOf.intValue());
                            } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_bigday_sync_switch", valueOf.intValue());
                            } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("pref_key_stat_sdk_enable", valueOf.intValue());
                            } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("pref_key_jpush_sdk_enable", valueOf.intValue());
                            } else if ("lcslog_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_lcs_log_switch", valueOf.intValue());
                            } else if ("android_slide_anim_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("sync_slide_animation__switch", valueOf.intValue());
                            } else if ("auto_play_video_homepage_have_4g".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("auto_play_video_homepage_have_4g", valueOf.intValue());
                            } else if ("auto_play_video_frs_have_4g".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("auto_play_video_frs_have_4g", valueOf.intValue());
                            } else if ("image_header_no_cache_enable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("image_no_cache_switch", valueOf.intValue());
                            } else if ("profile_usercenter_open".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_create_center_entrance_switch", valueOf.intValue());
                            } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                            }
                        }
                    }
                }
                if (this.mSwitchs != null && this.mSwitchs.size() > 0) {
                    SwitchManager.getInstance().refreshSwitchManager(this.mSwitchs);
                }
                int optInt2 = jSONObject.optInt("force_update_auto_play_video", -1);
                int i2 = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("force_update_auto_play_video", 0);
                if (i2 != 0 && optInt2 >= 1 && optInt2 <= 10 && optInt2 != i2) {
                    TbConfig.FORCE_UPDATE = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("force_update_auto_play_video", optInt2);
                CustomPlayerSwitch.setSwitchStatus(SwitchManager.getInstance().findType(CustomPlayerSwitch.CUSTOM_PLAYER_SWITCH));
                this.fca = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.fca);
                if (!this.fca) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt(SharedPrefConfig.FEATURE_CRASH_AUTO_CLOSE_LIMIT, 3));
                this.mGpuOpen = jSONObject.optInt(SharedPrefConfig.GPU_OPEN, 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.fcf = jSONObject.optInt(SharedPrefConfig.VOICE_SOFT_DECODER, 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.fcf);
                if (TbadkCoreApplication.getInst().getFirstSyncImageQuality()) {
                    int optInt3 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt3 == 0 || TbadkCoreApplication.getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.getInst().setIsAbstractOn(optInt3);
                    }
                    TbadkCoreApplication.getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.getInst().setIsAppOn(false);
                }
                this.fcb = jSONObject.optInt("perform_sample_param", 100000);
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
                TbadkCoreApplication.getInst().setSocketReconnStratgy(U(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(U(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(U(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.e bye = com.baidu.tbadk.data.e.bye();
                if (optJSONObject7 != null) {
                    bye.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.fch = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.SYNC_LOCAL_DOALOG, this.fch);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt4 = optJSONObject9.optInt("android_flops_dur", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    int optInt5 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt4);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt5);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setBigPhotoAdress(this.fbX);
                TbConfig.setSmallPhotoAdress(this.fbY);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.fbZ);
                com.baidu.tbadk.core.util.f.d.brn().BM(jSONObject.optString("android_preload_conf"));
                JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
                if (optJSONObject10 != null) {
                    this.fci = optJSONObject10.optString("cash_pay");
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("baidu_finance", optJSONObject10.optString("finance"));
                }
                if (TextUtils.isEmpty(this.fci) && TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bpu().getString("cash_pay", null))) {
                    this.fci = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
                }
                if (!StringUtils.isNull(this.fci)) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("cash_pay", this.fci);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String U(JSONArray jSONArray) throws Exception {
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

    public long bub() {
        return this.fcc;
    }
}
