package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<s, t> {
    private final int gms;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), s.iWt);
        this.gms = (l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public t c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.gms;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new t(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, s sVar, t tVar) {
        tVar.iWw.setText(R.string.no_data_common_txt);
        ap.setViewTextColor(tVar.iWw, R.color.CAM_X0107, 1);
        ap.setImageResource(tVar.iWx, R.drawable.new_pic_emotion_06);
        return view;
    }
}
