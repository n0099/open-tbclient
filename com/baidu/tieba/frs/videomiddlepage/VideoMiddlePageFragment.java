package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.q;
import d.a.n0.r0.i1.g;
import d.a.n0.r0.p2.h;
import d.a.n0.r0.p2.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoMiddlePageFragment extends BaseFragment implements h, d.a.n0.r0.p2.c {
    public int B;
    public int C;

    /* renamed from: e  reason: collision with root package name */
    public i f15844e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManager f15845f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f15846g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f15847h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r0.p2.f f15848i;
    public NavigationBar k;
    public View l;
    public ImageView m;
    public PbListView n;
    public View o;
    public int p;
    public boolean q;
    public NoNetworkView r;
    public String s;
    public List<BaseCardInfo> t;
    public d.a.m0.r.f0.a u;
    public d.a.n0.r0.p2.d w;
    public String y;
    public boolean j = true;
    public int v = -1;
    public boolean x = false;
    public boolean z = false;
    public int D = 4;
    public int E = 7;
    public int F = 4;
    public CustomMessageListener G = new a(2921317);
    public CustomMessageListener H = new b(2000994);
    public CustomMessageListener I = new c(2001115);
    public RecyclerView.OnScrollListener J = new e();
    public CustomMessageListener K = new f(2921414);
    public HashMap A = new HashMap();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921317 || customResponsedMessage.getmOrginalMessage() == null || customResponsedMessage.getmOrginalMessage().getExtra() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getmOrginalMessage().getExtra();
            if (VideoMiddlePageFragment.this.m != null) {
                if (Config.EXCEPTION_MEMORY_LOW.equals(str)) {
                    VideoMiddlePageFragment.this.m.setAlpha(0.2f);
                } else if ("high".equals(str)) {
                    VideoMiddlePageFragment.this.m.setAlpha(1.0f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError()) {
                return;
            }
            if (j.z()) {
                if (VideoMiddlePageFragment.this.r != null) {
                    VideoMiddlePageFragment.this.r.setVisibility(8);
                }
                if (!j.x() || d.a.n0.r3.f.d().e()) {
                    return;
                }
                if (VideoMiddlePageFragment.this.f15848i == null || !VideoMiddlePageFragment.this.f15848i.k()) {
                    if (VideoMiddlePageFragment.this.f15848i == null || !VideoMiddlePageFragment.this.f15848i.n()) {
                        return;
                    }
                    VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
                    return;
                }
                VideoMiddlePageFragment.this.getPageContext().showToast(R.string.video_mobile_play_tips);
            } else if (VideoMiddlePageFragment.this.r != null) {
                VideoMiddlePageFragment.this.r.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || VideoMiddlePageFragment.this.f15848i == null || (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) == null || !data.f12636a) {
                return;
            }
            VideoMiddlePageFragment.this.f15848i.o(data.f12638c, data.f12639d);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoMiddlePageFragment.this.getPageContext().getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                VideoMiddlePageFragment.this.p = i2;
                if (i2 != 0) {
                    if (i2 == 1) {
                        VideoMiddlePageFragment.this.m.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
                if (bdTypeRecyclerView.getLastVisiblePosition() > bdTypeRecyclerView.getCount() - 2 && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                    VideoMiddlePageFragment.this.f15844e.h(VideoMiddlePageFragment.this.s);
                    VideoMiddlePageFragment.this.f15844e.f();
                }
                VideoMiddlePageFragment.this.U0(bdTypeRecyclerView);
                d.a.n0.d3.c.g().h(VideoMiddlePageFragment.this.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (recyclerView instanceof BdTypeRecyclerView) {
                BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) recyclerView;
                if (VideoMiddlePageFragment.this.f15848i != null) {
                    if (bdTypeRecyclerView.getFirstVisiblePosition() > VideoMiddlePageFragment.this.f15848i.g() || bdTypeRecyclerView.getLastVisiblePosition() < VideoMiddlePageFragment.this.f15848i.g()) {
                        VideoMiddlePageFragment.this.f15848i.e();
                    }
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
            if (VideoMiddlePageFragment.this.f15848i != null) {
                VideoMiddlePageFragment.this.f15848i.p();
            }
        }
    }

    public static VideoMiddlePageFragment P0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("PARAM_FROM", str);
        bundle.putString("PARAM_FID", str2);
        VideoMiddlePageFragment videoMiddlePageFragment = new VideoMiddlePageFragment();
        videoMiddlePageFragment.setArguments(bundle);
        return videoMiddlePageFragment;
    }

    public final int N0(int i2) {
        int i3 = i2 + 1;
        int i4 = this.D;
        int i5 = 1;
        if (i3 > i4 - 1) {
            int i6 = i3 - (i4 - 1);
            if (i6 >= i4 - 1) {
                i5 = 1 + (i6 % (this.E - 1));
            }
        } else {
            i5 = 0;
        }
        return i5 + i2;
    }

    public d.a.n0.r0.p2.a O0() {
        d.a.n0.r0.p2.f fVar = this.f15848i;
        if (fVar != null) {
            return fVar.f();
        }
        return null;
    }

    public int Q0(View view) {
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int height = view.getHeight();
        if (rect.top == 0 && rect.bottom == height) {
            return 100;
        }
        int i2 = rect.top;
        if (i2 > 0) {
            return ((height - i2) * 100) / height;
        }
        int i3 = rect.bottom;
        if (i3 <= 0 || i3 >= height) {
            return 100;
        }
        return (i3 * 100) / height;
    }

    public final boolean R0(g gVar) {
        i iVar;
        VideoSerializeVideoThreadInfo e2;
        return (!"0".equals(gVar.f62381f) || (iVar = this.f15844e) == null || iVar.e() == null || (e2 = this.f15844e.e()) == null || e2.video == null || !TextUtils.equals(e2.title, gVar.x) || !TextUtils.equals(e2.video.videoUrl, gVar.getVideoUrl())) ? false : true;
    }

    public void S0(int i2) {
        d.a.n0.r0.p2.f fVar;
        if (this.f15846g == null || (fVar = this.f15848i) == null) {
            return;
        }
        if (i2 == 1) {
            if (fVar.n()) {
                this.f15848i.z();
            } else if (this.f15848i.k()) {
                this.f15848i.A();
            }
        }
        if (i2 == 2) {
            this.f15848i.A();
            if (this.f15848i.n()) {
                this.f15848i.v();
            }
        }
    }

    public boolean T0(int i2) {
        d.a.n0.r0.p2.f fVar = this.f15848i;
        if (fVar == null) {
            return false;
        }
        return fVar.s(i2);
    }

    public final void U0(BdTypeRecyclerView bdTypeRecyclerView) {
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition() - bdTypeRecyclerView.getHeaderViewsCount();
        int i2 = 0;
        if (firstVisiblePosition < 0) {
            firstVisiblePosition = 0;
        }
        if (bdTypeRecyclerView.getChildCount() > 0 && ((bdTypeRecyclerView.getChildAt(0) instanceof RelativeLayout) || (bdTypeRecyclerView.getChildAt(0) instanceof d.a.n0.k1.o.l.e))) {
            i2 = Q0(bdTypeRecyclerView.getChildAt(0));
        } else if (bdTypeRecyclerView.getChildCount() > 1) {
            i2 = Q0(bdTypeRecyclerView.getChildAt(1));
        }
        if (!this.f15848i.m(firstVisiblePosition) || i2 < 95) {
            firstVisiblePosition += this.f15848i.i(firstVisiblePosition);
        }
        this.f15848i.d(firstVisiblePosition);
    }

    public final void V0(List<BaseCardInfo> list, boolean z) {
        if (this.f15848i != null && !ListUtils.isEmpty(list)) {
            if (this.j) {
                this.f15848i.w(list, true);
                this.j = false;
            } else {
                this.f15848i.w(list, false);
            }
        }
        if (z) {
            return;
        }
        this.n.K();
    }

    @Override // d.a.n0.r0.p2.h
    public void c(String str) {
    }

    @Override // d.a.n0.r0.p2.h
    public void d(List<BaseCardInfo> list, boolean z, boolean z2) {
        i iVar;
        g.a aVar;
        ArrayList arrayList = null;
        d.a.d.d dVar = null;
        if (!ListUtils.isEmpty(list)) {
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                this.D = TbadkCoreApplication.getInst().getAdAdSense().n;
                this.E = TbadkCoreApplication.getInst().getAdAdSense().p;
                this.F = TbadkCoreApplication.getInst().getAdAdSense().o;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (size <= 0) {
                    break;
                }
                boolean z3 = (size - (this.D - 1)) % (this.E - 1) == 0;
                boolean z4 = i2 - size == this.F;
                if (i2 <= this.F) {
                    z4 = size == 1;
                }
                if (z3) {
                    i iVar2 = this.f15844e;
                    d.a.d.h f2 = d.a.d.c.f(3, iVar2 != null ? iVar2.d() : 0, 0, "", "", N0(size));
                    f2.a(this.A);
                    dVar = d.a.d.d.c(f2);
                    d.a.n0.k1.o.k.a.b(arrayList2, dVar, 0);
                    i2 = size + 1;
                }
                if (z4) {
                    BaseCardInfo baseCardInfo = list.get(size - 1);
                    if (dVar != null && baseCardInfo != null) {
                        baseCardInfo.setTrigger(new d.a.d.g(dVar));
                    }
                }
                arrayList2.add(0, list.get(size - 1));
                size--;
            }
            if (!this.x && this.t.size() > 0 && (iVar = this.f15844e) != null && iVar.e() != null) {
                String str = this.f15844e.e().threadId;
                if (arrayList2.size() > 0 && (arrayList2.get(0) instanceof g)) {
                    g gVar = (g) arrayList2.get(0);
                    if (str.equals(gVar.f62381f) || R0(gVar)) {
                        if (!StringUtils.isNull(gVar.z.n) || ((aVar = gVar.z.o) != null && aVar.a())) {
                            this.f15848i.B(gVar);
                        }
                        if (this.t.get(0) != null) {
                            this.t.get(0).setTrigger(gVar.getTrigger());
                        }
                        arrayList2.remove(gVar);
                    }
                    this.x = true;
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            this.t.addAll(arrayList);
        }
        if (this.z) {
            return;
        }
        V0(arrayList, z);
    }

    @Override // d.a.n0.r0.p2.h
    public void o() {
        d.a.m0.r.f0.a aVar = this.u;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.r.c(getPageContext(), i2);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z = !this.q;
            this.q = true;
            this.k.setVisibility(8);
            this.B = this.f15846g.getFirstVisiblePosition();
            View childAt = this.f15846g.getChildAt(0);
            this.C = childAt != null ? childAt.getTop() : 0;
        } else {
            z = this.q;
            this.q = false;
            this.k.setVisibility(0);
        }
        d.a.n0.r0.p2.f fVar = this.f15848i;
        if (fVar != null) {
            fVar.q(configuration);
        }
        if (!z || this.q || O0() == null || this.B == this.f15846g.getFirstVisiblePosition()) {
            return;
        }
        ((LinearLayoutManager) this.f15846g.getLayoutManager()).scrollToPositionWithOffset(this.B, this.C);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.d3.c.g().i(getUniqueId());
        this.f15844e = new i(this);
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_FID");
            String stringExtra2 = intent.getStringExtra("st_type");
            String stringExtra3 = intent.getStringExtra("yuelaou_locate");
            this.f15844e.i(stringExtra);
            this.f15844e.j(stringExtra3);
            this.f15844e.k(stringExtra2);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = (VideoSerializeVideoThreadInfo) intent.getSerializableExtra("param_video_thread_info");
            if (videoSerializeVideoThreadInfo != null) {
                this.A.put("forum_id", videoSerializeVideoThreadInfo.forumId);
                this.A.put("thread_id", videoSerializeVideoThreadInfo.threadId);
            }
            this.f15844e.l(videoSerializeVideoThreadInfo);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.s = arguments.getString("PARAM_FROM");
            this.y = arguments.getString("PARAM_FID");
        }
        i iVar = this.f15844e;
        if (iVar != null) {
            iVar.h(this.s);
            this.f15844e.g();
        }
        registerListener(this.H);
        registerListener(this.I);
        registerListener(this.G);
        registerListener(this.K);
        new d.a.n0.q3.b();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_video_middle_page_layout, viewGroup, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.d3.c.g().k(getUniqueId());
        i iVar = this.f15844e;
        if (iVar != null) {
            iVar.c();
        }
        d.a.n0.r0.p2.f fVar = this.f15848i;
        if (fVar != null) {
            fVar.r();
        }
        d.a.n0.r0.p2.d dVar = this.w;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        return this.f15846g.getPreLoadHandle();
    }

    @Override // d.a.n0.r0.p2.h
    public void onLoadFail() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.a.n0.r0.p2.f fVar = this.f15848i;
        if (fVar != null) {
            fVar.x(true);
            this.v = this.f15848i.g();
        }
        S0(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        d.a.n0.r0.p2.f fVar;
        int i2;
        super.onResume();
        d.a.n0.r0.p2.f fVar2 = this.f15848i;
        if (fVar2 != null) {
            fVar2.x(false);
        }
        if (this.j) {
            return;
        }
        S0(2);
        if (this.f15848i.n() || (fVar = this.f15848i) == null || (i2 = this.v) == -1) {
            return;
        }
        fVar.d(i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.a.n0.d3.c.g().h(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        this.f15845f = new LinearLayoutManager(getContext());
        this.o = new View(getPageContext().getPageActivity());
        this.o.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(getPageContext().getPageActivity(), R.dimen.ds88) + l.g(getPageContext().getPageActivity(), R.dimen.tbds42)));
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.video_middle_page_list_view);
        this.f15846g = bdTypeRecyclerView;
        bdTypeRecyclerView.s(this.o);
        this.f15846g.setLayoutManager(this.f15845f);
        this.f15846g.setFadingEdgeLength(0);
        this.f15846g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f15846g.setOverScrollMode(2);
        this.f15846g.setScrollable(this);
        this.f15847h = (RelativeLayout) view.findViewById(R.id.container);
        this.r = (NoNetworkView) view.findViewById(R.id.no_network_view);
        if (!j.z()) {
            this.r.setVisibility(0);
        }
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.n = pbListView;
        pbListView.s(false);
        this.n.a();
        this.n.v();
        this.n.o(R.color.CAM_X0105);
        this.n.A(getResources().getString(R.string.list_has_no_more));
        this.n.C(R.color.CAM_X0109);
        this.n.y(R.color.CAM_X0106);
        this.f15846g.setNextPage(this.n);
        this.n.J(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds804));
        this.f15846g.setOnScrollListener(this.J);
        this.f15848i = new d.a.n0.r0.p2.f(getPageContext(), this.f15846g, this, true, this.s, this.y, getUniqueId());
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.k = navigationBar;
        navigationBar.getBarBgView().setAlpha(0.0f);
        this.k.getTopCoverBgView().setAlpha(1.0f);
        this.k.hideBottomLine();
        if (DeviceInfoUtil.isReno3()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = l.g(getPageContext().getPageActivity(), R.dimen.tbds40);
            this.k.setLayoutParams(layoutParams);
        }
        View addSystemImageButton = this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d());
        this.l = addSystemImageButton;
        ImageView imageView = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.m = imageView;
        imageView.setImageDrawable(getPageContext().getResources().getDrawable(R.drawable.icon_return_bg));
        this.t = new ArrayList();
        d.a.n0.r0.p2.d dVar = new d.a.n0.r0.p2.d();
        this.w = dVar;
        dVar.e(this.f15844e);
        g b2 = this.w.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(b2);
        d(arrayList, true, false);
    }

    @Override // d.a.n0.r0.p2.h
    public void p0(d.a.n0.r0.p2.g gVar) {
    }

    @Override // d.a.n0.r0.p2.c
    public void t0(int i2) {
        d.a.n0.r0.p2.f fVar = this.f15848i;
        if (fVar == null) {
            return;
        }
        fVar.y(i2 - 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        return j.H() || d.a.n0.r3.f.d().e();
    }
}
