package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private boolean aik;
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private com.baidu.tieba.homepage.personalize.model.e iti;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.adX = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.bOA().jI(true);
                com.baidu.tieba.a.d.boA().dh("page_recommend", "show_");
                if (view != null && i.this.iti != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eq(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ep(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L));
                        i.this.iti.a(com.baidu.adp.lib.f.b.toLong(kVar.aPS().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bOL(), kVar.bOM(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aPS().getBaijiahaoData());
                    }
                    i.this.b(view, kVar);
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
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bOY());
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bOY());
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
        } else if (id == R.id.god_reply_content) {
            ao aoVar = new ao("c10760");
            aoVar.ag("obj_locate", 2);
            TiebaStatic.log(aoVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ao aoVar2 = new ao("c10760");
            aoVar2.ag("obj_locate", 1);
            TiebaStatic.log(aoVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ao aoVar3 = new ao("c10760");
                aoVar3.ag("obj_locate", 3);
                TiebaStatic.log(aoVar3);
            }
            TiebaStatic.log(kVar.bPb());
            com.baidu.tieba.a.d.boA().a("page_recommend", "clk_", kVar.bPb());
            i = 3;
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
        com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setFromCDN(this.aik);
        aVar.c(wVar);
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (i.this.adX != null) {
                        i.this.adX.a(akVar2.getView(), kVar);
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
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        akVar.se().setPosition(i);
        akVar.se().setPage(this.afG);
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.card.s.bOA().e(kVar.bOX());
        com.baidu.tieba.a.d.boA().e(kVar.bOX());
        com.baidu.card.w wVar = (com.baidu.card.w) akVar.se().rX();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) wVar.aeV.aiS.getLayoutParams();
        layoutParams.width = kVar.dLj;
        layoutParams.height = kVar.dLk;
        if (wVar.aeV.aiS.getVisibility() != 8) {
            wVar.aeV.aiS.setLayoutParams(layoutParams);
        }
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

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iti = eVar;
    }
}
