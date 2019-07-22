package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> VC;
    private String WN;
    private com.baidu.adp.widget.ListView.r YY;
    private NEGFeedBackView.a cSD;
    public BdUniqueId cxx;
    private com.baidu.tieba.homepage.personalize.model.e gja;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VC = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aZN().gS(true);
                com.baidu.tieba.a.d.aCF().bJ("page_recommend", "show_");
                if (view != null && r.this.gja != null && kVar != null && kVar.acx() != null && !StringUtils.isNull(kVar.acx().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dq(com.baidu.adp.lib.g.b.c(kVar.acx().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dp(com.baidu.adp.lib.g.b.c(kVar.acx().getTid(), 0L));
                        r.this.gja.a(com.baidu.adp.lib.g.b.c(kVar.acx().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aZX(), kVar.aZY(), com.baidu.adp.lib.g.b.f((String) view.getTag(), 1));
                    }
                    r.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bwS();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.YY = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            if (com.baidu.tieba.card.data.l.V(kVar.threadData)) {
                TiebaStatic.log(kVar.bap());
            } else {
                TiebaStatic.log(kVar.bak());
            }
            com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", kVar.bak());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bam());
            com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", kVar.bam());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bam());
            com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", kVar.bam());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bal());
            com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", kVar.bal());
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
            TiebaStatic.log(kVar.ban());
            com.baidu.tieba.a.d.aCF().a("page_recommend", "clk_", kVar.ban());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.coo().b(this.cxx, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aZX(), false, (String) null, (String) null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cxx);
        dVar.bn(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.card.d.a
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
        aVar.c(dVar);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YY);
        a.bq(2);
        z zVar = new z(a);
        zVar.setPageId(this.cxx);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.r.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (r.this.VC != null) {
                        r.this.VC.a(zVar2.getView(), kVar);
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
        kVar.pI(kVar.position + 1);
        zVar.qP().setPosition(i);
        zVar.qP().setPage(this.WN);
        zVar.qQ().a(this.cSD);
        zVar.a(kVar);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.VC);
        com.baidu.tieba.card.t.aZN().c(kVar.baj());
        com.baidu.tieba.a.d.aCF().c(kVar.baj());
        com.baidu.tieba.q.c.coo().a(this.cxx, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aZX(), false, null, null));
        return zVar.getView();
    }

    private void bwS() {
        com.baidu.tieba.card.data.k.eFD = "c10730";
        com.baidu.tieba.card.data.k.eFE = "c10731";
        com.baidu.tieba.card.data.k.eFF = "c10704";
        com.baidu.tieba.card.data.k.eFG = "c10755";
        com.baidu.tieba.card.data.k.eFH = "c10710";
        com.baidu.tieba.card.data.k.eFI = "c10736";
        com.baidu.tieba.card.data.k.eFJ = "c10737";
        com.baidu.tieba.card.data.k.eFK = "c10711";
        com.baidu.tieba.card.data.k.eFL = "c10758";
        com.baidu.tieba.card.data.k.eFM = "c10757";
        com.baidu.tieba.card.data.k.eFP = "c10734";
        com.baidu.tieba.card.data.k.eFQ = "c10708";
        com.baidu.tieba.card.data.k.eFR = "c10735";
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gja = eVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSD = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
