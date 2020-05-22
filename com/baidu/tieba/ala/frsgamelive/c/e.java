package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h fvO;
    private h fvP;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fvO.onChangeSkinType(tbPageContext, i);
        this.fvP.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fvO.a(aVar.fwu);
            this.fvP.a(aVar.fwv);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fvO.d(dVar);
        this.fvP.d(dVar);
    }

    public void setLabelName(String str) {
        this.fvO.setLabelName(str);
        this.fvP.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fvO = new h(getTbPageContext());
        this.fvP = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fvO.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fvP.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public e fvQ;

        public a(e eVar) {
            super(eVar.getView());
            this.fvQ = eVar;
        }
    }
}
