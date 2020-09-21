package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h gbU;
    private h gbV;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gbU.onChangeSkinType(tbPageContext, i);
        this.gbV.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gbU.a(aVar.gcA);
            this.gbV.a(aVar.gcB);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gbU.d(fVar);
        this.gbV.d(fVar);
    }

    public void setLabelName(String str) {
        this.gbU.setLabelName(str);
        this.gbV.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gbU = new h(getTbPageContext());
        this.gbV = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gbU.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gbV.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public e gbW;

        public a(e eVar) {
            super(eVar.getView());
            this.gbW = eVar;
        }
    }
}
