package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.c> {
    private TbPageContext fie;
    private d fif;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fie = tbPageContext;
        initView();
    }

    private void initView() {
        this.fif = new d(this.fie);
        ((ViewGroup) getView()).addView(this.fif.getView());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fif != null) {
            this.fif.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.c cVar) {
        if (cVar != null && cVar.dqA != null && this.fif != null) {
            this.fif.a(cVar.dqA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        if (this.fif != null) {
            this.fif.d(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public f fig;

        public a(f fVar) {
            super(fVar.getView());
            this.fig = fVar;
        }
    }
}
