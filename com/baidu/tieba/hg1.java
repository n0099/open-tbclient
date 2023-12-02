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
/* loaded from: classes6.dex */
public class hg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, gg1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947822647, "Lcom/baidu/tieba/hg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947822647, "Lcom/baidu/tieba/hg1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public hg1() {
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
            gg1<?> gg1Var = a.get(serviceReference);
            if (gg1Var != null) {
                return (T) gg1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, gg1<T> gg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, gg1Var) == null) {
            a.put(serviceReference, gg1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends gg1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", hh9.class);
            c("AlaLiveSdk", "IMSdkServicePerson", ih9.class);
            c("AlaSquare", "FrsLiveTabService", a86.class);
            c("AlaSquare", "SecondFloorService", y96.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", lh6.class);
            c("Frames", "JsPromptBridge", fh6.class);
            c("Frs", "FrsService", vs7.class);
            c("Frs", "FrsVisitedInfoService", av6.class);
            c("HotTopic", "HotTopicRequest", i06.class);
            c("IM", "IMessageCenterService", wa9.class);
            c("ImMessageCenter", "ChatBoxDialogService", r19.class);
            c("ImMessageCenter", "ChatFloatEntranceService", g39.class);
            c("ImMessageCenter", "ChatMessageDispatchService", u19.class);
            c("ImMessageCenter", "GroupChatService", m19.class);
            c("MessageCenter", "MessageCenterAIBotService", va9.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", hk6.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", dh6.class);
            c(WebView.LOGTAG, "IPrefetchManager", bh6.class);
            c(WebView.LOGTAG, "IPrerenderManager", ch6.class);
            c(WebView.LOGTAG, "IWebViewDebug", eh6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", wg6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatHistoryListService", ds8.class);
            c("aibot", "AibotChatService", ar8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", fv6.class);
            c("download", "DOWNLOAD", ox.class);
            c("download", "db", kx.class);
            c("feed", "component.resolver", mo6.class);
            c("feed", "widget.resolver", no6.class);
            c("live", DI.AB_NAME, wj9.class);
            c("live", "account", kj9.class);
            c("live", DI.APP_INFO_NAME, mj9.class);
            c("live", DI.PLAYER.DU_MEDIA, wk9.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, gk9.class);
            c("live", DI.EXT.EXT_LIVE_LOG, nk9.class);
            c("live", DI.FOLLOW_STATUS, ck9.class);
            c("live", DI.LIGHTBROWSER_VIEW, rj9.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, ll9.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, ak9.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, ik9.class);
            c("live", DI.LIVE_LOCATION, lk9.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, oj9.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, xk9.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, yj9.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, zj9.class);
            c("live", DI.LIVE_YY_RTC, jl9.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", pk9.class);
            c("live", DI.PAY_CHANNEL, uj9.class);
            c("live", DI.LIVE_PLAYER, el9.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, hl9.class);
            c("live", "share", pl9.class);
            c("live", DI.TB.SHARE_CHANNEL, nl9.class);
            c("live", DI.THIRD_PART_ACCOUNT, rl9.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, sl9.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, ul9.class);
            c("live", "toast", wl9.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, i98.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, g98.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, k98.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, m98.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, sk9.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", ek9.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", asa.class);
            c("module_home", "SpriteStateService", vra.class);
            c("nad.business", "rewardVideoLpTaskCenter", nk0.class);
            c("nad.core", "adRequester", dy0.class);
            c("nad.core", "browserDownload", ug0.class);
            c("nad.core", "cmd", f56.class);
            c("nad.core", "config", g56.class);
            c("nad.core", "crius", gg0.class);
            c("nad.core", "cyber", r36.class);
            c("nad.core", "deviceInfo.bag", e.class);
            c("nad.core", "deviceInfoInner", kd0.class);
            c("nad.core", "downloadCreator", x56.class);
            c("nad.core", "eventbus", si0.class);
            c("nad.core", "exp", hj0.class);
            c("nad.core", "ipdx", nd0.class);
            c("nad.core", "loadImage", tc0.class);
            c("nad.core", "loadVideo", iu0.class);
            c("nad.core", "maxUI", i56.class);
            c("nad.core", "nativeCookieMgr", u51.class);
            c("nad.core", "navBarTool", l56.class);
            c("nad.core", "splash.config", m56.class);
            c("nad.core", "splash.host", n56.class);
            c("nad.core", "thirdService", j56.class);
            c("nad.core", "toast", k56.class);
            c("nad.core", "uad", o56.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", yw6.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", rn5.class);
            c("tbadkcore", "tbadkcore", w16.class);
            c("tieba.core", "eventbus", ue9.class);
            c("tieba.core", "eventbus.autorelease", te9.class);
            c("ubc", UBC.TAG, eqb.class);
            c("voyager", "upload", azb.class);
            c("yaLog", "yaLogConfig", zzb.class);
        }
    }
}
