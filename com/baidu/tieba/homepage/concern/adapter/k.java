package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> agg;
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.bln() != null && !StringUtils.isNull(kVar.bln().getTid())) {
                    k.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.c.a(view, kVar, 2);
        } else if (id == R.id.forum_name_text) {
            com.baidu.tieba.homepage.concern.c.a(view, kVar, 7);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.sW();
        aVar.a((com.baidu.card.h) kVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.k.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) nVar;
                    kVar2.objType = 1;
                    if (k.this.agg != null) {
                        k.this.agg.a(threadCardViewHolder2.getView(), kVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
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
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }
}
