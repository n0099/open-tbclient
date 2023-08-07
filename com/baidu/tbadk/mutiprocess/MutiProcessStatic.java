package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.HybridNotify.HybridNotifyEvent;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.aiApply.AICapacityMainProcessToastEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.face.EmotionReloadEvent;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.tbadk.mutiprocess.live.ImageViewLiveEvent;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.mutiprocess.live.LiveStartClickDataEvent;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.mutiprocess.push.PushRecevierEvent;
import com.baidu.tbadk.mutiprocess.share.InitWeiboSdkEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.tbadk.mutiprocess.urlmanager.UrlDealEvent;
import com.baidu.tieba.aq5;
import com.baidu.tieba.cp5;
import com.baidu.tieba.dp5;
import com.baidu.tieba.fp5;
import com.baidu.tieba.gp5;
import com.baidu.tieba.hp5;
import com.baidu.tieba.ip5;
import com.baidu.tieba.jp5;
import com.baidu.tieba.kp5;
import com.baidu.tieba.lp5;
import com.baidu.tieba.mp5;
import com.baidu.tieba.np5;
import com.baidu.tieba.op5;
import com.baidu.tieba.pp5;
import com.baidu.tieba.qp5;
import com.baidu.tieba.rp5;
import com.baidu.tieba.sp5;
import com.baidu.tieba.to5;
import com.baidu.tieba.tp5;
import com.baidu.tieba.up5;
import com.baidu.tieba.vp5;
import com.baidu.tieba.xp5;
import com.baidu.tieba.zp5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MutiProcessStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1526690181, "Lcom/baidu/tbadk/mutiprocess/MutiProcessStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1526690181, "Lcom/baidu/tbadk/mutiprocess/MutiProcessStatic;");
                return;
            }
        }
        a();
    }

    public MutiProcessStatic() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                MutiProcessManager mutiProcessManager = MutiProcessManager.getInstance();
                mutiProcessManager.registerForeverListener(AgreeEvent.class, new cp5());
                mutiProcessManager.registerForeverListener(MissionEvent.class, new qp5());
                mutiProcessManager.registerForeverListener(CompeteTaskEvent.class, new gp5());
                mutiProcessManager.registerForeverListener(ShareEvent.class, new up5());
                mutiProcessManager.registerForeverListener(HistoryEvent.class, new kp5());
                mutiProcessManager.registerForeverListener(BackBaiduBoxViewEvent.class, new fp5());
                mutiProcessManager.registerForeverListener(ShowReplyInPbEvent.class, new vp5());
                mutiProcessManager.registerForeverListener(LocationEvent.class, new pp5());
                mutiProcessManager.registerForeverListener(PrePageKeyEvent.class, new rp5());
                mutiProcessManager.registerForeverListener(CurrentPageTypeEvent.class, new hp5());
                mutiProcessManager.registerForeverListener(ImageFpsEvent.class, new jp5());
                mutiProcessManager.registerForeverListener(SoLoaderEvent.class, new xp5());
                mutiProcessManager.registerForeverListener(PushRecevierEvent.class, new sp5());
                mutiProcessManager.registerForeverListener(ThirdPartyActivityLifecycleEvent.class, new zp5());
                mutiProcessManager.registerForeverListener(EmotionReloadEvent.class, new ip5());
                mutiProcessManager.registerForeverListener(LiveRemindDataEvent.class, new np5());
                mutiProcessManager.registerForeverListener(LiveStartClickDataEvent.class, new op5());
                mutiProcessManager.registerForeverListener(HotEvent.class, new lp5());
                mutiProcessManager.registerForeverListener(ImageViewLiveEvent.class, new mp5());
                mutiProcessManager.registerForeverListener(UrlDealEvent.class, new aq5());
                mutiProcessManager.registerForeverListener(InitWeiboSdkEvent.class, new tp5());
                mutiProcessManager.registerForeverListener(HybridNotifyEvent.class, new to5());
                mutiProcessManager.registerForeverListener(AICapacityMainProcessToastEvent.class, new dp5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
