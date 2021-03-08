package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class c extends k<l, FrsFeedItemViewHolder> {
    private boolean jss;
    protected a jzi;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jss = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public FrsFeedItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_feed_item_layout, (ViewGroup) null);
        this.jzi = new a(this.mPageContext, inflate, 2, this.jss, this.mPageId);
        return new FrsFeedItemViewHolder(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, FrsFeedItemViewHolder frsFeedItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) frsFeedItemViewHolder);
        if (lVar != null) {
            this.jzi.f(lVar.getForumId(), lVar.dMU());
        }
        return view;
    }
}
