package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext dJs;
    private d dJt;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dJs = tbPageContext;
        initView();
    }

    private void initView() {
        this.dJt = new d(this.dJs);
        ((ViewGroup) getView()).addView(this.dJt.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dJt != null) {
            this.dJt.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.caz != null && this.dJt != null) {
            this.dJt.a(cVar.caz);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.dJt != null) {
            this.dJt.d(dVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public f dJu;

        public a(f fVar) {
            super(fVar.getView());
            this.dJu = fVar;
        }
    }
}
