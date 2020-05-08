package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h fig;
    private h fih;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fig.onChangeSkinType(tbPageContext, i);
        this.fih.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fig.a(aVar.fiN);
            this.fih.a(aVar.fiO);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fig.d(dVar);
        this.fih.d(dVar);
    }

    public void setLabelName(String str) {
        this.fig.setLabelName(str);
        this.fih.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fig = new h(getTbPageContext());
        this.fih = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fig.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fih.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public e fii;

        public a(e eVar) {
            super(eVar.getView());
            this.fii = eVar;
        }
    }
}
