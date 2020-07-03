package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fHm;
    private d fHn;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fHm = tbPageContext;
        initView();
    }

    private void initView() {
        this.fHn = new d(this.fHm);
        ((ViewGroup) getView()).addView(this.fHn.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fHn != null) {
            this.fHn.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dLi != null && this.fHn != null) {
            this.fHn.a(cVar.dLi);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.fHn != null) {
            this.fHn.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends ad.a {
        public f fHo;

        public a(f fVar) {
            super(fVar.getView());
            this.fHo = fVar;
        }
    }
}
