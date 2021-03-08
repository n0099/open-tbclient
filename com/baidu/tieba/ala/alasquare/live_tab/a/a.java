package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.s;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<s, FrsNoListItemViewHolder> {
    private final int itemHeight;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), s.jlC);
        this.itemHeight = (l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public FrsNoListItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.itemHeight;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new FrsNoListItemViewHolder(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        frsNoListItemViewHolder.jlF.setText(R.string.no_data_common_txt);
        ap.setViewTextColor(frsNoListItemViewHolder.jlF, R.color.CAM_X0107, 1);
        ap.setImageResource(frsNoListItemViewHolder.jlG, R.drawable.new_pic_emotion_06);
        return view;
    }
}
