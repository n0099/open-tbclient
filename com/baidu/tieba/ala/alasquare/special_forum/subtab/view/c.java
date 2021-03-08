package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.e;
import com.baidu.tieba.ala.alasquare.subtablist.view.f;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<e> {
    private a gKf;
    private a gKg;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gKf = new a(getTbPageContext());
        this.gKg = new a(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.gKf.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.gKg.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gKf.onChangeSkinType(tbPageContext, i);
        this.gKg.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_special_game_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(e eVar) {
        if (eVar != null) {
            this.gKf.a(eVar.gCJ);
            this.gKg.a(eVar.gCK);
        }
    }

    public void a(e eVar, String str) {
        if (eVar != null) {
            this.gKf.a(eVar.gCJ, str);
            this.gKg.a(eVar.gCK, str);
        }
    }

    public void c(f fVar) {
        this.gKf.b(fVar);
        this.gKg.b(fVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
