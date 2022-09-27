package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.fz6;
import com.baidu.tieba.gc;
import com.baidu.tieba.gz6;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.ii6;
import com.baidu.tieba.ko;
import com.baidu.tieba.mo;
import com.baidu.tieba.o95;
import com.baidu.tieba.qp4;
import com.baidu.tieba.zz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements ii6, gz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicTabModel a;
    public HotTopicTabView b;
    public FrsTabItemData c;
    public TabLayout.OnTabSelectedListener d;
    public qp4<Object> e;
    public boolean f;

    /* loaded from: classes4.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabFragment a;

        public a(HotTopicTabFragment hotTopicTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabFragment;
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
                if (this.a.c != null && this.a.c.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    this.a.a.J(str);
                    this.a.a.setTabId(frsTabItemData.tabId);
                    if (this.a.a.loadData()) {
                        this.a.b.D();
                        this.a.b.m();
                        this.a.b.n();
                        this.a.D1();
                    } else {
                        this.a.b.D();
                        this.a.b.m();
                        List<Cdo> F = this.a.a.F(str);
                        if (!ListUtils.isEmpty(F)) {
                            this.a.b.setListData(F);
                        } else {
                            this.a.A1();
                        }
                    }
                }
                this.a.c = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.a.b.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements qp4<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabFragment a;

        public b(HotTopicTabFragment hotTopicTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabFragment;
        }

        @Override // com.baidu.tieba.qp4
        public void c(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            fz6.a(view2, obj, i + 1, this.a.w1());
        }

        @Override // com.baidu.tieba.qp4
        public void d(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            fz6.b(view2, obj, this.a.w1());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HotTopicTabFragment b;

        public c(HotTopicTabFragment hotTopicTabFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hotTopicTabFragment;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.x1(this.a);
            }
        }
    }

    public HotTopicTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.e = new b(this);
        this.f = true;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b.t()) {
                this.b.n();
                C1();
                return;
            }
            this.b.A(false);
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.b.t()) {
                this.b.m();
                D1();
                return;
            }
            this.b.z(false);
        }
    }

    @Override // com.baidu.tieba.gz6
    public void C0(int i, zz6 zz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, zz6Var) == null) {
            this.b.m();
            this.b.n();
            this.b.D();
            if (zz6Var != null && i == 0 && !ListUtils.isEmpty(zz6Var.getDataList())) {
                this.b.setData(zz6Var);
                this.b.B();
            } else if (ListUtils.isEmpty(this.a.E())) {
                A1();
            } else {
                this.b.setListData(this.a.E());
            }
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList();
            mo moVar = new mo();
            moVar.b = R.drawable.new_pic_emotion_05;
            moVar.a = getString(R.string.obfuscated_res_0x7f0f0c72);
            arrayList.add(moVar);
            this.b.o();
            this.b.setListData(arrayList);
        }
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ko());
            this.b.o();
            this.b.setListData(arrayList);
        }
    }

    @Override // com.baidu.tieba.ii6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.gz6
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean loadData = this.a.loadData();
            HotTopicTabModel hotTopicTabModel = this.a;
            List<Cdo> F = hotTopicTabModel.F(hotTopicTabModel.G());
            if (loadData) {
                if (!ListUtils.isEmpty(F) || this.b.t()) {
                    return;
                }
                this.b.D();
                this.b.n();
                B1();
                return;
            }
            this.b.D();
            this.b.m();
            if (!ListUtils.isEmpty(F)) {
                this.b.setListData(F);
            } else if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            } else {
                A1();
            }
        }
    }

    @Override // com.baidu.tieba.ii6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        hotTopicTabView.u();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a.I(this);
            this.a.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            x1(getContext());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            this.b.setPresenter(this);
            this.b.setUniqueId(getUniqueId());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_START_STAMP_KEY);
            if (this.b.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.b;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroyView();
            if (!this.f) {
                this.b.l();
                this.a.onDestroy();
            }
            this.f = false;
            o95.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.b.setViewForeground();
            }
        }
    }

    @Override // com.baidu.tieba.ii6
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.b.x();
        }
    }

    public final String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.a;
            return hotTopicTabModel != null ? String.valueOf(hotTopicTabModel.getTabId() + 1) : "1";
        }
        return (String) invokeV.objValue;
    }

    public void x1(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, context) == null) && this.f) {
            this.f = false;
            TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
            this.a = new HotTopicTabModel(pageContext);
            HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext, getArguments() == null ? "" : getArguments().getString("tab_name"));
            this.b = hotTopicTabView;
            hotTopicTabView.setOnTabSelectedListener(this.d);
            this.b.setOnItemCoverListener(this.e);
        }
    }

    @Override // com.baidu.tieba.ii6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void z1(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.e = new b(this);
        this.f = true;
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_START_STAMP_KEY);
        gc.b().a("hotTopic", new c(this, context));
        SpeedStatsManager.getInstance().addStatsTimeStamp(5027);
    }
}
