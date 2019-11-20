package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d dJb;
    private d dJc;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.dJb.onChangeSkinType(tbPageContext, i);
        this.dJc.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.dJb.a(aVar.dJV);
            this.dJc.a(aVar.dJW);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.dJb.d(dVar);
        this.dJc.d(dVar);
    }

    public void setLabelName(String str) {
        this.dJb.setLabelName(str);
        this.dJc.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.dJb = new d(getTbPageContext());
        this.dJc = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.dJb.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.dJc.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public c dJd;

        public a(c cVar) {
            super(cVar.getView());
            this.dJd = cVar;
        }
    }
}
