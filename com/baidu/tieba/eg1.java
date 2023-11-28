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
public class eg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, dg1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733274, "Lcom/baidu/tieba/eg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733274, "Lcom/baidu/tieba/eg1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public eg1() {
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
            dg1<?> dg1Var = a.get(serviceReference);
            if (dg1Var != null) {
                return (T) dg1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, dg1<T> dg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, dg1Var) == null) {
            a.put(serviceReference, dg1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends dg1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", dh9.class);
            c("AlaLiveSdk", "IMSdkServicePerson", eh9.class);
            c("AlaSquare", "FrsLiveTabService", w76.class);
            c("AlaSquare", "SecondFloorService", u96.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", hh6.class);
            c("Frames", "JsPromptBridge", bh6.class);
            c("Frs", "FrsService", rs7.class);
            c("Frs", "FrsVisitedInfoService", wu6.class);
            c("HotTopic", "HotTopicRequest", e06.class);
            c("IM", "IMessageCenterService", sa9.class);
            c("ImMessageCenter", "ChatBoxDialogService", n19.class);
            c("ImMessageCenter", "ChatFloatEntranceService", c39.class);
            c("ImMessageCenter", "ChatMessageDispatchService", q19.class);
            c("ImMessageCenter", "GroupChatService", i19.class);
            c("MessageCenter", "MessageCenterAIBotService", ra9.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", dk6.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", zg6.class);
            c(WebView.LOGTAG, "IPrefetchManager", xg6.class);
            c(WebView.LOGTAG, "IPrerenderManager", yg6.class);
            c(WebView.LOGTAG, "IWebViewDebug", ah6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", sg6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatHistoryListService", zr8.class);
            c("aibot", "AibotChatService", wq8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", bv6.class);
            c("download", "DOWNLOAD", ox.class);
            c("download", "db", kx.class);
            c("feed", "component.resolver", io6.class);
            c("feed", "widget.resolver", jo6.class);
            c("live", DI.AB_NAME, sj9.class);
            c("live", "account", gj9.class);
            c("live", DI.APP_INFO_NAME, ij9.class);
            c("live", DI.PLAYER.DU_MEDIA, sk9.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, ck9.class);
            c("live", DI.EXT.EXT_LIVE_LOG, jk9.class);
            c("live", DI.FOLLOW_STATUS, yj9.class);
            c("live", DI.LIGHTBROWSER_VIEW, nj9.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, hl9.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, wj9.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, ek9.class);
            c("live", DI.LIVE_LOCATION, hk9.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, kj9.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, tk9.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, uj9.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, vj9.class);
            c("live", DI.LIVE_YY_RTC, fl9.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", lk9.class);
            c("live", DI.PAY_CHANNEL, qj9.class);
            c("live", DI.LIVE_PLAYER, al9.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, dl9.class);
            c("live", "share", ll9.class);
            c("live", DI.TB.SHARE_CHANNEL, jl9.class);
            c("live", DI.THIRD_PART_ACCOUNT, nl9.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, ol9.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ql9.class);
            c("live", "toast", sl9.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, e98.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, c98.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, g98.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, i98.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, ok9.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", ak9.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", bsa.class);
            c("module_home", "SpriteStateService", wra.class);
            c("nad.business", "rewardVideoLpTaskCenter", nk0.class);
            c("nad.core", "adRequester", by0.class);
            c("nad.core", "browserDownload", ug0.class);
            c("nad.core", "cmd", b56.class);
            c("nad.core", "config", c56.class);
            c("nad.core", "crius", gg0.class);
            c("nad.core", "cyber", n36.class);
            c("nad.core", "deviceInfo.bag", e.class);
            c("nad.core", "deviceInfoInner", kd0.class);
            c("nad.core", "downloadCreator", t56.class);
            c("nad.core", "eventbus", si0.class);
            c("nad.core", "exp", hj0.class);
            c("nad.core", "ipdx", nd0.class);
            c("nad.core", "loadImage", tc0.class);
            c("nad.core", "loadVideo", gu0.class);
            c("nad.core", "maxUI", e56.class);
            c("nad.core", "nativeCookieMgr", s51.class);
            c("nad.core", "navBarTool", h56.class);
            c("nad.core", "splash.config", i56.class);
            c("nad.core", "splash.host", j56.class);
            c("nad.core", "thirdService", f56.class);
            c("nad.core", "toast", g56.class);
            c("nad.core", "uad", k56.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", uw6.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", nn5.class);
            c("tbadkcore", "tbadkcore", s16.class);
            c("tieba.core", "eventbus", qe9.class);
            c("tieba.core", "eventbus.autorelease", pe9.class);
            c("ubc", UBC.TAG, fqb.class);
            c("voyager", "upload", bzb.class);
            c("yaLog", "yaLogConfig", a0c.class);
        }
    }
}
