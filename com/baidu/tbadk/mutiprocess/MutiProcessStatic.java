package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.HybridNotify.HybridNotifyEvent;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.aiApply.AICapacityMainProcessToastEvent;
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
import com.baidu.tbadk.mutiprocess.share.ShareToastEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.tbadk.mutiprocess.toptip.TopNotifyEvent;
import com.baidu.tbadk.mutiprocess.urlmanager.UrlDealEvent;
import com.baidu.tbadk.mutiprocess.write.NewWritePageStateEvent;
import com.baidu.tieba.an5;
import com.baidu.tieba.bn5;
import com.baidu.tieba.cn5;
import com.baidu.tieba.dn5;
import com.baidu.tieba.en5;
import com.baidu.tieba.fn5;
import com.baidu.tieba.gn5;
import com.baidu.tieba.hn5;
import com.baidu.tieba.in5;
import com.baidu.tieba.jn5;
import com.baidu.tieba.kn5;
import com.baidu.tieba.ln5;
import com.baidu.tieba.mn5;
import com.baidu.tieba.nm5;
import com.baidu.tieba.nn5;
import com.baidu.tieba.on5;
import com.baidu.tieba.pn5;
import com.baidu.tieba.qn5;
import com.baidu.tieba.sn5;
import com.baidu.tieba.un5;
import com.baidu.tieba.vn5;
import com.baidu.tieba.wm5;
import com.baidu.tieba.wn5;
import com.baidu.tieba.xm5;
import com.baidu.tieba.zm5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
                MutiProcessManager mutiProcessManager = MutiProcessManager.getInstance();
                mutiProcessManager.registerForeverListener(AgreeEvent.class, new wm5());
                mutiProcessManager.registerForeverListener(MissionEvent.class, new kn5());
                mutiProcessManager.registerForeverListener(CompeteTaskEvent.class, new an5());
                mutiProcessManager.registerForeverListener(ShareEvent.class, new on5());
                mutiProcessManager.registerForeverListener(HistoryEvent.class, new en5());
                mutiProcessManager.registerForeverListener(BackBaiduBoxViewEvent.class, new zm5());
                mutiProcessManager.registerForeverListener(ShowReplyInPbEvent.class, new qn5());
                mutiProcessManager.registerForeverListener(LocationEvent.class, new jn5());
                mutiProcessManager.registerForeverListener(PrePageKeyEvent.class, new ln5());
                mutiProcessManager.registerForeverListener(CurrentPageTypeEvent.class, new bn5());
                mutiProcessManager.registerForeverListener(ImageFpsEvent.class, new dn5());
                mutiProcessManager.registerForeverListener(SoLoaderEvent.class, new sn5());
                mutiProcessManager.registerForeverListener(PushRecevierEvent.class, new mn5());
                mutiProcessManager.registerForeverListener(EmotionReloadEvent.class, new cn5());
                mutiProcessManager.registerForeverListener(LiveRemindDataEvent.class, new hn5());
                mutiProcessManager.registerForeverListener(LiveStartClickDataEvent.class, new in5());
                mutiProcessManager.registerForeverListener(HotEvent.class, new fn5());
                mutiProcessManager.registerForeverListener(TopNotifyEvent.class, new un5());
                mutiProcessManager.registerForeverListener(ImageViewLiveEvent.class, new gn5());
                mutiProcessManager.registerForeverListener(UrlDealEvent.class, new vn5());
                mutiProcessManager.registerForeverListener(InitWeiboSdkEvent.class, new nn5());
                mutiProcessManager.registerForeverListener(HybridNotifyEvent.class, new nm5());
                mutiProcessManager.registerForeverListener(AICapacityMainProcessToastEvent.class, new xm5());
                mutiProcessManager.registerForeverListener(NewWritePageStateEvent.class, new wn5());
                mutiProcessManager.registerForeverListener(ShareToastEvent.class, new pn5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
