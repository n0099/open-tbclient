package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d gyc;
    private d gyd;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.gyc.onChangeSkinType(tbPageContext, i);
        this.gyd.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.gyc.a(aVar.gyW);
            this.gyd.a(aVar.gyX);
        }
    }

    public void c(com.baidu.tieba.ala.f fVar) {
        this.gyc.d(fVar);
        this.gyd.d(fVar);
    }

    public void setLabelName(String str) {
        this.gyc.setLabelName(str);
        this.gyd.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.gyc = new d(getTbPageContext());
        this.gyd = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.gyc.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.gyd.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public c gye;

        public a(c cVar) {
            super(cVar.getView());
            this.gye = cVar;
        }
    }
}
