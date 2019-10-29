package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class n extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.g> {
    private a dzk;

    public n(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dzk = new a(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.dzk.bGb, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dzk.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.dCc) && this.dzk != null) {
            this.dzk.mTitle.setText(gVar.dCc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public View bGb;
        public n dzl;
        public TextView mTitle;

        public a(n nVar) {
            super(nVar.getView());
            this.dzl = nVar;
            this.bGb = nVar.getView();
            this.mTitle = (TextView) this.bGb.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }
}
