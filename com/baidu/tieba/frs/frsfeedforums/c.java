package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes4.dex */
public class c extends h<i, d> {
    private boolean fgN;
    protected a fjO;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fgN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_feed_item_layout, (ViewGroup) null);
        this.fjO = new a(this.mPageContext, inflate, 2, this.fgN, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, i iVar, d dVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, dVar);
        if (iVar != null) {
            this.fjO.g(iVar.getForumId(), iVar.cdB());
        }
        return view;
    }
}
