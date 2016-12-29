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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ac;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.homepage.framework.x;
import com.baidu.tieba.homepage.personalize.b.ab;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private PbListView aMJ;
    private int aSJ;
    private int anK;
    private TextView bVl;
    private BdUniqueId bbl;
    private com.baidu.tbadk.f.f cmR;
    private com.baidu.tieba.homepage.framework.d cnA;
    private String cnx;
    private String cny;
    private boolean cnz;
    public com.baidu.tieba.homepage.framework.b.a coW;
    private ab cpS;
    private int cqE;
    private m cqo;
    private boolean cqs;
    private BdTypeListView csC;
    private com.baidu.tieba.homepage.recommendfrs.a csD;
    private boolean csE;
    private boolean csF;
    private boolean csG;
    private long csH;
    private com.baidu.tieba.homepage.framework.b csI;
    private TagInfo csJ;
    private com.baidu.tieba.homepage.recommendfrs.data.a csK;
    private boolean csL;
    private int csM;
    private boolean csN;
    private CustomMessageListener csO;
    private boolean csP;
    private int csQ;
    private x csR;
    private boolean mHasMore;
    private ac mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.cqs = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.csC != null && eVar != null) {
            this.coW = eVar.aiH();
            this.csC.setOnTouchListener(eVar.aiI());
        }
    }

    public void Us() {
        if (this.coW != null) {
            this.coW.eV(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            jD(i2);
        }
    }

    private void jD(int i) {
        this.csM = i;
        if (this.bVl != null) {
            ViewGroup.LayoutParams layoutParams = this.bVl.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.bVl.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.csL = false;
        this.cqo = null;
        this.aSJ = 0;
        this.csN = false;
        this.cqs = false;
        this.csO = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cnx = "recommendFrsViewLastReadTabPositionNamespace";
        this.cny = "recommendFrsViewLastReadTabPositionKey";
        this.cqE = 0;
        this.csP = false;
        this.cnz = false;
        this.csQ = -1;
        this.csR = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        d(context, LayoutInflater.from(context).inflate(r.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.csD = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.csC.setAdapter((ListAdapter) this.csD);
        this.anK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bbl = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.csO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.csO);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.csI = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cnA = dVar;
    }

    public void aiT() {
        com.baidu.tieba.homepage.framework.a.aif().c(System.currentTimeMillis(), getLogType());
        this.csH = System.currentTimeMillis();
        if (this.csJ != null && !StringUtils.isNull(this.csJ.tag_name)) {
            TiebaStatic.log(new at("kantie_1").ab("obj_name", this.csJ.tag_name));
        }
        if (this.csF && this.csK != null && this.csK.ajC() != null && this.csK.ajC().size() > 0) {
            if (this.csK.getDataType() == 1) {
                this.csD.notifyDataSetChanged();
            } else {
                this.cpS.notifyDataSetChanged();
            }
        } else if (this.csE && !k.gD()) {
            if (this.csD.EZ() <= 0) {
                this.csD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anK), NoDataViewFactory.d.dh(r.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.csD.notifyDataSetChanged();
            }
        } else {
            if (this.csL) {
                this.csL = false;
                com.baidu.adp.lib.h.h.eG().postDelayed(new e(this), 200L);
            } else {
                ajs();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.csH) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        a((View) this, false, getResources().getDimensionPixelSize(r.e.ds520));
        ajt();
    }

    private void d(Context context, View view) {
        this.csC = (BdTypeListView) view.findViewById(r.g.listview);
        this.mPullView = new ac(this.pageContext);
        this.csC.setPullRefresh(this.mPullView);
        this.aMJ = new PbListView(context);
        this.aMJ.kk();
        this.aMJ.setTextColor(ar.getColor(r.d.cp_cont_d));
        this.aMJ.dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.csC.setOnSrollToBottomListener(this);
        this.csC.setOnScrollListener(this);
        this.bVl = new TextView(context);
        jD(this.csM);
        this.csC.f(this.bVl, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.csC != null) {
            this.csC.l(2000L);
        }
        if (this.aMJ != null) {
            this.aMJ.wq();
        }
        if (aVar == null) {
            jE(1);
            at(this);
            this.csD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anK), NoDataViewFactory.d.dh(r.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.csD.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.aif().d(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.csK = aVar;
        this.csG = false;
        this.csF = aVar.ajz();
        this.csE = aVar.ajy();
        this.csJ = aVar.ajA();
        setHasMore(aVar.hasMore());
        List<Object> ajC = aVar.ajC();
        if (this.csD != null) {
            if (ajC == null || ajC.size() <= 0) {
                if (!z2) {
                    jE(1);
                }
                if (this.csE && this.csF) {
                    this.csD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anK), NoDataViewFactory.d.dh(r.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.csD.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.csD.A(ajC);
                this.csD.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    jE(aVar.getDataType());
                }
                this.csD.A(ajC);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cpS == null) {
                    this.cpS = new ab(getContext(), this.csC);
                    this.cpS.setPageUniqueId(this.bbl);
                    if (aVar.getDataType() == 2) {
                        this.cpS.fd(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cpS.fd(true);
                    }
                    ajv();
                } else if (!z2) {
                    jE(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : ajC) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cpS.bq(arrayList);
            }
            if (this.csJ != null && !StringUtils.isNull(this.csJ.tag_name) && com.baidu.tbadk.core.util.x.s(ajC) > 0) {
                TiebaStatic.log(new at("kantie_1").ab("obj_name", this.csJ.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.aif().d(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.csC.setSelection(aVar.ajx());
        }
        if (this.csF) {
            at(this);
        }
        if (!z) {
            ajw();
        }
        if (aVar.ajA().tag_type.intValue() == 3 && this.csQ != -1 && !this.csN) {
            this.csN = true;
            if (this.csQ <= this.csC.getCount() - 1) {
                this.csC.setSelection(this.csQ);
            }
        }
    }

    public void fe(boolean z) {
        if (this.csC != null) {
            Us();
            if (!z || this.csK == null || this.csK.ajC() == null || this.csK.ajC().size() <= 0) {
                this.csC.setSelection(0);
                this.csC.kv();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.csC != null && this.aMJ != null) {
            if (this.aMJ.getView().getParent() == null) {
                this.csC.setNextPage(this.aMJ);
            }
            if (this.mHasMore) {
                this.aMJ.wu();
                this.aMJ.dl(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds110));
                return;
            }
            this.aMJ.dm(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajt() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.aif().jl(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.aif().f(System.currentTimeMillis(), logType);
        }
        if (this.csE) {
            this.csI.a(1, this.csJ.tag_code.longValue(), 0L, "");
        } else {
            this.csI.bn(this.csJ.tag_code.longValue());
        }
    }

    public void T(String str, int i) {
        int i2 = 0;
        if (this.csC != null) {
            this.csC.l(2000L);
        }
        this.csG = false;
        this.aMJ.wq();
        if (this.csK != null && this.csK.ajC() != null) {
            i2 = this.csK.ajC().size();
        }
        if (i2 <= 0 && (this.csE || i == -53)) {
            jE(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(r.j.neterror);
            }
            this.csD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anK), NoDataViewFactory.d.dX(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.csD.A(new ArrayList());
        }
        at(this);
        ajw();
    }

    private void j(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void jN(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cm("from_frs").bG(18003).oZ()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.csP = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.mHasMore && k.gD() && !this.csG) {
            this.csG = true;
            this.aMJ.wp();
            if (this.csI != null) {
                if (this.csK == null || this.csK.getDataType() == 1) {
                    if (this.csD == null) {
                        this.csI.a(1, this.csJ.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e ajr = this.csD.ajr();
                    if (ajr != null) {
                        this.csI.a(this.csK != null ? this.csK.getPn() + 1 : 1, this.csJ.tag_code.longValue(), ajr.ajF(), "");
                    }
                } else if (this.csK.getDataType() == 2) {
                    int pn = this.csK.getPn() + 1;
                    aju();
                    this.csI.a(pn, this.csJ.tag_code.longValue(), this.csK.aiP(), "");
                } else if (this.csK.getDataType() == 3) {
                    this.csI.a(this.csK.getPn() + 1, this.csJ.tag_code.longValue(), 0L, this.csK.ajB());
                }
            }
        }
    }

    private void aju() {
        if (this.csK != null && this.csK.getDataType() == 2 && this.csK.ajC() != null && this.csK.ajC().size() >= TbadkCoreApplication.m9getInst().getListItemRule().xL() - 30) {
            int xM = TbadkCoreApplication.m9getInst().getListItemRule().xM();
            if (xM < 0) {
                xM = 0;
            }
            ArrayList arrayList = new ArrayList(this.csK.ajC());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= xM && i < xM + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= xM + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.csK.bu(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cpS.bq(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        ar.e(this, r.d.cp_bg_line_d, i);
        if (this.csK == null || this.csK.getDataType() == 1) {
            if (this.csD != null) {
                this.csD.a(this.pageContext, i);
            }
        } else if ((this.csK.getDataType() == 2 || this.csK.getDataType() == 3) && this.cpS != null) {
            this.cpS.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.aMJ != null) {
            this.aMJ.setTextColor(ar.getColor(r.d.cp_cont_d));
            this.aMJ.dk(i);
        }
    }

    public boolean bw(long j) {
        return this.csJ != null && j == this.csJ.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.coW != null && !this.cqs) {
            this.coW.a(absListView, this.aSJ, i, i2, i3);
        }
        this.aSJ = i;
        if (this.csJ.tag_type.intValue() == 3 && this.csP) {
            this.cqE = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cnA != null && this.csJ != null) {
            this.cnA.g(this.csJ.tag_code.longValue(), this.csC.getFirstVisiblePosition());
        }
        if (this.coW != null && !this.cqs) {
            this.coW.onScrollStateChanged(absListView, i);
        }
        if (this.cqo == null) {
            this.cqo = new m();
            this.cqo.fg(1005);
        }
        this.cqo.pageType = getLogType();
        this.cqo.FB();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Ey();
        com.baidu.tbadk.mvc.b.a Ez = bVar.Ez();
        if (this.csK == null || this.csK.getDataType() == 1) {
            if (Ez instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) Ez;
                int i = 0;
                while (true) {
                    if (i < this.csD.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.csD.getItem(i);
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
                if (eVar.ajJ() != null && !eVar.ajJ().isEmpty()) {
                    str = eVar.ajJ().get(0);
                }
                if (eVar.ajK() == 33) {
                    b(eVar.ajL());
                } else if (eVar.ajM() == 1) {
                    j(eVar.ajI(), str);
                    TiebaStatic.log(new at("kantie_card").ab("obj_name", eVar.PR).s("obj_type", 1).s("obj_locate", i).ab("obj_source", eVar.cti).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.ajM() == 3) {
                    jN(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new at("kantie_card").ab("obj_name", eVar.PR).s("obj_type", 2).s("obj_locate", i).ab("obj_source", eVar.cti).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.qu(String.valueOf(eVar.getThreadId()));
                    this.csD.D(Ez);
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
        public void aM(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.csI != null) {
                b.this.ajt();
                if (com.baidu.tieba.homepage.framework.a.a.aiG().coM == com.baidu.tieba.homepage.framework.a.a.aiG().coK) {
                    com.baidu.tieba.homepage.framework.a.a.aiG().coL = 0;
                    com.baidu.tieba.homepage.framework.a.d.ju(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cmR == null) {
            if (i < 0) {
                this.cmR = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cmR = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cmR.tm();
        }
        this.cmR.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.csD != null) {
            jE(1);
            this.csD.bS(false);
            this.csD.notifyDataSetChanged();
        }
    }

    private void at(View view) {
        if (this.cmR != null) {
            this.cmR.M(view);
            this.cmR = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.csD != null) {
            this.csD.bS(true);
            this.csD.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cqo != null) {
            this.cqo.onDestroy();
        }
    }

    public void onPause() {
        if (this.csJ != null && this.csJ.tag_type.intValue() == 3) {
            jp(this.cqE);
        }
    }

    public void aiU() {
    }

    private void jE(int i) {
        if (i == 1) {
            if ((this.csC.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.csC.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.csC.setAdapter((ListAdapter) this.csD);
                ajv();
            }
        } else if ((i == 2 || i == 3) && (this.csC.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.csC.getAdapter()).getWrappedAdapter() instanceof y)) {
            this.csC.a((com.baidu.adp.widget.ListView.a<v, y.a>) null);
            ajv();
        }
    }

    private void ajv() {
        this.csC.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new ac(this.pageContext);
        this.csC.setPullRefresh(this.mPullView);
        this.csC.removeHeaderView(this.bVl);
        this.bVl = new TextView(this.pageContext.getPageActivity());
        jD(this.csM);
        this.csC.f(this.bVl, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.bbl);
    }

    private void ajw() {
        int logType = getLogType();
        long jl = com.baidu.tieba.homepage.framework.a.aif().jl(logType);
        if (jl > 0) {
            com.baidu.tieba.homepage.framework.a.aif().e(System.currentTimeMillis() - jl, logType);
            com.baidu.tieba.homepage.framework.a.aif().f(0L, logType);
        }
    }

    private int getLogType() {
        if (this.csJ == null) {
            return 2;
        }
        return this.csJ.tag_type.intValue();
    }

    public void ku() {
        if (this.csC != null) {
            this.csC.ku();
        }
    }

    public void jp(int i) {
        t.a(new g(this, i), null);
    }

    public void ajk() {
        b(this.csR);
    }

    public void b(x xVar) {
        if (!this.cnz) {
            this.cnz = true;
            t.a(new h(this), new i(this, xVar));
        }
    }
}
