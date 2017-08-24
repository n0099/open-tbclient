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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends e {
    private bl akl;
    private View.OnClickListener bHX;
    private View.OnClickListener bHY;
    private com.baidu.tbadk.core.view.userLike.c bHe;
    public TextView bIa;
    public EntelechyUserLikeButton bIb;
    private CommonUserLikeButton.a bId;
    private int mSkinType;
    private TbPageContext oW;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bId = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                c.this.hu(i);
            }
        };
        this.bHX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akl != null && c.this.akl.getAuthor() != null && !StringUtils.isNull(c.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(c.this.akl.getAuthor().getUserId()) && c.this.akl.rL() != null) {
                    if (c.this.Wx() != null) {
                        c.this.Wx().a(view, c.this.akl);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.oW.getPageActivity(), c.this.akl.getAuthor().getUserId(), c.this.akl.getAuthor().getName_show(), c.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bHY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Wx() != null) {
                    c.this.Wx().a(view, c.this.akl);
                }
            }
        };
        this.oW = tbPageContext;
        this.aoS.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIu.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds4);
        this.bIu.setLayoutParams(layoutParams);
        this.bIa = new TextView(tbPageContext.getPageActivity());
        this.bIa.setId(d.h.fans_num);
        this.bIa.setIncludeFontPadding(false);
        this.bIa.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds14);
        this.bIa.setLayoutParams(layoutParams2);
        this.bIa.setOnClickListener(this.bHX);
        this.bli.addView(this.bIa, 1);
        this.bIb = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bIb.setId(d.h.card_god_feed_like_btn);
        this.bIb.setFanNumCallBack(this.bId);
        this.bHe = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bIb);
        this.bHe.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
        this.bIb.setGravity(21);
        this.bIb.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bIb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        boolean z = false;
        super.a(blVar);
        if (blVar != null) {
            this.akl = blVar;
            if (blVar.getAuthor() != null) {
                hu(blVar.getAuthor().getFansNum());
                this.bHe.a(blVar.getAuthor());
                if (this.akl.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.akl.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bIb.setVisibility(8);
                    return;
                } else if (this.akl.getAuthor().getGodUserData().getIsLike()) {
                    if (this.akl.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bIb.setVisibility(8);
                    } else {
                        this.bIb.setVisibility(0);
                        this.bIb.aQ(true);
                    }
                } else {
                    this.bIb.setVisibility(0);
                }
            }
            MetaData author = blVar.getAuthor();
            ThemeCardInUserData themeCardInUserData = null;
            if (author != null) {
                themeCardInUserData = author.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.blj.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bIb.getLayoutParams();
            if (!z && blVar.sb() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bIa, d.e.cp_cont_d);
            this.bIb.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        if (this.bIa != null) {
            this.bIa.setText(String.format(this.oW.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
