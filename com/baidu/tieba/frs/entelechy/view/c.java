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
    private bh aiU;
    private com.baidu.tbadk.core.view.userLike.c bJP;
    private View.OnClickListener bKS;
    private View.OnClickListener bKT;
    public TextView bKV;
    public EntelechyUserLikeButton bKW;
    private CommonUserLikeButton.a bKY;
    private TbPageContext mH;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bKY = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dG(int i) {
                c.this.hO(i);
            }
        };
        this.bKS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiU != null && c.this.aiU.getAuthor() != null && !StringUtils.isNull(c.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(c.this.aiU.getAuthor().getUserId()) && c.this.aiU.rt() != null) {
                    if (c.this.Xn() != null) {
                        c.this.Xn().a(view, c.this.aiU);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mH.getPageActivity(), c.this.aiU.getAuthor().getUserId(), c.this.aiU.getAuthor().getName_show(), c.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bKT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xn() != null) {
                    c.this.Xn().a(view, c.this.aiU);
                }
            }
        };
        this.mH = tbPageContext;
        this.ans.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLq.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds4);
        this.bLq.setLayoutParams(layoutParams);
        this.bKV = new TextView(tbPageContext.getPageActivity());
        this.bKV.setId(d.h.fans_num);
        this.bKV.setIncludeFontPadding(false);
        this.bKV.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds14);
        this.bKV.setLayoutParams(layoutParams2);
        this.bKV.setOnClickListener(this.bKS);
        this.bmZ.addView(this.bKV, 1);
        this.bKW = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bKW.setId(d.h.card_god_feed_like_btn);
        this.bKW.setFanNumCallBack(this.bKY);
        this.bJP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bKW);
        this.bJP.setFromType("0");
        this.bJP.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
        this.bKW.setGravity(21);
        this.bKW.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bKW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        boolean z = false;
        super.a(bhVar);
        if (bhVar != null) {
            this.aiU = bhVar;
            if (bhVar.getAuthor() != null) {
                hO(bhVar.getAuthor().getFansNum());
                this.bJP.a(bhVar.getAuthor());
                if (this.aiU.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiU.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bKW.setVisibility(8);
                    return;
                } else if (this.aiU.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiU.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bKW.setVisibility(8);
                    } else {
                        this.bKW.setVisibility(0);
                        this.bKW.aO(true);
                    }
                } else {
                    this.bKW.setVisibility(0);
                }
            }
            MetaData author = bhVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bna.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bKW.getLayoutParams();
            if (!z && bhVar.rJ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bKV, d.e.cp_cont_d);
            this.bKW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (this.bKV != null) {
            this.bKV.setText(String.format(this.mH.getResources().getString(d.l.fans_default_name_god_user), am.u(i)));
        }
    }
}
