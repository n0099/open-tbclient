package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.t0.d1.e2.a.d.a;
import c.a.t0.d1.e2.a.d.c;
import c.a.t0.d1.e2.a.d.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsGameStrategyItemListView[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f43344b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43345c;

    /* renamed from: d  reason: collision with root package name */
    public a f43346d;

    /* renamed from: e  reason: collision with root package name */
    public c f43347e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f43348f;

    /* renamed from: g  reason: collision with root package name */
    public int f43349g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f43350h;

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
        this.a = new FrsGameStrategyItemListView[4];
        this.f43344b = 0;
        this.f43349g = -1;
        this.f43345c = context;
        this.f43346d = aVar;
        this.f43347e = cVar;
    }

    public final FrsGameStrategyItemListView a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.a;
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
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43344b : invokeV.intValue;
    }

    public FrsGameStrategyItemListView getCurrentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43348f : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public FrsGameStrategyItemListView getViewByTabAndLabel(int i2, int i3) {
        InterceptResult invokeII;
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == 0) {
                return this.a[0];
            }
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
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
        e a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            int i3 = i2 % 3;
            FrsGameStrategyItemListView a2 = a(i3);
            if (a2 == null) {
                a2 = new FrsGameStrategyItemListView(this.f43345c, this.f43350h);
                a2.setFrsGameTabDataLoadListener(this.f43346d);
                b(i3, a2);
            } else if (a2 == getCurrentView()) {
                a2 = a(3);
                if (a2 == null) {
                    a2 = new FrsGameStrategyItemListView(this.f43345c, this.f43350h);
                    a2.setFrsGameTabDataLoadListener(this.f43346d);
                    b(3, a2);
                } else if (a2.getParent() != null) {
                    viewGroup.removeView(a2);
                }
            } else if (a2.getParent() != null) {
                viewGroup.removeView(a2);
            }
            viewGroup.addView(a2);
            c cVar = this.f43347e;
            if (cVar != null && (a = cVar.a(i2)) != null) {
                Object obj = a.f16051c;
                if (obj instanceof LabelDataList) {
                    a2.initTab(a.a, ((LabelDataList) obj).getSelectedLabelId());
                }
            }
            return a2;
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
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
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
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
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
            this.f43344b = i2;
            notifyDataSetChanged();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.f43350h = bdUniqueId;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i2, obj) == null) && (obj instanceof FrsGameStrategyItemListView) && this.f43349g != i2) {
            this.f43349g = i2;
            FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
            this.f43348f = frsGameStrategyItemListView;
            frsGameStrategyItemListView.onEnterForground();
        }
    }
}
