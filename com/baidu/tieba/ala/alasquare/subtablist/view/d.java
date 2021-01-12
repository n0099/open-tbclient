package com.baidu.tieba.ala.alasquare.subtablist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private e gGQ;
    private e gGR;

    public d(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gGQ = new e(getTbPageContext(), z);
        this.gGR = new e(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gGQ.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.gGR.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gGQ.onChangeSkinType(tbPageContext, i);
        this.gGR.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.gGQ.b(bVar.gyo);
            this.gGR.b(bVar.gyp);
        }
    }

    public void d(g gVar) {
        this.gGQ.c(gVar);
        this.gGR.c(gVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
