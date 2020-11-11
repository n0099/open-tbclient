package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private c grX;
    private c grY;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.grX = new c(getTbPageContext(), z);
        this.grY = new c(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.grX.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.grY.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.grX.onChangeSkinType(tbPageContext, i);
        this.grY.onChangeSkinType(tbPageContext, i);
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
            this.grX.a(aVar.gke);
            this.grY.a(aVar.gkf);
        }
    }

    public void d(i iVar) {
        this.grX.c(iVar);
        this.grY.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
