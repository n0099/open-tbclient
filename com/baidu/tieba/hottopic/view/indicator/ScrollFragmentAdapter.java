package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
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
import d.a.d.a.f;
import d.a.d.e.p.l;
import d.a.q0.g1.c.j;
import d.a.q0.g1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f17285a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f17286b;

    /* renamed from: c  reason: collision with root package name */
    public List<HotRankView> f17287c;

    /* renamed from: d  reason: collision with root package name */
    public List<j> f17288d;

    /* renamed from: e  reason: collision with root package name */
    public List<p> f17289e;

    /* renamed from: f  reason: collision with root package name */
    public int f17290f;

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
        this.f17290f = -1;
        this.f17285a = context;
        f<?> a2 = d.a.d.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17286b = (TbPageContext) a2;
        }
        this.f17288d = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f17287c = arrayList;
        arrayList.add(g());
        this.f17287c.add(g());
        this.f17287c.add(g());
    }

    public void b(boolean z) {
        List<HotRankView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (list = this.f17287c) == null) {
            return;
        }
        for (HotRankView hotRankView : list) {
            if (hotRankView != null) {
                hotRankView.c(z);
            }
        }
    }

    public final HotRankView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f17290f;
            if (i2 == -1) {
                return null;
            }
            return (HotRankView) ListUtils.getItem(this.f17287c, i2 % 3);
        }
        return (HotRankView) invokeV.objValue;
    }

    public List<j> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17288d : (List) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
        }
    }

    public int e(p pVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pVar)) == null) {
            if (this.f17288d == null) {
                return -1;
            }
            int count = getCount();
            for (int i2 = 0; i2 < count; i2++) {
                p pVar2 = this.f17288d.get(0).f56974b.get(i2);
                if (pVar2 != null && (str = pVar2.f56998e) != null && str.equals(pVar.f56998e)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c() == null) {
            return;
        }
        c().e();
    }

    public final HotRankView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new HotRankView(this.f17285a) : (HotRankView) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f17288d) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int count = getCount();
            if (i2 < 0 || i2 >= count || ListUtils.isEmpty(this.f17288d) || this.f17288d.get(0) == null || ListUtils.isEmpty(this.f17288d.get(0).f56974b)) {
                return null;
            }
            return this.f17288d.get(0).f56974b.get(i2).f56998e;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(View view, int i2, int i3, int i4, int i5) {
        List<HotRankView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (list = this.f17287c) == null) {
            return;
        }
        for (HotRankView hotRankView : list) {
            if (hotRankView != null) {
                hotRankView.j(view, i2, i3, i4, i5);
            }
        }
    }

    public final void i() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (i2 = this.f17290f) < 0) {
            return;
        }
        HotRankView hotRankView = this.f17287c.get(i2 % 3);
        j jVar = (j) ListUtils.getItem(this.f17288d, this.f17290f);
        if (hotRankView != null) {
            hotRankView.d();
            hotRankView.e();
            p pVar = (p) ListUtils.getItem(this.f17289e, this.f17290f);
            hotRankView.k(jVar, pVar != null ? pVar.f56999f : "");
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                hotRankView.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            HotRankView hotRankView = this.f17287c.get(i2 % this.f17287c.size());
            if (hotRankView.getParent() != null) {
                viewGroup.removeView(hotRankView);
            }
            j jVar = this.f17288d.get(i2);
            viewGroup.addView(hotRankView);
            hotRankView.d();
            hotRankView.e();
            int i3 = this.f17290f;
            if (i3 == -1) {
                str = this.f17289e.get(0).f56999f;
            } else {
                str = this.f17289e.get(i3).f56999f;
            }
            hotRankView.k(jVar, str);
            return hotRankView;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || c() == null) {
            return;
        }
        c().l(true, l.g(this.f17286b.getPageActivity(), R.dimen.ds500));
    }

    public void k(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            if (this.f17288d == null) {
                this.f17288d = new ArrayList();
            }
            if (!ListUtils.isEmpty(list)) {
                this.f17288d.clear();
                this.f17288d.addAll(list);
            }
            if (this.f17289e == null && !ListUtils.isEmpty(this.f17288d)) {
                ArrayList arrayList = new ArrayList();
                this.f17289e = arrayList;
                arrayList.clear();
                this.f17289e.addAll(this.f17288d.get(0).f56974b);
            }
            notifyDataSetChanged();
            i();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048591, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            for (HotRankView hotRankView : this.f17287c) {
                if (hotRankView != null) {
                    hotRankView.i();
                }
            }
            if (this.f17290f == i2) {
                return;
            }
            this.f17290f = i2;
            if (ListUtils.isEmpty(this.f17288d)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            j jVar = this.f17288d.get(this.f17290f);
            List<HotRankView> list = this.f17287c;
            HotRankView hotRankView2 = list.get(i2 % list.size());
            if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                if (!d.a.d.e.p.j.A()) {
                    hotRankView2.m(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    return;
                }
                hotRankView2.l(true, 0);
                ((HotRanklistActivity) this.f17286b.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }
}
