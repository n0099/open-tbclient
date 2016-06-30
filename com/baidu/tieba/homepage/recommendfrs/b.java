package com.baidu.tieba.homepage.recommendfrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.g.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tieba.homepage.personalize.a.ad;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private int aKC;
    private BdUniqueId aSq;
    private int ajN;
    private boolean bBE;
    private TextView bXl;
    private PbListView biC;
    private com.baidu.tieba.homepage.framework.d coP;
    private f cok;
    public com.baidu.tieba.homepage.framework.b.a cpX;
    private ad cqW;
    private m cqx;
    private BdTypeListView ctb;
    private com.baidu.tieba.homepage.recommendfrs.a ctc;
    private boolean ctd;
    private boolean cte;
    private long ctf;
    private com.baidu.tieba.homepage.framework.b ctg;
    private TagInfo cth;
    private com.baidu.tieba.homepage.recommendfrs.data.a cti;
    private boolean ctj;
    private int ctk;
    private CustomMessageListener ctl;
    private boolean mHasMore;
    private w mPullView;
    private TbPageContext<?> pageContext;

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener) {
        this.cpX = aVar;
        if (this.ctb != null) {
            this.ctb.setOnTouchListener(onTouchListener);
        }
    }

    public void Xk() {
        if (this.cpX != null) {
            this.cpX.ex(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            jx(i2);
        }
    }

    private void jx(int i) {
        this.ctk = i;
        if (this.bXl != null) {
            ViewGroup.LayoutParams layoutParams = this.bXl.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.bXl.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.ctj = false;
        this.cqx = null;
        this.aKC = 0;
        this.ctl = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        init(context);
    }

    private void init(Context context) {
        h<?> s = l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        e(context, LayoutInflater.from(context).inflate(u.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.ctc = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.ctb.setAdapter((ListAdapter) this.ctc);
        this.ajN = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSq = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.ctl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ctl);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.ctg = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.coP = dVar;
    }

    public void ahe() {
        com.baidu.tieba.homepage.framework.a.agi().b(System.currentTimeMillis(), getLogType());
        this.ctf = System.currentTimeMillis();
        if (this.cth != null && !StringUtils.isNull(this.cth.tag_name)) {
            TiebaStatic.log(new ay("kantie_1").ab("obj_name", this.cth.tag_name));
        }
        if (this.cte && this.cti != null && this.cti.ahv() != null && this.cti.ahv().size() > 0) {
            if (this.cti.getDataType() == 1) {
                this.ctc.notifyDataSetChanged();
            } else {
                this.cqW.notifyDataSetChanged();
            }
        } else if (this.ctd && !k.fI()) {
            if (this.ctc.Ec() <= 0) {
                this.ctc.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajN), NoDataViewFactory.d.cQ(u.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.ctc.notifyDataSetChanged();
            }
        } else {
            if (this.ctj) {
                this.ctj = false;
                com.baidu.adp.lib.h.h.dM().postDelayed(new d(this), 200L);
            } else {
                ahl();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.ctf) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahl() {
        a((View) this, false, getResources().getDimensionPixelSize(u.e.ds520));
        ahm();
    }

    private void e(Context context, View view) {
        this.ctb = (BdTypeListView) view.findViewById(u.g.listview);
        this.mPullView = new w(this.pageContext);
        this.ctb.setPullRefresh(this.mPullView);
        this.biC = new PbListView(context);
        this.biC.jq();
        this.biC.setTextColor(av.getColor(u.d.cp_cont_d));
        this.biC.cT(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new e(this));
        this.ctb.setOnSrollToBottomListener(this);
        this.ctb.setOnScrollListener(this);
        this.bXl = new TextView(context);
        jx(this.ctk);
        this.ctb.f(this.bXl, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ctb != null) {
            this.ctb.k(2000L);
        }
        if (this.biC != null) {
            this.biC.vi();
        }
        if (aVar == null) {
            jy(1);
            aw(this);
            this.ctc.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajN), NoDataViewFactory.d.cQ(u.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.ctc.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.agi().c(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cti = aVar;
        this.bBE = false;
        this.cte = aVar.ahs();
        this.ctd = aVar.ahr();
        this.cth = aVar.aht();
        setHasMore(aVar.hasMore());
        List<Object> ahv = aVar.ahv();
        if (this.ctc != null) {
            if (ahv == null || ahv.size() <= 0) {
                if (!z2) {
                    jy(1);
                }
                if (this.ctd && this.cte) {
                    this.ctc.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajN), NoDataViewFactory.d.cQ(u.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.ctc.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.ctc.A((List) ahv);
                this.ctc.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    jy(aVar.getDataType());
                }
                this.ctc.A((List) ahv);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cqW == null) {
                    this.cqW = new ad(getContext(), this.ctb);
                    this.cqW.setPageUniqueId(this.aSq);
                    if (aVar.getDataType() == 2) {
                        this.cqW.eF(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cqW.eF(true);
                    }
                    aho();
                } else if (!z2) {
                    jy(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : ahv) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cqW.bp(arrayList);
            }
            if (this.cth != null && !StringUtils.isNull(this.cth.tag_name) && y.s(ahv) > 0) {
                TiebaStatic.log(new ay("kantie_1").ab("obj_name", this.cth.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.agi().c(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.ctb.setSelection(aVar.ahq());
        }
        if (this.cte || (ahv != null && !ahv.isEmpty())) {
            aw(this);
        }
        if (!z) {
            ahp();
        }
    }

    public void eG(boolean z) {
        if (this.ctb != null) {
            Xk();
            if (!z || this.cti == null || this.cti.ahv() == null || this.cti.ahv().size() <= 0) {
                this.ctb.setSelection(0);
                this.ctb.jB();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.ctb != null && this.biC != null) {
            if (this.biC.getView().getParent() == null) {
                this.ctb.setNextPage(this.biC);
            }
            if (this.mHasMore) {
                this.biC.vl();
                this.biC.cU(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds110));
                return;
            }
            this.biC.cV(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahm() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.agi().jk(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.agi().e(System.currentTimeMillis(), logType);
        }
        if (this.ctd) {
            this.ctg.a(1, this.cth.tag_code.longValue(), 0L, "");
        } else {
            this.ctg.bj(this.cth.tag_code.longValue());
        }
    }

    public void V(String str, int i) {
        int i2 = 0;
        if (this.ctb != null) {
            this.ctb.k(2000L);
        }
        this.bBE = false;
        this.biC.vi();
        if (this.cti != null && this.cti.ahv() != null) {
            i2 = this.cti.ahv().size();
        }
        if (i2 <= 0 && (this.ctd || i == -53)) {
            jy(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(u.j.neterror);
            }
            this.ctc.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.ajN), NoDataViewFactory.d.dT(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.ctc.A((List) new ArrayList());
        }
        aw(this);
        ahp();
    }

    private void g(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void kb(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source("index");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ci("from_frs").bp(18003).ol()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cpX != null) {
            this.cpX.a(absListView, this.aKC, i, i2, i3);
        }
        this.aKC = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        if (this.mHasMore && k.fI() && !this.bBE) {
            this.bBE = true;
            this.biC.vh();
            if (this.ctg != null) {
                if (this.cti == null || this.cti.getDataType() == 1) {
                    if (this.ctc == null) {
                        this.ctg.a(1, this.cth.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e ahk = this.ctc.ahk();
                    if (ahk != null) {
                        this.ctg.a(this.cti != null ? this.cti.getPn() + 1 : 1, this.cth.tag_code.longValue(), ahk.ahx(), "");
                    }
                } else if (this.cti.getDataType() == 2) {
                    int pn = this.cti.getPn() + 1;
                    ahn();
                    this.ctg.a(pn, this.cth.tag_code.longValue(), this.cti.agM(), "");
                } else if (this.cti.getDataType() == 3) {
                    this.ctg.a(this.cti.getPn() + 1, this.cth.tag_code.longValue(), 0L, this.cti.ahu());
                }
            }
        }
    }

    private void ahn() {
        if (this.cti != null && this.cti.getDataType() == 2 && this.cti.ahv() != null && this.cti.ahv().size() >= TbadkCoreApplication.m9getInst().getListItemRule().wE() - 30) {
            int wF = TbadkCoreApplication.m9getInst().getListItemRule().wF();
            if (wF < 0) {
                wF = 0;
            }
            ArrayList arrayList = new ArrayList(this.cti.ahv());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= wF && i < wF + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= wF + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cti.bt(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cqW.bp(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.j.a.a(this.pageContext, this);
        av.e(this, u.d.cp_bg_line_d, i);
        if (this.cti == null || this.cti.getDataType() == 1) {
            if (this.ctc != null) {
                this.ctc.a(this.pageContext, i);
            }
        } else if ((this.cti.getDataType() == 2 || this.cti.getDataType() == 3) && this.cqW != null) {
            this.cqW.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.biC != null) {
            this.biC.setTextColor(av.getColor(u.d.cp_cont_d));
            this.biC.cT(i);
        }
    }

    public boolean bs(long j) {
        return this.cth != null && j == this.cth.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.coP != null && this.cth != null) {
            this.coP.f(this.cth.tag_code.longValue(), this.ctb.getFirstVisiblePosition());
        }
        if (this.cpX != null) {
            this.cpX.onScrollStateChanged(absListView, i);
        }
        if (this.cqx == null) {
            this.cqx = new m();
            this.cqx.eQ(1005);
        }
        this.cqx.pageType = getLogType();
        this.cqx.ED();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Ds();
        com.baidu.tbadk.mvc.b.a Dt = bVar.Dt();
        if (this.cti == null || this.cti.getDataType() == 1) {
            if (Dt instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) Dt;
                int i = 0;
                while (true) {
                    if (i < this.ctc.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.ctc.getItem(i);
                        if (eVar2 != null && eVar2.getThreadId() == eVar.getThreadId()) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                String str = null;
                if (eVar.ahB() != null && !eVar.ahB().isEmpty()) {
                    str = eVar.ahB().get(0);
                }
                if (eVar.ahC() == 33) {
                    b(eVar.ahD());
                } else if (eVar.ahE() == 1) {
                    g(eVar.ahA(), str);
                    TiebaStatic.log(new ay("kantie_card").ab("obj_name", eVar.csz).s("obj_type", 1).s("obj_locate", i).ab("obj_source", eVar.ctB).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.ahE() == 3) {
                    kb(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new ay("kantie_card").ab("obj_name", eVar.csz).s("obj_type", 2).s("obj_locate", i).ab("obj_source", eVar.ctB).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.pL(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.pK(String.valueOf(eVar.getThreadId()));
                    this.ctc.A((com.baidu.tieba.homepage.recommendfrs.a) Dt);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kR() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements t.b {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.t.b
        public void aE(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.ctg != null) {
                b.this.ahm();
                if (com.baidu.tieba.homepage.framework.a.a.agG().cpM == com.baidu.tieba.homepage.framework.a.a.agG().cpK) {
                    com.baidu.tieba.homepage.framework.a.a.agG().cpL = 0;
                    com.baidu.tieba.homepage.framework.a.d.jp(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cok == null) {
            if (i < 0) {
                this.cok = new f(getContext());
            } else {
                this.cok = new f(getContext(), i);
            }
            this.cok.se();
        }
        this.cok.c(view, z);
        if (this.mPullView != null) {
            this.mPullView.Q(false);
        }
        if (this.ctc != null) {
            jy(1);
            this.ctc.bL(false);
            this.ctc.notifyDataSetChanged();
        }
    }

    private void aw(View view) {
        if (this.cok != null) {
            this.cok.K(view);
            this.cok = null;
        }
        if (this.mPullView != null) {
            this.mPullView.Q(true);
        }
        if (this.ctc != null) {
            this.ctc.bL(true);
            this.ctc.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cqx != null) {
            this.cqx.onDestroy();
        }
    }

    public void ahf() {
    }

    private void jy(int i) {
        if (i == 1) {
            if ((this.ctb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.ctb.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.ctb.setAdapter((ListAdapter) this.ctc);
                aho();
            }
        } else if ((i == 2 || i == 3) && (this.ctb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.ctb.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            this.ctb.a((com.baidu.adp.widget.ListView.a<v, y.a>) null);
            aho();
        }
    }

    private void aho() {
        this.ctb.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new w(this.pageContext);
        this.ctb.setPullRefresh(this.mPullView);
        this.ctb.removeHeaderView(this.bXl);
        this.bXl = new TextView(this.pageContext.getPageActivity());
        jx(this.ctk);
        this.ctb.f(this.bXl, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aSq);
    }

    private void ahp() {
        int logType = getLogType();
        long jk = com.baidu.tieba.homepage.framework.a.agi().jk(logType);
        if (jk > 0) {
            com.baidu.tieba.homepage.framework.a.agi().d(System.currentTimeMillis() - jk, logType);
            com.baidu.tieba.homepage.framework.a.agi().e(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cth == null) {
            return 2;
        }
        return this.cth.tag_type.intValue();
    }

    public void jA() {
        if (this.ctb != null) {
            this.ctb.jA();
        }
    }
}
