package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes3.dex */
public class c extends g<i, d> {
    private boolean dKt;
    protected a dNE;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dKt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_feed_item_layout, (ViewGroup) null);
        this.dNE = new a(this.mPageContext, inflate, 2, this.dKt, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, d dVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, dVar);
        if (iVar != null) {
            this.dNE.d(iVar.getForumId(), iVar.buO());
        }
        return view;
    }
}
