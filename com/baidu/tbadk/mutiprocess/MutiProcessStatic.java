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
import com.baidu.tieba.bm5;
import com.baidu.tieba.dm5;
import com.baidu.tieba.el5;
import com.baidu.tieba.em5;
import com.baidu.tieba.il5;
import com.baidu.tieba.jl5;
import com.baidu.tieba.kl5;
import com.baidu.tieba.ll5;
import com.baidu.tieba.ml5;
import com.baidu.tieba.nl5;
import com.baidu.tieba.ol5;
import com.baidu.tieba.pl5;
import com.baidu.tieba.ql5;
import com.baidu.tieba.rl5;
import com.baidu.tieba.sl5;
import com.baidu.tieba.tl5;
import com.baidu.tieba.ul5;
import com.baidu.tieba.vl5;
import com.baidu.tieba.wl5;
import com.baidu.tieba.xl5;
import com.baidu.tieba.yl5;
import com.baidu.tieba.zl5;
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
                el5 f = el5.f();
                f.l(AgreeEvent.class, new il5());
                f.l(MissionEvent.class, new ul5());
                f.l(CompeteTaskEvent.class, new kl5());
                f.l(ShareEvent.class, new yl5());
                f.l(HistoryEvent.class, new ol5());
                f.l(BackBaiduBoxViewEvent.class, new jl5());
                f.l(ShowReplyInPbEvent.class, new zl5());
                f.l(LocationEvent.class, new tl5());
                f.l(PrePageKeyEvent.class, new vl5());
                f.l(CurrentPageTypeEvent.class, new ll5());
                f.l(ImageFpsEvent.class, new nl5());
                f.l(SoLoaderEvent.class, new bm5());
                f.l(PushRecevierEvent.class, new wl5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new dm5());
                f.l(EmotionReloadEvent.class, new ml5());
                f.l(LiveRemindDataEvent.class, new rl5());
                f.l(LiveStartClickDataEvent.class, new sl5());
                f.l(HotEvent.class, new pl5());
                f.l(ImageViewLiveEvent.class, new ql5());
                f.l(UrlDealEvent.class, new em5());
                f.l(InitWeiboSdkEvent.class, new xl5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
