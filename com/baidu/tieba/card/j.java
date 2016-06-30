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
    private TbPageContext<?> Ea;
    private View aRW;
    private TextView aRX;
    public k aRY;
    private int mSkinType;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Ea = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aRW = linearLayout.findViewById(u.g.card_god_feed_unfollowed_top_margin);
        this.aRX = (TextView) linearLayout.findViewById(u.g.card_god_feed_unfollowed_god_describe);
        this.aRY = new k(this.Ea);
        this.aRY.aRZ = true;
        linearLayout.addView(this.aRY.getView());
    }

    public k KR() {
        return this.aRY;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aRW, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aRX, u.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.l(this.aRX, u.d.cp_bg_line_d);
            this.aRY.d(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_feed_unfollowed;
    }

    public void a(com.baidu.tieba.card.a.h hVar) {
        if (hVar != null) {
            if (hVar.aUT) {
                this.aRW.setVisibility(0);
            } else {
                this.aRW.setVisibility(8);
            }
            if (hVar.aVd == null || hVar.aVd.threadData == null || hVar.aVd.threadData.getAuthor() == null || hVar.aVd.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(hVar.aVd.threadData.getAuthor().getGodUserData().getIntro())) {
                this.aRX.setVisibility(8);
            } else {
                this.aRX.setVisibility(0);
                this.aRX.setText(hVar.aVd.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.aRY.a(hVar.aVd);
            d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aRY != null) {
            this.aRY.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
