package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> Fq;
    private String GC;
    private boolean HY;
    public BdUniqueId cKf;
    private NEGFeedBackView.a dcY;
    private com.baidu.tieba.homepage.personalize.model.e glg;
    private com.baidu.tieba.card.m glx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.X(lVar.cbq));
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, lVar.baG(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.baT());
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.X(lVar.cbq));
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 4, lVar.baG(), false, (String) null, (String) null));
            TiebaStatic.log(lVar.baY());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.Y(lVar.cbq));
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, lVar.baG(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.Y(lVar.cbq));
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, lVar.baG(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.X(lVar.cbq));
            com.baidu.tieba.q.c.cnk().b(this.cKf, com.baidu.tieba.q.a.a(lVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 5, lVar.baG(), false, (String) null, (String) null));
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.O("obj_locate", 4);
            TiebaStatic.log(anVar);
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.O("obj_locate", 2);
            TiebaStatic.log(anVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.O("obj_locate", 1);
            TiebaStatic.log(anVar3);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            an anVar4 = new an("c10760");
            anVar4.O("obj_locate", 3);
            TiebaStatic.log(anVar4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcY = null;
        this.Fq = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.baw().gF(true);
                com.baidu.tieba.a.d.aDe().bO("page_recommend", "show_");
                if (t.this.glg != null && lVar != null && lVar.agI() != null && !StringUtils.isNull(lVar.agI().getTid())) {
                    if (lVar.agI().cea > 0) {
                        TiebaStatic.log(lVar.X(lVar.agI()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cT(com.baidu.adp.lib.g.b.toLong(lVar.agI().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cS(com.baidu.adp.lib.g.b.toLong(lVar.agI().getTid(), 0L));
                        t.this.glg.a(com.baidu.adp.lib.g.b.toLong(lVar.agI().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.baG(), lVar.baH(), com.baidu.adp.lib.g.b.toInt((String) view.getTag(), 1));
                    }
                    t.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        buY();
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
        ac bVar;
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cKf);
        dVar.aC(1024);
        aVar.c(dVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            bVar = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        bVar.setPageUniqueId(this.cKf);
        bVar.setFrom("index");
        aVar.b(bVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.HY);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bXQ = 1;
        dVar2.bXR = 2;
        dVar2.bXV = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.aL(2);
        aVar.a(aaVar);
        x lU = aVar.lU();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(lU);
        aVar2.setPageId(this.cKf);
        lU.b(this.Fq);
        lU.aF(2);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (t.this.Fq != null) {
                        t.this.Fq.a(zVar.getView(), lVar);
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
            com.baidu.card.s lW = aVar.lW();
            lW.a(this.dcY);
            lW.z(lVar.agK());
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcY = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glg = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    public void onDestroy() {
        if (this.glx != null) {
            this.glx.onDestroy();
        }
    }

    public void onPause() {
        if (this.glx != null) {
            this.glx.onPause();
        }
    }

    public void onResume() {
        if (this.glx != null) {
            this.glx.onResume();
        }
    }
}
