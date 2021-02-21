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
    private c gDs;
    private c gDt;
    private LinearLayout gDu;
    private ViewGroup rootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gDs = new c(tbPageContext);
        this.gDt = new c(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gDu = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.bTo = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gDu.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gDu.addView(this.gDs.getView());
        this.gDu.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gDu.addView(this.gDt.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gDs.onChangeSkinType(tbPageContext, i);
        this.gDt.onChangeSkinType(tbPageContext, i);
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
            this.gDs.b(kVar.gBm);
            this.gDt.b(kVar.gBn);
            if (kVar.gBo) {
                this.bTo.setVisibility(0);
            } else {
                this.bTo.setVisibility(8);
            }
        }
    }

    public void a(i iVar) {
        this.gDs.a(iVar);
        this.gDt.a(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
