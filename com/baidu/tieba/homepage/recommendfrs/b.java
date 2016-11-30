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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.homepage.framework.x;
import com.baidu.tieba.homepage.personalize.b.ac;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private PbListView aNs;
    private int aTs;
    private int aoi;
    private BdUniqueId bcf;
    private com.baidu.tbadk.f.f cHx;
    private String cIc;
    private String cId;
    private boolean cIe;
    private com.baidu.tieba.homepage.framework.d cIf;
    public com.baidu.tieba.homepage.framework.b.a cJB;
    private m cKT;
    private boolean cKX;
    private ac cKx;
    private int cLj;
    private boolean cNA;
    private boolean cNB;
    private long cNC;
    private com.baidu.tieba.homepage.framework.b cND;
    private TagInfo cNE;
    private com.baidu.tieba.homepage.recommendfrs.data.a cNF;
    private boolean cNG;
    private int cNH;
    private boolean cNI;
    private CustomMessageListener cNJ;
    private boolean cNK;
    private int cNL;
    private x cNM;
    private BdTypeListView cNx;
    private com.baidu.tieba.homepage.recommendfrs.a cNy;
    private boolean cNz;
    private TextView cqb;
    private boolean mHasMore;
    private com.baidu.tbadk.core.view.ac mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.cKX = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cNx != null && eVar != null) {
            this.cJB = eVar.aoh();
            this.cNx.setOnTouchListener(eVar.aoi());
        }
    }

    public void aaf() {
        if (this.cJB != null) {
            this.cJB.fk(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            kt(i2);
        }
    }

    private void kt(int i) {
        this.cNH = i;
        if (this.cqb != null) {
            ViewGroup.LayoutParams layoutParams = this.cqb.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.cqb.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.cNG = false;
        this.cKT = null;
        this.aTs = 0;
        this.cNI = false;
        this.cKX = false;
        this.cNJ = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cIc = "recommendFrsViewLastReadTabPositionNamespace";
        this.cId = "recommendFrsViewLastReadTabPositionKey";
        this.cLj = 0;
        this.cNK = false;
        this.cIe = false;
        this.cNL = -1;
        this.cNM = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        f(context, LayoutInflater.from(context).inflate(r.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.cNy = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.cNx.setAdapter((ListAdapter) this.cNy);
        this.aoi = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bcf = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cNJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cNJ);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cND = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cIf = dVar;
    }

    public void aot() {
        com.baidu.tieba.homepage.framework.a.anF().d(System.currentTimeMillis(), getLogType());
        this.cNC = System.currentTimeMillis();
        if (this.cNE != null && !StringUtils.isNull(this.cNE.tag_name)) {
            TiebaStatic.log(new av("kantie_1").ab("obj_name", this.cNE.tag_name));
        }
        if (this.cNA && this.cNF != null && this.cNF.apb() != null && this.cNF.apb().size() > 0) {
            if (this.cNF.getDataType() == 1) {
                this.cNy.notifyDataSetChanged();
            } else {
                this.cKx.notifyDataSetChanged();
            }
        } else if (this.cNz && !k.gD()) {
            if (this.cNy.Fz() <= 0) {
                this.cNy.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aoi), NoDataViewFactory.d.df(r.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.cNy.notifyDataSetChanged();
            }
        } else {
            if (this.cNG) {
                this.cNG = false;
                com.baidu.adp.lib.h.h.eG().postDelayed(new e(this), 200L);
            } else {
                aoR();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cNC) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoR() {
        a((View) this, false, getResources().getDimensionPixelSize(r.e.ds520));
        aoS();
    }

    private void f(Context context, View view) {
        this.cNx = (BdTypeListView) view.findViewById(r.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.pageContext);
        this.cNx.setPullRefresh(this.mPullView);
        this.aNs = new PbListView(context);
        this.aNs.kk();
        this.aNs.setTextColor(at.getColor(r.d.cp_cont_d));
        this.aNs.di(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.cNx.setOnSrollToBottomListener(this);
        this.cNx.setOnScrollListener(this);
        this.cqb = new TextView(context);
        kt(this.cNH);
        this.cNx.f(this.cqb, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cNx != null) {
            this.cNx.l(2000L);
        }
        if (this.aNs != null) {
            this.aNs.wG();
        }
        if (aVar == null) {
            ku(1);
            at(this);
            this.cNy.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aoi), NoDataViewFactory.d.df(r.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cNy.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.anF().e(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cNF = aVar;
        this.cNB = false;
        this.cNA = aVar.aoY();
        this.cNz = aVar.aoX();
        this.cNE = aVar.aoZ();
        setHasMore(aVar.hasMore());
        List<Object> apb = aVar.apb();
        if (this.cNy != null) {
            if (apb == null || apb.size() <= 0) {
                if (!z2) {
                    ku(1);
                }
                if (this.cNz && this.cNA) {
                    this.cNy.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aoi), NoDataViewFactory.d.df(r.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.cNy.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.cNy.A(apb);
                this.cNy.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    ku(aVar.getDataType());
                }
                this.cNy.A(apb);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cKx == null) {
                    this.cKx = new ac(getContext(), this.cNx);
                    this.cKx.setPageUniqueId(this.bcf);
                    if (aVar.getDataType() == 2) {
                        this.cKx.fs(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cKx.fs(true);
                    }
                    aoU();
                } else if (!z2) {
                    ku(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : apb) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cKx.by(arrayList);
            }
            if (this.cNE != null && !StringUtils.isNull(this.cNE.tag_name) && com.baidu.tbadk.core.util.x.s(apb) > 0) {
                TiebaStatic.log(new av("kantie_1").ab("obj_name", this.cNE.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.anF().e(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.cNx.setSelection(aVar.aoW());
        }
        if (this.cNA) {
            at(this);
        }
        if (!z) {
            aoV();
        }
        if (aVar.aoZ().tag_type.intValue() == 3 && this.cNL != -1 && !this.cNI) {
            this.cNI = true;
            if (this.cNL <= this.cNx.getCount() - 1) {
                this.cNx.setSelection(this.cNL);
            }
        }
    }

    public void ft(boolean z) {
        if (this.cNx != null) {
            aaf();
            if (!z || this.cNF == null || this.cNF.apb() == null || this.cNF.apb().size() <= 0) {
                this.cNx.setSelection(0);
                this.cNx.kv();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.cNx != null && this.aNs != null) {
            if (this.aNs.getView().getParent() == null) {
                this.cNx.setNextPage(this.aNs);
            }
            if (this.mHasMore) {
                this.aNs.wK();
                this.aNs.dj(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds110));
                return;
            }
            this.aNs.dk(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoS() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.anF().ka(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.anF().g(System.currentTimeMillis(), logType);
        }
        if (this.cNz) {
            this.cND.a(1, this.cNE.tag_code.longValue(), 0L, "");
        } else {
            this.cND.bz(this.cNE.tag_code.longValue());
        }
    }

    public void V(String str, int i) {
        int i2 = 0;
        if (this.cNx != null) {
            this.cNx.l(2000L);
        }
        this.cNB = false;
        this.aNs.wG();
        if (this.cNF != null && this.cNF.apb() != null) {
            i2 = this.cNF.apb().size();
        }
        if (i2 <= 0 && (this.cNz || i == -53)) {
            ku(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(r.j.neterror);
            }
            this.cNy.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aoi), NoDataViewFactory.d.ea(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cNy.A(new ArrayList());
        }
        at(this);
        aoV();
    }

    private void j(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void lj(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cl("from_frs").bF(18003).oZ()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.cNK = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.mHasMore && k.gD() && !this.cNB) {
            this.cNB = true;
            this.aNs.wF();
            if (this.cND != null) {
                if (this.cNF == null || this.cNF.getDataType() == 1) {
                    if (this.cNy == null) {
                        this.cND.a(1, this.cNE.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e aoQ = this.cNy.aoQ();
                    if (aoQ != null) {
                        this.cND.a(this.cNF != null ? this.cNF.getPn() + 1 : 1, this.cNE.tag_code.longValue(), aoQ.apd(), "");
                    }
                } else if (this.cNF.getDataType() == 2) {
                    int pn = this.cNF.getPn() + 1;
                    aoT();
                    this.cND.a(pn, this.cNE.tag_code.longValue(), this.cNF.aop(), "");
                } else if (this.cNF.getDataType() == 3) {
                    this.cND.a(this.cNF.getPn() + 1, this.cNE.tag_code.longValue(), 0L, this.cNF.apa());
                }
            }
        }
    }

    private void aoT() {
        if (this.cNF != null && this.cNF.getDataType() == 2 && this.cNF.apb() != null && this.cNF.apb().size() >= TbadkCoreApplication.m9getInst().getListItemRule().xX() - 30) {
            int xY = TbadkCoreApplication.m9getInst().getListItemRule().xY();
            if (xY < 0) {
                xY = 0;
            }
            ArrayList arrayList = new ArrayList(this.cNF.apb());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= xY && i < xY + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= xY + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cNF.bC(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cKx.by(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        at.e(this, r.d.cp_bg_line_d, i);
        if (this.cNF == null || this.cNF.getDataType() == 1) {
            if (this.cNy != null) {
                this.cNy.a(this.pageContext, i);
            }
        } else if ((this.cNF.getDataType() == 2 || this.cNF.getDataType() == 3) && this.cKx != null) {
            this.cKx.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
        if (this.aNs != null) {
            this.aNs.setTextColor(at.getColor(r.d.cp_cont_d));
            this.aNs.di(i);
        }
    }

    public boolean bI(long j) {
        return this.cNE != null && j == this.cNE.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cJB != null && !this.cKX) {
            this.cJB.a(absListView, this.aTs, i, i2, i3);
        }
        this.aTs = i;
        if (this.cNE.tag_type.intValue() == 3 && this.cNK) {
            this.cLj = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cIf != null && this.cNE != null) {
            this.cIf.h(this.cNE.tag_code.longValue(), this.cNx.getFirstVisiblePosition());
        }
        if (this.cJB != null && !this.cKX) {
            this.cJB.onScrollStateChanged(absListView, i);
        }
        if (this.cKT == null) {
            this.cKT = new m();
            this.cKT.fg(1005);
        }
        this.cKT.pageType = getLogType();
        this.cKT.Gb();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.EQ();
        com.baidu.tbadk.mvc.b.a ER = bVar.ER();
        if (this.cNF == null || this.cNF.getDataType() == 1) {
            if (ER instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) ER;
                int i = 0;
                while (true) {
                    if (i < this.cNy.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.cNy.getItem(i);
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
                if (eVar.aph() != null && !eVar.aph().isEmpty()) {
                    str = eVar.aph().get(0);
                }
                if (eVar.api() == 33) {
                    b(eVar.apj());
                } else if (eVar.apk() == 1) {
                    j(eVar.apg(), str);
                    TiebaStatic.log(new av("kantie_card").ab("obj_name", eVar.PW).s("obj_type", 1).s("obj_locate", i).ab("obj_source", eVar.cOc).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.apk() == 3) {
                    lj(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new av("kantie_card").ab("obj_name", eVar.PW).s("obj_type", 2).s("obj_locate", i).ab("obj_source", eVar.cOc).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.rP(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.rO(String.valueOf(eVar.getThreadId()));
                    this.cNy.D(ER);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lL() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements z.b {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.z.b
        public void aL(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.cND != null) {
                b.this.aoS();
                if (com.baidu.tieba.homepage.framework.a.a.aog().cJr == com.baidu.tieba.homepage.framework.a.a.aog().cJp) {
                    com.baidu.tieba.homepage.framework.a.a.aog().cJq = 0;
                    com.baidu.tieba.homepage.framework.a.d.kj(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cHx == null) {
            if (i < 0) {
                this.cHx = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cHx = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cHx.tB();
        }
        this.cHx.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cNy != null) {
            ku(1);
            this.cNy.bT(false);
            this.cNy.notifyDataSetChanged();
        }
    }

    private void at(View view) {
        if (this.cHx != null) {
            this.cHx.M(view);
            this.cHx = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cNy != null) {
            this.cNy.bT(true);
            this.cNy.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cKT != null) {
            this.cKT.onDestroy();
        }
    }

    public void onPause() {
        if (this.cNE != null && this.cNE.tag_type.intValue() == 3) {
            ke(this.cLj);
        }
    }

    public void aou() {
    }

    private void ku(int i) {
        if (i == 1) {
            if ((this.cNx.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cNx.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.cNx.setAdapter((ListAdapter) this.cNy);
                aoU();
            }
        } else if ((i == 2 || i == 3) && (this.cNx.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cNx.getAdapter()).getWrappedAdapter() instanceof y)) {
            this.cNx.a((com.baidu.adp.widget.ListView.a<v, y.a>) null);
            aoU();
        }
    }

    private void aoU() {
        this.cNx.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.pageContext);
        this.cNx.setPullRefresh(this.mPullView);
        this.cNx.removeHeaderView(this.cqb);
        this.cqb = new TextView(this.pageContext.getPageActivity());
        kt(this.cNH);
        this.cNx.f(this.cqb, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.bcf);
    }

    private void aoV() {
        int logType = getLogType();
        long ka = com.baidu.tieba.homepage.framework.a.anF().ka(logType);
        if (ka > 0) {
            com.baidu.tieba.homepage.framework.a.anF().f(System.currentTimeMillis() - ka, logType);
            com.baidu.tieba.homepage.framework.a.anF().g(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cNE == null) {
            return 2;
        }
        return this.cNE.tag_type.intValue();
    }

    public void ku() {
        if (this.cNx != null) {
            this.cNx.ku();
        }
    }

    public void ke(int i) {
        t.a(new g(this, i), null);
    }

    public void aoK() {
        b(this.cNM);
    }

    public void b(x xVar) {
        if (!this.cIe) {
            this.cIe = true;
            t.a(new h(this), new i(this, xVar));
        }
    }
}
