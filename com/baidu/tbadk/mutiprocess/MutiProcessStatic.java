package com.baidu.tbadk.mutiprocess;

import b.a.q0.j0.h;
import b.a.q0.j0.l.a;
import b.a.q0.j0.w.b;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                h f2 = h.f();
                f2.l(AgreeEvent.class, new a());
                f2.l(MissionEvent.class, new b.a.q0.j0.s.a());
                f2.l(CompeteTaskEvent.class, new b.a.q0.j0.n.a());
                f2.l(ShareEvent.class, new b.a.q0.j0.u.a());
                f2.l(HistoryEvent.class, new b.a.q0.j0.q.a());
                f2.l(BackBaiduBoxViewEvent.class, new b.a.q0.j0.m.a());
                f2.l(SyncDataEvent.class, new b.a.q0.j0.x.a());
                f2.l(ShowReplyInPbEvent.class, new b.a.q0.j0.v.a());
                f2.l(LocationEvent.class, new b.a.q0.j0.r.a());
                f2.l(PrePageKeyEvent.class, new b.a.q0.j0.t.a());
                f2.l(CurrentPageTypeEvent.class, new b.a.q0.j0.o.a());
                f2.l(ImageFpsEvent.class, new b.a.q0.j0.p.a());
                f2.l(SoLoaderEvent.class, new b());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
