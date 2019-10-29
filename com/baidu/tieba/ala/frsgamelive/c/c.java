package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d dJS;
    private d dJT;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dJS.onChangeSkinType(tbPageContext, i);
        this.dJT.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.dJS.a(aVar.dKM);
            this.dJT.a(aVar.dKN);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.dJS.d(dVar);
        this.dJT.d(dVar);
    }

    public void setLabelName(String str) {
        this.dJS.setLabelName(str);
        this.dJT.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.dJS = new d(getTbPageContext());
        this.dJT = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.dJS.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.dJT.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public c dJU;

        public a(c cVar) {
            super(cVar.getView());
            this.dJU = cVar;
        }
    }
}
