package com.baidu.tieba.homepage.personalize.adapter;

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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> ahy;
    private String ajx;
    private com.baidu.adp.widget.ListView.s anC;
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    private as iQw;
    private com.baidu.tieba.homepage.personalize.model.e klV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iQw != null && this.iQw.tq() != null && this.iQw.tq().dAf() != null) {
            if (view.getId() == this.iQw.tq().dAf().getId()) {
                com.baidu.tieba.homepage.personalize.a.a.a(lVar.eLr, this.fIy, lVar.csU(), 4);
                TiebaStatic.log(lVar.ctm());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.aj(lVar.eLr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gfx = null;
        this.ahy = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.csH().mG(true);
                com.baidu.tieba.a.d.bKY().dK("page_recommend", "show_");
                if (y.this.klV != null && lVar != null && lVar.blp() != null && !StringUtils.isNull(lVar.blp().getTid())) {
                    if (lVar.blp().eUB > 0) {
                        TiebaStatic.log(lVar.aj(lVar.blp()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gF(com.baidu.adp.lib.f.b.toLong(lVar.blp().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gE(com.baidu.adp.lib.f.b.toLong(lVar.blp().getTid(), 0L));
                        y.this.klV.a(com.baidu.adp.lib.f.b.toLong(lVar.blp().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.csU(), lVar.csV(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.blp().getBaijiahaoData());
                    }
                    y.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPp();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anC = sVar;
    }

    private void cPp() {
        com.baidu.tieba.card.data.l.iCF = "c10708";
        com.baidu.tieba.card.data.l.iCG = "c10735";
        com.baidu.tieba.card.data.l.iCV = "c10709";
        com.baidu.tieba.card.data.l.iCE = "c10734";
        com.baidu.tieba.card.data.l.iCW = "c11929";
        com.baidu.tieba.card.data.l.iCX = "c11928";
        com.baidu.tieba.card.data.l.iCY = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.b bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        bVar.a(new a.InterfaceC0094a() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.2
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(bVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, y.this.mContext, 2, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, y.this.mContext, 2, false, bs);
                }
            }
        });
        this.iQw = bVar;
        this.iQw.setPageUniqueId(this.fIy);
        this.iQw.setFrom("index");
        this.iQw.setStageType("2001");
        aVar.c(this.iQw);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anC);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fIy);
        a2.a(this.ahy);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) nVar;
                    lVar.objType = 1;
                    if (y.this.ahy != null) {
                        y.this.ahy.a(autoVideoCardViewHolder2.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xe(lVar.position + 1);
        autoVideoCardViewHolder.tj().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.t.csH().e(lVar.ctd());
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.tj() != null) {
            autoVideoCardViewHolder.tj().setPage(this.ajx);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.ahy);
        com.baidu.tieba.homepage.personalize.a.a.a(lVar.eLr, this.fIy, lVar.csU());
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.anU = lVar.tid;
            if (lVar.blp() != null) {
                oVar.fOD = String.valueOf(lVar.blp().getFid());
                oVar.mKI = lVar.blp().bmq();
                if (lVar.blp().boj() != null) {
                    oVar.mKE = lVar.blp().boj().video_md5;
                    oVar.mKG = String.valueOf(lVar.blp().boj().is_vertical);
                }
            }
            oVar.ePf = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mKD = lVar.csV();
            oVar.mKA = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csU());
            if (lVar.blp() != null && lVar.blp().getBaijiahaoData() != null) {
                oVar.eVa = lVar.blp().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.blp().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.klV = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void onResume() {
        if (this.iQw != null) {
            this.iQw.onResume();
        }
    }

    public void onPause() {
        if (this.iQw != null) {
            this.iQw.onPause();
        }
    }
}
