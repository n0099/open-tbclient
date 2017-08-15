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
    private View.OnClickListener bHW;
    private View.OnClickListener bHX;
    public TextView bHZ;
    private com.baidu.tbadk.core.view.userLike.c bHd;
    public EntelechyUserLikeButton bIa;
    private CommonUserLikeButton.a bIc;
    private int mSkinType;
    private TbPageContext oV;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bIc = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                c.this.hu(i);
            }
        };
        this.bHW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akl != null && c.this.akl.getAuthor() != null && !StringUtils.isNull(c.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(c.this.akl.getAuthor().getUserId()) && c.this.akl.rK() != null) {
                    if (c.this.WA() != null) {
                        c.this.WA().a(view, c.this.akl);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.oV.getPageActivity(), c.this.akl.getAuthor().getUserId(), c.this.akl.getAuthor().getName_show(), c.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bHX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.WA() != null) {
                    c.this.WA().a(view, c.this.akl);
                }
            }
        };
        this.oV = tbPageContext;
        this.aoS.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIt.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds4);
        this.bIt.setLayoutParams(layoutParams);
        this.bHZ = new TextView(tbPageContext.getPageActivity());
        this.bHZ.setId(d.h.fans_num);
        this.bHZ.setIncludeFontPadding(false);
        this.bHZ.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds14);
        this.bHZ.setLayoutParams(layoutParams2);
        this.bHZ.setOnClickListener(this.bHW);
        this.blh.addView(this.bHZ, 1);
        this.bIa = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bIa.setId(d.h.card_god_feed_like_btn);
        this.bIa.setFanNumCallBack(this.bIc);
        this.bHd = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bIa);
        this.bHd.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds32);
        this.bIa.setGravity(21);
        this.bIa.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bIa);
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
                this.bHd.a(blVar.getAuthor());
                if (this.akl.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.akl.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bIa.setVisibility(8);
                    return;
                } else if (this.akl.getAuthor().getGodUserData().getIsLike()) {
                    if (this.akl.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bIa.setVisibility(8);
                    } else {
                        this.bIa.setVisibility(0);
                        this.bIa.aQ(true);
                    }
                } else {
                    this.bIa.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bli.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bIa.getLayoutParams();
            if (!z && blVar.sa() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bHZ, d.e.cp_cont_d);
            this.bIa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        if (this.bHZ != null) {
            this.bHZ.setText(String.format(this.oV.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
