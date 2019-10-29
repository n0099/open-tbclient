package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext dKj;
    private d dKk;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dKj = tbPageContext;
        initView();
    }

    private void initView() {
        this.dKk = new d(this.dKj);
        ((ViewGroup) getView()).addView(this.dKk.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dKk != null) {
            this.dKk.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.cbq != null && this.dKk != null) {
            this.dKk.a(cVar.cbq);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.dKk != null) {
            this.dKk.d(dVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public f dKl;

        public a(f fVar) {
            super(fVar.getView());
            this.dKl = fVar;
        }
    }
}
