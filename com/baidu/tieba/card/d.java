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
public class d extends a<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> GM;
    private View aXY;
    private TextView aXZ;
    public e aYa;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GM = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.aXY = linearLayout.findViewById(t.g.card_god_feed_unfollowed_top_margin);
        this.aXZ = (TextView) linearLayout.findViewById(t.g.card_god_feed_unfollowed_god_describe);
        this.aYa = new e(this.GM);
        this.aYa.aYb = true;
        linearLayout.addView(this.aYa.getView());
    }

    public e Ns() {
        return this.aYa;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aXY, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aXZ, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.av.l(this.aXZ, t.d.cp_bg_line_d);
            this.aYa.onChangeSkinType(tbPageContext, i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_god_feed_unfollowed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.h hVar) {
        if (hVar != null) {
            if (hVar.bbt) {
                this.aXY.setVisibility(0);
            } else {
                this.aXY.setVisibility(8);
            }
            if (hVar.bbD == null || hVar.bbD.threadData == null || hVar.bbD.threadData.getAuthor() == null || hVar.bbD.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(hVar.bbD.threadData.getAuthor().getGodUserData().getIntro())) {
                this.aXZ.setVisibility(8);
            } else {
                this.aXZ.setVisibility(0);
                this.aXZ.setText(hVar.bbD.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.aYa.onBindDataToView(hVar.bbD);
            onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aYa != null) {
            this.aYa.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
