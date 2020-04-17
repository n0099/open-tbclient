package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h fia;
    private h fib;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fia.onChangeSkinType(tbPageContext, i);
        this.fib.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fia.a(aVar.fiI);
            this.fib.a(aVar.fiJ);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fia.d(dVar);
        this.fib.d(dVar);
    }

    public void setLabelName(String str) {
        this.fia.setLabelName(str);
        this.fib.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fia = new h(getTbPageContext());
        this.fib = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fia.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fib.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public e fic;

        public a(e eVar) {
            super(eVar.getView());
            this.fic = eVar;
        }
    }
}
