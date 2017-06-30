package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.frs.p<bh, com.baidu.tieba.frs.entelechy.view.bh> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public com.baidu.tieba.frs.entelechy.view.bh onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.frs.entelechy.view.bh(LayoutInflater.from(this.mContext).inflate(w.j.frs_read_progress_item, viewGroup, false), this.ajP.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.frs.entelechy.view.bh bhVar2) {
        if (bhVar != null && bhVar2 != null) {
            bhVar2.a(bhVar);
        }
        return view;
    }
}
