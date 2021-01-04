package com.baidu.tieba.ala.alasquare.subtablist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private b gKS;
    private b gKT;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gKS = new b(getTbPageContext(), z);
        this.gKT = new b(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gKS.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.gKT.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gKS.onChangeSkinType(tbPageContext, i);
        this.gKT.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            this.gKS.a(aVar.gCV);
            this.gKT.a(aVar.gCW);
        }
    }

    public void d(g gVar) {
        this.gKS.c(gVar);
        this.gKT.c(gVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
