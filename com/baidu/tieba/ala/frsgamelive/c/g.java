package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private h eyW;
    private TbPageContext mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.eyW = new h(this.mPageContext);
        ((ViewGroup) getView()).addView(this.eyW.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eyW != null) {
            this.eyW.onChangeSkinType(tbPageContext, i);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.eyW != null) {
            this.eyW.d(dVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.cNb != null && this.eyW != null) {
            this.eyW.a(cVar.cNb);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public g eyX;

        public a(g gVar) {
            super(gVar.getView());
            this.eyX = gVar;
        }
    }
}
