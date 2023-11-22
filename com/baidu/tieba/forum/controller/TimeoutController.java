package com.baidu.tieba.forum.controller;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.fi7;
import com.baidu.tieba.forum.controller.TimeoutController;
import com.baidu.tieba.nq6;
import com.baidu.tieba.pg7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/forum/controller/TimeoutController;", "Lcom/baidu/tieba/forum/controller/BaseActivityController;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "TIMEOUT_MILLIS", "", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "timeoutRunnable", "Ljava/lang/Runnable;", MissionEvent.MESSAGE_DESTROY, "", "startTimeoutCheck", "stopTimeoutCheck", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TimeoutController extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public final long c;
    public final Lazy d;
    public final Runnable e;

    public TimeoutController(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.c = 3000L;
        this.d = LazyKt__LazyJVMKt.lazy(TimeoutController$handler$2.INSTANCE);
        this.e = new Runnable() { // from class: com.baidu.tieba.bg7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    TimeoutController.s(TimeoutController.this);
                }
            }
        };
    }

    public static final void s(TimeoutController this$0) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity fragmentActivity = this$0.b;
            BdUniqueId bdUniqueId = null;
            if (fragmentActivity instanceof BaseFragmentActivity) {
                baseFragmentActivity = (BaseFragmentActivity) fragmentActivity;
            } else {
                baseFragmentActivity = null;
            }
            if (baseFragmentActivity != null) {
                bdUniqueId = baseFragmentActivity.getUniqueId();
            }
            if (bdUniqueId == null) {
                return;
            }
            HybridLog.getInstance().d("TimeoutController", "触发Frs超时逻辑，通知锚点");
            double screenHeight = UtilHelper.getScreenHeight(this$0.b);
            nq6.b().c(new fi7(new fi7.a(1.5d * screenHeight, 0.3d * screenHeight, 0.2d * screenHeight, 0.25d * screenHeight, 0.0d, 0.0d, 48, null), bdUniqueId, Boolean.FALSE));
        }
    }

    @Override // com.baidu.tieba.pg7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.l();
            r();
        }
    }

    public final Handler o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (Handler) this.d.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o().postDelayed(this.e, this.c);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o().removeCallbacks(this.e);
        }
    }
}
