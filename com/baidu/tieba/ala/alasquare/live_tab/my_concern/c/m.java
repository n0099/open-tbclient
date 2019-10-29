package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class m extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c> {
    ViewGroup Bg;
    private k dzh;
    private k dzi;
    private k dzj;

    public m(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dzh = new k(tbPageContext);
        this.dzi = new k(tbPageContext);
        this.dzj = new k(tbPageContext);
        this.Bg = (ViewGroup) getView();
        new View(getContext());
        this.Bg.setPadding(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, getTbPageContext().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.Bg.addView(this.dzh.getView());
        this.Bg.addView(this.dzi.getView());
        this.Bg.addView(this.dzj.getView());
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.Bg, R.color.cp_bg_line_d);
        this.dzh.onChangeSkinType(tbPageContext, i);
        this.dzi.onChangeSkinType(tbPageContext, i);
        this.dzj.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_recommend_list_live_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar) {
        if (cVar != null) {
            this.dzh.b(cVar.dxr);
            this.dzi.b(cVar.dyb);
            this.dzj.b(cVar.dxs);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(o oVar) {
        this.dzh.a(oVar);
        this.dzi.a(oVar);
        this.dzj.a(oVar);
    }
}
