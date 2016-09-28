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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.performanceLog.m;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.homepage.framework.x;
import com.baidu.tieba.homepage.personalize.b.ac;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.TagInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends FrameLayout implements AbsListView.OnScrollListener, BdListView.e, com.baidu.tbadk.mvc.c.a {
    private PbListView aMn;
    private int aRr;
    private BdUniqueId aYW;
    private int anp;
    private String cCP;
    private String cCQ;
    private boolean cCR;
    private com.baidu.tieba.homepage.framework.d cCS;
    private com.baidu.tbadk.f.f cCk;
    public com.baidu.tieba.homepage.framework.b.a cEo;
    private m cFF;
    private boolean cFJ;
    private int cFY;
    private ac cFk;
    private BdTypeListView cIi;
    private com.baidu.tieba.homepage.recommendfrs.a cIj;
    private boolean cIk;
    private boolean cIl;
    private boolean cIm;
    private long cIn;
    private com.baidu.tieba.homepage.framework.b cIo;
    private TagInfo cIp;
    private com.baidu.tieba.homepage.recommendfrs.data.a cIq;
    private boolean cIr;
    private int cIs;
    private boolean cIt;
    private CustomMessageListener cIu;
    private boolean cIv;
    private int cIw;
    private x cIx;
    private TextView ckT;
    private boolean mHasMore;
    private ab mPullView;
    private TbPageContext<?> pageContext;

    public void setTabInForeBackgroundState(boolean z) {
        this.cFJ = z;
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cIi != null && eVar != null) {
            this.cEo = eVar.amm();
            this.cIi.setOnTouchListener(eVar.amn());
        }
    }

    public void Zd() {
        if (this.cEo != null) {
            this.cEo.eV(true);
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            km(i2);
        }
    }

    private void km(int i) {
        this.cIs = i;
        if (this.ckT != null) {
            ViewGroup.LayoutParams layoutParams = this.ckT.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, 0);
            }
            layoutParams.height = i;
            this.ckT.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.cIr = false;
        this.cFF = null;
        this.aRr = 0;
        this.cIt = false;
        this.cFJ = false;
        this.cIu = new c(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW);
        this.cCP = "recommendFrsViewLastReadTabPositionNamespace";
        this.cCQ = "recommendFrsViewLastReadTabPositionKey";
        this.cFY = 0;
        this.cIv = false;
        this.cCR = false;
        this.cIw = -1;
        this.cIx = new d(this);
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
        this.cIj = new com.baidu.tieba.homepage.recommendfrs.a(this.pageContext, viewEventCenter);
        this.cIi.setAdapter((ListAdapter) this.cIj);
        this.anp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aYW = bdUniqueId;
            if (this.mPullView != null) {
                this.mPullView.setTag(bdUniqueId);
            }
            this.cIu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cIu);
        }
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cIo = bVar;
    }

    public void setScrollCallback(com.baidu.tieba.homepage.framework.d dVar) {
        this.cCS = dVar;
    }

    public void amy() {
        com.baidu.tieba.homepage.framework.a.alK().d(System.currentTimeMillis(), getLogType());
        this.cIn = System.currentTimeMillis();
        if (this.cIp != null && !StringUtils.isNull(this.cIp.tag_name)) {
            TiebaStatic.log(new ax("kantie_1").ab("obj_name", this.cIp.tag_name));
        }
        if (this.cIl && this.cIq != null && this.cIq.anh() != null && this.cIq.anh().size() > 0) {
            if (this.cIq.getDataType() == 1) {
                this.cIj.notifyDataSetChanged();
            } else {
                this.cFk.notifyDataSetChanged();
            }
        } else if (this.cIk && !k.gD()) {
            if (this.cIj.Fu() <= 0) {
                this.cIj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anp), NoDataViewFactory.d.de(r.j.neterror), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                this.cIj.notifyDataSetChanged();
            }
        } else {
            if (this.cIr) {
                this.cIr = false;
                com.baidu.adp.lib.h.h.eG().postDelayed(new e(this), 200L);
            } else {
                amX();
            }
            TiebaStatic.eventStat(getContext(), "kantie_duration", String.valueOf((System.currentTimeMillis() - this.cIn) / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amX() {
        a((View) this, false, getResources().getDimensionPixelSize(r.e.ds520));
        amY();
    }

    private void f(Context context, View view) {
        this.cIi = (BdTypeListView) view.findViewById(r.g.listview);
        this.mPullView = new ab(this.pageContext);
        this.cIi.setPullRefresh(this.mPullView);
        this.aMn = new PbListView(context);
        this.aMn.kk();
        this.aMn.setTextColor(av.getColor(r.d.cp_cont_d));
        this.aMn.dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.mPullView.a(new a(this, null));
        this.mPullView.a(new f(this));
        this.cIi.setOnSrollToBottomListener(this);
        this.cIi.setOnScrollListener(this);
        this.ckT = new TextView(context);
        km(this.cIs);
        this.cIi.f(this.ckT, 0);
    }

    public void a(com.baidu.tieba.homepage.recommendfrs.data.a aVar, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cIi != null) {
            this.cIi.l(2000L);
        }
        if (this.aMn != null) {
            this.aMn.wC();
        }
        if (aVar == null) {
            kn(1);
            at(this);
            this.cIj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anp), NoDataViewFactory.d.de(r.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cIj.notifyDataSetChanged();
            com.baidu.tieba.homepage.framework.a.alK().e(System.currentTimeMillis() - currentTimeMillis, 2);
            return;
        }
        this.cIq = aVar;
        this.cIm = false;
        this.cIl = aVar.ane();
        this.cIk = aVar.and();
        this.cIp = aVar.anf();
        setHasMore(aVar.hasMore());
        List<Object> anh = aVar.anh();
        if (this.cIj != null) {
            if (anh == null || anh.size() <= 0) {
                if (!z2) {
                    kn(1);
                }
                if (this.cIk && this.cIl) {
                    this.cIj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anp), NoDataViewFactory.d.de(r.j.invite_friend_no_data_now), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                    setHasMore(false);
                } else {
                    this.cIj.a((NoDataViewFactory.c) null, (NoDataViewFactory.d) null, (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
                }
                this.cIj.A(anh);
                this.cIj.notifyDataSetChanged();
            } else if (aVar.getDataType() == 1) {
                if (!z2) {
                    kn(aVar.getDataType());
                }
                this.cIj.A(anh);
            } else if (aVar.getDataType() == 2 || aVar.getDataType() == 3) {
                if (this.cFk == null) {
                    this.cFk = new ac(getContext(), this.cIi);
                    this.cFk.setPageUniqueId(this.aYW);
                    if (aVar.getDataType() == 2) {
                        this.cFk.fd(false);
                    } else if (aVar.getDataType() == 3) {
                        this.cFk.fd(true);
                    }
                    ana();
                } else if (!z2) {
                    kn(aVar.getDataType());
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : anh) {
                    if (obj instanceof v) {
                        arrayList.add((v) obj);
                    }
                }
                this.cFk.bv(arrayList);
            }
            if (this.cIp != null && !StringUtils.isNull(this.cIp.tag_name) && y.s(anh) > 0) {
                TiebaStatic.log(new ax("kantie_1").ab("obj_name", this.cIp.tag_name));
            }
            com.baidu.tieba.homepage.framework.a.alK().e(System.currentTimeMillis() - currentTimeMillis, getLogType());
        }
        if (z) {
            this.cIi.setSelection(aVar.anc());
        }
        if (this.cIl) {
            at(this);
        }
        if (!z) {
            anb();
        }
        if (aVar.anf().tag_type.intValue() == 3 && this.cIw != -1 && !this.cIt) {
            this.cIt = true;
            if (this.cIw <= this.cIi.getCount() - 1) {
                this.cIi.setSelection(this.cIw);
            }
        }
    }

    public void fe(boolean z) {
        if (this.cIi != null) {
            Zd();
            if (!z || this.cIq == null || this.cIq.anh() == null || this.cIq.anh().size() <= 0) {
                this.cIi.setSelection(0);
                this.cIi.kv();
            }
        }
    }

    private void setHasMore(boolean z) {
        this.mHasMore = z;
        if (this.cIi != null && this.aMn != null) {
            if (this.aMn.getView().getParent() == null) {
                this.cIi.setNextPage(this.aMn);
            }
            if (this.mHasMore) {
                this.aMn.wF();
                this.aMn.di(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds110));
                return;
            }
            this.aMn.dj(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds140));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amY() {
        int logType = getLogType();
        if (com.baidu.tieba.homepage.framework.a.alK().jT(logType) == -1) {
            com.baidu.tieba.homepage.framework.a.alK().g(System.currentTimeMillis(), logType);
        }
        if (this.cIk) {
            this.cIo.a(1, this.cIp.tag_code.longValue(), 0L, "");
        } else {
            this.cIo.bA(this.cIp.tag_code.longValue());
        }
    }

    public void V(String str, int i) {
        int i2 = 0;
        if (this.cIi != null) {
            this.cIi.l(2000L);
        }
        this.cIm = false;
        this.aMn.wC();
        if (this.cIq != null && this.cIq.anh() != null) {
            i2 = this.cIq.anh().size();
        }
        if (i2 <= 0 && (this.cIk || i == -53)) {
            kn(1);
            if (StringUtils.isNull(str, true)) {
                str = TbadkCoreApplication.m9getInst().getString(r.j.neterror);
            }
            this.cIj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.anp), NoDataViewFactory.d.dY(str), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
            this.cIj.A(new ArrayList());
        }
        at(this);
        anb();
    }

    private void j(long j, String str) {
        TiebaStatic.eventStat(getContext(), "notlogin_9", "click", 1, new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getContext(), j, str)));
    }

    private void kY(String str) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getContext()).createNormalCfg(str, null, null);
        createNormalCfg.setVideo_source(ImageViewerConfig.INDEX);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    private void b(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            this.pageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.pageContext.getContext(), String.valueOf(zhiBoInfoTW.thread_id)).ck("from_frs").bF(18003).oX()));
            TiebaStatic.log("c10258");
        }
    }

    public void setEnableLastReadPosition(boolean z) {
        this.cIv = z;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.mHasMore && k.gD() && !this.cIm) {
            this.cIm = true;
            this.aMn.wB();
            if (this.cIo != null) {
                if (this.cIq == null || this.cIq.getDataType() == 1) {
                    if (this.cIj == null) {
                        this.cIo.a(1, this.cIp.tag_code.longValue(), 0L, "");
                        return;
                    }
                    com.baidu.tieba.homepage.recommendfrs.data.e amW = this.cIj.amW();
                    if (amW != null) {
                        this.cIo.a(this.cIq != null ? this.cIq.getPn() + 1 : 1, this.cIp.tag_code.longValue(), amW.anj(), "");
                    }
                } else if (this.cIq.getDataType() == 2) {
                    int pn = this.cIq.getPn() + 1;
                    amZ();
                    this.cIo.a(pn, this.cIp.tag_code.longValue(), this.cIq.amu(), "");
                } else if (this.cIq.getDataType() == 3) {
                    this.cIo.a(this.cIq.getPn() + 1, this.cIp.tag_code.longValue(), 0L, this.cIq.ang());
                }
            }
        }
    }

    private void amZ() {
        if (this.cIq != null && this.cIq.getDataType() == 2 && this.cIq.anh() != null && this.cIq.anh().size() >= TbadkCoreApplication.m9getInst().getListItemRule().xR() - 30) {
            int xS = TbadkCoreApplication.m9getInst().getListItemRule().xS();
            if (xS < 0) {
                xS = 0;
            }
            ArrayList arrayList = new ArrayList(this.cIq.anh());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i >= xS && i < xS + 30) {
                    arrayList2.add(arrayList.get(i));
                } else if (i >= xS + 30) {
                    break;
                }
            }
            arrayList.removeAll(arrayList2);
            this.cIq.bz(arrayList);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof v) {
                    arrayList3.add((v) next);
                }
            }
            this.cFk.bv(arrayList3);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.pageContext, this);
        av.e(this, r.d.cp_bg_line_d, i);
        if (this.cIq == null || this.cIq.getDataType() == 1) {
            if (this.cIj != null) {
                this.cIj.a(this.pageContext, i);
            }
        } else if ((this.cIq.getDataType() == 2 || this.cIq.getDataType() == 3) && this.cFk != null) {
            this.cFk.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.aMn != null) {
            this.aMn.setTextColor(av.getColor(r.d.cp_cont_d));
            this.aMn.dh(i);
        }
    }

    public boolean bJ(long j) {
        return this.cIp != null && j == this.cIp.tag_code.longValue();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cEo != null && !this.cFJ) {
            this.cEo.a(absListView, this.aRr, i, i2, i3);
        }
        this.aRr = i;
        if (this.cIp.tag_type.intValue() == 3 && this.cIv) {
            this.cFY = i;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.cCS != null && this.cIp != null) {
            this.cCS.h(this.cIp.tag_code.longValue(), this.cIi.getFirstVisiblePosition());
        }
        if (this.cEo != null && !this.cFJ) {
            this.cEo.onScrollStateChanged(absListView, i);
        }
        if (this.cFF == null) {
            this.cFF = new m();
            this.cFF.fd(1005);
        }
        this.cFF.pageType = getLogType();
        this.cFF.FV();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        bVar.EL();
        com.baidu.tbadk.mvc.b.a EM = bVar.EM();
        if (this.cIq == null || this.cIq.getDataType() == 1) {
            if (EM instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
                com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) EM;
                int i = 0;
                while (true) {
                    if (i < this.cIj.getCount()) {
                        com.baidu.tieba.homepage.recommendfrs.data.e eVar2 = (com.baidu.tieba.homepage.recommendfrs.data.e) this.cIj.getItem(i);
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
                if (eVar.ann() != null && !eVar.ann().isEmpty()) {
                    str = eVar.ann().get(0);
                }
                if (eVar.ano() == 33) {
                    b(eVar.anp());
                } else if (eVar.anq() == 1) {
                    j(eVar.anm(), str);
                    TiebaStatic.log(new ax("kantie_card").ab("obj_name", eVar.PC).s("obj_type", 1).s("obj_locate", i).ab("obj_source", eVar.cIN).s("obj_param1", 1).ab("abtest", eVar.abtest));
                } else if (eVar.anq() == 3) {
                    kY(new StringBuilder(String.valueOf(eVar.getThreadId())).toString());
                    TiebaStatic.log(new ax("kantie_card").ab("obj_name", eVar.PC).s("obj_type", 2).s("obj_locate", i).ab("obj_source", eVar.cIN).s("obj_param1", 1).ab("abtest", eVar.abtest));
                }
                s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.ru(String.valueOf(eVar.getThreadId()))) {
                    readThreadHistory.rt(String.valueOf(eVar.getThreadId()));
                    this.cIj.D(EM);
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
    public class a implements y.b {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.view.y.b
        public void aI(boolean z) {
            TiebaStatic.eventStat(b.this.getContext(), "kantie_update", null);
            if (b.this.cIo != null) {
                b.this.amY();
                if (com.baidu.tieba.homepage.framework.a.a.aml().cEd == com.baidu.tieba.homepage.framework.a.a.aml().cEb) {
                    com.baidu.tieba.homepage.framework.a.a.aml().cEc = 0;
                    com.baidu.tieba.homepage.framework.a.d.kc(0);
                }
            }
        }
    }

    private void a(View view, boolean z, int i) {
        if (this.cCk == null) {
            if (i < 0) {
                this.cCk = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.cCk = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.cCk.tx();
        }
        this.cCk.b(view, z);
        if (this.mPullView != null) {
            this.mPullView.U(false);
        }
        if (this.cIj != null) {
            kn(1);
            this.cIj.bP(false);
            this.cIj.notifyDataSetChanged();
        }
    }

    private void at(View view) {
        if (this.cCk != null) {
            this.cCk.L(view);
            this.cCk = null;
        }
        if (this.mPullView != null) {
            this.mPullView.U(true);
        }
        if (this.cIj != null) {
            this.cIj.bP(true);
            this.cIj.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.cFF != null) {
            this.cFF.onDestroy();
        }
    }

    public void onPause() {
        if (this.cIp != null && this.cIp.tag_type.intValue() == 3) {
            jX(this.cFY);
        }
    }

    public void amz() {
    }

    private void kn(int i) {
        if (i == 1) {
            if ((this.cIi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cIi.getAdapter()).getWrappedAdapter() instanceof com.baidu.tieba.homepage.recommendfrs.a)) {
                this.cIi.setAdapter((ListAdapter) this.cIj);
                ana();
            }
        } else if ((i == 2 || i == 3) && (this.cIi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) && !(((com.baidu.adp.widget.ListView.e) this.cIi.getAdapter()).getWrappedAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            this.cIi.a((com.baidu.adp.widget.ListView.a<v, y.a>) null);
            ana();
        }
    }

    private void ana() {
        this.cIi.setPullRefresh(null);
        this.mPullView.release();
        this.mPullView = new ab(this.pageContext);
        this.cIi.setPullRefresh(this.mPullView);
        this.cIi.removeHeaderView(this.ckT);
        this.ckT = new TextView(this.pageContext.getPageActivity());
        km(this.cIs);
        this.cIi.f(this.ckT, 0);
        this.mPullView.a(new a(this, null));
        this.mPullView.setTag(this.aYW);
    }

    private void anb() {
        int logType = getLogType();
        long jT = com.baidu.tieba.homepage.framework.a.alK().jT(logType);
        if (jT > 0) {
            com.baidu.tieba.homepage.framework.a.alK().f(System.currentTimeMillis() - jT, logType);
            com.baidu.tieba.homepage.framework.a.alK().g(0L, logType);
        }
    }

    private int getLogType() {
        if (this.cIp == null) {
            return 2;
        }
        return this.cIp.tag_type.intValue();
    }

    public void ku() {
        if (this.cIi != null) {
            this.cIi.ku();
        }
    }

    public void jX(int i) {
        u.a(new g(this, i), null);
    }

    public void amQ() {
        b(this.cIx);
    }

    public void b(x xVar) {
        if (!this.cCR) {
            this.cCR = true;
            u.a(new h(this), new i(this, xVar));
        }
    }
}
