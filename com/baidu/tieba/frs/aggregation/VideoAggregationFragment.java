package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.e1.t1.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, c.a.t0.e1.t1.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_PAUSE = 1;
    public static final int STATE_RESUME = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f43235e;

    /* renamed from: f  reason: collision with root package name */
    public String f43236f;

    /* renamed from: g  reason: collision with root package name */
    public String f43237g;

    /* renamed from: h  reason: collision with root package name */
    public String f43238h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f43239i;

    /* renamed from: j  reason: collision with root package name */
    public g f43240j;
    public PbListView k;
    public c.a.t0.e1.t1.f l;
    public i m;
    public NavigationBar n;
    public FrameLayout o;
    public NoNetworkView p;
    public NoDataView q;
    public List<c.a.t0.e1.t1.g> r;
    public CustomMessageListener s;
    public CustomMessageListener t;

    /* loaded from: classes12.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f43241e;

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
            this.f43241e = videoAggregationFragment;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f43241e.m.e();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f43242e;

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
            this.f43242e = videoAggregationFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f43242e.l == null) {
                return;
            }
            if (i2 > this.f43242e.l.c() || i2 + i3 < this.f43242e.l.c()) {
                this.f43242e.l.b();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || i2 != 0 || absListView.getLastVisiblePosition() <= absListView.getCount() - 2 || absListView.getFirstVisiblePosition() == 0) {
                return;
            }
            this.f43242e.m.d();
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f43243e;

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
            this.f43243e = videoAggregationFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43243e.i();
                this.f43243e.m.e();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAggregationFragment f43244e;

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
            this.f43244e = videoAggregationFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43244e.getActivity() == null || this.f43244e.getActivity().isFinishing()) {
                return;
            }
            this.f43244e.getActivity().finish();
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

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
            this.a = videoAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.z()) {
                if (this.a.q != null) {
                    this.a.m.e();
                } else if (l.x() && this.a.l != null && this.a.l.e()) {
                    this.a.getPageContext().showToast(R.string.video_mobile_play_tips);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAggregationFragment a;

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
            this.a = videoAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.l != null && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.a) {
                this.a.l.f(data.f40771c, data.f40772d);
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

    public static VideoAggregationFragment getInstance(String str, String str2, String str3, String str4) {
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

    @Override // c.a.t0.e1.t1.d
    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.o == null) {
            return;
        }
        this.f43239i.completePullRefreshPostDelayed(0L);
        hideLoadingView(this.o);
    }

    public final void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (noDataView = this.q) != null && noDataView.getVisibility() == 0) {
            this.q.setVisibility(8);
            this.f43239i.setVisibility(0);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.f43236f)) {
                this.n.setCenterTextTitle(getPageContext().getString(R.string.video_aggregation_title));
            } else {
                this.n.setCenterTextTitle(getPageContext().getString(R.string.video_middle_page_title));
            }
            this.n.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        }
    }

    public final void k(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, view, z) == null) {
            if (this.q == null) {
                if (z) {
                    this.q = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, 0, n.f(getPageContext().getPageActivity(), R.dimen.ds480), n.f(getPageContext().getPageActivity(), R.dimen.ds360)), NoDataViewFactory.e.d(getPageContext().getPageActivity().getString(R.string.neterror), getPageContext().getPageActivity().getString(R.string.refresh_view_title_text)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getPageContext().getPageActivity().getString(R.string.refresh_view_button_text), new c(this))));
                } else {
                    this.q = NoDataViewFactory.a(getPageContext().getPageActivity(), this.o, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.video_no_data), null);
                }
            }
            this.q.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.q.setVisibility(0);
            this.f43239i.setVisibility(8);
        }
    }

    public void notifyVideo(int i2) {
        c.a.t0.e1.t1.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f43239i == null || (fVar = this.l) == null) {
            return;
        }
        if (i2 == 1 && fVar.e()) {
            this.l.k();
        }
        if (i2 == 2) {
            this.l.n();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.n.onChangeSkinType(getPageContext(), i2);
            this.p.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0111);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
            c.a.t0.e1.t1.f fVar = this.l;
            if (fVar != null) {
                fVar.h(configuration);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f43235e = arguments.getString("PARAM_FID");
                this.f43236f = arguments.getString("PARAM_FROM");
                this.f43237g = arguments.getString("st_type");
                this.f43238h = arguments.getString("yuelaou_locate");
            }
            i iVar = new i(getPageContext(), this);
            this.m = iVar;
            iVar.g(this.f43235e);
            this.m.f(this.f43236f);
            this.m.i(this.f43237g);
            this.m.h(this.f43238h);
            this.m.e();
            registerListener(this.s);
            registerListener(this.t);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.fragment_video_aggregation, (ViewGroup) null) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            i iVar = this.m;
            if (iVar != null) {
                iVar.c();
            }
            c.a.t0.e1.t1.f fVar = this.l;
            if (fVar != null) {
                fVar.i();
            }
        }
    }

    public boolean onKeyDown(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            c.a.t0.e1.t1.f fVar = this.l;
            if (fVar == null) {
                return false;
            }
            return fVar.j(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // c.a.t0.e1.t1.d
    public void onLoadFail() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ListUtils.isEmpty(this.r)) {
            k(this.o, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            notifyVideo(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            notifyVideo(2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.o = (FrameLayout) view.findViewById(R.id.container);
            this.n = (NavigationBar) view.findViewById(R.id.navigation_bar);
            j();
            this.p = (NoNetworkView) view.findViewById(R.id.no_network_view);
            if (!l.z()) {
                this.p.setVisibility(0);
            }
            this.f43239i = (BdTypeListView) view.findViewById(R.id.listView);
            g gVar = new g(getPageContext());
            this.f43240j = gVar;
            gVar.i();
            this.f43240j.a(new a(this));
            this.f43240j.V(getUniqueId());
            this.f43239i.setPullRefresh(this.f43240j);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.k = pbListView;
            pbListView.a();
            this.k.A();
            this.k.D(getResources().getString(R.string.list_has_no_more));
            this.k.R();
            this.f43239i.setNextPage(this.k);
            this.f43239i.setOnScrollListener(new b(this));
            this.l = new c.a.t0.e1.t1.f(getPageContext(), this.f43239i, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.f43236f));
            showLoadingView();
        }
    }

    @Override // c.a.t0.e1.t1.d
    public void setData(List<c.a.t0.e1.t1.g> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || list == null) {
            return;
        }
        if (z) {
            this.r = list;
        } else {
            this.r.addAll(list);
        }
        if (z && list.size() == 0) {
            k(this.o, false);
            return;
        }
        this.l.m(list, z);
        if (!z2) {
            this.k.f();
        }
        i();
        NoDataView noDataView = this.q;
        if (noDataView != null) {
            this.o.removeView(noDataView);
            this.q = null;
        }
    }

    public void showLoadingView() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || getPageContext() == null || (frameLayout = this.o) == null) {
            return;
        }
        showLoadingView(frameLayout, false, n.f(getPageContext().getPageActivity(), R.dimen.ds360));
    }

    @Override // c.a.t0.e1.t1.d
    public void showMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }
}
