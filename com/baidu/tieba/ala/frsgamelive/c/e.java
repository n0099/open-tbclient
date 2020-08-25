package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h fYC;
    private h fYD;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fYC.onChangeSkinType(tbPageContext, i);
        this.fYD.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fYC.a(aVar.fZi);
            this.fYD.a(aVar.fZj);
        }
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        this.fYC.d(eVar);
        this.fYD.d(eVar);
    }

    public void setLabelName(String str) {
        this.fYC.setLabelName(str);
        this.fYD.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fYC = new h(getTbPageContext());
        this.fYD = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fYC.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fYD.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public e fYE;

        public a(e eVar) {
            super(eVar.getView());
            this.fYE = eVar;
        }
    }
}
