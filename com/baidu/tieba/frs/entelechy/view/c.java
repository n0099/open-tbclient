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
    private bd ajJ;
    private com.baidu.tbadk.core.view.userLike.c bZK;
    public TextView cOV;
    public EntelechyUserLikeButton cOW;
    private CommonUserLikeButton.a cOX;
    private View.OnClickListener cOY;
    private View.OnClickListener cOZ;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cOX = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                c.this.km(i);
            }
        };
        this.cOY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajJ != null && c.this.ajJ.rv() != null && !StringUtils.isNull(c.this.ajJ.rv().getName_show()) && !StringUtils.isNull(c.this.ajJ.rv().getUserId()) && c.this.ajJ.rB() != null) {
                    if (c.this.abt() != null) {
                        c.this.abt().a(view, c.this.ajJ);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.ajJ.rv().getUserId(), c.this.ajJ.rv().getName_show(), c.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.cOZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.ajJ);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.anY.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPd.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
        this.cPd.setLayoutParams(layoutParams);
        this.cOV = new TextView(tbPageContext.getPageActivity());
        this.cOV.setId(d.g.fans_num);
        this.cOV.setIncludeFontPadding(false);
        this.cOV.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds14);
        this.cOV.setLayoutParams(layoutParams2);
        this.cOV.setOnClickListener(this.cOY);
        this.bvL.addView(this.cOV, 1);
        this.cOW = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.cOW.setId(d.g.card_god_feed_like_btn);
        this.cOW.setFanNumCallBack(this.cOX);
        this.bZK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cOW);
        this.bZK.setFromType("0");
        this.bZK.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        this.cOW.setGravity(21);
        this.cOW.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.cOW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.ajJ = bdVar;
            if (bdVar.rv() != null) {
                km(bdVar.rv().getFansNum());
                this.bZK.a(bdVar.rv());
                if (this.ajJ.rv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajJ.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.cOW.setVisibility(8);
                    return;
                } else if (this.ajJ.rv().getGodUserData().getIsLike()) {
                    if (this.ajJ.rv().getGodUserData().getIsFromNetWork()) {
                        this.cOW.setVisibility(8);
                    } else {
                        this.cOW.setVisibility(0);
                        this.cOW.aN(true);
                    }
                } else {
                    this.cOW.setVisibility(0);
                }
            }
            MetaData rv = bdVar.rv();
            ThemeCardInUserData themeCardInUserData = null;
            if (rv != null) {
                themeCardInUserData = rv.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bvM.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOW.getLayoutParams();
            if (!z && bdVar.rR() != null) {
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
            aj.i(this.cOV, d.C0096d.cp_cont_d);
            this.cOW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        if (this.cOV != null) {
            this.cOV.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.u(i)));
        }
    }
}
