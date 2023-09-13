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
import com.baidu.tbadk.abtest.helper.HttpsExperimentFetcher;
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
public class dl1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, cl1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947708288, "Lcom/baidu/tieba/dl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947708288, "Lcom/baidu/tieba/dl1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public dl1() {
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
            cl1<?> cl1Var = a.get(serviceReference);
            if (cl1Var != null) {
                return (T) cl1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, cl1<T> cl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, cl1Var) == null) {
            a.put(serviceReference, cl1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends cl1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", m49.class);
            c("AlaLiveSdk", "IMSdkServicePerson", n49.class);
            c("AlaSquare", "SecondFloorService", dd6.class);
            c(IFetchTask.NAME_SPACE, "report", FetchTaskFetcher.class);
            c("Frames", "ISafetyConfig", qk6.class);
            c("Frames", "JsPromptBridge", kk6.class);
            c("Frs", "FrsService", ui7.class);
            c("Frs", "FrsVisitedInfoService", gy6.class);
            c("HotTopic", "HotTopicRequest", s36.class);
            c("IM", "IMessageCenterService", zx8.class);
            c("ImMessageCenter", "ChatBoxDialogService", pl8.class);
            c("ImMessageCenter", "ChatFloatEntranceService", hn8.class);
            c("ImMessageCenter", "GroupChatService", ml8.class);
            c("MessageCenter", "MessageCenterAIBotService", yx8.class);
            c(WebViewFactoryProvider.SETTING_MONITOR, "IMonitorBehavior", kn6.class);
            c("UniKVTest", "UniKVTest", UniKVTestFetcher.class);
            c(WebView.LOGTAG, "EMManagerProvider", ik6.class);
            c(WebView.LOGTAG, "IPrefetchManager", gk6.class);
            c(WebView.LOGTAG, "IPrerenderManager", hk6.class);
            c(WebView.LOGTAG, "IWebViewDebug", jk6.class);
            c(WebView.LOGTAG, "IWebViewFactoryService", bk6.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("aibot", "AibotChatService", pc8.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("download", "DOWNLOAD", ly6.class);
            c("download", "DOWNLOAD", a20.class);
            c("download", "db", w10.class);
            c("feed", "component.resolver", lr6.class);
            c("feed", "widget.resolver", mr6.class);
            c("live", DI.AB_NAME, b79.class);
            c("live", "account", p69.class);
            c("live", DI.APP_INFO_NAME, r69.class);
            c("live", DI.PLAYER.DU_MEDIA, b89.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, l79.class);
            c("live", DI.EXT.EXT_LIVE_LOG, s79.class);
            c("live", DI.FOLLOW_STATUS, h79.class);
            c("live", DI.LIGHTBROWSER_VIEW, w69.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, q89.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, f79.class);
            c("live", DI.LIVE_INSERT_VIDEO, VideoInsertLiveServiceFetcher.class);
            c("live", DI.LIVE_LIKE, n79.class);
            c("live", DI.LIVE_LOCATION, q79.class);
            c("live", DI.LIVE_PLAY_URL, LivePlayUrlServiceFetcher.class);
            c("live", DI.LIVE_REAL_AUTH, t69.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, c89.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, d79.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, e79.class);
            c("live", DI.LIVE_YY_RTC, o89.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", u79.class);
            c("live", DI.PAY_CHANNEL, z69.class);
            c("live", DI.LIVE_PLAYER, j89.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, m89.class);
            c("live", "share", u89.class);
            c("live", DI.TB.SHARE_CHANNEL, s89.class);
            c("live", DI.THIRD_PART_ACCOUNT, w89.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, x89.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, z89.class);
            c("live", "toast", b99.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_GAMEASSIST_DXM_RECHARGE, bz7.class);
            c("live", DI.YY.YY_GAMEASSIST_HOST_INFO, zy7.class);
            c("live", DI.YY.YY_GAMEASSIST_MODIFY_PWD, dz7.class);
            c("live", DI.YY.YY_GAMEASSIST_PERSMISSION, fz7.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, x79.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c(com.baidu.searchbox.live.game.interfaces.DI.MODULE_NAME, "common", j79.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("module_home", "SpriteResourceService", gda.class);
            c("module_home", "SpriteStateService", bda.class);
            c("nad.business", "rewardVideoLpTaskCenter", zo0.class);
            c("nad.core", "adRequester", x21.class);
            c("nad.core", "browserDownload", gl0.class);
            c("nad.core", "cmd", o86.class);
            c("nad.core", "config", p86.class);
            c("nad.core", "crius", sk0.class);
            c("nad.core", "cyber", b76.class);
            c("nad.core", "deviceInfo.bag", d.class);
            c("nad.core", "deviceInfoInner", wh0.class);
            c("nad.core", "downloadCreator", e96.class);
            c("nad.core", "eventbus", en0.class);
            c("nad.core", "exp", tn0.class);
            c("nad.core", "ipdx", zh0.class);
            c("nad.core", "loadImage", fh0.class);
            c("nad.core", "loadVideo", ty0.class);
            c("nad.core", "maxUI", r86.class);
            c("nad.core", "nativeCookieMgr", oa1.class);
            c("nad.core", "navBarTool", u86.class);
            c("nad.core", "splash.config", v86.class);
            c("nad.core", "splash.host", w86.class);
            c("nad.core", "thirdService", s86.class);
            c("nad.core", "toast", t86.class);
            c("nad.core", "uad", x86.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "stat", StatServiceFetcher.class);
            c(StatConstants.VALUE_FROM_RETRIEVE, "upload", UploadTaskFetcher.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", d07.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", gr5.class);
            c("tbadkcore", "tbadkcore", g56.class);
            c("tieba.core", "eventbus", z19.class);
            c("tieba.core", "eventbus.autorelease", y19.class);
            c("ubc", UBC.TAG, ubb.class);
            c("voyager", "upload", qkb.class);
            c("yaLog", "yaLogConfig", plb.class);
        }
    }
}
