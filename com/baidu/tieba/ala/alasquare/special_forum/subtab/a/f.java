package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private a dDr;
    private a dDs;

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dDr = new a(getTbPageContext());
        this.dDs = new a(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.dDr.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.dDs.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dDr.onChangeSkinType(tbPageContext, i);
        this.dDs.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_special_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.dDr.b(bVar.dxr);
            this.dDs.b(bVar.dxs);
        }
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, int i) {
        if (bVar != null) {
            this.dDr.a(bVar.dxr, i);
            this.dDs.a(bVar.dxs, i);
        }
    }

    public void d(h hVar) {
        this.dDr.c(hVar);
        this.dDs.c(hVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
