package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View cRQ;
    private d ejM;
    private d ejN;
    private LinearLayout ejO;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ejM = new d(tbPageContext);
        this.ejN = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.ejO = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.cRQ = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.ejO.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.ejO.addView(this.ejM.getView());
        this.ejO.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.ejO.addView(this.ejN.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.ejM.onChangeSkinType(tbPageContext, i);
        this.ejN.onChangeSkinType(tbPageContext, i);
        am.setBackgroundResource(this.cRQ, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.ejM.b(kVar.ehP);
            this.ejN.b(kVar.ehQ);
            if (kVar.ehR) {
                this.cRQ.setVisibility(0);
            } else {
                this.cRQ.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.ejM.a(oVar);
        this.ejN.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
