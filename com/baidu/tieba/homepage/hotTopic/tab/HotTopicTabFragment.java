package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.a38;
import com.baidu.tieba.bn;
import com.baidu.tieba.ei7;
import com.baidu.tieba.h28;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.i28;
import com.baidu.tieba.in;
import com.baidu.tieba.in5;
import com.baidu.tieba.kn;
import com.baidu.tieba.n55;
import com.baidu.tieba.rz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class HotTopicTabFragment extends BaseFragment implements ei7, i28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicTabModel a;
    public HotTopicTabView b;
    public ViewGroup c;
    public rz4<Object> d;
    public boolean e;

    @Override // com.baidu.tieba.ei7
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ei7
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements rz4<Object> {
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

        @Override // com.baidu.tieba.rz4
        public void c(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) != null) || obj == null) {
                return;
            }
            h28.b(view2, obj, this.a.W1());
        }

        @Override // com.baidu.tieba.rz4
        public void d(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) != null) || obj == null) {
                return;
            }
            h28.a(view2, obj, i + 1, this.a.W1());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ HotTopicTabFragment b;

        public b(HotTopicTabFragment hotTopicTabFragment, Context context) {
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
                this.b.X1(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabFragment a;

        public c(HotTopicTabFragment hotTopicTabFragment) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.a2();
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
        this.e = true;
    }

    @Override // com.baidu.tieba.ei7
    public void D() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.x();
        }
    }

    public final String W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.a;
            if (hotTopicTabModel != null) {
                return String.valueOf(hotTopicTabModel.getTabId() + 1);
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    public final void Z1() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        if (hotTopicTabView.t()) {
            this.b.n();
            b2();
            return;
        }
        this.b.A(false);
    }

    public final void a2() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        if (hotTopicTabView.t()) {
            this.b.m();
            c2();
            return;
        }
        this.b.z(false);
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new in());
        this.b.o();
        this.b.setListData(arrayList);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.u();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            IdleHandlerManager.getInstance().removeRunnable("hotTopic");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroyView();
            if (this.a != null && (hotTopicTabView = this.b) != null) {
                if (!this.e) {
                    hotTopicTabView.l();
                    this.a.onDestroy();
                }
                this.e = false;
                in5.e().b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            YunDialogManager.onHidden(n55.i);
        }
    }

    @Override // com.baidu.tieba.ei7
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
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
        this.e = true;
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_START_STAMP_KEY);
        IdleHandlerManager.getInstance().addOrRunTask("hotTopic", new b(this, context));
        SpeedStatsManager.getInstance().addStatsTimeStamp(5027);
    }

    public void X1(Context context) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, context) != null) || !this.e) {
            return;
        }
        this.e = false;
        TbPageContext tbPageContext = null;
        if (context instanceof TbPageContextSupport) {
            tbPageContext = ((TbPageContextSupport) context).getPageContext();
        }
        this.a = new HotTopicTabModel(tbPageContext);
        if (getArguments() == null) {
            string = "";
        } else {
            string = getArguments().getString("tab_name");
        }
        HotTopicTabView hotTopicTabView = new HotTopicTabView(tbPageContext, string);
        this.b = hotTopicTabView;
        hotTopicTabView.setOnItemCoverListener(this.d);
    }

    public void Y1(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onActivityCreated(bundle);
            HotTopicTabModel hotTopicTabModel = this.a;
            if (hotTopicTabModel != null) {
                hotTopicTabModel.W(this);
                this.a.setUniqueId(getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.v();
        }
    }

    @Override // com.baidu.tieba.i28
    public void W0(int i, a38 a38Var) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, a38Var) == null) && this.a != null && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.m();
            this.b.n();
            this.b.D();
            if (a38Var != null && i == 0 && !ListUtils.isEmpty(a38Var.getDataList())) {
                this.b.setData(a38Var);
                this.b.B();
            } else if (ListUtils.isEmpty(this.a.S())) {
                Z1();
            } else {
                this.b.setListData(this.a.S());
            }
        }
    }

    @Override // com.baidu.tieba.i28
    public void b() {
        HotTopicTabModel hotTopicTabModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (hotTopicTabModel = this.a) != null && this.b != null) {
            boolean loadData = hotTopicTabModel.loadData();
            HotTopicTabModel hotTopicTabModel2 = this.a;
            List<bn> T2 = hotTopicTabModel2.T(hotTopicTabModel2.U());
            if (loadData) {
                if (ListUtils.isEmpty(T2) && !this.b.t()) {
                    this.b.D();
                    this.b.n();
                    this.b.post(new c(this));
                    return;
                }
                return;
            }
            this.b.D();
            this.b.m();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setListData(T2);
            } else if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                Z1();
            }
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        kn knVar = new kn();
        knVar.b = R.drawable.new_pic_emotion_05;
        knVar.a = getString(R.string.no_data_common_txt);
        arrayList.add(knVar);
        this.b.o();
        this.b.setListData(arrayList);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                HotTopicTabView hotTopicTabView = this.b;
                if (hotTopicTabView != null) {
                    hotTopicTabView.setViewForeground();
                }
                if (getContext() != null) {
                    YunDialogManager.onShow(getContext(), n55.i);
                    return;
                }
                return;
            }
            YunDialogManager.onHidden(n55.i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(bundle);
            HotTopicTabView hotTopicTabView = this.b;
            if (hotTopicTabView != null) {
                hotTopicTabView.setPresenter(this);
                this.b.setUniqueId(getUniqueId());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_START_STAMP_KEY);
            this.c = new FrameLayout(getContext());
            if (this.isLazyLoaded) {
                onLazyLoad();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOT_TOPIC_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            X1(getContext());
            HotTopicTabModel hotTopicTabModel = this.a;
            if (hotTopicTabModel != null) {
                hotTopicTabModel.W(this);
                this.a.setUniqueId(getUniqueId());
            }
            HotTopicTabView hotTopicTabView = this.b;
            if (hotTopicTabView != null) {
                hotTopicTabView.setPresenter(this);
                this.b.setUniqueId(getUniqueId());
                if (this.b.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.b.getParent()).removeView(this.b);
                }
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.addView(this.b);
                }
            }
            b();
        }
    }
}
