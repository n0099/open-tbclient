package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import b.a.e.a.f;
import b.a.e.e.p.l;
import b.a.r0.j1.c;
import b.a.r0.j1.h;
import b.a.r0.j1.l.j;
import b.a.r0.j1.l.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.view.HotRankView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f50102a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f50103b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f50104c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f50105d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f50106e;

    /* renamed from: f  reason: collision with root package name */
    public int f50107f;

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
        this.f50107f = -1;
        this.f50102a = context;
        f<?> a2 = b.a.e.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f50103b = (TbPageContext) a2;
        }
        this.f50105d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f50104c = arrayList;
        arrayList.add(b());
        this.f50104c.add(b());
        this.f50104c.add(b());
    }

    public final HotRankView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f50107f;
            if (i2 == -1) {
                return null;
            }
            return (HotRankView) ListUtils.getItem(this.f50104c, i2 % 3);
        }
        return (HotRankView) invokeV.objValue;
    }

    public final HotRankView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new HotRankView(this.f50102a) : (HotRankView) invokeV.objValue;
    }

    public final void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i2 = this.f50107f) < 0) {
            return;
        }
        HotRankView hotRankView = this.f50104c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f50105d, this.f50107f);
        if (hotRankView != null) {
            hotRankView.hideLoadingView();
            hotRankView.hideNetRefreshView();
            p pVar = (p) ListUtils.getItem(this.f50106e, this.f50107f);
            hotRankView.refreshView(jVar, pVar != null ? pVar.f18486f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.showNetRefreshView(TbadkCoreApplication.getInst().getString(h.neterror), true);
            }
        }
    }

    public void completePullRefresh(boolean z) {
        List<HotRankView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (list = this.f50104c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f50105d) : invokeV.intValue;
    }

    public List<j> getHotTopicRanklistDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50105d : (List) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int count = getCount();
            if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f50105d) || this.f50105d.get(0) == null || ListUtils.isEmpty(this.f50105d.get(0).f18461b)) {
                return null;
            }
            return this.f50105d.get(0).f18461b.get(i2).f18485e;
        }
        return (CharSequence) invokeI.objValue;
    }

    public int getTagIndex(p pVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar)) == null) {
            if (this.f50105d == null) {
                return -1;
            }
            int count = getCount();
            for (int i2 = 0; i2 < count; i2++) {
                p pVar2 = this.f50105d.get(0).f18461b.get(i2);
                if (pVar2 != null && (str = pVar2.f18485e) != null && str.equals(pVar.f18485e)) {
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
            HotRankView hotRankView = this.f50104c.get(i2 % this.f50104c.size());
            if (hotRankView.getParent() != null) {
                viewGroup.removeView(hotRankView);
            }
            j jVar = this.f50105d.get(i2);
            viewGroup.addView(hotRankView);
            hotRankView.hideLoadingView();
            hotRankView.hideNetRefreshView();
            int i3 = this.f50107f;
            if (i3 == -1) {
                str = this.f50106e.get(0).f18486f;
            } else {
                str = this.f50106e.get(i3).f18486f;
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
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (list = this.f50104c) == null) {
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
            for (HotRankView hotRankView : this.f50104c) {
                if (hotRankView != null) {
                    hotRankView.onChangeSkinType();
                }
            }
            if (this.f50107f == i2) {
                return;
            }
            this.f50107f = i2;
            if (ListUtils.isEmpty(this.f50105d)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            j jVar = this.f50105d.get(this.f50107f);
            List<HotRankView> list = this.f50104c;
            HotRankView hotRankView2 = list.get(i2 % list.size());
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                if (!b.a.e.e.p.j.A()) {
                    hotRankView2.showNetRefreshView(TbadkCoreApplication.getInst().getString(h.neterror), true);
                    return;
                }
                hotRankView2.showLoadingView(true, 0);
                ((HotRanklistActivity) this.f50103b.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || a() == null) {
            return;
        }
        a().showLoadingView(true, l.g(this.f50103b.getPageActivity(), c.ds500));
    }

    public void updateList(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            if (this.f50105d == null) {
                this.f50105d = new ArrayList();
            }
            if (!ListUtils.isEmpty(list)) {
                this.f50105d.clear();
                this.f50105d.addAll(list);
            }
            if (this.f50106e == null && !ListUtils.isEmpty(this.f50105d)) {
                ArrayList arrayList = new ArrayList();
                this.f50106e = arrayList;
                arrayList.clear();
                this.f50106e.addAll(this.f50105d.get(0).f18461b);
            }
            notifyDataSetChanged();
            c();
        }
    }
}
