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
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
import com.repackage.b45;
import com.repackage.gu6;
import com.repackage.jc6;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.kl4;
import com.repackage.nb;
import com.repackage.nt6;
import com.repackage.ot6;
import com.repackage.qn;
import com.repackage.sn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicTabFragment extends BaseFragment implements jc6, ot6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicTabModel a;
    public HotTopicTabView b;
    public FrsTabItemData c;
    public TabLayout.OnTabSelectedListener d;
    public kl4<Object> e;
    public boolean f;

    /* loaded from: classes3.dex */
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
                    this.a.a.I(str);
                    this.a.a.setTabId(frsTabItemData.tabId);
                    if (this.a.a.loadData()) {
                        this.a.b.y();
                        this.a.b.i();
                        this.a.b.j();
                        this.a.Q0();
                    } else {
                        this.a.b.y();
                        this.a.b.i();
                        List<jn> E = this.a.a.E(str);
                        if (!ListUtils.isEmpty(E)) {
                            this.a.b.setListData(E);
                        } else {
                            this.a.N0();
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
                this.a.b.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements kl4<Object> {
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

        @Override // com.repackage.kl4
        public void a(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            nt6.a(view2, obj, i + 1, this.a.K0());
        }

        @Override // com.repackage.kl4
        public void c(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            nt6.b(view2, obj, this.a.K0());
        }
    }

    /* loaded from: classes3.dex */
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
                this.b.L0(this.a);
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

    @Override // com.repackage.jc6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.a;
            return hotTopicTabModel != null ? String.valueOf(hotTopicTabModel.getTabId() + 1) : "1";
        }
        return (String) invokeV.objValue;
    }

    public void L0(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.f) {
            this.f = false;
            TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
            this.a = new HotTopicTabModel(pageContext);
            HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
            this.b = hotTopicTabView;
            hotTopicTabView.setOnTabSelectedListener(this.d);
            this.b.setOnItemCoverListener(this.e);
        }
    }

    public void M0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b.p()) {
                this.b.j();
                P0();
                return;
            }
            this.b.v(false);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.b.p()) {
                this.b.i();
                Q0();
                return;
            }
            this.b.u(false);
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList arrayList = new ArrayList();
            sn snVar = new sn();
            snVar.b = R.drawable.new_pic_emotion_05;
            snVar.a = getString(R.string.obfuscated_res_0x7f0f0c4c);
            arrayList.add(snVar);
            this.b.k();
            this.b.setListData(arrayList);
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new qn());
            this.b.k();
            this.b.setListData(arrayList);
        }
    }

    @Override // com.repackage.ot6
    public void W(int i, gu6 gu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, gu6Var) == null) {
            this.b.i();
            this.b.j();
            this.b.y();
            if (gu6Var != null && i == 0 && !ListUtils.isEmpty(gu6Var.getDataList())) {
                this.b.setData(gu6Var);
                this.b.w();
            } else if (ListUtils.isEmpty(this.a.D())) {
                N0();
            } else {
                this.b.setListData(this.a.D());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.f75
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

    @Override // com.repackage.jc6
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.s();
        }
    }

    @Override // com.repackage.ot6
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean loadData = this.a.loadData();
            HotTopicTabModel hotTopicTabModel = this.a;
            List<jn> E = hotTopicTabModel.E(hotTopicTabModel.F());
            if (loadData) {
                if (!ListUtils.isEmpty(E) || this.b.p()) {
                    return;
                }
                this.b.y();
                this.b.j();
                O0();
                return;
            }
            this.b.y();
            this.b.i();
            if (!ListUtils.isEmpty(E)) {
                this.b.setListData(E);
            } else if (ji.A()) {
            } else {
                N0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a.H(this);
            this.a.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b.q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            L0(getContext());
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            if (!this.f) {
                this.b.h();
                this.a.onDestroy();
            }
            this.f = false;
            b45.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.b.setViewForeground();
            }
        }
    }

    @Override // com.repackage.jc6
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.repackage.jc6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
        nb.b().a("hotTopic", new c(this, context));
        SpeedStatsManager.getInstance().addStatsTimeStamp(5027);
    }
}
