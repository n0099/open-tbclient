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
import com.baidu.tieba.ad5;
import com.baidu.tieba.ae5;
import com.baidu.tieba.ed5;
import com.baidu.tieba.fd5;
import com.baidu.tieba.gd5;
import com.baidu.tieba.hd5;
import com.baidu.tieba.id5;
import com.baidu.tieba.jd5;
import com.baidu.tieba.kd5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.md5;
import com.baidu.tieba.nd5;
import com.baidu.tieba.od5;
import com.baidu.tieba.pd5;
import com.baidu.tieba.qd5;
import com.baidu.tieba.rd5;
import com.baidu.tieba.sd5;
import com.baidu.tieba.td5;
import com.baidu.tieba.ud5;
import com.baidu.tieba.vd5;
import com.baidu.tieba.xd5;
import com.baidu.tieba.zd5;
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
                ad5 f = ad5.f();
                f.l(AgreeEvent.class, new ed5());
                f.l(MissionEvent.class, new qd5());
                f.l(CompeteTaskEvent.class, new gd5());
                f.l(ShareEvent.class, new ud5());
                f.l(HistoryEvent.class, new kd5());
                f.l(BackBaiduBoxViewEvent.class, new fd5());
                f.l(ShowReplyInPbEvent.class, new vd5());
                f.l(LocationEvent.class, new pd5());
                f.l(PrePageKeyEvent.class, new rd5());
                f.l(CurrentPageTypeEvent.class, new hd5());
                f.l(ImageFpsEvent.class, new jd5());
                f.l(SoLoaderEvent.class, new xd5());
                f.l(PushRecevierEvent.class, new sd5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new zd5());
                f.l(EmotionReloadEvent.class, new id5());
                f.l(LiveRemindDataEvent.class, new nd5());
                f.l(LiveStartClickDataEvent.class, new od5());
                f.l(HotEvent.class, new ld5());
                f.l(ImageViewLiveEvent.class, new md5());
                f.l(UrlDealEvent.class, new ae5());
                f.l(InitWeiboSdkEvent.class, new td5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
