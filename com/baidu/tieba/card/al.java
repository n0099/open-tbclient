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
    private com.baidu.tbadk.core.data.bj ain;
    private TbPageContext ajF;
    private CommonUserLikeButton.a brB;
    public EntelechyUserLikeButton brE;
    private com.baidu.tbadk.core.view.userLike.c brF;
    public TextView btg;
    private com.baidu.tieba.card.data.p bth;
    private View.OnClickListener bti;
    private View.OnClickListener btj;
    private int mSkinType;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.brB = new am(this);
        this.bti = new an(this);
        this.btj = new ao(this);
        Sk();
        this.ajF = tbPageContext;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbk.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds4);
        this.bbk.setLayoutParams(layoutParams);
        this.btg = new TextView(tbPageContext.getPageActivity());
        this.btg.setIncludeFontPadding(false);
        this.btg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds24));
        this.btg.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.btg.setOnClickListener(this.bti);
        this.bbl.addView(this.btg, 1);
        this.brE = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.brF = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brE);
        this.brE.setFanNumCallBack(this.brB);
        this.brE.setAfterOnClickListener(this.btj);
        this.brE.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds28);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
        this.brE.setGravity(21);
        this.brE.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.brE);
    }

    @Override // com.baidu.tieba.card.x
    public void a(com.baidu.tieba.card.data.p pVar) {
        super.onBindDataToView(pVar);
        if (pVar != null && pVar.bbv != null) {
            this.bth = pVar;
            this.ain = pVar.bbv;
            pVar.sourceType = 0;
            if (pVar.bbv.getAuthor() != null) {
                gF(pVar.bbv.getAuthor().getFansNum());
                if (this.ain.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ain.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brE.setVisibility(8);
                    return;
                }
                if (this.ain.getAuthor().getGodUserData().getIsLike()) {
                    this.brE.setVisibility(8);
                } else {
                    this.brE.setVisibility(0);
                    this.brF.a(this.ain.getAuthor());
                }
                if (this.ain.getAuthor().getGodUserData().getType() == 2) {
                    this.bbg.setGodIconMargin(0);
                } else {
                    this.bbg.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.x, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i((View) this.btg, w.e.cp_cont_d);
            this.brE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.x
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.brF.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(int i) {
        if (this.btg != null) {
            this.btg.setText(String.format(this.ajF.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
