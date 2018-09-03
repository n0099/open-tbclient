package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class c extends h<com.baidu.tieba.tbadkCore.h, d> {
    private boolean dtH;
    protected a dwx;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dtH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(f.h.frs_feed_item_layout, (ViewGroup) null);
        this.dwx = new a(this.mPageContext, inflate, 2, this.dtH, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, d dVar) {
        super.onFillViewHolder(i, view, viewGroup, hVar, dVar);
        if (hVar != null) {
            this.dwx.d(hVar.getForumId(), hVar.btZ());
        }
        return view;
    }
}
