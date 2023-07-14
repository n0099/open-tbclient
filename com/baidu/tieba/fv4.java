package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ev4 a;
    public x55 b;

    public fv4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        x55 x55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (x55Var = this.b) != null) {
            x55Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !xi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            nx4.v(currentActivity, "", str, true);
        }
    }

    public void c(ev4 ev4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ev4Var) == null) {
            this.a = ev4Var;
        }
    }

    public void d() {
        ev4 ev4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (ev4Var = this.a) == null) {
            return;
        }
        int i = ev4Var.c;
        if (i == ev4.y) {
            x55 h = x55.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == ev4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            p15 p15Var = new p15(currentActivity);
            p15Var.d(currentActivity, this.a);
            p15Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            o15 b = o15.b();
            o15 b2 = o15.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == ev4.A) {
            int i2 = ev4Var.d;
            if (i2 == ev4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !xi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == ev4.F && !xi.isEmpty(ev4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == ev4.B && !TextUtils.isEmpty(ev4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            ev4 ev4Var2 = this.a;
            completeTaskToastData.activityId = ev4Var2.a;
            completeTaskToastData.missionId = ev4Var2.b;
            completeTaskToastData.duration = ev4Var2.i;
            completeTaskToastData.message = ev4Var2.e;
            completeTaskToastData.url = ev4Var2.k;
            completeTaskToastData.pageId = bu4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            wq5.i(competeTaskEvent);
            ev4 ev4Var3 = this.a;
            gv4.c(ev4Var3.a, ev4Var3.b);
        }
    }
}
