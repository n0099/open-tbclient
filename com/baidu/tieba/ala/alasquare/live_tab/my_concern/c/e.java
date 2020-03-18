package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View cWh;
    private d eoC;
    private d eoD;
    private LinearLayout eoE;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eoC = new d(tbPageContext);
        this.eoD = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.eoE = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.cWh = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.eoE.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.eoE.addView(this.eoC.getView());
        this.eoE.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.eoE.addView(this.eoD.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.eoC.onChangeSkinType(tbPageContext, i);
        this.eoD.onChangeSkinType(tbPageContext, i);
        am.setBackgroundResource(this.cWh, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.eoC.b(kVar.emz);
            this.eoD.b(kVar.emA);
            if (kVar.emB) {
                this.cWh.setVisibility(0);
            } else {
                this.cWh.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.eoC.a(oVar);
        this.eoD.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
