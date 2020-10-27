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
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    private NEGFeedBackView.a fJp;
    public BdUniqueId fmX;
    private com.baidu.tieba.homepage.personalize.model.e jyq;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        return a2(i, view, viewGroup, lVar, (am) amVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.clQ().lE(true);
                com.baidu.tieba.a.d.bGs().dM("page_recommend", "show_");
                if (view != null && v.this.jyq != null && lVar != null && lVar.bhz() != null && !StringUtils.isNull(lVar.bhz().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fw(com.baidu.adp.lib.f.b.toLong(lVar.bhz().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fv(com.baidu.adp.lib.f.b.toLong(lVar.bhz().getTid(), 0L));
                        v.this.jyq.a(com.baidu.adp.lib.f.b.toLong(lVar.bhz().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.cmc(), lVar.cmd(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bhz().getBaijiahaoData());
                    }
                    v.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cGu();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        aq cmp;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.m.ab(lVar.erH)) {
                cmp = lVar.cmu();
                TiebaStatic.log(cmp);
            } else {
                cmp = lVar.cmp();
                TiebaStatic.log(cmp);
            }
            com.baidu.tieba.a.d.bGs().a("page_recommend", "clk_", cmp);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(lVar.cmt());
            com.baidu.tieba.a.d.bGs().a("page_recommend", "clk_", lVar.cmt());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.cmr());
            com.baidu.tieba.a.d.bGs().a("page_recommend", "clk_", lVar.cmr());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.cmr());
            com.baidu.tieba.a.d.bGs().a("page_recommend", "clk_", lVar.cmr());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.cmq());
            com.baidu.tieba.a.d.bGs().a("page_recommend", "clk_", lVar.cmq());
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
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.erH, this.fmX, lVar.cmc(), i);
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
        cVar.etA = 1;
        cVar.etG = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        anVar.bo(32);
        aVar.b(anVar);
        ak a2 = aVar.a(true, viewGroup, this.alD);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fmX);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.v.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (v.this.afF != null) {
                        v.this.afF.a(amVar2.getView(), lVar);
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
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.erH == null) {
            return null;
        }
        lVar.wW(lVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahu);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (lVar.bhz() != null && lVar.bhz().bkP() != null) {
                            aq IM = lVar.IM(com.baidu.tieba.card.data.l.hVu);
                            IM.dR("obj_type", lVar.bhz().bkP().id);
                            IM.dR("obj_name", lVar.bhz().bkP().name);
                            TiebaStatic.log(IM);
                        }
                    }
                }
            });
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.fJp);
        amVar.b((am) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        com.baidu.tieba.card.t.clQ().e(lVar.cmo());
        com.baidu.tieba.a.d.bGs().e(lVar.cmo());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.erH, this.fmX, lVar.cmc());
        return amVar.getView();
    }

    private void cGu() {
        com.baidu.tieba.card.data.l.hVj = "c10730";
        com.baidu.tieba.card.data.l.hVk = "c10731";
        com.baidu.tieba.card.data.l.hVl = "c10704";
        com.baidu.tieba.card.data.l.hVm = "c10755";
        com.baidu.tieba.card.data.l.hVn = "c10710";
        com.baidu.tieba.card.data.l.hVo = "c10736";
        com.baidu.tieba.card.data.l.hVp = "c10737";
        com.baidu.tieba.card.data.l.hVq = "c10711";
        com.baidu.tieba.card.data.l.hVr = "c10758";
        com.baidu.tieba.card.data.l.hVs = "c10757";
        com.baidu.tieba.card.data.l.hVv = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jyq = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fJp = aVar;
    }
}
