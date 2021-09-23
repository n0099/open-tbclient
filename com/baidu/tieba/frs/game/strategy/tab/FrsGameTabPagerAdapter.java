package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.r0.w0.s1.a.d.a;
import c.a.r0.w0.s1.a.d.c;
import c.a.r0.w0.s1.a.d.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f51270a;

    /* renamed from: b  reason: collision with root package name */
    public int f51271b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51272c;

    /* renamed from: d  reason: collision with root package name */
    public a f51273d;

    /* renamed from: e  reason: collision with root package name */
    public c f51274e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f51275f;

    /* renamed from: g  reason: collision with root package name */
    public int f51276g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f51277h;

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
        this.f51270a = new FrsGameStrategyItemListView[4];
        this.f51271b = 0;
        this.f51276g = -1;
        this.f51272c = context;
        this.f51273d = aVar;
        this.f51274e = cVar;
    }

    public final FrsGameStrategyItemListView a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f51270a;
            if (i2 >= frsGameStrategyItemListViewArr.length) {
                return null;
            }
            return frsGameStrategyItemListViewArr[i2];
        }
        return (FrsGameStrategyItemListView) invokeI.objValue;
    }

    public final void b(int i2, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, frsGameStrategyItemListView) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f51270a;
            if (i2 >= frsGameStrategyItemListViewArr.length) {
                return;
            }
            frsGameStrategyItemListViewArr[i2] = frsGameStrategyItemListView;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51271b : invokeV.intValue;
    }

    public FrsGameStrategyItemListView getCurrentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51275f : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public FrsGameStrategyItemListView getViewByTabAndLabel(int i2, int i3) {
        InterceptResult invokeII;
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == 0) {
                return this.f51270a[0];
            }
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f51270a) {
                if (frsGameStrategyItemListView != null && i2 == frsGameStrategyItemListView.getTabId() && i3 == frsGameStrategyItemListView.getLabelId()) {
                    return frsGameStrategyItemListView;
                }
            }
            return null;
        }
        return (FrsGameStrategyItemListView) invokeII.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            int i3 = i2 % 3;
            FrsGameStrategyItemListView a3 = a(i3);
            if (a3 == null) {
                a3 = new FrsGameStrategyItemListView(this.f51272c, this.f51277h);
                a3.setFrsGameTabDataLoadListener(this.f51273d);
                b(i3, a3);
            } else if (a3 == getCurrentView()) {
                a3 = a(3);
                if (a3 == null) {
                    a3 = new FrsGameStrategyItemListView(this.f51272c, this.f51277h);
                    a3.setFrsGameTabDataLoadListener(this.f51273d);
                    b(3, a3);
                } else if (a3.getParent() != null) {
                    viewGroup.removeView(a3);
                }
            } else if (a3.getParent() != null) {
                viewGroup.removeView(a3);
            }
            viewGroup.addView(a3);
            c cVar = this.f51274e;
            if (cVar != null && (a2 = cVar.a(i2)) != null) {
                Object obj = a2.f27818c;
                if (obj instanceof LabelDataList) {
                    a3.initTab(a2.f27816a, ((LabelDataList) obj).getSelectedLabelId());
                }
            }
            return a3;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, obj)) == null) ? (obj instanceof FrsGameStrategyItemListView) && obj == view : invokeLL.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f51270a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.onChangeSkinType(i2);
                }
            }
        }
    }

    public void onDestory() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f51270a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.onDestory();
                }
            }
        }
    }

    public void setCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.f51271b = i2;
            notifyDataSetChanged();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.f51277h = bdUniqueId;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i2, obj) == null) && (obj instanceof FrsGameStrategyItemListView) && this.f51276g != i2) {
            this.f51276g = i2;
            FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
            this.f51275f = frsGameStrategyItemListView;
            frsGameStrategyItemListView.onEnterForground();
        }
    }
}
