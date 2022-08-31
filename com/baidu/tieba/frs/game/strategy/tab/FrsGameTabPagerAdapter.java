package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.ll6;
import com.baidu.tieba.nl6;
import com.baidu.tieba.pl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsGameStrategyItemListView[] a;
    public int b;
    public Context c;
    public ll6 d;
    public nl6 e;
    public FrsGameStrategyItemListView f;
    public int g;
    public BdUniqueId h;

    public FrsGameTabPagerAdapter(Context context, ll6 ll6Var, nl6 nl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ll6Var, nl6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new FrsGameStrategyItemListView[4];
        this.b = 0;
        this.g = -1;
        this.c = context;
        this.d = ll6Var;
        this.e = nl6Var;
    }

    public FrsGameStrategyItemListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public FrsGameStrategyItemListView c(int i, int i2) {
        InterceptResult invokeII;
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (i == 0 && i2 == 0) {
                return this.a[0];
            }
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
                if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                    return frsGameStrategyItemListView;
                }
            }
            return null;
        }
        return (FrsGameStrategyItemListView) invokeII.objValue;
    }

    public final FrsGameStrategyItemListView d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.a;
            if (i >= frsGameStrategyItemListViewArr.length) {
                return null;
            }
            return frsGameStrategyItemListViewArr[i];
        }
        return (FrsGameStrategyItemListView) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
        }
    }

    public void e(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.p(i);
                }
            }
        }
    }

    public void f() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.q();
                }
            }
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            this.b = i;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.intValue;
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.h = bdUniqueId;
        }
    }

    public final void i(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, frsGameStrategyItemListView) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.a;
            if (i >= frsGameStrategyItemListViewArr.length) {
                return;
            }
            frsGameStrategyItemListViewArr[i] = frsGameStrategyItemListView;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        pl6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i)) == null) {
            int i2 = i % 3;
            FrsGameStrategyItemListView d = d(i2);
            if (d == null) {
                d = new FrsGameStrategyItemListView(this.c, this.h);
                d.setFrsGameTabDataLoadListener(this.d);
                i(i2, d);
            } else if (d == b()) {
                d = d(3);
                if (d == null) {
                    d = new FrsGameStrategyItemListView(this.c, this.h);
                    d.setFrsGameTabDataLoadListener(this.d);
                    i(3, d);
                } else if (d.getParent() != null) {
                    viewGroup.removeView(d);
                }
            } else if (d.getParent() != null) {
                viewGroup.removeView(d);
            }
            viewGroup.addView(d);
            nl6 nl6Var = this.e;
            if (nl6Var != null && (a = nl6Var.a(i)) != null) {
                Object obj = a.c;
                if (obj instanceof LabelDataList) {
                    d.o(a.a, ((LabelDataList) obj).getSelectedLabelId());
                }
            }
            return d;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view2, obj)) == null) ? (obj instanceof FrsGameStrategyItemListView) && obj == view2 : invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i, obj) == null) && (obj instanceof FrsGameStrategyItemListView) && this.g != i) {
            this.g = i;
            FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
            this.f = frsGameStrategyItemListView;
            frsGameStrategyItemListView.r();
        }
    }
}
