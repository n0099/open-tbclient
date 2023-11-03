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
public class dg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, cg1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703483, "Lcom/baidu/tieba/dg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703483, "Lcom/baidu/tieba/dg1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public dg1() {
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
            cg1<?> cg1Var = a.get(serviceReference);
            if (cg1Var != null) {
                return (T) cg1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, cg1<T> cg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, cg1Var) == null) {
            a.put(serviceReference, cg1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends cg1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", md9.class);
            c("AlaLiveSdk", "IMSdkServicePerson", nd9.class);
            c("AlaSquare", "FrsLiveTabService", n76.class);
            c("AlaSquare", "SecondFloorService", l96.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", yg6.class);
            c("Frames", "JsPromptBridge", sg6.class);
            c("Frs", "FrsService", eq7.class);
            c("Frs", "FrsVisitedInfoService", lu6.class);
            c("HotTopic", "HotTopicRequest", wz5.class);
            c("IM", "IMessageCenterService", h79.class);
            c("ImMessageCenter", "ChatBoxDialogService", ey8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", tz8.class);
            c("ImMessageCenter", "ChatMessageDispatchService", hy8.class);
            c("ImMessageCenter", "GroupChatService", zx8.class);
            c("MessageCenter", "MessageCenterAIBotService", g79.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", tj6.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", qg6.class);
            c(WebView.LOGTAG, "IPrefetchManager", og6.class);
            c(WebView.LOGTAG, "IPrerenderManager", pg6.class);
            c(WebView.LOGTAG, "IWebViewDebug", rg6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", jg6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatService", sn8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", qu6.class);
            c("download", "DOWNLOAD", nx.class);
            c("download", "db", jx.class);
            c("feed", "component.resolver", xn6.class);
            c("feed", "widget.resolver", yn6.class);
            c("live", DI.AB_NAME, bg9.class);
            c("live", "account", pf9.class);
            c("live", DI.APP_INFO_NAME, rf9.class);
            c("live", DI.PLAYER.DU_MEDIA, bh9.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, lg9.class);
            c("live", DI.EXT.EXT_LIVE_LOG, sg9.class);
            c("live", DI.FOLLOW_STATUS, hg9.class);
            c("live", DI.LIGHTBROWSER_VIEW, wf9.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, qh9.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, fg9.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, ng9.class);
            c("live", DI.LIVE_LOCATION, qg9.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, tf9.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, ch9.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, dg9.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, eg9.class);
            c("live", DI.LIVE_YY_RTC, oh9.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", ug9.class);
            c("live", DI.PAY_CHANNEL, zf9.class);
            c("live", DI.LIVE_PLAYER, jh9.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, mh9.class);
            c("live", "share", uh9.class);
            c("live", DI.TB.SHARE_CHANNEL, sh9.class);
            c("live", DI.THIRD_PART_ACCOUNT, wh9.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, xh9.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, zh9.class);
            c("live", "toast", bi9.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, j68.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, h68.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, l68.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, n68.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, xg9.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", jg9.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", hna.class);
            c("module_home", "SpriteStateService", cna.class);
            c("nad.business", "rewardVideoLpTaskCenter", mk0.class);
            c("nad.core", "adRequester", ay0.class);
            c("nad.core", "browserDownload", tg0.class);
            c("nad.core", "cmd", s46.class);
            c("nad.core", "config", t46.class);
            c("nad.core", "crius", fg0.class);
            c("nad.core", "cyber", f36.class);
            c("nad.core", "deviceInfo.bag", e.class);
            c("nad.core", "deviceInfoInner", jd0.class);
            c("nad.core", "downloadCreator", k56.class);
            c("nad.core", "eventbus", ri0.class);
            c("nad.core", "exp", gj0.class);
            c("nad.core", "ipdx", md0.class);
            c("nad.core", "loadImage", sc0.class);
            c("nad.core", "loadVideo", fu0.class);
            c("nad.core", "maxUI", v46.class);
            c("nad.core", "nativeCookieMgr", r51.class);
            c("nad.core", "navBarTool", y46.class);
            c("nad.core", "splash.config", z46.class);
            c("nad.core", "splash.host", a56.class);
            c("nad.core", "thirdService", w46.class);
            c("nad.core", "toast", x46.class);
            c("nad.core", "uad", b56.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", jw6.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", en5.class);
            c("tbadkcore", "tbadkcore", k16.class);
            c("tieba.core", "eventbus", za9.class);
            c("tieba.core", "eventbus.autorelease", ya9.class);
            c("ubc", UBC.TAG, ilb.class);
            c("voyager", "upload", eub.class);
            c("yaLog", "yaLogConfig", dvb.class);
        }
    }
}
