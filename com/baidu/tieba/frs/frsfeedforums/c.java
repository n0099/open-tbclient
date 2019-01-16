package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class c extends h<com.baidu.tieba.tbadkCore.h, d> {
    private boolean dTr;
    protected a dWl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dTr = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.frs_feed_item_layout, (ViewGroup) null);
        this.dWl = new a(this.mPageContext, inflate, 2, this.dTr, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, d dVar) {
        super.onFillViewHolder(i, view, viewGroup, hVar, dVar);
        if (hVar != null) {
            this.dWl.e(hVar.getForumId(), hVar.bCK());
        }
        return view;
    }
}
