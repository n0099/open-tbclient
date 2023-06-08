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
import com.baidu.tieba.aq5;
import com.baidu.tieba.bq5;
import com.baidu.tieba.cq5;
import com.baidu.tieba.dq5;
import com.baidu.tieba.fq5;
import com.baidu.tieba.hq5;
import com.baidu.tieba.ip5;
import com.baidu.tieba.iq5;
import com.baidu.tieba.mp5;
import com.baidu.tieba.np5;
import com.baidu.tieba.op5;
import com.baidu.tieba.pp5;
import com.baidu.tieba.qp5;
import com.baidu.tieba.rp5;
import com.baidu.tieba.sp5;
import com.baidu.tieba.tp5;
import com.baidu.tieba.up5;
import com.baidu.tieba.vp5;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xp5;
import com.baidu.tieba.yp5;
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
                ip5 f = ip5.f();
                f.l(AgreeEvent.class, new mp5());
                f.l(MissionEvent.class, new yp5());
                f.l(CompeteTaskEvent.class, new op5());
                f.l(ShareEvent.class, new cq5());
                f.l(HistoryEvent.class, new sp5());
                f.l(BackBaiduBoxViewEvent.class, new np5());
                f.l(ShowReplyInPbEvent.class, new dq5());
                f.l(LocationEvent.class, new xp5());
                f.l(PrePageKeyEvent.class, new zp5());
                f.l(CurrentPageTypeEvent.class, new pp5());
                f.l(ImageFpsEvent.class, new rp5());
                f.l(SoLoaderEvent.class, new fq5());
                f.l(PushRecevierEvent.class, new aq5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new hq5());
                f.l(EmotionReloadEvent.class, new qp5());
                f.l(LiveRemindDataEvent.class, new vp5());
                f.l(LiveStartClickDataEvent.class, new wp5());
                f.l(HotEvent.class, new tp5());
                f.l(ImageViewLiveEvent.class, new up5());
                f.l(UrlDealEvent.class, new iq5());
                f.l(InitWeiboSdkEvent.class, new bq5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
