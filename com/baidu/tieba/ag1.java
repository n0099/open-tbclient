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
public class ag1 {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentHashMap<ServiceReference, zf1<?>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947614110, "Lcom/baidu/tieba/ag1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947614110, "Lcom/baidu/tieba/ag1;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        d();
    }

    public ag1() {
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
            zf1<?> zf1Var = a.get(serviceReference);
            if (zf1Var != null) {
                return (T) zf1Var.getService();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> void b(ServiceReference serviceReference, zf1<T> zf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, serviceReference, zf1Var) == null) {
            a.put(serviceReference, zf1Var);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends zf1<T>> cls) {
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
            c("AlaLiveSdk", "IMSdkService", kn7.class);
            c("AlaSquare", "SecondFloorService", fy5.class);
            c("Frs", "FrsService", rk6.class);
            c("HotTopic", "HotTopicRequest", lp5.class);
            c("ImMessageCenter", "ChatBoxDialogService", og7.class);
            c("ImMessageCenter", "ChatFloatEntranceService", kh7.class);
            c("ImMessageCenter", "GroupChatService", mg7.class);
            c("abtest", "service", AbTestServiceFetcher.class);
            c("behavior-api", "behavior-api", BehaviorServiceFetcher.class);
            c("device_score", "DEVICE_SCORE", DeviceScoreFetcher.class);
            c("device_score", "DEVICE_SCORE_COLLECT", DeviceScoreCollectFetcher.class);
            c("device_score", "DEVICE_SCORE_CONFIG", DeviceScoreConfigFetcher.class);
            c("live", DI.AB_NAME, qp7.class);
            c("live", DI.ACCOUNT, fp7.class);
            c("live", DI.APP_INFO_NAME, hp7.class);
            c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, yp7.class);
            c("live", DI.EXT.EXT_LIVE_LOG, fq7.class);
            c("live", DI.FOLLOW_STATUS, wp7.class);
            c("live", DI.LIGHTBROWSER_VIEW, mp7.class);
            c("live", DI.LIVE_CUSTOM_SETTINGS, br7.class);
            c("live", DI.LIVE_EVENT_DISPATCHER, up7.class);
            c("live", DI.LIVE_LIKE, aq7.class);
            c("live", DI.LIVE_LOCATION, dq7.class);
            c("live", DI.LIVE_REAL_AUTH, jp7.class);
            c("live", DI.LIVE_SHOW_VIDEO_PLAYER, nq7.class);
            c("live", DI.LIVE_USER_SECURITY_BEHAVIOR, sp7.class);
            c("live", DI.LIVE_USER_SECURITY_DEVICE_INFO, tp7.class);
            c("live", DI.MINI_SHELL.MEDIA_2_YY, Media2YYServiceFetcher.class);
            c("live", "multi_plugin", MultiPluginManagerServiceFetcher.class);
            c("live", "net", hq7.class);
            c("live", DI.PAY_CHANNEL, op7.class);
            c("live", DI.LIVE_PLAYER, uq7.class);
            c("live", DI.MINI_SHELL.PLUGIN_MANAGER, PluginInvokeServiceFetcher.class);
            c("live", DI.LIVE_PRE_START_PLAYER, LivePreStartPlayServiceFetcher.class);
            c("live", DI.ROUTER_NAME, zq7.class);
            c("live", "share", fr7.class);
            c("live", DI.TB.SHARE_CHANNEL, dr7.class);
            c("live", DI.THIRD_PART_ACCOUNT, hr7.class);
            c("live", DI.YY.THIRD_PART_ALI_RECHARGE, ir7.class);
            c("live", DI.YY.THIRD_PART_WX_RECHARGE, kr7.class);
            c("live", DI.TOAST_NAME, mr7.class);
            c("live", DI.MINI_SHELL.YY_2_MEDIA, YY2MediaServiceFetcher.class);
            c("live", DI.YY.YY_MULTI_PLUGIN_PROGRESS, YYPluginProgressInvokeServiceFetcher.class);
            c("live", DI.YYPAY.YY_PAY, kq7.class);
            c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
            c("logsystem", "exceptionhandler", ExceptionHandlerServiceFetcher.class);
            c("nad.business", "rewardVideoLpTaskCenter", vn0.class);
            c("nad.core", "adRequester", m01.class);
            c("nad.core", "browserDownload", jk0.class);
            c("nad.core", "cmd", st5.class);
            c("nad.core", "config", tt5.class);
            c("nad.core", "crius", vj0.class);
            c("nad.core", "deviceInfo.bag", b.class);
            c("nad.core", "deviceInfoInner", gh0.class);
            c("nad.core", "eventbus", am0.class);
            c("nad.core", "exp", pm0.class);
            c("nad.core", "ipdx", jh0.class);
            c("nad.core", "loadImage", qg0.class);
            c("nad.core", "loadVideo", jw0.class);
            c("nad.core", "maxUI", vt5.class);
            c("nad.core", "navBarTool", xt5.class);
            c("nad.core", "splash.config", yt5.class);
            c("nad.core", "splash.host", zt5.class);
            c("nad.core", "thirdService", wt5.class);
            c("nad.core", "uad", au5.class);
            c("speed", "runtime", SpeedRuntimeProvider.class);
            c("tbBaseEmotion", "EmotionService", jb6.class);
            c("tbadkcore", "IHttpsExperiment", HttpsExperimentFetcher.class);
            c("tbadkcore", "INetExperiment", NetExperimentFetcher.class);
            c("tbadkcore", "ISoProcess", hd5.class);
            c("tbadkcore", "tbadkcore", zq5.class);
            c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, zf9.class);
            c("voyager", StatConstants.VALUE_TYPE_UPLOAD, qo9.class);
            c("yaLog", "yaLogConfig", np9.class);
        }
    }
}
