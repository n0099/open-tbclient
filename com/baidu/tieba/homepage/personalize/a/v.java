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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    private NEGFeedBackView.a fWA;
    public BdUniqueId fzO;
    private com.baidu.tieba.homepage.personalize.model.e jSO;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        return a2(i, view, viewGroup, kVar, (am) amVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csg().mj(true);
                com.baidu.tieba.a.d.bLT().dS("page_recommend", "show_");
                if (view != null && v.this.jSO != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L));
                        v.this.jSO.a(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.css(), kVar.cst(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bmn().getBaijiahaoData());
                    }
                    v.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNP();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        ar csz;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.ad(kVar.eCR)) {
                csz = kVar.csA();
                TiebaStatic.log(csz);
            } else {
                csz = kVar.csz();
                TiebaStatic.log(csz);
            }
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", csz);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.csJ());
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csJ());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.csH());
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csH());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.csH());
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csH());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.csy());
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csy());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c10760");
            arVar.al("obj_locate", 4);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c10760");
            arVar2.al("obj_locate", 2);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            ar arVar3 = new ar("c10760");
            arVar3.al("obj_locate", 1);
            TiebaStatic.log(arVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.css(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 1;
        dVar.eEP = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(1);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        anVar.bs(32);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.v.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (v.this.agG != null) {
                        v.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.k kVar, am amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.tZ().setPage(this.aiw);
        if (amVar.tZ().tT() instanceof an) {
            ((an) amVar.tZ().tT()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (kVar.bmn() != null && kVar.bmn().bpE() != null) {
                            ar Ju = kVar.Ju(com.baidu.tieba.card.data.k.ing);
                            Ju.dY("obj_type", kVar.bmn().bpE().id);
                            Ju.dY("obj_name", kVar.bmn().bpE().name);
                            TiebaStatic.log(Ju);
                        }
                    }
                }
            });
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.fWA);
        amVar.b((am) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.card.t.csg().e(kVar.csB());
        com.baidu.tieba.a.d.bLT().e(kVar.csB());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.css());
        return amVar.getView();
    }

    private void cNP() {
        com.baidu.tieba.card.data.k.imV = "c10730";
        com.baidu.tieba.card.data.k.imW = "c10731";
        com.baidu.tieba.card.data.k.imX = "c10704";
        com.baidu.tieba.card.data.k.imY = "c10755";
        com.baidu.tieba.card.data.k.imZ = "c10710";
        com.baidu.tieba.card.data.k.ina = "c10736";
        com.baidu.tieba.card.data.k.inb = "c10737";
        com.baidu.tieba.card.data.k.inc = "c10711";
        com.baidu.tieba.card.data.k.ind = "c10758";
        com.baidu.tieba.card.data.k.ine = "c10757";
        com.baidu.tieba.card.data.k.inh = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jSO = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWA = aVar;
    }
}
