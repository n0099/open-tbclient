package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d fGV;
    private d fGW;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fGV.onChangeSkinType(tbPageContext, i);
        this.fGW.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fGV.a(aVar.fHP);
            this.fGW.a(aVar.fHQ);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fGV.d(dVar);
        this.fGW.d(dVar);
    }

    public void setLabelName(String str) {
        this.fGV.setLabelName(str);
        this.fGW.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fGV = new d(getTbPageContext());
        this.fGW = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fGV.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fGW.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends ad.a {
        public c fGX;

        public a(c cVar) {
            super(cVar.getView());
            this.fGX = cVar;
        }
    }
}
