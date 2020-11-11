package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes22.dex */
public class c extends k<l, d> {
    private boolean iRq;
    protected a iVz;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iRq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public d c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_feed_item_layout, (ViewGroup) null);
        this.iVz = new a(this.mPageContext, inflate, 2, this.iRq, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) dVar);
        if (lVar != null) {
            this.iVz.f(lVar.getForumId(), lVar.dJk());
        }
        return view;
    }
}
