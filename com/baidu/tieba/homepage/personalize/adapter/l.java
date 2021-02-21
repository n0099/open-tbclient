package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private boolean akO;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdT = null;
        this.akO = true;
        this.agg = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 1;
                com.baidu.tieba.card.t.csB().mG(true);
                com.baidu.tieba.a.d.bKU().dK("page_recommend", "show_");
                if (kVar != null && kVar.bln() != null && !au.isEmpty(kVar.bln().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(kVar.csV());
                        com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.csV());
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.csV());
                        com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.csV());
                        i = 5;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.ctf());
                        com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.ctf());
                        i = 0;
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.ctd());
                        com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.ctd());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.ctd());
                        com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.ctd());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.csU());
                        com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.csU());
                        i = 0;
                    } else if (id == R.id.god_reply_voice_btn) {
                        ar arVar = new ar("c10760");
                        arVar.ap("obj_locate", 4);
                        TiebaStatic.log(arVar);
                        i = 0;
                    } else if (id == R.id.god_reply_content) {
                        ar arVar2 = new ar("c10760");
                        arVar2.ap("obj_locate", 2);
                        TiebaStatic.log(arVar2);
                        i = 0;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                ar arVar3 = new ar("c10760");
                                arVar3.ap("obj_locate", 3);
                                TiebaStatic.log(arVar3);
                            }
                            TiebaStatic.log(kVar.cte());
                            com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.cte());
                        }
                        i = 0;
                    } else {
                        ar arVar4 = new ar("c10760");
                        arVar4.ap("obj_locate", 1);
                        TiebaStatic.log(arVar4);
                        i = 0;
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eJQ, l.this.fGZ, kVar.csO(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPi();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fGZ);
        dVar.br(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.adapter.l.2
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
        aVar.a(dVar);
        aVar.c(new com.baidu.card.t(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm("index");
        nVar.a(new ar("c13342"));
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 1;
        eVar.eMg = 1;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        ak th = aVar.th();
        th.setSourceForPb(2);
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(th);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.l.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (l.this.agg != null) {
                        l.this.agg.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.tj() == null) {
            return null;
        }
        kVar.xd(kVar.position + 1);
        com.baidu.tieba.card.t.csB().e(kVar.IV("c12190"));
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        com.baidu.card.ab aK = threadCardViewHolder.aK(true);
        aK.a(this.gdT);
        threadCardViewHolder.a(kVar.blx(), this.jZd);
        aK.C(kVar.blp());
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.b(this.agg);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eJQ, this.fGZ, kVar.csO());
        return threadCardViewHolder.getView();
    }

    private void cPi() {
        com.baidu.tieba.card.data.k.iAI = "c10705";
        com.baidu.tieba.card.data.k.iAJ = "c10730";
        com.baidu.tieba.card.data.k.iAK = "c10731";
        com.baidu.tieba.card.data.k.iAL = "c10704";
        com.baidu.tieba.card.data.k.iAM = "c10755";
        com.baidu.tieba.card.data.k.iAN = "c10710";
        com.baidu.tieba.card.data.k.iAO = "c10736";
        com.baidu.tieba.card.data.k.iAP = "c10737";
        com.baidu.tieba.card.data.k.iAQ = "c10711";
        com.baidu.tieba.card.data.k.iAR = "c10758";
        com.baidu.tieba.card.data.k.iAS = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdT = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }
}
