package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class n extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.g> {
    private a ffu;

    public n(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ffu = new a(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.ffu.dex, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ffu.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.fiA) && this.ffu != null) {
            this.ffu.mTitle.setText(gVar.fiA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public View dex;
        public n ffv;
        public TextView mTitle;

        public a(n nVar) {
            super(nVar.getView());
            this.ffv = nVar;
            this.dex = nVar.getView();
            this.mTitle = (TextView) this.dex.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }
}
