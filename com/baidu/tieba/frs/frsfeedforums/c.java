package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes3.dex */
public class c extends f<h, d> {
    private boolean deA;
    protected a dhp;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.deA = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.frs_feed_item_layout, (ViewGroup) null);
        this.dhp = new a(this.mPageContext, inflate, 2, this.deA, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h hVar, d dVar) {
        super.onFillViewHolder(i, view2, viewGroup, hVar, dVar);
        if (hVar != null) {
            this.dhp.d(hVar.getForumId(), hVar.bpT());
        }
        return view2;
    }
}
