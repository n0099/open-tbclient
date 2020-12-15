package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext gMN;
    private d gMO;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gMN = tbPageContext;
        initView();
    }

    private void initView() {
        this.gMO = new d(this.gMN);
        ((ViewGroup) getView()).addView(this.gMO.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gMO != null) {
            this.gMO.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eCR != null && this.gMO != null) {
            this.gMO.a(cVar.eCR);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        if (this.gMO != null) {
            this.gMO.d(fVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public f gMP;

        public a(f fVar) {
            super(fVar.getView());
            this.gMP = fVar;
        }
    }
}
