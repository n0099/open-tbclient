package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.a.g> {
    private TbPageContext<?> DV;
    private TextView aOA;
    public k aOB;
    private View aOz;
    private int mSkinType;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.DV = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aOz = linearLayout.findViewById(t.g.card_god_feed_unfollowed_top_margin);
        this.aOA = (TextView) linearLayout.findViewById(t.g.card_god_feed_unfollowed_god_describe);
        this.aOB = new k(this.DV);
        this.aOB.aOC = true;
        linearLayout.addView(this.aOB.getView());
    }

    public k JQ() {
        return this.aOB;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(this.aOz, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.aOA, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.l(this.aOA, t.d.cp_bg_line_d);
            this.aOB.d(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_god_feed_unfollowed;
    }

    public void a(com.baidu.tieba.card.a.g gVar) {
        if (gVar != null) {
            if (gVar.aRx) {
                this.aOz.setVisibility(0);
            } else {
                this.aOz.setVisibility(8);
            }
            if (gVar.aRH == null || gVar.aRH.aRG == null || gVar.aRH.aRG.getAuthor() == null || gVar.aRH.aRG.getAuthor().getGodUserData() == null || StringUtils.isNull(gVar.aRH.aRG.getAuthor().getGodUserData().getIntro())) {
                this.aOA.setVisibility(8);
            } else {
                this.aOA.setVisibility(0);
                this.aOA.setText(gVar.aRH.aRG.getAuthor().getGodUserData().getIntro());
            }
            this.aOB.a(gVar.aRH);
            d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aOB != null) {
            this.aOB.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
