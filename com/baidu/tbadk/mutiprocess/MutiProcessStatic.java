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
import com.baidu.tbadk.switchs.NewWritePageSwitch;
import com.baidu.tieba.aa5;
import com.baidu.tieba.bx4;
import com.baidu.tieba.ea5;
import com.baidu.tieba.fa5;
import com.baidu.tieba.ga5;
import com.baidu.tieba.ha5;
import com.baidu.tieba.ia5;
import com.baidu.tieba.ja5;
import com.baidu.tieba.ka5;
import com.baidu.tieba.la5;
import com.baidu.tieba.ma5;
import com.baidu.tieba.na5;
import com.baidu.tieba.oa5;
import com.baidu.tieba.pa5;
import com.baidu.tieba.qa5;
import com.baidu.tieba.ra5;
import com.baidu.tieba.sa5;
import com.baidu.tieba.ta5;
import com.baidu.tieba.va5;
import com.baidu.tieba.wa5;
import com.baidu.tieba.xa5;
import com.baidu.tieba.y95;
import com.baidu.tieba.z95;
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
                aa5 f = aa5.f();
                f.l(AgreeEvent.class, new ea5());
                f.l(MissionEvent.class, new pa5());
                f.l(CompeteTaskEvent.class, new ga5());
                f.l(ShareEvent.class, new sa5());
                f.l(HistoryEvent.class, new ka5());
                f.l(BackBaiduBoxViewEvent.class, new fa5());
                f.l(SyncDataEvent.class, new wa5());
                f.l(ShowReplyInPbEvent.class, new ta5());
                f.l(LocationEvent.class, new oa5());
                f.l(PrePageKeyEvent.class, new qa5());
                f.l(CurrentPageTypeEvent.class, new ha5());
                f.l(ImageFpsEvent.class, new ja5());
                f.l(SoLoaderEvent.class, new va5());
                f.l(PushRecevierEvent.class, new ra5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new xa5());
                f.l(EmotionReloadEvent.class, new ia5());
                f.l(LiveRemindDataEvent.class, new ma5());
                f.l(LiveStartClickDataEvent.class, new na5());
                f.l(HotEvent.class, new la5());
                if (!y95.l()) {
                    bx4.k().w("key_new_write_page", z95.c("key_new_write_page", 0));
                } else {
                    z95.i("key_new_write_page", NewWritePageSwitch.getIsOn() ? 1 : 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
