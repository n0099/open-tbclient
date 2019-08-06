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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> VC;
    private String WN;
    private com.baidu.adp.widget.ListView.r YY;
    private NEGFeedBackView.a cSK;
    public BdUniqueId cxE;
    private ac gdC;
    private com.baidu.tieba.homepage.personalize.model.e gjQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gdC != null && this.gdC.qU() != null && this.gdC.qU().ceg() != null) {
            if (view.getId() == this.gdC.qU().ceg().getId()) {
                TiebaStatic.log(lVar.Y(lVar.threadData));
                com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 4, lVar.aZZ(), false, (String) null, (String) null));
                TiebaStatic.log(lVar.bas());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.Y(lVar.threadData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cSK = null;
        this.VC = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aZP().gS(true);
                com.baidu.tieba.a.d.aCH().bJ("page_recommend", "show_");
                if (s.this.gjQ != null && lVar != null && lVar.acy() != null && !StringUtils.isNull(lVar.acy().getTid())) {
                    if (lVar.acy().bLT > 0) {
                        TiebaStatic.log(lVar.Y(lVar.acy()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(lVar.acy().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(lVar.acy().getTid(), 0L));
                        s.this.gjQ.a(com.baidu.adp.lib.g.b.c(lVar.acy().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aZZ(), lVar.baa(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    s.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxg();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    private void bxg() {
        com.baidu.tieba.card.data.l.eFX = "c10708";
        com.baidu.tieba.card.data.l.eFY = "c10735";
        com.baidu.tieba.card.data.l.eGq = "c10709";
        com.baidu.tieba.card.data.l.eFW = "c10734";
        com.baidu.tieba.card.data.l.eGr = "c11929";
        com.baidu.tieba.card.data.l.eGs = "c11928";
        com.baidu.tieba.card.data.l.eGt = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.gdC = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.gdC = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gdC.setPageUniqueId(this.cxE);
        this.gdC.setFrom("index");
        aVar.b(this.gdC);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YY);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cxE);
        a.a(this.VC);
        a.bq(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (s.this.VC != null) {
                        s.this.VC.a(zVar.getView(), lVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.qP().b(new a.C0038a(1));
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
            lVar.pJ(lVar.position + 1);
            aVar.qP().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aZP().c(lVar.bal());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.eGp) {
                an anVar = new an("c11003");
                bh acy = lVar.acy();
                if (acy != null) {
                    anVar.bT("tid", acy.getTid());
                    if (acy.aey() != null) {
                        anVar.P("ab_type", acy.aey().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aZP().c(anVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.qP() != null) {
                aVar.qP().setPage(this.WN);
            }
            aVar.a(lVar);
            aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qP().a(this.VC);
            com.baidu.tieba.q.c.coG().a(this.cxE, lVar.threadData != null ? lVar.threadData.getId() : null, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_exp", lVar.aZZ(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bWU = lVar.tid;
            if (lVar.acy() != null) {
                zVar.eFF = String.valueOf(lVar.acy().getFid());
                if (lVar.acy().aeP() != null) {
                    zVar.iyF = lVar.acy().aeP().video_md5;
                    zVar.iyH = String.valueOf(lVar.acy().aeP().is_vertical);
                }
            }
            zVar.bGS = lVar.bac();
            zVar.mSource = lVar.getSource();
            zVar.iyE = lVar.baa();
            zVar.iyC = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aZZ());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gjQ = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    public void onResume() {
        if (this.gdC != null) {
            this.gdC.onResume();
        }
    }

    public void onPause() {
        if (this.gdC != null) {
            this.gdC.onPause();
        }
    }
}
