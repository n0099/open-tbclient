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
import com.baidu.tieba.bk5;
import com.baidu.tieba.cj5;
import com.baidu.tieba.ck5;
import com.baidu.tieba.gj5;
import com.baidu.tieba.hj5;
import com.baidu.tieba.ij5;
import com.baidu.tieba.jj5;
import com.baidu.tieba.kj5;
import com.baidu.tieba.lj5;
import com.baidu.tieba.mj5;
import com.baidu.tieba.nj5;
import com.baidu.tieba.oj5;
import com.baidu.tieba.pj5;
import com.baidu.tieba.qj5;
import com.baidu.tieba.rj5;
import com.baidu.tieba.sj5;
import com.baidu.tieba.tj5;
import com.baidu.tieba.uj5;
import com.baidu.tieba.vj5;
import com.baidu.tieba.wj5;
import com.baidu.tieba.xj5;
import com.baidu.tieba.zj5;
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
                cj5 f = cj5.f();
                f.l(AgreeEvent.class, new gj5());
                f.l(MissionEvent.class, new sj5());
                f.l(CompeteTaskEvent.class, new ij5());
                f.l(ShareEvent.class, new wj5());
                f.l(HistoryEvent.class, new mj5());
                f.l(BackBaiduBoxViewEvent.class, new hj5());
                f.l(ShowReplyInPbEvent.class, new xj5());
                f.l(LocationEvent.class, new rj5());
                f.l(PrePageKeyEvent.class, new tj5());
                f.l(CurrentPageTypeEvent.class, new jj5());
                f.l(ImageFpsEvent.class, new lj5());
                f.l(SoLoaderEvent.class, new zj5());
                f.l(PushRecevierEvent.class, new uj5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new bk5());
                f.l(EmotionReloadEvent.class, new kj5());
                f.l(LiveRemindDataEvent.class, new pj5());
                f.l(LiveStartClickDataEvent.class, new qj5());
                f.l(HotEvent.class, new nj5());
                f.l(ImageViewLiveEvent.class, new oj5());
                f.l(UrlDealEvent.class, new ck5());
                f.l(InitWeiboSdkEvent.class, new vj5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
