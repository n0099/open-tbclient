package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class l extends com.baidu.tieba.frs.k<com.baidu.tieba.frs.w, com.baidu.tieba.frs.entelechy.view.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public com.baidu.tieba.frs.entelechy.view.e c(ViewGroup viewGroup) {
        return new com.baidu.tieba.frs.entelechy.view.e(LayoutInflater.from(this.mContext).inflate(R.layout.frs_read_progress_item, viewGroup, false), this.mPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.w wVar, com.baidu.tieba.frs.entelechy.view.e eVar) {
        if (wVar != null && eVar != null) {
            eVar.a(wVar);
        }
        return view;
    }
}
