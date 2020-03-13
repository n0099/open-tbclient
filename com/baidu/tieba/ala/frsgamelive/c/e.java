package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private h eDl;
    private h eDm;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eDl.onChangeSkinType(tbPageContext, i);
        this.eDm.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.eDl.a(aVar.eDR);
            this.eDm.a(aVar.eDS);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.eDl.d(dVar);
        this.eDm.d(dVar);
    }

    public void setLabelName(String str) {
        this.eDl.setLabelName(str);
        this.eDm.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.eDl = new h(getTbPageContext());
        this.eDm = new h(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.eDl.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.eDm.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public e eDn;

        public a(e eVar) {
            super(eVar.getView());
            this.eDn = eVar;
        }
    }
}
