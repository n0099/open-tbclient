package com.baidu.tieba.ala.category.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
/* loaded from: classes10.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.ala.category.b.c, b> {
    private String gOA;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, com.baidu.tieba.ala.category.b.c.gOP, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: am */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.mContext, this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.category.b.c cVar, b bVar) {
        bVar.a(cVar, this.gOA);
        return view;
    }

    public void Gn(String str) {
        this.gOA = str;
        notifyDataSetChanged();
    }
}
