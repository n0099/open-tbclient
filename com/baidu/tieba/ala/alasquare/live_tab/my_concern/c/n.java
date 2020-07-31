package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class n extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.g> {
    private a fvP;

    public n(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.fvP = new a(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.fvP.dpe, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.fvP.mTitle, R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.fyU) && this.fvP != null) {
            this.fvP.mTitle.setText(gVar.fyU);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends ad.a {
        public View dpe;
        public n fvQ;
        public TextView mTitle;

        public a(n nVar) {
            super(nVar.getView());
            this.fvQ = nVar;
            this.dpe = nVar.getView();
            this.mTitle = (TextView) this.dpe.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }
}
