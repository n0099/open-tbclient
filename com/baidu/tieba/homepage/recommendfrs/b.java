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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.homepage.framework.x;
import com.baidu.tieba.homepage.personalize.b.ad;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private PbListView aLK;
    private BdUniqueId aUC;
    private int amR;
    private int bAg;
    private boolean brm;
    private TextView cbJ;
    private com.baidu.tbadk.f.f ctR;
    private String cuA;
    private boolean cuB;
    private com.baidu.tieba.homepage.framework.d cuC;
    private String cuz;
    public com.baidu.tieba.homepage.framework.b.a cvY;
    private ad cwR;
    private int cxF;
    private m cxo;
    private BdTypeListView czH;
    private com.baidu.tieba.homepage.recommendfrs.a czI;
    private boolean czJ;
    private boolean czK;
    private long czL;
    private com.baidu.tieba.homepage.framework.b czM;
    private TagInfo czN;
    private com.baidu.tieba.homepage.recommendfrs.data.a czO;
    private boolean czP;
    private int czQ;
    private boolean czR;
    private CustomMessageListener czS;
    private boolean czT;
    private int czU;
    private x czV;
    private boolean mHasMore;
    private boolean mIsBackground;
    private com.baidu.tbadk.core.view.ad mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.czH != null && eVar != null) {
            this.cvY = eVar.ajP();
            this.czH.setOnTouchListener(eVar.ajQ());
        }
    }

    public void VN() {
        if (this.cvY != null) {
            this.cvY.eZ(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            kq(i2);
        }
    }

    private void kq(int i) {
        this.czQ = i;
        if (this.cbJ != null) {
            ViewGroup.LayoutParams layoutParams = this.cbJ.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.cbJ.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.czP = false;
        this.cxo = null;
        this.bAg = 0;
        this.czR = false;
        this.mIsBackground = false;
        this.czS = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cuz = "recommendFrsViewLastReadTabPositionNamespace";
        this.cuA = "recommendFrsViewLastReadTabPositionKey";
        this.cxF = 0;
        this.czT = false;
        this.cuB = false;
        this.czU = -1;
        this.czV = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.g<?> C = k.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        d(context, LayoutInflater.from(context).inflate(r.j.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.czI = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.czH.setAdapter((ListAdapter) this.czI);
        this.amR = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aUC = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.czS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.czS);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.czM = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cuC = dVar;
    }

    public void aka() {
        com.baidu.tieba.homepage.framework.a.ajm().c(System.currentTimeMillis(), getLogType());
        this.czL = System.currentTimeMillis();
        if (this.czN != null && !StringUtils.isNull(this.czN.tag_name)) {
            TiebaStatic.log(new ar("kantie_1").ab("obj_name", this.czN.tag_name));
        }
        if (this.czK && this.czO != null && this.czO.akJ() != null && this.czO.akJ().size() > 0) {
            if (this.czO.getDataType() == 1) {
                this.czI.notifyDataSetChanged();
            } else {
                this.cwR.notifyDataSetChanged();
            }
            if (this.czN != null && this.czN.tag_type.intValue() == 7) {
                int i = com.baidu.tbadk.ala.a.no().getInt("recommend_refresh", 60);
                if (System.currentTimeMillis() - com.baidu.tbadk.ala.a.no().getLong("recommend_auto_update_get_server_data_time", System.currentTimeMillis()) > (i >= 60 ? i : 60) * 1000) {
                    fi(false);
                }
            }
        } else if (this.czJ && !com.baidu.adp.lib.util.k.gB()) {
            if (this.czI.ET() <= 0) {
                this.czI.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amR), NoDataViewFactory.d.di(r.l.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.czI.notifyDataSetChanged();
            }
        } else {
            if (this.czP) {
                this.czP = false;
                com.baidu.adp.lib.g.h.eE().postDelayed(new e(this), 200L);
            } else {
                akz();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.czL) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        a((View) this, false, getResources().getDimensionPixelSize(r.f.ds520));
        akA();
    }

    private void d(Context context, View view) {
        this.czH = (BdTypeListView) view.findViewById(r.h.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.pageContext);
        this.czH.setPullRefresh(this.mPullView);
        this.aLK = new PbListView(context);
        this.aLK.kg();
        this.aLK.setTextColor(ap.getColor(r.e.cp_cont_d));
        this.aLK.dl(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.czH.setOnSrollToBottomListener(this);
        this.czH.setOnScrollListener(this);
        this.cbJ = new TextView(context);
        kq(this.czQ);
        this.czH.addHeaderView(this.cbJ, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.czH != null) {
            this.czH.completePullRefreshPostDelayed(2000L);
        }
        if (this.aLK != null) {
            this.aLK.wl();
        }
        if (aVar == null) {
            kr(1);
            ay(this);
            this.czI.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amR), NoDataViewFactory.d.di(r.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.czI.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.ajm().d(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.czO = aVar;
        this.brm = false;
        this.czK = aVar.akG();
        this.czJ = aVar.akF();
        this.czN = aVar.akH();
        setHasMore(aVar.hasMore());
        List<Object> akJ = aVar.akJ();
        if (this.czI != null) {
            if (akJ == null || akJ.size() <= 0) {
                if (!z2) {
                    kr(1);
                }
                if (this.czJ && this.czK) {
                    this.czI.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amR), NoDataViewFactory.d.di(r.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.czI.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.czI.y(akJ);
                this.czI.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    kr(aVar.getDataType());
                }
                this.czI.y(akJ);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cwR == null) {
                    this.cwR = new ad(getContext(), this.czH);
                    this.cwR.setPageUniqueId(this.aUC);
                    if (aVar.getDataType() == 2) {
                        this.cwR.fh(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cwR.fh(true);
                    }
                    akC();
                } else if (!z2) {
                    kr(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : akJ) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cwR.bw(arrayList);
            }
            if (this.czN != null && !StringUtils.isNull(this.czN.tag_name) && w.r(akJ) > 0) {
                TiebaStatic.log(new ar("kantie_1").ab("obj_name", this.czN.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.ajm().d(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.czH.setSelection(aVar.akE());
        }
        if (this.czK) {
            ay(this);
        }
        if (!z) {
            akD();
        }
        if (aVar.akH().tag_type.intValue() == 3 && this.czU != -1 && !this.czR) {
            this.czR = true;
            if (this.czU <= this.czH.getCount() - 1) {
                this.czH.setSelection(this.czU);
            }
        }
    }

    public void fi(boolean z) {
        if (this.czH != null) {
            VN();
            if (!z || this.czO == null || this.czO.akJ() == null || this.czO.akJ().size() <= 0) {
                this.czH.setSelection(0);
                this.czH.startPullRefresh();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.czH != null && this.aLK != null) {
            if (this.aLK.getView().getParent() == null) {
                this.czH.setNextPage(this.aLK);
            }
            if (this.mHasMore) {
                this.aLK.wp();
                this.aLK.dm(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds110));
                return;
            }
            this.aLK.dn(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.ajm().jY(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.ajm().f(System.currentTimeMillis(), logType);
        }
        if (this.czJ) {
            this.czM.a(1, this.czN.tag_code.longValue(), 0L, "");
        } else {
            this.czM.bi(this.czN.tag_code.longValue());
        }
    }

    public void T(String str, int i) {
        int i2 = 0;
        if (this.czH != null) {
            this.czH.completePullRefreshPostDelayed(2000L);
        }
        this.brm = false;
        this.aLK.wl();
        if (this.czO != null && this.czO.akJ() != null) {
            i2 = this.czO.akJ().size();
        }
        if (i2 <= 0 && (this.czJ || i == -53)) {
            kr(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(r.l.neterror);
            }
            this.czI.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.amR), NoDataViewFactory.d.dV(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.czI.y(new ArrayList());
        }
        ay(this);
        akD();
    }

    private void g(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void kb(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ck("from_frs").bF(18003).oS()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.czT = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kp() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.gB() && !this.brm) {
            this.brm = true;
            this.aLK.wk();
            if (this.czM != null) {
                if (this.czO == null || this.czO.getDataType() == 1) {
                    if (this.czI == null) {
                        this.czM.a(1, this.czN.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e aky = this.czI.aky();
                    if (aky != null) {
                        this.czM.a(this.czO != null ? this.czO.getPn() + 1 : 1, this.czN.tag_code.longValue(), aky.akM(), "");
                    }
                } else if (this.czO.getDataType() == 2) {
                    int pn = this.czO.getPn() + 1;
                    akB();
                    this.czM.a(pn, this.czN.tag_code.longValue(), this.czO.ajW(), "");
                } else if (this.czO.getDataType() == 3) {
                    this.czM.a(this.czO.getPn() + 1, this.czN.tag_code.longValue(), 0L, this.czO.akI());
                }
            }
        }
    }

    private void akB() {
        if (this.czO != null && this.czO.getDataType() == 2 && this.czO.akJ() != null && this.czO.akJ().size() >= TbadkCoreApplication.m9getInst().getListItemRule().xH() - 30) {
            int xI = TbadkCoreApplication.m9getInst().getListItemRule().xI();
            if (xI < 0) {
                xI = 0;
            }
            ArrayList arrayList = new ArrayList(this.czO.akJ());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= xI && i < xI + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= xI + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.czO.bA(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cwR.bw(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        ap.e(this, r.e.cp_bg_line_d, i);
        if (this.czO == null || this.czO.getDataType() == 1) {
            if (this.czI != null) {
                this.czI.a(this.pageContext, i);
            }
        } else if ((this.czO.getDataType() == 2 || this.czO.getDataType() == 3) && this.cwR != null) {
            this.cwR.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        if (this.aLK != null) {
            this.aLK.setTextColor(ap.getColor(r.e.cp_cont_d));
            this.aLK.dl(i);
        }
    }

    public boolean br(long j) {
        return this.czN != null && j == this.czN.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cvY != null && !this.mIsBackground) {
            this.cvY.a(absListView, this.bAg, i, i2, i3);
        }
        this.bAg = i;
        if (this.czN.tag_type.intValue() == 3 && this.czT) {
            this.cxF = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cuC != null && this.czN != null) {
            this.cuC.g(this.czN.tag_code.longValue(), this.czH.getFirstVisiblePosition());
        }
        if (this.cvY != null && !this.mIsBackground) {
            this.cvY.onScrollStateChanged(absListView, i);
        }
        if (this.cxo == null) {
            this.cxo = new m();
            this.cxo.fh(1005);
        }
        this.cxo.pageType = getLogType();
        this.cxo.Fv();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Es();
        com.baidu.tbadk.mvc.b.a Et = bVar.Et();
        if (this.czO == null || this.czO.getDataType() == 1) {
            if (Et instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) Et;
                int i = 0;
                while (true) {
                    if (i < this.czI.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.czI.getItem(i);
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
                if (eVar.akQ() != null && !eVar.akQ().isEmpty()) {
                    str = eVar.akQ().get(0);
                }
                if (eVar.akR() == 33) {
                    b(eVar.akS());
                } else if (eVar.akT() == 1) {
                    g(eVar.akP(), str);
                    TiebaStatic.log(new ar("kantie_card").ab("obj_name", eVar.OZ).s("obj_type", 1).s("obj_locate", i).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cAm).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.akT() == 3) {
                    kb(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new ar("kantie_card").ab("obj_name", eVar.OZ).s("obj_type", 2).s("obj_locate", i).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cAm).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.qP(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.qO(String.valueOf(eVar.getThreadId()));
                    this.czI.D(Et);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lD() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements aa.b {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.aa.b
        public void aM(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.czM != null) {
                b.this.akA();
                if (com.baidu.tieba.homepage.framework.a.a.ajO().cvO == com.baidu.tieba.homepage.framework.a.a.ajO().cvM) {
                    com.baidu.tieba.homepage.framework.a.a.ajO().cvN = 0;
                    com.baidu.tieba.homepage.framework.a.d.kh(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.ctR == null) {
            if (i < 0) {
                this.ctR = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.ctR = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.ctR.tg();
        }
        this.ctR.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.czI != null) {
            kr(1);
            this.czI.bS(false);
            this.czI.notifyDataSetChanged();
        }
    }

    private void ay(View view) {
        if (this.ctR != null) {
            this.ctR.K(view);
            this.ctR = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.czI != null) {
            this.czI.bS(true);
            this.czI.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cxo != null) {
            this.cxo.onDestroy();
        }
    }

    public void onPause() {
        if (this.czN != null && this.czN.tag_type.intValue() == 3) {
            kc(this.cxF);
        }
    }

    public void akb() {
    }

    private void kr(int i) {
        if (i == 1) {
            if ((this.czH.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.czH.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.czH.setAdapter((ListAdapter) this.czI);
                akC();
            }
        } else if ((i == 2 || i == 3) && (this.czH.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.czH.getAdapter()).getWrappedAdapter() instanceof y)) {
            this.czH.addAdapter(null);
            akC();
        }
    }

    private void akC() {
        this.czH.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.pageContext);
        this.czH.setPullRefresh(this.mPullView);
        this.czH.removeHeaderView(this.cbJ);
        this.cbJ = new TextView(this.pageContext.getPageActivity());
        kq(this.czQ);
        this.czH.addHeaderView(this.cbJ, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aUC);
    }

    private void akD() {
        int logType = getLogType();
        long jY = com.baidu.tieba.homepage.framework.a.ajm().jY(logType);
        if (jY > 0) {
            com.baidu.tieba.homepage.framework.a.ajm().e(System.currentTimeMillis() - jY, logType);
            com.baidu.tieba.homepage.framework.a.ajm().f(0L, logType);
        }
    }

    private int getLogType() {
        if (this.czN == null) {
            return 2;
        }
        return this.czN.tag_type.intValue();
    }

    public void completePullRefresh() {
        if (this.czH != null) {
            this.czH.completePullRefresh();
        }
    }

    public void kc(int i) {
        t.a(new g(this, i), null);
    }

    public void akr() {
        b(this.czV);
    }

    public void b(x xVar) {
        if (!this.cuB) {
            this.cuB = true;
            t.a(new h(this), new i(this, xVar));
        }
    }
}
