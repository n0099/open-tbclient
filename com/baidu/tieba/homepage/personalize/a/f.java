package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JE;
    private String Lg;
    private boolean Nj;
    private com.baidu.adp.widget.ListView.r Oq;
    public BdUniqueId dxg;
    private com.baidu.tieba.homepage.personalize.model.e hbj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Nj = true;
        this.JE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (view != null && f.this.hbj != null && kVar != null && kVar.axQ() != null && !StringUtils.isNull(kVar.axQ().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(kVar.axQ().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(kVar.axQ().getTid(), 0L));
                        f.this.hbj.a(com.baidu.adp.lib.f.b.toLong(kVar.axQ().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.btK(), kVar.btL(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.axQ().getBaijiahaoData());
                    }
                    f.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bNs();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Oq = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.btW());
            com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btW());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.btY());
            com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btY());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.btY());
            com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btY());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.btX());
            com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btX());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.Z("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.Z("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.Z("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.btZ());
            com.baidu.tieba.a.d.aVo().a("page_recommend", "clk_", kVar.btZ());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.cNb, this.dxg, kVar.btK(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFrom("index");
        rVar.setFromCDN(this.Nj);
        aVar.c(rVar);
        ad a = aVar.a(false, viewGroup, this.Oq);
        a.aM(2);
        af afVar = new af(a);
        afVar.setPageId(this.dxg);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (f.this.JE != null) {
                        f.this.JE.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cNb == null) {
            return null;
        }
        kVar.rm(kVar.position + 1);
        afVar.mU().setPosition(i);
        afVar.mU().setPage(this.Lg);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.JE);
        com.baidu.tieba.card.r.btA().c(kVar.btV());
        com.baidu.tieba.a.d.aVo().c(kVar.btV());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cNb, this.dxg, kVar.btK());
        return afVar.getView();
    }

    private void bNs() {
        com.baidu.tieba.card.data.k.fKg = "c10705";
        com.baidu.tieba.card.data.k.fKh = "c10730";
        com.baidu.tieba.card.data.k.fKi = "c10731";
        com.baidu.tieba.card.data.k.fKj = "c10704";
        com.baidu.tieba.card.data.k.fKk = "c10755";
        com.baidu.tieba.card.data.k.fKl = "c10710";
        com.baidu.tieba.card.data.k.fKm = "c10736";
        com.baidu.tieba.card.data.k.fKn = "c10737";
        com.baidu.tieba.card.data.k.fKo = "c10711";
        com.baidu.tieba.card.data.k.fKp = "c10758";
        com.baidu.tieba.card.data.k.fKq = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hbj = eVar;
    }
}
