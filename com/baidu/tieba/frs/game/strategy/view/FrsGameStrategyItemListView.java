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
import d.a.c.a.j;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import d.a.j0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements d.a.k0.q0.s1.a.d.b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15528e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f15529f;

    /* renamed from: g  reason: collision with root package name */
    public g f15530g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f15531h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f15532i;
    public d.a.j0.d0.g j;
    public PbListView k;
    public d.a.k0.q0.s1.a.e.c l;
    public d.a.k0.q0.x1.b m;
    public d.a.k0.q0.s1.a.d.a n;
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
        public class RunnableC0175a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15534e;

            public RunnableC0175a(a aVar, String str) {
                this.f15534e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f15534e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public a() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a2 h2;
            boolean z;
            d.a.k0.q0.s1.a.d.e a2;
            if (nVar == null || !(nVar instanceof d.a.k0.q0.s1.a.a.b) || (h2 = ((d.a.k0.q0.s1.a.a.b) nVar).h()) == null) {
                return;
            }
            if (FrsGameStrategyItemListView.this.n != null && (a2 = FrsGameStrategyItemListView.this.n.a(FrsGameStrategyItemListView.this.p)) != null) {
                Object obj = a2.f59493c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(FrsGameStrategyItemListView.this.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", FrsGameStrategyItemListView.this.n.h()).param("tid", h2.o0()).param("obj_id", a2.f59492b).param("obj_locate", labelName));
                }
            }
            if (h2.O() == null || h2.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsGameStrategyItemListView.this.f15528e.getPageActivity())) {
                if (h2.G() != 1 || ViewHelper.checkUpIsLogin(FrsGameStrategyItemListView.this.f15528e.getPageActivity())) {
                    d.a.k0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(h2.o0())) {
                        readThreadHistory.a(h2.o0());
                        FrsGameStrategyItemListView.this.l.b();
                    }
                    String J = h2.J();
                    if (J == null || J.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC0175a(this, J)).start();
                        z = true;
                    }
                    String x1 = h2.x1();
                    if (x1 == null) {
                        x1 = "";
                    }
                    if (h2.x0() == 2 && !x1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(FrsGameStrategyItemListView.this.f15528e, new String[]{x1, "", null});
                        return;
                    }
                    if (x1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        h2.G3(x1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.f15528e.getPageActivity()).createFromThreadCfg(h2, null, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(h2.c0()));
                    createFromThreadCfg.setStartFrom(3);
                    FrsGameStrategyItemListView.this.f15528e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.j0.r.f0.f.g
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
            FrsGameStrategyItemListView.this.n.c(FrsGameStrategyItemListView.this.p, FrsGameStrategyItemListView.this.q);
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
        this.f15528e = (TbPageContext) j.a(context);
        this.f15529f = bdUniqueId;
        n();
    }

    @Override // d.a.k0.q0.s1.a.d.b
    public void a(int i2, int i3, List<n> list, List<d.a.k0.q0.s1.a.d.e> list2, boolean z, boolean z2, int i4) {
        if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
            l();
            this.f15531h.z();
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

    @Override // d.a.k0.q0.s1.a.d.b
    public void b(int i2, int i3, String str) {
        if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
            this.r = false;
            l();
            if (ListUtils.isEmpty(this.o)) {
                w(str);
                k();
                return;
            }
            this.f15528e.showToast(str);
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
        this.f15531h.setNextPage(null);
    }

    public final void l() {
        d.a.j0.d0.g gVar = this.j;
        if (gVar != null) {
            gVar.dettachView(this);
        }
    }

    public final void m() {
        NoDataView noDataView = this.f15532i;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void n() {
        BdTypeListView bdTypeListView = new BdTypeListView(getContext());
        this.f15531h = bdTypeListView;
        bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
        this.f15531h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f15531h.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.f15531h.setFadingEdgeLength(0);
        this.f15531h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.f15531h.setOnSrollToBottomListener(new c());
        this.f15531h.setOnTouchListener(new d());
        addView(this.f15531h);
        d.a.k0.q0.s1.a.e.c cVar = new d.a.k0.q0.s1.a.e.c(this.f15528e, this.f15531h);
        this.l = cVar;
        cVar.c(this.s);
        g gVar = new g(this.f15528e);
        this.f15530g = gVar;
        gVar.Z(this.f15529f);
        this.f15530g.a(this.t);
        this.m = new d.a.k0.q0.x1.b(this.f15528e.getPageActivity(), this.f15529f, true);
        this.f15531h.setPullRefresh(this.f15530g);
        if (this.k == null) {
            PbListView pbListView = new PbListView(this.f15528e.getPageActivity());
            this.k = pbListView;
            pbListView.a();
        }
        this.k.o(R.color.CAM_X0204);
    }

    public void o(int i2, int i3) {
        this.p = i2;
        this.q = i3;
        k();
        LinkedList linkedList = new LinkedList();
        this.o = linkedList;
        this.l.d(linkedList);
        this.n.d(i2, i3);
    }

    public void p(int i2) {
        SkinManager.setBackgroundColor(this.f15531h, R.color.CAM_X0204);
        g gVar = this.f15530g;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoDataView noDataView = this.f15532i;
        if (noDataView != null) {
            noDataView.f(this.f15528e, i2);
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
        this.f15531h.F();
    }

    public void setFrsGameTabDataLoadListener(d.a.k0.q0.s1.a.d.a aVar) {
        this.n = aVar;
    }

    public final void t() {
        m();
        d.a.k0.q0.s1.a.d.a aVar = this.n;
        if (aVar != null) {
            aVar.b(this.p, this.q);
        }
    }

    public final void u() {
        this.r = true;
        this.f15531h.setNextPage(this.k);
        this.k.O();
    }

    public final void v() {
        if (this.j == null) {
            d.a.j0.d0.g gVar = new d.a.j0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.j = gVar;
            gVar.onChangeSkinType();
        }
        this.j.attachView(this, false);
    }

    public final void w(String str) {
        if (this.f15532i == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.f15532i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e()), getResources().getDimensionPixelSize(R.dimen.ds20)));
        }
        this.f15532i.f(this.f15528e, TbadkCoreApplication.getInst().getSkinType());
        this.f15532i.setVisibility(0);
        this.f15532i.bringToFront();
    }

    public final void x() {
        this.r = false;
        this.f15531h.setNextPage(this.k);
        this.k.f();
        this.k.A(this.f15528e.getResources().getString(R.string.list_no_more));
    }
}
