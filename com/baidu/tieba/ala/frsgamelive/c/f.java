package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext eDK;
    private d eDL;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eDK = tbPageContext;
        initView();
    }

    private void initView() {
        this.eDL = new d(this.eDK);
        ((ViewGroup) getView()).addView(this.eDL.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eDL != null) {
            this.eDL.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.cRt != null && this.eDL != null) {
            this.eDL.a(cVar.cRt);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.eDL != null) {
            this.eDL.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public f eDM;

        public a(f fVar) {
            super(fVar.getView());
            this.eDM = fVar;
        }
    }
}
