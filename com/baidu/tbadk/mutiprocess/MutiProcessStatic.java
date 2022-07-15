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
import com.repackage.a75;
import com.repackage.b75;
import com.repackage.c75;
import com.repackage.d75;
import com.repackage.e75;
import com.repackage.f75;
import com.repackage.g75;
import com.repackage.h75;
import com.repackage.j75;
import com.repackage.k75;
import com.repackage.l75;
import com.repackage.r65;
import com.repackage.v65;
import com.repackage.w65;
import com.repackage.x65;
import com.repackage.y65;
import com.repackage.z65;
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
                r65 f = r65.f();
                f.l(AgreeEvent.class, new v65());
                f.l(MissionEvent.class, new d75());
                f.l(CompeteTaskEvent.class, new x65());
                f.l(ShareEvent.class, new g75());
                f.l(HistoryEvent.class, new b75());
                f.l(BackBaiduBoxViewEvent.class, new w65());
                f.l(SyncDataEvent.class, new k75());
                f.l(ShowReplyInPbEvent.class, new h75());
                f.l(LocationEvent.class, new c75());
                f.l(PrePageKeyEvent.class, new e75());
                f.l(CurrentPageTypeEvent.class, new y65());
                f.l(ImageFpsEvent.class, new a75());
                f.l(SoLoaderEvent.class, new j75());
                f.l(PushRecevierEvent.class, new f75());
                f.l(ThirdPartyActivityLifecycleEvent.class, new l75());
                f.l(EmotionReloadEvent.class, new z65());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
