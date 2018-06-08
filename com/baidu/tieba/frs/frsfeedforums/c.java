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
    private boolean dnO;
    protected a dqE;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dnO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.frs_feed_item_layout, (ViewGroup) null);
        this.dqE = new a(this.mPageContext, inflate, 2, this.dnO, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, d dVar) {
        super.onFillViewHolder(i, view, viewGroup, hVar, dVar);
        if (hVar != null) {
            this.dqE.d(hVar.getForumId(), hVar.buU());
        }
        return view;
    }
}
