package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d fMq;
    private d fMr;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fMq.onChangeSkinType(tbPageContext, i);
        this.fMr.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fMq.a(aVar.fNk);
            this.fMr.a(aVar.fNl);
        }
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        this.fMq.d(eVar);
        this.fMr.d(eVar);
    }

    public void setLabelName(String str) {
        this.fMq.setLabelName(str);
        this.fMr.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fMq = new d(getTbPageContext());
        this.fMr = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fMq.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fMr.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends ad.a {
        public c fMs;

        public a(c cVar) {
            super(cVar.getView());
            this.fMs = cVar;
        }
    }
}
