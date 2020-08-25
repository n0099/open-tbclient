package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private g fNa;
    private g fNb;

    public e(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fNa = new g(getTbPageContext(), z);
        this.fNb = new g(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fNa.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.fNb.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fNa.onChangeSkinType(tbPageContext, i);
        this.fNb.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.fNa.b(bVar.fEL);
            this.fNb.b(bVar.fEM);
        }
    }

    public void d(i iVar) {
        this.fNa.c(iVar);
        this.fNb.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
