package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.q;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<p, q> {
    private final int eYA;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), p.hqo);
        this.eYA = (l.getEquipmentHeight(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public q b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = this.eYA;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return new q(inflate, viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, p pVar, q qVar) {
        qVar.hqr.setText(R.string.no_data_common_txt);
        am.setViewTextColor(qVar.hqr, R.color.cp_cont_j, 1);
        am.setImageResource(qVar.hqs, R.drawable.new_pic_emotion_06);
        return view;
    }
}
