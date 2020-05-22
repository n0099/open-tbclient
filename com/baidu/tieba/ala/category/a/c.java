package com.baidu.tieba.ala.category.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
/* loaded from: classes3.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.ala.category.b.c, d> {
    private String fne;

    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, com.baidu.tieba.ala.category.b.c.fnt, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: Y */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        return new d(this.mContext, this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.category.b.c cVar, d dVar) {
        dVar.a(cVar, this.fne);
        return view;
    }

    public void Bc(String str) {
        this.fne = str;
        notifyDataSetChanged();
    }
}
