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
import com.baidu.tieba.ak5;
import com.baidu.tieba.bk5;
import com.baidu.tieba.ck5;
import com.baidu.tieba.dk5;
import com.baidu.tieba.ek5;
import com.baidu.tieba.fk5;
import com.baidu.tieba.gk5;
import com.baidu.tieba.hk5;
import com.baidu.tieba.ik5;
import com.baidu.tieba.jk5;
import com.baidu.tieba.kk5;
import com.baidu.tieba.lk5;
import com.baidu.tieba.mk5;
import com.baidu.tieba.nk5;
import com.baidu.tieba.ok5;
import com.baidu.tieba.pk5;
import com.baidu.tieba.qk5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.uk5;
import com.baidu.tieba.vj5;
import com.baidu.tieba.vk5;
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
                vj5 f = vj5.f();
                f.l(AgreeEvent.class, new zj5());
                f.l(MissionEvent.class, new lk5());
                f.l(CompeteTaskEvent.class, new bk5());
                f.l(ShareEvent.class, new pk5());
                f.l(HistoryEvent.class, new fk5());
                f.l(BackBaiduBoxViewEvent.class, new ak5());
                f.l(ShowReplyInPbEvent.class, new qk5());
                f.l(LocationEvent.class, new kk5());
                f.l(PrePageKeyEvent.class, new mk5());
                f.l(CurrentPageTypeEvent.class, new ck5());
                f.l(ImageFpsEvent.class, new ek5());
                f.l(SoLoaderEvent.class, new sk5());
                f.l(PushRecevierEvent.class, new nk5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new uk5());
                f.l(EmotionReloadEvent.class, new dk5());
                f.l(LiveRemindDataEvent.class, new ik5());
                f.l(LiveStartClickDataEvent.class, new jk5());
                f.l(HotEvent.class, new gk5());
                f.l(ImageViewLiveEvent.class, new hk5());
                f.l(UrlDealEvent.class, new vk5());
                f.l(InitWeiboSdkEvent.class, new ok5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
