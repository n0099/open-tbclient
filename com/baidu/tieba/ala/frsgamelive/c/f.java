package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext eyT;
    private d eyU;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eyT = tbPageContext;
        initView();
    }

    private void initView() {
        this.eyU = new d(this.eyT);
        ((ViewGroup) getView()).addView(this.eyU.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eyU != null) {
            this.eyU.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.cNb != null && this.eyU != null) {
            this.eyU.a(cVar.cNb);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.eyU != null) {
            this.eyU.d(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public f eyV;

        public a(f fVar) {
            super(fVar.getView());
            this.eyV = fVar;
        }
    }
}
