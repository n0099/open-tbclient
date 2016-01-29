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
    private TbPageContext<?> Nw;
    private View aPk;
    private TextView aPl;
    private p aPm;
    private int mSkinType;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Nw = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aPk = linearLayout.findViewById(t.g.card_god_feed_unfollowed_top_margin);
        this.aPl = (TextView) linearLayout.findViewById(t.g.card_god_feed_unfollowed_god_describe);
        this.aPm = new p(this.Nw);
        this.aPm.aPn = true;
        linearLayout.addView(this.aPm.getView());
    }

    public p JP() {
        return this.aPm;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(this.aPk, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) this.aPl, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.l(this.aPl, t.d.cp_bg_line_d);
            this.aPm.d(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_god_feed_unfollowed;
    }

    public void a(com.baidu.tieba.card.a.j jVar) {
        if (jVar != null) {
            if (jVar.aRK) {
                this.aPk.setVisibility(0);
            } else {
                this.aPk.setVisibility(8);
            }
            if (jVar.aSd == null || jVar.aSd.aSc == null || jVar.aSd.aSc.getAuthor() == null || jVar.aSd.aSc.getAuthor().getGodUserData() == null || StringUtils.isNull(jVar.aSd.aSc.getAuthor().getGodUserData().getIntro())) {
                this.aPl.setVisibility(8);
            } else {
                this.aPl.setVisibility(0);
                this.aPl.setText(jVar.aSd.aSc.getAuthor().getGodUserData().getIntro());
            }
            this.aPm.a(jVar.aSd);
            d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aPm != null) {
            this.aPm.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
