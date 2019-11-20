package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private c dDi;
    private c dDj;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.dDi = new c(getTbPageContext(), z);
        this.dDj = new c(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.dDi.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.dDj.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dDi.onChangeSkinType(tbPageContext, i);
        this.dDj.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_new_square_sub_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            this.dDi.a(aVar.dwA);
            this.dDj.a(aVar.dwB);
        }
    }

    public void d(h hVar) {
        this.dDi.c(hVar);
        this.dDj.c(hVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
