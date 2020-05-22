package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fvR;
    private d fvS;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fvR = tbPageContext;
        initView();
    }

    private void initView() {
        this.fvS = new d(this.fvR);
        ((ViewGroup) getView()).addView(this.fvS.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fvS != null) {
            this.fvS.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dEA != null && this.fvS != null) {
            this.fvS.a(cVar.dEA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.fvS != null) {
            this.fvS.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public f fvT;

        public a(f fVar) {
            super(fVar.getView());
            this.fvT = fVar;
        }
    }
}
