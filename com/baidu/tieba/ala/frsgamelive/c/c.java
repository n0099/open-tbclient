package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d gMw;
    private d gMx;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gMw.onChangeSkinType(tbPageContext, i);
        this.gMx.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gMw.a(aVar.gNq);
            this.gMx.a(aVar.gNr);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gMw.d(fVar);
        this.gMx.d(fVar);
    }

    public void setLabelName(String str) {
        this.gMw.setLabelName(str);
        this.gMx.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gMw = new d(getTbPageContext());
        this.gMx = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gMw.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gMx.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public c gMy;

        public a(c cVar) {
            super(cVar.getView());
            this.gMy = cVar;
        }
    }
}
