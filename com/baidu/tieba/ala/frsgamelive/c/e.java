package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h fME;
    private h fMF;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fME.onChangeSkinType(tbPageContext, i);
        this.fMF.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fME.a(aVar.fNk);
            this.fMF.a(aVar.fNl);
        }
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        this.fME.d(eVar);
        this.fMF.d(eVar);
    }

    public void setLabelName(String str) {
        this.fME.setLabelName(str);
        this.fMF.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fME = new h(getTbPageContext());
        this.fMF = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fME.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fMF.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends ad.a {
        public e fMG;

        public a(e eVar) {
            super(eVar.getView());
            this.fMG = eVar;
        }
    }
}
