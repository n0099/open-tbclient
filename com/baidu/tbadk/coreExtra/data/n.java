package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
    private long ceY;
    private HashMap<String, Integer> mSwitchs;
    private boolean mGpuOpen = true;
    private boolean ceW = true;
    private int ceX = 100000;
    private int ceZ = 100;
    private boolean cfb = false;
    private int cfd = 1;
    private String ceT = null;
    private String ceU = null;
    private String mYijianfankuiFname = null;
    private String ceV = null;
    private final BannerData ceS = new BannerData();
    private com.baidu.tbadk.core.data.m cfa = new com.baidu.tbadk.core.data.m();
    private w cfc = new w();

    public n() {
        this.mSwitchs = null;
        this.mSwitchs = new HashMap<>();
    }

    public int alm() {
        return this.ceX;
    }

    public int getCrashLimitCount() {
        return this.ceZ;
    }

    public w aln() {
        return this.cfc;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.ceS.parserJson(jSONObject.optJSONObject("banner"));
                this.ceT = jSONObject.optString("big_head_image_host");
                this.ceU = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.ceV = jSONObject.optString("yijianfankui_fid");
                this.ceZ = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.ceY = jSONObject.optLong("vip_new_task", 0L);
                this.cfc.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.aqF().kb(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.aqF().kc(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.aqF().eZ(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.cfa == null) {
                    this.cfa = new com.baidu.tbadk.core.data.m();
                }
                this.cfa.parseJson(jSONObject.optString("photo_strategy"));
                if (com.baidu.tbadk.core.util.p.getInstance() != null) {
                    com.baidu.tbadk.core.util.p.getInstance().setmCdnLogData(this.cfa);
                }
                com.baidu.tbadk.i.a aVar = new com.baidu.tbadk.i.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().bTK) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
                if (optJSONObject2 != null) {
                    com.baidu.tieba.tbadkCore.videoupload.a.AJ(optJSONObject2.optInt("chunk_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.AK(optJSONObject2.optInt("block_size"));
                    com.baidu.tieba.tbadkCore.videoupload.a.AI(optJSONObject2.optInt("data_size"));
                }
                com.baidu.tbadk.p.m.auk().bj(jSONObject.optLong("small_flow_time_out"));
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
                                com.baidu.adp.lib.b.d.hI().c(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            } else if ("auto_play_video_homepage".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("auto_play_video_homepage", valueOf.intValue());
                            } else if ("auto_play_video_frs".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("auto_play_video_frs", valueOf.intValue());
                            } else if ("android_safe_sdk_open".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("android_safe_sdk_open", valueOf.intValue());
                            } else if ("android_new_log_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                            } else if ("android_splash_video_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_splash_switch", valueOf.intValue());
                            } else if ("android_abtest_channel_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_abtest_channel", valueOf.intValue());
                            } else if ("android_crab_enable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("pref_key_crab_sdk_enable", valueOf.intValue());
                            } else if ("android_bigday_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_bigday_sync_switch", valueOf.intValue());
                            } else if ("android_video_player_reuseable".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_player_reuse_switch", valueOf.intValue());
                            } else if ("android_mtj_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("pref_key_stat_sdk_enable", valueOf.intValue());
                            } else if ("android_jpush_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("pref_key_jpush_sdk_enable", valueOf.intValue());
                            } else if ("lcslog_upload_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_lcs_log_switch", valueOf.intValue());
                            } else if ("android_slide_anim_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("sync_slide_animation__switch", valueOf.intValue());
                            } else if ("android_mission_system_entrance_switch".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_mission_entrance", valueOf.intValue());
                            }
                        }
                    }
                }
                if (this.mSwitchs != null && this.mSwitchs.size() > 0) {
                    com.baidu.adp.lib.b.d.hI().i(this.mSwitchs);
                }
                com.baidu.tieba.play.t.cbN();
                com.baidu.tbadk.t.s.kO(com.baidu.adp.lib.b.d.hI().ay("android_custom_player_enabled_2"));
                this.ceW = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.getInst().setIsPushServiceOpen(this.ceW);
                if (!this.ceW) {
                    UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                TbadkCoreApplication.getInst().setHttpAutoSwitch(jSONObject.optInt("http_client_auto", 1) == 1);
                this.cfb = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.cfb);
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
                this.ceX = jSONObject.optInt("perform_sample_param", 100000);
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
                TbadkCoreApplication.getInst().setSocketReconnStratgy(B(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(B(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.getInst().setSocketGetMsgStratgy(B(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject6 != null) {
                    TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.e aqo = com.baidu.tbadk.data.e.aqo();
                if (optJSONObject7 != null) {
                    aqo.parserJson(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
                if (optJSONObject8 != null) {
                    this.cfd = optJSONObject8.optInt("local_dialog_android", 1);
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("sync_local_dialog", this.cfd);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
                if (optJSONObject9 != null) {
                    int optInt3 = optJSONObject9.optInt("android_flops_dur", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    int optInt4 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                    TbSingleton.getInstance().setCpuThreshold(optInt3);
                    TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt4);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setBigPhotoAdress(this.ceT);
                TbConfig.setSmallPhotoAdress(this.ceU);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.ceV);
                com.baidu.tbadk.core.util.e.e.aiV().or(jSONObject.optString("android_preload_conf"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String B(JSONArray jSONArray) throws Exception {
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

    public long alo() {
        return this.ceY;
    }
}
