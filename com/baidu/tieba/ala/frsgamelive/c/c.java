package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d eyC;
    private d eyD;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eyC.onChangeSkinType(tbPageContext, i);
        this.eyD.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.eyC.a(aVar.ezw);
            this.eyD.a(aVar.ezx);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.eyC.d(dVar);
        this.eyD.d(dVar);
    }

    public void setLabelName(String str) {
        this.eyC.setLabelName(str);
        this.eyD.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.eyC = new d(getTbPageContext());
        this.eyD = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.eyC.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.eyD.getView());
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public c eyE;

        public a(c cVar) {
            super(cVar.getView());
            this.eyE = cVar;
        }
    }
}
