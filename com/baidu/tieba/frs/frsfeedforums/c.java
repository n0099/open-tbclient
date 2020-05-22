package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes9.dex */
public class c extends h<l, d> {
    private boolean hvF;
    protected a hzb;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hvF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public d b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_feed_item_layout, (ViewGroup) null);
        this.hzb = new a(this.mPageContext, inflate, 2, this.hvF, this.mPageId);
        return new d(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) lVar, (l) dVar);
        if (lVar != null) {
            this.hzb.f(lVar.getForumId(), lVar.dcG());
        }
        return view;
    }
}
