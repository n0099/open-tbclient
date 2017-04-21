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
    private TbPageContext<?> ajU;
    private View btH;
    private TextView btI;
    public e btJ;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajU = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.btH = linearLayout.findViewById(w.h.card_god_feed_unfollowed_top_margin);
        this.btI = (TextView) linearLayout.findViewById(w.h.card_god_feed_unfollowed_god_describe);
        this.btJ = new e(this.ajU);
        this.btJ.btK = true;
        linearLayout.addView(this.btJ.getView());
    }

    public e TH() {
        return this.btJ;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.btH, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.btI, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.k(this.btI, w.e.cp_bg_line_d);
            this.btJ.onChangeSkinType(tbPageContext, i);
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
                this.btH.setVisibility(0);
            } else {
                this.btH.setVisibility(8);
            }
            if (gVar.bxi == null || gVar.bxi.threadData == null || gVar.bxi.threadData.getAuthor() == null || gVar.bxi.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(gVar.bxi.threadData.getAuthor().getGodUserData().getIntro())) {
                this.btI.setVisibility(8);
            } else {
                this.btI.setVisibility(0);
                this.btI.setText(gVar.bxi.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.btJ.onBindDataToView(gVar.bxi);
            onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.btJ != null) {
            this.btJ.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
