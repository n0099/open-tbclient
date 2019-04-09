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
    private ab<com.baidu.tieba.card.data.l> Xs;
    private String YB;
    private com.baidu.adp.widget.ListView.r aaM;
    private NEGFeedBackView.a cIW;
    public BdUniqueId coa;
    private com.baidu.tieba.homepage.personalize.model.e fLD;
    private ac fLT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.fLT != null && this.fLT.rC() != null && this.fLT.rC().bSV() != null) {
            if (view.getId() == this.fLT.rC().bSV().getId()) {
                TiebaStatic.log(lVar.X(lVar.cZD));
                com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_click", 4, lVar.aQN(), false, null, null));
                TiebaStatic.log(lVar.aRf());
            } else if (view.getId() == d.g.thread_card_root) {
                TiebaStatic.log(lVar.X(lVar.cZD));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIW = null;
        this.Xs = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aQD().go(true);
                com.baidu.tieba.a.d.awh().bA("page_recommend", "show_");
                if (r.this.fLD != null && lVar != null && lVar.WO() != null && !StringUtils.isNull(lVar.WO().getTid())) {
                    if (lVar.WO().bDx > 0) {
                        TiebaStatic.log(lVar.X(lVar.WO()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(lVar.WO().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(lVar.WO().getTid(), 0L));
                        r.this.fLD.a(com.baidu.adp.lib.g.b.d(lVar.WO().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aQN(), lVar.aQO(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    r.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmI();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.aaM = rVar;
    }

    private void bmI() {
        com.baidu.tieba.card.data.l.elf = "c10708";
        com.baidu.tieba.card.data.l.ely = "c10735";
        com.baidu.tieba.card.data.l.elz = "c10709";
        com.baidu.tieba.card.data.l.ele = "c10734";
        com.baidu.tieba.card.data.l.elA = "c11929";
        com.baidu.tieba.card.data.l.elB = "c11928";
        com.baidu.tieba.card.data.l.elC = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.fLT = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.fLT = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.fLT.setPageUniqueId(this.coa);
        this.fLT.setFrom("index");
        aVar.b(this.fLT);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.aaM);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.coa);
        a.a(this.Xs);
        a.bx(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (r.this.Xs != null) {
                        r.this.Xs.a(zVar.getView(), lVar);
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
            lVar.oo(lVar.position + 1);
            aVar.rx().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aQD().b(lVar.aQY());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.elx) {
                am amVar = new am("c11003");
                bg WO = lVar.WO();
                if (WO != null) {
                    amVar.bJ("tid", WO.getTid());
                    if (WO.YO() != null) {
                        amVar.T("ab_type", WO.YO().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aQD().b(amVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.rx() != null) {
                aVar.rx().setPage(this.YB);
            }
            aVar.a(lVar);
            aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.rx().a(this.Xs);
            com.baidu.tieba.q.c.cdp().a(this.coa, lVar.cZD != null ? lVar.cZD.getId() : null, com.baidu.tieba.q.a.a(lVar.cZD, "a002", "common_exp", lVar.aQN(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.ctx = lVar.tid;
            if (lVar.WO() != null) {
                zVar.ekN = String.valueOf(lVar.WO().getFid());
                if (lVar.WO().Zf() != null) {
                    zVar.hYC = lVar.WO().Zf().video_md5;
                    zVar.hYE = String.valueOf(lVar.WO().Zf().is_vertical);
                }
            }
            zVar.byE = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.hYB = lVar.aQO();
            zVar.hYz = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aQN());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLD = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YB = str;
    }

    public void onResume() {
        if (this.fLT != null) {
            this.fLT.onResume();
        }
    }

    public void onPause() {
        if (this.fLT != null) {
            this.fLT.onPause();
        }
    }
}
