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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends e {
    private be aXV;
    private com.baidu.tbadk.core.view.userLike.c cOt;
    public TextView dDP;
    public EntelechyUserLikeButton dDQ;
    private CommonUserLikeButton.a dDR;
    private View.OnClickListener dDS;
    private View.OnClickListener dDT;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dDR = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gF(int i) {
                c.this.nk(i);
            }
        };
        this.dDS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXV != null && c.this.aXV.yX() != null && !StringUtils.isNull(c.this.aXV.yX().getName_show()) && !StringUtils.isNull(c.this.aXV.yX().getUserId()) && c.this.aXV.zd() != null) {
                    if (c.this.aiY() != null) {
                        c.this.aiY().a(view, c.this.aXV);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.aXV.yX().getUserId(), c.this.aXV.yX().getName_show(), c.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.dDT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiY() != null) {
                    c.this.aiY().a(view, c.this.aXV);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bbZ.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDX.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds4);
        this.dDX.setLayoutParams(layoutParams);
        this.dDP = new TextView(tbPageContext.getPageActivity());
        this.dDP.setId(d.g.fans_num);
        this.dDP.setIncludeFontPadding(false);
        this.dDP.setTextSize(0, com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds14);
        this.dDP.setLayoutParams(layoutParams2);
        this.dDP.setOnClickListener(this.dDS);
        this.cjA.addView(this.dDP, 1);
        this.dDQ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dDQ.setId(d.g.card_god_feed_like_btn);
        this.dDQ.setFanNumCallBack(this.dDR);
        this.cOt = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dDQ);
        this.cOt.setFromType("0");
        this.cOt.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
        this.dDQ.setGravity(21);
        this.dDQ.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.dDQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(be beVar) {
        boolean z = false;
        super.a(beVar);
        if (beVar != null) {
            this.aXV = beVar;
            if (beVar.yX() != null) {
                nk(beVar.yX().getFansNum());
                this.cOt.a(beVar.yX());
                if (this.aXV.yX().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aXV.yX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dDQ.setVisibility(8);
                    return;
                } else if (this.aXV.yX().getGodUserData().getIsLike()) {
                    if (this.aXV.yX().getGodUserData().getIsFromNetWork()) {
                        this.dDQ.setVisibility(8);
                    } else {
                        this.dDQ.setVisibility(0);
                        this.dDQ.bt(true);
                    }
                } else {
                    this.dDQ.setVisibility(0);
                }
            }
            MetaData yX = beVar.yX();
            ThemeCardInUserData themeCardInUserData = null;
            if (yX != null) {
                themeCardInUserData = yX.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.cjB.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDQ.getLayoutParams();
            if (!z && beVar.zt() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.r(this.dDP, d.C0108d.cp_cont_d);
            this.dDQ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nk(int i) {
        if (this.dDP != null) {
            this.dDP.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.C(i)));
        }
    }
}
