package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private View bTo;
    private c gDe;
    private c gDf;
    private LinearLayout gDg;
    private ViewGroup rootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gDe = new c(tbPageContext);
        this.gDf = new c(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gDg = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.bTo = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gDg.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gDg.addView(this.gDe.getView());
        this.gDg.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gDg.addView(this.gDf.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gDe.onChangeSkinType(tbPageContext, i);
        this.gDf.onChangeSkinType(tbPageContext, i);
        ap.setBackgroundResource(this.bTo, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar != null) {
            this.gDe.b(kVar.gAY);
            this.gDf.b(kVar.gAZ);
            if (kVar.gBa) {
                this.bTo.setVisibility(0);
            } else {
                this.bTo.setVisibility(8);
            }
        }
    }

    public void a(i iVar) {
        this.gDe.a(iVar);
        this.gDf.a(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
