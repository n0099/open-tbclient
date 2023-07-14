package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.HybridNotify.HybridNotifyEvent;
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
import com.baidu.tieba.ar5;
import com.baidu.tieba.br5;
import com.baidu.tieba.cr5;
import com.baidu.tieba.dr5;
import com.baidu.tieba.er5;
import com.baidu.tieba.fr5;
import com.baidu.tieba.gr5;
import com.baidu.tieba.hr5;
import com.baidu.tieba.ir5;
import com.baidu.tieba.jr5;
import com.baidu.tieba.kr5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.mr5;
import com.baidu.tieba.nr5;
import com.baidu.tieba.oq5;
import com.baidu.tieba.or5;
import com.baidu.tieba.pr5;
import com.baidu.tieba.qr5;
import com.baidu.tieba.rr5;
import com.baidu.tieba.tr5;
import com.baidu.tieba.vr5;
import com.baidu.tieba.wq5;
import com.baidu.tieba.wr5;
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
                wq5 f = wq5.f();
                f.l(AgreeEvent.class, new ar5());
                f.l(MissionEvent.class, new mr5());
                f.l(CompeteTaskEvent.class, new cr5());
                f.l(ShareEvent.class, new qr5());
                f.l(HistoryEvent.class, new gr5());
                f.l(BackBaiduBoxViewEvent.class, new br5());
                f.l(ShowReplyInPbEvent.class, new rr5());
                f.l(LocationEvent.class, new lr5());
                f.l(PrePageKeyEvent.class, new nr5());
                f.l(CurrentPageTypeEvent.class, new dr5());
                f.l(ImageFpsEvent.class, new fr5());
                f.l(SoLoaderEvent.class, new tr5());
                f.l(PushRecevierEvent.class, new or5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new vr5());
                f.l(EmotionReloadEvent.class, new er5());
                f.l(LiveRemindDataEvent.class, new jr5());
                f.l(LiveStartClickDataEvent.class, new kr5());
                f.l(HotEvent.class, new hr5());
                f.l(ImageViewLiveEvent.class, new ir5());
                f.l(UrlDealEvent.class, new wr5());
                f.l(InitWeiboSdkEvent.class, new pr5());
                f.l(HybridNotifyEvent.class, new oq5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
