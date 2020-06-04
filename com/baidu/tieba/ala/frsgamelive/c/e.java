package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private h fvZ;
    private h fwa;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fvZ.onChangeSkinType(tbPageContext, i);
        this.fwa.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fvZ.a(aVar.fwF);
            this.fwa.a(aVar.fwG);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fvZ.d(dVar);
        this.fwa.d(dVar);
    }

    public void setLabelName(String str) {
        this.fvZ.setLabelName(str);
        this.fwa.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fvZ = new h(getTbPageContext());
        this.fwa = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fvZ.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fwa.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public e fwb;

        public a(e eVar) {
            super(eVar.getView());
            this.fwb = eVar;
        }
    }
}
