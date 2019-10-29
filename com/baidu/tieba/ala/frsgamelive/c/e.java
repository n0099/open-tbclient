package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h dKg;
    private h dKh;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dKg.onChangeSkinType(tbPageContext, i);
        this.dKh.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.dKg.a(aVar.dKM);
            this.dKh.a(aVar.dKN);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.dKg.d(dVar);
        this.dKh.d(dVar);
    }

    public void setLabelName(String str) {
        this.dKg.setLabelName(str);
        this.dKh.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.dKg = new h(getTbPageContext());
        this.dKh = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.dKg.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.dKh.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public e dKi;

        public a(e eVar) {
            super(eVar.getView());
            this.dKi = eVar;
        }
    }
}
