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
    private TbPageContext<?> GO;
    private View baR;
    private TextView baS;
    public e baT;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        LinearLayout linearLayout = (LinearLayout) getView();
        this.baR = linearLayout.findViewById(r.g.card_god_feed_unfollowed_top_margin);
        this.baS = (TextView) linearLayout.findViewById(r.g.card_god_feed_unfollowed_god_describe);
        this.baT = new e(this.GO);
        this.baT.baU = true;
        linearLayout.addView(this.baT.getView());
    }

    public e Or() {
        return this.baT;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(this.baR, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) this.baS, r.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.l(this.baS, r.d.cp_bg_line_d);
            this.baT.onChangeSkinType(tbPageContext, i);
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
    public void onBindDataToView(com.baidu.tieba.card.data.g gVar) {
        if (gVar != null) {
            if (gVar.needTopMargin) {
                this.baR.setVisibility(0);
            } else {
                this.baR.setVisibility(8);
            }
            if (gVar.bei == null || gVar.bei.threadData == null || gVar.bei.threadData.getAuthor() == null || gVar.bei.threadData.getAuthor().getGodUserData() == null || StringUtils.isNull(gVar.bei.threadData.getAuthor().getGodUserData().getIntro())) {
                this.baS.setVisibility(8);
            } else {
                this.baS.setVisibility(0);
                this.baS.setText(gVar.bei.threadData.getAuthor().getGodUserData().getIntro());
            }
            this.baT.onBindDataToView(gVar.bei);
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.baT != null) {
            this.baT.j(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
