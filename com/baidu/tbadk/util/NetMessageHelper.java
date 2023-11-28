package com.baidu.tbadk.util;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.mfa;
import com.baidu.tieba.nfa;
import com.baidu.tieba.nv4;
import com.baidu.tieba.pm5;
import com.baidu.tieba.qv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import org.json.JSONObject;
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
                    builder.BDUSS = pm5.b();
                    if (!StringUtils.isNull(pm5.e())) {
                        builder.stoken = pm5.e();
                    }
                } else {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        builder.BDUSS = currentAccountInfo.getBDUSS();
                        String a = qv4.a(currentAccountInfo);
                        if (!StringUtils.isNull(a)) {
                            builder.stoken = a;
                        }
                    }
                }
            }
            if (z2) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.tbs = pm5.f();
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
            if (nfa.b()) {
                builder._phone_imei = TbadkCoreApplication.getInst().getImei();
                builder.model = DeviceInfoHelper.getModel();
                builder._os_version = DeviceInfoHelper.getOsVersion();
                builder.brand = Build.BRAND;
                builder.oaid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                builder.android_id = TbadkCoreApplication.getInst().getAndroidId();
            } else {
                builder.need_decrypt = Integer.valueOf(JavaTypesHelper.toInt(nfa.c(), 0));
                String g = nfa.g(HttpRequest.PHONE_IMEI);
                if (HttpRequest.PHONE_IMEI.equals(g)) {
                    builder._phone_imei = nfa.f();
                } else if (HttpRequest.PHONE_IMEI_REVERSAL.equals(g)) {
                    builder.iemi = nfa.f();
                }
                String g2 = nfa.g("model");
                if ("model".equals(g2)) {
                    builder.model = nfa.h();
                } else if ("ledom".equals(g2)) {
                    builder.ledom = nfa.h();
                }
                String g3 = nfa.g(HttpRequest.OS_VERSION);
                if (HttpRequest.OS_VERSION.equals(g3)) {
                    builder._os_version = nfa.j();
                } else if ("noisrev_so".equals(g3)) {
                    builder.noisrev_so = nfa.j();
                }
                String g4 = nfa.g("brand");
                if ("brand".equals(g4)) {
                    builder.brand = nfa.e();
                } else if ("dnarb".equals(g4)) {
                    builder.dnarb = nfa.e();
                }
                String g5 = nfa.g("oaid");
                if ("oaid".equals(g5)) {
                    builder.oaid = nfa.i();
                } else if ("diao".equals(g5)) {
                    builder.diao = nfa.i();
                }
                String g6 = nfa.g(HttpRequest.ANDROID_ID);
                if (HttpRequest.ANDROID_ID.equals(g6)) {
                    builder.android_id = nfa.d();
                } else if (HttpRequest.ANDROID_ID_REVERSAL.equals(g6)) {
                    builder.di_diordna = nfa.d();
                }
            }
            if (mfa.b()) {
                builder.mac = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            } else {
                builder.need_cam_decrypt = Integer.valueOf(JavaTypesHelper.toInt(mfa.c(), 0));
                String d = mfa.d("mac");
                if ("mac".equals(d)) {
                    builder.mac = mfa.e();
                } else if (HttpRequest.MAC_REVERSAL.equals(d)) {
                    builder.cam = mfa.e();
                }
            }
            builder.sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
            builder.framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
            builder.naws_game_ver = TbadkCoreApplication.getInst().getNaws_game_ver();
            builder.q_type = Integer.valueOf(nv4.c().e());
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

    public static JSONObject getCommonParamsJson(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(HttpRequest.CLIENT_TYPE, 2);
                jSONObject.put("_client_version", TbConfig.getVersion());
                jSONObject.put(HttpRequest.CLIENT_ID, TbadkCoreApplication.getClientId());
                if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                    jSONObject.put(HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
                }
                if (!TbadkCoreApplication.getInst().isOfficial()) {
                    jSONObject.put(IAdInterListener.AdReqParam.APID, TbConfig.SW_APID);
                }
                jSONObject.put("from", TbadkCoreApplication.getFrom());
                jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
                jSONObject.put("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
                jSONObject.put("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
                jSONObject.put(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
                jSONObject.put("_timestamp", System.currentTimeMillis());
                jSONObject.put("user_agent", WebviewHelper.getGlobalUserAgent());
                if (z) {
                    if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                        jSONObject.put(HttpRequest.BDUSS, pm5.b());
                        if (!StringUtils.isNull(pm5.e())) {
                            jSONObject.put("stoken", pm5.e());
                        }
                    } else {
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        if (currentAccountInfo != null) {
                            jSONObject.put(HttpRequest.BDUSS, currentAccountInfo.getBDUSS());
                            String a = qv4.a(currentAccountInfo);
                            if (!StringUtils.isNull(a)) {
                                jSONObject.put("stoken", a);
                            }
                        }
                    }
                }
                if (z2) {
                    if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                        jSONObject.put("tbs", pm5.f());
                    } else {
                        jSONObject.put("tbs", TbadkCoreApplication.getInst().getTbs());
                    }
                }
                if (z3) {
                    jSONObject.put("applist", TbadkCoreApplication.getInst().getInstalledAppIds());
                }
                jSONObject.put("pversion", "1.0.3");
                jSONObject.put("lego_lib_version", TbConfig.getLegoLibVersion());
                if (SharedPrefHelper.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
                    jSONObject.put("z_id", TbadkCoreApplication.getInst().getZid());
                }
                jSONObject.put("net_type", BdNetTypeUtil.netType());
                jSONObject.put(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                jSONObject.put("is_teenager", 0);
                if (nfa.b()) {
                    jSONObject.put(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
                    jSONObject.put("model", DeviceInfoHelper.getModel());
                    jSONObject.put(HttpRequest.OS_VERSION, DeviceInfoHelper.getOsVersion());
                    jSONObject.put("brand", Build.BRAND);
                    jSONObject.put("oaid", PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst()));
                    jSONObject.put(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
                    str = HttpRequest.MAC_REVERSAL;
                } else {
                    str = HttpRequest.MAC_REVERSAL;
                    jSONObject.put(HttpRequest.NEED_DECRYPT, JavaTypesHelper.toInt(nfa.c(), 0));
                    String g = nfa.g(HttpRequest.PHONE_IMEI);
                    if (HttpRequest.PHONE_IMEI.equals(g)) {
                        jSONObject.put(HttpRequest.PHONE_IMEI, nfa.f());
                    } else if (HttpRequest.PHONE_IMEI_REVERSAL.equals(g)) {
                        jSONObject.put(HttpRequest.PHONE_IMEI_REVERSAL, nfa.f());
                    }
                    String g2 = nfa.g("model");
                    if ("model".equals(g2)) {
                        jSONObject.put("model", nfa.h());
                    } else if ("ledom".equals(g2)) {
                        jSONObject.put("ledom", nfa.h());
                    }
                    String g3 = nfa.g(HttpRequest.OS_VERSION);
                    if (HttpRequest.OS_VERSION.equals(g3)) {
                        jSONObject.put(HttpRequest.OS_VERSION, nfa.j());
                    } else if ("noisrev_so".equals(g3)) {
                        jSONObject.put("noisrev_so", nfa.j());
                    }
                    String g4 = nfa.g("brand");
                    if ("brand".equals(g4)) {
                        jSONObject.put("brand", nfa.e());
                    } else if ("dnarb".equals(g4)) {
                        jSONObject.put("dnarb", nfa.e());
                    }
                    String g5 = nfa.g("oaid");
                    if ("oaid".equals(g5)) {
                        jSONObject.put("oaid", nfa.i());
                    } else if ("diao".equals(g5)) {
                        jSONObject.put("diao", nfa.i());
                    }
                    String g6 = nfa.g(HttpRequest.ANDROID_ID);
                    if (HttpRequest.ANDROID_ID.equals(g6)) {
                        jSONObject.put(HttpRequest.ANDROID_ID, nfa.d());
                    } else if (HttpRequest.ANDROID_ID_REVERSAL.equals(g6)) {
                        jSONObject.put(HttpRequest.ANDROID_ID_REVERSAL, nfa.d());
                    }
                }
                if (mfa.b()) {
                    jSONObject.put("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
                } else {
                    jSONObject.put("need_cam_decrypt", JavaTypesHelper.toInt(mfa.c(), 0));
                    String d = mfa.d("mac");
                    if ("mac".equals(d)) {
                        jSONObject.put("mac", mfa.e());
                    } else {
                        String str2 = str;
                        if (str2.equals(d)) {
                            jSONObject.put(str2, mfa.e());
                        }
                    }
                }
                jSONObject.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
                jSONObject.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
                jSONObject.put("naws_game_ver", TbadkCoreApplication.getInst().getNaws_game_ver());
                jSONObject.put("q_type", nv4.c().e());
                jSONObject.put("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                jSONObject.put("scr_dip", Double.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                jSONObject.put("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp());
                jSONObject.put("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime());
                jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime());
                jSONObject.put("event_day", TbSingleton.getInstance().getData());
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    i = 1;
                } else {
                    i = 2;
                }
                jSONObject.put("cmode", i);
                jSONObject.put("start_type", GrowthFunnelHelper.realStartType);
                jSONObject.put("start_scheme", GrowthFunnelHelper.getRealStartScheme());
                jSONObject.put("extra", SharedPrefHelper.getInstance().getString("key_sync_extra_field", ""));
                jSONObject.put("personalized_rec_switch", TbSingleton.getInstance().getPersonalizedRecSwitch());
                jSONObject.put("device_score", String.valueOf(ScheduleStrategy.getDeviceScore()));
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    th.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }
}
