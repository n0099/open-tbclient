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
public class if1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851477, "Lcom/baidu/tieba/if1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851477, "Lcom/baidu/tieba/if1;");
                return;
            }
        }
        a = new ConcurrentHashMap();
        d();
    }

    public if1() {
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

    public static Object a(ServiceReference serviceReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, serviceReference)) == null) {
            hf1 hf1Var = (hf1) a.get(serviceReference);
            if (hf1Var != null) {
                return hf1Var.getService();
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static void b(ServiceReference serviceReference, hf1 hf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, hf1Var) == null) {
            a.put(serviceReference, hf1Var);
        }
    }

    public static void c(String str, String str2, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, cls) == null) {
            try {
                b(new ServiceReference(str, str2), (hf1) cls.newInstance());
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
            c("Frs", "FrsService", zh6.class);
            c("HotTopic", "HotTopicRequest", fn5.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", "ab", vk7.class);
            c("live", DI.ACCOUNT, kk7.class);
            c("live", DI.APP_INFO_NAME, mk7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, dl7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, kl7.class);
            c("live", DI.FOLLOW_STATUS, bl7.class);
            c("live", DI.LIGHTBROWSER_VIEW, rk7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, gm7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, zk7.class);
            c("live", DI.LIVE_LIKE, fl7.class);
            c("live", DI.LIVE_LOCATION, il7.class);
            c("live", DI.LIVE_REAL_AUTH, ok7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, sl7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, xk7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, yk7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", ml7.class);
            c("live", DI.PAY_CHANNEL, tk7.class);
            c("live", DI.LIVE_PLAYER, zl7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, em7.class);
            c("live", "share", km7.class);
            c("live", DI.TB.SHARE_CHANNEL, im7.class);
            c("live", DI.THIRD_PART_ACCOUNT, mm7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, nm7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, pm7.class);
            c("live", DI.TOAST_NAME, rm7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, pl7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.core", "adRequester", vz0.class);
            c("nad.core", "browserDownload", kk0.class);
            c("nad.core", "cmd", br5.class);
            c("nad.core", "config", cr5.class);
            c("nad.core", "crius", wj0.class);
            c("nad.core", "deviceInfo.bag", b.class);
            c("nad.core", "deviceInfoInner", hh0.class);
            c("nad.core", "eventbus", bm0.class);
            c("nad.core", "exp", qm0.class);
            c("nad.core", "ipdx", kh0.class);
            c("nad.core", "loadImage", rg0.class);
            c("nad.core", "loadVideo", sv0.class);
            c("nad.core", "maxUI", er5.class);
            c("nad.core", "navBarTool", gr5.class);
            c("nad.core", "splash.config", hr5.class);
            c("nad.core", "splash.host", ir5.class);
            c("nad.core", "thirdService", fr5.class);
            c("nad.core", "uad", jr5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", r86.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", mb5.class);
            c("tbadkcore", "tbadkcore", so5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, ua9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, lj9.class);
            c("yaLog", "yaLogConfig", ik9.class);
        }
    }
}
