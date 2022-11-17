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
/* loaded from: classes3.dex */
public class bg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, ag1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947643901, "Lcom/baidu/tieba/bg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947643901, "Lcom/baidu/tieba/bg1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public bg1() {
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
            ag1<?> ag1Var = a.get(serviceReference);
            if (ag1Var != null) {
                return (T) ag1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, ag1<T> ag1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, ag1Var) == null) {
            a.put(serviceReference, ag1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends ag1<T>> cls) {
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
            c("AlaSquare", "SecondFloorService", kx5.class);
            c("Frs", "FrsService", wj6.class);
            c("HotTopic", "HotTopicRequest", qo5.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", DI.AB_NAME, rm7.class);
            c("live", DI.ACCOUNT, gm7.class);
            c("live", DI.APP_INFO_NAME, im7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, zm7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, gn7.class);
            c("live", DI.FOLLOW_STATUS, xm7.class);
            c("live", DI.LIGHTBROWSER_VIEW, nm7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, co7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, vm7.class);
            c("live", DI.LIVE_LIKE, bn7.class);
            c("live", DI.LIVE_LOCATION, en7.class);
            c("live", DI.LIVE_REAL_AUTH, km7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, on7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, tm7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, um7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", in7.class);
            c("live", DI.PAY_CHANNEL, pm7.class);
            c("live", DI.LIVE_PLAYER, vn7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, ao7.class);
            c("live", "share", go7.class);
            c("live", DI.TB.SHARE_CHANNEL, eo7.class);
            c("live", DI.THIRD_PART_ACCOUNT, io7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, jo7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, lo7.class);
            c("live", DI.TOAST_NAME, no7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, ln7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.business", "rewardVideoLpTaskCenter", wn0.class);
            c("nad.core", "adRequester", n01.class);
            c("nad.core", "browserDownload", kk0.class);
            c("nad.core", "cmd", xs5.class);
            c("nad.core", "config", ys5.class);
            c("nad.core", "crius", wj0.class);
            c("nad.core", "deviceInfo.bag", b.class);
            c("nad.core", "deviceInfoInner", hh0.class);
            c("nad.core", "eventbus", bm0.class);
            c("nad.core", "exp", qm0.class);
            c("nad.core", "ipdx", kh0.class);
            c("nad.core", "loadImage", rg0.class);
            c("nad.core", "loadVideo", kw0.class);
            c("nad.core", "maxUI", at5.class);
            c("nad.core", "navBarTool", ct5.class);
            c("nad.core", "splash.config", dt5.class);
            c("nad.core", "splash.host", et5.class);
            c("nad.core", "thirdService", bt5.class);
            c("nad.core", "uad", ft5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", oa6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", pc5.class);
            c("tbadkcore", "tbadkcore", eq5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, pc9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, gl9.class);
            c("yaLog", "yaLogConfig", dm9.class);
        }
    }
}
