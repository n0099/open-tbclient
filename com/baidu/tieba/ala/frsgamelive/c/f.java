package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gEh;
    private d gEi;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gEh = tbPageContext;
        initView();
    }

    private void initView() {
        this.gEi = new d(this.gEh);
        ((ViewGroup) getView()).addView(this.gEi.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gEi != null) {
            this.gEi.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.exA != null && this.gEi != null) {
            this.gEi.a(cVar.exA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        if (this.gEi != null) {
            this.gEi.d(fVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public f gEj;

        public a(f fVar) {
            super(fVar.getView());
            this.gEj = fVar;
        }
    }
}
