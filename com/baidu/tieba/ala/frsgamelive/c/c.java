package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d fvA;
    private d fvB;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fvA.onChangeSkinType(tbPageContext, i);
        this.fvB.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fvA.a(aVar.fwu);
            this.fvB.a(aVar.fwv);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fvA.d(dVar);
        this.fvB.d(dVar);
    }

    public void setLabelName(String str) {
        this.fvA.setLabelName(str);
        this.fvB.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fvA = new d(getTbPageContext());
        this.fvB = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fvA.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fvB.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public c fvC;

        public a(c cVar) {
            super(cVar.getView());
            this.fvC = cVar;
        }
    }
}
