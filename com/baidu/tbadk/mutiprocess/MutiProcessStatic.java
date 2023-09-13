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
import com.baidu.tieba.ar5;
import com.baidu.tieba.br5;
import com.baidu.tieba.cr5;
import com.baidu.tieba.dq5;
import com.baidu.tieba.dr5;
import com.baidu.tieba.er5;
import com.baidu.tieba.fr5;
import com.baidu.tieba.hr5;
import com.baidu.tieba.jr5;
import com.baidu.tieba.kr5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.mq5;
import com.baidu.tieba.nq5;
import com.baidu.tieba.pq5;
import com.baidu.tieba.qq5;
import com.baidu.tieba.rq5;
import com.baidu.tieba.sq5;
import com.baidu.tieba.tq5;
import com.baidu.tieba.uq5;
import com.baidu.tieba.vq5;
import com.baidu.tieba.wq5;
import com.baidu.tieba.xq5;
import com.baidu.tieba.yq5;
import com.baidu.tieba.zq5;
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
                mutiProcessManager.registerForeverListener(AgreeEvent.class, new mq5());
                mutiProcessManager.registerForeverListener(MissionEvent.class, new ar5());
                mutiProcessManager.registerForeverListener(CompeteTaskEvent.class, new qq5());
                mutiProcessManager.registerForeverListener(ShareEvent.class, new er5());
                mutiProcessManager.registerForeverListener(HistoryEvent.class, new uq5());
                mutiProcessManager.registerForeverListener(BackBaiduBoxViewEvent.class, new pq5());
                mutiProcessManager.registerForeverListener(ShowReplyInPbEvent.class, new fr5());
                mutiProcessManager.registerForeverListener(LocationEvent.class, new zq5());
                mutiProcessManager.registerForeverListener(PrePageKeyEvent.class, new br5());
                mutiProcessManager.registerForeverListener(CurrentPageTypeEvent.class, new rq5());
                mutiProcessManager.registerForeverListener(ImageFpsEvent.class, new tq5());
                mutiProcessManager.registerForeverListener(SoLoaderEvent.class, new hr5());
                mutiProcessManager.registerForeverListener(PushRecevierEvent.class, new cr5());
                mutiProcessManager.registerForeverListener(EmotionReloadEvent.class, new sq5());
                mutiProcessManager.registerForeverListener(LiveRemindDataEvent.class, new xq5());
                mutiProcessManager.registerForeverListener(LiveStartClickDataEvent.class, new yq5());
                mutiProcessManager.registerForeverListener(HotEvent.class, new vq5());
                mutiProcessManager.registerForeverListener(TopNotifyEvent.class, new jr5());
                mutiProcessManager.registerForeverListener(ImageViewLiveEvent.class, new wq5());
                mutiProcessManager.registerForeverListener(UrlDealEvent.class, new kr5());
                mutiProcessManager.registerForeverListener(InitWeiboSdkEvent.class, new dr5());
                mutiProcessManager.registerForeverListener(HybridNotifyEvent.class, new dq5());
                mutiProcessManager.registerForeverListener(AICapacityMainProcessToastEvent.class, new nq5());
                mutiProcessManager.registerForeverListener(NewWritePageStateEvent.class, new lr5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
