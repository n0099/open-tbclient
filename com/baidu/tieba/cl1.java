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
import com.baidu.searchbox.live.video.VideoInsertLiveServiceFetcher;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerServiceFetcher;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.retrieve.core.task.FetchTaskFetcher;
import com.baidu.searchbox.retrieve.core.task.UploadTaskFetcher;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.stats.service.StatServiceFetcher;
import com.baidu.tbadk.abtest.helper.NetExperimentFetcher;
import com.baidu.tbadk.switchs.UniKVTestFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class cl1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, bl1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947678497, "Lcom/baidu/tieba/cl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947678497, "Lcom/baidu/tieba/cl1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public cl1() {
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
            bl1<?> bl1Var = a.get(serviceReference);
            if (bl1Var != null) {
                return (T) bl1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, bl1<T> bl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, bl1Var) == null) {
            a.put(serviceReference, bl1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends bl1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", x59.class);
            c("AlaLiveSdk", "IMSdkServicePerson", y59.class);
            c("AlaSquare", "SecondFloorService", hd6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", uk6.class);
            c("Frames", "JsPromptBridge", ok6.class);
            c("Frs", "FrsService", ej7.class);
            c("Frs", "FrsVisitedInfoService", my6.class);
            c("HotTopic", "HotTopicRequest", t36.class);
            c("IM", "IMessageCenterService", sz8.class);
            c("ImMessageCenter", "ChatBoxDialogService", uq8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", gs8.class);
            c("ImMessageCenter", "GroupChatService", rq8.class);
            c("MessageCenter", "MessageCenterAIBotService", rz8.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", on6.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", mk6.class);
            c(WebView.LOGTAG, "IPrefetchManager", kk6.class);
            c(WebView.LOGTAG, "IPrerenderManager", lk6.class);
            c(WebView.LOGTAG, "IWebViewDebug", nk6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", fk6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatService", kg8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", ry6.class);
            c("download", "DOWNLOAD", z10.class);
            c("download", "db", v10.class);
            c("feed", "component.resolver", rr6.class);
            c("feed", "widget.resolver", sr6.class);
            c("live", DI.AB_NAME, m89.class);
            c("live", "account", a89.class);
            c("live", DI.APP_INFO_NAME, c89.class);
            c("live", DI.PLAYER.DU_MEDIA, m99.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, w89.class);
            c("live", DI.EXT.EXT_LIVE_LOG, d99.class);
            c("live", DI.FOLLOW_STATUS, s89.class);
            c("live", DI.LIGHTBROWSER_VIEW, h89.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, ba9.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, q89.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, y89.class);
            c("live", DI.LIVE_LOCATION, b99.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, e89.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, n99.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, o89.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, p89.class);
            c("live", DI.LIVE_YY_RTC, z99.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", f99.class);
            c("live", DI.PAY_CHANNEL, k89.class);
            c("live", DI.LIVE_PLAYER, u99.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, x99.class);
            c("live", "share", fa9.class);
            c("live", DI.TB.SHARE_CHANNEL, da9.class);
            c("live", DI.THIRD_PART_ACCOUNT, ha9.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, ia9.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ka9.class);
            c("live", "toast", ma9.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, dz7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, bz7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, fz7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, hz7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, i99.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", u89.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", mfa.class);
            c("module_home", "SpriteStateService", hfa.class);
            c("nad.business", "rewardVideoLpTaskCenter", yo0.class);
            c("nad.core", "adRequester", w21.class);
            c("nad.core", "browserDownload", fl0.class);
            c("nad.core", "cmd", p86.class);
            c("nad.core", "config", q86.class);
            c("nad.core", "crius", rk0.class);
            c("nad.core", "cyber", c76.class);
            c("nad.core", "deviceInfo.bag", d.class);
            c("nad.core", "deviceInfoInner", vh0.class);
            c("nad.core", "downloadCreator", h96.class);
            c("nad.core", "eventbus", dn0.class);
            c("nad.core", "exp", sn0.class);
            c("nad.core", "ipdx", yh0.class);
            c("nad.core", "loadImage", eh0.class);
            c("nad.core", "loadVideo", sy0.class);
            c("nad.core", "maxUI", s86.class);
            c("nad.core", "nativeCookieMgr", na1.class);
            c("nad.core", "navBarTool", v86.class);
            c("nad.core", "splash.config", w86.class);
            c("nad.core", "splash.host", x86.class);
            c("nad.core", "thirdService", t86.class);
            c("nad.core", "toast", u86.class);
            c("nad.core", "uad", y86.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", k07.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", hr5.class);
            c("tbadkcore", "tbadkcore", h56.class);
            c("tieba.core", "eventbus", k39.class);
            c("tieba.core", "eventbus.autorelease", j39.class);
            c("ubc", UBC.TAG, mdb.class);
            c("voyager", "upload", imb.class);
            c("yaLog", "yaLogConfig", hnb.class);
        }
    }
}
