package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes21.dex */
public class c extends k<l, d> {
    private boolean iSd;
    protected a iWl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iSd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public d c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_feed_item_layout, (ViewGroup) null);
        this.iWl = new a(this.mPageContext, inflate, 2, this.iSd, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) dVar);
        if (lVar != null) {
            this.iWl.f(lVar.getForumId(), lVar.dJb());
        }
        return view;
    }
}
