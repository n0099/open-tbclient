package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d fvL;
    private d fvM;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fvL.onChangeSkinType(tbPageContext, i);
        this.fvM.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fvL.a(aVar.fwF);
            this.fvM.a(aVar.fwG);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fvL.d(dVar);
        this.fvM.d(dVar);
    }

    public void setLabelName(String str) {
        this.fvL.setLabelName(str);
        this.fvM.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fvL = new d(getTbPageContext());
        this.fvM = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fvL.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fvM.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public c fvN;

        public a(c cVar) {
            super(cVar.getView());
            this.fvN = cVar;
        }
    }
}
