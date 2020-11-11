package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h gEe;
    private h gEf;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gEe.onChangeSkinType(tbPageContext, i);
        this.gEf.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gEe.a(aVar.gEK);
            this.gEf.a(aVar.gEL);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gEe.d(fVar);
        this.gEf.d(fVar);
    }

    public void setLabelName(String str) {
        this.gEe.setLabelName(str);
        this.gEf.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gEe = new h(getTbPageContext());
        this.gEf = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gEe.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gEf.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public e gEg;

        public a(e eVar) {
            super(eVar.getView());
            this.gEg = eVar;
        }
    }
}
