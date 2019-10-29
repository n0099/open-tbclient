package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
    private ab<com.baidu.tieba.card.data.l> Fq;
    private String GC;
    private com.baidu.adp.widget.ListView.r IY;
    public BdUniqueId cKf;
    private NEGFeedBackView.a dcY;
    private ac geR;
    private com.baidu.tieba.homepage.personalize.model.e glg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.geR != null && this.geR.ma() != null && this.geR.ma().cbX() != null) {
            if (view.getId() == this.geR.ma().cbX().getId()) {
                TiebaStatic.log(lVar.X(lVar.cbq));
                com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 4, lVar.baG(), false, (String) null, (String) null));
                TiebaStatic.log(lVar.baY());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.X(lVar.cbq));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcY = null;
        this.Fq = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.baw().gF(true);
                com.baidu.tieba.a.d.aDe().bO("page_recommend", "show_");
                if (s.this.glg != null && lVar != null && lVar.agI() != null && !StringUtils.isNull(lVar.agI().getTid())) {
                    if (lVar.agI().cea > 0) {
                        TiebaStatic.log(lVar.X(lVar.agI()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cT(com.baidu.adp.lib.g.b.toLong(lVar.agI().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cS(com.baidu.adp.lib.g.b.toLong(lVar.agI().getTid(), 0L));
                        s.this.glg.a(com.baidu.adp.lib.g.b.toLong(lVar.agI().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.baG(), lVar.baH(), com.baidu.adp.lib.g.b.toInt((String) view.getTag(), 1));
                    }
                    s.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buY();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.IY = rVar;
    }

    private void buY() {
        com.baidu.tieba.card.data.l.eQl = "c10708";
        com.baidu.tieba.card.data.l.eQm = "c10735";
        com.baidu.tieba.card.data.l.eQE = "c10709";
        com.baidu.tieba.card.data.l.eQk = "c10734";
        com.baidu.tieba.card.data.l.eQF = "c11929";
        com.baidu.tieba.card.data.l.eQG = "c11928";
        com.baidu.tieba.card.data.l.eQH = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.geR = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.geR = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.geR.setPageUniqueId(this.cKf);
        this.geR.setFrom("index");
        aVar.b(this.geR);
        x a = aVar.a(false, viewGroup, this.IY);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cKf);
        a.b(this.Fq);
        a.aF(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (s.this.Fq != null) {
                        s.this.Fq.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false);
                    zVar.lV().b(new a.C0044a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar != null) {
            lVar.oP(lVar.position + 1);
            aVar.lV().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.baw().c(lVar.baR());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.eQD) {
                an anVar = new an("c11003");
                bh agI = lVar.agI();
                if (agI != null) {
                    anVar.bS("tid", agI.getTid());
                    if (agI.aiG() != null) {
                        anVar.O(TiebaInitialize.Params.AB_TYPE, agI.aiG().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.baw().c(anVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.lV() != null) {
                aVar.lV().setPage(this.GC);
            }
            aVar.a(lVar);
            aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.lV().b(this.Fq);
            com.baidu.tieba.q.c.cnk().a(this.cKf, lVar.cbq != null ? lVar.cbq.getId() : null, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", lVar.baG(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.cmS = lVar.tid;
            if (lVar.agI() != null) {
                zVar.ePT = String.valueOf(lVar.agI().getFid());
                if (lVar.agI().aiX() != null) {
                    zVar.ize = lVar.agI().aiX().video_md5;
                    zVar.izg = String.valueOf(lVar.agI().aiX().is_vertical);
                }
            }
            zVar.bZb = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.izd = lVar.baH();
            zVar.izb = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baG());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glg = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    public void onResume() {
        if (this.geR != null) {
            this.geR.onResume();
        }
    }

    public void onPause() {
        if (this.geR != null) {
            this.geR.onPause();
        }
    }
}
