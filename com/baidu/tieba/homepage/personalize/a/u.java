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
/* loaded from: classes21.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afn;
    private String ahc;
    private com.baidu.adp.widget.ListView.v alj;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private com.baidu.tieba.homepage.personalize.model.e iWS;
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
        this.afn = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cfn().kO(true);
                com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
                if (view != null && u.this.iWS != null && lVar != null && lVar.bcY() != null && !StringUtils.isNull(lVar.bcY().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fd(com.baidu.adp.lib.f.b.toLong(lVar.bcY().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fc(com.baidu.adp.lib.f.b.toLong(lVar.bcY().getTid(), 0L));
                        u.this.iWS.a(com.baidu.adp.lib.f.b.toLong(lVar.bcY().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.cfz(), lVar.cfA(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bcY().getBaijiahaoData());
                    }
                    u.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        czJ();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alj = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        aq cfM;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.m.ab(lVar.dXg)) {
                cfM = lVar.cfR();
                TiebaStatic.log(cfM);
            } else {
                cfM = lVar.cfM();
                TiebaStatic.log(cfM);
            }
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", cfM);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(lVar.cfQ());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfQ());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.cfO());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfO());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.cfO());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfO());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.cfN());
            com.baidu.tieba.a.d.bBN().a("page_recommend", "clk_", lVar.cfN());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            aq aqVar = new aq("c10760");
            aqVar.ai("obj_locate", 4);
            TiebaStatic.log(aqVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            aq aqVar2 = new aq("c10760");
            aqVar2.ai("obj_locate", 2);
            TiebaStatic.log(aqVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            aq aqVar3 = new aq("c10760");
            aqVar3.ai("obj_locate", 1);
            TiebaStatic.log(aqVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, this.eSq, lVar.cfz(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 1;
        cVar.dZe = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        anVar.bo(32);
        aVar.b(anVar);
        ak a = aVar.a(true, viewGroup, this.alj);
        a.setSourceForPb(2);
        am amVar = new am(a);
        amVar.setPageId(this.eSq);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.u.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (u.this.afn != null) {
                        u.this.afn.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.l lVar, am amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.dXg == null) {
            return null;
        }
        lVar.vX(lVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahc);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.u.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (lVar.bcY() != null && lVar.bcY().bgn() != null) {
                            aq HA = lVar.HA(com.baidu.tieba.card.data.l.huc);
                            HA.dF("obj_type", lVar.bcY().bgn().id);
                            HA.dF("obj_name", lVar.bcY().bgn().name);
                            TiebaStatic.log(HA);
                        }
                    }
                }
            });
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.foG);
        amVar.b((am) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.card.s.cfn().e(lVar.cfL());
        com.baidu.tieba.a.d.bBN().e(lVar.cfL());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dXg, this.eSq, lVar.cfz());
        return amVar.getView();
    }

    private void czJ() {
        com.baidu.tieba.card.data.l.htR = "c10730";
        com.baidu.tieba.card.data.l.htS = "c10731";
        com.baidu.tieba.card.data.l.htT = "c10704";
        com.baidu.tieba.card.data.l.htU = "c10755";
        com.baidu.tieba.card.data.l.htV = "c10710";
        com.baidu.tieba.card.data.l.htW = "c10736";
        com.baidu.tieba.card.data.l.htX = "c10737";
        com.baidu.tieba.card.data.l.htY = "c10711";
        com.baidu.tieba.card.data.l.htZ = "c10758";
        com.baidu.tieba.card.data.l.hua = "c10757";
        com.baidu.tieba.card.data.l.hud = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iWS = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }
}
