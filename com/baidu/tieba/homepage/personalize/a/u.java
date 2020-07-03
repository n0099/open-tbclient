package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private com.baidu.adp.widget.ListView.v ajy;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private com.baidu.tieba.homepage.personalize.model.e iti;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        return a2(i, view, viewGroup, kVar, (ak) akVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bOA().jI(true);
                com.baidu.tieba.a.d.boA().dh("page_recommend", "show_");
                if (view != null && u.this.iti != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eq(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ep(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L));
                        u.this.iti.a(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bOL(), kVar.bOM(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aPS().getBaijiahaoData());
                    }
                    u.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cjP();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        ao bOY;
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.ad(kVar.dLi)) {
                bOY = kVar.bPd();
                TiebaStatic.log(bOY);
            } else {
                bOY = kVar.bOY();
                TiebaStatic.log(bOY);
            }
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", bOY);
            i = 1;
        } else if (id == R.id.thread_card_voice) {
            TiebaStatic.log(kVar.bPc());
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPc());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bPa());
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPa());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bPa());
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPa());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bOZ());
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bOZ());
            i = 9;
        } else if (id == R.id.god_reply_voice_btn) {
            ao aoVar = new ao("c10760");
            aoVar.ag("obj_locate", 4);
            TiebaStatic.log(aoVar);
            i = 5;
        } else if (id == R.id.god_reply_content) {
            ao aoVar2 = new ao("c10760");
            aoVar2.ag("obj_locate", 2);
            TiebaStatic.log(aoVar2);
            i = 5;
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            i = 0;
        } else {
            ao aoVar3 = new ao("c10760");
            aoVar3.ag("obj_locate", 1);
            TiebaStatic.log(aoVar3);
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, this.eyE, kVar.bOL(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 1;
        cVar.dHw = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setStType("personalize_page");
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        alVar.bd(32);
        aVar.b(alVar);
        ai a = aVar.a(true, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.u.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (u.this.adX != null) {
                        u.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, final com.baidu.tieba.card.data.k kVar, ak akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        akVar.se().setPosition(i);
        akVar.se().setPage(this.afG);
        if (akVar.se().rY() instanceof al) {
            ((al) akVar.se().rY()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.personalize.a.u.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                        if (kVar.aPS() != null && kVar.aPS().aTe() != null) {
                            ao DS = kVar.DS(com.baidu.tieba.card.data.k.gUy);
                            DS.dk("obj_type", kVar.aPS().aTe().id);
                            DS.dk("obj_name", kVar.aPS().aTe().name);
                            TiebaStatic.log(DS);
                        }
                    }
                }
            });
        }
        akVar.a(!kVar.aPZ(), Align.ALIGN_RIGHT_BOTTOM, this.eTW);
        akVar.b((ak) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.card.s.bOA().e(kVar.bOX());
        com.baidu.tieba.a.d.boA().e(kVar.bOX());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, this.eyE, kVar.bOL());
        return akVar.getView();
    }

    private void cjP() {
        com.baidu.tieba.card.data.k.gUn = "c10730";
        com.baidu.tieba.card.data.k.gUo = "c10731";
        com.baidu.tieba.card.data.k.gUp = "c10704";
        com.baidu.tieba.card.data.k.gUq = "c10755";
        com.baidu.tieba.card.data.k.gUr = "c10710";
        com.baidu.tieba.card.data.k.gUs = "c10736";
        com.baidu.tieba.card.data.k.gUt = "c10737";
        com.baidu.tieba.card.data.k.gUu = "c10711";
        com.baidu.tieba.card.data.k.gUv = "c10758";
        com.baidu.tieba.card.data.k.gUw = "c10757";
        com.baidu.tieba.card.data.k.gUz = "c10734";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iti = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }
}
