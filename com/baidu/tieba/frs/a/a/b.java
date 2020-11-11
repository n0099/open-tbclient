package com.baidu.tieba.frs.a.a;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes22.dex */
public class b extends k<ac, c> {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public c c(ViewGroup viewGroup) {
        Log.e("Adapter", "Frs U9 Context:" + this.mContext + "   Resource:" + this.mContext.getResources() + "  Asset:" + this.mContext.getResources().getAssets());
        return new c(this.mPageContext, LayoutInflater.from(this.mContext).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ac acVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) acVar, (ac) cVar);
        if (acVar == null || cVar == null) {
            return null;
        }
        cVar.a(acVar);
        cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return cVar.getView();
    }
}
