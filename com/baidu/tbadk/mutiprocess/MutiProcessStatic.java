package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.face.EmotionReloadEvent;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a85;
import com.repackage.b85;
import com.repackage.c85;
import com.repackage.d85;
import com.repackage.e85;
import com.repackage.f85;
import com.repackage.g85;
import com.repackage.i85;
import com.repackage.j85;
import com.repackage.k85;
import com.repackage.o75;
import com.repackage.s75;
import com.repackage.t75;
import com.repackage.u75;
import com.repackage.v75;
import com.repackage.w75;
import com.repackage.x75;
import com.repackage.y75;
import com.repackage.z75;
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
                o75 f = o75.f();
                f.l(AgreeEvent.class, new s75());
                f.l(MissionEvent.class, new c85());
                f.l(CompeteTaskEvent.class, new u75());
                f.l(ShareEvent.class, new f85());
                f.l(HistoryEvent.class, new y75());
                f.l(BackBaiduBoxViewEvent.class, new t75());
                f.l(SyncDataEvent.class, new j85());
                f.l(ShowReplyInPbEvent.class, new g85());
                f.l(LocationEvent.class, new b85());
                f.l(PrePageKeyEvent.class, new d85());
                f.l(CurrentPageTypeEvent.class, new v75());
                f.l(ImageFpsEvent.class, new x75());
                f.l(SoLoaderEvent.class, new i85());
                f.l(PushRecevierEvent.class, new e85());
                f.l(ThirdPartyActivityLifecycleEvent.class, new k85());
                f.l(EmotionReloadEvent.class, new w75());
                f.l(LiveRemindDataEvent.class, new z75());
                f.l(LiveStartClickDataEvent.class, new a85());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
