package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private long cui;
    private String cuo;
    private HashMap<String, Integer> nU;
    private boolean mGpuOpen = true;
    private boolean cug = true;
    private int cuh = 100000;
    private int cuj = 100;
    private boolean cul = false;
    private int cun = 1;
    private String cud = null;
    private String cue = null;
    private String mYijianfankuiFname = null;
    private String cuf = null;
    private final BannerData cuc = new BannerData();
    private com.baidu.tbadk.core.data.m cuk = new com.baidu.tbadk.core.data.m();
    private x cum = new x();

    public n() {
        this.nU = null;
        this.nU = new HashMap<>();
    }

    public int apg() {
        return this.cuh;
    }

    public int getCrashLimitCount() {
        return this.cuj;
    }

    public x aph() {
        return this.cum;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.cuc.parserJson(jSONObject.optJSONObject("banner"));
                this.cud = jSONObject.optString("big_head_image_host");
                this.cue = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.cuf = jSONObject.optString("yijianfankui_fid");
                this.cuj = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.cui = jSONObject.optLong("vip_new_task", 0L);
                this.cum.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.atL().jD(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.atL().jE(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.atL().fa(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.cuk == null) {
                    this.cuk = new com.baidu.tbadk.core.data.m();
                }
                this.cuk.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.p.getInstance() != null) {
                    com.baidu.tbadk.core.util.p.getInstance().setmCdnLogData(this.cuk);
                }
                com.baidu.tbadk.i.a aVar = new com.baidu.tbadk.i.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().cjP) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.Ad(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.Ae(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.Ac(optJSONObject2.optInt("data_size"));
                }
                com.baidu.tbadk.p.m.awL().bb(jSONObject.optLong("small_flow_time_out"));
                TbadkCoreApplication.getInst().setInterviewLivePollingInterval(jSONObject.optLong("interview_pulling_interval"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.nU.put(optString, valueOf);
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.d.ft().c(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            } else if (SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.AUTO_PLAY_VIDEO_HOMEPAGE, valueOf.intValue());
                            } else if (SharedPrefConfig.AUTO_PLAY_VIDEO_FRS.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, valueOf.intValue());
                            } else if (SharedPrefConfig.ANDROID_SAFE_SDK_OPEN.equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, valueOf.intValue());
                            } else if ("android_new_log_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_LOG_REAL_TIME_UPLOAD_SWITCH, valueOf.intValue());
                            } else if ("android_splash_video_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_VIDEO_SPLASH_SWITCH, valueOf.intValue());
                            } else if ("android_abtest_channel_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, valueOf.intValue());
                            } else if ("android_crab_enable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("pref_key_crab_sdk_enable", valueOf.intValue());
                            } else if ("android_bigday_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_bigday_sync_switch", valueOf.intValue());
                            } else if ("android_video_player_reuseable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_video_player_reuse_switch", valueOf.intValue());
                            } else if ("android_mtj_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("pref_key_stat_sdk_enable", valueOf.intValue());
                            } else if ("android_jpush_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("pref_key_jpush_sdk_enable", valueOf.intValue());
                            } else if ("lcslog_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_lcs_log_switch", valueOf.intValue());
                            } else if ("android_slide_anim_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("sync_slide_animation__switch", valueOf.intValue());
                            } else if ("android_mission_system_entrance_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_mission_entrance", valueOf.intValue());
                            }
                        }
                    }
                }
                if (this.nU != null && this.nU.size() > 0) {
                    com.baidu.adp.lib.b.d.ft().i(this.nU);
                }
                com.baidu.tieba.play.t.ccI();
                com.baidu.tbadk.t.s.ki(com.baidu.adp.lib.b.d.ft().af("android_custom_player_enabled_2"));
                this.cug = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.cug);
                if (!this.cug) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt(SharedPrefConfig.FEATURE_CRASH_AUTO_CLOSE_LIMIT, 3));
                this.mGpuOpen = jSONObject.optInt(SharedPrefConfig.GPU_OPEN, 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.cul = jSONObject.optInt(SharedPrefConfig.VOICE_SOFT_DECODER, 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.cul);
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
                this.cuh = jSONObject.optInt("perform_sample_param", 100000);
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
                TbadkCoreApplication.getInst().setSocketReconnStratgy(J(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(J(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(J(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.e att = com.baidu.tbadk.data.e.att();
                if (optJSONObject7 != null) {
                    att.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.cun = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.SYNC_LOCAL_DOALOG, this.cun);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt3 = optJSONObject9.optInt("android_flops_dur", Integer.MAX_VALUE);
                    int optInt4 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt3);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt4);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setBigPhotoAdress(this.cud);
                TbConfig.setSmallPhotoAdress(this.cue);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.cuf);
                com.baidu.tbadk.core.util.g.e.ann().oq(jSONObject.optString("android_preload_conf"));
                JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
                if (optJSONObject10 != null) {
                    this.cuo = optJSONObject10.optString("cash_pay");
                }
                if (TextUtils.isEmpty(this.cuo) && TextUtils.isEmpty(com.baidu.tbadk.core.sharedPref.b.alP().getString("cash_pay", null))) {
                    this.cuo = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
                }
                if (!StringUtils.isNull(this.cuo)) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("cash_pay", this.cuo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String J(JSONArray jSONArray) throws Exception {
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

    public long apj() {
        return this.cui;
    }
}
