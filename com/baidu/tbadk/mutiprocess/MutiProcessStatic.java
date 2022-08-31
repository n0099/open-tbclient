package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.face.EmotionReloadEvent;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.mutiprocess.live.LiveStartClickDataEvent;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.mutiprocess.push.PushRecevierEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.tieba.a85;
import com.baidu.tieba.b85;
import com.baidu.tieba.c85;
import com.baidu.tieba.d85;
import com.baidu.tieba.e85;
import com.baidu.tieba.f85;
import com.baidu.tieba.g85;
import com.baidu.tieba.h85;
import com.baidu.tieba.i85;
import com.baidu.tieba.j85;
import com.baidu.tieba.k85;
import com.baidu.tieba.l85;
import com.baidu.tieba.n85;
import com.baidu.tieba.o85;
import com.baidu.tieba.p85;
import com.baidu.tieba.s75;
import com.baidu.tieba.w75;
import com.baidu.tieba.x75;
import com.baidu.tieba.y75;
import com.baidu.tieba.z75;
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
                s75 f = s75.f();
                f.l(AgreeEvent.class, new w75());
                f.l(MissionEvent.class, new h85());
                f.l(CompeteTaskEvent.class, new y75());
                f.l(ShareEvent.class, new k85());
                f.l(HistoryEvent.class, new c85());
                f.l(BackBaiduBoxViewEvent.class, new x75());
                f.l(SyncDataEvent.class, new o85());
                f.l(ShowReplyInPbEvent.class, new l85());
                f.l(LocationEvent.class, new g85());
                f.l(PrePageKeyEvent.class, new i85());
                f.l(CurrentPageTypeEvent.class, new z75());
                f.l(ImageFpsEvent.class, new b85());
                f.l(SoLoaderEvent.class, new n85());
                f.l(PushRecevierEvent.class, new j85());
                f.l(ThirdPartyActivityLifecycleEvent.class, new p85());
                f.l(EmotionReloadEvent.class, new a85());
                f.l(LiveRemindDataEvent.class, new e85());
                f.l(LiveStartClickDataEvent.class, new f85());
                f.l(HotEvent.class, new d85());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
