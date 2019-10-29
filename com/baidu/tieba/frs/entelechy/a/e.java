package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.p, com.baidu.tieba.frs.entelechy.view.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.tieba.frs.entelechy.view.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.frs.entelechy.view.e(LayoutInflater.from(this.mContext).inflate(R.layout.frs_read_progress_item, viewGroup, false), this.mPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.p pVar, com.baidu.tieba.frs.entelechy.view.e eVar) {
        if (pVar != null && eVar != null) {
            eVar.a(pVar);
        }
        return view;
    }
}
