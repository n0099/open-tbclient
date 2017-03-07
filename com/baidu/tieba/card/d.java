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
    private TbPageContext<?> ajF;
    private View brx;
    private TextView bry;
    public e brz;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajF = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.brx = linearLayout.findViewById(w.h.card_god_feed_unfollowed_top_margin);
        this.bry = (TextView) linearLayout.findViewById(w.h.card_god_feed_unfollowed_god_describe);
        this.brz = new e(this.ajF);
        this.brz.brA = true;
        linearLayout.addView(this.brz.getView());
    }

    public e Sh() {
        return this.brz;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.brx, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i((View) this.bry, w.e.cp_cont_f);
            com.baidu.tbadk.core.util.aq.k(this.bry, w.e.cp_bg_line_d);
            this.brz.onChangeSkinType(tbPageContext, i);
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
                this.brx.setVisibility(0);
            } else {
                this.brx.setVisibility(8);
            }
            if (gVar.buY == null || gVar.buY.threadData == null || gVar.buY.threadData.getAuthor() == null || gVar.buY.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(gVar.buY.threadData.getAuthor().getGodUserData().getIntro())) {
                this.bry.setVisibility(8);
            } else {
                this.bry.setVisibility(0);
                this.bry.setText(gVar.buY.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.brz.onBindDataToView(gVar.buY);
            onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.brz != null) {
            this.brz.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
