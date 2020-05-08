package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fij;
    private d fik;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fij = tbPageContext;
        initView();
    }

    private void initView() {
        this.fik = new d(this.fij);
        ((ViewGroup) getView()).addView(this.fik.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fik != null) {
            this.fik.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dqE != null && this.fik != null) {
            this.fik.a(cVar.dqE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.fik != null) {
            this.fik.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public f fil;

        public a(f fVar) {
            super(fVar.getView());
            this.fil = fVar;
        }
    }
}
