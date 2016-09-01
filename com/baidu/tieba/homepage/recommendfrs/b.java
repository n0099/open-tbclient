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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.homepage.framework.x;
import com.baidu.tieba.homepage.personalize.a.ac;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private int aQi;
    private BdUniqueId aYu;
    private int anH;
    private PbListView bvo;
    private com.baidu.tbadk.g.f cBG;
    private String cCk;
    private String cCl;
    private boolean cCm;
    private com.baidu.tieba.homepage.framework.d cCn;
    public com.baidu.tieba.homepage.framework.b.a cDK;
    private m cEI;
    private int cFa;
    private ac cFl;
    private int cHA;
    private boolean cHB;
    private CustomMessageListener cHC;
    private boolean cHD;
    private int cHE;
    private x cHF;
    private BdTypeListView cHq;
    private com.baidu.tieba.homepage.recommendfrs.a cHr;
    private boolean cHs;
    private boolean cHt;
    private boolean cHu;
    private long cHv;
    private com.baidu.tieba.homepage.framework.b cHw;
    private TagInfo cHx;
    private com.baidu.tieba.homepage.recommendfrs.data.a cHy;
    private boolean cHz;
    private TextView ckw;
    private boolean mHasMore;
    private w mPullView;
    private TbPageContext<?> pageContext;

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener) {
        this.cDK = aVar;
        if (this.cHq != null) {
            this.cHq.setOnTouchListener(onTouchListener);
        }
    }

    public void YO() {
        if (this.cDK != null) {
            this.cDK.eU(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            kg(i2);
        }
    }

    private void kg(int i) {
        this.cHA = i;
        if (this.ckw != null) {
            ViewGroup.LayoutParams layoutParams = this.ckw.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.ckw.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.cHz = false;
        this.cEI = null;
        this.aQi = 0;
        this.cHB = false;
        this.cHC = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cCk = "recommendFrsViewLastReadTabPositionNamespace";
        this.cCl = "recommendFrsViewLastReadTabPositionKey";
        this.cFa = 0;
        this.cHD = false;
        this.cCm = false;
        this.cHE = -1;
        this.cHF = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.h<?> C = l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        f(context, LayoutInflater.from(context).inflate(t.h.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.cHr = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.cHq.setAdapter((ListAdapter) this.cHr);
        this.anH = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aYu = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cHC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cHC);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cHw = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cCn = dVar;
    }

    public void amB() {
        com.baidu.tieba.homepage.framework.a.alw().d(System.currentTimeMillis(), getLogType());
        this.cHv = System.currentTimeMillis();
        if (this.cHx != null && !StringUtils.isNull(this.cHx.tag_name)) {
            TiebaStatic.log(new ay("kantie_1").ab("obj_name", this.cHx.tag_name));
        }
        if (this.cHt && this.cHy != null && this.cHy.amT() != null && this.cHy.amT().size() > 0) {
            if (this.cHy.getDataType() == 1) {
                this.cHr.notifyDataSetChanged();
            } else {
                this.cFl.notifyDataSetChanged();
            }
        } else if (this.cHs && !k.gD()) {
            if (this.cHr.Fv() <= 0) {
                this.cHr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anH), NoDataViewFactory.d.de(t.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.cHr.notifyDataSetChanged();
            }
        } else {
            if (this.cHz) {
                this.cHz = false;
                com.baidu.adp.lib.h.h.eG().postDelayed(new e(this), 200L);
            } else {
                amJ();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cHv) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amJ() {
        a((View) this, false, getResources().getDimensionPixelSize(t.e.ds520));
        amK();
    }

    private void f(Context context, View view) {
        this.cHq = (BdTypeListView) view.findViewById(t.g.listview);
        this.mPullView = new w(this.pageContext);
        this.cHq.setPullRefresh(this.mPullView);
        this.bvo = new PbListView(context);
        this.bvo.kk();
        this.bvo.setTextColor(av.getColor(t.d.cp_cont_d));
        this.bvo.dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.cHq.setOnSrollToBottomListener(this);
        this.cHq.setOnScrollListener(this);
        this.ckw = new TextView(context);
        kg(this.cHA);
        this.cHq.f(this.ckw, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cHq != null) {
            this.cHq.l(2000L);
        }
        if (this.bvo != null) {
            this.bvo.wm();
        }
        if (aVar == null) {
            kh(1);
            au(this);
            this.cHr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anH), NoDataViewFactory.d.de(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cHr.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.alw().e(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cHy = aVar;
        this.cHu = false;
        this.cHt = aVar.amQ();
        this.cHs = aVar.amP();
        this.cHx = aVar.amR();
        setHasMore(aVar.hasMore());
        List<Object> amT = aVar.amT();
        if (this.cHr != null) {
            if (amT == null || amT.size() <= 0) {
                if (!z2) {
                    kh(1);
                }
                if (this.cHs && this.cHt) {
                    this.cHr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anH), NoDataViewFactory.d.de(t.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.cHr.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.cHr.A(amT);
                this.cHr.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    kh(aVar.getDataType());
                }
                this.cHr.A(amT);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cFl == null) {
                    this.cFl = new ac(getContext(), this.cHq);
                    this.cFl.setPageUniqueId(this.aYu);
                    if (aVar.getDataType() == 2) {
                        this.cFl.fc(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cFl.fc(true);
                    }
                    amM();
                } else if (!z2) {
                    kh(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : amT) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cFl.bv(arrayList);
            }
            if (this.cHx != null && !StringUtils.isNull(this.cHx.tag_name) && y.s(amT) > 0) {
                TiebaStatic.log(new ay("kantie_1").ab("obj_name", this.cHx.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.alw().e(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.cHq.setSelection(aVar.amO());
        }
        if (this.cHt) {
            au(this);
        }
        if (!z) {
            amN();
        }
        if (aVar.amR().tag_type.intValue() == 3 && this.cHE != -1 && !this.cHB) {
            this.cHB = true;
            if (this.cHE <= this.cHq.getCount() - 1) {
                this.cHq.setSelection(this.cHE);
            }
        }
    }

    public void fd(boolean z) {
        if (this.cHq != null) {
            YO();
            if (!z || this.cHy == null || this.cHy.amT() == null || this.cHy.amT().size() <= 0) {
                this.cHq.setSelection(0);
                this.cHq.kv();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.cHq != null && this.bvo != null) {
            if (this.bvo.getView().getParent() == null) {
                this.cHq.setNextPage(this.bvo);
            }
            if (this.mHasMore) {
                this.bvo.wp();
                this.bvo.di(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds110));
                return;
            }
            this.bvo.dj(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amK() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.alw().jN(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.alw().g(System.currentTimeMillis(), logType);
        }
        if (this.cHs) {
            this.cHw.a(1, this.cHx.tag_code.longValue(), 0L, "");
        } else {
            this.cHw.bA(this.cHx.tag_code.longValue());
        }
    }

    public void V(String str, int i) {
        int i2 = 0;
        if (this.cHq != null) {
            this.cHq.l(2000L);
        }
        this.cHu = false;
        this.bvo.wm();
        if (this.cHy != null && this.cHy.amT() != null) {
            i2 = this.cHy.amT().size();
        }
        if (i2 <= 0 && (this.cHs || i == -53)) {
            kh(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(t.j.neterror);
            }
            this.cHr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anH), NoDataViewFactory.d.dV(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cHr.A(new ArrayList());
        }
        au(this);
        amN();
    }

    private void j(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void kR(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ck("from_frs").bF(18003).oW()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.cHD = z;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cDK != null) {
            this.cDK.a(absListView, this.aQi, i, i2, i3);
        }
        this.aQi = i;
        if (this.cHx.tag_type.intValue() == 3 && this.cHD) {
            this.cFa = i;
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.mHasMore && k.gD() && !this.cHu) {
            this.cHu = true;
            this.bvo.wl();
            if (this.cHw != null) {
                if (this.cHy == null || this.cHy.getDataType() == 1) {
                    if (this.cHr == null) {
                        this.cHw.a(1, this.cHx.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e amI = this.cHr.amI();
                    if (amI != null) {
                        this.cHw.a(this.cHy != null ? this.cHy.getPn() + 1 : 1, this.cHx.tag_code.longValue(), amI.amV(), "");
                    }
                } else if (this.cHy.getDataType() == 2) {
                    int pn = this.cHy.getPn() + 1;
                    amL();
                    this.cHw.a(pn, this.cHx.tag_code.longValue(), this.cHy.amg(), "");
                } else if (this.cHy.getDataType() == 3) {
                    this.cHw.a(this.cHy.getPn() + 1, this.cHx.tag_code.longValue(), 0L, this.cHy.amS());
                }
            }
        }
    }

    private void amL() {
        if (this.cHy != null && this.cHy.getDataType() == 2 && this.cHy.amT() != null && this.cHy.amT().size() >= TbadkCoreApplication.m9getInst().getListItemRule().xO() - 30) {
            int xP = TbadkCoreApplication.m9getInst().getListItemRule().xP();
            if (xP < 0) {
                xP = 0;
            }
            ArrayList arrayList = new ArrayList(this.cHy.amT());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= xP && i < xP + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= xP + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cHy.bz(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cFl.bv(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.j.a.a(this.pageContext, this);
        av.e(this, t.d.cp_bg_line_d, i);
        if (this.cHy == null || this.cHy.getDataType() == 1) {
            if (this.cHr != null) {
                this.cHr.a(this.pageContext, i);
            }
        } else if ((this.cHy.getDataType() == 2 || this.cHy.getDataType() == 3) && this.cFl != null) {
            this.cFl.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.bvo != null) {
            this.bvo.setTextColor(av.getColor(t.d.cp_cont_d));
            this.bvo.dh(i);
        }
    }

    public boolean bJ(long j) {
        return this.cHx != null && j == this.cHx.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cCn != null && this.cHx != null) {
            this.cCn.h(this.cHx.tag_code.longValue(), this.cHq.getFirstVisiblePosition());
        }
        if (this.cDK != null) {
            this.cDK.onScrollStateChanged(absListView, i);
        }
        if (this.cEI == null) {
            this.cEI = new m();
            this.cEI.fe(1005);
        }
        this.cEI.pageType = getLogType();
        this.cEI.FW();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.EL();
        com.baidu.tbadk.mvc.b.a EM = bVar.EM();
        if (this.cHy == null || this.cHy.getDataType() == 1) {
            if (EM instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) EM;
                int i = 0;
                while (true) {
                    if (i < this.cHr.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.cHr.getItem(i);
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
                if (eVar.amZ() != null && !eVar.amZ().isEmpty()) {
                    str = eVar.amZ().get(0);
                }
                if (eVar.ana() == 33) {
                    b(eVar.anb());
                } else if (eVar.anc() == 1) {
                    j(eVar.amY(), str);
                    TiebaStatic.log(new ay("kantie_card").ab("obj_name", eVar.PE).s("obj_type", 1).s("obj_locate", i).ab("obj_source", eVar.cHV).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.anc() == 3) {
                    kR(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new ay("kantie_card").ab("obj_name", eVar.PE).s("obj_type", 2).s("obj_locate", i).ab("obj_source", eVar.cHV).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.rf(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.re(String.valueOf(eVar.getThreadId()));
                    this.cHr.D(EM);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lI() {
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
        public void aI(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.cHw != null) {
                b.this.amK();
                if (com.baidu.tieba.homepage.framework.a.a.alX().cDz == com.baidu.tieba.homepage.framework.a.a.alX().cDx) {
                    com.baidu.tieba.homepage.framework.a.a.alX().cDy = 0;
                    com.baidu.tieba.homepage.framework.a.d.jW(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cBG == null) {
            if (i < 0) {
                this.cBG = new com.baidu.tbadk.g.f(getContext());
            } else {
                this.cBG = new com.baidu.tbadk.g.f(getContext(), i);
            }
            this.cBG.ti();
        }
        this.cBG.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cHr != null) {
            kh(1);
            this.cHr.bQ(false);
            this.cHr.notifyDataSetChanged();
        }
    }

    private void au(View view) {
        if (this.cBG != null) {
            this.cBG.L(view);
            this.cBG = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cHr != null) {
            this.cHr.bQ(true);
            this.cHr.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cEI != null) {
            this.cEI.onDestroy();
        }
    }

    public void onPause() {
        if (this.cHx != null && this.cHx.tag_type.intValue() == 3) {
            jR(this.cFa);
        }
    }

    public void amC() {
    }

    private void kh(int i) {
        if (i == 1) {
            if ((this.cHq.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cHq.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.cHq.setAdapter((ListAdapter) this.cHr);
                amM();
            }
        } else if ((i == 2 || i == 3) && (this.cHq.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cHq.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            this.cHq.a((com.baidu.adp.widget.ListView.a<v, y.a>) null);
            amM();
        }
    }

    private void amM() {
        this.cHq.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new w(this.pageContext);
        this.cHq.setPullRefresh(this.mPullView);
        this.cHq.removeHeaderView(this.ckw);
        this.ckw = new TextView(this.pageContext.getPageActivity());
        kg(this.cHA);
        this.cHq.f(this.ckw, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aYu);
    }

    private void amN() {
        int logType = getLogType();
        long jN = com.baidu.tieba.homepage.framework.a.alw().jN(logType);
        if (jN > 0) {
            com.baidu.tieba.homepage.framework.a.alw().f(System.currentTimeMillis() - jN, logType);
            com.baidu.tieba.homepage.framework.a.alw().g(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cHx == null) {
            return 2;
        }
        return this.cHx.tag_type.intValue();
    }

    public void ku() {
        if (this.cHq != null) {
            this.cHq.ku();
        }
    }

    public void jR(int i) {
        u.a(new g(this, i), null);
    }

    public void amy() {
        b(this.cHF);
    }

    public void b(x xVar) {
        if (!this.cCm) {
            this.cCm = true;
            u.a(new h(this), new i(this, xVar));
        }
    }
}
