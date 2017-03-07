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
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
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
    private PbListView aRw;
    private int asm;
    private int bHm;
    private BdUniqueId baP;
    private boolean bym;
    private BdTypeListView cBd;
    private com.baidu.tieba.homepage.recommendfrs.a cBe;
    private boolean cBf;
    private boolean cBg;
    private long cBh;
    private com.baidu.tieba.homepage.framework.b cBi;
    private TagInfo cBj;
    private com.baidu.tieba.homepage.recommendfrs.data.a cBk;
    private boolean cBl;
    private int cBm;
    private boolean cBn;
    private CustomMessageListener cBo;
    private boolean cBp;
    private int cBq;
    private x cBr;
    private TextView cgI;
    private String cvY;
    private String cvZ;
    private com.baidu.tbadk.f.f cvq;
    private boolean cwa;
    private com.baidu.tieba.homepage.framework.d cwb;
    public com.baidu.tieba.homepage.framework.b.a cxx;
    private m cyN;
    private ad cyq;
    private int czc;
    private boolean mHasMore;
    private boolean mIsBackground;
    private ae mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cBd != null && eVar != null) {
            this.cxx = eVar.ajb();
            this.cBd.setOnTouchListener(eVar.ajc());
        }
    }

    public void WL() {
        if (this.cxx != null) {
            this.cxx.eQ(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            jU(i2);
        }
    }

    private void jU(int i) {
        this.cBm = i;
        if (this.cgI != null) {
            ViewGroup.LayoutParams layoutParams = this.cgI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.cgI.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.cBl = false;
        this.cyN = null;
        this.bHm = 0;
        this.cBn = false;
        this.mIsBackground = false;
        this.cBo = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cvY = "recommendFrsViewLastReadTabPositionNamespace";
        this.cvZ = "recommendFrsViewLastReadTabPositionKey";
        this.czc = 0;
        this.cBp = false;
        this.cwa = false;
        this.cBq = -1;
        this.cBr = new d(this);
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.g<?> aa = k.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        d(context, LayoutInflater.from(context).inflate(w.j.recommend_frs_activity, this));
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        viewEventCenter.addEventDelegate(this);
        this.cBe = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.cBd.setAdapter((ListAdapter) this.cBe);
        this.asm = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.baP = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cBo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cBo);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cBi = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cwb = dVar;
    }

    public void ajm() {
        com.baidu.tieba.homepage.framework.a.aiz().c(System.currentTimeMillis(), getLogType());
        this.cBh = System.currentTimeMillis();
        if (this.cBj != null && !StringUtils.isNull(this.cBj.tag_name)) {
            TiebaStatic.log(new as("kantie_1").Z("obj_name", this.cBj.tag_name));
        }
        if (this.cBg && this.cBk != null && this.cBk.ajV() != null && this.cBk.ajV().size() > 0) {
            if (this.cBk.getDataType() == 1) {
                this.cBe.notifyDataSetChanged();
            } else {
                this.cyq.notifyDataSetChanged();
            }
            if (this.cBj != null && this.cBj.tag_type.intValue() == 7) {
                int i = com.baidu.tbadk.ala.a.nC().getInt("recommend_refresh", 60);
                if (System.currentTimeMillis() - com.baidu.tbadk.ala.a.nC().getLong("recommend_auto_update_get_server_data_time", System.currentTimeMillis()) > (i >= 60 ? i : 60) * 1000) {
                    eZ(false);
                }
            }
        } else if (this.cBf && !com.baidu.adp.lib.util.k.hv()) {
            if (this.cBe.Fs() <= 0) {
                this.cBe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asm), NoDataViewFactory.d.de(w.l.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.cBe.notifyDataSetChanged();
            }
        } else {
            if (this.cBl) {
                this.cBl = false;
                com.baidu.adp.lib.g.h.fM().postDelayed(new e(this), 200L);
            } else {
                ajL();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cBh) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajL() {
        a((View) this, false, getResources().getDimensionPixelSize(w.f.ds520));
        ajM();
    }

    private void d(Context context, View view) {
        this.cBd = (BdTypeListView) view.findViewById(w.h.listview);
        this.mPullView = new ae(this.pageContext);
        this.cBd.setPullRefresh(this.mPullView);
        this.aRw = new PbListView(context);
        this.aRw.la();
        this.aRw.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRw.dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.cBd.setOnSrollToBottomListener(this);
        this.cBd.setOnScrollListener(this);
        this.cgI = new TextView(context);
        jU(this.cBm);
        this.cBd.addHeaderView(this.cgI, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cBd != null) {
            this.cBd.completePullRefreshPostDelayed(2000L);
        }
        if (this.aRw != null) {
            this.aRw.wI();
        }
        if (aVar == null) {
            jV(1);
            aw(this);
            this.cBe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asm), NoDataViewFactory.d.de(w.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cBe.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.aiz().d(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cBk = aVar;
        this.bym = false;
        this.cBg = aVar.ajS();
        this.cBf = aVar.ajR();
        this.cBj = aVar.ajT();
        setHasMore(aVar.hasMore());
        List<Object> ajV = aVar.ajV();
        if (this.cBe != null) {
            if (ajV == null || ajV.size() <= 0) {
                if (!z2) {
                    jV(1);
                }
                if (this.cBf && this.cBg) {
                    this.cBe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asm), NoDataViewFactory.d.de(w.l.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.cBe.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.cBe.w(ajV);
                this.cBe.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    jV(aVar.getDataType());
                }
                this.cBe.w(ajV);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cyq == null) {
                    this.cyq = new ad(getContext(), this.cBd);
                    this.cyq.setPageUniqueId(this.baP);
                    if (aVar.getDataType() == 2) {
                        this.cyq.eY(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cyq.eY(true);
                    }
                    ajO();
                } else if (!z2) {
                    jV(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : ajV) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cyq.bd(arrayList);
            }
            if (this.cBj != null && !StringUtils.isNull(this.cBj.tag_name) && com.baidu.tbadk.core.util.x.p(ajV) > 0) {
                TiebaStatic.log(new as("kantie_1").Z("obj_name", this.cBj.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.aiz().d(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.cBd.setSelection(aVar.ajQ());
        }
        if (this.cBg) {
            aw(this);
        }
        if (!z) {
            ajP();
        }
        if (aVar.ajT().tag_type.intValue() == 3 && this.cBq != -1 && !this.cBn) {
            this.cBn = true;
            if (this.cBq <= this.cBd.getCount() - 1) {
                this.cBd.setSelection(this.cBq);
            }
        }
    }

    public void eZ(boolean z) {
        if (this.cBd != null) {
            WL();
            if (!z || this.cBk == null || this.cBk.ajV() == null || this.cBk.ajV().size() <= 0) {
                this.cBd.setSelection(0);
                this.cBd.startPullRefresh();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.cBd != null && this.aRw != null) {
            if (this.aRw.getView().getParent() == null) {
                this.cBd.setNextPage(this.aRw);
            }
            if (this.mHasMore) {
                this.aRw.wM();
                this.aRw.di(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds110));
                return;
            }
            this.aRw.dj(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajM() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.aiz().jD(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.aiz().f(System.currentTimeMillis(), logType);
        }
        if (this.cBf) {
            this.cBi.a(1, this.cBj.tag_code.longValue(), 0L, "");
        } else {
            this.cBi.bi(this.cBj.tag_code.longValue());
        }
    }

    public void M(String str, int i) {
        int i2 = 0;
        if (this.cBd != null) {
            this.cBd.completePullRefreshPostDelayed(2000L);
        }
        this.bym = false;
        this.aRw.wI();
        if (this.cBk != null && this.cBk.ajV() != null) {
            i2 = this.cBk.ajV().size();
        }
        if (i2 <= 0 && (this.cBf || i == -53)) {
            jV(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
            }
            this.cBe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.asm), NoDataViewFactory.d.dP(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cBe.w(new ArrayList());
        }
        aw(this);
        ajP();
    }

    private void g(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void jC(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).cd("from_frs").bz(18003).pg()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.cBp = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lj() {
        if (this.mHasMore && com.baidu.adp.lib.util.k.hv() && !this.bym) {
            this.bym = true;
            this.aRw.wH();
            if (this.cBi != null) {
                if (this.cBk == null || this.cBk.getDataType() == 1) {
                    if (this.cBe == null) {
                        this.cBi.a(1, this.cBj.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e ajK = this.cBe.ajK();
                    if (ajK != null) {
                        this.cBi.a(this.cBk != null ? this.cBk.getPn() + 1 : 1, this.cBj.tag_code.longValue(), ajK.ajY(), "");
                    }
                } else if (this.cBk.getDataType() == 2) {
                    int pn = this.cBk.getPn() + 1;
                    ajN();
                    this.cBi.a(pn, this.cBj.tag_code.longValue(), this.cBk.aji(), "");
                } else if (this.cBk.getDataType() == 3) {
                    this.cBi.a(this.cBk.getPn() + 1, this.cBj.tag_code.longValue(), 0L, this.cBk.ajU());
                }
            }
        }
    }

    private void ajN() {
        if (this.cBk != null && this.cBk.getDataType() == 2 && this.cBk.ajV() != null && this.cBk.ajV().size() >= TbadkCoreApplication.m9getInst().getListItemRule().yd() - 30) {
            int ye = TbadkCoreApplication.m9getInst().getListItemRule().ye();
            if (ye < 0) {
                ye = 0;
            }
            ArrayList arrayList = new ArrayList(this.cBk.ajV());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= ye && i < ye + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= ye + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cBk.bh(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cyq.bd(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        aq.e(this, w.e.cp_bg_line_d, i);
        if (this.cBk == null || this.cBk.getDataType() == 1) {
            if (this.cBe != null) {
                this.cBe.b(this.pageContext, i);
            }
        } else if ((this.cBk.getDataType() == 2 || this.cBk.getDataType() == 3) && this.cyq != null) {
            this.cyq.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.aRw != null) {
            this.aRw.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aRw.dh(i);
        }
    }

    public boolean br(long j) {
        return this.cBj != null && j == this.cBj.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cxx != null && !this.mIsBackground) {
            this.cxx.a(absListView, this.bHm, i, i2, i3);
        }
        this.bHm = i;
        if (this.cBj.tag_type.intValue() == 3 && this.cBp) {
            this.czc = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cwb != null && this.cBj != null) {
            this.cwb.g(this.cBj.tag_code.longValue(), this.cBd.getFirstVisiblePosition());
        }
        if (this.cxx != null && !this.mIsBackground) {
            this.cxx.onScrollStateChanged(absListView, i);
        }
        if (this.cyN == null) {
            this.cyN = new m();
            this.cyN.fb(1005);
        }
        this.cyN.pageType = getLogType();
        this.cyN.FP();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.EN();
        com.baidu.tbadk.mvc.b.a EO = bVar.EO();
        if (this.cBk == null || this.cBk.getDataType() == 1) {
            if (EO instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) EO;
                int i = 0;
                while (true) {
                    if (i < this.cBe.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.cBe.getItem(i);
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
                if (eVar.akc() != null && !eVar.akc().isEmpty()) {
                    str = eVar.akc().get(0);
                }
                if (eVar.akd() == 33) {
                    b(eVar.ake());
                } else if (eVar.akf() == 1) {
                    g(eVar.akb(), str);
                    TiebaStatic.log(new as("kantie_card").Z("obj_name", eVar.Uc).s("obj_type", 1).s("obj_locate", i).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cBI).s("obj_param1", 1).Z("abtest", eVar.abtest));
                } else if (eVar.akf() == 3) {
                    jC(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new as("kantie_card").Z("obj_name", eVar.Uc).s("obj_type", 2).s("obj_locate", i).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cBI).s("obj_param1", 1).Z("abtest", eVar.abtest));
                }
                r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.pX(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.pW(String.valueOf(eVar.getThreadId()));
                    this.cBe.D(EO);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EM() {
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
        public void aL(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.cBi != null) {
                b.this.ajM();
                if (com.baidu.tieba.homepage.framework.a.a.aja().cxn == com.baidu.tieba.homepage.framework.a.a.aja().cxl) {
                    com.baidu.tieba.homepage.framework.a.a.aja().cxm = 0;
                    com.baidu.tieba.homepage.framework.a.d.jM(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cvq == null) {
            if (i < 0) {
                this.cvq = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cvq = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cvq.tD();
        }
        this.cvq.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.V(false);
        }
        if (this.cBe != null) {
            jV(1);
            this.cBe.bS(false);
            this.cBe.notifyDataSetChanged();
        }
    }

    private void aw(View view) {
        if (this.cvq != null) {
            this.cvq.I(view);
            this.cvq = null;
        }
        if (this.mPullView != null) {
            this.mPullView.V(true);
        }
        if (this.cBe != null) {
            this.cBe.bS(true);
            this.cBe.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cyN != null) {
            this.cyN.onDestroy();
        }
    }

    public void onPause() {
        if (this.cBj != null && this.cBj.tag_type.intValue() == 3) {
            jH(this.czc);
        }
    }

    public void ajn() {
    }

    private void jV(int i) {
        if (i == 1) {
            if ((this.cBd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cBd.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.cBd.setAdapter((ListAdapter) this.cBe);
                ajO();
            }
        } else if ((i == 2 || i == 3) && (this.cBd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cBd.getAdapter()).getWrappedAdapter() instanceof y)) {
            this.cBd.addAdapter(null);
            ajO();
        }
    }

    private void ajO() {
        this.cBd.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new ae(this.pageContext);
        this.cBd.setPullRefresh(this.mPullView);
        this.cBd.removeHeaderView(this.cgI);
        this.cgI = new TextView(this.pageContext.getPageActivity());
        jU(this.cBm);
        this.cBd.addHeaderView(this.cgI, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.baP);
    }

    private void ajP() {
        int logType = getLogType();
        long jD = com.baidu.tieba.homepage.framework.a.aiz().jD(logType);
        if (jD > 0) {
            com.baidu.tieba.homepage.framework.a.aiz().e(System.currentTimeMillis() - jD, logType);
            com.baidu.tieba.homepage.framework.a.aiz().f(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cBj == null) {
            return 2;
        }
        return this.cBj.tag_type.intValue();
    }

    public void completePullRefresh() {
        if (this.cBd != null) {
            this.cBd.completePullRefresh();
        }
    }

    public void jH(int i) {
        t.a(new g(this, i), null);
    }

    public void ajD() {
        b(this.cBr);
    }

    public void b(x xVar) {
        if (!this.cwa) {
            this.cwa = true;
            t.a(new h(this), new i(this, xVar));
        }
    }
}
