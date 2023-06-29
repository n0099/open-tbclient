package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes6.dex */
public class gx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, obj, z) == null) {
            b(obj, z, false);
        }
    }

    public static void b(Object obj, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{obj, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c(obj, z, z2, false);
        }
    }

    public static void c(Object obj, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{obj, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || obj == null) {
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
            builder.user_agent = ly5.b();
            if (z) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.BDUSS = qp5.b();
                    if (!StringUtils.isNull(qp5.e())) {
                        builder.stoken = qp5.e();
                    }
                } else {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        builder.BDUSS = currentAccountInfo.getBDUSS();
                        String a = v05.a(currentAccountInfo);
                        if (!StringUtils.isNull(a)) {
                            builder.stoken = a;
                        }
                    }
                }
            }
            if (z2) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.tbs = qp5.f();
                } else {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
            }
            if (z3) {
                builder.applist = TbadkCoreApplication.getInst().getInstalledAppIds();
            }
            builder.pversion = "1.0.3";
            builder.lego_lib_version = TbConfig.getLegoLibVersion();
            if (r95.p().q("android_safe_sdk_open", 0) == 1) {
                builder.z_id = TbadkCoreApplication.getInst().getZid();
            }
            builder.net_type = Integer.valueOf(BdNetTypeUtil.netType());
            builder.sample_id = TbSingleton.getInstance().getSampleId();
            builder.is_teenager = 0;
            if (eq9.b()) {
                builder._phone_imei = TbadkCoreApplication.getInst().getImei();
                builder.model = zi.g();
                builder._os_version = zi.k();
                builder.brand = Build.BRAND;
                builder.oaid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                builder.android_id = TbadkCoreApplication.getInst().getAndroidId();
            } else {
                builder.need_decrypt = Integer.valueOf(vg.e(eq9.c(), 0));
                String g = eq9.g(HttpRequest.PHONE_IMEI);
                if (HttpRequest.PHONE_IMEI.equals(g)) {
                    builder._phone_imei = eq9.f();
                } else if (HttpRequest.PHONE_IMEI_REVERSAL.equals(g)) {
                    builder.iemi = eq9.f();
                }
                String g2 = eq9.g("model");
                if ("model".equals(g2)) {
                    builder.model = eq9.h();
                } else if ("ledom".equals(g2)) {
                    builder.ledom = eq9.h();
                }
                String g3 = eq9.g(HttpRequest.OS_VERSION);
                if (HttpRequest.OS_VERSION.equals(g3)) {
                    builder._os_version = eq9.j();
                } else if ("noisrev_so".equals(g3)) {
                    builder.noisrev_so = eq9.j();
                }
                String g4 = eq9.g("brand");
                if ("brand".equals(g4)) {
                    builder.brand = eq9.e();
                } else if ("dnarb".equals(g4)) {
                    builder.dnarb = eq9.e();
                }
                String g5 = eq9.g("oaid");
                if ("oaid".equals(g5)) {
                    builder.oaid = eq9.i();
                } else if ("diao".equals(g5)) {
                    builder.diao = eq9.i();
                }
                String g6 = eq9.g(HttpRequest.ANDROID_ID);
                if (HttpRequest.ANDROID_ID.equals(g6)) {
                    builder.android_id = eq9.d();
                } else if (HttpRequest.ANDROID_ID_REVERSAL.equals(g6)) {
                    builder.di_diordna = eq9.d();
                }
            }
            if (dq9.b()) {
                builder.mac = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            } else {
                builder.need_cam_decrypt = Integer.valueOf(vg.e(dq9.c(), 0));
                String d = dq9.d("mac");
                if ("mac".equals(d)) {
                    builder.mac = dq9.e();
                } else if (HttpRequest.MAC_REVERSAL.equals(d)) {
                    builder.cam = dq9.e();
                }
            }
            builder.sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
            builder.framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
            builder.naws_game_ver = TbadkCoreApplication.getInst().getNaws_game_ver();
            builder.q_type = Integer.valueOf(r05.c().e());
            builder.scr_h = Integer.valueOf(xi.j(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(xi.l(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(xi.i(TbadkCoreApplication.getInst()));
            builder.active_timestamp = Long.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
            builder.first_install_time = Long.valueOf(TbSingleton.getInstance().getAppFirstInstallTime());
            builder.last_update_time = Long.valueOf(TbSingleton.getInstance().getAppLastUpdateTime());
            builder.event_day = TbSingleton.getInstance().getData();
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                i = 2;
            }
            builder.cmode = Integer.valueOf(i);
            builder.start_type = Integer.valueOf(g85.f);
            builder.start_scheme = g85.e();
            builder.extra = r95.p().w("key_sync_extra_field", "");
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
