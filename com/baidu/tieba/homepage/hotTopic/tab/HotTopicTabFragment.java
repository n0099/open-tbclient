package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
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
import com.baidu.tieba.a05;
import com.baidu.tieba.ee7;
import com.baidu.tieba.eu4;
import com.baidu.tieba.fi;
import com.baidu.tieba.fy7;
import com.baidu.tieba.gy7;
import com.baidu.tieba.hi;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.li5;
import com.baidu.tieba.oma;
import com.baidu.tieba.pma;
import com.baidu.tieba.yh;
import com.baidu.tieba.yy7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
/* loaded from: classes6.dex */
public class HotTopicTabFragment extends BaseFragment implements ee7, gy7, pma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotTopicTabModel a;
    public HotTopicTabView b;
    public ViewGroup c;
    public eu4<Object> d;
    public boolean e;

    @Override // com.baidu.tieba.pma
    @NonNull
    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "home_popular_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "home" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ee7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "a076" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ee7
    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements eu4<Object> {
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

        @Override // com.baidu.tieba.eu4
        public void b(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) != null) || obj == null) {
                return;
            }
            fy7.a(view2, obj, i + 1, this.a.e2());
        }

        @Override // com.baidu.tieba.eu4
        public void d(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) != null) || obj == null) {
                return;
            }
            fy7.b(view2, obj, this.a.e2());
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
                this.b.f2(this.a);
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
            this.a.i2();
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

    @Override // com.baidu.tieba.ee7
    public void N() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.x();
        }
    }

    public final String e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HotTopicTabModel hotTopicTabModel = this.a;
            if (hotTopicTabModel != null) {
                return String.valueOf(hotTopicTabModel.getTabId() + 1);
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return Integer.toString(getUniqueId().getId());
        }
        return (String) invokeV.objValue;
    }

    public final void h2() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        if (hotTopicTabView.t()) {
            this.b.n();
            j2();
            return;
        }
        this.b.A(false);
    }

    public final void i2() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (hotTopicTabView = this.b) == null) {
            return;
        }
        if (hotTopicTabView.t()) {
            this.b.m();
            k2();
            return;
        }
        this.b.z(false);
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fi());
        this.b.o();
        this.b.setListData(arrayList);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.u();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            IdleHandlerManager.getInstance().removeRunnable("hotTopic");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroyView();
            if (this.a != null && (hotTopicTabView = this.b) != null) {
                if (!this.e) {
                    hotTopicTabView.l();
                    this.a.onDestroy();
                }
                this.e = false;
                li5.e().b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            YunDialogManager.onHidden(a05.i);
        }
    }

    @Override // com.baidu.tieba.ee7
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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

    public void f2(Context context) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, context) != null) || !this.e) {
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

    public void g2(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scrollFragmentTabHost) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
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
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (hotTopicTabView = this.b) != null) {
            hotTopicTabView.v();
        }
    }

    @Override // com.baidu.tieba.gy7
    public void c() {
        HotTopicTabModel hotTopicTabModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (hotTopicTabModel = this.a) != null && this.b != null) {
            boolean loadData = hotTopicTabModel.loadData();
            HotTopicTabModel hotTopicTabModel2 = this.a;
            List<yh> T2 = hotTopicTabModel2.T(hotTopicTabModel2.U());
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
                h2();
            }
        }
    }

    @Override // com.baidu.tieba.gy7
    public void d1(int i, yy7 yy7Var) {
        boolean z;
        HotTopicTabView hotTopicTabView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, yy7Var) == null) {
            boolean z2 = false;
            if (this.a != null && (hotTopicTabView = this.b) != null) {
                hotTopicTabView.m();
                this.b.n();
                this.b.D();
                if (yy7Var != null && i == 0 && !ListUtils.isEmpty(yy7Var.getDataList())) {
                    this.b.setData(yy7Var);
                    this.b.B();
                    oma.c(this, new Pair[0]);
                    return;
                } else if (ListUtils.isEmpty(this.a.S())) {
                    oma.a(this, new Pair(PushMessageHelper.ERROR_TYPE, "home_popular"), new Pair("error_info", "home popular response wrong"));
                    h2();
                    return;
                } else {
                    this.b.setListData(this.a.S());
                    oma.c(this, new Pair[0]);
                    return;
                }
            }
            Pair[] pairArr = new Pair[2];
            pairArr[0] = new Pair(PushMessageHelper.ERROR_TYPE, "home_popular");
            StringBuilder sb = new StringBuilder();
            sb.append("home popular model is null = ");
            if (this.a == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append("view is null");
            if (this.b == null) {
                z2 = true;
            }
            sb.append(z2);
            pairArr[1] = new Pair("error_info", sb.toString());
            oma.a(this, pairArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
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

    public void j2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        hi hiVar = new hi();
        hiVar.b = R.drawable.new_pic_emotion_05;
        hiVar.a = getString(R.string.no_data_common_txt);
        arrayList.add(hiVar);
        this.b.o();
        this.b.setListData(arrayList);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                HotTopicTabView hotTopicTabView = this.b;
                if (hotTopicTabView != null) {
                    hotTopicTabView.setViewForeground();
                }
                if (getContext() != null) {
                    YunDialogManager.onShow(getContext(), a05.i);
                    return;
                }
                return;
            }
            YunDialogManager.onHidden(a05.i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            oma.b(this, new Pair[0]);
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
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            f2(getContext());
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
            c();
        }
    }
}
