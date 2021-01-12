package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, ThreadCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> ago;
    private String air;
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private BdUniqueId jTk;
    private com.baidu.card.i jTl;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                BdToast.b(j.this.mPageContext.getContext(), j.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
            }
        };
        this.mPageContext = tbPageContext;
        this.jTk = bdUniqueId2;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, ThreadCardViewHolder<com.baidu.tieba.card.data.l> threadCardViewHolder) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return this.jTk != null ? this.jTk : com.baidu.tieba.card.data.b.iug;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return com.baidu.tieba.card.data.b.iun;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qp() {
        return com.baidu.tieba.card.data.b.iuo;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qq() {
        return com.baidu.tieba.card.data.b.iup;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.jTl = new com.baidu.card.i(this.mPageContext.getPageActivity());
        this.jTl.setPageUniqueId(this.fEN);
        aVar.c(this.jTl);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amu);
        ThreadCardViewHolder<com.baidu.tieba.card.data.l> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a2.a(this.ago);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.j.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                BdToast.b(j.this.mPageContext.getContext(), j.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, ThreadCardViewHolder<com.baidu.tieba.card.data.l> threadCardViewHolder) {
        if (lVar == null) {
            return threadCardViewHolder.getView();
        }
        if (threadCardViewHolder == null) {
            return null;
        }
        lVar.wT(lVar.position + 1);
        com.baidu.tieba.card.s.crj().e(lVar.Ih("c12351"));
        threadCardViewHolder.tm().setPosition(i);
        lVar.sourceType = 0;
        if (threadCardViewHolder.tm() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tm().setPage(this.air);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.ago);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
