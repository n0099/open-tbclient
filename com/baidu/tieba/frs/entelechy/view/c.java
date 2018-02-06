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
    private bd aZM;
    private com.baidu.tbadk.core.view.userLike.c cWj;
    public TextView dLM;
    public EntelechyUserLikeButton dLN;
    private CommonUserLikeButton.a dLO;
    private View.OnClickListener dLP;
    private View.OnClickListener dLQ;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dLO = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                c.this.nl(i);
            }
        };
        this.dLP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZM != null && c.this.aZM.zn() != null && !StringUtils.isNull(c.this.aZM.zn().getName_show()) && !StringUtils.isNull(c.this.aZM.zn().getUserId()) && c.this.aZM.zt() != null) {
                    if (c.this.akP() != null) {
                        c.this.akP().a(view, c.this.aZM);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.aZM.zn().getUserId(), c.this.aZM.zn().getName_show(), c.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.dLQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.aZM);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bdX.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLU.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds4);
        this.dLU.setLayoutParams(layoutParams);
        this.dLM = new TextView(tbPageContext.getPageActivity());
        this.dLM.setId(d.g.fans_num);
        this.dLM.setIncludeFontPadding(false);
        this.dLM.setTextSize(0, com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds14);
        this.dLM.setLayoutParams(layoutParams2);
        this.dLM.setOnClickListener(this.dLP);
        this.cnj.addView(this.dLM, 1);
        this.dLN = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dLN.setId(d.g.card_god_feed_like_btn);
        this.dLN.setFanNumCallBack(this.dLO);
        this.cWj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dLN);
        this.cWj.setFromType("0");
        this.cWj.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
        this.dLN.setGravity(21);
        this.dLN.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.dLN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.aZM = bdVar;
            if (bdVar.zn() != null) {
                nl(bdVar.zn().getFansNum());
                this.cWj.a(bdVar.zn());
                if (this.aZM.zn().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aZM.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dLN.setVisibility(8);
                    return;
                } else if (this.aZM.zn().getGodUserData().getIsLike()) {
                    if (this.aZM.zn().getGodUserData().getIsFromNetWork()) {
                        this.dLN.setVisibility(8);
                    } else {
                        this.dLN.setVisibility(0);
                        this.dLN.bz(true);
                    }
                } else {
                    this.dLN.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.cnk.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLN.getLayoutParams();
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
            aj.r(this.dLM, d.C0140d.cp_cont_d);
            this.dLN.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.dLM != null) {
            this.dLM.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.C(i)));
        }
    }
}
