package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class n extends h<o, p> {
    private final int grW;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.grW = (com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public p b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.grW;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new p(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, p pVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (o) pVar);
        if (oVar.bFB() == 6) {
            pVar.gsa.setText(R.string.attention_no_post_tip);
        } else {
            pVar.gsa.setText(R.string.no_data_common_txt);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(pVar.gsa, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(pVar.gsb, R.drawable.new_pic_emotion_06);
        return view;
    }
}
