package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class j extends f<k, l> {
    private final int djV;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.djV = (com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.djV;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new l(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, l lVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, lVar);
        if (kVar.auG() == 6) {
            lVar.djY.setText(d.k.attention_no_post_tip);
        } else {
            lVar.djY.setText(d.k.no_data_text);
        }
        com.baidu.tbadk.core.util.al.c(lVar.djY, d.C0141d.cp_cont_b, 1);
        return view;
    }
}
