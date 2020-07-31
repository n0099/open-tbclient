package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private c fBe;
    private c fBf;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fBe = new c(getTbPageContext(), z);
        this.fBf = new c(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fBe.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.fBf.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fBe.onChangeSkinType(tbPageContext, i);
        this.fBf.onChangeSkinType(tbPageContext, i);
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
            this.fBe.a(aVar.fts);
            this.fBf.a(aVar.ftt);
        }
    }

    public void d(i iVar) {
        this.fBe.c(iVar);
        this.fBf.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
