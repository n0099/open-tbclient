package com.baidu.tbadk.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.b05;
import com.baidu.tieba.dv9;
import com.baidu.tieba.e05;
import com.baidu.tieba.ev9;
import com.baidu.tieba.yo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes5.dex */
public class NetMessageHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NetMessageHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void bindCommonParamsToProtobufData(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, obj, z) == null) {
            bindCommonParamsToProtobufData(obj, z, false);
        }
    }

    public static void bindCommonParamsToProtobufData(Object obj, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{obj, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            bindCommonParamsToProtobufData(obj, z, z2, false);
        }
    }

    public static void bindCommonParamsToProtobufData(Object obj, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{obj, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || obj == null) {
            return;
        }
        try {
            Field field = obj.getClass().getField("common");
            int i = 1;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            CommonReq.Builder builder = new CommonReq.Builder();
            builder._client_type = 2;
            builder._client_version = TbConfig.getVersion();
            builder._client_id = TbadkCoreApplication.getClientId();
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                builder.subapp_type = TbConfig.getSubappType();
            }
            if (!TbadkCoreApplication.getInst().isOfficial()) {
                builder.apid = TbConfig.SW_APID;
            }
            builder.from = TbadkCoreApplication.getFrom();
            builder.cuid = TbadkCoreApplication.getInst().getCuid();
            builder.cuid_galaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            builder.c3_aid = TbadkCoreApplication.getInst().getCuidGalaxy3();
            builder.cuid_gid = TbadkCoreApplication.getInst().getCuidGid();
            builder._timestamp = Long.valueOf(System.currentTimeMillis());
            builder.user_agent = WebviewHelper.getGlobalUserAgent();
            if (z) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.BDUSS = yo5.b();
                    if (!StringUtils.isNull(yo5.e())) {
                        builder.stoken = yo5.e();
                    }
                } else {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        builder.BDUSS = currentAccountInfo.getBDUSS();
                        String a = e05.a(currentAccountInfo);
                        if (!StringUtils.isNull(a)) {
                            builder.stoken = a;
                        }
                    }
                }
            }
            if (z2) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.tbs = yo5.f();
                } else {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
            }
            if (z3) {
                builder.applist = TbadkCoreApplication.getInst().getInstalledAppIds();
            }
            builder.pversion = "1.0.3";
            builder.lego_lib_version = TbConfig.getLegoLibVersion();
            if (SharedPrefHelper.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
                builder.z_id = TbadkCoreApplication.getInst().getZid();
            }
            builder.net_type = Integer.valueOf(BdNetTypeUtil.netType());
            builder.sample_id = TbSingleton.getInstance().getSampleId();
            builder.is_teenager = 0;
            if (ev9.b()) {
                builder._phone_imei = TbadkCoreApplication.getInst().getImei();
                builder.model = DeviceInfoHelper.getModel();
                builder._os_version = DeviceInfoHelper.getOsVersion();
                builder.brand = Build.BRAND;
                builder.oaid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                builder.android_id = TbadkCoreApplication.getInst().getAndroidId();
            } else {
                builder.need_decrypt = Integer.valueOf(JavaTypesHelper.toInt(ev9.c(), 0));
                String g = ev9.g(HttpRequest.PHONE_IMEI);
                if (HttpRequest.PHONE_IMEI.equals(g)) {
                    builder._phone_imei = ev9.f();
                } else if (HttpRequest.PHONE_IMEI_REVERSAL.equals(g)) {
                    builder.iemi = ev9.f();
                }
                String g2 = ev9.g("model");
                if ("model".equals(g2)) {
                    builder.model = ev9.h();
                } else if ("ledom".equals(g2)) {
                    builder.ledom = ev9.h();
                }
                String g3 = ev9.g(HttpRequest.OS_VERSION);
                if (HttpRequest.OS_VERSION.equals(g3)) {
                    builder._os_version = ev9.j();
                } else if ("noisrev_so".equals(g3)) {
                    builder.noisrev_so = ev9.j();
                }
                String g4 = ev9.g("brand");
                if ("brand".equals(g4)) {
                    builder.brand = ev9.e();
                } else if ("dnarb".equals(g4)) {
                    builder.dnarb = ev9.e();
                }
                String g5 = ev9.g("oaid");
                if ("oaid".equals(g5)) {
                    builder.oaid = ev9.i();
                } else if ("diao".equals(g5)) {
                    builder.diao = ev9.i();
                }
                String g6 = ev9.g(HttpRequest.ANDROID_ID);
                if (HttpRequest.ANDROID_ID.equals(g6)) {
                    builder.android_id = ev9.d();
                } else if (HttpRequest.ANDROID_ID_REVERSAL.equals(g6)) {
                    builder.di_diordna = ev9.d();
                }
            }
            if (dv9.b()) {
                builder.mac = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            } else {
                builder.need_cam_decrypt = Integer.valueOf(JavaTypesHelper.toInt(dv9.c(), 0));
                String d = dv9.d("mac");
                if ("mac".equals(d)) {
                    builder.mac = dv9.e();
                } else if (HttpRequest.MAC_REVERSAL.equals(d)) {
                    builder.cam = dv9.e();
                }
            }
            builder.sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
            builder.framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
            builder.naws_game_ver = TbadkCoreApplication.getInst().getNaws_game_ver();
            builder.q_type = Integer.valueOf(b05.c().e());
            builder.scr_h = Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            builder.active_timestamp = Long.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
            builder.first_install_time = Long.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
            builder.last_update_time = Long.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
            builder.event_day = TbSingleton.getInstance().getData();
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                i = 2;
            }
            builder.cmode = Integer.valueOf(i);
            builder.start_type = Integer.valueOf(GrowthFunnelHelper.realStartType);
            builder.start_scheme = GrowthFunnelHelper.getRealStartScheme();
            builder.extra = SharedPrefHelper.getInstance().getString("key_sync_extra_field", "");
            builder.personalized_rec_switch = Integer.valueOf(TbSingleton.getInstance().getPersonalizedRecSwitch());
            builder.device_score = String.valueOf(ScheduleStrategy.getDeviceScore());
            field.set(obj, builder.build(false));
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                th.printStackTrace();
            }
        }
    }
}
