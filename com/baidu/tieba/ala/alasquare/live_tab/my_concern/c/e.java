package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private View dJr;
    private d feX;
    private d feY;
    private LinearLayout feZ;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.feX = new d(tbPageContext);
        this.feY = new d(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.feZ = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.dJr = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.feZ.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.feZ.addView(this.feX.getView());
        this.feZ.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.feZ.addView(this.feY.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.feX.onChangeSkinType(tbPageContext, i);
        this.feY.onChangeSkinType(tbPageContext, i);
        am.setBackgroundResource(this.dJr, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.feX.b(kVar.fcY);
            this.feY.b(kVar.fcZ);
            if (kVar.fda) {
                this.dJr.setVisibility(0);
            } else {
                this.dJr.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.feX.a(oVar);
        this.feY.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
