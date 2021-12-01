package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.m.e.n;
import c.a.d.m.e.t;
import c.a.d.m.e.v;
import c.a.q0.n.f;
import c.a.r0.d1.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.IdleLaunchTask;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.taskmanager.IdleLaunchTaskManager;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class HotTopicTabFragment extends BaseFragment implements o0, c.a.r0.n1.f.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f45240e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f45241f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f45242g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f45243h;

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f45244i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f45245j;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f45242g != null && this.a.f45242g.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    this.a.f45240e.G(str);
                    this.a.f45240e.setTabId(frsTabItemData.tabId);
                    if (this.a.f45240e.loadData()) {
                        this.a.f45241f.stopPullRefresh();
                        this.a.f45241f.hideLoadingView();
                        this.a.f45241f.hideNetRefreshView();
                        this.a.showTabLoadingView();
                    } else {
                        this.a.f45241f.stopPullRefresh();
                        this.a.f45241f.hideLoadingView();
                        List<n> C = this.a.f45240e.C(str);
                        if (!ListUtils.isEmpty(C)) {
                            this.a.f45241f.setListData(C);
                        } else {
                            this.a.showEmptyView();
                        }
                    }
                }
                this.a.f45242g = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.a.f45241f.stopPullRefresh();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements f<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f45246e;

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
            this.f45246e = hotTopicTabFragment;
        }

        @Override // c.a.q0.n.f
        public void a(View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || obj == null) {
                return;
            }
            c.a.r0.n1.f.a.a.a(view, obj, i2 + 1, this.f45246e.j());
        }

        @Override // c.a.q0.n.f
        public void c(View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || obj == null) {
                return;
            }
            c.a.r0.n1.f.a.a.b(view, obj, this.f45246e.j());
        }
    }

    /* loaded from: classes10.dex */
    public class c extends IdleLaunchTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f45248f;

        public c(HotTopicTabFragment hotTopicTabFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45248f = hotTopicTabFragment;
            this.f45247e = context;
        }

        @Override // com.baidu.searchbox.launch.SmartLaunchTask
        public void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45248f.k(this.f45247e);
            }
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
        this.f45243h = new a(this);
        this.f45244i = new b(this);
        this.f45245j = true;
    }

    @Override // c.a.r0.d1.o0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f45241f.forceRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.p0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.f45240e;
            return hotTopicTabModel != null ? String.valueOf(hotTopicTabModel.getTabId() + 1) : "1";
        }
        return (String) invokeV.objValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f45245j) {
            this.f45245j = false;
            TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
            this.f45240e = new HotTopicTabModel(pageContext);
            HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
            this.f45241f = hotTopicTabView;
            hotTopicTabView.setOnTabSelectedListener(this.f45243h);
            this.f45241f.setOnItemCoverListener(this.f45244i);
        }
    }

    @Override // c.a.r0.n1.f.a.b
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean loadData = this.f45240e.loadData();
            HotTopicTabModel hotTopicTabModel = this.f45240e;
            List<n> C = hotTopicTabModel.C(hotTopicTabModel.D());
            if (loadData) {
                if (!ListUtils.isEmpty(C) || this.f45241f.isShownHeaderView()) {
                    return;
                }
                this.f45241f.stopPullRefresh();
                this.f45241f.hideNetRefreshView();
                showLoadingView();
                return;
            }
            this.f45241f.stopPullRefresh();
            this.f45241f.hideLoadingView();
            if (!ListUtils.isEmpty(C)) {
                this.f45241f.setListData(C);
            } else if (j.A()) {
            } else {
                showEmptyView();
            }
        }
    }

    @Override // c.a.r0.n1.f.a.b
    public void netCallback(int i2, c.a.r0.n1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, aVar) == null) {
            this.f45241f.hideLoadingView();
            this.f45241f.hideNetRefreshView();
            this.f45241f.stopPullRefresh();
            if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
                this.f45241f.setData(aVar);
                this.f45241f.showNoMoreView();
            } else if (ListUtils.isEmpty(this.f45240e.B())) {
                showEmptyView();
            } else {
                this.f45241f.setListData(this.f45240e.B());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f45240e.F(this);
            this.f45240e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f45241f.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            k(getContext());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            this.f45241f.setPresenter(this);
            this.f45241f.setUniqueId(getUniqueId());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_START_STAMP_KEY);
            if (this.f45241f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f45241f.getParent()).removeView(this.f45241f);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.f45241f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroyView();
            if (!this.f45245j) {
                this.f45241f.destroy();
                this.f45240e.onDestroy();
            }
            this.f45245j = false;
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            loadData();
        }
    }

    @Override // c.a.r0.d1.o0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.r0.d1.o0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                this.f45241f.setViewForeground();
            }
        }
    }

    @Override // c.a.r0.d1.o0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f45241f.reload();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.f45241f) == null) {
            return;
        }
        hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    public final void showEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.f45241f.isShownHeaderView()) {
                this.f45241f.hideNetRefreshView();
                showTabEmptyView();
                return;
            }
            this.f45241f.showNetRefreshView(false);
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f45241f.isShownHeaderView()) {
                this.f45241f.hideLoadingView();
                showTabLoadingView();
                return;
            }
            this.f45241f.showLoadingView(false);
        }
    }

    public void showTabEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f3005f = R.drawable.new_pic_emotion_05;
            vVar.f3004e = getString(R.string.no_data_common_txt);
            arrayList.add(vVar);
            this.f45241f.hideNoMoreView();
            this.f45241f.setListData(arrayList);
        }
    }

    public void showTabLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new t());
            this.f45241f.hideNoMoreView();
            this.f45241f.setListData(arrayList);
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
        this.f45243h = new a(this);
        this.f45244i = new b(this);
        this.f45245j = true;
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_START_STAMP_KEY);
        IdleLaunchTaskManager.registerIdleTask(new c(this, context));
        SpeedStatsManager.getInstance().addStatsTimeStamp(5027);
    }
}
