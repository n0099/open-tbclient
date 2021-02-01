package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.ap;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class v extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private boolean akO;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdO = null;
        this.akO = true;
        this.agg = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csu().mG(true);
                com.baidu.tieba.a.d.bKP().dK("page_recommend", "show_");
                if (view != null && kVar != null && kVar.bln() != null && !StringUtils.isNull(kVar.bln().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.IW("c12642"));
                        com.baidu.tieba.a.d.bKP().a("page_recommend", "clk_", kVar.csO());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.csY());
                        com.baidu.tieba.a.d.bKP().a("page_recommend", "clk_", kVar.csY());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.csW());
                        com.baidu.tieba.a.d.bKP().a("page_recommend", "clk_", kVar.csW());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.csW());
                        com.baidu.tieba.a.d.bKP().a("page_recommend", "clk_", kVar.csW());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.csN());
                        com.baidu.tieba.a.d.bKP().a("page_recommend", "clk_", kVar.csN());
                    } else if (id == R.id.god_reply_voice_btn) {
                        ar arVar = new ar("c10760");
                        arVar.ap("obj_locate", 4);
                        TiebaStatic.log(arVar);
                    } else if (id == R.id.god_reply_content) {
                        ar arVar2 = new ar("c10760");
                        arVar2.ap("obj_locate", 2);
                        TiebaStatic.log(arVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        ar arVar3 = new ar("c10760");
                        arVar3.ap("obj_locate", 1);
                        TiebaStatic.log(arVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            ar arVar4 = new ar("c10760");
                            arVar4.ap("obj_locate", 3);
                            TiebaStatic.log(arVar4);
                        }
                        TiebaStatic.log(kVar.csX());
                        com.baidu.tieba.a.d.bKP().a("page_recommend", "clk_", kVar.csX());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eJQ, v.this.fGZ, kVar.csH(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPb();
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
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.adapter.v.2
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
        ap apVar = new ap(this.mPageContext.getPageActivity());
        aVar.c(apVar);
        apVar.bD(2);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.k(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm("index");
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
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.v.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (v.this.agg != null) {
                        v.this.agg.a(threadCardViewHolder2.getView(), kVar);
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
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eJQ == null) {
            return null;
        }
        kVar.xd(kVar.position + 1);
        com.baidu.tieba.card.t.csu().e(kVar.IV("c12641"));
        com.baidu.tieba.a.d.bKP().a("page_recommend", "show_", kVar.csQ());
        threadCardViewHolder.tj().setPage(this.aif);
        threadCardViewHolder.aK(true).a(this.gdO);
        threadCardViewHolder.a(kVar.blx(), this.jYP);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eJQ, this.fGZ, kVar.csH());
        return threadCardViewHolder.getView();
    }

    private void cPb() {
        com.baidu.tieba.card.data.k.iAu = "c10705";
        com.baidu.tieba.card.data.k.iAv = "c10730";
        com.baidu.tieba.card.data.k.iAw = "c10731";
        com.baidu.tieba.card.data.k.iAx = "c10704";
        com.baidu.tieba.card.data.k.iAy = "c10755";
        com.baidu.tieba.card.data.k.iAz = "c10710";
        com.baidu.tieba.card.data.k.iAA = "c10736";
        com.baidu.tieba.card.data.k.iAB = "c10737";
        com.baidu.tieba.card.data.k.iAC = "c10711";
        com.baidu.tieba.card.data.k.iAD = "c10758";
        com.baidu.tieba.card.data.k.iAE = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }
}
