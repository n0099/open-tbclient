package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h gDL;
    private h gDM;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gDL.onChangeSkinType(tbPageContext, i);
        this.gDM.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gDL.a(aVar.gEr);
            this.gDM.a(aVar.gEs);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gDL.d(fVar);
        this.gDM.d(fVar);
    }

    public void setLabelName(String str) {
        this.gDL.setLabelName(str);
        this.gDM.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gDL = new h(getTbPageContext());
        this.gDM = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gDL.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gDM.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public e gDN;

        public a(e eVar) {
            super(eVar.getView());
            this.gDN = eVar;
        }
    }
}
