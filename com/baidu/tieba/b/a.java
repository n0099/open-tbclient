package com.baidu.tieba.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends d<com.baidu.tbadk.data.b, com.baidu.tbadk.l.b> {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public com.baidu.tbadk.l.b b(ViewGroup viewGroup) {
        return new com.baidu.tbadk.l.b(LayoutInflater.from(this.mContext).inflate(R.layout.ala_follow_lives_layout, viewGroup, false), this.mPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.b bVar, com.baidu.tbadk.l.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.avq();
            bVar2.a(bVar);
        }
        return view;
    }
}
