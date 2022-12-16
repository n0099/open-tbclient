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
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.tbadk.mutiprocess.urlmanager.UrlDealEvent;
import com.baidu.tieba.ad5;
import com.baidu.tieba.bd5;
import com.baidu.tieba.cd5;
import com.baidu.tieba.dd5;
import com.baidu.tieba.ed5;
import com.baidu.tieba.fd5;
import com.baidu.tieba.gd5;
import com.baidu.tieba.id5;
import com.baidu.tieba.kd5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.mc5;
import com.baidu.tieba.qc5;
import com.baidu.tieba.rc5;
import com.baidu.tieba.sc5;
import com.baidu.tieba.tc5;
import com.baidu.tieba.uc5;
import com.baidu.tieba.vc5;
import com.baidu.tieba.wc5;
import com.baidu.tieba.xc5;
import com.baidu.tieba.yc5;
import com.baidu.tieba.zc5;
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
                mc5 f = mc5.f();
                f.l(AgreeEvent.class, new qc5());
                f.l(MissionEvent.class, new cd5());
                f.l(CompeteTaskEvent.class, new sc5());
                f.l(ShareEvent.class, new fd5());
                f.l(HistoryEvent.class, new wc5());
                f.l(BackBaiduBoxViewEvent.class, new rc5());
                f.l(ShowReplyInPbEvent.class, new gd5());
                f.l(LocationEvent.class, new bd5());
                f.l(PrePageKeyEvent.class, new dd5());
                f.l(CurrentPageTypeEvent.class, new tc5());
                f.l(ImageFpsEvent.class, new vc5());
                f.l(SoLoaderEvent.class, new id5());
                f.l(PushRecevierEvent.class, new ed5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new kd5());
                f.l(EmotionReloadEvent.class, new uc5());
                f.l(LiveRemindDataEvent.class, new zc5());
                f.l(LiveStartClickDataEvent.class, new ad5());
                f.l(HotEvent.class, new xc5());
                f.l(ImageViewLiveEvent.class, new yc5());
                f.l(UrlDealEvent.class, new ld5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
