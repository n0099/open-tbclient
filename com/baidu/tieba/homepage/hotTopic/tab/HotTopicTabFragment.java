package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.c.k.e.t;
import d.a.c.k.e.v;
import d.a.o0.m.f;
import d.a.o0.z0.b0;
import d.a.p0.u0.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements n0, d.a.p0.e1.f.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f16648e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f16649f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f16650g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f16651h;

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f16652i;

    /* loaded from: classes4.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f16653a;

        public a(HotTopicTabFragment hotTopicTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16653a = hotTopicTabFragment;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) && tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
                if (this.f16653a.f16650g != null && this.f16653a.f16650g.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    this.f16653a.f16648e.G(str);
                    if (this.f16653a.f16648e.LoadData()) {
                        this.f16653a.f16649f.y();
                        this.f16653a.f16649f.h();
                        this.f16653a.f16649f.j();
                        this.f16653a.S0();
                    } else {
                        this.f16653a.f16649f.y();
                        this.f16653a.f16649f.h();
                        List<n> C = this.f16653a.f16648e.C(str);
                        if (!ListUtils.isEmpty(C)) {
                            this.f16653a.f16649f.setListData(C);
                        } else {
                            this.f16653a.P0();
                        }
                    }
                }
                this.f16653a.f16650g = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.f16653a.f16649f.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f16654e;

        public b(HotTopicTabFragment hotTopicTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16654e = hotTopicTabFragment;
        }

        @Override // d.a.o0.m.f
        public void a(View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            d.a.p0.e1.f.a.a.a(view, obj, i2 + 1, this.f16654e.N0());
        }

        @Override // d.a.o0.m.f
        public void c(View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            d.a.p0.e1.f.a.a.b(view, obj, this.f16654e.N0());
        }
    }

    public HotTopicTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16651h = new a(this);
        this.f16652i = new b(this);
    }

    @Override // d.a.p0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.p0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.f16648e;
            return hotTopicTabModel != null ? hotTopicTabModel.D() : "";
        }
        return (String) invokeV.objValue;
    }

    public void O0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.f16649f) == null) {
            return;
        }
        hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f16649f.p()) {
                this.f16649f.j();
                R0();
                return;
            }
            this.f16649f.v(false);
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f16649f.p()) {
                this.f16649f.h();
                S0();
                return;
            }
            this.f16649f.u(false);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f41935f = R.drawable.new_pic_emotion_05;
            vVar.f41934e = getString(R.string.no_data_common_txt);
            arrayList.add(vVar);
            this.f16649f.k();
            this.f16649f.setListData(arrayList);
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new t());
            this.f16649f.k();
            this.f16649f.setListData(arrayList);
        }
    }

    @Override // d.a.p0.e1.f.a.b
    public void Z(int i2, d.a.p0.e1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, aVar) == null) {
            this.f16649f.h();
            this.f16649f.j();
            this.f16649f.y();
            if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
                this.f16649f.setData(aVar);
                this.f16649f.w();
            } else if (ListUtils.isEmpty(this.f16648e.B())) {
                P0();
            } else {
                this.f16649f.setListData(this.f16648e.B());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.o0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.o0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (super.getCurrentPageSourceKeyList() != null) {
                arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
            } else {
                arrayList = new ArrayList();
            }
            if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
                arrayList.add("a001");
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.p0.e1.f.a.b
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean LoadData = this.f16648e.LoadData();
            HotTopicTabModel hotTopicTabModel = this.f16648e;
            List<n> C = hotTopicTabModel.C(hotTopicTabModel.D());
            if (LoadData) {
                if (!ListUtils.isEmpty(C) || this.f16649f.p()) {
                    return;
                }
                this.f16649f.y();
                this.f16649f.j();
                Q0();
                return;
            }
            this.f16649f.y();
            this.f16649f.h();
            if (!ListUtils.isEmpty(C)) {
                this.f16649f.setListData(C);
            } else if (j.A()) {
            } else {
                P0();
            }
        }
    }

    @Override // d.a.p0.u0.n0
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f16649f.s();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f16649f.q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            this.f16648e.F(this);
            this.f16648e.setUniqueId(getUniqueId());
            this.f16649f.setPresenter(this);
            this.f16649f.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f16649f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f16649f.getParent()).removeView(this.f16649f);
            }
            return this.f16649f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            this.f16649f.g();
            this.f16648e.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.f16649f.setViewForeground();
            }
        }
    }

    @Override // d.a.p0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // d.a.p0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // d.a.p0.u0.n0
    public void x(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b0Var) == null) {
        }
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16651h = new a(this);
        this.f16652i = new b(this);
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f16648e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f16649f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f16651h);
        this.f16649f.setOnItemCoverListener(this.f16652i);
    }
}
