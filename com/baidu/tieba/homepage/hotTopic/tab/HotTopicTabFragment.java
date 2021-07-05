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
import d.a.r0.m.f;
import d.a.r0.z0.b0;
import d.a.s0.u0.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicTabFragment extends BaseFragment implements n0, d.a.s0.e1.f.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f16609e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f16610f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f16611g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f16612h;

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f16613i;

    /* loaded from: classes5.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f16614a;

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
            this.f16614a = hotTopicTabFragment;
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
                if (this.f16614a.f16611g != null && this.f16614a.f16611g.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    this.f16614a.f16609e.G(str);
                    if (this.f16614a.f16609e.LoadData()) {
                        this.f16614a.f16610f.y();
                        this.f16614a.f16610f.h();
                        this.f16614a.f16610f.i();
                        this.f16614a.R0();
                    } else {
                        this.f16614a.f16610f.y();
                        this.f16614a.f16610f.h();
                        List<n> C = this.f16614a.f16609e.C(str);
                        if (!ListUtils.isEmpty(C)) {
                            this.f16614a.f16610f.setListData(C);
                        } else {
                            this.f16614a.O0();
                        }
                    }
                }
                this.f16614a.f16611g = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.f16614a.f16610f.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f16615e;

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
            this.f16615e = hotTopicTabFragment;
        }

        @Override // d.a.r0.m.f
        public void a(View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            d.a.s0.e1.f.a.a.a(view, obj, i2 + 1, this.f16615e.M0());
        }

        @Override // d.a.r0.m.f
        public void c(View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            d.a.s0.e1.f.a.a.b(view, obj, this.f16615e.M0());
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
        this.f16612h = new a(this);
        this.f16613i = new b(this);
    }

    @Override // d.a.s0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.f16609e;
            return hotTopicTabModel != null ? hotTopicTabModel.D() : "";
        }
        return (String) invokeV.objValue;
    }

    public void N0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.f16610f) == null) {
            return;
        }
        hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f16610f.p()) {
                this.f16610f.i();
                Q0();
                return;
            }
            this.f16610f.v(false);
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f16610f.p()) {
                this.f16610f.h();
                R0();
                return;
            }
            this.f16610f.u(false);
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f44919f = R.drawable.new_pic_emotion_05;
            vVar.f44918e = getString(R.string.no_data_common_txt);
            arrayList.add(vVar);
            this.f16610f.k();
            this.f16610f.setListData(arrayList);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new t());
            this.f16610f.k();
            this.f16610f.setListData(arrayList);
        }
    }

    @Override // d.a.s0.e1.f.a.b
    public void Z(int i2, d.a.s0.e1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, aVar) == null) {
            this.f16610f.h();
            this.f16610f.i();
            this.f16610f.y();
            if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
                this.f16610f.setData(aVar);
                this.f16610f.w();
            } else if (ListUtils.isEmpty(this.f16609e.B())) {
                O0();
            } else {
                this.f16610f.setListData(this.f16609e.B());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
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

    @Override // d.a.s0.e1.f.a.b
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean LoadData = this.f16609e.LoadData();
            HotTopicTabModel hotTopicTabModel = this.f16609e;
            List<n> C = hotTopicTabModel.C(hotTopicTabModel.D());
            if (LoadData) {
                if (!ListUtils.isEmpty(C) || this.f16610f.p()) {
                    return;
                }
                this.f16610f.y();
                this.f16610f.i();
                P0();
                return;
            }
            this.f16610f.y();
            this.f16610f.h();
            if (!ListUtils.isEmpty(C)) {
                this.f16610f.setListData(C);
            } else if (j.A()) {
            } else {
                O0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f16610f.q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            this.f16609e.F(this);
            this.f16609e.setUniqueId(getUniqueId());
            this.f16610f.setPresenter(this);
            this.f16610f.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f16610f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f16610f.getParent()).removeView(this.f16610f);
            }
            return this.f16610f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroyView();
            this.f16610f.g();
            this.f16609e.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.f16610f.setViewForeground();
            }
        }
    }

    @Override // d.a.s0.u0.n0
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f16610f.s();
        }
    }

    @Override // d.a.s0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
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
        this.f16612h = new a(this);
        this.f16613i = new b(this);
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f16609e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f16610f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f16612h);
        this.f16610f.setOnItemCoverListener(this.f16613i);
    }
}
