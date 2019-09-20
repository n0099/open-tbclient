package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VB;
    private String WM;
    private com.baidu.adp.widget.ListView.r YY;
    private boolean Yd;
    public BdUniqueId cyA;
    private com.baidu.tieba.homepage.personalize.model.e glI;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Yd = true;
        this.VB = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.bat().gV(true);
                com.baidu.tieba.a.d.aCV().bJ("page_recommend", "show_");
                if (view != null && d.this.glI != null && kVar != null && kVar.acC() != null && !StringUtils.isNull(kVar.acC().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dt(com.baidu.adp.lib.g.b.e(kVar.acC().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ds(com.baidu.adp.lib.g.b.e(kVar.acC().getTid(), 0L));
                        d.this.glI.a(com.baidu.adp.lib.g.b.e(kVar.acC().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.baD(), kVar.baE(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    d.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxU();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.baQ());
            com.baidu.tieba.a.d.aCV().a("page_recommend", "clk_", kVar.baQ());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aCV().a("page_recommend", "clk_", kVar.baS());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.baS());
            com.baidu.tieba.a.d.aCV().a("page_recommend", "clk_", kVar.baS());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.baR());
            com.baidu.tieba.a.d.aCV().a("page_recommend", "clk_", kVar.baR());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.P("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.P("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (view instanceof TbImageView) {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.P("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.baT());
            com.baidu.tieba.a.d.aCV().a("page_recommend", "clk_", kVar.baT());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.cpt().b(this.cyA, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.baD(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFrom("index");
        nVar.setFromCDN(this.Yd);
        aVar.b(nVar);
        x a = aVar.a(false, viewGroup, this.YY);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cyA);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.d.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (d.this.VB != null) {
                        d.this.VB.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qQ().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.threadData == null) {
            return null;
        }
        kVar.pN(kVar.position + 1);
        zVar.qQ().setPosition(i);
        zVar.qQ().setPage(this.WM);
        zVar.a(kVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.VB);
        com.baidu.tieba.card.t.bat().c(kVar.baP());
        com.baidu.tieba.a.d.aCV().c(kVar.baP());
        com.baidu.tieba.q.c.cpt().a(this.cyA, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.baD(), false, null, null));
        return zVar.getView();
    }

    private void bxU() {
        com.baidu.tieba.card.data.k.eHs = "c10705";
        com.baidu.tieba.card.data.k.eHt = "c10730";
        com.baidu.tieba.card.data.k.eHu = "c10731";
        com.baidu.tieba.card.data.k.eHv = "c10704";
        com.baidu.tieba.card.data.k.eHw = "c10755";
        com.baidu.tieba.card.data.k.eHx = "c10710";
        com.baidu.tieba.card.data.k.eHy = "c10736";
        com.baidu.tieba.card.data.k.eHz = "c10737";
        com.baidu.tieba.card.data.k.eHA = "c10711";
        com.baidu.tieba.card.data.k.eHB = "c10758";
        com.baidu.tieba.card.data.k.eHC = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glI = eVar;
    }
}
