package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fYJ;
    private d fYK;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fYJ = tbPageContext;
        initView();
    }

    private void initView() {
        this.fYK = new d(this.fYJ);
        ((ViewGroup) getView()).addView(this.fYK.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fYK != null) {
            this.fYK.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dUW != null && this.fYK != null) {
            this.fYK.a(cVar.dUW);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        if (this.fYK != null) {
            this.fYK.d(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public f fYL;

        public a(f fVar) {
            super(fVar.getView());
            this.fYL = fVar;
        }
    }
}
