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
            c("AlaLiveSdk", "IMSdkService", nd9.class);
            c("AlaLiveSdk", "IMSdkServicePerson", od9.class);
            c("AlaSquare", "FrsLiveTabService", o76.class);
            c("AlaSquare", "SecondFloorService", m96.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", zg6.class);
            c("Frames", "JsPromptBridge", tg6.class);
            c("Frs", "FrsService", fq7.class);
            c("Frs", "FrsVisitedInfoService", mu6.class);
            c("HotTopic", "HotTopicRequest", xz5.class);
            c("IM", "IMessageCenterService", i79.class);
            c("ImMessageCenter", "ChatBoxDialogService", fy8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", uz8.class);
            c("ImMessageCenter", "ChatMessageDispatchService", iy8.class);
            c("ImMessageCenter", "GroupChatService", ay8.class);
            c("MessageCenter", "MessageCenterAIBotService", h79.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", uj6.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", rg6.class);
            c(WebView.LOGTAG, "IPrefetchManager", pg6.class);
            c(WebView.LOGTAG, "IPrerenderManager", qg6.class);
            c(WebView.LOGTAG, "IWebViewDebug", sg6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", kg6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatService", tn8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", ru6.class);
            c("download", "DOWNLOAD", nx.class);
            c("download", "db", jx.class);
            c("feed", "component.resolver", yn6.class);
            c("feed", "widget.resolver", zn6.class);
            c("live", DI.AB_NAME, cg9.class);
            c("live", "account", qf9.class);
            c("live", DI.APP_INFO_NAME, sf9.class);
            c("live", DI.PLAYER.DU_MEDIA, ch9.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, mg9.class);
            c("live", DI.EXT.EXT_LIVE_LOG, tg9.class);
            c("live", DI.FOLLOW_STATUS, ig9.class);
            c("live", DI.LIGHTBROWSER_VIEW, xf9.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, rh9.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, gg9.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, og9.class);
            c("live", DI.LIVE_LOCATION, rg9.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, uf9.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, dh9.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, eg9.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, fg9.class);
            c("live", DI.LIVE_YY_RTC, ph9.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", vg9.class);
            c("live", DI.PAY_CHANNEL, ag9.class);
            c("live", DI.LIVE_PLAYER, kh9.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, nh9.class);
            c("live", "share", vh9.class);
            c("live", DI.TB.SHARE_CHANNEL, th9.class);
            c("live", DI.THIRD_PART_ACCOUNT, xh9.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, yh9.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ai9.class);
            c("live", "toast", ci9.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, k68.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, i68.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, m68.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, o68.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, yg9.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", kg9.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", ina.class);
            c("module_home", "SpriteStateService", dna.class);
            c("nad.business", "rewardVideoLpTaskCenter", mk0.class);
            c("nad.core", "adRequester", ay0.class);
            c("nad.core", "browserDownload", tg0.class);
            c("nad.core", "cmd", t46.class);
            c("nad.core", "config", u46.class);
            c("nad.core", "crius", fg0.class);
            c("nad.core", "cyber", g36.class);
            c("nad.core", "deviceInfo.bag", e.class);
            c("nad.core", "deviceInfoInner", jd0.class);
            c("nad.core", "downloadCreator", l56.class);
            c("nad.core", "eventbus", ri0.class);
            c("nad.core", "exp", gj0.class);
            c("nad.core", "ipdx", md0.class);
            c("nad.core", "loadImage", sc0.class);
            c("nad.core", "loadVideo", fu0.class);
            c("nad.core", "maxUI", w46.class);
            c("nad.core", "nativeCookieMgr", r51.class);
            c("nad.core", "navBarTool", z46.class);
            c("nad.core", "splash.config", a56.class);
            c("nad.core", "splash.host", b56.class);
            c("nad.core", "thirdService", x46.class);
            c("nad.core", "toast", y46.class);
            c("nad.core", "uad", c56.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", kw6.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", fn5.class);
            c("tbadkcore", "tbadkcore", l16.class);
            c("tieba.core", "eventbus", ab9.class);
            c("tieba.core", "eventbus.autorelease", za9.class);
            c("ubc", UBC.TAG, jlb.class);
            c("voyager", "upload", fub.class);
            c("yaLog", "yaLogConfig", evb.class);
        }
    }
}
