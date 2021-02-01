package com.baidu.tieba.homepage.concern.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> agg;
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private as iOz;
    private BdUniqueId kaL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iOz != null && this.iOz.tq() != null && this.iOz.tq().dzP() != null) {
            if (view.getId() == this.iOz.tq().dzP().getId()) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
            }
        }
    }

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.csu().mG(true);
                com.baidu.tieba.a.d.bKP().dK("page_recommend", "show_");
                if (lVar != null && lVar.bln() != null && !StringUtils.isNull(lVar.bln().getTid())) {
                    if (lVar.bln().eTa <= 0) {
                        x.this.b(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.aj(lVar.bln()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kaL = bdUniqueId2;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId ql() {
        return this.kaL != null ? this.kaL : com.baidu.tieba.card.data.b.izQ;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qm() {
        return com.baidu.tieba.card.data.b.izW;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return com.baidu.tieba.card.data.b.izY;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return com.baidu.tieba.card.data.b.izZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.b bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        bVar.setPageUniqueId(this.fGZ);
        bVar.setFrom("concern_tab");
        bVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.concern.adapter.x.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(bVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, x.this.mContext, 1, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, x.this.mContext, 1, false, bs);
                }
            }
        });
        this.iOz = bVar;
        aVar.c(this.iOz);
        if (this.iOz != null) {
            this.iOz.setStageType("2001");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fGZ);
        a2.a(this.agg);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.x.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qv() instanceof com.baidu.tieba.card.data.l)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar2 = (com.baidu.tieba.card.data.l) ((com.baidu.adp.widget.ListView.g) nVar).qv();
                    lVar2.objType = 1;
                    if (x.this.agg != null) {
                        x.this.agg.a(threadCardViewHolder.getView(), lVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0089a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xd(lVar.position + 1);
        com.baidu.tieba.card.t.csu().e(lVar.IS("c12351"));
        autoVideoCardViewHolder.tj().setPosition(i);
        lVar.sourceType = 0;
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.tj().setPage(this.aif);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.agg);
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.amC = lVar.tid;
            if (lVar.bln() != null) {
                oVar.fNd = String.valueOf(lVar.bln().getFid());
                if (lVar.bln().boh() != null) {
                    oVar.mIj = lVar.bln().boh().video_md5;
                    oVar.mIl = String.valueOf(lVar.bln().boh().is_vertical);
                }
            }
            oVar.eNE = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mIi = lVar.csI();
            oVar.mIf = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csH());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }
}
