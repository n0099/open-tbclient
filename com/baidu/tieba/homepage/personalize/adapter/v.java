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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class v extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> ago;
    private String air;
    private boolean akY;
    public BdUniqueId fEN;
    private NEGFeedBackView.a gbz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbz = null;
        this.akY = true;
        this.ago = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.s.crj().mC(true);
                com.baidu.tieba.a.d.bKv().dQ("page_recommend", "show_");
                if (view != null && kVar != null && kVar.bkV() != null && !StringUtils.isNull(kVar.bkV().getTid())) {
                    int id = view.getId();
                    int i = 0;
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(kVar.Il("c12642"));
                        com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crC());
                        i = 1;
                    } else if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.crM());
                        com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crM());
                    } else if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.crK());
                        com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crK());
                        i = 2;
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.crK());
                        com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crK());
                        i = 2;
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.crB());
                        com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crB());
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c10760");
                        aqVar.an("obj_locate", 4);
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c10760");
                        aqVar2.an("obj_locate", 2);
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c10760");
                        aqVar3.an("obj_locate", 1);
                        TiebaStatic.log(aqVar3);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar4 = new aq("c10760");
                            aqVar4.an("obj_locate", 3);
                            TiebaStatic.log(aqVar4);
                        }
                        TiebaStatic.log(kVar.crL());
                        com.baidu.tieba.a.d.bKv().a("page_recommend", "clk_", kVar.crL());
                    }
                    if (i != 0) {
                        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eHK, v.this.fEN, kVar.crv(), i);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fEN);
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
        nVar.setFromCDN(this.akY);
        nVar.setForm("index");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eJO = 1;
        dVar2.eJU = 1;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        ak tk = aVar.tk();
        tk.setSourceForPb(2);
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(tk);
        threadCardViewHolder.setPageId(this.fEN);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.v.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar2;
                    kVar.objType = 1;
                    if (v.this.ago != null) {
                        v.this.ago.a(threadCardViewHolder2.getView(), kVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eHK == null) {
            return null;
        }
        kVar.wT(kVar.position + 1);
        com.baidu.tieba.card.s.crj().e(kVar.Ik("c12641"));
        com.baidu.tieba.a.d.bKv().a("page_recommend", "show_", kVar.crE());
        threadCardViewHolder.tm().setPage(this.air);
        threadCardViewHolder.aK(true).a(this.gbz);
        threadCardViewHolder.a(kVar.blf(), this.jRn);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        com.baidu.tieba.homepage.personalize.a.a.a(kVar.eHK, this.fEN, kVar.crv());
        return threadCardViewHolder.getView();
    }

    private void cNf() {
        com.baidu.tieba.card.data.k.iuK = "c10705";
        com.baidu.tieba.card.data.k.iuL = "c10730";
        com.baidu.tieba.card.data.k.iuM = "c10731";
        com.baidu.tieba.card.data.k.iuN = "c10704";
        com.baidu.tieba.card.data.k.iuO = "c10755";
        com.baidu.tieba.card.data.k.iuP = "c10710";
        com.baidu.tieba.card.data.k.iuQ = "c10736";
        com.baidu.tieba.card.data.k.iuR = "c10737";
        com.baidu.tieba.card.data.k.iuS = "c10711";
        com.baidu.tieba.card.data.k.iuT = "c10758";
        com.baidu.tieba.card.data.k.iuU = "c10757";
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gbz = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }
}
