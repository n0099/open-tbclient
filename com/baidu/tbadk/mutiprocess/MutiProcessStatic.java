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
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.tbadk.mutiprocess.urlmanager.UrlDealEvent;
import com.baidu.tieba.ac5;
import com.baidu.tieba.bc5;
import com.baidu.tieba.cc5;
import com.baidu.tieba.dc5;
import com.baidu.tieba.ec5;
import com.baidu.tieba.fc5;
import com.baidu.tieba.gc5;
import com.baidu.tieba.ic5;
import com.baidu.tieba.jc5;
import com.baidu.tieba.kc5;
import com.baidu.tieba.lc5;
import com.baidu.tieba.mb5;
import com.baidu.tieba.qb5;
import com.baidu.tieba.rb5;
import com.baidu.tieba.sb5;
import com.baidu.tieba.tb5;
import com.baidu.tieba.ub5;
import com.baidu.tieba.vb5;
import com.baidu.tieba.wb5;
import com.baidu.tieba.xb5;
import com.baidu.tieba.yb5;
import com.baidu.tieba.zb5;
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
                mb5 f = mb5.f();
                f.l(AgreeEvent.class, new qb5());
                f.l(MissionEvent.class, new cc5());
                f.l(CompeteTaskEvent.class, new sb5());
                f.l(ShareEvent.class, new fc5());
                f.l(HistoryEvent.class, new wb5());
                f.l(BackBaiduBoxViewEvent.class, new rb5());
                f.l(SyncDataEvent.class, new jc5());
                f.l(ShowReplyInPbEvent.class, new gc5());
                f.l(LocationEvent.class, new bc5());
                f.l(PrePageKeyEvent.class, new dc5());
                f.l(CurrentPageTypeEvent.class, new tb5());
                f.l(ImageFpsEvent.class, new vb5());
                f.l(SoLoaderEvent.class, new ic5());
                f.l(PushRecevierEvent.class, new ec5());
                f.l(ThirdPartyActivityLifecycleEvent.class, new kc5());
                f.l(EmotionReloadEvent.class, new ub5());
                f.l(LiveRemindDataEvent.class, new zb5());
                f.l(LiveStartClickDataEvent.class, new ac5());
                f.l(HotEvent.class, new xb5());
                f.l(ImageViewLiveEvent.class, new yb5());
                f.l(UrlDealEvent.class, new lc5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
