package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> Xq;
    private String Yz;
    private boolean ZO;
    private NEGFeedBackView.a cIW;
    public BdUniqueId cnX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIW = null;
        this.ZO = true;
        this.Xq = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.aQF().go(true);
                com.baidu.tieba.a.d.awk().bA("page_recommend", "show_");
                if (view != null && kVar != null && kVar.WR() != null && !StringUtils.isNull(kVar.WR().getTid())) {
                    int id = view.getId();
                    if (id == d.g.thread_card_root || id == d.g.thread_info_commont_container) {
                        TiebaStatic.log(kVar.tL("c12642"));
                        com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRb());
                        com.baidu.tieba.q.c.cdq().b(p.this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 1, kVar.aQP(), false, null, null));
                    } else if (id == d.g.thread_card_voice) {
                        TiebaStatic.log(kVar.aRf());
                        com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRf());
                    } else if (id == d.g.user_avatar) {
                        TiebaStatic.log(kVar.aRd());
                        com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRd());
                        com.baidu.tieba.q.c.cdq().b(p.this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aQP(), false, null, null));
                    } else if (id == d.g.user_name) {
                        TiebaStatic.log(kVar.aRd());
                        com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRd());
                        com.baidu.tieba.q.c.cdq().b(p.this.cnX, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_click", 2, kVar.aQP(), false, null, null));
                    } else if (id == d.g.forum_name_text) {
                        TiebaStatic.log(kVar.aRc());
                        com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRc());
                    } else if (id == d.g.god_reply_voice_btn) {
                        am amVar = new am("c10760");
                        amVar.T("obj_locate", 4);
                        TiebaStatic.log(amVar);
                    } else if (id == d.g.god_reply_content) {
                        am amVar2 = new am("c10760");
                        amVar2.T("obj_locate", 2);
                        TiebaStatic.log(amVar2);
                    } else if (id == d.g.god_reply_user_pendant_header || id == d.g.god_reply_username_text) {
                        am amVar3 = new am("c10760");
                        amVar3.T("obj_locate", 1);
                        TiebaStatic.log(amVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(d.g.god_reply_image_layout) instanceof Integer) {
                            am amVar4 = new am("c10760");
                            amVar4.T("obj_locate", 3);
                            TiebaStatic.log(amVar4);
                        }
                        TiebaStatic.log(kVar.aRe());
                        com.baidu.tieba.a.d.awk().a("page_recommend", "clk_", kVar.aRe());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        bmL();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z<com.baidu.tieba.card.data.k> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cnX);
        dVar.bv(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.p.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == d.g.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == d.g.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.bB(2);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZO);
        hVar.setForm("index");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxh = 1;
        dVar2.bxm = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bA(2);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        x rw = aVar.rw();
        rw.by(2);
        z<com.baidu.tieba.card.data.k> zVar = new z<>(rw);
        zVar.setPageId(this.cnX);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.p.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (p.this.Xq != null) {
                        p.this.Xq.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    zVar2.rx().b(new a.C0037a(1));
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
        kVar.os(kVar.position + 1);
        com.baidu.tieba.card.t.aQF().b(kVar.tK("c12641"));
        com.baidu.tieba.a.d.awk().a("page_recommend", "show_", kVar.aRa());
        zVar.rx().setPage(this.Yz);
        zVar.ry().a(this.cIW);
        zVar.a(kVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.Xq);
        com.baidu.tieba.q.c.cdq().a(this.cnX, kVar.threadData != null ? kVar.threadData.getId() : null, com.baidu.tieba.q.a.a(kVar.threadData, "a002", "common_exp", kVar.aQP(), false, null, null));
        return zVar.getView();
    }

    private void bmL() {
        com.baidu.tieba.card.data.k.eli = "c10705";
        com.baidu.tieba.card.data.k.elj = "c10730";
        com.baidu.tieba.card.data.k.elk = "c10731";
        com.baidu.tieba.card.data.k.ell = "c10704";
        com.baidu.tieba.card.data.k.elm = "c10755";
        com.baidu.tieba.card.data.k.eln = "c10710";
        com.baidu.tieba.card.data.k.elo = "c10736";
        com.baidu.tieba.card.data.k.elp = "c10737";
        com.baidu.tieba.card.data.k.elq = "c10711";
        com.baidu.tieba.card.data.k.elr = "c10758";
        com.baidu.tieba.card.data.k.els = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIW = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.Yz = str;
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }
}
