package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
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
import com.baidu.tbadk.switchs.PicReqSwitch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private long ftl;
    private String fts;
    private HashMap<String, Integer> mSwitchs;
    private boolean mGpuOpen = true;
    private boolean ftj = true;
    private int ftk = 100000;
    private int ftm = 100;
    private boolean fto = false;
    private int ftr = 1;
    private String ftg = null;
    private String fth = null;
    private String mYijianfankuiFname = null;
    private String fti = null;
    private final BannerData ftf = new BannerData();
    private com.baidu.tbadk.core.data.q ftn = new com.baidu.tbadk.core.data.q();
    private ag ftq = new ag();

    public s() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public int bzT() {
        return this.ftk;
    }

    public int getCrashLimitCount() {
        return this.ftm;
    }

    public ag bzU() {
        return this.ftq;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.ftf.parserJson(jSONObject.optJSONObject("banner"));
                this.ftg = jSONObject.optString("big_head_image_host");
                this.fth = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.fti = jSONObject.optString("yijianfankui_fid");
                this.ftm = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.ftl = jSONObject.optLong("vip_new_task", 0L);
                this.ftq.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.bEv().so(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.bEv().sp(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.bEv().kK(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.ftn == null) {
                    this.ftn = new com.baidu.tbadk.core.data.q();
                }
                this.ftn.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.r.getInstance() != null) {
                    com.baidu.tbadk.core.util.r.getInstance().setmCdnLogData(this.ftn);
                }
                com.baidu.tbadk.i.a aVar = new com.baidu.tbadk.i.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.b.e.getInstance().fek) {
                        com.baidu.tbadk.core.util.b.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.b.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.b.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.Lg(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.Lh(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.Lf(optJSONObject2.optInt("data_size"));
                }
                com.baidu.tbadk.n.k.bHF().setSmallFlowInterval(jSONObject.optLong("small_flow_time_out"));
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
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE, valueOf.intValue());
                            } else if (SharedPrefConfig.AUTO_PLAY_VIDEO_FRS.equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, valueOf.intValue());
                            } else if (SharedPrefConfig.ANDROID_SAFE_SDK_OPEN.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, valueOf.intValue());
                            } else if ("android_new_log_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.KEY_LOG_REAL_TIME_UPLOAD_SWITCH, valueOf.intValue());
                            } else if ("android_splash_video_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, valueOf.intValue());
                            } else if ("android_abtest_channel_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, valueOf.intValue());
                            } else if (CrabSdkSwitch.CRAB_SDK_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("pref_key_crab_sdk_enable", valueOf.intValue());
                            } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_bigday_sync_switch", valueOf.intValue());
                            } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("pref_key_stat_sdk_enable", valueOf.intValue());
                            } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("pref_key_jpush_sdk_enable", valueOf.intValue());
                            } else if ("lcslog_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_lcs_log_switch", valueOf.intValue());
                            } else if ("android_slide_anim_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("sync_slide_animation__switch", valueOf.intValue());
                            } else if ("auto_play_video_homepage_have_4g".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("auto_play_video_homepage_have_4g", valueOf.intValue());
                            } else if ("auto_play_video_frs_have_4g".equals(optString)) {
                                if (valueOf.intValue() <= 0) {
                                    valueOf = 0;
                                }
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("auto_play_video_frs_have_4g", valueOf.intValue());
                            } else if ("image_header_no_cache_enable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("image_no_cache_switch", valueOf.intValue());
                            } else if ("profile_usercenter_open".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_create_center_entrance_switch", valueOf.intValue());
                            } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                            } else if (PicReqSwitch.PIC_REQ_SWITCH_KEY.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_pic_req_switch", valueOf.intValue());
                            }
                        }
                    }
                }
                if (this.mSwitchs != null && this.mSwitchs.size() > 0) {
                    SwitchManager.getInstance().refreshSwitchManager(this.mSwitchs);
                }
                int optInt2 = jSONObject.optInt("force_update_auto_play_video", -1);
                int i2 = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("force_update_auto_play_video", 0);
                if (i2 != 0 && optInt2 >= 1 && optInt2 <= 10 && optInt2 != i2) {
                    TbConfig.FORCE_UPDATE = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("force_update_auto_play_video", optInt2);
                CustomPlayerSwitch.setSwitchStatus(SwitchManager.getInstance().findType(CustomPlayerSwitch.CUSTOM_PLAYER_SWITCH));
                this.ftj = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.ftj);
                if (!this.ftj) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt(SharedPrefConfig.FEATURE_CRASH_AUTO_CLOSE_LIMIT, 3));
                this.mGpuOpen = jSONObject.optInt(SharedPrefConfig.GPU_OPEN, 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.fto = jSONObject.optInt(SharedPrefConfig.VOICE_SOFT_DECODER, 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.fto);
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
                this.ftk = jSONObject.optInt("perform_sample_param", 100000);
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
                TbadkCoreApplication.getInst().setSocketReconnStratgy(V(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(V(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(V(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.f bDZ = com.baidu.tbadk.data.f.bDZ();
                if (optJSONObject7 != null) {
                    bDZ.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.ftr = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.SYNC_LOCAL_DOALOG, this.ftr);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt4 = optJSONObject9.optInt("android_flops_dur", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    int optInt5 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt4);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt5);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setBigPhotoAdress(this.ftg);
                TbConfig.setSmallPhotoAdress(this.fth);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.fti);
                com.baidu.tbadk.core.util.g.d.bxf().Cs(jSONObject.optString("android_preload_conf"));
                JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
                if (optJSONObject10 != null) {
                    this.fts = optJSONObject10.optString("cash_pay");
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("baidu_finance", optJSONObject10.optString("finance"));
                }
                if (TextUtils.isEmpty(this.fts) && TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.bvq().getString("cash_pay", null))) {
                    this.fts = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
                }
                if (!StringUtils.isNull(this.fts)) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("cash_pay", this.fts);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String V(JSONArray jSONArray) throws Exception {
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

    public long bzV() {
        return this.ftl;
    }
}
