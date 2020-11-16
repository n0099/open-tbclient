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
/* loaded from: classes21.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> afK;
    private String ahw;
    private com.baidu.adp.widget.ListView.v alH;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    private com.baidu.tieba.homepage.personalize.model.e jFl;
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
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.cnT().lO(true);
                com.baidu.tieba.a.d.bIl().dL("page_recommend", "show_");
                if (view != null && v.this.jFl != null && kVar != null && kVar.bjd() != null && !StringUtils.isNull(kVar.bjd().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fV(com.baidu.adp.lib.f.b.toLong(kVar.bjd().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fU(com.baidu.adp.lib.f.b.toLong(kVar.bjd().getTid(), 0L));
                        v.this.jFl.a(com.baidu.adp.lib.f.b.toLong(kVar.bjd().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.cof(), kVar.cog(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bjd().getBaijiahaoData());
                    }
                    v.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        ar com2;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.ad(kVar.evQ)) {
                com2 = kVar.con();
                TiebaStatic.log(com2);
            } else {
                com2 = kVar.com();
                TiebaStatic.log(com2);
            }
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", com2);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.cow());
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cow());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.cou());
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cou());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.cou());
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cou());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.col());
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.col());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            ar arVar = new ar("c10760");
            arVar.ak("obj_locate", 4);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            ar arVar2 = new ar("c10760");
            arVar2.ak("obj_locate", 2);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            ar arVar3 = new ar("c10760");
            arVar3.ak("obj_locate", 1);
            TiebaStatic.log(arVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.evQ, this.fsa, kVar.cof(), i);
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
        dVar.exI = 1;
        dVar.exO = 1;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(1);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        anVar.bo(32);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.alH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.v.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (v.this.afK != null) {
                        v.this.afK.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.k kVar, am amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.evQ == null) {
            return null;
        }
        kVar.xH(kVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahw);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.v.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (kVar.bjd() != null && kVar.bjd().bmr() != null) {
                            ar IE = kVar.IE(com.baidu.tieba.card.data.k.icj);
                            IE.dR("obj_type", kVar.bjd().bmr().id);
                            IE.dR("obj_name", kVar.bjd().bmr().name);
                            TiebaStatic.log(IE);
                        }
                    }
                }
            });
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.fOM);
        amVar.b((am) kVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        com.baidu.tieba.card.t.cnT().e(kVar.coo());
        com.baidu.tieba.a.d.bIl().e(kVar.coo());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.evQ, this.fsa, kVar.cof());
        return amVar.getView();
    }

    private void cIA() {
        com.baidu.tieba.card.data.k.ibY = "c10730";
        com.baidu.tieba.card.data.k.ibZ = "c10731";
        com.baidu.tieba.card.data.k.ica = "c10704";
        com.baidu.tieba.card.data.k.icb = "c10755";
        com.baidu.tieba.card.data.k.icc = "c10710";
        com.baidu.tieba.card.data.k.icd = "c10736";
        com.baidu.tieba.card.data.k.ice = "c10737";
        com.baidu.tieba.card.data.k.icf = "c10711";
        com.baidu.tieba.card.data.k.icg = "c10758";
        com.baidu.tieba.card.data.k.ich = "c10757";
        com.baidu.tieba.card.data.k.ick = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jFl = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }
}
