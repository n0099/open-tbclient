package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h eDH;
    private h eDI;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eDH.onChangeSkinType(tbPageContext, i);
        this.eDI.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.eDH.a(aVar.eEn);
            this.eDI.a(aVar.eEo);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.eDH.d(dVar);
        this.eDI.d(dVar);
    }

    public void setLabelName(String str) {
        this.eDH.setLabelName(str);
        this.eDI.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.eDH = new h(getTbPageContext());
        this.eDI = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.eDH.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.eDI.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public e eDJ;

        public a(e eVar) {
            super(eVar.getView());
            this.eDJ = eVar;
        }
    }
}
