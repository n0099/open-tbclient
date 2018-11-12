package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class l extends h<m, n> {
    private final int dEg;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dEg = (com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public n onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.dEg;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new n(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, n nVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, nVar);
        if (mVar.aAq() == 6) {
            nVar.dEj.setText(e.j.attention_no_post_tip);
        } else {
            nVar.dEj.setText(e.j.no_data_text);
        }
        com.baidu.tbadk.core.util.al.c(nVar.dEj, e.d.cp_cont_b, 1);
        return view;
    }
}
