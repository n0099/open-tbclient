package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afE;
    private String aht;
    private com.baidu.adp.widget.ListView.v alC;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private com.baidu.tieba.homepage.personalize.model.e jlQ;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        return a2(i, view, viewGroup, lVar, (am) amVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afE = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.ciJ().lm(true);
                com.baidu.tieba.a.d.bEz().dF("page_recommend", "show_");
                if (view != null && u.this.jlQ != null && lVar != null && lVar.bfG() != null && !StringUtils.isNull(lVar.bfG().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fv(com.baidu.adp.lib.f.b.toLong(lVar.bfG().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fu(com.baidu.adp.lib.f.b.toLong(lVar.bfG().getTid(), 0L));
                        u.this.jlQ.a(com.baidu.adp.lib.f.b.toLong(lVar.bfG().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ciV(), lVar.ciW(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bfG().getBaijiahaoData());
                    }
                    u.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cDn();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alC = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        aq cji;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.m.ab(lVar.eji)) {
                cji = lVar.cjn();
                TiebaStatic.log(cji);
            } else {
                cji = lVar.cji();
                TiebaStatic.log(cji);
            }
            com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", cji);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(lVar.cjm());
            com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjm());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.cjk());
            com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjk());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.cjk());
            com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjk());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.cjj());
            com.baidu.tieba.a.d.bEz().a("page_recommend", "clk_", lVar.cjj());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c10760");
            aqVar.aj("obj_locate", 4);
            TiebaStatic.log(aqVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c10760");
            aqVar2.aj("obj_locate", 2);
            TiebaStatic.log(aqVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            aq aqVar3 = new aq("c10760");
            aqVar3.aj("obj_locate", 1);
            TiebaStatic.log(aqVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.eji, this.fey, lVar.ciV(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 1;
        cVar.elg = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        anVar.bo(32);
        aVar.b(anVar);
        ak a2 = aVar.a(true, viewGroup, this.alC);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fey);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.u.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (u.this.afE != null) {
                        u.this.afE.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.l lVar, am amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.eji == null) {
            return null;
        }
        lVar.wD(lVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.aht);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.u.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (lVar.bfG() != null && lVar.bfG().biW() != null) {
                            aq In = lVar.In(com.baidu.tieba.card.data.l.hIX);
                            In.dK("obj_type", lVar.bfG().biW().id);
                            In.dK("obj_name", lVar.bfG().biW().name);
                            TiebaStatic.log(In);
                        }
                    }
                }
            });
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.fAU);
        amVar.b((am) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afE);
        com.baidu.tieba.card.s.ciJ().e(lVar.cjh());
        com.baidu.tieba.a.d.bEz().e(lVar.cjh());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.eji, this.fey, lVar.ciV());
        return amVar.getView();
    }

    private void cDn() {
        com.baidu.tieba.card.data.l.hIM = "c10730";
        com.baidu.tieba.card.data.l.hIN = "c10731";
        com.baidu.tieba.card.data.l.hIO = "c10704";
        com.baidu.tieba.card.data.l.hIP = "c10755";
        com.baidu.tieba.card.data.l.hIQ = "c10710";
        com.baidu.tieba.card.data.l.hIR = "c10736";
        com.baidu.tieba.card.data.l.hIS = "c10737";
        com.baidu.tieba.card.data.l.hIT = "c10711";
        com.baidu.tieba.card.data.l.hIU = "c10758";
        com.baidu.tieba.card.data.l.hIV = "c10757";
        com.baidu.tieba.card.data.l.hIY = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jlQ = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fAU = aVar;
    }
}
