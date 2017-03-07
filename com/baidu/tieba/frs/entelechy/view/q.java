package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q extends a {
    private bj ain;
    private TbPageContext ajF;
    private boolean bTC;
    private CommonUserLikeButton.a brB;
    public EntelechyUserLikeButton brE;
    private com.baidu.tbadk.core.view.userLike.c brF;
    public TextView btg;
    private View.OnClickListener bti;
    private int mSkinType;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bTC = false;
        this.brB = new r(this);
        this.bti = new s(this);
        this.ajF = tbPageContext;
        this.bbg.setGodIconMargin(0);
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
        this.brE.setFanNumCallBack(this.brB);
        this.brE.setId(w.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, w.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds36);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
        this.brE.setGravity(21);
        this.brE.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.brE);
        this.brF = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brE);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(bj bjVar) {
        super.onBindDataToView(bjVar);
        if (bjVar != null) {
            this.ain = bjVar;
            if (this.ain.sU() != null && this.ain.sU().channelId > 0) {
                this.bTC = true;
            } else {
                this.bTC = false;
            }
            if (this.bTC) {
                this.bbg.setIsGod(false);
            } else if (this.ain.getAuthor() == null || this.ain.getAuthor().getPendantData() == null || StringUtils.isNull(this.ain.getAuthor().getPendantData().qd())) {
                this.bbg.setIsGod(true);
            } else {
                this.bbg.setIsGod(false);
            }
            if (bjVar.getAuthor() != null) {
                this.brF.a(bjVar.getAuthor());
                if (this.bTC) {
                    this.btg.setVisibility(4);
                } else {
                    this.btg.setVisibility(0);
                    gF(bjVar.getAuthor().getFansNum());
                }
                if (this.ain.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ain.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.brE.setVisibility(8);
                    return;
                } else if (this.bTC) {
                    this.brE.setVisibility(8);
                    return;
                } else if (this.ain.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ain.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.brE.setVisibility(8);
                    } else {
                        this.brE.setVisibility(0);
                        this.brE.aO(true);
                    }
                } else {
                    this.brE.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bbm.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.brE.getLayoutParams();
            if (bjVar.sl() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds20);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds40);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i((View) this.btg, w.e.cp_cont_d);
            this.brE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(int i) {
        if (this.btg != null) {
            this.btg.setText(String.format(this.ajF.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
        }
    }
}
