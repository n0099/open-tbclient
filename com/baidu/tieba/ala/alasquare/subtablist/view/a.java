package com.baidu.tieba.ala.alasquare.subtablist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private b gJk;
    private b gJl;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gJk = new b(getTbPageContext(), z);
        this.gJl = new b(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gJk.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.gJl.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gJk.onChangeSkinType(tbPageContext, i);
        this.gJl.onChangeSkinType(tbPageContext, i);
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
            this.gJk.a(aVar.gBm);
            this.gJl.a(aVar.gBn);
        }
    }

    public void d(g gVar) {
        this.gJk.c(gVar);
        this.gJl.c(gVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
