package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private boolean akO;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private com.baidu.tieba.homepage.personalize.model.e kjT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.agg = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csB().mG(true);
                com.baidu.tieba.a.d.bKU().dK("page_recommend", "show_");
                if (view != null && e.this.kjT != null && kVar != null && kVar.bln() != null && !StringUtils.isNull(kVar.bln().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gF(com.baidu.adp.lib.f.b.toLong(kVar.bln().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gE(com.baidu.adp.lib.f.b.toLong(kVar.bln().getTid(), 0L));
                        e.this.kjT.a(com.baidu.adp.lib.f.b.toLong(kVar.bln().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.csO(), kVar.csP(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bln().getBaijiahaoData());
                    }
                    e.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPi();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.csV());
            com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.csV());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.ctd());
            com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.ctd());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.ctd());
            com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.ctd());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.csU());
            com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.csU());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            ar arVar = new ar("c10760");
            arVar.ap("obj_locate", 2);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar2 = new ar("c10760");
            arVar2.ap("obj_locate", 1);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ar arVar3 = new ar("c10760");
                arVar3.ap("obj_locate", 3);
                TiebaStatic.log(arVar3);
            }
            TiebaStatic.log(kVar.cte());
            com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.cte());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.a.a.a(kVar.eJQ, this.fGZ, kVar.csO(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("index");
        vVar.setFromCDN(this.akO);
        aVar.c(vVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.e.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (e.this.agg != null) {
                        e.this.agg.a(threadCardViewHolder2.getView(), kVar);
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
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.tj().setPage(this.aif);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.card.t.csB().e(kVar.csX());
        com.baidu.tieba.a.d.bKU().e(kVar.csX());
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

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kjT = eVar;
    }
}
