package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
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
import com.baidu.tieba.ai5;
import com.baidu.tieba.bi5;
import com.baidu.tieba.ci5;
import com.baidu.tieba.di5;
import com.baidu.tieba.ei5;
import com.baidu.tieba.fi5;
import com.baidu.tieba.gi5;
import com.baidu.tieba.ii5;
import com.baidu.tieba.ki5;
import com.baidu.tieba.lh5;
import com.baidu.tieba.li5;
import com.baidu.tieba.ph5;
import com.baidu.tieba.qh5;
import com.baidu.tieba.rh5;
import com.baidu.tieba.sh5;
import com.baidu.tieba.th5;
import com.baidu.tieba.uh5;
import com.baidu.tieba.vh5;
import com.baidu.tieba.wh5;
import com.baidu.tieba.xh5;
import com.baidu.tieba.yh5;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
                lh5 f = lh5.f();
                f.l(AgreeEvent.class, new ph5());
                f.l(MissionEvent.class, new bi5());
                f.l(CompeteTaskEvent.class, new rh5());
                f.l(ShareEvent.class, new fi5());
                f.l(HistoryEvent.class, new vh5());
                f.l(BackBaiduBoxViewEvent.class, new qh5());
                f.l(ShowReplyInPbEvent.class, new gi5());
                f.l(LocationEvent.class, new ai5());
                f.l(PrePageKeyEvent.class, new ci5());
                f.l(CurrentPageTypeEvent.class, new sh5());
                f.l(ImageFpsEvent.class, new uh5());
                f.l(SoLoaderEvent.class, new ii5());
                f.l(PushRecevierEvent.class, new di5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new ki5());
                f.l(EmotionReloadEvent.class, new th5());
                f.l(LiveRemindDataEvent.class, new yh5());
                f.l(LiveStartClickDataEvent.class, new zh5());
                f.l(HotEvent.class, new wh5());
                f.l(ImageViewLiveEvent.class, new xh5());
                f.l(UrlDealEvent.class, new li5());
                f.l(InitWeiboSdkEvent.class, new ei5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
