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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> VB;
    private String WM;
    private com.baidu.adp.widget.ListView.r YY;
    private NEGFeedBackView.a cTD;
    public BdUniqueId cyA;
    private ac gfu;
    private com.baidu.tieba.homepage.personalize.model.e glI;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gfu != null && this.gfu.qV() != null && this.gfu.qV().ceV() != null) {
            if (view.getId() == this.gfu.qV().ceV().getId()) {
                TiebaStatic.log(lVar.Z(lVar.threadData));
                com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 4, lVar.baD(), false, (String) null, (String) null));
                TiebaStatic.log(lVar.baW());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.Z(lVar.threadData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cTD = null;
        this.VB = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.bat().gV(true);
                com.baidu.tieba.a.d.aCV().bJ("page_recommend", "show_");
                if (s.this.glI != null && lVar != null && lVar.acC() != null && !StringUtils.isNull(lVar.acC().getTid())) {
                    if (lVar.acC().bMr > 0) {
                        TiebaStatic.log(lVar.Z(lVar.acC()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dt(com.baidu.adp.lib.g.b.e(lVar.acC().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ds(com.baidu.adp.lib.g.b.e(lVar.acC().getTid(), 0L));
                        s.this.glI.a(com.baidu.adp.lib.g.b.e(lVar.acC().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.baD(), lVar.baE(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    s.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxU();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    private void bxU() {
        com.baidu.tieba.card.data.l.eHG = "c10708";
        com.baidu.tieba.card.data.l.eHH = "c10735";
        com.baidu.tieba.card.data.l.eHZ = "c10709";
        com.baidu.tieba.card.data.l.eHF = "c10734";
        com.baidu.tieba.card.data.l.eIa = "c11929";
        com.baidu.tieba.card.data.l.eIb = "c11928";
        com.baidu.tieba.card.data.l.eIc = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.gfu = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.gfu = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gfu.setPageUniqueId(this.cyA);
        this.gfu.setFrom("index");
        aVar.b(this.gfu);
        x a = aVar.a(false, viewGroup, this.YY);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cyA);
        a.a(this.VB);
        a.bq(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (s.this.VB != null) {
                        s.this.VB.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.qQ().b(new a.C0038a(1));
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
            lVar.pN(lVar.position + 1);
            aVar.qQ().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.bat().c(lVar.baP());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.eHY) {
                an anVar = new an("c11003");
                bh acC = lVar.acC();
                if (acC != null) {
                    anVar.bT("tid", acC.getTid());
                    if (acC.aeC() != null) {
                        anVar.P("ab_type", acC.aeC().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.bat().c(anVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.qQ() != null) {
                aVar.qQ().setPage(this.WM);
            }
            aVar.a(lVar);
            aVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qQ().a(this.VB);
            com.baidu.tieba.q.c.cpt().a(this.cyA, lVar.threadData != null ? lVar.threadData.getId() : null, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_exp", lVar.baD(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bXN = lVar.tid;
            if (lVar.acC() != null) {
                zVar.eHo = String.valueOf(lVar.acC().getFid());
                if (lVar.acC().aeT() != null) {
                    zVar.iAH = lVar.acC().aeT().video_md5;
                    zVar.iAJ = String.valueOf(lVar.acC().aeT().is_vertical);
                }
            }
            zVar.bHq = lVar.baG();
            zVar.mSource = lVar.getSource();
            zVar.iAG = lVar.baE();
            zVar.iAE = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baD());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glI = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    public void onResume() {
        if (this.gfu != null) {
            this.gfu.onResume();
        }
    }

    public void onPause() {
        if (this.gfu != null) {
            this.gfu.onPause();
        }
    }
}
