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
public class d extends a<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> GM;
    private View aYC;
    private TextView aYD;
    public e aYE;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GM = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aYC = linearLayout.findViewById(r.g.card_god_feed_unfollowed_top_margin);
        this.aYD = (TextView) linearLayout.findViewById(r.g.card_god_feed_unfollowed_god_describe);
        this.aYE = new e(this.GM);
        this.aYE.aYF = true;
        linearLayout.addView(this.aYE.getView());
    }

    public e NT() {
        return this.aYE;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aYC, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aYD, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.l(this.aYD, r.d.cp_bg_line_d);
            this.aYE.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_god_feed_unfollowed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.h hVar) {
        if (hVar != null) {
            if (hVar.bbL) {
                this.aYC.setVisibility(0);
            } else {
                this.aYC.setVisibility(8);
            }
            if (hVar.bbV == null || hVar.bbV.threadData == null || hVar.bbV.threadData.getAuthor() == null || hVar.bbV.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(hVar.bbV.threadData.getAuthor().getGodUserData().getIntro())) {
                this.aYD.setVisibility(8);
            } else {
                this.aYD.setVisibility(0);
                this.aYD.setText(hVar.bbV.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.aYE.onBindDataToView(hVar.bbV);
            onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aYE != null) {
            this.aYE.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
