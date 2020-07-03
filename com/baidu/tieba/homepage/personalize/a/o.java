package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class o extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private boolean aik;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eTW = null;
        this.aik = true;
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 1;
                com.baidu.tieba.card.s.bOA().jI(true);
                com.baidu.tieba.a.d.boA().dh("page_recommend", "show_");
                if (kVar != null && kVar.aPS() != null && !ar.isEmpty(kVar.aPS().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(kVar.bOY());
                        com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bOY());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.bOY());
                        com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bOY());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.bPc());
                        com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPc());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.bPa());
                        com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPa());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.bPa());
                        com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPa());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.bOZ());
                        com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bOZ());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        ao aoVar = new ao("c10760");
                        aoVar.ag("obj_locate", 4);
                        TiebaStatic.log(aoVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        ao aoVar2 = new ao("c10760");
                        aoVar2.ag("obj_locate", 2);
                        TiebaStatic.log(aoVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                ao aoVar3 = new ao("c10760");
                                aoVar3.ag("obj_locate", 3);
                                TiebaStatic.log(aoVar3);
                            }
                            TiebaStatic.log(kVar.bPb());
                            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPb());
                        }
                        i = 0;
                    } else {
                        ao aoVar4 = new ao("c10760");
                        aoVar4.ag("obj_locate", 1);
                        TiebaStatic.log(aoVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, o.this.eyE, kVar.bOL(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cjP();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eyE);
        eVar.be(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.o.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        aVar.c(new com.baidu.card.r(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aik);
        lVar.setForm("index");
        lVar.a(new ao("c13342"));
        aVar.a((com.baidu.card.h) lVar);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 1;
        cVar.dHw = 1;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(1);
        alVar.setShareReportFrom(3);
        alVar.setFromForPb(2);
        aVar.b(alVar);
        ai sd = aVar.sd();
        sd.setSourceForPb(2);
        ak<com.baidu.tieba.card.data.k> akVar = new ak<>(sd);
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.o.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (o.this.adX != null) {
                        o.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 2, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.se() == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        com.baidu.tieba.card.s.bOA().e(kVar.DV("c12190"));
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        com.baidu.card.z aI = akVar.aI(true);
        aI.a(this.eTW);
        akVar.a(kVar.aQc(), this.ilu);
        aI.D(kVar.aPU());
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.b(this.adX);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dLi, this.eyE, kVar.bOL());
        return akVar.getView();
    }

    private void cjP() {
        com.baidu.tieba.card.data.k.gUm = "c10705";
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
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }
}
