package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class q extends j<r, s> {
    private final int fou;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fou = (com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public s b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.fou;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new s(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, r rVar, s sVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (r) sVar);
        if (rVar.cdj() == 6) {
            sVar.hIY.setText(R.string.attention_no_post_tip);
        } else {
            sVar.hIY.setText(R.string.no_data_common_txt);
        }
        com.baidu.tbadk.core.util.ao.setViewTextColor(sVar.hIY, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ao.setImageResource(sVar.hIZ, R.drawable.new_pic_emotion_06);
        return view;
    }
}
