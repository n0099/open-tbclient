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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends e {
    private bd ajM;
    private com.baidu.tbadk.core.view.userLike.c bZG;
    public TextView cOK;
    public EntelechyUserLikeButton cOL;
    private CommonUserLikeButton.a cOM;
    private View.OnClickListener cON;
    private View.OnClickListener cOO;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cOM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                c.this.kk(i);
            }
        };
        this.cON = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajM != null && c.this.ajM.rx() != null && !StringUtils.isNull(c.this.ajM.rx().getName_show()) && !StringUtils.isNull(c.this.ajM.rx().getUserId()) && c.this.ajM.rD() != null) {
                    if (c.this.abs() != null) {
                        c.this.abs().a(view, c.this.ajM);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.ajM.rx().getUserId(), c.this.ajM.rx().getName_show(), c.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.cOO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abs() != null) {
                    c.this.abs().a(view, c.this.ajM);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.anW.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOS.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
        this.cOS.setLayoutParams(layoutParams);
        this.cOK = new TextView(tbPageContext.getPageActivity());
        this.cOK.setId(d.g.fans_num);
        this.cOK.setIncludeFontPadding(false);
        this.cOK.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds14);
        this.cOK.setLayoutParams(layoutParams2);
        this.cOK.setOnClickListener(this.cON);
        this.bvK.addView(this.cOK, 1);
        this.cOL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.cOL.setId(d.g.card_god_feed_like_btn);
        this.cOL.setFanNumCallBack(this.cOM);
        this.bZG = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cOL);
        this.bZG.setFromType("0");
        this.bZG.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        this.cOL.setGravity(21);
        this.cOL.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.cOL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: y */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.ajM = bdVar;
            if (bdVar.rx() != null) {
                kk(bdVar.rx().getFansNum());
                this.bZG.a(bdVar.rx());
                if (this.ajM.rx().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajM.rx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.cOL.setVisibility(8);
                    return;
                } else if (this.ajM.rx().getGodUserData().getIsLike()) {
                    if (this.ajM.rx().getGodUserData().getIsFromNetWork()) {
                        this.cOL.setVisibility(8);
                    } else {
                        this.cOL.setVisibility(0);
                        this.cOL.aM(true);
                    }
                } else {
                    this.cOL.setVisibility(0);
                }
            }
            MetaData rx = bdVar.rx();
            ThemeCardInUserData themeCardInUserData = null;
            if (rx != null) {
                themeCardInUserData = rx.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bvL.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOL.getLayoutParams();
            if (!z && bdVar.rT() != null) {
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
            aj.i(this.cOK, d.C0082d.cp_cont_d);
            this.cOL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(int i) {
        if (this.cOK != null) {
            this.cOK.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.u(i)));
        }
    }
}
