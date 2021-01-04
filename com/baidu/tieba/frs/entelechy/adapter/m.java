package com.baidu.tieba.frs.entelechy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.view.ReadProgressViewHolder;
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.u, ReadProgressViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public ReadProgressViewHolder e(ViewGroup viewGroup) {
        return new ReadProgressViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.frs_read_progress_item, viewGroup, false), this.mPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.u uVar, ReadProgressViewHolder readProgressViewHolder) {
        if (uVar != null && readProgressViewHolder != null) {
            readProgressViewHolder.a(uVar);
        }
        return view;
    }
}
