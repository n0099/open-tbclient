package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
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
/* loaded from: classes16.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private NEGFeedBackView.a flJ;
    private com.baidu.tieba.homepage.personalize.model.e iOg;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        return a2(i, view, viewGroup, lVar, (al) alVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                if (view != null && u.this.iOg != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eP(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eO(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L));
                        u.this.iOg.a(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ccj(), lVar.cck(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bce().getBaijiahaoData());
                    }
                    u.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyk();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        aq ccw;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.m.aa(lVar.dUS)) {
                ccw = lVar.ccB();
                TiebaStatic.log(ccw);
            } else {
                ccw = lVar.ccw();
                TiebaStatic.log(ccw);
            }
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", ccw);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(lVar.ccA());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccA());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ccy());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccy());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ccy());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccy());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.ccx());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccx());
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
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 1;
        cVar.dWQ = 1;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(1);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        amVar.bk(32);
        aVar.b(amVar);
        aj a = aVar.a(true, viewGroup, this.akI);
        a.setSourceForPb(2);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.u.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (u.this.aeT != null) {
                        u.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.l lVar, al alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.tR().setPage(this.agH);
        if (alVar.tR().tL() instanceof am) {
            ((am) alVar.tR().tL()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.u.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (lVar.bce() != null && lVar.bce().bft() != null) {
                            aq Hc = lVar.Hc(com.baidu.tieba.card.data.l.hmV);
                            Hc.dD("obj_type", lVar.bce().bft().id);
                            Hc.dD("obj_name", lVar.bce().bft().name);
                            TiebaStatic.log(Hc);
                        }
                    }
                }
            });
        }
        alVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.flJ);
        alVar.b((al) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        com.baidu.tieba.card.s.cbX().e(lVar.ccv());
        com.baidu.tieba.a.d.bAA().e(lVar.ccv());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj());
        return alVar.getView();
    }

    private void cyk() {
        com.baidu.tieba.card.data.l.hmK = "c10730";
        com.baidu.tieba.card.data.l.hmL = "c10731";
        com.baidu.tieba.card.data.l.hmM = "c10704";
        com.baidu.tieba.card.data.l.hmN = "c10755";
        com.baidu.tieba.card.data.l.hmO = "c10710";
        com.baidu.tieba.card.data.l.hmP = "c10736";
        com.baidu.tieba.card.data.l.hmQ = "c10737";
        com.baidu.tieba.card.data.l.hmR = "c10711";
        com.baidu.tieba.card.data.l.hmS = "c10758";
        com.baidu.tieba.card.data.l.hmT = "c10757";
        com.baidu.tieba.card.data.l.hmW = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iOg = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flJ = aVar;
    }
}
