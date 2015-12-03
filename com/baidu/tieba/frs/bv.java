package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bv extends bm<com.baidu.tieba.tbadkCore.i, bw> {
    protected bo bbY;

    /* JADX INFO: Access modifiers changed from: protected */
    public bv(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public bw a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.g.frs_feed_item_layout, (ViewGroup) null);
        this.bbY = new bo(this.aXA.getPageContext(), inflate, 2);
        return new bw(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.i iVar, bw bwVar) {
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.tbadkCore.i) bwVar);
        if (iVar != null) {
            this.bbY.e(iVar.getForumId(), iVar.aBB());
        }
        return view;
    }
}
