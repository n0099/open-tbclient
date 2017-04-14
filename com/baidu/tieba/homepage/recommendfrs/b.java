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
import com.baidu.adp.base.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.j.m;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.homepage.framework.x;
import com.baidu.tieba.homepage.personalize.b.ad;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private PbListView aRM;
    private int asC;
    private int bHf;
    private BdUniqueId baI;
    private boolean byf;
    private TextView cfi;
    private com.baidu.tbadk.i.f ctQ;
    private boolean cuA;
    private com.baidu.tieba.homepage.framework.d cuB;
    private String cuy;
    private String cuz;
    public com.baidu.tieba.homepage.framework.b.a cvX;
    private ad cwQ;
    private int cxC;
    private m cxn;
    private BdTypeListView czC;
    private com.baidu.tieba.homepage.recommendfrs.a czD;
    private boolean czE;
    private boolean czF;
    private long czG;
    private com.baidu.tieba.homepage.framework.b czH;
    private TagInfo czI;
    private com.baidu.tieba.homepage.recommendfrs.data.a czJ;
    private boolean czK;
    private int czL;
    private boolean czM;
    private CustomMessageListener czN;
    private boolean czO;
    private int czP;
    private x czQ;
    private boolean mHasMore;
    private boolean mIsBackground;
    private ae mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.czC != null && eVar != null) {
            this.cvX = eVar.aiV();
            this.czC.setOnTouchListener(eVar.aiW());
        }
    }

    public void Xj() {
        if (this.cvX != null) {
            this.cvX.eQ(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            jV(i2);
        }
    }

    private void jV(int i) {
        this.czL = i;
        if (this.cfi != null) {
            ViewGroup.LayoutParams layoutParams = this.cfi.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.cfi.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.czK = false;
        this.cxn = null;
        this.bHf = 0;
        this.czM = false;
        this.mIsBackground = false;
        this.czN = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cuy = "recommendFrsViewLastReadTabPositionNamespace";
        this.cuz = "recommendFrsViewLastReadTabPositionKey";
        this.cxC = 0;
        this.czO = false;
        this.cuA = false;
        this.czP = -1;
        this.czQ = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.g<?> Z = k.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        d(context, LayoutInflater.from(context).inflate(w.j.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.czD = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.czC.setAdapter((ListAdapter) this.czD);
        this.asC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.baI = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.czN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.czN);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.czH = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cuB = dVar;
    }

    public void ajg() {
        com.baidu.tieba.homepage.framework.a.ait().c(System.currentTimeMillis(), getLogType());
        this.czG = System.currentTimeMillis();
        if (this.czI != null && !StringUtils.isNull(this.czI.tag_name)) {
            TiebaStatic.log(new as("kantie_1").aa("obj_name", this.czI.tag_name));
        }
        if (this.czF && this.czJ != null && this.czJ.ajP() != null && this.czJ.ajP().size() > 0) {
            if (this.czJ.getDataType() == 1) {
                this.czD.notifyDataSetChanged();
            } else {
                this.cwQ.notifyDataSetChanged();
            }
            if (this.czI != null && this.czI.tag_type.intValue() == 7) {
                int i = com.baidu.tbadk.ala.a.nZ().getInt("recommend_refresh", 60);
                if (System.currentTimeMillis() - com.baidu.tbadk.ala.a.nZ().getLong("recommend_auto_update_get_server_data_time", System.currentTimeMillis()) > (i >= 60 ? i : 60) * 1000) {
                    eZ(false);
                }
            }
        } else if (this.czE && !com.baidu.adp.lib.util.k.hA()) {
            if (this.czD.FQ() <= 0) {
                this.czD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asC), NoDataViewFactory.d.dh(w.l.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.czD.notifyDataSetChanged();
            }
        } else {
            if (this.czK) {
                this.czK = false;
                com.baidu.adp.lib.g.h.fR().postDelayed(new e(this), 200L);
            } else {
                ajF();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.czG) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajF() {
        a((View) this, false, getResources().getDimensionPixelSize(w.f.ds520));
        ajG();
    }

    private void d(Context context, View view) {
        this.czC = (BdTypeListView) view.findViewById(w.h.listview);
        this.mPullView = new ae(this.pageContext);
        this.czC.setPullRefresh(this.mPullView);
        this.aRM = new PbListView(context);
        this.aRM.le();
        this.aRM.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRM.dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.czC.setOnSrollToBottomListener(this);
        this.czC.setOnScrollListener(this);
        this.cfi = new TextView(context);
        jV(this.czL);
        this.czC.addHeaderView(this.cfi, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.czC != null) {
            this.czC.completePullRefreshPostDelayed(2000L);
        }
        if (this.aRM != null) {
            this.aRM.xe();
        }
        if (aVar == null) {
            jW(1);
            au(this);
            this.czD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asC), NoDataViewFactory.d.dh(w.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.czD.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.ait().d(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.czJ = aVar;
        this.byf = false;
        this.czF = aVar.ajM();
        this.czE = aVar.ajL();
        this.czI = aVar.ajN();
        setHasMore(aVar.hasMore());
        List<Object> ajP = aVar.ajP();
        if (this.czD != null) {
            if (ajP == null || ajP.size() <= 0) {
                if (!z2) {
                    jW(1);
                }
                if (this.czE && this.czF) {
                    this.czD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asC), NoDataViewFactory.d.dh(w.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.czD.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.czD.w(ajP);
                this.czD.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    jW(aVar.getDataType());
                }
                this.czD.w(ajP);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cwQ == null) {
                    this.cwQ = new ad(getContext(), this.czC);
                    this.cwQ.setPageUniqueId(this.baI);
                    if (aVar.getDataType() == 2) {
                        this.cwQ.eY(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cwQ.eY(true);
                    }
                    ajI();
                } else if (!z2) {
                    jW(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : ajP) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cwQ.bc(arrayList);
            }
            if (this.czI != null && !StringUtils.isNull(this.czI.tag_name) && com.baidu.tbadk.core.util.x.p(ajP) > 0) {
                TiebaStatic.log(new as("kantie_1").aa("obj_name", this.czI.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.ait().d(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.czC.setSelection(aVar.ajK());
        }
        if (this.czF) {
            au(this);
        }
        if (!z) {
            ajJ();
        }
        if (aVar.ajN().tag_type.intValue() == 3 && this.czP != -1 && !this.czM) {
            this.czM = true;
            if (this.czP <= this.czC.getCount() - 1) {
                this.czC.setSelection(this.czP);
            }
        }
    }

    public void eZ(boolean z) {
        if (this.czC != null) {
            Xj();
            if (!z || this.czJ == null || this.czJ.ajP() == null || this.czJ.ajP().size() <= 0) {
                this.czC.setSelection(0);
                this.czC.startPullRefresh();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.czC != null && this.aRM != null) {
            if (this.aRM.getView().getParent() == null) {
                this.czC.setNextPage(this.aRM);
            }
            if (this.mHasMore) {
                this.aRM.xi();
                this.aRM.dl(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds110));
                return;
            }
            this.aRM.dm(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajG() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.ait().jE(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.ait().f(System.currentTimeMillis(), logType);
        }
        if (this.czE) {
            this.czH.a(1, this.czI.tag_code.longValue(), 0L, "");
        } else {
            this.czH.bi(this.czI.tag_code.longValue());
        }
    }

    public void M(String str, int i) {
        int i2 = 0;
        if (this.czC != null) {
            this.czC.completePullRefreshPostDelayed(2000L);
        }
        this.byf = false;
        this.aRM.xe();
        if (this.czJ != null && this.czJ.ajP() != null) {
            i2 = this.czJ.ajP().size();
        }
        if (i2 <= 0 && (this.czE || i == -53)) {
            jW(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
            }
            this.czD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asC), NoDataViewFactory.d.dV(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.czD.w(new ArrayList());
        }
        au(this);
        ajJ();
    }

    private void g(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void jI(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ck("from_frs").bC(18003).pE()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.czO = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.hA() && !this.byf) {
            this.byf = true;
            this.aRM.xd();
            if (this.czH != null) {
                if (this.czJ == null || this.czJ.getDataType() == 1) {
                    if (this.czD == null) {
                        this.czH.a(1, this.czI.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e ajE = this.czD.ajE();
                    if (ajE != null) {
                        this.czH.a(this.czJ != null ? this.czJ.getPn() + 1 : 1, this.czI.tag_code.longValue(), ajE.ajS(), "");
                    }
                } else if (this.czJ.getDataType() == 2) {
                    int pn = this.czJ.getPn() + 1;
                    ajH();
                    this.czH.a(pn, this.czI.tag_code.longValue(), this.czJ.ajc(), "");
                } else if (this.czJ.getDataType() == 3) {
                    this.czH.a(this.czJ.getPn() + 1, this.czI.tag_code.longValue(), 0L, this.czJ.ajO());
                }
            }
        }
    }

    private void ajH() {
        if (this.czJ != null && this.czJ.getDataType() == 2 && this.czJ.ajP() != null && this.czJ.ajP().size() >= TbadkCoreApplication.m9getInst().getListItemRule().yB() - 30) {
            int yC = TbadkCoreApplication.m9getInst().getListItemRule().yC();
            if (yC < 0) {
                yC = 0;
            }
            ArrayList arrayList = new ArrayList(this.czJ.ajP());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= yC && i < yC + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= yC + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.czJ.bg(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cwQ.bc(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.m.a.a(this.pageContext, this);
        aq.e(this, w.e.cp_bg_line_d, i);
        if (this.czJ == null || this.czJ.getDataType() == 1) {
            if (this.czD != null) {
                this.czD.b(this.pageContext, i);
            }
        } else if ((this.czJ.getDataType() == 2 || this.czJ.getDataType() == 3) && this.cwQ != null) {
            this.cwQ.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.aRM != null) {
            this.aRM.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aRM.dk(i);
        }
    }

    public boolean br(long j) {
        return this.czI != null && j == this.czI.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cvX != null && !this.mIsBackground) {
            this.cvX.a(absListView, this.bHf, i, i2, i3);
        }
        this.bHf = i;
        if (this.czI.tag_type.intValue() == 3 && this.czO) {
            this.cxC = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cuB != null && this.czI != null) {
            this.cuB.g(this.czI.tag_code.longValue(), this.czC.getFirstVisiblePosition());
        }
        if (this.cvX != null && !this.mIsBackground) {
            this.cvX.onScrollStateChanged(absListView, i);
        }
        if (this.cxn == null) {
            this.cxn = new m();
            this.cxn.fe(1005);
        }
        this.cxn.pageType = getLogType();
        this.cxn.Gn();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Fl();
        com.baidu.tbadk.mvc.b.a Fm = bVar.Fm();
        if (this.czJ == null || this.czJ.getDataType() == 1) {
            if (Fm instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) Fm;
                int i = 0;
                while (true) {
                    if (i < this.czD.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.czD.getItem(i);
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
                if (eVar.ajW() != null && !eVar.ajW().isEmpty()) {
                    str = eVar.ajW().get(0);
                }
                if (eVar.ajX() == 33) {
                    a(eVar.ajY());
                } else if (eVar.ajZ() == 1) {
                    g(eVar.ajV(), str);
                    TiebaStatic.log(new as("kantie_card").aa("obj_name", eVar.Uu).s("obj_type", 1).s("obj_locate", i).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cAh).s("obj_param1", 1).aa("abtest", eVar.abtest));
                } else if (eVar.ajZ() == 3) {
                    jI(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new as("kantie_card").aa("obj_name", eVar.Uu).s("obj_type", 2).s("obj_locate", i).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cAh).s("obj_param1", 1).aa("abtest", eVar.abtest));
                }
                r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.qo(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.qn(String.valueOf(eVar.getThreadId()));
                    this.czD.D(Fm);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements ab.b {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.ab.b
        public void aN(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.czH != null) {
                b.this.ajG();
                if (com.baidu.tieba.homepage.framework.a.a.aiU().cvN == com.baidu.tieba.homepage.framework.a.a.aiU().cvL) {
                    com.baidu.tieba.homepage.framework.a.a.aiU().cvM = 0;
                    com.baidu.tieba.homepage.framework.a.d.jN(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.ctQ == null) {
            if (i < 0) {
                this.ctQ = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.ctQ = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.ctQ.onChangeSkinType();
        }
        this.ctQ.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.V(false);
        }
        if (this.czD != null) {
            jW(1);
            this.czD.bU(false);
            this.czD.notifyDataSetChanged();
        }
    }

    private void au(View view) {
        if (this.ctQ != null) {
            this.ctQ.I(view);
            this.ctQ = null;
        }
        if (this.mPullView != null) {
            this.mPullView.V(true);
        }
        if (this.czD != null) {
            this.czD.bU(true);
            this.czD.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cxn != null) {
            this.cxn.onDestroy();
        }
    }

    public void onPause() {
        if (this.czI != null && this.czI.tag_type.intValue() == 3) {
            jI(this.cxC);
        }
    }

    public void ajh() {
    }

    private void jW(int i) {
        if (i == 1) {
            if ((this.czC.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.czC.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.czC.setAdapter((ListAdapter) this.czD);
                ajI();
            }
        } else if ((i == 2 || i == 3) && (this.czC.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.czC.getAdapter()).getWrappedAdapter() instanceof y)) {
            this.czC.addAdapter(null);
            ajI();
        }
    }

    private void ajI() {
        this.czC.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new ae(this.pageContext);
        this.czC.setPullRefresh(this.mPullView);
        this.czC.removeHeaderView(this.cfi);
        this.cfi = new TextView(this.pageContext.getPageActivity());
        jV(this.czL);
        this.czC.addHeaderView(this.cfi, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.baI);
    }

    private void ajJ() {
        int logType = getLogType();
        long jE = com.baidu.tieba.homepage.framework.a.ait().jE(logType);
        if (jE > 0) {
            com.baidu.tieba.homepage.framework.a.ait().e(System.currentTimeMillis() - jE, logType);
            com.baidu.tieba.homepage.framework.a.ait().f(0L, logType);
        }
    }

    private int getLogType() {
        if (this.czI == null) {
            return 2;
        }
        return this.czI.tag_type.intValue();
    }

    public void completePullRefresh() {
        if (this.czC != null) {
            this.czC.completePullRefresh();
        }
    }

    public void jI(int i) {
        t.a(new g(this, i), null);
    }

    public void ajx() {
        b(this.czQ);
    }

    public void b(x xVar) {
        if (!this.cuA) {
            this.cuA = true;
            t.a(new h(this), new i(this, xVar));
        }
    }
}
