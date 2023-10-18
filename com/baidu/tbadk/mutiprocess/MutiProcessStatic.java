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
import com.baidu.tbadk.mutiprocess.toptip.TopNotifyEvent;
import com.baidu.tbadk.mutiprocess.urlmanager.UrlDealEvent;
import com.baidu.tbadk.mutiprocess.write.NewWritePageStateEvent;
import com.baidu.tieba.al5;
import com.baidu.tieba.bl5;
import com.baidu.tieba.cl5;
import com.baidu.tieba.dl5;
import com.baidu.tieba.el5;
import com.baidu.tieba.fl5;
import com.baidu.tieba.gl5;
import com.baidu.tieba.hl5;
import com.baidu.tieba.il5;
import com.baidu.tieba.jl5;
import com.baidu.tieba.kk5;
import com.baidu.tieba.kl5;
import com.baidu.tieba.ll5;
import com.baidu.tieba.ml5;
import com.baidu.tieba.ol5;
import com.baidu.tieba.ql5;
import com.baidu.tieba.rl5;
import com.baidu.tieba.sl5;
import com.baidu.tieba.tk5;
import com.baidu.tieba.uk5;
import com.baidu.tieba.wk5;
import com.baidu.tieba.xk5;
import com.baidu.tieba.yk5;
import com.baidu.tieba.zk5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
                mutiProcessManager.registerForeverListener(AgreeEvent.class, new tk5());
                mutiProcessManager.registerForeverListener(MissionEvent.class, new hl5());
                mutiProcessManager.registerForeverListener(CompeteTaskEvent.class, new xk5());
                mutiProcessManager.registerForeverListener(ShareEvent.class, new ll5());
                mutiProcessManager.registerForeverListener(HistoryEvent.class, new bl5());
                mutiProcessManager.registerForeverListener(BackBaiduBoxViewEvent.class, new wk5());
                mutiProcessManager.registerForeverListener(ShowReplyInPbEvent.class, new ml5());
                mutiProcessManager.registerForeverListener(LocationEvent.class, new gl5());
                mutiProcessManager.registerForeverListener(PrePageKeyEvent.class, new il5());
                mutiProcessManager.registerForeverListener(CurrentPageTypeEvent.class, new yk5());
                mutiProcessManager.registerForeverListener(ImageFpsEvent.class, new al5());
                mutiProcessManager.registerForeverListener(SoLoaderEvent.class, new ol5());
                mutiProcessManager.registerForeverListener(PushRecevierEvent.class, new jl5());
                mutiProcessManager.registerForeverListener(EmotionReloadEvent.class, new zk5());
                mutiProcessManager.registerForeverListener(LiveRemindDataEvent.class, new el5());
                mutiProcessManager.registerForeverListener(LiveStartClickDataEvent.class, new fl5());
                mutiProcessManager.registerForeverListener(HotEvent.class, new cl5());
                mutiProcessManager.registerForeverListener(TopNotifyEvent.class, new ql5());
                mutiProcessManager.registerForeverListener(ImageViewLiveEvent.class, new dl5());
                mutiProcessManager.registerForeverListener(UrlDealEvent.class, new rl5());
                mutiProcessManager.registerForeverListener(InitWeiboSdkEvent.class, new kl5());
                mutiProcessManager.registerForeverListener(HybridNotifyEvent.class, new kk5());
                mutiProcessManager.registerForeverListener(AICapacityMainProcessToastEvent.class, new uk5());
                mutiProcessManager.registerForeverListener(NewWritePageStateEvent.class, new sl5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
