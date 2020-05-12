package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> ada;
    private String aeB;
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private com.baidu.tieba.homepage.personalize.model.e hOH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ada = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bEX().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                if (view != null && y.this.hOH != null && kVar != null && kVar.aIu() != null && !StringUtils.isNull(kVar.aIu().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(kVar.aIu().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(kVar.aIu().getTid(), 0L));
                        y.this.hOH.a(com.baidu.adp.lib.f.b.toLong(kVar.aIu().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bFg(), kVar.bFh(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aIu().getBaijiahaoData());
                    }
                    y.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZL();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahy = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.ab(kVar.dqE)) {
                TiebaStatic.log(kVar.bFx());
            } else {
                TiebaStatic.log(kVar.bFs());
            }
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFs());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bFu());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFu());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bFu());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFu());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bFt());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFt());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.af("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.af("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.af("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.bFv());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFv());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqE, this.ebA, kVar.bFg(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebA);
        eVar.aX(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.y.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.ahy);
        a.bc(2);
        af afVar = new af(a);
        afVar.setPageId(this.ebA);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.y.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (y.this.ada != null) {
                        y.this.ada.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqE == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        afVar.rD().setPosition(i);
        afVar.rD().setPage(this.aeB);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        com.baidu.tieba.card.r.bEX().e(kVar.bFr());
        com.baidu.tieba.a.d.bfN().e(kVar.bFr());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqE, this.ebA, kVar.bFg());
        return afVar.getView();
    }

    private void bZL() {
        com.baidu.tieba.card.data.k.gsn = "c10730";
        com.baidu.tieba.card.data.k.gso = "c10731";
        com.baidu.tieba.card.data.k.gsp = "c10704";
        com.baidu.tieba.card.data.k.gsq = "c10755";
        com.baidu.tieba.card.data.k.gsr = "c10710";
        com.baidu.tieba.card.data.k.gss = "c10736";
        com.baidu.tieba.card.data.k.gst = "c10737";
        com.baidu.tieba.card.data.k.gsu = "c10711";
        com.baidu.tieba.card.data.k.gsv = "c10758";
        com.baidu.tieba.card.data.k.gsw = "c10757";
        com.baidu.tieba.card.data.k.gsz = "c10734";
        com.baidu.tieba.card.data.k.gsA = "c10708";
        com.baidu.tieba.card.data.k.gsB = "c10735";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOH = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }
}
