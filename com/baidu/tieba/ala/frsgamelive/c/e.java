package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h gMI;
    private h gMJ;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gMI.onChangeSkinType(tbPageContext, i);
        this.gMJ.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gMI.a(aVar.gNo);
            this.gMJ.a(aVar.gNp);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gMI.d(fVar);
        this.gMJ.d(fVar);
    }

    public void setLabelName(String str) {
        this.gMI.setLabelName(str);
        this.gMJ.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gMI = new h(getTbPageContext());
        this.gMJ = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gMI.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gMJ.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public e gMK;

        public a(e eVar) {
            super(eVar.getView());
            this.gMK = eVar;
        }
    }
}
