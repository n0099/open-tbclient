package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h dJp;
    private h dJq;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dJp.onChangeSkinType(tbPageContext, i);
        this.dJq.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.dJp.a(aVar.dJV);
            this.dJq.a(aVar.dJW);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.dJp.d(dVar);
        this.dJq.d(dVar);
    }

    public void setLabelName(String str) {
        this.dJp.setLabelName(str);
        this.dJq.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.dJp = new h(getTbPageContext());
        this.dJq = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.dJp.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.dJq.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public e dJr;

        public a(e eVar) {
            super(eVar.getView());
            this.dJr = eVar;
        }
    }
}
