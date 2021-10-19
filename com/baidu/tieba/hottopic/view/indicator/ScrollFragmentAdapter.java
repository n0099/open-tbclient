package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.r0.j1.c.j;
import c.a.r0.j1.c.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.view.HotRankView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52833a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f52834b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f52835c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f52836d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f52837e;

    /* renamed from: f  reason: collision with root package name */
    public int f52838f;

    public ScrollFragmentAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52838f = -1;
        this.f52833a = context;
        f<?> a2 = c.a.e.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f52834b = (TbPageContext) a2;
        }
        this.f52836d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f52835c = arrayList;
        arrayList.add(b());
        this.f52835c.add(b());
        this.f52835c.add(b());
    }

    public final HotRankView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f52838f;
            if (i2 == -1) {
                return null;
            }
            return (HotRankView) ListUtils.getItem(this.f52835c, i2 % 3);
        }
        return (HotRankView) invokeV.objValue;
    }

    public final HotRankView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new HotRankView(this.f52833a) : (HotRankView) invokeV.objValue;
    }

    public final void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i2 = this.f52838f) < 0) {
            return;
        }
        HotRankView hotRankView = this.f52835c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f52836d, this.f52838f);
        if (hotRankView != null) {
            hotRankView.hideLoadingView();
            hotRankView.hideNetRefreshView();
            p pVar = (p) ListUtils.getItem(this.f52837e, this.f52838f);
            hotRankView.refreshView(jVar, pVar != null ? pVar.f19508f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.showNetRefreshView(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void completePullRefresh(boolean z) {
        List<HotRankView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (list = this.f52835c) == null) {
            return;
        }
        for (HotRankView hotRankView : list) {
            if (hotRankView != null) {
                hotRankView.completePullRefresh(z);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f52836d) : invokeV.intValue;
    }

    public List<j> getHotTopicRanklistDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52836d : (List) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int count = getCount();
            if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f52836d) || this.f52836d.get(0) == null || ListUtils.isEmpty(this.f52836d.get(0).f19481b)) {
                return null;
            }
            return this.f52836d.get(0).f19481b.get(i2).f19507e;
        }
        return (CharSequence) invokeI.objValue;
    }

    public int getTagIndex(p pVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar)) == null) {
            if (this.f52836d == null) {
                return -1;
            }
            int count = getCount();
            for (int i2 = 0; i2 < count; i2++) {
                p pVar2 = this.f52836d.get(0).f19481b.get(i2);
                if (pVar2 != null && (str = pVar2.f19507e) != null && str.equals(pVar.f19507e)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || a() == null) {
            return;
        }
        a().hideNetRefreshView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) {
            HotRankView hotRankView = this.f52835c.get(i2 % this.f52835c.size());
            if (hotRankView.getParent() != null) {
                viewGroup.removeView(hotRankView);
            }
            j jVar = this.f52836d.get(i2);
            viewGroup.addView(hotRankView);
            hotRankView.hideLoadingView();
            hotRankView.hideNetRefreshView();
            int i3 = this.f52838f;
            if (i3 == -1) {
                str = this.f52837e.get(0).f19508f;
            } else {
                str = this.f52837e.get(i3).f19508f;
            }
            hotRankView.refreshView(jVar, str);
            return hotRankView;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void listViewStartPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || a() == null) {
            return;
        }
        a().listViewStartPullRefresh();
    }

    public void onTabLayoutSizeChanged(View view, int i2, int i3, int i4, int i5) {
        List<HotRankView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (list = this.f52835c) == null) {
            return;
        }
        for (HotRankView hotRankView : list) {
            if (hotRankView != null) {
                hotRankView.onTabLayoutSizeChanged(view, i2, i3, i4, i5);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            for (HotRankView hotRankView : this.f52835c) {
                if (hotRankView != null) {
                    hotRankView.onChangeSkinType();
                }
            }
            if (this.f52838f == i2) {
                return;
            }
            this.f52838f = i2;
            if (ListUtils.isEmpty(this.f52836d)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            j jVar = this.f52836d.get(this.f52838f);
            List<HotRankView> list = this.f52835c;
            HotRankView hotRankView2 = list.get(i2 % list.size());
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                if (!c.a.e.e.p.j.A()) {
                    hotRankView2.showNetRefreshView(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    return;
                }
                hotRankView2.showLoadingView(true, 0);
                ((HotRanklistActivity) this.f52834b.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || a() == null) {
            return;
        }
        a().showLoadingView(true, l.g(this.f52834b.getPageActivity(), R.dimen.ds500));
    }

    public void updateList(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            if (this.f52836d == null) {
                this.f52836d = new ArrayList();
            }
            if (!ListUtils.isEmpty(list)) {
                this.f52836d.clear();
                this.f52836d.addAll(list);
            }
            if (this.f52837e == null && !ListUtils.isEmpty(this.f52836d)) {
                ArrayList arrayList = new ArrayList();
                this.f52837e = arrayList;
                arrayList.clear();
                this.f52837e.addAll(this.f52836d.get(0).f19481b);
            }
            notifyDataSetChanged();
            c();
        }
    }
}
