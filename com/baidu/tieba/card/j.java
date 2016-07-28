package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.a.h> {
    private TbPageContext<?> EA;
    private View aSQ;
    private TextView aSR;
    public k aSS;
    private int mSkinType;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.EA = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aSQ = linearLayout.findViewById(u.g.card_god_feed_unfollowed_top_margin);
        this.aSR = (TextView) linearLayout.findViewById(u.g.card_god_feed_unfollowed_god_describe);
        this.aSS = new k(this.EA);
        this.aSS.aST = true;
        linearLayout.addView(this.aSS.getView());
    }

    public k KQ() {
        return this.aSS;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aSQ, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aSR, u.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.l(this.aSR, u.d.cp_bg_line_d);
            this.aSS.d(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_feed_unfollowed;
    }

    public void a(com.baidu.tieba.card.a.h hVar) {
        if (hVar != null) {
            if (hVar.aVQ) {
                this.aSQ.setVisibility(0);
            } else {
                this.aSQ.setVisibility(8);
            }
            if (hVar.aWb == null || hVar.aWb.threadData == null || hVar.aWb.threadData.getAuthor() == null || hVar.aWb.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(hVar.aWb.threadData.getAuthor().getGodUserData().getIntro())) {
                this.aSR.setVisibility(8);
            } else {
                this.aSR.setVisibility(0);
                this.aSR.setText(hVar.aWb.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.aSS.a(hVar.aWb);
            d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aSS != null) {
            this.aSS.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
