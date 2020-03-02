package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext eDb;
    private d eDc;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eDb = tbPageContext;
        initView();
    }

    private void initView() {
        this.eDc = new d(this.eDb);
        ((ViewGroup) getView()).addView(this.eDc.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eDc != null) {
            this.eDc.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.cRf != null && this.eDc != null) {
            this.eDc.a(cVar.cRf);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.eDc != null) {
            this.eDc.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public f eDd;

        public a(f fVar) {
            super(fVar.getView());
            this.eDd = fVar;
        }
    }
}
