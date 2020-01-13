package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private c epu;
    private c epv;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.epu = new c(getTbPageContext(), z);
        this.epv = new c(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.epu.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.epv.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.epu.onChangeSkinType(tbPageContext, i);
        this.epv.onChangeSkinType(tbPageContext, i);
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
            this.epu.a(aVar.ehP);
            this.epv.a(aVar.ehQ);
        }
    }

    public void d(i iVar) {
        this.epu.c(iVar);
        this.epv.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
