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
import com.baidu.searchbox.retrieve.core.task.FetchTaskFetcher;
import com.baidu.searchbox.retrieve.core.task.UploadTaskFetcher;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.stats.service.StatServiceFetcher;
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
/* loaded from: classes3.dex */
public class bl1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, al1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947648706, "Lcom/baidu/tieba/bl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947648706, "Lcom/baidu/tieba/bl1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public bl1() {
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
            al1<?> al1Var = a.get(serviceReference);
            if (al1Var != null) {
                return (T) al1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, al1<T> al1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, al1Var) == null) {
            a.put(serviceReference, al1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends al1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", wz7.class);
            c("AlaSquare", "SecondFloorService", c56.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", ac6.class);
            c("Frames", "JsPromptBridge", tb6.class);
            c("Frs", "FrsService", ov6.class);
            c("HotTopic", "HotTopicRequest", hw5.class);
            c("ImMessageCenter", "ChatBoxDialogService", ds7.class);
            c("ImMessageCenter", "ChatFloatEntranceService", ct7.class);
            c("ImMessageCenter", "GroupChatService", bs7.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", pe6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", DI.AB_NAME, k28.class);
            c("live", DI.ACCOUNT, z18.class);
            c("live", DI.APP_INFO_NAME, b28.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, u28.class);
            c("live", DI.EXT.EXT_LIVE_LOG, b38.class);
            c("live", DI.FOLLOW_STATUS, q28.class);
            c("live", DI.LIGHTBROWSER_VIEW, g28.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, x38.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, o28.class);
            c("live", DI.LIVE_LIKE, w28.class);
            c("live", DI.LIVE_LOCATION, z28.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, d28.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, j38.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, m28.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, n28.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", d38.class);
            c("live", DI.PAY_CHANNEL, i28.class);
            c("live", DI.LIVE_PLAYER, q38.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, v38.class);
            c("live", "share", b48.class);
            c("live", DI.TB.SHARE_CHANNEL, z38.class);
            c("live", DI.THIRD_PART_ACCOUNT, d48.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, e48.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, g48.class);
            c("live", "toast", i48.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, g38.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", s28.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.business", "rewardVideoLpTaskCenter", qo0.class);
            c("nad.core", "adRequester", c21.class);
            c("nad.core", "browserDownload", el0.class);
            c("nad.core", "cmd", p06.class);
            c("nad.core", "config", q06.class);
            c("nad.core", "crius", qk0.class);
            c("nad.core", "deviceInfo.bag", c.class);
            c("nad.core", "deviceInfoInner", wh0.class);
            c("nad.core", "eventbus", vm0.class);
            c("nad.core", "exp", kn0.class);
            c("nad.core", "ipdx", zh0.class);
            c("nad.core", "loadImage", fh0.class);
            c("nad.core", "loadVideo", yx0.class);
            c("nad.core", "maxUI", s06.class);
            c("nad.core", "nativeCookieMgr", c91.class);
            c("nad.core", "navBarTool", u06.class);
            c("nad.core", "splash.config", v06.class);
            c("nad.core", "splash.host", w06.class);
            c("nad.core", "thirdService", t06.class);
            c("nad.core", "uad", x06.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, StatConstants.VALUE_TYPE_UPLOAD, UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", bm6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", uj5.class);
            c("tbadkcore", "tbadkcore", vx5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, pu9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, l3a.class);
            c("yaLog", "yaLogConfig", k4a.class);
        }
    }
}
