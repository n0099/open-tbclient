package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class l extends h<m, n> {
    private final int fyh;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fyh = (com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public n b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.fyh;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new n(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, n nVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (m) nVar);
        if (mVar.blo() == 6) {
            nVar.fyl.setText(R.string.attention_no_post_tip);
        } else {
            nVar.fyl.setText(R.string.no_data_text);
        }
        com.baidu.tbadk.core.util.am.setViewTextColor(nVar.fyl, R.color.cp_cont_d, 1);
        com.baidu.tbadk.core.util.am.setImageResource(nVar.fym, R.drawable.new_pic_emotion_gray_06);
        return view;
    }
}
