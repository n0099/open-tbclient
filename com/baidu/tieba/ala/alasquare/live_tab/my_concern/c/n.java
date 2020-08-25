package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class n extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.g> {
    private a fHh;

    public n(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fHh = new a(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.fHh.dzg, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fHh.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.fKm) && this.fHh != null) {
            this.fHh.mTitle.setText(gVar.fKm);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public View dzg;
        public n fHi;
        public TextView mTitle;

        public a(n nVar) {
            super(nVar.getView());
            this.fHi = nVar;
            this.dzg = nVar.getView();
            this.mTitle = (TextView) this.dzg.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }
}
