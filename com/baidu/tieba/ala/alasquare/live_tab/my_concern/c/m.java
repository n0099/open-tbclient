package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c> {
    ViewGroup AE;
    private k dyq;
    private k dyr;
    private k dys;

    public m(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dyq = new k(tbPageContext);
        this.dyr = new k(tbPageContext);
        this.dys = new k(tbPageContext);
        this.AE = (ViewGroup) getView();
        new View(getContext());
        this.AE.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.AE.addView(this.dyq.getView());
        this.AE.addView(this.dyr.getView());
        this.AE.addView(this.dys.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.AE, R.color.cp_bg_line_d);
        this.dyq.onChangeSkinType(tbPageContext, i);
        this.dyr.onChangeSkinType(tbPageContext, i);
        this.dys.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar) {
        if (cVar != null) {
            this.dyq.b(cVar.dwA);
            this.dyr.b(cVar.dxk);
            this.dys.b(cVar.dwB);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(o oVar) {
        this.dyq.a(oVar);
        this.dyr.a(oVar);
        this.dys.a(oVar);
    }
}
