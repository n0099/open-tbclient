package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.e> {
    private a grj;
    private a grk;

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.grj = new a(getTbPageContext());
        this.grk = new a(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.grj.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.grk.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.grj.onChangeSkinType(tbPageContext, i);
        this.grk.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_special_game_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar) {
        if (eVar != null) {
            this.grj.a(eVar.gjS);
            this.grk.a(eVar.gjT);
        }
    }

    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, String str) {
        if (eVar != null) {
            this.grj.a(eVar.gjS, str);
            this.grk.a(eVar.gjT, str);
        }
    }

    public void c(com.baidu.tieba.ala.alasquare.subtablist.c.h hVar) {
        this.grj.b(hVar);
        this.grk.b(hVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
