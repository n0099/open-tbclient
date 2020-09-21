package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View eis;
    private d fKa;
    private d fKb;
    private LinearLayout fKc;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fKa = new d(tbPageContext);
        this.fKb = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.fKc = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.eis = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.fKc.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.fKc.addView(this.fKa.getView());
        this.fKc.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.fKc.addView(this.fKb.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fKa.onChangeSkinType(tbPageContext, i);
        this.fKb.onChangeSkinType(tbPageContext, i);
        ap.setBackgroundResource(this.eis, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.fKa.b(kVar.fIb);
            this.fKb.b(kVar.fIc);
            if (kVar.fId) {
                this.eis.setVisibility(0);
            } else {
                this.eis.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.fKa.a(oVar);
        this.fKb.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
