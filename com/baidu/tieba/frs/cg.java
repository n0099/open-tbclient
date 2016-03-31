package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cg extends bx<com.baidu.tieba.tbadkCore.h, ch> {
    protected bz bnq;

    /* JADX INFO: Access modifiers changed from: protected */
    public cg(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public ch b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_feed_item_layout, (ViewGroup) null);
        this.bnq = new bz(this.bix.getPageContext(), inflate, 2);
        return new ch(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, ch chVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) chVar);
        if (hVar != null) {
            this.bnq.c(hVar.getForumId(), hVar.aRD());
        }
        return view;
    }
}
