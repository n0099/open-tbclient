package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class m extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c> {
    private k fHe;
    private k fHf;
    private k fHg;
    ViewGroup rootView;

    public m(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fHe = new k(tbPageContext);
        this.fHf = new k(tbPageContext);
        this.fHg = new k(tbPageContext);
        this.rootView = (ViewGroup) getView();
        new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.fHe.getView());
        this.rootView.addView(this.fHf.getView());
        this.rootView.addView(this.fHg.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.fHe.onChangeSkinType(tbPageContext, i);
        this.fHf.onChangeSkinType(tbPageContext, i);
        this.fHg.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar) {
        if (cVar != null) {
            this.fHe.b(cVar.fEL);
            this.fHf.b(cVar.fFZ);
            this.fHg.b(cVar.fEM);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(o oVar) {
        this.fHe.a(oVar);
        this.fHf.a(oVar);
        this.fHg.a(oVar);
    }
}
