package com.baidu.tieba;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ek7 {
    public static /* synthetic */ Interceptable $ic;
    public static final ek7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947737304, "Lcom/baidu/tieba/ek7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947737304, "Lcom/baidu/tieba/ek7;");
                return;
            }
        }
        a = new ek7();
    }

    public ek7() {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zh5.h().i(false);
        }
    }

    public static final void c(Function1 function1, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, function1, z) == null) {
            if (z) {
                zh5.h().o(true);
            }
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(z));
            }
        }
    }

    public final void b(yh5 view2, BaseFragmentActivity activity, final Function1<? super Boolean, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, activity, function1) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(activity, "activity");
            zh5.h().m(view2);
            zh5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds237));
            if (zh5.h().j()) {
                activity.getPageContext().getOrignalPage().grantWindowPermission(new iv4() { // from class: com.baidu.tieba.ck7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.iv4
                    public final void onPermissionResult(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            ek7.c(Function1.this, z);
                        }
                    }
                }, true);
            }
        }
    }
}
