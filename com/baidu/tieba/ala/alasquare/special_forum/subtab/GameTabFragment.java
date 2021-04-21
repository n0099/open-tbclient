package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.d0.h;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public View f14557h;
    public BdTypeListView i;
    public PbListView j;
    public g k;
    public h l;
    public d.b.j0.t.d.f.b.d m;
    public AlaLiveTabGameModel n;
    public String r;
    public boolean o = true;
    public boolean p = false;
    public boolean q = false;
    public AlaLiveTabGameModel.b s = new b();
    public BdListView.p t = new c();
    public final f.g u = new d();

    /* loaded from: classes4.dex */
    public class a implements d.b.j0.t.d.g.d.f {
        public a() {
        }

        @Override // d.b.j0.t.d.g.d.f
        public void a(d.b.j0.t.d.a.a aVar) {
            GameTabFragment.this.Y0(aVar);
            TiebaStatic.log(new StatisticItem("c12904").param(TiebaStatic.Params.ENTRY_NAME, GameTabFragment.this.r));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaLiveTabGameModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.b
        public void a(boolean z, List<n> list) {
            GameTabFragment.this.o = z;
            GameTabFragment.this.q = true;
            GameTabFragment.this.b1(false);
            GameTabFragment gameTabFragment = GameTabFragment.this;
            gameTabFragment.hideLoadingView(gameTabFragment.f14557h);
            if (ListUtils.isEmpty(list)) {
                GameTabFragment.this.d1();
                return;
            }
            GameTabFragment.this.i.setData(list);
            if (!GameTabFragment.this.o) {
                GameTabFragment.this.e1();
            } else {
                GameTabFragment.this.c1();
            }
            GameTabFragment.this.X0();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.b
        public void b(int i, String str, boolean z) {
            GameTabFragment gameTabFragment = GameTabFragment.this;
            gameTabFragment.hideLoadingView(gameTabFragment.f14557h);
            GameTabFragment.this.W0();
            GameTabFragment.this.d1();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.C()) {
                GameTabFragment.this.W0();
            } else if (GameTabFragment.this.o) {
                GameTabFragment.this.n.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                GameTabFragment.this.n.E();
            } else {
                GameTabFragment.this.b1(false);
            }
        }
    }

    public static GameTabFragment Z0(String str) {
        GameTabFragment gameTabFragment = new GameTabFragment();
        if (!StringUtils.isNull(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("key_special_forum_game_tab_entryname", str);
            gameTabFragment.setArguments(bundle);
        }
        return gameTabFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void E() {
        super.E();
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView != null) {
            bdTypeListView.smoothScrollToPosition(0);
            this.i.F();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void G0() {
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView != null) {
            bdTypeListView.getAdapter2().notifyDataSetChanged();
        }
    }

    public final void W0() {
        this.i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public final void X0() {
        h hVar;
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView == null || (hVar = this.l) == null) {
            return;
        }
        this.p = false;
        bdTypeListView.removeHeaderView(hVar.b());
    }

    public final void Y0(d.b.j0.t.d.a.a aVar) {
        SdkLiveInfoData sdkLiveInfoData;
        if (aVar == null || (sdkLiveInfoData = aVar.f62220e) == null) {
            return;
        }
        if (sdkLiveInfoData.shouldJumpChushouLiveRoom()) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            SdkLiveInfoData sdkLiveInfoData2 = aVar.f62220e;
            d.b.j0.t.d.c.c.c(pageContext, sdkLiveInfoData2.roomId, String.valueOf(sdkLiveInfoData2.liveInfo.liveType));
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = d.b.c.e.m.b.f(aVar.f62220e.roomId, 0L);
        SdkLiveInfoData sdkLiveInfoData3 = aVar.f62220e;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData3.liveInfo;
        if (alaLiveInfo != null) {
            alaLiveInfoCoreData.hslUrl = alaLiveInfo.hlsUrl;
            alaLiveInfoCoreData.liveCover = alaLiveInfo.cover;
            alaLiveInfoCoreData.rtmpUrl = alaLiveInfo.rtmpUrl;
            alaLiveInfoCoreData.liveTitle = sdkLiveInfoData3.title;
            alaLiveInfoCoreData.audienceCount = alaLiveInfo.audienceCount;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
    }

    public final void a1() {
        this.q = false;
        this.n.E();
        showLoadingView(this.f14557h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    public void b1(boolean z) {
        if (z) {
            return;
        }
        this.i.z();
    }

    public final void c1() {
        this.i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.O();
    }

    public final void d1() {
        if (this.l == null) {
            h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
            this.l = hVar;
            hVar.m(null);
            this.l.g(null);
            this.l.o();
            this.l.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.l.l(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.l.onChangeSkinType();
        if (this.p) {
            return;
        }
        this.i.x(this.l.b(), 0);
        this.p = true;
    }

    public final void e1() {
        this.i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.A(getResources().getString(R.string.list_no_more));
        this.j.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.j.d(i);
        }
        h hVar = this.l;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && !StringUtils.isNull(arguments.getString("key_special_forum_game_tab_entryname"))) {
            this.r = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.n == null) {
            this.n = new AlaLiveTabGameModel(getPageContext(), this.s);
        }
        this.n.init();
        if (this.m == null) {
            d.b.j0.t.d.f.b.d dVar = new d.b.j0.t.d.f.b.d(getPageContext());
            this.m = dVar;
            dVar.j0(this.r);
            this.m.l0(new a());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f14557h == null) {
            View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.f14557h = inflate;
            BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
            this.i = bdTypeListView;
            bdTypeListView.setOnSrollToBottomListener(this.t);
            g gVar = new g(getPageContext());
            this.k = gVar;
            gVar.b(this.u);
            this.i.setPullRefresh(this.k);
            PbListView pbListView = new PbListView(getContext());
            this.j = pbListView;
            pbListView.a();
            this.j.o(R.color.CAM_X0201);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.v();
            this.j.E(R.dimen.tbfontsize33);
            this.j.C(SkinManager.getColor(R.color.CAM_X0107));
            this.j.y(R.color.CAM_X0110);
            this.j.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m);
            this.i.a(arrayList);
        }
        if (this.f14557h.getParent() != null) {
            ((ViewGroup) this.f14557h.getParent()).removeView(this.f14557h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f14557h;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.i.setOnSrollToBottomListener(null);
        this.i.setScrollable(null);
        this.n.onDestroy();
        hideLoadingView(this.f14557h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        a1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.q) {
            a1();
        }
    }
}
