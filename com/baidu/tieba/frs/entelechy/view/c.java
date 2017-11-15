package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends e {
    private bh ajq;
    private com.baidu.tbadk.core.view.userLike.c bRI;
    private View.OnClickListener bSM;
    private View.OnClickListener bSN;
    public EntelechyUserLikeButton bSP;
    public TextView cFE;
    private CommonUserLikeButton.a cFF;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cFF = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dG(int i) {
                c.this.jM(i);
            }
        };
        this.bSM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajq != null && c.this.ajq.rt() != null && !StringUtils.isNull(c.this.ajq.rt().getName_show()) && !StringUtils.isNull(c.this.ajq.rt().getUserId()) && c.this.ajq.rz() != null) {
                    if (c.this.ZJ() != null) {
                        c.this.ZJ().a(view, c.this.ajq);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.ajq.rt().getUserId(), c.this.ajq.rt().getName_show(), c.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ZJ() != null) {
                    c.this.ZJ().a(view, c.this.ajq);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.anM.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTh.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
        this.bTh.setLayoutParams(layoutParams);
        this.cFE = new TextView(tbPageContext.getPageActivity());
        this.cFE.setId(d.g.fans_num);
        this.cFE.setIncludeFontPadding(false);
        this.cFE.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds14);
        this.cFE.setLayoutParams(layoutParams2);
        this.cFE.setOnClickListener(this.bSM);
        this.boQ.addView(this.cFE, 1);
        this.bSP = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bSP.setId(d.g.card_god_feed_like_btn);
        this.bSP.setFanNumCallBack(this.cFF);
        this.bRI = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bSP);
        this.bRI.setFromType("0");
        this.bRI.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        this.bSP.setGravity(21);
        this.bSP.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bSP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        boolean z = false;
        super.a(bhVar);
        if (bhVar != null) {
            this.ajq = bhVar;
            if (bhVar.rt() != null) {
                jM(bhVar.rt().getFansNum());
                this.bRI.a(bhVar.rt());
                if (this.ajq.rt().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajq.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bSP.setVisibility(8);
                    return;
                } else if (this.ajq.rt().getGodUserData().getIsLike()) {
                    if (this.ajq.rt().getGodUserData().getIsFromNetWork()) {
                        this.bSP.setVisibility(8);
                    } else {
                        this.bSP.setVisibility(0);
                        this.bSP.aM(true);
                    }
                } else {
                    this.bSP.setVisibility(0);
                }
            }
            MetaData rt = bhVar.rt();
            ThemeCardInUserData themeCardInUserData = null;
            if (rt != null) {
                themeCardInUserData = rt.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.boR.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSP.getLayoutParams();
            if (!z && bhVar.rP() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.cFE, d.C0080d.cp_cont_d);
            this.bSP.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(int i) {
        if (this.cFE != null) {
            this.cFE.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.u(i)));
        }
    }
}
