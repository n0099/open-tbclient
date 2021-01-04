package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private View bUk;
    private c gFa;
    private c gFb;
    private LinearLayout gFc;
    private ViewGroup rootView;

    public d(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFa = new c(tbPageContext);
        this.gFb = new c(tbPageContext);
        this.rootView = (ViewGroup) getView();
        this.gFc = (LinearLayout) this.rootView.findViewById(R.id.id_tab_live_sub_row);
        this.bUk = this.rootView.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.gFc.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.gFc.addView(this.gFa.getView());
        this.gFc.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.gFc.addView(this.gFb.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gFa.onChangeSkinType(tbPageContext, i);
        this.gFb.onChangeSkinType(tbPageContext, i);
        ao.setBackgroundResource(this.bUk, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar != null) {
            this.gFa.b(kVar.gCV);
            this.gFb.b(kVar.gCW);
            if (kVar.gCX) {
                this.bUk.setVisibility(0);
            } else {
                this.bUk.setVisibility(8);
            }
        }
    }

    public void a(i iVar) {
        this.gFa.a(iVar);
        this.gFb.a(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
