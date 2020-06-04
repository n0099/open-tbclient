package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private c fkK;
    private c fkL;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fkK = new c(getTbPageContext(), z);
        this.fkL = new c(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fkK.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.fkL.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fkK.onChangeSkinType(tbPageContext, i);
        this.fkL.onChangeSkinType(tbPageContext, i);
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
            this.fkK.a(aVar.fcY);
            this.fkL.a(aVar.fcZ);
        }
    }

    public void d(i iVar) {
        this.fkK.c(iVar);
        this.fkL.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
