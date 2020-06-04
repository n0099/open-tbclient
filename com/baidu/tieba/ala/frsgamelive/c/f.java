package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fwc;
    private d fwd;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fwc = tbPageContext;
        initView();
    }

    private void initView() {
        this.fwd = new d(this.fwc);
        ((ViewGroup) getView()).addView(this.fwd.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fwd != null) {
            this.fwd.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dEA != null && this.fwd != null) {
            this.fwd.a(cVar.dEA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.fwd != null) {
            this.fwd.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public f fwe;

        public a(f fVar) {
            super(fVar.getView());
            this.fwe = fVar;
        }
    }
}
