package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private boolean NK;
    private com.baidu.adp.widget.ListView.r OT;
    public BdUniqueId dBK;
    private com.baidu.tieba.homepage.personalize.model.e heO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.NK = true;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bvm().id(true);
                com.baidu.tieba.a.d.aXK().cu("page_recommend", "show_");
                if (view != null && i.this.heO != null && kVar != null && kVar.aAj() != null && !StringUtils.isNull(kVar.aAj().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(kVar.aAj().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(kVar.aAj().getTid(), 0L));
                        i.this.heO.a(com.baidu.adp.lib.f.b.toLong(kVar.aAj().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bvw(), kVar.bvx(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aAj().getBaijiahaoData());
                    }
                    i.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OT = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bvI());
            com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvI());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bvK());
            com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvK());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bvK());
            com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvK());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bvJ());
            com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvJ());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.X("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.X("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.X("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.bvL());
            com.baidu.tieba.a.d.aXK().a("page_recommend", "clk_", kVar.bvL());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRt, this.dBK, kVar.bvw(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("index");
        uVar.setFromCDN(this.NK);
        aVar.c(uVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.OT);
        a.aQ(2);
        af afVar = new af(a);
        afVar.setPageId(this.dBK);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (i.this.JZ != null) {
                        i.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRt == null) {
            return null;
        }
        kVar.rv(kVar.position + 1);
        afVar.nk().setPosition(i);
        afVar.nk().setPage(this.LC);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.card.r.bvm().e(kVar.bvH());
        com.baidu.tieba.a.d.aXK().e(kVar.bvH());
        com.baidu.card.u uVar = (com.baidu.card.u) afVar.nk().nd();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) uVar.KU.Ox.getLayoutParams();
        layoutParams.width = kVar.cRu;
        layoutParams.height = kVar.cRv;
        if (uVar.KU.Ox.getVisibility() != 8) {
            uVar.KU.Ox.setLayoutParams(layoutParams);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cRt, this.dBK, kVar.bvw());
        return afVar.getView();
    }

    private void bPl() {
        com.baidu.tieba.card.data.k.fNz = "c10705";
        com.baidu.tieba.card.data.k.fNA = "c10730";
        com.baidu.tieba.card.data.k.fNB = "c10731";
        com.baidu.tieba.card.data.k.fNC = "c10704";
        com.baidu.tieba.card.data.k.fND = "c10755";
        com.baidu.tieba.card.data.k.fNE = "c10710";
        com.baidu.tieba.card.data.k.fNF = "c10736";
        com.baidu.tieba.card.data.k.fNG = "c10737";
        com.baidu.tieba.card.data.k.fNH = "c10711";
        com.baidu.tieba.card.data.k.fNI = "c10758";
        com.baidu.tieba.card.data.k.fNJ = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.heO = eVar;
    }
}
