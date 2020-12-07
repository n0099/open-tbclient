package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d gMu;
    private d gMv;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gMu.onChangeSkinType(tbPageContext, i);
        this.gMv.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gMu.a(aVar.gNo);
            this.gMv.a(aVar.gNp);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gMu.d(fVar);
        this.gMv.d(fVar);
    }

    public void setLabelName(String str) {
        this.gMu.setLabelName(str);
        this.gMv.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gMu = new d(getTbPageContext());
        this.gMv = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gMu.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gMv.getView());
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public c gMw;

        public a(c cVar) {
            super(cVar.getView());
            this.gMw = cVar;
        }
    }
}
