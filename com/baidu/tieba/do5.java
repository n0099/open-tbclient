package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.RemoveViewNPE;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class do5 {
    public static /* synthetic */ Interceptable $ic;
    public static final do5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711295, "Lcom/baidu/tieba/do5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711295, "Lcom/baidu/tieba/do5;");
                return;
            }
        }
        a = new do5();
    }

    public do5() {
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

    @JvmStatic
    public static final void a(BdRecyclerView viewGroup, int i, NullPointerException e) {
        io5 io5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, viewGroup, i, e) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(e, "e");
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "viewGroup.getChildAt(index)");
            if (childAt instanceof ViewGroup) {
                io5Var = a.b((ViewGroup) childAt);
            } else {
                io5Var = null;
            }
            if (io5Var != null) {
                String str = "BdRecyclerView removeViewAt() NPE at index: " + i + ", the out parent is: [class: " + childAt.getClass().getSimpleName() + ", id: " + childAt.getId() + "], internal parent is: [class: " + io5Var.b().getClass().getSimpleName() + ", id: " + io5Var.b().getId() + "], child index is: " + io5Var.a();
                Throwable initCause = new RemoveViewNPE().initCause(new Throwable(str, e));
                BdLog.detailException(initCause);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 6).param("obj_source", str));
                initCause.printStackTrace();
            }
        }
    }

    public final io5 b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof ViewGroup) {
                        b((ViewGroup) childAt);
                    } else if (childAt == null) {
                        return new io5(viewGroup, i);
                    }
                    if (i2 < childCount) {
                        i = i2;
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        } else {
            return (io5) invokeL.objValue;
        }
    }
}
