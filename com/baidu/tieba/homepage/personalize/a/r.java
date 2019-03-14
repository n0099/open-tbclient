package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> Xr;
    private String YA;
    private com.baidu.adp.widget.ListView.r aaK;
    private NEGFeedBackView.a cIT;
    public BdUniqueId cnX;
    private com.baidu.tieba.homepage.personalize.model.e fLP;
    private ac fMf;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.fMf != null && this.fMf.rC() != null && this.fMf.rC().bSZ() != null) {
            if (view.getId() == this.fMf.rC().bSZ().getId()) {
                TiebaStatic.log(lVar.Y(lVar.cZz));
                com.baidu.tieba.q.c.cdt().b(this.cnX, com.baidu.tieba.q.a.a(lVar.cZz, "a002", "common_click", 4, lVar.aQP(), false, null, null));
                TiebaStatic.log(lVar.aRh());
            } else if (view.getId() == d.g.thread_card_root) {
                TiebaStatic.log(lVar.Y(lVar.cZz));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIT = null;
        this.Xr = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aQF().go(true);
                com.baidu.tieba.a.d.awk().bA("page_recommend", "show_");
                if (r.this.fLP != null && lVar != null && lVar.WR() != null && !StringUtils.isNull(lVar.WR().getTid())) {
                    if (lVar.WR().bDt > 0) {
                        TiebaStatic.log(lVar.Y(lVar.WR()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(lVar.WR().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(lVar.WR().getTid(), 0L));
                        r.this.fLP.a(com.baidu.adp.lib.g.b.d(lVar.WR().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aQP(), lVar.aQQ(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    r.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmL();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.aaK = rVar;
    }

    private void bmL() {
        com.baidu.tieba.card.data.l.els = "c10708";
        com.baidu.tieba.card.data.l.elL = "c10735";
        com.baidu.tieba.card.data.l.elM = "c10709";
        com.baidu.tieba.card.data.l.elr = "c10734";
        com.baidu.tieba.card.data.l.elN = "c11929";
        com.baidu.tieba.card.data.l.elO = "c11928";
        com.baidu.tieba.card.data.l.elP = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.fMf = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.fMf = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.fMf.setPageUniqueId(this.cnX);
        this.fMf.setFrom("index");
        aVar.b(this.fMf);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.aaK);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cnX);
        a.a(this.Xr);
        a.by(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (r.this.Xr != null) {
                        r.this.Xr.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.rx().b(new a.C0039a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar != null) {
            lVar.os(lVar.position + 1);
            aVar.rx().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aQF().b(lVar.aRa());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.elK) {
                am amVar = new am("c11003");
                bg WR = lVar.WR();
                if (WR != null) {
                    amVar.bJ("tid", WR.getTid());
                    if (WR.YR() != null) {
                        amVar.T("ab_type", WR.YR().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aQF().b(amVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.rx() != null) {
                aVar.rx().setPage(this.YA);
            }
            aVar.a(lVar);
            aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.rx().a(this.Xr);
            com.baidu.tieba.q.c.cdt().a(this.cnX, lVar.cZz != null ? lVar.cZz.getId() : null, com.baidu.tieba.q.a.a(lVar.cZz, "a002", "common_exp", lVar.aQP(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.ctu = lVar.tid;
            if (lVar.WR() != null) {
                zVar.ela = String.valueOf(lVar.WR().getFid());
                if (lVar.WR().Zi() != null) {
                    zVar.hYP = lVar.WR().Zi().video_md5;
                    zVar.hYR = String.valueOf(lVar.WR().Zi().is_vertical);
                }
            }
            zVar.byA = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.hYO = lVar.aQQ();
            zVar.hYM = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aQP());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLP = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }

    public void onResume() {
        if (this.fMf != null) {
            this.fMf.onResume();
        }
    }

    public void onPause() {
        if (this.fMf != null) {
            this.fMf.onPause();
        }
    }
}
