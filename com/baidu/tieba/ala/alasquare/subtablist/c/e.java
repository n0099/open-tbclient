package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private g epY;
    private g epZ;

    public e(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.epY = new g(getTbPageContext(), z);
        this.epZ = new g(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.epY.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds4), -1));
        viewGroup.addView(this.epZ.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.epY.onChangeSkinType(tbPageContext, i);
        this.epZ.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.epY.b(bVar.ehP);
            this.epZ.b(bVar.ehQ);
        }
    }

    public void d(i iVar) {
        this.epY.c(iVar);
        this.epZ.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
