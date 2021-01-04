package com.baidu.tieba.frs.extra.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes2.dex */
public class b extends k<ad, FrsU9ViewHolder> {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
    public FrsU9ViewHolder e(ViewGroup viewGroup) {
        Log.e("Adapter", "Frs U9 Context:" + this.mContext + "   Resource:" + this.mContext.getResources() + "  Asset:" + this.mContext.getResources().getAssets());
        return new FrsU9ViewHolder(this.mPageContext, LayoutInflater.from(this.mContext).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ad adVar, FrsU9ViewHolder frsU9ViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) adVar, (ad) frsU9ViewHolder);
        if (adVar == null || frsU9ViewHolder == null) {
            return null;
        }
        frsU9ViewHolder.a(adVar);
        frsU9ViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return frsU9ViewHolder.getView();
    }
}
