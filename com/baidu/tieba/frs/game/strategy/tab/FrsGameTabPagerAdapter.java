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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.r1.a.d.a;
import d.a.s0.u0.r1.a.d.c;
import d.a.s0.u0.r1.a.d.e;
/* loaded from: classes5.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f15630a;

    /* renamed from: b  reason: collision with root package name */
    public int f15631b;

    /* renamed from: c  reason: collision with root package name */
    public Context f15632c;

    /* renamed from: d  reason: collision with root package name */
    public a f15633d;

    /* renamed from: e  reason: collision with root package name */
    public c f15634e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f15635f;

    /* renamed from: g  reason: collision with root package name */
    public int f15636g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f15637h;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15630a = new FrsGameStrategyItemListView[4];
        this.f15631b = 0;
        this.f15636g = -1;
        this.f15632c = context;
        this.f15633d = aVar;
        this.f15634e = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
        }
    }

    public FrsGameStrategyItemListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15635f : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public FrsGameStrategyItemListView f(int i2, int i3) {
        InterceptResult invokeII;
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == 0) {
                return this.f15630a[0];
            }
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15630a) {
                if (frsGameStrategyItemListView != null && i2 == frsGameStrategyItemListView.getTabId() && i3 == frsGameStrategyItemListView.getLabelId()) {
                    return frsGameStrategyItemListView;
                }
            }
            return null;
        }
        return (FrsGameStrategyItemListView) invokeII.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15631b : invokeV.intValue;
    }

    public final FrsGameStrategyItemListView i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15630a;
            if (i2 >= frsGameStrategyItemListViewArr.length) {
                return null;
            }
            return frsGameStrategyItemListViewArr[i2];
        }
        return (FrsGameStrategyItemListView) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            int i3 = i2 % 3;
            FrsGameStrategyItemListView i4 = i(i3);
            if (i4 == null) {
                i4 = new FrsGameStrategyItemListView(this.f15632c, this.f15637h);
                i4.setFrsGameTabDataLoadListener(this.f15633d);
                n(i3, i4);
            } else if (i4 == e()) {
                i4 = i(3);
                if (i4 == null) {
                    i4 = new FrsGameStrategyItemListView(this.f15632c, this.f15637h);
                    i4.setFrsGameTabDataLoadListener(this.f15633d);
                    n(3, i4);
                } else if (i4.getParent() != null) {
                    viewGroup.removeView(i4);
                }
            } else if (i4.getParent() != null) {
                viewGroup.removeView(i4);
            }
            viewGroup.addView(i4);
            c cVar = this.f15634e;
            if (cVar != null && (a2 = cVar.a(i2)) != null) {
                Object obj = a2.f66937c;
                if (obj instanceof LabelDataList) {
                    i4.o(a2.f66935a, ((LabelDataList) obj).getSelectedLabelId());
                }
            }
            return i4;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, obj)) == null) ? (obj instanceof FrsGameStrategyItemListView) && obj == view : invokeLL.booleanValue;
    }

    public void j(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15630a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.p(i2);
                }
            }
        }
    }

    public void k() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15630a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.q();
                }
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.f15631b = i2;
            notifyDataSetChanged();
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f15637h = bdUniqueId;
        }
    }

    public final void n(int i2, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, frsGameStrategyItemListView) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15630a;
            if (i2 >= frsGameStrategyItemListViewArr.length) {
                return;
            }
            frsGameStrategyItemListViewArr[i2] = frsGameStrategyItemListView;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i2, obj) == null) && (obj instanceof FrsGameStrategyItemListView) && this.f15636g != i2) {
            this.f15636g = i2;
            FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
            this.f15635f = frsGameStrategyItemListView;
            frsGameStrategyItemListView.r();
        }
    }
}
