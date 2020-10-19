package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext goo;
    private d gop;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.goo = tbPageContext;
        initView();
    }

    private void initView() {
        this.gop = new d(this.goo);
        ((ViewGroup) getView()).addView(this.gop.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gop != null) {
            this.gop.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.eji != null && this.gop != null) {
            this.gop.a(cVar.eji);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        if (this.gop != null) {
            this.gop.d(fVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public f goq;

        public a(f fVar) {
            super(fVar.getView());
            this.goq = fVar;
        }
    }
}
