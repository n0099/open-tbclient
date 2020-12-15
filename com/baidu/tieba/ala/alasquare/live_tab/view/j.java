package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class j extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.e> {
    private l gvJ;
    private l gvK;
    private ViewGroup rootView;

    public j(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i) {
        super(tbPageContext, viewGroup);
        this.gvJ = new l(tbPageContext, i);
        this.gvK = new l(tbPageContext, i);
        this.rootView = (ViewGroup) getView();
        View view = new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.gvJ.getView());
        this.rootView.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.rootView.addView(this.gvK.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gvJ.onChangeSkinType(tbPageContext, i);
        this.gvK.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar) {
        if (eVar != null) {
            this.gvJ.a(eVar.grK);
            this.gvK.a(eVar.grL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
