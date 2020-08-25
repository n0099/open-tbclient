package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.e> {
    private a fLI;
    private a fLJ;

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fLI = new a(getTbPageContext());
        this.fLJ = new a(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.fLI.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.fLJ.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fLI.onChangeSkinType(tbPageContext, i);
        this.fLJ.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_special_game_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar) {
        if (eVar != null) {
            this.fLI.a(eVar.fEz);
            this.fLJ.a(eVar.fEA);
        }
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, String str) {
        if (eVar != null) {
            this.fLI.a(eVar.fEz, str);
            this.fLJ.a(eVar.fEA, str);
        }
    }

    public void c(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.fLI.b(hVar);
        this.fLJ.b(hVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
