package com.baidu.tieba.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends d<com.baidu.tbadk.data.b, com.baidu.tbadk.i.b> {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public com.baidu.tbadk.i.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.i.b(LayoutInflater.from(this.mContext).inflate(d.i.ala_follow_lives_layout, viewGroup, false), this.mPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tbadk.data.b bVar, com.baidu.tbadk.i.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.EY();
            bVar2.a(bVar);
        }
        return view2;
    }
}
