package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> {
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> iIM;
    private TbPageContext<?> mPageContext;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iIM = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                ThreadCardViewHolder threadCardViewHolder;
                super.a(view, (View) kVar);
                if (kVar != null && kVar.bkV() != null && (threadCardViewHolder = (ThreadCardViewHolder) view.getTag()) != null) {
                    ay.a((com.baidu.tbadk.core.data.a) kVar.bkV(), view.getContext(), 2, false);
                    threadCardViewHolder.tm().b(new a.C0089a(1));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amu);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.o.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) nVar;
                    if (o.this.iIM != null) {
                        o.this.iIM.a(threadCardViewHolder2.getView(), kVar);
                    }
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
        threadCardViewHolder.tm().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
    }
}
