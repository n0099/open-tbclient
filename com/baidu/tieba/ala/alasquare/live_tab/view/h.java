package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.e> {
    private boolean fcD;
    private k fgA;
    private k fgz;
    private ViewGroup rootView;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fcD = false;
        this.fgz = new k(tbPageContext);
        this.fgz.jl(this.fcD);
        this.fgA = new k(tbPageContext);
        this.fgA.jl(this.fcD);
        this.rootView = (ViewGroup) getView();
        View view = new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.fgz.getView());
        this.rootView.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.rootView.addView(this.fgA.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fgz.onChangeSkinType(tbPageContext, i);
        this.fgA.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar) {
        if (eVar != null) {
            this.fgz.a(eVar.fcM);
            this.fgA.a(eVar.fcN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jl(boolean z) {
        this.fcD = z;
    }
}
