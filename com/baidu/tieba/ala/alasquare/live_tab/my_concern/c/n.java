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
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.g> {
    private a ekj;

    public n(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ekj = new a(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.ekj.cqd, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ekj.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.enh) && this.ekj != null) {
            this.ekj.mTitle.setText(gVar.enh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public View cqd;
        public n ekk;
        public TextView mTitle;

        public a(n nVar) {
            super(nVar.getView());
            this.ekk = nVar;
            this.cqd = nVar.getView();
            this.mTitle = (TextView) this.cqd.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }
}
