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
    private ViewGroup Bg;
    private View cfY;
    private d dyN;
    private d dyO;
    private LinearLayout dyP;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dyN = new d(tbPageContext);
        this.dyO = new d(tbPageContext);
        this.Bg = (ViewGroup) getView();
        this.dyP = (LinearLayout) this.Bg.findViewById(R.id.id_tab_live_sub_row);
        this.cfY = this.Bg.findViewById(R.id.id_tab_live_sub_line_divider);
        View view = new View(getContext());
        this.dyP.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.dyP.addView(this.dyN.getView());
        this.dyP.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.dyP.addView(this.dyO.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.Bg, R.color.cp_bg_line_d);
        this.dyN.onChangeSkinType(tbPageContext, i);
        this.dyO.onChangeSkinType(tbPageContext, i);
        am.setBackgroundResource(this.cfY, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar != null) {
            this.dyN.b(iVar.dxr);
            this.dyO.b(iVar.dxs);
            if (iVar.dxt) {
                this.cfY.setVisibility(0);
            } else {
                this.cfY.setVisibility(8);
            }
        }
    }

    public void a(o oVar) {
        this.dyN.a(oVar);
        this.dyO.a(oVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
