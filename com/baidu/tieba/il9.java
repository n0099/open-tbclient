package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class il9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;
        public final /* synthetic */ int b;

        public a(BdTypeListView bdTypeListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getContext());
                int[] iArr = new int[2];
                this.a.getLocationOnScreen(iArr);
                this.a.setSelectionFromTop(this.b, ((equipmentHeight - il9.b) - iArr[1]) / 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;
        public final /* synthetic */ int b;

        public b(BdTypeListView bdTypeListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.smoothScrollToPosition(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;
        public final /* synthetic */ String b;

        public c(BdTypeListView bdTypeListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !tca.b(this.a) || (a = il9.a(this.a, this.b)) < 0) {
                return;
            }
            int height = this.a.getHeight();
            int width = this.a.getWidth();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            BdTypeListView bdTypeListView = this.a;
            View childAt = bdTypeListView.getChildAt(a - bdTypeListView.getFirstVisiblePosition());
            if ((childAt == null || childAt.getBottom() > height - il9.b) && (view2 = this.a.getAdapter2().getView(a, null, this.a)) != null) {
                view2.measure(makeMeasureSpec2, makeMeasureSpec);
                this.a.setSelectionFromTop(a, (height - view2.getMeasuredHeight()) - il9.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947857491, "Lcom/baidu/tieba/il9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947857491, "Lcom/baidu/tieba/il9;");
                return;
            }
        }
        a = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds240);
        b = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
    }

    public static int a(BdTypeListView bdTypeListView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bdTypeListView, str)) == null) {
            if (bdTypeListView != null && !TextUtils.isEmpty(str)) {
                List<yh> data = bdTypeListView.getData();
                int headerViewsCount = bdTypeListView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i = 0; i < size; i++) {
                        yh yhVar = data.get(i);
                        if ((yhVar instanceof pea) && yhVar.getType() == pea.X0 && str.equals(((pea) yhVar).U())) {
                            return i + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int b(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<yh> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    if (data.get(i) instanceof nf9) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int c(BdTypeListView bdTypeListView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, bdTypeListView, str, i)) == null) {
            if (bdTypeListView != null && !StringUtils.isNull(str)) {
                List<yh> data = bdTypeListView.getData();
                int headerViewsCount = bdTypeListView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        yh yhVar = data.get(i2);
                        if ((yhVar instanceof pea) && str.equals(((pea) yhVar).U())) {
                            return (i2 + headerViewsCount) - i;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    public static int d(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<yh> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    yh yhVar = data.get(i);
                    if ((yhVar instanceof pea) && yhVar.getType() == pea.X0) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int e(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bdTypeListView)) == null) {
            if (bdTypeListView == null) {
                return -1;
            }
            List<yh> data = bdTypeListView.getData();
            int headerViewsCount = bdTypeListView.getHeaderViewsCount();
            if (data != null && data.size() > 0) {
                int size = data.size();
                for (int i = 0; i < size; i++) {
                    yh yhVar = data.get(i);
                    if ((yhVar instanceof nf9) && ((nf9) yhVar).a == nf9.h) {
                        return i + headerViewsCount;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void f(BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, bdTypeListView, str) == null) && bdTypeListView != null && !StringUtils.isNull(str)) {
            g(bdTypeListView);
            int c2 = c(bdTypeListView, str, 1);
            if (c2 >= 0) {
                bdTypeListView.post(new b(bdTypeListView, c2));
            }
        }
    }

    public static void h(BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, bdTypeListView, str) != null) || bdTypeListView == null) {
            return;
        }
        int e = e(bdTypeListView);
        if (e < 0) {
            e = c(bdTypeListView, str, 0);
        }
        if (e >= 0) {
            bdTypeListView.post(new a(bdTypeListView, e));
        }
    }

    public static void i(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65545, null, bdTypeListView, i) != null) || bdTypeListView == null) {
            return;
        }
        int e = e(bdTypeListView);
        if (e < 0) {
            e = b(bdTypeListView);
        }
        if (e >= 0) {
            bdTypeListView.setSelectionFromTop(e, a + i);
        }
    }

    public static void g(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bdTypeListView) == null) {
            i(bdTypeListView, 0);
        }
    }

    public static void k(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.setSelectionFromTop(0, 0);
        }
    }

    public static void j(int i, BdTypeListView bdTypeListView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(65546, null, i, bdTypeListView, str) == null) && bdTypeListView != null && !TextUtils.isEmpty(str) && bdTypeListView.getAdapter2() != null) {
            if (12 == i) {
                h(bdTypeListView, str);
                return;
            }
            g(bdTypeListView);
            bdTypeListView.post(new c(bdTypeListView, str));
        }
    }
}
