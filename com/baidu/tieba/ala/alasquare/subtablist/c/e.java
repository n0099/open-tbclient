package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private g gsB;
    private g gsC;

    public e(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gsB = new g(getTbPageContext(), z);
        this.gsC = new g(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gsB.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.gsC.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gsB.onChangeSkinType(tbPageContext, i);
        this.gsC.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.gsB.b(bVar.gke);
            this.gsC.b(bVar.gkf);
        }
    }

    public void d(i iVar) {
        this.gsB.c(iVar);
        this.gsC.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
