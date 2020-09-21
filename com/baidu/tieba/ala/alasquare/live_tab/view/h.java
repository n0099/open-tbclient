package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.e> {
    private boolean fHG;
    private k fLG;
    private k fLH;
    private ViewGroup rootView;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fHG = false;
        this.fLG = new k(tbPageContext);
        this.fLG.kE(this.fHG);
        this.fLH = new k(tbPageContext);
        this.fLH.kE(this.fHG);
        this.rootView = (ViewGroup) getView();
        View view = new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.fLG.getView());
        this.rootView.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.rootView.addView(this.fLH.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fLG.onChangeSkinType(tbPageContext, i);
        this.fLH.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar) {
        if (eVar != null) {
            this.fLG.a(eVar.fHP);
            this.fLH.a(eVar.fHQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void kE(boolean z) {
        this.fHG = z;
    }
}
