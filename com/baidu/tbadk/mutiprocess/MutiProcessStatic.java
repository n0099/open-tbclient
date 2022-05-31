package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.face.EmotionReloadEvent;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.mutiprocess.replay.ReplayEvent;
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
import com.repackage.a55;
import com.repackage.e55;
import com.repackage.f55;
import com.repackage.g55;
import com.repackage.h55;
import com.repackage.i55;
import com.repackage.j55;
import com.repackage.k55;
import com.repackage.l55;
import com.repackage.m55;
import com.repackage.n55;
import com.repackage.o55;
import com.repackage.p55;
import com.repackage.q55;
import com.repackage.s55;
import com.repackage.t55;
import com.repackage.u55;
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
                a55 f = a55.f();
                f.l(AgreeEvent.class, new e55());
                f.l(MissionEvent.class, new m55());
                f.l(CompeteTaskEvent.class, new g55());
                f.l(ShareEvent.class, new p55());
                f.l(HistoryEvent.class, new k55());
                f.l(BackBaiduBoxViewEvent.class, new f55());
                f.l(SyncDataEvent.class, new t55());
                f.l(ShowReplyInPbEvent.class, new q55());
                f.l(LocationEvent.class, new l55());
                f.l(PrePageKeyEvent.class, new n55());
                f.l(CurrentPageTypeEvent.class, new h55());
                f.l(ImageFpsEvent.class, new j55());
                f.l(SoLoaderEvent.class, new s55());
                f.l(ReplayEvent.class, new o55());
                f.l(ThirdPartyActivityLifecycleEvent.class, new u55());
                f.l(EmotionReloadEvent.class, new i55());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
