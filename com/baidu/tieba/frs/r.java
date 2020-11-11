package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class r extends k<s, t> {
    private final int geB;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.geB = (com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public t c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.geB;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new t(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (s) tVar);
        if (sVar.cAa() == 6) {
            tVar.iKO.setText(R.string.attention_no_post_tip);
        } else {
            tVar.iKO.setText(R.string.no_data_common_txt);
        }
        com.baidu.tbadk.core.util.ap.setViewTextColor(tVar.iKO, R.color.cp_cont_j, 1);
        com.baidu.tbadk.core.util.ap.setImageResource(tVar.iKP, R.drawable.new_pic_emotion_06);
        return view;
    }
}
