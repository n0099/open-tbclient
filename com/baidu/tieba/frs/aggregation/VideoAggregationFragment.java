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
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import d.a.p0.u0.h1.i;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d.a.p0.u0.h1.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f15495e;

    /* renamed from: f  reason: collision with root package name */
    public String f15496f;

    /* renamed from: g  reason: collision with root package name */
    public String f15497g;

    /* renamed from: h  reason: collision with root package name */
    public String f15498h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f15499i;
    public g j;
    public PbListView k;
    public d.a.p0.u0.h1.f l;
    public i m;
    public NavigationBar n;
    public FrameLayout o;
    public NoNetworkView p;
    public NoDataView q;
    public List<d.a.p0.u0.h1.g> r;
    public CustomMessageListener s;
    public CustomMessageListener t;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f15500e;

        public a(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15500e = videoAggregationFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f15500e.m.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f15501e;

        public b(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15501e = videoAggregationFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f15501e.l == null) {
                return;
            }
            if (i2 > this.f15501e.l.c() || i2 + i3 < this.f15501e.l.c()) {
                this.f15501e.l.b();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || i2 != 0 || absListView.getLastVisiblePosition() <= absListView.getCount() - 2 || absListView.getFirstVisiblePosition() == 0) {
                return;
            }
            this.f15501e.m.d();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f15502e;

        public c(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15502e = videoAggregationFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15502e.M0();
                this.f15502e.m.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f15503e;

        public d(VideoAggregationFragment videoAggregationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15503e = videoAggregationFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15503e.getActivity() == null || this.f15503e.getActivity().isFinishing()) {
                return;
            }
            this.f15503e.getActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f15504a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoAggregationFragment videoAggregationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15504a = videoAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z()) {
                if (this.f15504a.q != null) {
                    this.f15504a.m.e();
                } else if (j.x() && this.f15504a.l != null && this.f15504a.l.e()) {
                    this.f15504a.getPageContext().showToast(R.string.video_mobile_play_tips);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f15505a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(VideoAggregationFragment videoAggregationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAggregationFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15505a = videoAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.f15505a.l != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.f12817a) {
                this.f15505a.l.f(data.f12819c, data.f12820d);
            }
        }
    }

    public VideoAggregationFragment() {
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
        this.r = null;
        this.s = new e(this, 2000994);
        this.t = new f(this, 2001115);
    }

    public static VideoAggregationFragment L0(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, str4)) == null) {
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

    public final void M0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (noDataView = this.q) != null && noDataView.getVisibility() == 0) {
            this.q.setVisibility(8);
            this.f15499i.setVisibility(0);
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.f15496f)) {
                this.n.setCenterTextTitle(getPageContext().getString(R.string.video_aggregation_title));
            } else {
                this.n.setCenterTextTitle(getPageContext().getString(R.string.video_middle_page_title));
            }
            this.n.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        }
    }

    public void O0(int i2) {
        d.a.p0.u0.h1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f15499i == null || (fVar = this.l) == null) {
            return;
        }
        if (i2 == 1 && fVar.e()) {
            this.l.k();
        }
        if (i2 == 2) {
            this.l.n();
        }
    }

    public boolean P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            d.a.p0.u0.h1.f fVar = this.l;
            if (fVar == null) {
                return false;
            }
            return fVar.j(i2);
        }
        return invokeI.booleanValue;
    }

    public void Q0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || getPageContext() == null || (frameLayout = this.o) == null) {
            return;
        }
        showLoadingView(frameLayout, false, l.g(getPageContext().getPageActivity(), R.dimen.ds360));
    }

    public final void R0(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, view, z) == null) {
            if (this.q == null) {
                if (z) {
                    this.q = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds480), l.g(getPageContext().getPageActivity(), R.dimen.ds360)), NoDataViewFactory.e.d(getPageContext().getPageActivity().getString(R.string.neterror), getPageContext().getPageActivity().getString(R.string.refresh_view_title_text)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getPageContext().getPageActivity().getString(R.string.refresh_view_button_text), new c(this))));
                } else {
                    this.q = NoDataViewFactory.a(getPageContext().getPageActivity(), this.o, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.video_no_data), null);
                }
            }
            this.q.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.q.setVisibility(0);
            this.f15499i.setVisibility(8);
        }
    }

    @Override // d.a.p0.u0.h1.d
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // d.a.p0.u0.h1.d
    public void d(List<d.a.p0.u0.h1.g> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || list == null) {
            return;
        }
        if (z) {
            this.r = list;
        } else {
            this.r.addAll(list);
        }
        if (z && list.size() == 0) {
            R0(this.o, false);
            return;
        }
        this.l.m(list, z);
        if (!z2) {
            this.k.f();
        }
        M0();
        NoDataView noDataView = this.q;
        if (noDataView != null) {
            this.o.removeView(noDataView);
            this.q = null;
        }
    }

    @Override // d.a.p0.u0.h1.d
    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.o == null) {
            return;
        }
        this.f15499i.A(0L);
        hideLoadingView(this.o);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.n.onChangeSkinType(getPageContext(), i2);
            this.p.c(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0111);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
            d.a.p0.u0.h1.f fVar = this.l;
            if (fVar != null) {
                fVar.h(configuration);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f15495e = arguments.getString("PARAM_FID");
                this.f15496f = arguments.getString("PARAM_FROM");
                this.f15497g = arguments.getString("st_type");
                this.f15498h = arguments.getString("yuelaou_locate");
            }
            i iVar = new i(getPageContext(), this);
            this.m = iVar;
            iVar.g(this.f15495e);
            this.m.f(this.f15496f);
            this.m.i(this.f15497g);
            this.m.h(this.f15498h);
            this.m.e();
            registerListener(this.s);
            registerListener(this.t);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.fragment_video_aggregation, (ViewGroup) null) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            i iVar = this.m;
            if (iVar != null) {
                iVar.c();
            }
            d.a.p0.u0.h1.f fVar = this.l;
            if (fVar != null) {
                fVar.i();
            }
        }
    }

    @Override // d.a.p0.u0.h1.d
    public void onLoadFail() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && ListUtils.isEmpty(this.r)) {
            R0(this.o, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            O0(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            O0(2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.o = (FrameLayout) view.findViewById(R.id.container);
            this.n = (NavigationBar) view.findViewById(R.id.navigation_bar);
            N0();
            this.p = (NoNetworkView) view.findViewById(R.id.no_network_view);
            if (!j.z()) {
                this.p.setVisibility(0);
            }
            this.f15499i = (BdTypeListView) view.findViewById(R.id.listView);
            g gVar = new g(getPageContext());
            this.j = gVar;
            gVar.n();
            this.j.a(new a(this));
            this.j.a0(getUniqueId());
            this.f15499i.setPullRefresh(this.j);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.k = pbListView;
            pbListView.a();
            this.k.x();
            this.k.A(getResources().getString(R.string.list_has_no_more));
            this.k.O();
            this.f15499i.setNextPage(this.k);
            this.f15499i.setOnScrollListener(new b(this));
            this.l = new d.a.p0.u0.h1.f(getPageContext(), this.f15499i, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.f15496f));
            Q0();
        }
    }
}
