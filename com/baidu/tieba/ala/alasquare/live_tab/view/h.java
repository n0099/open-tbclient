package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    ViewGroup AE;
    private j dzr;
    private j dzs;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dzr = new j(tbPageContext);
        this.dzs = new j(tbPageContext);
        this.AE = (ViewGroup) getView();
        View view = new View(getContext());
        this.AE.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.AE.addView(this.dzr.getView());
        this.AE.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.AE.addView(this.dzs.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.AE, R.color.cp_bg_line_d);
        this.dzr.onChangeSkinType(tbPageContext, i);
        this.dzs.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar != null) {
            this.dzr.b(iVar.dwA);
            this.dzs.b(iVar.dwB);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
