package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.entelechy.view.bc;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.frs.p<bf, bc> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public bc onCreateViewHolder(ViewGroup viewGroup) {
        return new bc(LayoutInflater.from(this.mContext).inflate(w.j.frs_read_progress_item, viewGroup, false), this.ajr.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, bc bcVar) {
        if (bfVar != null && bcVar != null) {
            bcVar.a(bfVar);
        }
        return view;
    }
}
