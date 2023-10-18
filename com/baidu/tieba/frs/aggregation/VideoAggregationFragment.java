package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.l45;
import com.baidu.tieba.m45;
import com.baidu.tieba.qf7;
import com.baidu.tieba.sf7;
import com.baidu.tieba.tf7;
import com.baidu.tieba.vf7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, qf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public BdTypeListView e;
    public m45 f;
    public PbListView g;
    public sf7 h;
    public vf7 i;
    public NavigationBar j;
    public FrameLayout k;
    public NoNetworkView l;
    public NoDataView m;
    public List<tf7> n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    @Override // com.baidu.tieba.qf7
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements l45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

        public a(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationFragment;
        }

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.i.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

        public b(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.h != null) {
                if (i > this.a.h.c() || i + i2 < this.a.h.c()) {
                    this.a.h.b();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 0 && absListView.getLastVisiblePosition() > absListView.getCount() - 2 && absListView.getFirstVisiblePosition() != 0) {
                this.a.i.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

        public c(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.h2();
            this.a.i.e();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

        public d(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoAggregationFragment videoAggregationFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                if (this.a.m != null) {
                    this.a.i.e();
                } else if (BdNetTypeUtil.isMobileNet() && this.a.h != null && this.a.h.e()) {
                    this.a.getPageContext().showToast((int) R.string.obfuscated_res_0x7f0f1803);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoAggregationFragment videoAggregationFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.UpdateAttentionData data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.a.h == null || (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) == null || !data.isSucc) {
                return;
            }
            this.a.h.f(data.toUid, data.isAttention);
        }
    }

    public VideoAggregationFragment() {
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
        this.n = null;
        this.o = new e(this, 2000994);
        this.p = new f(this, 2001115);
    }

    public void j2(int i) {
        sf7 sf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.e != null && (sf7Var = this.h) != null) {
            if (i == 1 && sf7Var.e()) {
                this.h.k();
            }
            if (i == 2) {
                this.h.n();
            }
        }
    }

    public boolean k2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            sf7 sf7Var = this.h;
            if (sf7Var == null) {
                return false;
            }
            return sf7Var.j(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            this.j.onChangeSkinType(getPageContext(), i);
            this.l.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0111);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
            sf7 sf7Var = this.h;
            if (sf7Var != null) {
                sf7Var.h(configuration);
            }
        }
    }

    public static VideoAggregationFragment g2(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, str, str2, str3, str4)) == null) {
            VideoAggregationFragment videoAggregationFragment = new VideoAggregationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_FID", str);
            bundle.putString("PARAM_FROM", str2);
            bundle.putString("st_type", str3);
            bundle.putString("yuelaou_locate", str4);
            videoAggregationFragment.setArguments(bundle);
            return videoAggregationFragment;
        }
        return (VideoAggregationFragment) invokeLLLL.objValue;
    }

    @Override // com.baidu.tieba.qf7
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ListUtils.isEmpty(this.n)) {
            m2(this.k, true);
        }
    }

    public final void h2() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (noDataView = this.m) != null && noDataView.getVisibility() == 0) {
            this.m.setVisibility(8);
            this.e.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.qf7
    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.k == null) {
            return;
        }
        this.e.z(0L);
        hideLoadingView(this.k);
    }

    public void l2() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getPageContext() != null && (frameLayout = this.k) != null) {
            showLoadingView(frameLayout, false, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703c8));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            vf7 vf7Var = this.i;
            if (vf7Var != null) {
                vf7Var.c();
            }
            sf7 sf7Var = this.h;
            if (sf7Var != null) {
                sf7Var.i();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            j2(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            j2(2);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.b)) {
                this.j.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f17e3));
            } else {
                this.j.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f17fc));
            }
            this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        }
    }

    public final void m2(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view2, z) == null) {
            if (this.m == null) {
                if (z) {
                    this.m = NoDataViewFactory.a(getPageContext().getPageActivity(), view2, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, 0, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703e6), BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703c8)), NoDataViewFactory.e.d(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0e4f), getPageContext().getPageActivity().getString(R.string.refresh_view_title_text)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getPageContext().getPageActivity().getString(R.string.refresh_view_button_text), new c(this))));
                } else {
                    this.m = NoDataViewFactory.a(getPageContext().getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f07039a)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f1806), null);
                }
            }
            this.m.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.m.setVisibility(0);
            this.e.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.k = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907bc);
            this.j = (NavigationBar) view2.findViewById(R.id.navigation_bar);
            i2();
            this.l = (NoNetworkView) view2.findViewById(R.id.no_network_view);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.l.setVisibility(0);
            }
            this.e = (BdTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f091558);
            m45 m45Var = new m45(getPageContext());
            this.f = m45Var;
            m45Var.f();
            this.f.a(new a(this));
            this.f.W(getUniqueId());
            this.e.setPullRefresh(this.f);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.g = pbListView;
            pbListView.a();
            this.g.D();
            this.g.H(getResources().getString(R.string.list_has_no_more));
            this.g.U();
            this.e.setNextPage(this.g);
            this.e.setOnScrollListener(new b(this));
            this.h = new sf7(getPageContext(), this.e, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.b));
            l2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.a = arguments.getString("PARAM_FID");
                this.b = arguments.getString("PARAM_FROM");
                this.c = arguments.getString("st_type");
                this.d = arguments.getString("yuelaou_locate");
            }
            vf7 vf7Var = new vf7(getPageContext(), this);
            this.i = vf7Var;
            vf7Var.g(this.a);
            this.i.f(this.b);
            this.i.i(this.c);
            this.i.h(this.d);
            this.i.e();
            registerListener(this.o);
            registerListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0341, (ViewGroup) null);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qf7
    public void q1(List<tf7> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048593, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || list == null) {
            return;
        }
        if (z) {
            this.n = list;
        } else {
            this.n.addAll(list);
        }
        if (z && list.size() == 0) {
            m2(this.k, false);
            return;
        }
        this.h.m(list, z);
        if (!z2) {
            this.g.g();
        }
        h2();
        NoDataView noDataView = this.m;
        if (noDataView != null) {
            this.k.removeView(noDataView);
            this.m = null;
        }
    }
}
