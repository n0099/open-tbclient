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
    private PbListView aRO;
    private int asE;
    private boolean bAw;
    private int bJw;
    private BdUniqueId bbE;
    private BdTypeListView cBT;
    private com.baidu.tieba.homepage.recommendfrs.a cBU;
    private boolean cBV;
    private boolean cBW;
    private long cBX;
    private com.baidu.tieba.homepage.framework.b cBY;
    private TagInfo cBZ;
    private com.baidu.tieba.homepage.recommendfrs.data.a cCa;
    private boolean cCb;
    private int cCc;
    private boolean cCd;
    private CustomMessageListener cCe;
    private boolean cCf;
    private int cCg;
    private x cCh;
    private TextView chz;
    private String cwP;
    private String cwQ;
    private boolean cwR;
    private com.baidu.tieba.homepage.framework.d cwS;
    private com.baidu.tbadk.i.f cwh;
    public com.baidu.tieba.homepage.framework.b.a cyo;
    private m czE;
    private int czT;
    private ad czh;
    private boolean mHasMore;
    private boolean mIsBackground;
    private ae mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cBT != null && eVar != null) {
            this.cyo = eVar.ajW();
            this.cBT.setOnTouchListener(eVar.ajX());
        }
    }

    public void Yk() {
        if (this.cyo != null) {
            this.cyo.fa(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            kb(i2);
        }
    }

    private void kb(int i) {
        this.cCc = i;
        if (this.chz != null) {
            ViewGroup.LayoutParams layoutParams = this.chz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.chz.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.cCb = false;
        this.czE = null;
        this.bJw = 0;
        this.cCd = false;
        this.mIsBackground = false;
        this.cCe = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cwP = "recommendFrsViewLastReadTabPositionNamespace";
        this.cwQ = "recommendFrsViewLastReadTabPositionKey";
        this.czT = 0;
        this.cCf = false;
        this.cwR = false;
        this.cCg = -1;
        this.cCh = new d(this);
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
        this.cBU = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.cBT.setAdapter((ListAdapter) this.cBU);
        this.asE = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bbE = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cCe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cCe);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cBY = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cwS = dVar;
    }

    public void akh() {
        com.baidu.tieba.homepage.framework.a.aju().c(System.currentTimeMillis(), getLogType());
        this.cBX = System.currentTimeMillis();
        if (this.cBZ != null && !StringUtils.isNull(this.cBZ.tag_name)) {
            TiebaStatic.log(new as("kantie_1").aa("obj_name", this.cBZ.tag_name));
        }
        if (this.cBW && this.cCa != null && this.cCa.akQ() != null && this.cCa.akQ().size() > 0) {
            if (this.cCa.getDataType() == 1) {
                this.cBU.notifyDataSetChanged();
            } else {
                this.czh.notifyDataSetChanged();
            }
            if (this.cBZ != null && this.cBZ.tag_type.intValue() == 7) {
                int i = com.baidu.tbadk.ala.a.nZ().getInt("recommend_refresh", 60);
                if (System.currentTimeMillis() - com.baidu.tbadk.ala.a.nZ().getLong("recommend_auto_update_get_server_data_time", System.currentTimeMillis()) > (i >= 60 ? i : 60) * 1000) {
                    fj(false);
                }
            }
        } else if (this.cBV && !com.baidu.adp.lib.util.k.hB()) {
            if (this.cBU.FQ() <= 0) {
                this.cBU.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asE), NoDataViewFactory.d.dh(w.l.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.cBU.notifyDataSetChanged();
            }
        } else {
            if (this.cCb) {
                this.cCb = false;
                com.baidu.adp.lib.g.h.fS().postDelayed(new e(this), 200L);
            } else {
                akG();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cBX) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        a((View) this, false, getResources().getDimensionPixelSize(w.f.ds520));
        akH();
    }

    private void d(Context context, View view) {
        this.cBT = (BdTypeListView) view.findViewById(w.h.listview);
        this.mPullView = new ae(this.pageContext);
        this.cBT.setPullRefresh(this.mPullView);
        this.aRO = new PbListView(context);
        this.aRO.lf();
        this.aRO.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRO.dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.cBT.setOnSrollToBottomListener(this);
        this.cBT.setOnScrollListener(this);
        this.chz = new TextView(context);
        kb(this.cCc);
        this.cBT.addHeaderView(this.chz, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cBT != null) {
            this.cBT.completePullRefreshPostDelayed(2000L);
        }
        if (this.aRO != null) {
            this.aRO.xe();
        }
        if (aVar == null) {
            kc(1);
            au(this);
            this.cBU.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asE), NoDataViewFactory.d.dh(w.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cBU.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.aju().d(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cCa = aVar;
        this.bAw = false;
        this.cBW = aVar.akN();
        this.cBV = aVar.akM();
        this.cBZ = aVar.akO();
        setHasMore(aVar.hasMore());
        List<Object> akQ = aVar.akQ();
        if (this.cBU != null) {
            if (akQ == null || akQ.size() <= 0) {
                if (!z2) {
                    kc(1);
                }
                if (this.cBV && this.cBW) {
                    this.cBU.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asE), NoDataViewFactory.d.dh(w.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.cBU.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.cBU.w(akQ);
                this.cBU.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    kc(aVar.getDataType());
                }
                this.cBU.w(akQ);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.czh == null) {
                    this.czh = new ad(getContext(), this.cBT);
                    this.czh.setPageUniqueId(this.bbE);
                    if (aVar.getDataType() == 2) {
                        this.czh.fi(false);
                    } else if (aVar.getDataType() == 3) {
                        this.czh.fi(true);
                    }
                    akJ();
                } else if (!z2) {
                    kc(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : akQ) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.czh.bd(arrayList);
            }
            if (this.cBZ != null && !StringUtils.isNull(this.cBZ.tag_name) && com.baidu.tbadk.core.util.x.p(akQ) > 0) {
                TiebaStatic.log(new as("kantie_1").aa("obj_name", this.cBZ.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.aju().d(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.cBT.setSelection(aVar.akL());
        }
        if (this.cBW) {
            au(this);
        }
        if (!z) {
            akK();
        }
        if (aVar.akO().tag_type.intValue() == 3 && this.cCg != -1 && !this.cCd) {
            this.cCd = true;
            if (this.cCg <= this.cBT.getCount() - 1) {
                this.cBT.setSelection(this.cCg);
            }
        }
    }

    public void fj(boolean z) {
        if (this.cBT != null) {
            Yk();
            if (!z || this.cCa == null || this.cCa.akQ() == null || this.cCa.akQ().size() <= 0) {
                this.cBT.setSelection(0);
                this.cBT.startPullRefresh();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.cBT != null && this.aRO != null) {
            if (this.aRO.getView().getParent() == null) {
                this.cBT.setNextPage(this.aRO);
            }
            if (this.mHasMore) {
                this.aRO.xi();
                this.aRO.dl(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds110));
                return;
            }
            this.aRO.dm(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akH() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.aju().jK(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.aju().f(System.currentTimeMillis(), logType);
        }
        if (this.cBV) {
            this.cBY.a(1, this.cBZ.tag_code.longValue(), 0L, "");
        } else {
            this.cBY.bi(this.cBZ.tag_code.longValue());
        }
    }

    public void M(String str, int i) {
        int i2 = 0;
        if (this.cBT != null) {
            this.cBT.completePullRefreshPostDelayed(2000L);
        }
        this.bAw = false;
        this.aRO.xe();
        if (this.cCa != null && this.cCa.akQ() != null) {
            i2 = this.cCa.akQ().size();
        }
        if (i2 <= 0 && (this.cBV || i == -53)) {
            kc(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
            }
            this.cBU.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asE), NoDataViewFactory.d.dV(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cBU.w(new ArrayList());
        }
        au(this);
        akK();
    }

    private void g(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void jJ(String str) {
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
        this.cCf = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lo() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.hB() && !this.bAw) {
            this.bAw = true;
            this.aRO.xd();
            if (this.cBY != null) {
                if (this.cCa == null || this.cCa.getDataType() == 1) {
                    if (this.cBU == null) {
                        this.cBY.a(1, this.cBZ.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e akF = this.cBU.akF();
                    if (akF != null) {
                        this.cBY.a(this.cCa != null ? this.cCa.getPn() + 1 : 1, this.cBZ.tag_code.longValue(), akF.akT(), "");
                    }
                } else if (this.cCa.getDataType() == 2) {
                    int pn = this.cCa.getPn() + 1;
                    akI();
                    this.cBY.a(pn, this.cBZ.tag_code.longValue(), this.cCa.akd(), "");
                } else if (this.cCa.getDataType() == 3) {
                    this.cBY.a(this.cCa.getPn() + 1, this.cBZ.tag_code.longValue(), 0L, this.cCa.akP());
                }
            }
        }
    }

    private void akI() {
        if (this.cCa != null && this.cCa.getDataType() == 2 && this.cCa.akQ() != null && this.cCa.akQ().size() >= TbadkCoreApplication.m9getInst().getListItemRule().yB() - 30) {
            int yC = TbadkCoreApplication.m9getInst().getListItemRule().yC();
            if (yC < 0) {
                yC = 0;
            }
            ArrayList arrayList = new ArrayList(this.cCa.akQ());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= yC && i < yC + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= yC + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cCa.bh(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.czh.bd(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.m.a.a(this.pageContext, this);
        aq.e(this, w.e.cp_bg_line_d, i);
        if (this.cCa == null || this.cCa.getDataType() == 1) {
            if (this.cBU != null) {
                this.cBU.b(this.pageContext, i);
            }
        } else if ((this.cCa.getDataType() == 2 || this.cCa.getDataType() == 3) && this.czh != null) {
            this.czh.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.aRO != null) {
            this.aRO.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aRO.dk(i);
        }
    }

    public boolean br(long j) {
        return this.cBZ != null && j == this.cBZ.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cyo != null && !this.mIsBackground) {
            this.cyo.a(absListView, this.bJw, i, i2, i3);
        }
        this.bJw = i;
        if (this.cBZ.tag_type.intValue() == 3 && this.cCf) {
            this.czT = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cwS != null && this.cBZ != null) {
            this.cwS.g(this.cBZ.tag_code.longValue(), this.cBT.getFirstVisiblePosition());
        }
        if (this.cyo != null && !this.mIsBackground) {
            this.cyo.onScrollStateChanged(absListView, i);
        }
        if (this.czE == null) {
            this.czE = new m();
            this.czE.fe(1005);
        }
        this.czE.pageType = getLogType();
        this.czE.Gn();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.Fl();
        com.baidu.tbadk.mvc.b.a Fm = bVar.Fm();
        if (this.cCa == null || this.cCa.getDataType() == 1) {
            if (Fm instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) Fm;
                int i = 0;
                while (true) {
                    if (i < this.cBU.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.cBU.getItem(i);
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
                if (eVar.akX() != null && !eVar.akX().isEmpty()) {
                    str = eVar.akX().get(0);
                }
                if (eVar.akY() == 33) {
                    a(eVar.akZ());
                } else if (eVar.ala() == 1) {
                    g(eVar.akW(), str);
                    TiebaStatic.log(new as("kantie_card").aa("obj_name", eVar.Uw).s("obj_type", 1).s("obj_locate", i).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cCy).s("obj_param1", 1).aa("abtest", eVar.abtest));
                } else if (eVar.ala() == 3) {
                    jJ(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new as("kantie_card").aa("obj_name", eVar.Uw).s("obj_type", 2).s("obj_locate", i).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cCy).s("obj_param1", 1).aa("abtest", eVar.abtest));
                }
                r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.qp(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.qo(String.valueOf(eVar.getThreadId()));
                    this.cBU.D(Fm);
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
            if (b.this.cBY != null) {
                b.this.akH();
                if (com.baidu.tieba.homepage.framework.a.a.ajV().cye == com.baidu.tieba.homepage.framework.a.a.ajV().cyc) {
                    com.baidu.tieba.homepage.framework.a.a.ajV().cyd = 0;
                    com.baidu.tieba.homepage.framework.a.d.jT(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cwh == null) {
            if (i < 0) {
                this.cwh = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.cwh = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.cwh.onChangeSkinType();
        }
        this.cwh.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.V(false);
        }
        if (this.cBU != null) {
            kc(1);
            this.cBU.bU(false);
            this.cBU.notifyDataSetChanged();
        }
    }

    private void au(View view) {
        if (this.cwh != null) {
            this.cwh.I(view);
            this.cwh = null;
        }
        if (this.mPullView != null) {
            this.mPullView.V(true);
        }
        if (this.cBU != null) {
            this.cBU.bU(true);
            this.cBU.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.czE != null) {
            this.czE.onDestroy();
        }
    }

    public void onPause() {
        if (this.cBZ != null && this.cBZ.tag_type.intValue() == 3) {
            jO(this.czT);
        }
    }

    public void aki() {
    }

    private void kc(int i) {
        if (i == 1) {
            if ((this.cBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cBT.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.cBT.setAdapter((ListAdapter) this.cBU);
                akJ();
            }
        } else if ((i == 2 || i == 3) && (this.cBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cBT.getAdapter()).getWrappedAdapter() instanceof y)) {
            this.cBT.addAdapter(null);
            akJ();
        }
    }

    private void akJ() {
        this.cBT.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new ae(this.pageContext);
        this.cBT.setPullRefresh(this.mPullView);
        this.cBT.removeHeaderView(this.chz);
        this.chz = new TextView(this.pageContext.getPageActivity());
        kb(this.cCc);
        this.cBT.addHeaderView(this.chz, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.bbE);
    }

    private void akK() {
        int logType = getLogType();
        long jK = com.baidu.tieba.homepage.framework.a.aju().jK(logType);
        if (jK > 0) {
            com.baidu.tieba.homepage.framework.a.aju().e(System.currentTimeMillis() - jK, logType);
            com.baidu.tieba.homepage.framework.a.aju().f(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cBZ == null) {
            return 2;
        }
        return this.cBZ.tag_type.intValue();
    }

    public void completePullRefresh() {
        if (this.cBT != null) {
            this.cBT.completePullRefresh();
        }
    }

    public void jO(int i) {
        t.a(new g(this, i), null);
    }

    public void aky() {
        b(this.cCh);
    }

    public void b(x xVar) {
        if (!this.cwR) {
            this.cwR = true;
            t.a(new h(this), new i(this, xVar));
        }
    }
}
