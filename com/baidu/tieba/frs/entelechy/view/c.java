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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends e {
    private bj ajE;
    private com.baidu.tbadk.core.view.userLike.c bKO;
    private View.OnClickListener bLI;
    private View.OnClickListener bLJ;
    public TextView bLL;
    public EntelechyUserLikeButton bLM;
    private CommonUserLikeButton.a bLO;
    private TbPageContext mF;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bLO = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dx(int i) {
                c.this.hH(i);
            }
        };
        this.bLI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajE != null && c.this.ajE.getAuthor() != null && !StringUtils.isNull(c.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(c.this.ajE.getAuthor().getUserId()) && c.this.ajE.rG() != null) {
                    if (c.this.XL() != null) {
                        c.this.XL().a(view, c.this.ajE);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mF.getPageActivity(), c.this.ajE.getAuthor().getUserId(), c.this.ajE.getAuthor().getName_show(), c.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bLJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XL() != null) {
                    c.this.XL().a(view, c.this.ajE);
                }
            }
        };
        this.mF = tbPageContext;
        this.aop.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMf.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds4);
        this.bMf.setLayoutParams(layoutParams);
        this.bLL = new TextView(tbPageContext.getPageActivity());
        this.bLL.setId(d.h.fans_num);
        this.bLL.setIncludeFontPadding(false);
        this.bLL.setTextSize(0, com.baidu.adp.lib.util.k.f(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.f(tbPageContext.getPageActivity(), d.f.ds14);
        this.bLL.setLayoutParams(layoutParams2);
        this.bLL.setOnClickListener(this.bLI);
        this.blC.addView(this.bLL, 1);
        this.bLM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bLM.setId(d.h.card_god_feed_like_btn);
        this.bLM.setFanNumCallBack(this.bLO);
        this.bKO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bLM);
        this.bKO.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
        this.bLM.setGravity(21);
        this.bLM.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bLM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        boolean z = false;
        super.a(bjVar);
        if (bjVar != null) {
            this.ajE = bjVar;
            if (bjVar.getAuthor() != null) {
                hH(bjVar.getAuthor().getFansNum());
                this.bKO.a(bjVar.getAuthor());
                if (this.ajE.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajE.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bLM.setVisibility(8);
                    return;
                } else if (this.ajE.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ajE.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bLM.setVisibility(8);
                    } else {
                        this.bLM.setVisibility(0);
                        this.bLM.aQ(true);
                    }
                } else {
                    this.bLM.setVisibility(0);
                }
            }
            MetaData author = bjVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.blD.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLM.getLayoutParams();
            if (!z && bjVar.rW() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bLL, d.e.cp_cont_d);
            this.bLM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        if (this.bLL != null) {
            this.bLL.setText(String.format(this.mF.getResources().getString(d.l.fans_default_name_god_user), am.u(i)));
        }
    }
}
