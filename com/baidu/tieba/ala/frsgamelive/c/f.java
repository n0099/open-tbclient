package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gML;
    private d gMM;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gML = tbPageContext;
        initView();
    }

    private void initView() {
        this.gMM = new d(this.gML);
        ((ViewGroup) getView()).addView(this.gMM.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gMM != null) {
            this.gMM.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eCR != null && this.gMM != null) {
            this.gMM.a(cVar.eCR);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        if (this.gMM != null) {
            this.gMM.d(fVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public f gMN;

        public a(f fVar) {
            super(fVar.getView());
            this.gMN = fVar;
        }
    }
}
