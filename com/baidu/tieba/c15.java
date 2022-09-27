package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoSwitchManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.BannerData;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.CsjPrivacySwitch;
import com.baidu.tbadk.switchs.FixNpsAnrSwitch;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.switchs.FunAdServerRecordSwitch;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tbadk.switchs.GdtPrivacySwitch;
import com.baidu.tbadk.switchs.HasUseGlideSwitch;
import com.baidu.tbadk.switchs.JPushSdkSwitch;
import com.baidu.tbadk.switchs.KsPrivacySwitch;
import com.baidu.tbadk.switchs.LaunchViewOptSwitch;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tbadk.switchs.NewWritePageSwitch;
import com.baidu.tbadk.switchs.NewWriteProtobufSwitch;
import com.baidu.tbadk.switchs.OpenStartSafeModeSwitch;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tbadk.switchs.ResetSplashAdConfigSwitch;
import com.baidu.tbadk.switchs.StatSdkSwitch;
import com.baidu.tbadk.switchs.ThreadCardImgClickToPBSwitch;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BannerData a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public int f;
    public long g;
    public int h;
    public HashMap<String, Integer> i;
    public rr4 j;
    public boolean k;
    public x15 l;
    public int m;
    public String n;

    public c15() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.e = true;
        this.f = 100000;
        this.h = 100;
        this.i = null;
        this.k = false;
        this.m = 1;
        this.b = null;
        this.c = null;
        this.a = new BannerData();
        this.i = new HashMap<>();
        this.j = new rr4();
        this.l = new x15();
    }

    public final String a(JSONArray jSONArray) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
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
        return (String) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : invokeV.intValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : invokeV.intValue;
    }

    public x15 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (x15) invokeV.objValue;
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a.parserJson(jSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER));
            this.b = jSONObject.optString("big_head_image_host");
            this.c = jSONObject.optString("small_head_image_host");
            this.h = jSONObject.optInt("crash_limit_count", 100);
            int i = -1;
            int optInt = jSONObject.optInt("app_recommend", -1);
            this.g = jSONObject.optLong("vip_new_task", 0L);
            this.l.b(jSONObject.optJSONObject("webview_checkurl"));
            JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
            if (optJSONObject != null) {
                x45.j().t(optJSONObject.optInt("distance", 60));
                x45.j().u(optJSONObject.optInt("items_num", 10));
                x45.j().v(1 == optJSONObject.optInt("ad_show", 1));
            }
            if (this.j == null) {
                this.j = new rr4();
            }
            this.j.a(jSONObject.optString("photo_strategy"));
            if (ICDNProblemUploader.getInstance() != null) {
                ICDNProblemUploader.getInstance().setmCdnLogData(this.j);
            }
            sp4 sp4Var = new sp4();
            sp4Var.a(jSONObject.optJSONObject("photo_cdn_time"));
            if (ICDNIPDirectConnect.getInstance() != null) {
                if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                    ICDNIPDirectConnect.getInstance().init();
                }
                ICDNIPDirectConnect.getInstance().setCDNImageTimeData(sp4Var);
                ICDNIPDirectConnect.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("movideo");
            if (optJSONObject2 != null) {
                oo8.c(optJSONObject2.optInt("chunk_size"));
                oo8.b(optJSONObject2.optInt("block_size"));
                oo8.d(optJSONObject2.optInt("data_size"));
            }
            PerformanceLoggerHelper.getInstance().setSmallFlowInterval(jSONObject.optLong("small_flow_time_out"));
            JSONArray optJSONArray = jSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH);
            if (optJSONArray != null) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("name");
                        Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", i));
                        this.i.put(optString, valueOf);
                        if ("netlib_type".equals(optString)) {
                            TbadkCoreApplication.getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                        } else if (LoginPassV6Switch.KEY.equals(optString)) {
                            SwitchManager.getInstance().turn(optString, valueOf.intValue());
                            g05.a();
                        } else if ("android_safe_sdk_open".equals(optString)) {
                            ox4.k().w("android_safe_sdk_open", valueOf.intValue());
                        } else if ("android_new_log_upload_switch".equals(optString)) {
                            ox4.k().w("KEY_LOG_REAL_TIME_UPLOAD_SWITCH", valueOf.intValue());
                        } else if ("android_abtest_channel_switch".equals(optString)) {
                            ox4.k().w("key_abtest_channel", valueOf.intValue());
                        } else if (BigdaySwitch.BIGDAY_KEY.equals(optString)) {
                            ox4.k().w("key_bigday_sync_switch", valueOf.intValue());
                        } else if (StatSdkSwitch.STAT_SDK_KEY.equals(optString)) {
                            ox4.k().w("pref_key_stat_sdk_enable", valueOf.intValue());
                        } else if (JPushSdkSwitch.JPUSH_SDK_KEY.equals(optString)) {
                            ox4.k().w("pref_key_jpush_sdk_enable", valueOf.intValue());
                        } else if ("lcslog_upload_switch".equals(optString)) {
                            ox4.k().w("key_lcs_log_switch", valueOf.intValue());
                        } else if ("android_slide_anim_switch".equals(optString)) {
                            ox4.k().w("sync_slide_animation__switch", valueOf.intValue());
                        } else if ("image_header_no_cache_enable".equals(optString)) {
                            ox4.k().w("image_no_cache_switch", valueOf.intValue());
                        } else if ("profile_usercenter_open".equals(optString)) {
                            ox4.k().w("key_create_center_entrance_switch", valueOf.intValue());
                        } else if (FunAdSdkSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w("pref_key_fun_ad_sdk_enable", valueOf.intValue());
                        } else if ("pic_req_switch_key".equals(optString)) {
                            ox4.k().w("key_pic_req_switch", valueOf.intValue());
                        } else if (FunAdServerRecordSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w("pref_key_fun_ad_server_record_enable", valueOf.intValue());
                        } else if (GdtPrivacySwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w("pref_key_splash_gdt_privacy_enable", valueOf.intValue());
                        } else if (CsjPrivacySwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w("pref_key_splash_csj_privacy_enable", valueOf.intValue());
                        } else if (KsPrivacySwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w("pref_key_splash_ks_privacy_enable", valueOf.intValue());
                        } else if (FunAdSplashClickRegionSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w("pref_key_fun_ad_splash_click_enable", valueOf.intValue());
                        } else if (QqShareH5Switch.QQ_SHARE_H5_ENABLE.equals(optString)) {
                            ox4.k().w("key_qq_share_h5_enable", valueOf.intValue());
                        } else if (WeChatShareSmallAppToH5Switch.SMALL_APP_TO_H5.equals(optString)) {
                            ox4.k().w("key_wechat_small_app_to_h5", valueOf.intValue());
                        } else if ("platform_csj_init".equals(optString)) {
                            ox4.k().w("key_fun_cjs_init", valueOf.intValue());
                        } else if ("platform_gdt_init".equals(optString)) {
                            ox4.k().w("key_fun_gdt_init", valueOf.intValue());
                        } else if ("platform_ks_init".equals(optString)) {
                            ox4.k().w("key_fun_ks_init", valueOf.intValue());
                        } else if (MainTabDataSwitch.LAUNCH_UP_MAIN_TAB_DATA_ENABLE.equals(optString)) {
                            ox4.k().w("key_launch_up_main_tab_data", valueOf.intValue());
                        } else if (NewWriteProtobufSwitch.NEW_WRITE_PROTOBUF_ENABLE.equals(optString)) {
                            ox4.k().w("key_new_write_protobuf", valueOf.intValue());
                        } else if (NewWritePageSwitch.KEY_NEW_WRITE_PAGE.equals(optString)) {
                            ox4.k().w("key_new_write_page", valueOf.intValue());
                        } else if (OpenStartSafeModeSwitch.KEY.equals(optString)) {
                            ox4.k().w("key_is_start_safe_mode", valueOf.intValue());
                        } else if (ResetSplashAdConfigSwitch.KEY.equals(optString)) {
                            if (valueOf.intValue() == 1) {
                                ox4.k().u("key_is_jump_splash_ad", false);
                            }
                        } else if (LaunchViewOptSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w(LaunchViewOptSwitch.KEY_SWITCH, valueOf.intValue());
                        } else if (PbLoadingViewOptimizeSwitch.ANDROID_PB_LOADING_VIEW_OPTIMIZE.equals(optString)) {
                            ox4.k().w("key_android_pb_loading_view_optimize", valueOf.intValue());
                        } else if (PreInitMainTabViewSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w(PreInitMainTabViewSwitch.KEY_SWITCH, valueOf.intValue());
                        } else if (ThreadCardImgClickToPBSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w(ThreadCardImgClickToPBSwitch.KEY_SWITCH, valueOf.intValue());
                        } else if (FixNpsAnrSwitch.KEY_SWITCH.equals(optString)) {
                            ox4.k().w(FixNpsAnrSwitch.KEY_SWITCH, valueOf.intValue());
                        } else if (HasUseGlideSwitch.HAS_USE_GLIDE.equals(optString)) {
                            ox4.k().w("key_use_glide_switch", valueOf.intValue());
                        }
                    }
                    i2++;
                    i = -1;
                }
            }
            if (this.i != null && this.i.size() > 0) {
                SwitchManager.getInstance().refreshSwitchManager(this.i);
            }
            this.e = jSONObject.optInt("is_pushservice_open", 1) == 1;
            TbadkCoreApplication.getInst().setIsPushServiceOpen(this.e);
            if (!this.e) {
                UtilHelper.stopPushService(TbadkCoreApplication.getInst().getApp().getApplicationContext());
            }
            TbadkCoreApplication.getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
            this.d = jSONObject.optInt("gpu_open", 1) == 1;
            TbadkCoreApplication.getInst().setGpuOpen(this.d);
            boolean z = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
            this.k = z;
            VoiceManager.setVoiceUseSoftDecoder(z);
            if (TbadkCoreApplication.getInst().getFirstSyncImageQuality()) {
                int optInt2 = jSONObject.optInt("open_abstract", 0);
                if (!(optInt2 == 0 || TbadkCoreApplication.getInst().getIsAbstractStatus() != 0)) {
                    TbadkCoreApplication.getInst().setIsAbstractOn(optInt2);
                }
            }
            if (optInt == 1) {
                TbadkCoreApplication.getInst().setIsAppOn(true);
            } else if (optInt == 0) {
                TbadkCoreApplication.getInst().setIsAppOn(false);
            }
            this.f = jSONObject.optInt("perform_sample_param", 100000);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("keepalive");
            if (optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("wifi");
                if (optJSONObject4 != null) {
                    TbadkCoreApplication.getInst().setKeepaliveWifi(optJSONObject4.optInt(SetImageWatermarkTypeReqMsg.SWITCH));
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("nonwifi");
                if (optJSONObject5 != null) {
                    TbadkCoreApplication.getInst().setKeepaliveNonWifi(optJSONObject5.optInt(SetImageWatermarkTypeReqMsg.SWITCH));
                }
            }
            TbadkCoreApplication.getInst().setSocketReconnStratgy(a(jSONObject.optJSONArray("lcsReconStrategy")));
            TbadkCoreApplication.getInst().setSocketHeartBeatStratgy(a(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
            TbadkCoreApplication.getInst().setSocketGetMsgStratgy(a(jSONObject.optJSONArray("imGetMsgStrategy")));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("imNetworkTimeOut");
            if (optJSONObject6 != null) {
                TbadkCoreApplication.getInst().setImTimeOut(new int[]{optJSONObject6.optInt("2gTo", 0) * 1000, optJSONObject6.optInt("3gTo", 0) * 1000, optJSONObject6.optInt("wifiTo", 0) * 1000});
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("imNotifyRecordStrategy");
            h45 a = h45.a();
            if (optJSONObject7 != null) {
                a.b(optJSONObject7);
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("local_dialog");
            if (optJSONObject8 != null) {
                this.m = optJSONObject8.optInt("local_dialog_android", 1);
                ox4.k().w("sync_local_dialog", this.m);
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("benchmark");
            if (optJSONObject9 != null) {
                int optInt3 = optJSONObject9.optInt("android_flops_dur", Integer.MAX_VALUE);
                int optInt4 = optJSONObject9.optInt("android_anim_avg_fps", 0);
                TbSingleton.getInstance().setCpuThreshold(optInt3);
                TbSingleton.getInstance().setAnimAverageFpsThreshold(optInt4);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
            TbConfig.setBigPhotoAdress(this.b);
            TbConfig.setSmallPhotoAdress(this.c);
            PreLoadVideoSwitchManager.getInstance().setSyncSwitchJson(jSONObject.optString("android_preload_conf"));
            JSONObject optJSONObject10 = jSONObject.optJSONObject("duxiaoman_url");
            if (optJSONObject10 != null) {
                this.n = optJSONObject10.optString("cash_pay");
                ox4.k().y("baidu_finance", optJSONObject10.optString("finance"));
            }
            if (TextUtils.isEmpty(this.n) && TextUtils.isEmpty(ox4.k().q("cash_pay", null))) {
                this.n = "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1";
            }
            if (StringUtils.isNull(this.n)) {
                return;
            }
            ox4.k().y("cash_pay", this.n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
