package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cf extends bw<com.baidu.tieba.tbadkCore.h, cg> {
    private boolean biL;
    protected by biT;

    public cf(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.biL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public cg b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_feed_item_layout, (ViewGroup) null);
        this.biT = new by(this.bek.getPageContext(), inflate, 2, this.biL);
        return new cg(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, cg cgVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) cgVar);
        if (hVar != null) {
            this.biT.d(hVar.getForumId(), hVar.aSb());
        }
        return view;
    }
}
