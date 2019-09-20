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
    private ab<com.baidu.tieba.card.data.l> VB;
    private String WM;
    private boolean Yd;
    private NEGFeedBackView.a cTD;
    public BdUniqueId cyA;
    private com.baidu.tieba.homepage.personalize.model.e glI;
    private com.baidu.tieba.card.m glZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.Z(lVar.threadData));
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 1, lVar.baD(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.baR());
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.Z(lVar.threadData));
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 4, lVar.baD(), false, (String) null, (String) null));
            TiebaStatic.log(lVar.baW());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.aa(lVar.threadData));
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 2, lVar.baD(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.aa(lVar.threadData));
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 2, lVar.baD(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.Z(lVar.threadData));
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 5, lVar.baD(), false, (String) null, (String) null));
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c10760");
            anVar.P("obj_locate", 4);
            TiebaStatic.log(anVar);
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c10760");
            anVar2.P("obj_locate", 2);
            TiebaStatic.log(anVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c10760");
            anVar3.P("obj_locate", 1);
            TiebaStatic.log(anVar3);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            an anVar4 = new an("c10760");
            anVar4.P("obj_locate", 3);
            TiebaStatic.log(anVar4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cTD = null;
        this.VB = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.bat().gV(true);
                com.baidu.tieba.a.d.aCV().bJ("page_recommend", "show_");
                if (t.this.glI != null && lVar != null && lVar.acC() != null && !StringUtils.isNull(lVar.acC().getTid())) {
                    if (lVar.acC().bMr > 0) {
                        TiebaStatic.log(lVar.Z(lVar.acC()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dt(com.baidu.adp.lib.g.b.e(lVar.acC().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ds(com.baidu.adp.lib.g.b.e(lVar.acC().getTid(), 0L));
                        t.this.glI.a(com.baidu.adp.lib.g.b.e(lVar.acC().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.baD(), lVar.baE(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    t.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxU();
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
        ac bVar;
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cyA);
        dVar.bn(1024);
        aVar.c(dVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            bVar = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        bVar.setPageUniqueId(this.cyA);
        bVar.setFrom("index");
        aVar.b(bVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFY = 1;
        dVar2.bFZ = 2;
        dVar2.bGd = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        x qP = aVar.qP();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(qP);
        aVar2.setPageId(this.cyA);
        qP.a(this.VB);
        qP.bq(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (t.this.VB != null) {
                        t.this.VB.a(zVar.getView(), lVar);
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
            com.baidu.card.s qR = aVar.qR();
            qR.a(this.cTD);
            qR.C(lVar.acE());
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cTD = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glI = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void onDestroy() {
        if (this.glZ != null) {
            this.glZ.onDestroy();
        }
    }

    public void onPause() {
        if (this.glZ != null) {
            this.glZ.onPause();
        }
    }

    public void onResume() {
        if (this.glZ != null) {
            this.glZ.onResume();
        }
    }
}
