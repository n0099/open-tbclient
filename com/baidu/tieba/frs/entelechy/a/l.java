package com.baidu.tieba.frs.entelechy.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class l extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.t, com.baidu.tieba.frs.entelechy.view.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public com.baidu.tieba.frs.entelechy.view.e b(ViewGroup viewGroup) {
        return new com.baidu.tieba.frs.entelechy.view.e(LayoutInflater.from(this.mContext).inflate(R.layout.frs_read_progress_item, viewGroup, false), this.mPageContext.getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.t tVar, com.baidu.tieba.frs.entelechy.view.e eVar) {
        if (tVar != null && eVar != null) {
            eVar.a(tVar);
        }
        return view;
    }
}
