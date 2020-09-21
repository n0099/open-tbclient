package com.baidu.tieba.ala.live.personcenter.admin.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.tieba.ala.live.personcenter.admin.b.b;
/* loaded from: classes4.dex */
public class a extends AbsDelegateAdapter<b, com.baidu.tieba.ala.live.personcenter.admin.d.b> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, b.gjI, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: al */
    public com.baidu.tieba.ala.live.personcenter.admin.d.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.ala.live.personcenter.admin.d.b(this.mContext, this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, com.baidu.tieba.ala.live.personcenter.admin.d.b bVar2) {
        bVar2.b(bVar);
        return view;
    }
}
