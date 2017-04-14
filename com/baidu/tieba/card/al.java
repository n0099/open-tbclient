package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class al extends x {
    private com.baidu.tbadk.core.data.bi aiB;
    private TbPageContext ajT;
    private CommonUserLikeButton.a brt;
    public EntelechyUserLikeButton brw;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public TextView bsY;
    private com.baidu.tieba.card.data.p bsZ;
    private View.OnClickListener bta;
    private View.OnClickListener btb;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brt = new am(this);
        this.bta = new an(this);
        this.btb = new ao(this);
        SI();
        this.ajT = tbPageContext;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbd.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds4);
        this.bbd.setLayoutParams(layoutParams);
        this.bsY = new TextView(tbPageContext.getPageActivity());
        this.bsY.setIncludeFontPadding(false);
        this.bsY.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        this.bsY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bsY.setOnClickListener(this.bta);
        this.bbe.addView(this.bsY, 1);
        this.brw = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brw);
        this.brw.setFanNumCallBack(this.brt);
        this.brw.setAfterOnClickListener(this.btb);
        this.brw.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds28);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
        this.brw.setGravity(21);
        this.brw.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.brw);
    }

    @Override // com.baidu.tieba.card.x
    public void a(com.baidu.tieba.card.data.p pVar) {
        super.onBindDataToView(pVar);
        if (pVar != null && pVar.bbo != null) {
            this.bsZ = pVar;
            this.aiB = pVar.bbo;
            pVar.sourceType = 0;
            if (pVar.bbo.getAuthor() != null) {
                gI(pVar.bbo.getAuthor().getFansNum());
                if (this.aiB.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiB.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brw.setVisibility(8);
                    return;
                }
                if (this.aiB.getAuthor().getGodUserData().getIsLike()) {
                    this.brw.setVisibility(8);
                } else {
                    this.brw.setVisibility(0);
                    this.brx.a(this.aiB.getAuthor());
                }
                if (this.aiB.getAuthor().getGodUserData().getType() == 2) {
                    this.baZ.setGodIconMargin(0);
                } else {
                    this.baZ.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bsY, w.e.cp_cont_d);
            this.brw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.brx.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        if (this.bsY != null) {
            this.bsY.setText(String.format(this.ajT.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
