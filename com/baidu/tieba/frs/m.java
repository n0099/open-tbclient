package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class m extends h<n, o> {
    private final int goW;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.goW = (com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public o b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.goW;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new o(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, o oVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (n) oVar);
        if (nVar.bDL() == 6) {
            oVar.gpa.setText(R.string.attention_no_post_tip);
        } else {
            oVar.gpa.setText(R.string.no_data_common_txt);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(oVar.gpa, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.am.setImageResource(oVar.gpb, R.drawable.new_pic_emotion_06);
        return view;
    }
}
