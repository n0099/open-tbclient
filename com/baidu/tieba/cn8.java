package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class cn8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends LinearSmoothScroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeRecyclerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bdTypeRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                int calculateDtToFit = super.calculateDtToFit(i, i2, i3, i4, i5);
                if (calculateDtToFit == 0) {
                    return calculateDtToFit;
                }
                int[] iArr = new int[2];
                this.a.getLocationOnScreen(iArr);
                return ((calculateDtToFit - cn8.a) - ((iArr[1] + this.a.getHeight()) - hi.j(TbadkCoreApplication.getInst().getApp()))) + xh.b(TbadkCoreApplication.getInst().getApp());
            }
            return invokeCommon.intValue;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayMetrics)) == null) {
                if (displayMetrics != null && (i = displayMetrics.densityDpi) != 0) {
                    return 300.0f / i;
                }
                return super.calculateSpeedPerPixel(displayMetrics);
            }
            return invokeL.floatValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeRecyclerView a;
        public final /* synthetic */ int b;

        public b(BdTypeRecyclerView bdTypeRecyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.smoothScrollToPosition(this.b - 1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947680636, "Lcom/baidu/tieba/cn8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947680636, "Lcom/baidu/tieba/cn8;");
                return;
            }
        }
        a = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        b = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds562);
    }

    public static boolean a(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        List<gn> data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView != null && (data = bdTypeRecyclerView.getData()) != null && data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    gn gnVar = data.get(i);
                    if ((gnVar instanceof bc9) && gnVar.getType() == bc9.Q0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int c(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView == null) {
                return -1;
            }
            List<gn> data = bdTypeRecyclerView.getData();
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    if (data.get(i) instanceof xi8) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int b(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bdTypeRecyclerView, str)) == null) {
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
                List<gn> data = bdTypeRecyclerView.getData();
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i = 0; i < size; i++) {
                        gn gnVar = data.get(i);
                        if ((gnVar instanceof bc9) && gnVar.getType() == bc9.Q0 && str.equals(((bc9) gnVar).O())) {
                            return i + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int d(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdTypeRecyclerView)) == null) {
            if (bdTypeRecyclerView == null) {
                return -1;
            }
            List<gn> data = bdTypeRecyclerView.getData();
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    gn gnVar = data.get(i);
                    if ((gnVar instanceof xi8) && ((xi8) gnVar).b == xi8.j) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void e(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, bdTypeRecyclerView) != null) || bdTypeRecyclerView == null) {
            return;
        }
        int d = d(bdTypeRecyclerView);
        if (d < 0) {
            d = c(bdTypeRecyclerView);
        }
        if (d >= 0) {
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(d, 0);
            }
        }
    }

    public static void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i) == null) {
            b = i;
        }
    }

    public static void f(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, bdTypeRecyclerView, str) == null) && bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
            e(bdTypeRecyclerView);
            bdTypeRecyclerView.post(new b(bdTypeRecyclerView, b(bdTypeRecyclerView, str)));
        }
    }

    public static void g(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, bdTypeRecyclerView, str) != null) || bdTypeRecyclerView == null) {
            return;
        }
        bdTypeRecyclerView.getLayoutManager().scrollToPosition(b(bdTypeRecyclerView, str));
    }

    public static void h(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, bdTypeRecyclerView, str) == null) && bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
            new a(bdTypeRecyclerView.getContext(), bdTypeRecyclerView);
            e(bdTypeRecyclerView);
            int b2 = b(bdTypeRecyclerView, str);
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(b2, (UtilHelper.getScreenHeight(bdTypeRecyclerView.getContext()) - b) / 5);
            }
        }
    }
}
