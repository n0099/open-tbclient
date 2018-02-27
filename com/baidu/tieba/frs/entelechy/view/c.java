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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends e {
    private bd aZA;
    private com.baidu.tbadk.core.view.userLike.c cVX;
    public TextView dLA;
    public EntelechyUserLikeButton dLB;
    private CommonUserLikeButton.a dLC;
    private View.OnClickListener dLD;
    private View.OnClickListener dLE;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dLC = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                c.this.nl(i);
            }
        };
        this.dLD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZA != null && c.this.aZA.zn() != null && !StringUtils.isNull(c.this.aZA.zn().getName_show()) && !StringUtils.isNull(c.this.aZA.zn().getUserId()) && c.this.aZA.zt() != null) {
                    if (c.this.akO() != null) {
                        c.this.akO().a(view, c.this.aZA);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.aZA.zn().getUserId(), c.this.aZA.zn().getName_show(), c.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.dLE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akO() != null) {
                    c.this.akO().a(view, c.this.aZA);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bdL.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLI.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds4);
        this.dLI.setLayoutParams(layoutParams);
        this.dLA = new TextView(tbPageContext.getPageActivity());
        this.dLA.setId(d.g.fans_num);
        this.dLA.setIncludeFontPadding(false);
        this.dLA.setTextSize(0, com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds14);
        this.dLA.setLayoutParams(layoutParams2);
        this.dLA.setOnClickListener(this.dLD);
        this.cmX.addView(this.dLA, 1);
        this.dLB = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dLB.setId(d.g.card_god_feed_like_btn);
        this.dLB.setFanNumCallBack(this.dLC);
        this.cVX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dLB);
        this.cVX.setFromType("0");
        this.cVX.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
        this.dLB.setGravity(21);
        this.dLB.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.dLB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.aZA = bdVar;
            if (bdVar.zn() != null) {
                nl(bdVar.zn().getFansNum());
                this.cVX.a(bdVar.zn());
                if (this.aZA.zn().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aZA.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dLB.setVisibility(8);
                    return;
                } else if (this.aZA.zn().getGodUserData().getIsLike()) {
                    if (this.aZA.zn().getGodUserData().getIsFromNetWork()) {
                        this.dLB.setVisibility(8);
                    } else {
                        this.dLB.setVisibility(0);
                        this.dLB.bz(true);
                    }
                } else {
                    this.dLB.setVisibility(0);
                }
            }
            MetaData zn = bdVar.zn();
            ThemeCardInUserData themeCardInUserData = null;
            if (zn != null) {
                themeCardInUserData = zn.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.cmY.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLB.getLayoutParams();
            if (!z && bdVar.zJ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.r(this.dLA, d.C0141d.cp_cont_d);
            this.dLB.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.dLA != null) {
            this.dLA.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.C(i)));
        }
    }
}
