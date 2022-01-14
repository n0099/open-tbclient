package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.t0.q1.h;
import c.a.t0.q1.l.e;
import c.a.t0.q1.o.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static String[] f44636g;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public List<HotTopicView> f44637b;

    /* renamed from: c  reason: collision with root package name */
    public List<e> f44638c;

    /* renamed from: d  reason: collision with root package name */
    public int f44639d;

    /* renamed from: e  reason: collision with root package name */
    public c.f f44640e;

    /* renamed from: f  reason: collision with root package name */
    public c f44641f;

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
        f44636g = new String[]{"最热", "最新"};
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
        this.f44639d = -1;
        this.f44640e = fVar;
        f<?> a = j.a(context);
        if (a instanceof TbPageContext) {
            this.a = (TbPageContext) a;
        }
        this.f44638c = new ArrayList();
        this.f44637b = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.f44640e);
        hotTopicView2.setScrollCallback(this.f44640e);
        this.f44637b.add(hotTopicView);
        this.f44637b.add(hotTopicView2);
    }

    public final void a() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f44639d) < 0) {
            return;
        }
        HotTopicView hotTopicView = this.f44637b.get(i2 % 2);
        e eVar = (e) ListUtils.getItem(this.f44638c, this.f44639d);
        if (hotTopicView != null) {
            hotTopicView.hideLoadingView();
            hotTopicView.hideNetRefreshView();
            hotTopicView.refreshView(eVar);
            if (eVar == null || ListUtils.isEmpty(eVar.i())) {
                hotTopicView.showNetRefreshView(TbadkCoreApplication.getInst().getString(h.neterror), true);
            }
        }
    }

    public void changeListViewFakeHeaderHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || ListUtils.isEmpty(this.f44637b)) {
            return;
        }
        for (HotTopicView hotTopicView : this.f44637b) {
            hotTopicView.changePlaceHolderHeaderViewHeight(i2);
        }
    }

    public void completePullRefresh(boolean z) {
        List<HotTopicView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (list = this.f44637b) == null) {
            return;
        }
        for (HotTopicView hotTopicView : list) {
            if (hotTopicView != null) {
                hotTopicView.completePullRefresh(z);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (HotTopicView hotTopicView : this.f44637b) {
                if (hotTopicView != null) {
                    hotTopicView.destroy();
                }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f44638c) : invokeV.intValue;
    }

    public HotTopicView getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f44639d;
            if (i2 == -1) {
                return null;
            }
            return (HotTopicView) ListUtils.getItem(this.f44637b, i2 % 2);
        }
        return (HotTopicView) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? f44636g[i2] : (CharSequence) invokeI.objValue;
    }

    public void hideLoadMoreView(int i2) {
        List<HotTopicView> list;
        HotTopicView hotTopicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (list = this.f44637b) == null || i2 >= list.size() || (hotTopicView = this.f44637b.get(i2)) == null) {
            return;
        }
        hotTopicView.hideLoadMoreView();
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || getCurrentTab() == null) {
            return;
        }
        getCurrentTab().hideNetRefreshView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void listViewStartPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || getCurrentTab() == null) {
            return;
        }
        getCurrentTab().listViewStartPullRefresh();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            for (int i3 = 0; i3 < this.f44638c.size(); i3++) {
                HotTopicView hotTopicView = this.f44637b.get(i3);
                if (hotTopicView != null) {
                    hotTopicView.onChangeSkinType(i2);
                }
            }
        }
    }

    public void pause() {
        HotTopicView currentTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (currentTab = getCurrentTab()) == null) {
            return;
        }
        currentTab.pause();
    }

    public void resume() {
        HotTopicView currentTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (currentTab = getCurrentTab()) == null) {
            return;
        }
        currentTab.resume();
    }

    public void scrollOtherListView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            for (HotTopicView hotTopicView : this.f44637b) {
                if (hotTopicView != null && hotTopicView != getCurrentTab()) {
                    hotTopicView.scrollListView(i2);
                }
            }
        }
    }

    public void scrollOtherListViewToTop(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            for (HotTopicView hotTopicView : this.f44637b) {
                if (hotTopicView != null && hotTopicView != getCurrentTab()) {
                    hotTopicView.scrollToTop(f2);
                }
            }
        }
    }

    public void setMainView(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.f44641f = cVar;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            int i3 = this.f44639d;
            if (i3 == i2) {
                return;
            }
            this.f44639d = i2;
            if (ListUtils.isEmpty(this.f44638c)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            e eVar = (e) ListUtils.getItem(this.f44638c, this.f44639d);
            if (eVar != null && eVar.h() != null) {
                if (this.f44639d == 0) {
                    TiebaStatic.log(new StatisticItem("c11970").param("obj_id", eVar.h().f21543e));
                } else {
                    TiebaStatic.log(new StatisticItem("c11971").param("obj_id", eVar.h().f21543e));
                }
            }
            HotTopicView hotTopicView = (HotTopicView) ListUtils.getItem(this.f44637b, i3 % 2);
            if (hotTopicView != null) {
                hotTopicView.pause();
            }
            HotTopicView hotTopicView2 = (HotTopicView) ListUtils.getItem(this.f44637b, i2 % 2);
            if (hotTopicView2 != null) {
                if (eVar != null && !ListUtils.isEmpty(eVar.i())) {
                    hotTopicView2.resume();
                } else if (!l.A()) {
                    hotTopicView2.showNetRefreshView(TbadkCoreApplication.getInst().getString(h.neterror), true);
                } else {
                    hotTopicView2.showLoadingView(true);
                    this.a.getOrignalPage().loadHotTopicData();
                }
            }
        }
    }

    public void showLoadMoreView(int i2) {
        List<HotTopicView> list;
        HotTopicView hotTopicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (list = this.f44637b) == null || i2 >= list.size() || (hotTopicView = this.f44637b.get(i2)) == null) {
            return;
        }
        hotTopicView.showLoadMoreView();
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || getCurrentTab() == null) {
            return;
        }
        getCurrentTab().showLoadingView(true);
    }

    public void showNoMoreView(int i2) {
        List<HotTopicView> list;
        HotTopicView hotTopicView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (list = this.f44637b) == null || i2 >= list.size() || (hotTopicView = this.f44637b.get(i2)) == null) {
            return;
        }
        hotTopicView.showNoMoreView();
    }

    public void updateList(List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                this.f44638c.clear();
                this.f44638c.addAll(list);
            }
            notifyDataSetChanged();
            a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) {
            HotTopicView hotTopicView = this.f44637b.get(i2 % 2);
            if (hotTopicView.getParent() != null) {
                viewGroup.removeView(hotTopicView);
            }
            hotTopicView.setMainView(this.f44641f);
            viewGroup.addView(hotTopicView);
            hotTopicView.hideLoadingView();
            hotTopicView.hideNetRefreshView();
            hotTopicView.refreshView(this.f44638c.get(i2));
            return hotTopicView;
        }
        return (HotTopicView) invokeLI.objValue;
    }
}
