package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import d.b.c.a.j;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.h0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements d.b.i0.q0.s1.a.d.b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16005e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f16006f;

    /* renamed from: g  reason: collision with root package name */
    public g f16007g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f16008h;
    public NoDataView i;
    public d.b.h0.d0.g j;
    public PbListView k;
    public d.b.i0.q0.s1.a.e.c l;
    public d.b.i0.q0.x1.b m;
    public d.b.i0.q0.s1.a.d.a n;
    public List<n> o;
    public int p;
    public int q;
    public boolean r;
    public w s;
    public f.g t;

    /* loaded from: classes4.dex */
    public class a implements w {

        /* renamed from: com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0191a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f16010e;

            public RunnableC0191a(a aVar, String str) {
                this.f16010e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f16010e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public a() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            a2 g2;
            boolean z;
            d.b.i0.q0.s1.a.d.e a2;
            if (nVar == null || !(nVar instanceof d.b.i0.q0.s1.a.a.b) || (g2 = ((d.b.i0.q0.s1.a.a.b) nVar).g()) == null) {
                return;
            }
            if (FrsGameStrategyItemListView.this.n != null && (a2 = FrsGameStrategyItemListView.this.n.a(FrsGameStrategyItemListView.this.p)) != null) {
                Object obj = a2.f60223c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(FrsGameStrategyItemListView.this.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", FrsGameStrategyItemListView.this.n.h()).param("tid", g2.o0()).param("obj_id", a2.f60222b).param("obj_locate", labelName));
                }
            }
            if (g2.O() == null || g2.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsGameStrategyItemListView.this.f16005e.getPageActivity())) {
                if (g2.G() != 1 || ViewHelper.checkUpIsLogin(FrsGameStrategyItemListView.this.f16005e.getPageActivity())) {
                    d.b.i0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(g2.o0())) {
                        readThreadHistory.a(g2.o0());
                        FrsGameStrategyItemListView.this.l.b();
                    }
                    String J = g2.J();
                    if (J == null || J.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC0191a(this, J)).start();
                        z = true;
                    }
                    String w1 = g2.w1();
                    if (w1 == null) {
                        w1 = "";
                    }
                    if (g2.x0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(FrsGameStrategyItemListView.this.f16005e, new String[]{w1, "", null});
                        return;
                    }
                    if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        g2.E3(w1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.f16005e.getPageActivity()).createFromThreadCfg(g2, null, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(g2.c0()));
                    createFromThreadCfg.setStartFrom(3);
                    FrsGameStrategyItemListView.this.f16005e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            FrsGameStrategyItemListView.this.t();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!FrsGameStrategyItemListView.this.r || FrsGameStrategyItemListView.this.n == null) {
                return;
            }
            FrsGameStrategyItemListView.this.n.d(FrsGameStrategyItemListView.this.p, FrsGameStrategyItemListView.this.q);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsGameStrategyItemListView.this.m != null) {
                FrsGameStrategyItemListView.this.m.b(view, motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsGameStrategyItemListView.this.t();
        }
    }

    public FrsGameStrategyItemListView(Context context, BdUniqueId bdUniqueId) {
        super(context);
        this.s = new a();
        this.t = new b();
        this.f16005e = (TbPageContext) j.a(context);
        this.f16006f = bdUniqueId;
        n();
    }

    @Override // d.b.i0.q0.s1.a.d.b
    public void a(int i, int i2, List<n> list, List<d.b.i0.q0.s1.a.d.e> list2, boolean z, boolean z2, int i3) {
        if ((i == 0 && i2 == 0) || (i == this.p && i2 == this.q)) {
            l();
            this.f16008h.z();
            if (ListUtils.isEmpty(list) && ListUtils.isEmpty(this.o)) {
                w(getContext().getString(R.string.no_data_text));
                k();
                this.r = false;
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                this.o = list;
            }
            this.l.d(this.o);
            this.r = z;
            if (z) {
                u();
            } else {
                x();
            }
        }
    }

    @Override // d.b.i0.q0.s1.a.d.b
    public void b(int i, int i2, String str) {
        if ((i == 0 && i2 == 0) || (i == this.p && i2 == this.q)) {
            this.r = false;
            l();
            if (ListUtils.isEmpty(this.o)) {
                w(str);
                k();
                return;
            }
            this.f16005e.showToast(str);
            x();
        }
    }

    public int getLabelId() {
        return this.q;
    }

    public int getTabId() {
        return this.p;
    }

    public final void k() {
        this.r = false;
        this.f16008h.setNextPage(null);
    }

    public final void l() {
        d.b.h0.d0.g gVar = this.j;
        if (gVar != null) {
            gVar.dettachView(this);
        }
    }

    public final void m() {
        NoDataView noDataView = this.i;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void n() {
        BdTypeListView bdTypeListView = new BdTypeListView(getContext());
        this.f16008h = bdTypeListView;
        bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
        this.f16008h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f16008h.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.f16008h.setFadingEdgeLength(0);
        this.f16008h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.f16008h.setOnSrollToBottomListener(new c());
        this.f16008h.setOnTouchListener(new d());
        addView(this.f16008h);
        d.b.i0.q0.s1.a.e.c cVar = new d.b.i0.q0.s1.a.e.c(this.f16005e, this.f16008h);
        this.l = cVar;
        cVar.c(this.s);
        g gVar = new g(this.f16005e);
        this.f16007g = gVar;
        gVar.Z(this.f16006f);
        this.f16007g.b(this.t);
        this.m = new d.b.i0.q0.x1.b(this.f16005e.getPageActivity(), this.f16006f, true);
        this.f16008h.setPullRefresh(this.f16007g);
        if (this.k == null) {
            PbListView pbListView = new PbListView(this.f16005e.getPageActivity());
            this.k = pbListView;
            pbListView.a();
        }
        this.k.o(R.color.CAM_X0204);
    }

    public void o(int i, int i2) {
        this.p = i;
        this.q = i2;
        k();
        LinkedList linkedList = new LinkedList();
        this.o = linkedList;
        this.l.d(linkedList);
        this.n.c(i, i2);
    }

    public void p(int i) {
        SkinManager.setBackgroundColor(this.f16008h, R.color.CAM_X0204);
        g gVar = this.f16007g;
        if (gVar != null) {
            gVar.I(i);
        }
        NoDataView noDataView = this.i;
        if (noDataView != null) {
            noDataView.f(this.f16005e, i);
        }
    }

    public void q() {
    }

    public void r() {
        if (ListUtils.isEmpty(this.o) && (this.p != 0 || this.q != 0)) {
            v();
            this.n.b(this.p, this.q);
        }
        p(TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        this.f16008h.F();
    }

    public void setFrsGameTabDataLoadListener(d.b.i0.q0.s1.a.d.a aVar) {
        this.n = aVar;
    }

    public final void t() {
        m();
        d.b.i0.q0.s1.a.d.a aVar = this.n;
        if (aVar != null) {
            aVar.b(this.p, this.q);
        }
    }

    public final void u() {
        this.r = true;
        this.f16008h.setNextPage(this.k);
        this.k.O();
    }

    public final void v() {
        if (this.j == null) {
            d.b.h0.d0.g gVar = new d.b.h0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.j = gVar;
            gVar.onChangeSkinType();
        }
        this.j.attachView(this, false);
    }

    public final void w(String str) {
        if (this.i == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e()), getResources().getDimensionPixelSize(R.dimen.ds20)));
        }
        this.i.f(this.f16005e, TbadkCoreApplication.getInst().getSkinType());
        this.i.setVisibility(0);
        this.i.bringToFront();
    }

    public final void x() {
        this.r = false;
        this.f16008h.setNextPage(this.k);
        this.k.f();
        this.k.A(this.f16005e.getResources().getString(R.string.list_no_more));
    }
}
