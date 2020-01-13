package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c> {
    private k ekg;
    private k ekh;
    private k eki;
    ViewGroup rootView;

    public m(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ekg = new k(tbPageContext);
        this.ekh = new k(tbPageContext);
        this.eki = new k(tbPageContext);
        this.rootView = (ViewGroup) getView();
        new View(getContext());
        this.rootView.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.rootView.addView(this.ekg.getView());
        this.rootView.addView(this.ekh.getView());
        this.rootView.addView(this.eki.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        this.ekg.onChangeSkinType(tbPageContext, i);
        this.ekh.onChangeSkinType(tbPageContext, i);
        this.eki.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar) {
        if (cVar != null) {
            this.ekg.b(cVar.ehP);
            this.ekh.b(cVar.eja);
            this.eki.b(cVar.ehQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(o oVar) {
        this.ekg.a(oVar);
        this.ekh.a(oVar);
        this.eki.a(oVar);
    }
}
