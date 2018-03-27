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
    private bd aZC;
    private com.baidu.tbadk.core.view.userLike.c cWa;
    public TextView dLF;
    public EntelechyUserLikeButton dLG;
    private CommonUserLikeButton.a dLH;
    private View.OnClickListener dLI;
    private View.OnClickListener dLJ;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dLH = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                c.this.nl(i);
            }
        };
        this.dLI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZC != null && c.this.aZC.zn() != null && !StringUtils.isNull(c.this.aZC.zn().getName_show()) && !StringUtils.isNull(c.this.aZC.zn().getUserId()) && c.this.aZC.zt() != null) {
                    if (c.this.akP() != null) {
                        c.this.akP().a(view, c.this.aZC);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.aZC.zn().getUserId(), c.this.aZC.zn().getName_show(), c.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.dLJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.aZC);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bdO.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLN.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds4);
        this.dLN.setLayoutParams(layoutParams);
        this.dLF = new TextView(tbPageContext.getPageActivity());
        this.dLF.setId(d.g.fans_num);
        this.dLF.setIncludeFontPadding(false);
        this.dLF.setTextSize(0, com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds14);
        this.dLF.setLayoutParams(layoutParams2);
        this.dLF.setOnClickListener(this.dLI);
        this.cna.addView(this.dLF, 1);
        this.dLG = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dLG.setId(d.g.card_god_feed_like_btn);
        this.dLG.setFanNumCallBack(this.dLH);
        this.cWa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dLG);
        this.cWa.setFromType("0");
        this.cWa.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
        this.dLG.setGravity(21);
        this.dLG.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.dLG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.aZC = bdVar;
            if (bdVar.zn() != null) {
                nl(bdVar.zn().getFansNum());
                this.cWa.a(bdVar.zn());
                if (this.aZC.zn().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aZC.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dLG.setVisibility(8);
                    return;
                } else if (this.aZC.zn().getGodUserData().getIsLike()) {
                    if (this.aZC.zn().getGodUserData().getIsFromNetWork()) {
                        this.dLG.setVisibility(8);
                    } else {
                        this.dLG.setVisibility(0);
                        this.dLG.bz(true);
                    }
                } else {
                    this.dLG.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.cnb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLG.getLayoutParams();
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
            aj.r(this.dLF, d.C0141d.cp_cont_d);
            this.dLG.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.dLF != null) {
            this.dLF.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.C(i)));
        }
    }
}
