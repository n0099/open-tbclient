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
/* loaded from: classes2.dex */
public class c extends e {
    private bd aYc;
    private com.baidu.tbadk.core.view.userLike.c cTp;
    public TextView dIL;
    public EntelechyUserLikeButton dIM;
    private CommonUserLikeButton.a dIN;
    private View.OnClickListener dIO;
    private View.OnClickListener dIP;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dIN = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gC(int i) {
                c.this.nn(i);
            }
        };
        this.dIO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aYc != null && c.this.aYc.yT() != null && !StringUtils.isNull(c.this.aYc.yT().getName_show()) && !StringUtils.isNull(c.this.aYc.yT().getUserId()) && c.this.aYc.yZ() != null) {
                    if (c.this.akg() != null) {
                        c.this.akg().a(view, c.this.aYc);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.aYc.yT().getUserId(), c.this.aYc.yT().getName_show(), c.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.dIP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akg() != null) {
                    c.this.akg().a(view, c.this.aYc);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bch.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dIT.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds4);
        this.dIT.setLayoutParams(layoutParams);
        this.dIL = new TextView(tbPageContext.getPageActivity());
        this.dIL.setId(d.g.fans_num);
        this.dIL.setIncludeFontPadding(false);
        this.dIL.setTextSize(0, com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds14);
        this.dIL.setLayoutParams(layoutParams2);
        this.dIL.setOnClickListener(this.dIO);
        this.cjQ.addView(this.dIL, 1);
        this.dIM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dIM.setId(d.g.card_god_feed_like_btn);
        this.dIM.setFanNumCallBack(this.dIN);
        this.cTp = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dIM);
        this.cTp.setFromType("0");
        this.cTp.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
        this.dIM.setGravity(21);
        this.dIM.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.dIM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.aYc = bdVar;
            if (bdVar.yT() != null) {
                nn(bdVar.yT().getFansNum());
                this.cTp.a(bdVar.yT());
                if (this.aYc.yT().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aYc.yT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dIM.setVisibility(8);
                    return;
                } else if (this.aYc.yT().getGodUserData().getIsLike()) {
                    if (this.aYc.yT().getGodUserData().getIsFromNetWork()) {
                        this.dIM.setVisibility(8);
                    } else {
                        this.dIM.setVisibility(0);
                        this.dIM.bu(true);
                    }
                } else {
                    this.dIM.setVisibility(0);
                }
            }
            MetaData yT = bdVar.yT();
            ThemeCardInUserData themeCardInUserData = null;
            if (yT != null) {
                themeCardInUserData = yT.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.cjR.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIM.getLayoutParams();
            if (!z && bdVar.zp() != null) {
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
            aj.r(this.dIL, d.C0108d.cp_cont_d);
            this.dIM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(int i) {
        if (this.dIL != null) {
            this.dIL.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.C(i)));
        }
    }
}
