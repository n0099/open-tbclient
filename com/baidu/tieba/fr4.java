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
public class fr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public er4 a;
    public l05 b;

    public fr4() {
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
        l05 l05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l05Var = this.b) != null) {
            l05Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !hi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            jt4.v(currentActivity, "", str, true);
        }
    }

    public void c(er4 er4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, er4Var) == null) {
            this.a = er4Var;
        }
    }

    public void d() {
        er4 er4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (er4Var = this.a) == null) {
            return;
        }
        int i = er4Var.c;
        if (i == er4.y) {
            l05 h = l05.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == er4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            gw4 gw4Var = new gw4(currentActivity);
            gw4Var.d(currentActivity, this.a);
            gw4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            fw4 b = fw4.b();
            fw4 b2 = fw4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == er4.A) {
            int i2 = er4Var.d;
            if (i2 == er4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !hi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == er4.F && !hi.isEmpty(er4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == er4.B && !TextUtils.isEmpty(er4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            er4 er4Var2 = this.a;
            completeTaskToastData.activityId = er4Var2.a;
            completeTaskToastData.missionId = er4Var2.b;
            completeTaskToastData.duration = er4Var2.i;
            completeTaskToastData.message = er4Var2.e;
            completeTaskToastData.url = er4Var2.k;
            completeTaskToastData.pageId = bq4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            cj5.i(competeTaskEvent);
            er4 er4Var3 = this.a;
            gr4.c(er4Var3.a, er4Var3.b);
        }
    }
}
