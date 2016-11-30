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
    private TbPageContext<?> GO;
    private View bbL;
    private TextView bbM;
    public e bbN;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.bbL = linearLayout.findViewById(r.g.card_god_feed_unfollowed_top_margin);
        this.bbM = (TextView) linearLayout.findViewById(r.g.card_god_feed_unfollowed_god_describe);
        this.bbN = new e(this.GO);
        this.bbN.bbO = true;
        linearLayout.addView(this.bbN.getView());
    }

    public e OW() {
        return this.bbN;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(this.bbL, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.bbM, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.l(this.bbM, r.d.cp_bg_line_d);
            this.bbN.onChangeSkinType(tbPageContext, i);
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
            if (hVar.needTopMargin) {
                this.bbL.setVisibility(0);
            } else {
                this.bbL.setVisibility(8);
            }
            if (hVar.beT == null || hVar.beT.threadData == null || hVar.beT.threadData.getAuthor() == null || hVar.beT.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(hVar.beT.threadData.getAuthor().getGodUserData().getIntro())) {
                this.bbM.setVisibility(8);
            } else {
                this.bbM.setVisibility(0);
                this.bbM.setText(hVar.beT.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.bbN.onBindDataToView(hVar.beT);
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bbN != null) {
            this.bbN.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
