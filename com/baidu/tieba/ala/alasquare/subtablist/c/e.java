package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private g dED;
    private g dEE;

    public e(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dED = new g(getTbPageContext(), z);
        this.dEE = new g(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.dED.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.dEE.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dED.onChangeSkinType(tbPageContext, i);
        this.dEE.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.dED.b(bVar.dxr);
            this.dEE.b(bVar.dxs);
        }
    }

    public void d(h hVar) {
        this.dED.c(hVar);
        this.dEE.c(hVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
