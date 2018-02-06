package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.g<com.baidu.tieba.frs.r, com.baidu.tieba.frs.entelechy.view.o> {
    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public com.baidu.tieba.frs.entelechy.view.o onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.frs.entelechy.view.o(LayoutInflater.from(this.mContext).inflate(d.h.frs_read_progress_item, viewGroup, false), this.mPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.entelechy.view.o oVar) {
        if (rVar != null && oVar != null) {
            oVar.a(rVar);
        }
        return view;
    }
}
