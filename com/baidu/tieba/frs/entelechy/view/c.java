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
    private bj ajF;
    private com.baidu.tbadk.core.view.userLike.c bJX;
    private View.OnClickListener bKR;
    private View.OnClickListener bKS;
    public TextView bKU;
    public EntelechyUserLikeButton bKV;
    private CommonUserLikeButton.a bKX;
    private TbPageContext mF;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bKX = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dx(int i) {
                c.this.hF(i);
            }
        };
        this.bKR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajF != null && c.this.ajF.getAuthor() != null && !StringUtils.isNull(c.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(c.this.ajF.getAuthor().getUserId()) && c.this.ajF.rG() != null) {
                    if (c.this.XA() != null) {
                        c.this.XA().a(view, c.this.ajF);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mF.getPageActivity(), c.this.ajF.getAuthor().getUserId(), c.this.ajF.getAuthor().getName_show(), c.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bKS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.XA() != null) {
                    c.this.XA().a(view, c.this.ajF);
                }
            }
        };
        this.mF = tbPageContext;
        this.aor.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLo.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds4);
        this.bLo.setLayoutParams(layoutParams);
        this.bKU = new TextView(tbPageContext.getPageActivity());
        this.bKU.setId(d.h.fans_num);
        this.bKU.setIncludeFontPadding(false);
        this.bKU.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds14);
        this.bKU.setLayoutParams(layoutParams2);
        this.bKU.setOnClickListener(this.bKR);
        this.blD.addView(this.bKU, 1);
        this.bKV = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bKV.setId(d.h.card_god_feed_like_btn);
        this.bKV.setFanNumCallBack(this.bKX);
        this.bJX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bKV);
        this.bJX.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
        this.bKV.setGravity(21);
        this.bKV.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bKV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        boolean z = false;
        super.a(bjVar);
        if (bjVar != null) {
            this.ajF = bjVar;
            if (bjVar.getAuthor() != null) {
                hF(bjVar.getAuthor().getFansNum());
                this.bJX.a(bjVar.getAuthor());
                if (this.ajF.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajF.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bKV.setVisibility(8);
                    return;
                } else if (this.ajF.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ajF.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bKV.setVisibility(8);
                    } else {
                        this.bKV.setVisibility(0);
                        this.bKV.aQ(true);
                    }
                } else {
                    this.bKV.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.blE.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bKV.getLayoutParams();
            if (!z && bjVar.rW() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bKU, d.e.cp_cont_d);
            this.bKV.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF(int i) {
        if (this.bKU != null) {
            this.bKU.setText(String.format(this.mF.getResources().getString(d.l.fans_default_name_god_user), am.u(i)));
        }
    }
}
