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
    private a gFy;
    private a gFz;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFy = new a(getTbPageContext());
        this.gFz = new a(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.gFy.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.gFz.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gFy.onChangeSkinType(tbPageContext, i);
        this.gFz.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_special_game_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(e eVar) {
        if (eVar != null) {
            this.gFy.a(eVar.gyc);
            this.gFz.a(eVar.gyd);
        }
    }

    public void a(e eVar, String str) {
        if (eVar != null) {
            this.gFy.a(eVar.gyc, str);
            this.gFz.a(eVar.gyd, str);
        }
    }

    public void c(f fVar) {
        this.gFy.b(fVar);
        this.gFz.b(fVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
