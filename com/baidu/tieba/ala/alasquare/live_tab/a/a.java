package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<r, s> {
    private final int fou;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), r.hIV);
        this.fou = (l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
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
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, r rVar, s sVar) {
        sVar.hIY.setText(R.string.no_data_common_txt);
        ao.setViewTextColor(sVar.hIY, R.color.cp_cont_j, 1);
        ao.setImageResource(sVar.hIZ, R.drawable.new_pic_emotion_06);
        return view;
    }
}
