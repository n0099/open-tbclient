package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.bdtask.ui.components.dialog.DoubleBtnDialog;
import com.baidu.bdtask.ui.components.dialog.SingleBtnDialog;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class fv extends ws<zp> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a<T> implements bt<TaskDialogViewData> {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(251548480, "Lcom/baidu/tieba/fv$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(251548480, "Lcom/baidu/tieba/fv$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bt
        /* renamed from: a */
        public final void onChanged(TaskDialogViewData taskDialogViewData) {
            Context context;
            Class cls;
            hs h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, taskDialogViewData) == null) && taskDialogViewData != null) {
                hu v = BDPTask.m.v();
                if (v != null && (h = v.h()) != null) {
                    context = h.getAppContext();
                } else {
                    context = null;
                }
                if (taskDialogViewData.getShowType() == 1) {
                    cls = SingleBtnDialog.class;
                } else {
                    cls = DoubleBtnDialog.class;
                }
                Intent intent = new Intent(context, cls);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", taskDialogViewData);
                intent.putExtras(bundle);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (context != null) {
                    context.startActivity(intent);
                }
            }
        }
    }

    public fv() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xs
    /* renamed from: b */
    public void a(zp zpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zpVar) == null) {
            zpVar.a().l(a.a);
        }
    }
}
