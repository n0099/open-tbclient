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
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tieba.homepage.framework.x;
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
    private int aLv;
    private BdUniqueId aTm;
    private int akC;
    private TextView bZm;
    private PbListView bjZ;
    private com.baidu.tbadk.g.f cqy;
    private String crc;
    private String crd;
    private boolean cre;
    private com.baidu.tieba.homepage.framework.d crf;
    public com.baidu.tieba.homepage.framework.b.a csC;
    private ad ctG;
    private m ctc;
    private int ctu;
    private BdTypeListView cvM;
    private com.baidu.tieba.homepage.recommendfrs.a cvN;
    private boolean cvO;
    private boolean cvP;
    private boolean cvQ;
    private long cvR;
    private com.baidu.tieba.homepage.framework.b cvS;
    private TagInfo cvT;
    private com.baidu.tieba.homepage.recommendfrs.data.a cvU;
    private boolean cvV;
    private int cvW;
    private boolean cvX;
    private CustomMessageListener cvY;
    private int cvZ;
    private x cwa;
    private boolean mHasMore;
    private w mPullView;
    private TbPageContext<?> pageContext;

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener) {
        this.csC = aVar;
        if (this.cvM != null) {
            this.cvM.setOnTouchListener(onTouchListener);
        }
    }

    public void XC() {
        if (this.csC != null) {
            this.csC.ey(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            jD(i2);
        }
    }

    private void jD(int i) {
        this.cvW = i;
        if (this.bZm != null) {
            ViewGroup.LayoutParams layoutParams = this.bZm.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.bZm.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.cvV = false;
        this.ctc = null;
        this.aLv = 0;
        this.cvX = false;
        this.cvY = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.crc = "recommendFrsViewLastReadTabPositionNamespace";
        this.crd = "recommendFrsViewLastReadTabPositionKey";
        this.ctu = 0;
        this.cre = false;
        this.cvZ = -1;
        this.cwa = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> s = l.s(context);
        if (s instanceof TbPageContext) {
            this.pageContext = (TbPageContext) s;
        }
        f(context, LayoutInflater.from(context).inflate(u.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.cvN = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.cvM.setAdapter((ListAdapter) this.cvN);
        this.akC = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aTm = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cvY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvY);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cvS = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.crf = dVar;
    }

    public void ahM() {
        com.baidu.tieba.homepage.framework.a.agL().c(System.currentTimeMillis(), getLogType());
        this.cvR = System.currentTimeMillis();
        if (this.cvT != null && !StringUtils.isNull(this.cvT.tag_name)) {
            TiebaStatic.log(new ay("kantie_1").ab("obj_name", this.cvT.tag_name));
        }
        if (this.cvP && this.cvU != null && this.cvU.aif() != null && this.cvU.aif().size() > 0) {
            if (this.cvU.getDataType() == 1) {
                this.cvN.notifyDataSetChanged();
            } else {
                this.ctG.notifyDataSetChanged();
            }
        } else if (this.cvO && !k.fH()) {
            if (this.cvN.Eb() <= 0) {
                this.cvN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akC), NoDataViewFactory.d.cQ(u.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.cvN.notifyDataSetChanged();
            }
        } else {
            if (this.cvV) {
                this.cvV = false;
                com.baidu.adp.lib.h.h.dL().postDelayed(new e(this), 200L);
            } else {
                ahU();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cvR) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahU() {
        a((View) this, false, getResources().getDimensionPixelSize(u.e.ds520));
        ahV();
    }

    private void f(Context context, View view) {
        this.cvM = (BdTypeListView) view.findViewById(u.g.listview);
        this.mPullView = new w(this.pageContext);
        this.cvM.setPullRefresh(this.mPullView);
        this.bjZ = new PbListView(context);
        this.bjZ.jp();
        this.bjZ.setTextColor(av.getColor(u.d.cp_cont_d));
        this.bjZ.cT(TbadkCoreApplication.m10getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.cvM.setOnSrollToBottomListener(this);
        this.cvM.setOnScrollListener(this);
        this.bZm = new TextView(context);
        jD(this.cvW);
        this.cvM.f(this.bZm, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cvM != null) {
            this.cvM.l(2000L);
        }
        if (this.bjZ != null) {
            this.bjZ.vi();
        }
        if (aVar == null) {
            jE(1);
            au(this);
            this.cvN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akC), NoDataViewFactory.d.cQ(u.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cvN.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.agL().d(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cvU = aVar;
        this.cvQ = false;
        this.cvP = aVar.aic();
        this.cvO = aVar.aib();
        this.cvT = aVar.aid();
        setHasMore(aVar.hasMore());
        List<Object> aif = aVar.aif();
        if (this.cvN != null) {
            if (aif == null || aif.size() <= 0) {
                if (!z2) {
                    jE(1);
                }
                if (this.cvO && this.cvP) {
                    this.cvN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akC), NoDataViewFactory.d.cQ(u.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.cvN.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.cvN.A(aif);
                this.cvN.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    jE(aVar.getDataType());
                }
                this.cvN.A(aif);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.ctG == null) {
                    this.ctG = new ad(getContext(), this.cvM);
                    this.ctG.setPageUniqueId(this.aTm);
                    if (aVar.getDataType() == 2) {
                        this.ctG.eG(false);
                    } else if (aVar.getDataType() == 3) {
                        this.ctG.eG(true);
                    }
                    ahX();
                } else if (!z2) {
                    jE(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : aif) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.ctG.bt(arrayList);
            }
            if (this.cvT != null && !StringUtils.isNull(this.cvT.tag_name) && y.s(aif) > 0) {
                TiebaStatic.log(new ay("kantie_1").ab("obj_name", this.cvT.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.agL().d(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.cvM.setSelection(aVar.aia());
        }
        if (this.cvP) {
            au(this);
        }
        if (!z) {
            ahY();
        }
        if (aVar.aid().tag_type.intValue() == 3 && this.cvZ != -1 && !this.cvX) {
            this.cvX = true;
            if (this.cvZ <= this.cvM.getCount() - 1) {
                this.cvM.setSelection(this.cvZ);
            }
        }
    }

    public void eH(boolean z) {
        if (this.cvM != null) {
            XC();
            if (!z || this.cvU == null || this.cvU.aif() == null || this.cvU.aif().size() <= 0) {
                this.cvM.setSelection(0);
                this.cvM.jA();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.cvM != null && this.bjZ != null) {
            if (this.bjZ.getView().getParent() == null) {
                this.cvM.setNextPage(this.bjZ);
            }
            if (this.mHasMore) {
                this.bjZ.vl();
                this.bjZ.cU(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds110));
                return;
            }
            this.bjZ.cV(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahV() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.agL().jl(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.agL().f(System.currentTimeMillis(), logType);
        }
        if (this.cvO) {
            this.cvS.a(1, this.cvT.tag_code.longValue(), 0L, "");
        } else {
            this.cvS.be(this.cvT.tag_code.longValue());
        }
    }

    public void V(String str, int i) {
        int i2 = 0;
        if (this.cvM != null) {
            this.cvM.l(2000L);
        }
        this.cvQ = false;
        this.bjZ.vi();
        if (this.cvU != null && this.cvU.aif() != null) {
            i2 = this.cvU.aif().size();
        }
        if (i2 <= 0 && (this.cvO || i == -53)) {
            jE(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m10getInst().getString(u.j.neterror);
            }
            this.cvN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.akC), NoDataViewFactory.d.dS(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cvN.A(new ArrayList());
        }
        au(this);
        ahY();
    }

    private void g(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void ki(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source("index");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cj("from_frs").bs(18003).oa()));
            TiebaStatic.log("c10258");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.csC != null) {
            this.csC.a(absListView, this.aLv, i, i2, i3);
        }
        this.aLv = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        if (this.mHasMore && k.fH() && !this.cvQ) {
            this.cvQ = true;
            this.bjZ.vh();
            if (this.cvS != null) {
                if (this.cvU == null || this.cvU.getDataType() == 1) {
                    if (this.cvN == null) {
                        this.cvS.a(1, this.cvT.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e ahT = this.cvN.ahT();
                    if (ahT != null) {
                        this.cvS.a(this.cvU != null ? this.cvU.getPn() + 1 : 1, this.cvT.tag_code.longValue(), ahT.aih(), "");
                    }
                } else if (this.cvU.getDataType() == 2) {
                    int pn = this.cvU.getPn() + 1;
                    ahW();
                    this.cvS.a(pn, this.cvT.tag_code.longValue(), this.cvU.ahs(), "");
                } else if (this.cvU.getDataType() == 3) {
                    this.cvS.a(this.cvU.getPn() + 1, this.cvT.tag_code.longValue(), 0L, this.cvU.aie());
                }
            }
        }
    }

    private void ahW() {
        if (this.cvU != null && this.cvU.getDataType() == 2 && this.cvU.aif() != null && this.cvU.aif().size() >= TbadkCoreApplication.m10getInst().getListItemRule().wE() - 30) {
            int wF = TbadkCoreApplication.m10getInst().getListItemRule().wF();
            if (wF < 0) {
                wF = 0;
            }
            ArrayList arrayList = new ArrayList(this.cvU.aif());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= wF && i < wF + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= wF + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cvU.bx(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.ctG.bt(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.j.a.a(this.pageContext, this);
        av.e(this, u.d.cp_bg_line_d, i);
        if (this.cvU == null || this.cvU.getDataType() == 1) {
            if (this.cvN != null) {
                this.cvN.a(this.pageContext, i);
            }
        } else if ((this.cvU.getDataType() == 2 || this.cvU.getDataType() == 3) && this.ctG != null) {
            this.ctG.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.bjZ != null) {
            this.bjZ.setTextColor(av.getColor(u.d.cp_cont_d));
            this.bjZ.cT(i);
        }
    }

    public boolean bn(long j) {
        return this.cvT != null && j == this.cvT.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.crf != null && this.cvT != null) {
            this.crf.g(this.cvT.tag_code.longValue(), this.cvM.getFirstVisiblePosition());
        }
        if (this.csC != null) {
            this.csC.onScrollStateChanged(absListView, i);
        }
        if (this.ctc == null) {
            this.ctc = new m();
            this.ctc.eQ(1005);
        }
        this.ctc.pageType = getLogType();
        this.ctc.EC();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Dr();
        com.baidu.tbadk.mvc.b.a Ds = bVar.Ds();
        if (this.cvU == null || this.cvU.getDataType() == 1) {
            if (Ds instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) Ds;
                int i = 0;
                while (true) {
                    if (i < this.cvN.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.cvN.getItem(i);
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
                if (eVar.ail() != null && !eVar.ail().isEmpty()) {
                    str = eVar.ail().get(0);
                }
                if (eVar.aim() == 33) {
                    b(eVar.ain());
                } else if (eVar.aio() == 1) {
                    g(eVar.aik(), str);
                    TiebaStatic.log(new ay("kantie_card").ab("obj_name", eVar.cvj).s("obj_type", 1).s("obj_locate", i).ab("obj_source", eVar.cwq).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.aio() == 3) {
                    ki(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new ay("kantie_card").ab("obj_name", eVar.cvj).s("obj_type", 2).s("obj_locate", i).ab("obj_source", eVar.cwq).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.qu(String.valueOf(eVar.getThreadId()));
                    this.cvN.D(Ds);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kN() {
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
        public void aH(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.cvS != null) {
                b.this.ahV();
                if (com.baidu.tieba.homepage.framework.a.a.ahm().csr == com.baidu.tieba.homepage.framework.a.a.ahm().csp) {
                    com.baidu.tieba.homepage.framework.a.a.ahm().csq = 0;
                    com.baidu.tieba.homepage.framework.a.d.ju(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cqy == null) {
            if (i < 0) {
                this.cqy = new com.baidu.tbadk.g.f(getContext());
            } else {
                this.cqy = new com.baidu.tbadk.g.f(getContext(), i);
            }
            this.cqy.sd();
        }
        this.cqy.c(view, z);
        if (this.mPullView != null) {
            this.mPullView.S(false);
        }
        if (this.cvN != null) {
            jE(1);
            this.cvN.bO(false);
            this.cvN.notifyDataSetChanged();
        }
    }

    private void au(View view) {
        if (this.cqy != null) {
            this.cqy.K(view);
            this.cqy = null;
        }
        if (this.mPullView != null) {
            this.mPullView.S(true);
        }
        if (this.cvN != null) {
            this.cvN.bO(true);
            this.cvN.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.ctc != null) {
            this.ctc.onDestroy();
        }
    }

    public void onPause() {
        if (this.cvT != null && this.cvT.tag_type.intValue() == 3) {
            jp(this.ctu);
        }
    }

    public void ahN() {
    }

    private void jE(int i) {
        if (i == 1) {
            if ((this.cvM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cvM.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.cvM.setAdapter((ListAdapter) this.cvN);
                ahX();
            }
        } else if ((i == 2 || i == 3) && (this.cvM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cvM.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            this.cvM.a((com.baidu.adp.widget.ListView.a<v, y.a>) null);
            ahX();
        }
    }

    private void ahX() {
        this.cvM.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new w(this.pageContext);
        this.cvM.setPullRefresh(this.mPullView);
        this.cvM.removeHeaderView(this.bZm);
        this.bZm = new TextView(this.pageContext.getPageActivity());
        jD(this.cvW);
        this.cvM.f(this.bZm, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aTm);
    }

    private void ahY() {
        int logType = getLogType();
        long jl = com.baidu.tieba.homepage.framework.a.agL().jl(logType);
        if (jl > 0) {
            com.baidu.tieba.homepage.framework.a.agL().e(System.currentTimeMillis() - jl, logType);
            com.baidu.tieba.homepage.framework.a.agL().f(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cvT == null) {
            return 2;
        }
        return this.cvT.tag_type.intValue();
    }

    public void jz() {
        if (this.cvM != null) {
            this.cvM.jz();
        }
    }

    public void ahZ() {
        this.cvM.setOnScrollListener(new g(this));
    }

    public void jp(int i) {
        com.baidu.tbadk.util.u.a(new h(this, i), null);
    }

    public void ahJ() {
        b(this.cwa);
    }

    public void b(x xVar) {
        if (!this.cre) {
            this.cre = true;
            com.baidu.tbadk.util.u.a(new i(this), new j(this, xVar));
        }
    }
}
