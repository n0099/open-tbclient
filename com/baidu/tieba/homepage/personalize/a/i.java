package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private boolean alo;
    private com.baidu.adp.widget.ListView.v amH;
    public BdUniqueId fzO;
    private com.baidu.tieba.homepage.personalize.model.e jSO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alo = true;
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csg().mj(true);
                com.baidu.tieba.a.d.bLT().dS("page_recommend", "show_");
                if (view != null && i.this.jSO != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L));
                        i.this.jSO.a(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.css(), kVar.cst(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bmn().getBaijiahaoData());
                    }
                    i.this.b(view, kVar);
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
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.csz());
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csz());
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
        } else if (id == R.id.god_reply_content) {
            ar arVar = new ar("c10760");
            arVar.al("obj_locate", 2);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar2 = new ar("c10760");
            arVar2.al("obj_locate", 1);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ar arVar3 = new ar("c10760");
                arVar3.al("obj_locate", 3);
                TiebaStatic.log(arVar3);
            }
            TiebaStatic.log(kVar.csI());
            com.baidu.tieba.a.d.bLT().a("page_recommend", "clk_", kVar.csI());
            i = 3;
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
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("index");
        vVar.setFromCDN(this.alo);
        aVar.c(vVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (i.this.agG != null) {
                        i.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.tZ().setPage(this.aiw);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.card.t.csg().e(kVar.csB());
        com.baidu.tieba.a.d.bLT().e(kVar.csB());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.css());
        return amVar.getView();
    }

    private void cNP() {
        com.baidu.tieba.card.data.k.imU = "c10705";
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
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jSO = eVar;
    }
}
