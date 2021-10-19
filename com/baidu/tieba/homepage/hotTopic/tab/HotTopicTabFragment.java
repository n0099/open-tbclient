package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.e.l.e.t;
import c.a.e.l.e.v;
import c.a.q0.n.f;
import c.a.r0.x0.n0;
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
/* loaded from: classes7.dex */
public class HotTopicTabFragment extends BaseFragment implements n0, c.a.r0.h1.f.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f52260e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f52261f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f52262g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f52263h;

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f52264i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f52265j;

    /* loaded from: classes7.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f52266a;

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
            this.f52266a = hotTopicTabFragment;
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
                if (this.f52266a.f52262g != null && this.f52266a.f52262g.tabId != frsTabItemData.tabId) {
                    String str = frsTabItemData.tabCode;
                    this.f52266a.f52260e.G(str);
                    this.f52266a.f52260e.setTabId(frsTabItemData.tabId);
                    if (this.f52266a.f52260e.loadData()) {
                        this.f52266a.f52261f.stopPullRefresh();
                        this.f52266a.f52261f.hideLoadingView();
                        this.f52266a.f52261f.hideNetRefreshView();
                        this.f52266a.showTabLoadingView();
                    } else {
                        this.f52266a.f52261f.stopPullRefresh();
                        this.f52266a.f52261f.hideLoadingView();
                        List<n> C = this.f52266a.f52260e.C(str);
                        if (!ListUtils.isEmpty(C)) {
                            this.f52266a.f52261f.setListData(C);
                        } else {
                            this.f52266a.showEmptyView();
                        }
                    }
                }
                this.f52266a.f52262g = frsTabItemData;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.f52266a.f52261f.stopPullRefresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f52267e;

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
            this.f52267e = hotTopicTabFragment;
        }

        @Override // c.a.q0.n.f
        public void a(View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || obj == null) {
                return;
            }
            c.a.r0.h1.f.a.a.a(view, obj, i2 + 1, this.f52267e.g());
        }

        @Override // c.a.q0.n.f
        public void c(View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || obj == null) {
                return;
            }
            c.a.r0.h1.f.a.a.b(view, obj, this.f52267e.g());
        }
    }

    /* loaded from: classes7.dex */
    public class c extends IdleLaunchTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f52268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabFragment f52269f;

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
            this.f52269f = hotTopicTabFragment;
            this.f52268e = context;
        }

        @Override // com.baidu.searchbox.launch.SmartLaunchTask
        public void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52269f.h(this.f52268e);
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
        this.f52263h = new a(this);
        this.f52264i = new b(this);
        this.f52265j = true;
    }

    @Override // c.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f52261f.forceRefresh();
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.f52260e;
            return hotTopicTabModel != null ? String.valueOf(hotTopicTabModel.getTabId() + 1) : "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
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
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f52265j) {
            this.f52265j = false;
            TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
            this.f52260e = new HotTopicTabModel(pageContext);
            HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
            this.f52261f = hotTopicTabView;
            hotTopicTabView.setOnTabSelectedListener(this.f52263h);
            this.f52261f.setOnItemCoverListener(this.f52264i);
        }
    }

    @Override // c.a.r0.h1.f.a.b
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean loadData = this.f52260e.loadData();
            HotTopicTabModel hotTopicTabModel = this.f52260e;
            List<n> C = hotTopicTabModel.C(hotTopicTabModel.D());
            if (loadData) {
                if (!ListUtils.isEmpty(C) || this.f52261f.isShownHeaderView()) {
                    return;
                }
                this.f52261f.stopPullRefresh();
                this.f52261f.hideNetRefreshView();
                showLoadingView();
                return;
            }
            this.f52261f.stopPullRefresh();
            this.f52261f.hideLoadingView();
            if (!ListUtils.isEmpty(C)) {
                this.f52261f.setListData(C);
            } else if (j.A()) {
            } else {
                showEmptyView();
            }
        }
    }

    @Override // c.a.r0.h1.f.a.b
    public void netCallback(int i2, c.a.r0.h1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, aVar) == null) {
            this.f52261f.hideLoadingView();
            this.f52261f.hideNetRefreshView();
            this.f52261f.stopPullRefresh();
            if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
                this.f52261f.setData(aVar);
                this.f52261f.showNoMoreView();
            } else if (ListUtils.isEmpty(this.f52260e.B())) {
                showEmptyView();
            } else {
                this.f52261f.setListData(this.f52260e.B());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f52260e.F(this);
            this.f52260e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f52261f.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            h(getContext());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            this.f52261f.setPresenter(this);
            this.f52261f.setUniqueId(getUniqueId());
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
            if (this.f52261f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f52261f.getParent()).removeView(this.f52261f);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.f52261f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroyView();
            if (!this.f52265j) {
                this.f52261f.destroy();
                this.f52260e.onDestroy();
            }
            this.f52265j = false;
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

    @Override // c.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.r0.x0.n0
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
                this.f52261f.setViewForeground();
            }
        }
    }

    @Override // c.a.r0.x0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f52261f.reload();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, scrollFragmentTabHost) == null) || (hotTopicTabView = this.f52261f) == null) {
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
            if (this.f52261f.isShownHeaderView()) {
                this.f52261f.hideNetRefreshView();
                showTabEmptyView();
                return;
            }
            this.f52261f.showNetRefreshView(false);
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f52261f.isShownHeaderView()) {
                this.f52261f.hideLoadingView();
                showTabLoadingView();
                return;
            }
            this.f52261f.showLoadingView(false);
        }
    }

    public void showTabEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList();
            v vVar = new v();
            vVar.f3064f = R.drawable.new_pic_emotion_05;
            vVar.f3063e = getString(R.string.no_data_common_txt);
            arrayList.add(vVar);
            this.f52261f.hideNoMoreView();
            this.f52261f.setListData(arrayList);
        }
    }

    public void showTabLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new t());
            this.f52261f.hideNoMoreView();
            this.f52261f.setListData(arrayList);
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
        this.f52263h = new a(this);
        this.f52264i = new b(this);
        this.f52265j = true;
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_START_STAMP_KEY);
        IdleLaunchTaskManager.registerIdleTask(new c(this, context));
        SpeedStatsManager.getInstance().addStatsTimeStamp(5027);
    }
}
