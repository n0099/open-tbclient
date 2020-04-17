package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d fhM;
    private d fhN;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fhM.onChangeSkinType(tbPageContext, i);
        this.fhN.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fhM.a(aVar.fiI);
            this.fhN.a(aVar.fiJ);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.fhM.d(dVar);
        this.fhN.d(dVar);
    }

    public void setLabelName(String str) {
        this.fhM.setLabelName(str);
        this.fhN.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fhM = new d(getTbPageContext());
        this.fhN = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fhM.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fhN.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public c fhO;

        public a(c cVar) {
            super(cVar.getView());
            this.fhO = cVar;
        }
    }
}
