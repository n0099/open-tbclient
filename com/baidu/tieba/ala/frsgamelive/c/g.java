package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private h eDd;
    private TbPageContext mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.eDd = new h(this.mPageContext);
        ((ViewGroup) getView()).addView(this.eDd.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eDd != null) {
            this.eDd.onChangeSkinType(tbPageContext, i);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.eDd != null) {
            this.eDd.d(dVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.cRe != null && this.eDd != null) {
            this.eDd.a(cVar.cRe);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public g eDe;

        public a(g gVar) {
            super(gVar.getView());
            this.eDe = gVar;
        }
    }
}
