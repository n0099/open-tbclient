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
public class o extends a<com.baidu.tieba.card.a.j> {
    private TbPageContext<?> ND;
    private View aSa;
    private TextView aSb;
    public p aSc;
    private int mSkinType;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ND = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aSa = linearLayout.findViewById(t.g.card_god_feed_unfollowed_top_margin);
        this.aSb = (TextView) linearLayout.findViewById(t.g.card_god_feed_unfollowed_god_describe);
        this.aSc = new p(this.ND);
        this.aSc.aSd = true;
        linearLayout.addView(this.aSc.getView());
    }

    public p Lh() {
        return this.aSc;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(this.aSa, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.aSb, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.l(this.aSb, t.d.cp_bg_line_d);
            this.aSc.d(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_god_feed_unfollowed;
    }

    public void a(com.baidu.tieba.card.a.j jVar) {
        if (jVar != null) {
            if (jVar.aVs) {
                this.aSa.setVisibility(0);
            } else {
                this.aSa.setVisibility(8);
            }
            if (jVar.aVK == null || jVar.aVK.aVJ == null || jVar.aVK.aVJ.getAuthor() == null || jVar.aVK.aVJ.getAuthor().getGodUserData() == null || StringUtils.isNull(jVar.aVK.aVJ.getAuthor().getGodUserData().getIntro())) {
                this.aSb.setVisibility(8);
            } else {
                this.aSb.setVisibility(0);
                this.aSb.setText(jVar.aVK.aVJ.getAuthor().getGodUserData().getIntro());
            }
            this.aSc.a(jVar.aVK);
            d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aSc != null) {
            this.aSc.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
