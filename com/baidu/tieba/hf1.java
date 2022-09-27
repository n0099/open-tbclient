package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.behavior.record.BehaviorServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.abtest.ioc.AbTestServiceFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceFetcher;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.live.service.Media2YYServiceFetcher;
import com.baidu.searchbox.live.service.PluginInvokeServiceFetcher;
import com.baidu.searchbox.live.service.YY2MediaServiceFetcher;
import com.baidu.searchbox.live.service.YYPluginProgressInvokeServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher;
import com.baidu.tbadk.abtest.helper.NetExperimentFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class hf1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, gf1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947821686, "Lcom/baidu/tieba/hf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947821686, "Lcom/baidu/tieba/hf1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public hf1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T> T a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, serviceReference)) == null) {
            gf1<?> gf1Var = a.get(serviceReference);
            if (gf1Var != null) {
                return (T) gf1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, gf1<T> gf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, gf1Var) == null) {
            a.put(serviceReference, gf1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends gf1<T>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, cls) == null) {
            try {
                b(new ServiceReference(str, str2), cls.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            c("Frs", "FrsService", sh6.class);
            c("HotTopic", "HotTopicRequest", ym5.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", kk7.class);
            c("live", DI.ACCOUNT, zj7.class);
            c("live", DI.APP_INFO_NAME, bk7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, sk7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, zk7.class);
            c("live", DI.FOLLOW_STATUS, qk7.class);
            c("live", DI.LIGHTBROWSER_VIEW, gk7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, vl7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, ok7.class);
            c("live", DI.LIVE_LIKE, uk7.class);
            c("live", DI.LIVE_LOCATION, xk7.class);
            c("live", DI.LIVE_REAL_AUTH, dk7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, hl7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, mk7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, nk7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", bl7.class);
            c("live", DI.PAY_CHANNEL, ik7.class);
            c("live", DI.LIVE_PLAYER, ol7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, tl7.class);
            c("live", "share", zl7.class);
            c("live", DI.TB.SHARE_CHANNEL, xl7.class);
            c("live", DI.THIRD_PART_ACCOUNT, bm7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, cm7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, em7.class);
            c("live", DI.TOAST_NAME, gm7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, el7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", uz0.class);
            c("nad.core", "browserDownload", jk0.class);
            c("nad.core", "cmd", uq5.class);
            c("nad.core", "config", vq5.class);
            c("nad.core", "crius", vj0.class);
            c("nad.core", "deviceInfo.bag", b.class);
            c("nad.core", "deviceInfoInner", gh0.class);
            c("nad.core", "eventbus", am0.class);
            c("nad.core", "exp", pm0.class);
            c("nad.core", "ipdx", jh0.class);
            c("nad.core", "loadImage", qg0.class);
            c("nad.core", "loadVideo", rv0.class);
            c("nad.core", "maxUI", xq5.class);
            c("nad.core", "navBarTool", zq5.class);
            c("nad.core", "splash.config", ar5.class);
            c("nad.core", "splash.host", br5.class);
            c("nad.core", "thirdService", yq5.class);
            c("nad.core", "uad", cr5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", k86.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", hb5.class);
            c("tbadkcore", "tbadkcore", lo5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, ca9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, ti9.class);
            c("yaLog", "yaLogConfig", qj9.class);
        }
    }
}
