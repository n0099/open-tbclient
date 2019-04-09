package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Xs;
    private String YB;
    private boolean ZR;
    private com.baidu.adp.widget.ListView.r aaM;
    public BdUniqueId coa;
    private com.baidu.tieba.homepage.personalize.model.e fLD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ZR = true;
        this.Xs = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aQD().go(true);
                com.baidu.tieba.a.d.awh().bA("page_recommend", "show_");
                if (view != null && e.this.fLD != null && kVar != null && kVar.WO() != null && !StringUtils.isNull(kVar.WO().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.cM(com.baidu.adp.lib.g.b.d(kVar.WO().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.cL(com.baidu.adp.lib.g.b.d(kVar.WO().getTid(), 0L));
                        e.this.fLD.a(com.baidu.adp.lib.g.b.d(kVar.WO().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.aQN(), kVar.aQO(), com.baidu.adp.lib.g.b.l((String) view.getTag(), 1));
                    }
                    e.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmI();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.aaM = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == d.g.thread_card_root || id == d.g.thread_info_commont_container) {
            TiebaStatic.log(kVar.aQZ());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aQZ());
            i = 1;
        } else if (id == d.g.user_avatar) {
            TiebaStatic.log(kVar.aRb());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRb());
        } else if (id == d.g.user_name) {
            TiebaStatic.log(kVar.aRb());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRb());
        } else if (id == d.g.forum_name_text) {
            TiebaStatic.log(kVar.aRa());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRa());
            i = 9;
        } else if (id == d.g.god_reply_content) {
            am amVar = new am("c10760");
            amVar.T("obj_locate", 2);
            TiebaStatic.log(amVar);
            i = 5;
        } else if (id == d.g.god_reply_user_pendant_header || id == d.g.god_reply_username_text) {
            am amVar2 = new am("c10760");
            amVar2.T("obj_locate", 1);
            TiebaStatic.log(amVar2);
            i = 5;
        } else if (view instanceof TbImageView) {
            if (view.getTag(d.g.god_reply_image_layout) instanceof Integer) {
                am amVar3 = new am("c10760");
                amVar3.T("obj_locate", 3);
                TiebaStatic.log(amVar3);
            }
            TiebaStatic.log(kVar.aRc());
            com.baidu.tieba.a.d.awh().a("page_recommend", "clk_", kVar.aRc());
            i = 3;
        } else {
            i = 0;
        }
        if (i != 0) {
            com.baidu.tieba.q.c.cdp().b(this.coa, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", i, kVar.aQN(), false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.setFrom("index");
        qVar.setFromCDN(this.ZR);
        aVar.b(qVar);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.aaM);
        a.bx(2);
        z zVar = new z(a);
        zVar.setPageId(this.coa);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (e.this.Xs != null) {
                        e.this.Xs.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.rx().b(new a.C0039a(1));
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
        kVar.oo(kVar.position + 1);
        zVar.rx().setPosition(i);
        zVar.rx().setPage(this.YB);
        zVar.a(kVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.Xs);
        com.baidu.tieba.card.t.aQD().b(kVar.aQY());
        com.baidu.tieba.a.d.awh().b(kVar.aQY());
        com.baidu.card.q qVar = (com.baidu.card.q) zVar.rx().rq();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.Ye.aaw.getLayoutParams();
        layoutParams.width = kVar.bAR;
        layoutParams.height = kVar.bAS;
        if (qVar.Ye.aaw.getVisibility() != 8) {
            qVar.Ye.aaw.setLayoutParams(layoutParams);
        }
        com.baidu.tieba.q.c.cdp().a(this.coa, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aQN(), false, null, null));
        return zVar.getView();
    }

    private void bmI() {
        com.baidu.tieba.card.data.k.ekR = "c10705";
        com.baidu.tieba.card.data.k.ekS = "c10730";
        com.baidu.tieba.card.data.k.ekT = "c10731";
        com.baidu.tieba.card.data.k.ekU = "c10704";
        com.baidu.tieba.card.data.k.ekV = "c10755";
        com.baidu.tieba.card.data.k.ekW = "c10710";
        com.baidu.tieba.card.data.k.ekX = "c10736";
        com.baidu.tieba.card.data.k.ekY = "c10737";
        com.baidu.tieba.card.data.k.ekZ = "c10711";
        com.baidu.tieba.card.data.k.ela = "c10758";
        com.baidu.tieba.card.data.k.elb = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YB = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fLD = eVar;
    }
}
