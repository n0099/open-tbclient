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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> VC;
    private String WN;
    private boolean Yd;
    private NEGFeedBackView.a cSD;
    public BdUniqueId cxx;
    private com.baidu.tieba.homepage.personalize.model.e gja;
    private com.baidu.tieba.card.m gjr;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        int id = view.getId();
        if (id == R.id.thread_card_root) {
            TiebaStatic.log(lVar.X(lVar.threadData));
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 1, lVar.aZX(), false, (String) null, (String) null));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.bal());
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(lVar.X(lVar.threadData));
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 4, lVar.aZX(), false, (String) null, (String) null));
            TiebaStatic.log(lVar.baq());
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.Y(lVar.threadData));
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 2, lVar.aZX(), false, (String) null, (String) null));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.Y(lVar.threadData));
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 2, lVar.aZX(), false, (String) null, (String) null));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.X(lVar.threadData));
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_click", 5, lVar.aZX(), false, (String) null, (String) null));
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
        this.cSD = null;
        this.VC = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.aZN().gS(true);
                com.baidu.tieba.a.d.aCF().bJ("page_recommend", "show_");
                if (t.this.gja != null && lVar != null && lVar.acx() != null && !StringUtils.isNull(lVar.acx().getTid())) {
                    if (lVar.acx().bLO > 0) {
                        TiebaStatic.log(lVar.X(lVar.acx()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(lVar.acx().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(lVar.acx().getTid(), 0L));
                        t.this.gja.a(com.baidu.adp.lib.g.b.c(lVar.acx().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aZX(), lVar.aZY(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    t.this.a(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bwS();
    }

    private void bwS() {
        com.baidu.tieba.card.data.l.eFQ = "c10708";
        com.baidu.tieba.card.data.l.eFR = "c10735";
        com.baidu.tieba.card.data.l.eGj = "c10709";
        com.baidu.tieba.card.data.l.eFP = "c10734";
        com.baidu.tieba.card.data.l.eGk = "c11929";
        com.baidu.tieba.card.data.l.eGl = "c11928";
        com.baidu.tieba.card.data.l.eGm = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        ac bVar;
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cxx);
        dVar.bn(1024);
        aVar.c(dVar);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            bVar = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        } else {
            bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        }
        bVar.setPageUniqueId(this.cxx);
        bVar.setFrom("index");
        aVar.b(bVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFz = 1;
        dVar2.bFA = 2;
        dVar2.bFE = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        x qO = aVar.qO();
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(qO);
        aVar2.setPageId(this.cxx);
        qO.a(this.VC);
        qO.bq(2);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (t.this.VC != null) {
                        t.this.VC.a(zVar.getView(), lVar);
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
            lVar.pI(lVar.position + 1);
            lVar.sourceType = 0;
            com.baidu.tieba.card.t.aZN().c(lVar.baj());
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.eGi) {
                an anVar = new an("c11003");
                bg acx = lVar.acx();
                if (acx != null) {
                    anVar.bT("tid", acx.getTid());
                    if (acx.aex() != null) {
                        anVar.P("ab_type", acx.aex().hadConcerned() ? 1 : 0);
                    }
                }
                com.baidu.tieba.card.t.aZN().c(anVar);
            }
            aVar.setVideoStatsData(c(lVar));
            if (aVar.qP() != null) {
                aVar.qP().setPage(this.WN);
            }
            com.baidu.card.s qQ = aVar.qQ();
            qQ.a(this.cSD);
            qQ.C(lVar.acz());
            aVar.a(lVar);
            aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qP().a(this.VC);
            com.baidu.tieba.q.c.coo().a(this.cxx, lVar.threadData != null ? lVar.threadData.getId() : null, com.baidu.tieba.q.a.a(lVar.threadData, "a002", "common_exp", lVar.aZX(), false, null, null));
            return aVar.getView();
        }
        return null;
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bWO = lVar.tid;
            if (lVar.acx() != null) {
                zVar.eFy = String.valueOf(lVar.acx().getFid());
                if (lVar.acx().aeO() != null) {
                    zVar.ixC = lVar.acx().aeO().video_md5;
                    zVar.ixE = String.valueOf(lVar.acx().aeO().is_vertical);
                }
            }
            zVar.bGR = lVar.baa();
            zVar.mSource = lVar.getSource();
            zVar.ixB = lVar.aZY();
            zVar.ixz = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aZX());
        }
        return zVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSD = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gja = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void onDestroy() {
        if (this.gjr != null) {
            this.gjr.onDestroy();
        }
    }

    public void onPause() {
        if (this.gjr != null) {
            this.gjr.onPause();
        }
    }

    public void onResume() {
        if (this.gjr != null) {
            this.gjr.onResume();
        }
    }
}
