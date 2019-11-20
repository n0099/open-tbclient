package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private ViewGroup AE;
    private View cfh;
    private d dxW;
    private d dxX;
    private LinearLayout dxY;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dxW = new d(tbPageContext);
        this.dxX = new d(tbPageContext);
        this.AE = (ViewGroup) getView();
        this.dxY = (LinearLayout) this.AE.findViewById(R.id.id_tab_live_sub_row);
        this.cfh = this.AE.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.dxY.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.dxY.addView(this.dxW.getView());
        this.dxY.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.dxY.addView(this.dxX.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.AE, R.color.cp_bg_line_d);
        this.dxW.onChangeSkinType(tbPageContext, i);
        this.dxX.onChangeSkinType(tbPageContext, i);
        am.setBackgroundResource(this.cfh, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar != null) {
            this.dxW.b(iVar.dwA);
            this.dxX.b(iVar.dwB);
            if (iVar.dwC) {
                this.cfh.setVisibility(0);
            } else {
                this.cfh.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.dxW.a(oVar);
        this.dxX.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
