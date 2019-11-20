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
    private ab<com.baidu.tieba.card.data.l> EP;
    private String Gc;
    private com.baidu.adp.widget.ListView.r Iu;
    public BdUniqueId cJo;
    private NEGFeedBackView.a dcg;
    private ac gdZ;
    private com.baidu.tieba.homepage.personalize.model.e gkp;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gdZ != null && this.gdZ.ma() != null && this.gdZ.ma().cbV() != null) {
            if (view.getId() == this.gdZ.ma().cbV().getId()) {
                TiebaStatic.log(lVar.X(lVar.caz));
                com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(lVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 4, lVar.baE(), false, (String) null, (String) null));
                TiebaStatic.log(lVar.baW());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.X(lVar.caz));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcg = null;
        this.EP = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.bau().gF(true);
                com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
                if (s.this.gkp != null && lVar != null && lVar.agG() != null && !StringUtils.isNull(lVar.agG().getTid())) {
                    if (lVar.agG().cdj > 0) {
                        TiebaStatic.log(lVar.X(lVar.agG()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cS(com.baidu.adp.lib.g.b.toLong(lVar.agG().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cR(com.baidu.adp.lib.g.b.toLong(lVar.agG().getTid(), 0L));
                        s.this.gkp.a(com.baidu.adp.lib.g.b.toLong(lVar.agG().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.baE(), lVar.baF(), com.baidu.adp.lib.g.b.toInt((String) view.getTag(), 1));
                    }
                    s.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buW();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Iu = rVar;
    }

    private void buW() {
        com.baidu.tieba.card.data.l.ePu = "c10708";
        com.baidu.tieba.card.data.l.ePv = "c10735";
        com.baidu.tieba.card.data.l.ePN = "c10709";
        com.baidu.tieba.card.data.l.ePt = "c10734";
        com.baidu.tieba.card.data.l.ePO = "c11929";
        com.baidu.tieba.card.data.l.ePP = "c11928";
        com.baidu.tieba.card.data.l.ePQ = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            this.gdZ = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            this.gdZ = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        this.gdZ.setPageUniqueId(this.cJo);
        this.gdZ.setFrom("index");
        aVar.b(this.gdZ);
        x a = aVar.a(false, viewGroup, this.Iu);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cJo);
        a.b(this.EP);
        a.aF(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (s.this.EP != null) {
                        s.this.EP.a(zVar.getView(), lVar);
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
            lVar.oO(lVar.position + 1);
            aVar.lV().setPosition(i);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.bau().c(lVar.baP());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.ePM) {
                an anVar = new an("c11003");
                bh agG = lVar.agG();
                if (agG != null) {
                    anVar.bS("tid", agG.getTid());
                    if (agG.aiE() != null) {
                        anVar.O(TiebaInitialize.Params.AB_TYPE, agG.aiE().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.bau().c(anVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.lV() != null) {
                aVar.lV().setPage(this.Gc);
            }
            aVar.a(lVar);
            aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.lV().b(this.EP);
            com.baidu.tieba.q.c.cni().a(this.cJo, lVar.caz != null ? lVar.caz.getId() : null, com.baidu.tieba.q.a.a(lVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", lVar.baE(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.cma = lVar.tid;
            if (lVar.agG() != null) {
                zVar.ePc = String.valueOf(lVar.agG().getFid());
                if (lVar.agG().aiV() != null) {
                    zVar.iyn = lVar.agG().aiV().video_md5;
                    zVar.iyp = String.valueOf(lVar.agG().aiV().is_vertical);
                }
            }
            zVar.bYk = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.iym = lVar.baF();
            zVar.iyk = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baE());
        }
        return zVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gkp = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    public void onResume() {
        if (this.gdZ != null) {
            this.gdZ.onResume();
        }
    }

    public void onPause() {
        if (this.gdZ != null) {
            this.gdZ.onPause();
        }
    }
}
