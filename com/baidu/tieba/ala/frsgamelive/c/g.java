package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private h fwf;
    private TbPageContext mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.fwf = new h(this.mPageContext);
        ((ViewGroup) getView()).addView(this.fwf.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fwf != null) {
            this.fwf.onChangeSkinType(tbPageContext, i);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.fwf != null) {
            this.fwf.d(dVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dEA != null && this.fwf != null) {
            this.fwf.a(cVar.dEA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public g fwg;

        public a(g gVar) {
            super(gVar.getView());
            this.fwg = gVar;
        }
    }
}
