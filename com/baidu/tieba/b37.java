package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b37 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947594115, "Lcom/baidu/tieba/b37;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947594115, "Lcom/baidu/tieba/b37;");
        }
    }

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity != null) {
                try {
                    if (activity.isInMultiWindowMode()) {
                        return true;
                    }
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, bdTypeRecyclerView) != null) || bdTypeRecyclerView == null) {
            return;
        }
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        int i = 0;
        View childAt = bdTypeRecyclerView.getChildAt(0);
        if (childAt != null) {
            i = childAt.getTop();
        }
        a = firstVisiblePosition;
        b = i;
    }

    public static void c(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, bdTypeRecyclerView) != null) || bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || a > bdTypeRecyclerView.getCount() - 1) {
            return;
        }
        bdTypeRecyclerView.requestFocusFromTouch();
        ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(a, b);
        a = 0;
        b = 0;
    }
}
