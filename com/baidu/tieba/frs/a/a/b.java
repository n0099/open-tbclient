package com.baidu.tieba.frs.a.a;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class b extends h<v, c> {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        Log.e("Adapter", "Frs U9 Context:" + this.mContext + "   Resource:" + this.mContext.getResources() + "  Asset:" + this.mContext.getResources().getAssets());
        return new c(this.mPageContext, LayoutInflater.from(this.mContext).inflate(d.h.u9_info_layout, (ViewGroup) null, true), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, v vVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, vVar, cVar);
        if (vVar == null || cVar == null) {
            return null;
        }
        cVar.a(vVar);
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return cVar.getView();
    }
}
