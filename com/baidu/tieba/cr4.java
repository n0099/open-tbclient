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
/* loaded from: classes3.dex */
public class cr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public br4 a;
    public h05 b;

    public cr4() {
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
        h05 h05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (h05Var = this.b) != null) {
            h05Var.f();
            this.b = null;
        }
    }

    public final void b(String str) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !gi.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && !StringUtils.isNull(str)) {
            gt4.v(currentActivity, "", str, true);
        }
    }

    public void c(br4 br4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, br4Var) == null) {
            this.a = br4Var;
        }
    }

    public void d() {
        br4 br4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (br4Var = this.a) == null) {
            return;
        }
        int i = br4Var.c;
        if (i == br4.y) {
            h05 h = h05.h(TbadkCoreApplication.getInst().getCurrentActivity(), this.a);
            h.j();
            this.b = h;
        } else if (i == br4.z) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            dw4 dw4Var = new dw4(currentActivity);
            dw4Var.d(currentActivity, this.a);
            dw4Var.i();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            cw4 b = cw4.b();
            cw4 b2 = cw4.b();
            b2.i("business_count_hint" + currentAccount + this.a.a, b.c("business_count_hint" + currentAccount + this.a.a) - 1);
        } else if (i == br4.A) {
            int i2 = br4Var.d;
            if (i2 == br4.E) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.a.l) && !gi.isEmpty(this.a.k)) {
                    b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == br4.F && !gi.isEmpty(br4Var.k)) {
                b(this.a.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == br4.B && !TextUtils.isEmpty(br4Var.e)) {
            CompleteTaskToastData completeTaskToastData = new CompleteTaskToastData();
            br4 br4Var2 = this.a;
            completeTaskToastData.activityId = br4Var2.a;
            completeTaskToastData.missionId = br4Var2.b;
            completeTaskToastData.duration = br4Var2.i;
            completeTaskToastData.message = br4Var2.e;
            completeTaskToastData.url = br4Var2.k;
            completeTaskToastData.pageId = zp4.w().v();
            CompeteTaskEvent competeTaskEvent = new CompeteTaskEvent();
            competeTaskEvent.taskToastData = completeTaskToastData;
            vh5.i(competeTaskEvent);
            br4 br4Var3 = this.a;
            dr4.c(br4Var3.a, br4Var3.b);
        }
    }
}
