package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.k> {
    private l ell;
    private l elm;
    private ViewGroup rootView;

    public i(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i) {
        super(tbPageContext, viewGroup);
        this.ell = new l(tbPageContext, i);
        this.elm = new l(tbPageContext, i);
        this.rootView = (ViewGroup) getView();
        View view = new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.ell.getView());
        this.rootView.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.rootView.addView(this.elm.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.ell.onChangeSkinType(tbPageContext, i);
        this.elm.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.k kVar) {
        if (kVar != null) {
            this.ell.b(kVar.ehP);
            this.elm.b(kVar.ehQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
