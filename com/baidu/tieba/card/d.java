package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d extends a<com.baidu.tieba.card.data.g> {
    private TbPageContext<?> ajT;
    private View brp;
    private TextView brq;
    public e brr;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajT = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.brp = linearLayout.findViewById(w.h.card_god_feed_unfollowed_top_margin);
        this.brq = (TextView) linearLayout.findViewById(w.h.card_god_feed_unfollowed_god_describe);
        this.brr = new e(this.ajT);
        this.brr.brs = true;
        linearLayout.addView(this.brr.getView());
    }

    public e SF() {
        return this.brr;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.brp, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.brq, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.k(this.brq, w.e.cp_bg_line_d);
            this.brr.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_god_feed_unfollowed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.g gVar) {
        if (gVar != null) {
            if (gVar.needTopMargin) {
                this.brp.setVisibility(0);
            } else {
                this.brp.setVisibility(8);
            }
            if (gVar.buR == null || gVar.buR.threadData == null || gVar.buR.threadData.getAuthor() == null || gVar.buR.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(gVar.buR.threadData.getAuthor().getGodUserData().getIntro())) {
                this.brq.setVisibility(8);
            } else {
                this.brq.setVisibility(0);
                this.brq.setText(gVar.buR.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.brr.onBindDataToView(gVar.buR);
            onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.brr != null) {
            this.brr.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
