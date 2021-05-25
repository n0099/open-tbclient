package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.n0.r0.i1.i;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoAggregationFragment extends BaseFragment implements View.OnClickListener, d.a.n0.r0.i1.d {

    /* renamed from: e  reason: collision with root package name */
    public String f15219e;

    /* renamed from: f  reason: collision with root package name */
    public String f15220f;

    /* renamed from: g  reason: collision with root package name */
    public String f15221g;

    /* renamed from: h  reason: collision with root package name */
    public String f15222h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f15223i;
    public g j;
    public PbListView k;
    public d.a.n0.r0.i1.f l;
    public i m;
    public NavigationBar n;
    public FrameLayout o;
    public NoNetworkView p;
    public NoDataView q;
    public List<d.a.n0.r0.i1.g> r = null;
    public CustomMessageListener s = new e(2000994);
    public CustomMessageListener t = new f(2001115);

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            VideoAggregationFragment.this.m.e();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (VideoAggregationFragment.this.l != null) {
                if (i2 > VideoAggregationFragment.this.l.c() || i2 + i3 < VideoAggregationFragment.this.l.c()) {
                    VideoAggregationFragment.this.l.b();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 != 0 || absListView.getLastVisiblePosition() <= absListView.getCount() - 2 || absListView.getFirstVisiblePosition() == 0) {
                return;
            }
            VideoAggregationFragment.this.m.d();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoAggregationFragment.this.I0();
            VideoAggregationFragment.this.m.e();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoAggregationFragment.this.getActivity() == null || VideoAggregationFragment.this.getActivity().isFinishing()) {
                return;
            }
            VideoAggregationFragment.this.getActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.z()) {
                if (VideoAggregationFragment.this.q != null) {
                    VideoAggregationFragment.this.m.e();
                } else if (j.x() && VideoAggregationFragment.this.l != null && VideoAggregationFragment.this.l.e()) {
                    VideoAggregationFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || VideoAggregationFragment.this.l == null || (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) == null || !data.f12574a) {
                return;
            }
            VideoAggregationFragment.this.l.f(data.f12576c, data.f12577d);
        }
    }

    public static VideoAggregationFragment H0(String str, String str2, String str3, String str4) {
        VideoAggregationFragment videoAggregationFragment = new VideoAggregationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FID", str);
        bundle.putString("PARAM_FROM", str2);
        bundle.putString("st_type", str3);
        bundle.putString("yuelaou_locate", str4);
        videoAggregationFragment.setArguments(bundle);
        return videoAggregationFragment;
    }

    public final void I0() {
        NoDataView noDataView = this.q;
        if (noDataView == null || noDataView.getVisibility() != 0) {
            return;
        }
        this.q.setVisibility(8);
        this.f15223i.setVisibility(0);
    }

    public final void J0() {
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.f15220f)) {
            this.n.setCenterTextTitle(getPageContext().getString(R.string.video_aggregation_title));
        } else {
            this.n.setCenterTextTitle(getPageContext().getString(R.string.video_middle_page_title));
        }
        this.n.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
    }

    public void K0(int i2) {
        d.a.n0.r0.i1.f fVar;
        if (this.f15223i == null || (fVar = this.l) == null) {
            return;
        }
        if (i2 == 1 && fVar.e()) {
            this.l.k();
        }
        if (i2 == 2) {
            this.l.n();
        }
    }

    public boolean L0(int i2) {
        d.a.n0.r0.i1.f fVar = this.l;
        if (fVar == null) {
            return false;
        }
        return fVar.j(i2);
    }

    public void M0() {
        FrameLayout frameLayout;
        if (getPageContext() == null || (frameLayout = this.o) == null) {
            return;
        }
        showLoadingView(frameLayout, false, l.g(getPageContext().getPageActivity(), R.dimen.ds360));
    }

    public final void N0(View view, boolean z) {
        if (this.q == null) {
            if (z) {
                this.q = NoDataViewFactory.a(getPageContext().getPageActivity(), view, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds480), l.g(getPageContext().getPageActivity(), R.dimen.ds360)), NoDataViewFactory.e.d(getPageContext().getPageActivity().getString(R.string.neterror), getPageContext().getPageActivity().getString(R.string.refresh_view_title_text)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getPageContext().getPageActivity().getString(R.string.refresh_view_button_text), new c())));
            } else {
                this.q = NoDataViewFactory.a(getPageContext().getPageActivity(), this.o, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.video_no_data), null);
            }
        }
        this.q.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.q.setVisibility(0);
        this.f15223i.setVisibility(8);
    }

    @Override // d.a.n0.r0.i1.d
    public void c(String str) {
    }

    @Override // d.a.n0.r0.i1.d
    public void d(List<d.a.n0.r0.i1.g> list, boolean z, boolean z2) {
        if (list == null) {
            return;
        }
        if (z) {
            this.r = list;
        } else {
            this.r.addAll(list);
        }
        if (z && list.size() == 0) {
            N0(this.o, false);
            return;
        }
        this.l.m(list, z);
        if (!z2) {
            this.k.f();
        }
        I0();
        NoDataView noDataView = this.q;
        if (noDataView != null) {
            this.o.removeView(noDataView);
            this.q = null;
        }
    }

    @Override // d.a.n0.r0.i1.d
    public void n() {
        if (this.o == null) {
            return;
        }
        this.f15223i.A(0L);
        hideLoadingView(this.o);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.n.onChangeSkinType(getPageContext(), i2);
        this.p.c(getPageContext(), i2);
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0111);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
        }
        d.a.n0.r0.i1.f fVar = this.l;
        if (fVar != null) {
            fVar.h(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15219e = arguments.getString("PARAM_FID");
            this.f15220f = arguments.getString("PARAM_FROM");
            this.f15221g = arguments.getString("st_type");
            this.f15222h = arguments.getString("yuelaou_locate");
        }
        i iVar = new i(getPageContext(), this);
        this.m = iVar;
        iVar.g(this.f15219e);
        this.m.f(this.f15220f);
        this.m.i(this.f15221g);
        this.m.h(this.f15222h);
        this.m.e();
        registerListener(this.s);
        registerListener(this.t);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_aggregation, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i iVar = this.m;
        if (iVar != null) {
            iVar.c();
        }
        d.a.n0.r0.i1.f fVar = this.l;
        if (fVar != null) {
            fVar.i();
        }
    }

    @Override // d.a.n0.r0.i1.d
    public void onLoadFail() {
        if (ListUtils.isEmpty(this.r)) {
            N0(this.o, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        K0(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        K0(2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.o = (FrameLayout) view.findViewById(R.id.container);
        this.n = (NavigationBar) view.findViewById(R.id.navigation_bar);
        J0();
        this.p = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.z()) {
            this.p.setVisibility(0);
        }
        this.f15223i = (BdTypeListView) view.findViewById(R.id.listView);
        g gVar = new g(getPageContext());
        this.j = gVar;
        gVar.n();
        this.j.a(new a());
        this.j.Z(getUniqueId());
        this.f15223i.setPullRefresh(this.j);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.k = pbListView;
        pbListView.a();
        this.k.x();
        this.k.A(getResources().getString(R.string.list_has_no_more));
        this.k.O();
        this.f15223i.setNextPage(this.k);
        this.f15223i.setOnScrollListener(new b());
        this.l = new d.a.n0.r0.i1.f(getPageContext(), this.f15223i, VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD.equals(this.f15220f));
        M0();
    }
}
