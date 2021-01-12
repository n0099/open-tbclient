package com.baidu.tieba.ala.alasquare.subtablist.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.a> {
    private b gGm;
    private b gGn;

    public a(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.gGm = new b(getTbPageContext(), z);
        this.gGn = new b(getTbPageContext(), z);
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gGm.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds4), -1));
        viewGroup.addView(this.gGn.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gGm.onChangeSkinType(tbPageContext, i);
        this.gGn.onChangeSkinType(tbPageContext, i);
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
            this.gGm.a(aVar.gyo);
            this.gGn.a(aVar.gyp);
        }
    }

    public void d(g gVar) {
        this.gGm.c(gVar);
        this.gGn.c(gVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
