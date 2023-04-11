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
/* loaded from: classes4.dex */
public class er4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dr4 a;
    public k05 b;

    public er4() {
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
        k05 k05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (k05Var = this.b) != null) {
            k05Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !hi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            it4.v(currentActivity, "", str, true);
        }
    }

    public void c(dr4 dr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dr4Var) == null) {
            this.a = dr4Var;
        }
    }

    public void d() {
        dr4 dr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (dr4Var = this.a) == null) {
            return;
        }
        int i = dr4Var.c;
        if (i == dr4.y) {
            k05 h = k05.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == dr4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            fw4 fw4Var = new fw4(currentActivity);
            fw4Var.d(currentActivity, this.a);
            fw4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ew4 b = ew4.b();
            ew4 b2 = ew4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == dr4.A) {
            int i2 = dr4Var.d;
            if (i2 == dr4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !hi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == dr4.F && !hi.isEmpty(dr4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == dr4.B && !TextUtils.isEmpty(dr4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            dr4 dr4Var2 = this.a;
            completeTaskToastData.activityId = dr4Var2.a;
            completeTaskToastData.missionId = dr4Var2.b;
            completeTaskToastData.duration = dr4Var2.i;
            completeTaskToastData.message = dr4Var2.e;
            completeTaskToastData.url = dr4Var2.k;
            completeTaskToastData.pageId = aq4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            bj5.i(competeTaskEvent);
            dr4 dr4Var3 = this.a;
            fr4.c(dr4Var3.a, dr4Var3.b);
        }
    }
}
