package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private h fMK;
    private TbPageContext mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.fMK = new h(this.mPageContext);
        ((ViewGroup) getView()).addView(this.fMK.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fMK != null) {
            this.fMK.onChangeSkinType(tbPageContext, i);
        }
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        if (this.fMK != null) {
            this.fMK.d(eVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dLK != null && this.fMK != null) {
            this.fMK.a(cVar.dLK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends ad.a {
        public g fML;

        public a(g gVar) {
            super(gVar.getView());
            this.fML = gVar;
        }
    }
}
