package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class h extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c> {
    private g gDM;
    private g gDN;
    private g gDO;
    ViewGroup rootView;

    public h(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gDM = new g(tbPageContext);
        this.gDN = new g(tbPageContext);
        this.gDO = new g(tbPageContext);
        this.rootView = (ViewGroup) getView();
        new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.gDM.getView());
        this.rootView.addView(this.gDN.getView());
        this.rootView.addView(this.gDO.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        this.gDM.onChangeSkinType(tbPageContext, i);
        this.gDN.onChangeSkinType(tbPageContext, i);
        this.gDO.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar) {
        if (cVar != null) {
            this.gDM.b(cVar.gBm);
            this.gDN.b(cVar.gCH);
            this.gDO.b(cVar.gBn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(i iVar) {
        this.gDM.a(iVar);
        this.gDN.a(iVar);
        this.gDO.a(iVar);
    }
}
