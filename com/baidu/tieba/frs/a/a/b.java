package com.baidu.tieba.frs.a.a;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes4.dex */
public class b extends h<x, c> {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        Log.e("Adapter", "Frs U9 Context:" + this.mContext + "   Resource:" + this.mContext.getResources() + "  Asset:" + this.mContext.getResources().getAssets());
        return new c(this.mPageContext, LayoutInflater.from(this.mContext).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, x xVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, xVar, cVar);
        if (xVar == null || cVar == null) {
            return null;
        }
        cVar.a(xVar);
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return cVar.getView();
    }
}
