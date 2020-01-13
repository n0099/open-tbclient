package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h eyQ;
    private h eyR;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eyQ.onChangeSkinType(tbPageContext, i);
        this.eyR.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.eyQ.a(aVar.ezw);
            this.eyR.a(aVar.ezx);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.eyQ.d(dVar);
        this.eyR.d(dVar);
    }

    public void setLabelName(String str) {
        this.eyQ.setLabelName(str);
        this.eyR.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.eyQ = new h(getTbPageContext());
        this.eyR = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.eyQ.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.eyR.getView());
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public e eyS;

        public a(e eVar) {
            super(eVar.getView());
            this.eyS = eVar;
        }
    }
}
