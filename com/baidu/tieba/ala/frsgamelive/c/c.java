package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d eDt;
    private d eDu;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eDt.onChangeSkinType(tbPageContext, i);
        this.eDu.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.eDt.a(aVar.eEn);
            this.eDu.a(aVar.eEo);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.eDt.d(dVar);
        this.eDu.d(dVar);
    }

    public void setLabelName(String str) {
        this.eDt.setLabelName(str);
        this.eDu.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.eDt = new d(getTbPageContext());
        this.eDu = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.eDt.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.eDu.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public c eDv;

        public a(c cVar) {
            super(cVar.getView());
            this.eDv = cVar;
        }
    }
}
