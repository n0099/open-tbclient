package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class j extends com.baidu.tieba.frs.f<com.baidu.tieba.frs.n, com.baidu.tieba.frs.entelechy.view.j> {
    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public com.baidu.tieba.frs.entelechy.view.j onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.frs.entelechy.view.j(LayoutInflater.from(this.mContext).inflate(d.i.frs_read_progress_item, viewGroup, false), this.mPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.n nVar, com.baidu.tieba.frs.entelechy.view.j jVar) {
        if (nVar != null && jVar != null) {
            jVar.a(nVar);
        }
        return view;
    }
}
