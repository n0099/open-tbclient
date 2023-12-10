package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947626820, "Lcom/baidu/tieba/c68;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947626820, "Lcom/baidu/tieba/c68;");
        }
    }

    @JvmStatic
    public static final void a(TbPageContext<?> tbPageContext) {
        FrsActivity frsActivity;
        boolean z;
        FrsFragment n1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
        FrsActivity frsActivity2 = null;
        if (pageActivity instanceof FrsActivity) {
            frsActivity = (FrsActivity) pageActivity;
        } else {
            frsActivity = null;
        }
        if (frsActivity != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            frsActivity2 = frsActivity;
        }
        if (frsActivity2 != null && (n1 = frsActivity2.n1()) != null) {
            fp5.a.h(n1.getUniqueId());
        }
    }
}
