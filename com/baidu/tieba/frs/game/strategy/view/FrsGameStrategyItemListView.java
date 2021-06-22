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
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.n0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyItemListView extends FrameLayout implements d.a.o0.r0.s1.a.d.b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15575e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f15576f;

    /* renamed from: g  reason: collision with root package name */
    public g f15577g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f15578h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f15579i;
    public d.a.n0.d0.g j;
    public PbListView k;
    public d.a.o0.r0.s1.a.e.c l;
    public d.a.o0.r0.x1.b m;
    public d.a.o0.r0.s1.a.d.a n;
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
        public class RunnableC0179a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15581e;

            public RunnableC0179a(a aVar, String str) {
                this.f15581e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f15581e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public a() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            a2 c2;
            boolean z;
            d.a.o0.r0.s1.a.d.e a2;
            if (nVar == null || !(nVar instanceof d.a.o0.r0.s1.a.a.b) || (c2 = ((d.a.o0.r0.s1.a.a.b) nVar).c()) == null) {
                return;
            }
            if (FrsGameStrategyItemListView.this.n != null && (a2 = FrsGameStrategyItemListView.this.n.a(FrsGameStrategyItemListView.this.p)) != null) {
                Object obj = a2.f63450c;
                if (obj instanceof LabelDataList) {
                    String labelName = ((LabelDataList) obj).getLabelName(FrsGameStrategyItemListView.this.q);
                    if (labelName == null) {
                        labelName = "";
                    }
                    TiebaStatic.log(new StatisticItem("c12388").param("fid", FrsGameStrategyItemListView.this.n.i()).param("tid", c2.o0()).param("obj_id", a2.f63449b).param("obj_locate", labelName));
                }
            }
            if (c2.O() == null || c2.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsGameStrategyItemListView.this.f15575e.getPageActivity())) {
                if (c2.G() != 1 || ViewHelper.checkUpIsLogin(FrsGameStrategyItemListView.this.f15575e.getPageActivity())) {
                    d.a.o0.e3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(c2.o0())) {
                        readThreadHistory.a(c2.o0());
                        FrsGameStrategyItemListView.this.l.b();
                    }
                    String J = c2.J();
                    if (J == null || J.equals("")) {
                        z = false;
                    } else {
                        new Thread(new RunnableC0179a(this, J)).start();
                        z = true;
                    }
                    String z1 = c2.z1();
                    if (z1 == null) {
                        z1 = "";
                    }
                    if (c2.y0() == 2 && !z1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(FrsGameStrategyItemListView.this.f15575e, new String[]{z1, "", null});
                        return;
                    }
                    if (z1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        c2.I3(z1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsGameStrategyItemListView.this.f15575e.getPageActivity()).createFromThreadCfg(c2, null, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(c2.c0()));
                    createFromThreadCfg.setStartFrom(3);
                    FrsGameStrategyItemListView.this.f15575e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.n0.r.f0.f.g
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
        this.f15575e = (TbPageContext) j.a(context);
        this.f15576f = bdUniqueId;
        n();
    }

    @Override // d.a.o0.r0.s1.a.d.b
    public void a(int i2, int i3, List<n> list, List<d.a.o0.r0.s1.a.d.e> list2, boolean z, boolean z2, int i4) {
        if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
            l();
            this.f15578h.z();
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

    @Override // d.a.o0.r0.s1.a.d.b
    public void b(int i2, int i3, String str) {
        if ((i2 == 0 && i3 == 0) || (i2 == this.p && i3 == this.q)) {
            this.r = false;
            l();
            if (ListUtils.isEmpty(this.o)) {
                w(str);
                k();
                return;
            }
            this.f15575e.showToast(str);
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
        this.f15578h.setNextPage(null);
    }

    public final void l() {
        d.a.n0.d0.g gVar = this.j;
        if (gVar != null) {
            gVar.dettachView(this);
        }
    }

    public final void m() {
        NoDataView noDataView = this.f15579i;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void n() {
        BdTypeListView bdTypeListView = new BdTypeListView(getContext());
        this.f15578h = bdTypeListView;
        bdTypeListView.setDivider(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0204)));
        this.f15578h.setDividerHeight(getContext().getResources().getDimensionPixelSize(R.dimen.ds1));
        this.f15578h.setCacheColorHint(getContext().getResources().getColor(17170445));
        this.f15578h.setFadingEdgeLength(0);
        this.f15578h.setSelector(getContext().getResources().getDrawable(R.drawable.list_selector_transparent));
        this.f15578h.setOnSrollToBottomListener(new c());
        this.f15578h.setOnTouchListener(new d());
        addView(this.f15578h);
        d.a.o0.r0.s1.a.e.c cVar = new d.a.o0.r0.s1.a.e.c(this.f15575e, this.f15578h);
        this.l = cVar;
        cVar.c(this.s);
        g gVar = new g(this.f15575e);
        this.f15577g = gVar;
        gVar.Z(this.f15576f);
        this.f15577g.a(this.t);
        this.m = new d.a.o0.r0.x1.b(this.f15575e.getPageActivity(), this.f15576f, true);
        this.f15578h.setPullRefresh(this.f15577g);
        if (this.k == null) {
            PbListView pbListView = new PbListView(this.f15575e.getPageActivity());
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
        SkinManager.setBackgroundColor(this.f15578h, R.color.CAM_X0204);
        g gVar = this.f15577g;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoDataView noDataView = this.f15579i;
        if (noDataView != null) {
            noDataView.f(this.f15575e, i2);
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
        this.f15578h.F();
    }

    public void setFrsGameTabDataLoadListener(d.a.o0.r0.s1.a.d.a aVar) {
        this.n = aVar;
    }

    public final void t() {
        m();
        d.a.o0.r0.s1.a.d.a aVar = this.n;
        if (aVar != null) {
            aVar.b(this.p, this.q);
        }
    }

    public final void u() {
        this.r = true;
        this.f15578h.setNextPage(this.k);
        this.k.O();
    }

    public final void v() {
        if (this.j == null) {
            d.a.n0.d0.g gVar = new d.a.n0.d0.g(getContext(), getContext().getResources().getDimensionPixelSize(R.dimen.ds120));
            this.j = gVar;
            gVar.onChangeSkinType();
        }
        this.j.attachView(this, false);
    }

    public final void w(String str) {
        if (this.f15579i == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds120);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds360);
            this.f15579i = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_08, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.c(str), NoDataViewFactory.c.b(new NoDataViewFactory.b(getContext().getString(R.string.refresh_view_button_text), new e()), getResources().getDimensionPixelSize(R.dimen.ds20)));
        }
        this.f15579i.f(this.f15575e, TbadkCoreApplication.getInst().getSkinType());
        this.f15579i.setVisibility(0);
        this.f15579i.bringToFront();
    }

    public final void x() {
        this.r = false;
        this.f15578h.setNextPage(this.k);
        this.k.f();
        this.k.A(this.f15575e.getResources().getString(R.string.list_no_more));
    }
}
