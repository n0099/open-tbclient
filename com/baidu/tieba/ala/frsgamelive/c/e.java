package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h fHj;
    private h fHk;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fHj.onChangeSkinType(tbPageContext, i);
        this.fHk.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fHj.a(aVar.fHP);
            this.fHk.a(aVar.fHQ);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fHj.d(dVar);
        this.fHk.d(dVar);
    }

    public void setLabelName(String str) {
        this.fHj.setLabelName(str);
        this.fHk.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fHj = new h(getTbPageContext());
        this.fHk = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fHj.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fHk.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends ad.a {
        public e fHl;

        public a(e eVar) {
            super(eVar.getView());
            this.fHl = eVar;
        }
    }
}
