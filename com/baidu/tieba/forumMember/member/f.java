package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class f extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.n, FrsEmpertyItemViewHolder> {
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bn */
    public FrsEmpertyItemViewHolder e(ViewGroup viewGroup) {
        return new FrsEmpertyItemViewHolder(new View(this.mContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.n nVar, FrsEmpertyItemViewHolder frsEmpertyItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (com.baidu.tieba.frs.n) frsEmpertyItemViewHolder);
        frsEmpertyItemViewHolder.zF(nVar.getHeight());
        frsEmpertyItemViewHolder.setBackground(nVar.cEQ());
        return view;
    }
}
