package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.subtablist.b.b> {
    private b fke;
    private b fkf;

    public i(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fke = new b(getTbPageContext());
        this.fkf = new b(getTbPageContext());
        ViewGroup viewGroup2 = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup2.addView(this.fke.getView());
        viewGroup2.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds6), -1));
        viewGroup2.addView(this.fkf.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fke.onChangeSkinType(tbPageContext, i);
        this.fkf.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_special_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            this.fke.b(bVar.fcY);
            this.fkf.b(bVar.fcZ);
        }
    }

    public void a(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, int i) {
        if (bVar != null) {
            this.fke.a(bVar.fcY, i);
            this.fkf.a(bVar.fcZ, i);
        }
    }

    public void d(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.fke.c(iVar);
        this.fkf.c(iVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
