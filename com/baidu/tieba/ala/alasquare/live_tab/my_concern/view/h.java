package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c> {
    private g gFu;
    private g gFv;
    private g gFw;
    ViewGroup rootView;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFu = new g(tbPageContext);
        this.gFv = new g(tbPageContext);
        this.gFw = new g(tbPageContext);
        this.rootView = (ViewGroup) getView();
        new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.gFu.getView());
        this.rootView.addView(this.gFv.getView());
        this.rootView.addView(this.gFw.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gFu.onChangeSkinType(tbPageContext, i);
        this.gFv.onChangeSkinType(tbPageContext, i);
        this.gFw.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar) {
        if (cVar != null) {
            this.gFu.b(cVar.gCV);
            this.gFv.b(cVar.gEq);
            this.gFw.b(cVar.gCW);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(i iVar) {
        this.gFu.a(iVar);
        this.gFv.a(iVar);
        this.gFw.a(iVar);
    }
}
