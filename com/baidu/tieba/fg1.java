package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.behavior.record.BehaviorServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.abtest.ioc.AbTestServiceFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreCollectFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreConfigFetcher;
import com.baidu.searchbox.devicescore.DeviceScoreFetcher;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePlayUrlServiceFetcher;
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
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class fg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, eg1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947763065, "Lcom/baidu/tieba/fg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947763065, "Lcom/baidu/tieba/fg1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public fg1() {
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
            eg1<?> eg1Var = a.get(serviceReference);
            if (eg1Var != null) {
                return (T) eg1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, eg1<T> eg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, eg1Var) == null) {
            a.put(serviceReference, eg1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends eg1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", zr7.class);
            c("AlaSquare", "SecondFloorService", zy5.class);
            c("Frames", "ISafetyConfig", x56.class);
            c("Frames", "JsPromptBridge", q56.class);
            c("Frs", "FrsService", eo6.class);
            c("HotTopic", "HotTopicRequest", fq5.class);
            c("ImMessageCenter", "ChatBoxDialogService", dk7.class);
            c("ImMessageCenter", "ChatFloatEntranceService", zk7.class);
            c("ImMessageCenter", "GroupChatService", bk7.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", t76.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", DI.AB_NAME, gu7.class);
            c("live", DI.ACCOUNT, vt7.class);
            c("live", DI.APP_INFO_NAME, xt7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, ou7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, vu7.class);
            c("live", DI.FOLLOW_STATUS, mu7.class);
            c("live", DI.LIGHTBROWSER_VIEW, cu7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, rv7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, ku7.class);
            c("live", DI.LIVE_LIKE, qu7.class);
            c("live", DI.LIVE_LOCATION, tu7.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, zt7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, dv7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, iu7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, ju7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", xu7.class);
            c("live", DI.PAY_CHANNEL, eu7.class);
            c("live", DI.LIVE_PLAYER, kv7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, pv7.class);
            c("live", "share", vv7.class);
            c("live", DI.TB.SHARE_CHANNEL, tv7.class);
            c("live", DI.THIRD_PART_ACCOUNT, xv7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, yv7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, aw7.class);
            c("live", "toast", cw7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, av7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.business", "rewardVideoLpTaskCenter", ao0.class);
            c("nad.core", "adRequester", r01.class);
            c("nad.core", "browserDownload", ok0.class);
            c("nad.core", "cmd", mu5.class);
            c("nad.core", "config", nu5.class);
            c("nad.core", "crius", ak0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", lh0.class);
            c("nad.core", "eventbus", fm0.class);
            c("nad.core", "exp", um0.class);
            c("nad.core", "ipdx", oh0.class);
            c("nad.core", "loadImage", vg0.class);
            c("nad.core", "loadVideo", ow0.class);
            c("nad.core", "maxUI", pu5.class);
            c("nad.core", "navBarTool", ru5.class);
            c("nad.core", "splash.config", su5.class);
            c("nad.core", "splash.host", tu5.class);
            c("nad.core", "thirdService", qu5.class);
            c("nad.core", "uad", uu5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", re6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", wd5.class);
            c("tbadkcore", "tbadkcore", tr5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, hl9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, yt9.class);
            c("yaLog", "yaLogConfig", vu9.class);
        }
    }
}
