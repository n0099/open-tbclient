package com.baidu.tieba.ala.alasquare.subtablist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private e gJO;
    private e gJP;

    public d(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gJO = new e(getTbPageContext(), z);
        this.gJP = new e(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gJO.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.gJP.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gJO.onChangeSkinType(tbPageContext, i);
        this.gJP.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.gJO.b(bVar.gBm);
            this.gJP.b(bVar.gBn);
        }
    }

    public void d(g gVar) {
        this.gJO.c(gVar);
        this.gJP.c(gVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
