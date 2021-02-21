package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csB().mG(true);
                if (view != null && kVar != null && kVar.bln() != null && !StringUtils.isNull(kVar.bln().getTid())) {
                    i.this.b(view, kVar);
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
        int i;
        ar csV;
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(kVar.csU());
                com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", kVar.csU());
                i = 9;
            } else {
                if (kVar.bmv()) {
                    csV = kVar.csW();
                } else {
                    csV = kVar.csV();
                }
                TiebaStatic.log(csV);
                com.baidu.tieba.a.d.bKU().a("page_recommend", "clk_", csV);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.a.a.a(kVar.eJQ, this.fGZ, kVar.csO(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.amk);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.i.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    kVar.objType = 1;
                    if (i.this.agg != null) {
                        i.this.agg.a(threadCardViewHolder2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
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
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP, this.gdT);
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

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdT = aVar;
    }
}
