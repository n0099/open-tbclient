package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.e> {
    private boolean gCA;
    private g gGG;
    private g gGH;
    private ViewGroup rootView;

    public e(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gCA = false;
        this.gGG = new g(tbPageContext);
        this.gGG.mw(this.gCA);
        this.gGH = new g(tbPageContext);
        this.gGH.mw(this.gCA);
        this.rootView = (ViewGroup) getView();
        View view = new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.gGG.getView());
        this.rootView.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.rootView.addView(this.gGH.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gGG.onChangeSkinType(tbPageContext, i);
        this.gGH.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar) {
        if (eVar != null) {
            this.gGG.a(eVar.gCJ);
            this.gGH.a(eVar.gCK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mw(boolean z) {
        this.gCA = z;
    }
}
