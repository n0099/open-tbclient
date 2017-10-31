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
    private com.baidu.tbadk.core.view.userLike.c bRv;
    private View.OnClickListener bSA;
    public EntelechyUserLikeButton bSC;
    private View.OnClickListener bSz;
    public TextView cFl;
    private CommonUserLikeButton.a cFm;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cFm = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                c.this.jN(i);
            }
        };
        this.bSz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajq != null && c.this.ajq.rt() != null && !StringUtils.isNull(c.this.ajq.rt().getName_show()) && !StringUtils.isNull(c.this.ajq.rt().getUserId()) && c.this.ajq.rz() != null) {
                    if (c.this.Zx() != null) {
                        c.this.Zx().a(view, c.this.ajq);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.ajq.rt().getUserId(), c.this.ajq.rt().getName_show(), c.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bSA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Zx() != null) {
                    c.this.Zx().a(view, c.this.ajq);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.anN.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSU.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
        this.bSU.setLayoutParams(layoutParams);
        this.cFl = new TextView(tbPageContext.getPageActivity());
        this.cFl.setId(d.g.fans_num);
        this.cFl.setIncludeFontPadding(false);
        this.cFl.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds14);
        this.cFl.setLayoutParams(layoutParams2);
        this.cFl.setOnClickListener(this.bSz);
        this.boH.addView(this.cFl, 1);
        this.bSC = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bSC.setId(d.g.card_god_feed_like_btn);
        this.bSC.setFanNumCallBack(this.cFm);
        this.bRv = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bSC);
        this.bRv.setFromType("0");
        this.bRv.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        this.bSC.setGravity(21);
        this.bSC.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bSC);
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
                jN(bhVar.rt().getFansNum());
                this.bRv.a(bhVar.rt());
                if (this.ajq.rt().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajq.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bSC.setVisibility(8);
                    return;
                } else if (this.ajq.rt().getGodUserData().getIsLike()) {
                    if (this.ajq.rt().getGodUserData().getIsFromNetWork()) {
                        this.bSC.setVisibility(8);
                    } else {
                        this.bSC.setVisibility(0);
                        this.bSC.aM(true);
                    }
                } else {
                    this.bSC.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.boI.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSC.getLayoutParams();
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
            aj.i(this.cFl, d.C0080d.cp_cont_d);
            this.bSC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN(int i) {
        if (this.cFl != null) {
            this.cFl.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.u(i)));
        }
    }
}
