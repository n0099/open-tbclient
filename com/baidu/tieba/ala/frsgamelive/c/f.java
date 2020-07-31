package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fMH;
    private d fMI;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fMH = tbPageContext;
        initView();
    }

    private void initView() {
        this.fMI = new d(this.fMH);
        ((ViewGroup) getView()).addView(this.fMI.getView());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fMI != null) {
            this.fMI.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dLK != null && this.fMI != null) {
            this.fMI.a(cVar.dLK);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        if (this.fMI != null) {
            this.fMI.d(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ad.a {
        public f fMJ;

        public a(f fVar) {
            super(fVar.getView());
            this.fMJ = fVar;
        }
    }
}
