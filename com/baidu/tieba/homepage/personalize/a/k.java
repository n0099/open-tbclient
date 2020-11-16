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
/* loaded from: classes21.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> afK;
    private String ahw;
    private boolean akn;
    private com.baidu.adp.widget.ListView.v alH;
    public BdUniqueId fsa;
    private com.baidu.tieba.homepage.personalize.model.e jFl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akn = true;
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.cnT().lO(true);
                com.baidu.tieba.a.d.bIl().dL("page_recommend", "show_");
                if (view != null && k.this.jFl != null && kVar != null && kVar.bjd() != null && !StringUtils.isNull(kVar.bjd().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fV(com.baidu.adp.lib.f.b.toLong(kVar.bjd().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fU(com.baidu.adp.lib.f.b.toLong(kVar.bjd().getTid(), 0L));
                        k.this.jFl.a(com.baidu.adp.lib.f.b.toLong(kVar.bjd().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.cof(), kVar.cog(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bjd().getBaijiahaoData());
                    }
                    k.this.b(view, kVar);
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
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.com());
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.com());
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
        } else if (id == R.id.god_reply_content) {
            ar arVar = new ar("c10760");
            arVar.ak("obj_locate", 2);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar2 = new ar("c10760");
            arVar2.ak("obj_locate", 1);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ar arVar3 = new ar("c10760");
                arVar3.ak("obj_locate", 3);
                TiebaStatic.log(arVar3);
            }
            TiebaStatic.log(kVar.cov());
            com.baidu.tieba.a.d.bIl().a("page_recommend", "clk_", kVar.cov());
            i = 3;
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
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
        zVar.setFrom("index");
        zVar.setFromCDN(this.akn);
        aVar.c(zVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.k.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (k.this.afK != null) {
                        k.this.afK.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.evQ == null) {
            return null;
        }
        kVar.xH(kVar.position + 1);
        amVar.tW().setPosition(i);
        amVar.tW().setPage(this.ahw);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        com.baidu.tieba.card.t.cnT().e(kVar.coo());
        com.baidu.tieba.a.d.bIl().e(kVar.coo());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.evQ, this.fsa, kVar.cof());
        return amVar.getView();
    }

    private void cIA() {
        com.baidu.tieba.card.data.k.ibX = "c10705";
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
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jFl = eVar;
    }
}
