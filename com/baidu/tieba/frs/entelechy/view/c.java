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
    private bd aXU;
    private com.baidu.tbadk.core.view.userLike.c cSU;
    public TextView dIq;
    public EntelechyUserLikeButton dIr;
    private CommonUserLikeButton.a dIs;
    private View.OnClickListener dIt;
    private View.OnClickListener dIu;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dIs = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gC(int i) {
                c.this.nn(i);
            }
        };
        this.dIt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXU != null && c.this.aXU.yS() != null && !StringUtils.isNull(c.this.aXU.yS().getName_show()) && !StringUtils.isNull(c.this.aXU.yS().getUserId()) && c.this.aXU.yY() != null) {
                    if (c.this.akb() != null) {
                        c.this.akb().a(view, c.this.aXU);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.aXU.yS().getUserId(), c.this.aXU.yS().getName_show(), c.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.dIu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akb() != null) {
                    c.this.akb().a(view, c.this.aXU);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bbZ.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dIy.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds4);
        this.dIy.setLayoutParams(layoutParams);
        this.dIq = new TextView(tbPageContext.getPageActivity());
        this.dIq.setId(d.g.fans_num);
        this.dIq.setIncludeFontPadding(false);
        this.dIq.setTextSize(0, com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.s(tbPageContext.getPageActivity(), d.e.ds14);
        this.dIq.setLayoutParams(layoutParams2);
        this.dIq.setOnClickListener(this.dIt);
        this.cjI.addView(this.dIq, 1);
        this.dIr = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dIr.setId(d.g.card_god_feed_like_btn);
        this.dIr.setFanNumCallBack(this.dIs);
        this.cSU = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dIr);
        this.cSU.setFromType("0");
        this.cSU.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
        this.dIr.setGravity(21);
        this.dIr.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.dIr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.aXU = bdVar;
            if (bdVar.yS() != null) {
                nn(bdVar.yS().getFansNum());
                this.cSU.a(bdVar.yS());
                if (this.aXU.yS().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aXU.yS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dIr.setVisibility(8);
                    return;
                } else if (this.aXU.yS().getGodUserData().getIsLike()) {
                    if (this.aXU.yS().getGodUserData().getIsFromNetWork()) {
                        this.dIr.setVisibility(8);
                    } else {
                        this.dIr.setVisibility(0);
                        this.dIr.bt(true);
                    }
                } else {
                    this.dIr.setVisibility(0);
                }
            }
            MetaData yS = bdVar.yS();
            ThemeCardInUserData themeCardInUserData = null;
            if (yS != null) {
                themeCardInUserData = yS.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.cjJ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIr.getLayoutParams();
            if (!z && bdVar.zo() != null) {
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
            aj.r(this.dIq, d.C0107d.cp_cont_d);
            this.dIr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(int i) {
        if (this.dIq != null) {
            this.dIq.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.C(i)));
        }
    }
}
