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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VC;
    private String WN;
    private com.baidu.adp.widget.ListView.r YY;
    private boolean Yd;
    public BdUniqueId cxE;
    private com.baidu.tieba.homepage.personalize.model.e gjQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Yd = true;
        this.VC = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aZP().gS(true);
                com.baidu.tieba.a.d.aCH().bJ("page_recommend", "show_");
                if (view != null && f.this.gjQ != null && kVar != null && kVar.acy() != null && !StringUtils.isNull(kVar.acy().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L));
                        f.this.gjQ.a(com.baidu.adp.lib.g.b.c(kVar.acy().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aZZ(), kVar.baa(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    f.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bxg();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bam());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bam());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bao());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bao());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bao());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bao());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.ban());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.ban());
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
            TiebaStatic.log(kVar.bap());
            com.baidu.tieba.a.d.aCH().a("page_recommend", "clk_", kVar.bap());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.coG().b(this.cxE, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aZZ(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFrom("index");
        rVar.setFromCDN(this.Yd);
        aVar.b(rVar);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YY);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cxE);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.f.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (f.this.VC != null) {
                        f.this.VC.a(zVar2.getView(), kVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.qP().b(new a.C0038a(1));
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
        kVar.pJ(kVar.position + 1);
        zVar.qP().setPosition(i);
        zVar.qP().setPage(this.WN);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        com.baidu.tieba.card.t.aZP().c(kVar.bal());
        com.baidu.tieba.a.d.aCH().c(kVar.bal());
        com.baidu.tieba.q.c.coG().a(this.cxE, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aZZ(), false, null, null));
        return zVar.getView();
    }

    private void bxg() {
        com.baidu.tieba.card.data.k.eFJ = "c10705";
        com.baidu.tieba.card.data.k.eFK = "c10730";
        com.baidu.tieba.card.data.k.eFL = "c10731";
        com.baidu.tieba.card.data.k.eFM = "c10704";
        com.baidu.tieba.card.data.k.eFN = "c10755";
        com.baidu.tieba.card.data.k.eFO = "c10710";
        com.baidu.tieba.card.data.k.eFP = "c10736";
        com.baidu.tieba.card.data.k.eFQ = "c10737";
        com.baidu.tieba.card.data.k.eFR = "c10711";
        com.baidu.tieba.card.data.k.eFS = "c10758";
        com.baidu.tieba.card.data.k.eFT = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gjQ = eVar;
    }
}
