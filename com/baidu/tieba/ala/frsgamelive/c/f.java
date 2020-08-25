package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fYF;
    private d fYG;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fYF = tbPageContext;
        initView();
    }

    private void initView() {
        this.fYG = new d(this.fYF);
        ((ViewGroup) getView()).addView(this.fYG.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fYG != null) {
            this.fYG.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dUS != null && this.fYG != null) {
            this.fYG.a(cVar.dUS);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        if (this.fYG != null) {
            this.fYG.d(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public f fYH;

        public a(f fVar) {
            super(fVar.getView());
            this.fYH = fVar;
        }
    }
}
