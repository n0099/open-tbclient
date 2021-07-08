package com.baidu.tieba.hottopic.adapter;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.p0.g1.c.e;
import d.a.p0.g1.f.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static String[] f17055g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f17056a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicView> f17057b;

    /* renamed from: c  reason: collision with root package name */
    public List<e> f17058c;

    /* renamed from: d  reason: collision with root package name */
    public int f17059d;

    /* renamed from: e  reason: collision with root package name */
    public c.f f17060e;

    /* renamed from: f  reason: collision with root package name */
    public c f17061f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-387841820, "Lcom/baidu/tieba/hottopic/adapter/HotTopicThreadPagerAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-387841820, "Lcom/baidu/tieba/hottopic/adapter/HotTopicThreadPagerAdapter;");
                return;
            }
        }
        f17055g = new String[]{"最热", "最新"};
    }

    public HotTopicThreadPagerAdapter(Context context, c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17059d = -1;
        this.f17060e = fVar;
        f<?> a2 = j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17056a = (TbPageContext) a2;
        }
        this.f17058c = new ArrayList();
        this.f17057b = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.f17060e);
        hotTopicView2.setScrollCallback(this.f17060e);
        this.f17057b.add(hotTopicView);
        this.f17057b.add(hotTopicView2);
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || ListUtils.isEmpty(this.f17057b)) {
            return;
        }
        for (HotTopicView hotTopicView : this.f17057b) {
            hotTopicView.k(i2);
        }
    }

    public void c(boolean z) {
        List<HotTopicView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f17057b) == null) {
            return;
        }
        for (HotTopicView hotTopicView : list) {
            if (hotTopicView != null) {
                hotTopicView.m(z);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (HotTopicView hotTopicView : this.f17057b) {
                if (hotTopicView != null) {
                    hotTopicView.n();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
        }
    }

    public HotTopicView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f17059d;
            if (i2 == -1) {
                return null;
            }
            return (HotTopicView) ListUtils.getItem(this.f17057b, i2 % 2);
        }
        return (HotTopicView) invokeV.objValue;
    }

    public void f(int i2) {
        List<HotTopicView> list;
        HotTopicView hotTopicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (list = this.f17057b) == null || i2 >= list.size() || (hotTopicView = this.f17057b.get(i2)) == null) {
            return;
        }
        hotTopicView.p();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || e() == null) {
            return;
        }
        e().r();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f17058c) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? f17055g[i2] : (CharSequence) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: h */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) {
            HotTopicView hotTopicView = this.f17057b.get(i2 % 2);
            if (hotTopicView.getParent() != null) {
                viewGroup.removeView(hotTopicView);
            }
            hotTopicView.setMainView(this.f17061f);
            viewGroup.addView(hotTopicView);
            hotTopicView.q();
            hotTopicView.r();
            hotTopicView.A(this.f17058c.get(i2));
            return hotTopicView;
        }
        return (HotTopicView) invokeLI.objValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            for (int i3 = 0; i3 < this.f17058c.size(); i3++) {
                HotTopicView hotTopicView = this.f17057b.get(i3);
                if (hotTopicView != null) {
                    hotTopicView.w(i2);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j() {
        HotTopicView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (e2 = e()) == null) {
            return;
        }
        e2.z();
    }

    public final void k() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (i2 = this.f17059d) < 0) {
            return;
        }
        HotTopicView hotTopicView = this.f17057b.get(i2 % 2);
        e eVar = (e) ListUtils.getItem(this.f17058c, this.f17059d);
        if (hotTopicView != null) {
            hotTopicView.q();
            hotTopicView.r();
            hotTopicView.A(eVar);
            if (eVar == null || ListUtils.isEmpty(eVar.i())) {
                hotTopicView.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            }
        }
    }

    public void l() {
        HotTopicView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (e2 = e()) == null) {
            return;
        }
        e2.B();
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            for (HotTopicView hotTopicView : this.f17057b) {
                if (hotTopicView != null && hotTopicView != e()) {
                    hotTopicView.C(i2);
                }
            }
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            for (HotTopicView hotTopicView : this.f17057b) {
                if (hotTopicView != null && hotTopicView != e()) {
                    hotTopicView.D(f2);
                }
            }
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.f17061f = cVar;
        }
    }

    public void p(int i2) {
        List<HotTopicView> list;
        HotTopicView hotTopicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (list = this.f17057b) == null || i2 >= list.size() || (hotTopicView = this.f17057b.get(i2)) == null) {
            return;
        }
        hotTopicView.E();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || e() == null) {
            return;
        }
        e().F(true);
    }

    public void r(int i2) {
        List<HotTopicView> list;
        HotTopicView hotTopicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (list = this.f17057b) == null || i2 >= list.size() || (hotTopicView = this.f17057b.get(i2)) == null) {
            return;
        }
        hotTopicView.H();
    }

    public void s(List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                this.f17058c.clear();
                this.f17058c.addAll(list);
            }
            notifyDataSetChanged();
            k();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            int i3 = this.f17059d;
            if (i3 == i2) {
                return;
            }
            this.f17059d = i2;
            if (ListUtils.isEmpty(this.f17058c)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            e eVar = (e) ListUtils.getItem(this.f17058c, this.f17059d);
            if (eVar != null && eVar.h() != null) {
                if (this.f17059d == 0) {
                    TiebaStatic.log(new StatisticItem("c11970").param("obj_id", eVar.h().f56416e));
                } else {
                    TiebaStatic.log(new StatisticItem("c11971").param("obj_id", eVar.h().f56416e));
                }
            }
            HotTopicView hotTopicView = (HotTopicView) ListUtils.getItem(this.f17057b, i3 % 2);
            if (hotTopicView != null) {
                hotTopicView.z();
            }
            HotTopicView hotTopicView2 = (HotTopicView) ListUtils.getItem(this.f17057b, i2 % 2);
            if (hotTopicView2 != null) {
                if (eVar != null && !ListUtils.isEmpty(eVar.i())) {
                    hotTopicView2.B();
                } else if (!d.a.c.e.p.j.A()) {
                    hotTopicView2.G(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                } else {
                    hotTopicView2.F(true);
                    this.f17056a.getOrignalPage().loadHotTopicData();
                }
            }
        }
    }
}
