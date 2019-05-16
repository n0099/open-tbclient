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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> Vj;
    private String Wt;
    private com.baidu.adp.widget.ListView.r YE;
    private NEGFeedBackView.a cRf;
    public BdUniqueId cwh;
    private ac fXM;
    private com.baidu.tieba.homepage.personalize.model.e gcL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.fXM != null && this.fXM.qx() != null && this.fXM.qx().caV() != null) {
            if (view.getId() == this.fXM.qx().caV().getId()) {
                TiebaStatic.log(lVar.X(lVar.threadData));
                com.baidu.tieba.q.c.clt().b(this.cwh, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 4, lVar.aXW(), false, (String) null, (String) null));
                TiebaStatic.log(lVar.aYo());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.X(lVar.threadData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRf = null;
        this.Vj = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aXM().gM(true);
                com.baidu.tieba.a.d.aBn().bJ("page_recommend", "show_");
                if (s.this.gcL != null && lVar != null && lVar.abv() != null && !StringUtils.isNull(lVar.abv().getTid())) {
                    if (lVar.abv().bKN > 0) {
                        TiebaStatic.log(lVar.X(lVar.abv()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dj(com.baidu.adp.lib.g.b.c(lVar.abv().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.di(com.baidu.adp.lib.g.b.c(lVar.abv().getTid(), 0L));
                        s.this.gcL.a(com.baidu.adp.lib.g.b.c(lVar.abv().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aXW(), lVar.aXX(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    s.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buk();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YE = rVar;
    }

    private void buk() {
        com.baidu.tieba.card.data.l.eAT = "c10708";
        com.baidu.tieba.card.data.l.eAU = "c10735";
        com.baidu.tieba.card.data.l.eBm = "c10709";
        com.baidu.tieba.card.data.l.eAS = "c10734";
        com.baidu.tieba.card.data.l.eBn = "c11929";
        com.baidu.tieba.card.data.l.eBo = "c11928";
        com.baidu.tieba.card.data.l.eBp = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.fXM = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.fXM = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.fXM.setPageUniqueId(this.cwh);
        this.fXM.setFrom("index");
        aVar.b(this.fXM);
        aVar.qq().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YE);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cwh);
        a.a(this.Vj);
        a.bq(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (s.this.Vj != null) {
                        s.this.Vj.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.qs().b(new a.C0038a(1));
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
            lVar.ps(lVar.position + 1);
            aVar.qs().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aXM().b(lVar.aYh());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.eBl) {
                am amVar = new am("c11003");
                bg abv = lVar.abv();
                if (abv != null) {
                    amVar.bT("tid", abv.getTid());
                    if (abv.adv() != null) {
                        amVar.P("ab_type", abv.adv().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aXM().b(amVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.qs() != null) {
                aVar.qs().setPage(this.Wt);
            }
            aVar.a(lVar);
            aVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qs().a(this.Vj);
            com.baidu.tieba.q.c.clt().a(this.cwh, lVar.threadData != null ? lVar.threadData.getId() : null, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_exp", lVar.aXW(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bVL = lVar.tid;
            if (lVar.abv() != null) {
                zVar.eAB = String.valueOf(lVar.abv().getFid());
                if (lVar.abv().adM() != null) {
                    zVar.iri = lVar.abv().adM().video_md5;
                    zVar.irk = String.valueOf(lVar.abv().adM().is_vertical);
                }
            }
            zVar.bFP = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.irh = lVar.aXX();
            zVar.irf = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aXW());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gcL = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    public void onResume() {
        if (this.fXM != null) {
            this.fXM.onResume();
        }
    }

    public void onPause() {
        if (this.fXM != null) {
            this.fXM.onPause();
        }
    }
}
