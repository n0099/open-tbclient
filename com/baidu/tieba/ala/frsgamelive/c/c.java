package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d fhR;
    private d fhS;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fhR.onChangeSkinType(tbPageContext, i);
        this.fhS.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fhR.a(aVar.fiN);
            this.fhS.a(aVar.fiO);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fhR.d(dVar);
        this.fhS.d(dVar);
    }

    public void setLabelName(String str) {
        this.fhR.setLabelName(str);
        this.fhS.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fhR = new d(getTbPageContext());
        this.fhS = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fhR.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fhS.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public c fhT;

        public a(c cVar) {
            super(cVar.getView());
            this.fhT = cVar;
        }
    }
}
