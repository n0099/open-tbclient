package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.l.e.n;
import b.a.e.l.e.t;
import b.a.e.l.e.v;
import b.a.q0.n.f;
import b.a.r0.x0.n0;
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
/* loaded from: classes9.dex */
public class HotTopicTabFragment extends BaseFragment implements n0, b.a.r0.h1.f.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f49563e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f49564f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f49565g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f49566h;

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f49567i;
    public boolean j;

    /* loaded from: classes9.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f49568a;

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
            this.f49568a = hotTopicTabFragment;
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
                if (this.f49568a.f49565g != null && this.f49568a.f49565g.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    this.f49568a.f49563e.G(str);
                    this.f49568a.f49563e.setTabId(frsTabItemData.tabId);
                    if (this.f49568a.f49563e.loadData()) {
                        this.f49568a.f49564f.stopPullRefresh();
                        this.f49568a.f49564f.hideLoadingView();
                        this.f49568a.f49564f.hideNetRefreshView();
                        this.f49568a.showTabLoadingView();
                    } else {
                        this.f49568a.f49564f.stopPullRefresh();
                        this.f49568a.f49564f.hideLoadingView();
                        List<n> C = this.f49568a.f49563e.C(str);
                        if (!ListUtils.isEmpty(C)) {
                            this.f49568a.f49564f.setListData(C);
                        } else {
                            this.f49568a.showEmptyView();
                        }
                    }
                }
                this.f49568a.f49565g = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.f49568a.f49564f.stopPullRefresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f49569e;

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
            this.f49569e = hotTopicTabFragment;
        }

        @Override // b.a.q0.n.f
        public void a(View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            b.a.r0.h1.f.a.a.a(view, obj, i2 + 1, this.f49569e.g());
        }

        @Override // b.a.q0.n.f
        public void c(View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || obj == null) {
                return;
            }
            b.a.r0.h1.f.a.a.b(view, obj, this.f49569e.g());
        }
    }

    /* loaded from: classes9.dex */
    public class c extends IdleLaunchTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49570e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f49571f;

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
            this.f49571f = hotTopicTabFragment;
            this.f49570e = context;
        }

        @Override // com.baidu.searchbox.launch.SmartLaunchTask
        public void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49571f.h(this.f49570e);
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
        this.f49566h = new a(this);
        this.f49567i = new b(this);
        this.j = true;
    }

    @Override // b.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49564f.forceRefresh();
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.f49563e;
            return hotTopicTabModel != null ? String.valueOf(hotTopicTabModel.getTabId() + 1) : "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.q0.o0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.j) {
            this.j = false;
            TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
            this.f49563e = new HotTopicTabModel(pageContext);
            HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
            this.f49564f = hotTopicTabView;
            hotTopicTabView.setOnTabSelectedListener(this.f49566h);
            this.f49564f.setOnItemCoverListener(this.f49567i);
        }
    }

    @Override // b.a.r0.h1.f.a.b
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean loadData = this.f49563e.loadData();
            HotTopicTabModel hotTopicTabModel = this.f49563e;
            List<n> C = hotTopicTabModel.C(hotTopicTabModel.D());
            if (loadData) {
                if (!ListUtils.isEmpty(C) || this.f49564f.isShownHeaderView()) {
                    return;
                }
                this.f49564f.stopPullRefresh();
                this.f49564f.hideNetRefreshView();
                showLoadingView();
                return;
            }
            this.f49564f.stopPullRefresh();
            this.f49564f.hideLoadingView();
            if (!ListUtils.isEmpty(C)) {
                this.f49564f.setListData(C);
            } else if (j.A()) {
            } else {
                showEmptyView();
            }
        }
    }

    @Override // b.a.r0.h1.f.a.b
    public void netCallback(int i2, b.a.r0.h1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, aVar) == null) {
            this.f49564f.hideLoadingView();
            this.f49564f.hideNetRefreshView();
            this.f49564f.stopPullRefresh();
            if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
                this.f49564f.setData(aVar);
                this.f49564f.showNoMoreView();
            } else if (ListUtils.isEmpty(this.f49563e.B())) {
                showEmptyView();
            } else {
                this.f49564f.setListData(this.f49563e.B());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f49563e.F(this);
            this.f49563e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f49564f.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            h(getContext());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            this.f49564f.setPresenter(this);
            this.f49564f.setUniqueId(getUniqueId());
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
            if (this.f49564f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f49564f.getParent()).removeView(this.f49564f);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.f49564f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroyView();
            if (!this.j) {
                this.f49564f.destroy();
                this.f49563e.onDestroy();
            }
            this.j = false;
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

    @Override // b.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // b.a.r0.x0.n0
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
                this.f49564f.setViewForeground();
            }
        }
    }

    @Override // b.a.r0.x0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f49564f.reload();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.f49564f) == null) {
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
            if (this.f49564f.isShownHeaderView()) {
                this.f49564f.hideNetRefreshView();
                showTabEmptyView();
                return;
            }
            this.f49564f.showNetRefreshView(false);
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f49564f.isShownHeaderView()) {
                this.f49564f.hideLoadingView();
                showTabLoadingView();
                return;
            }
            this.f49564f.showLoadingView(false);
        }
    }

    public void showTabEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f2517f = R.drawable.new_pic_emotion_05;
            vVar.f2516e = getString(R.string.no_data_common_txt);
            arrayList.add(vVar);
            this.f49564f.hideNoMoreView();
            this.f49564f.setListData(arrayList);
        }
    }

    public void showTabLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new t());
            this.f49564f.hideNoMoreView();
            this.f49564f.setListData(arrayList);
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
        this.f49566h = new a(this);
        this.f49567i = new b(this);
        this.j = true;
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_START_STAMP_KEY);
        IdleLaunchTaskManager.registerIdleTask(new c(this, context));
        SpeedStatsManager.getInstance().addStatsTimeStamp(5027);
    }
}
