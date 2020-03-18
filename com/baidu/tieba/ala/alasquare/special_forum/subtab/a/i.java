package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private b etJ;
    private b etK;

    public i(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.etJ = new b(getTbPageContext());
        this.etK = new b(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.etJ.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.etK.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.etJ.onChangeSkinType(tbPageContext, i);
        this.etK.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_special_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.etJ.b(bVar.emz);
            this.etK.b(bVar.emA);
        }
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, int i) {
        if (bVar != null) {
            this.etJ.a(bVar.emz, i);
            this.etK.a(bVar.emA, i);
        }
    }

    public void d(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.etJ.c(iVar);
        this.etK.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
