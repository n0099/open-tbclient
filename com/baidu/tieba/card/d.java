package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends a<com.baidu.tieba.card.data.g> {
    private TbPageContext<?> FY;
    private View bkF;
    private TextView bkG;
    public e bkH;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.FY = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.bkF = linearLayout.findViewById(r.h.card_god_feed_unfollowed_top_margin);
        this.bkG = (TextView) linearLayout.findViewById(r.h.card_god_feed_unfollowed_god_describe);
        this.bkH = new e(this.FY);
        this.bkH.bkI = true;
        linearLayout.addView(this.bkH.getView());
    }

    public e Rk() {
        return this.bkH;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.k(this.bkF, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.i((View) this.bkG, r.e.cp_cont_f);
            com.baidu.tbadk.core.util.ap.k(this.bkG, r.e.cp_bg_line_d);
            this.bkH.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_god_feed_unfollowed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.g gVar) {
        if (gVar != null) {
            if (gVar.needTopMargin) {
                this.bkF.setVisibility(0);
            } else {
                this.bkF.setVisibility(8);
            }
            if (gVar.bod == null || gVar.bod.threadData == null || gVar.bod.threadData.getAuthor() == null || gVar.bod.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(gVar.bod.threadData.getAuthor().getGodUserData().getIntro())) {
                this.bkG.setVisibility(8);
            } else {
                this.bkG.setVisibility(0);
                this.bkG.setText(gVar.bod.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.bkH.onBindDataToView(gVar.bod);
            onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bkH != null) {
            this.bkH.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
