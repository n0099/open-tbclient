package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class by extends bp<com.baidu.tieba.tbadkCore.i, bz> {
    protected br bfX;

    /* JADX INFO: Access modifiers changed from: protected */
    public by(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public bz a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.h.frs_feed_item_layout, (ViewGroup) null);
        this.bfX = new br(this.bbA.getPageContext(), inflate, 2);
        return new bz(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.i iVar, bz bzVar) {
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.tbadkCore.i) bzVar);
        if (iVar != null) {
            this.bfX.e(iVar.getForumId(), iVar.aDJ());
        }
        return view;
    }
}
