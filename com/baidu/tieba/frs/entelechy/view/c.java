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
    private bh ajg;
    private com.baidu.tbadk.core.view.userLike.c bKb;
    private View.OnClickListener bLe;
    private View.OnClickListener bLf;
    public TextView bLh;
    public EntelechyUserLikeButton bLi;
    private CommonUserLikeButton.a bLk;
    private TbPageContext mG;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bLk = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                c.this.hP(i);
            }
        };
        this.bLe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajg != null && c.this.ajg.getAuthor() != null && !StringUtils.isNull(c.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(c.this.ajg.getAuthor().getUserId()) && c.this.ajg.rA() != null) {
                    if (c.this.Xr() != null) {
                        c.this.Xr().a(view, c.this.ajg);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mG.getPageActivity(), c.this.ajg.getAuthor().getUserId(), c.this.ajg.getAuthor().getName_show(), c.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bLf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.Xr() != null) {
                    c.this.Xr().a(view, c.this.ajg);
                }
            }
        };
        this.mG = tbPageContext;
        this.anE.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLC.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds4);
        this.bLC.setLayoutParams(layoutParams);
        this.bLh = new TextView(tbPageContext.getPageActivity());
        this.bLh.setId(d.h.fans_num);
        this.bLh.setIncludeFontPadding(false);
        this.bLh.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds14);
        this.bLh.setLayoutParams(layoutParams2);
        this.bLh.setOnClickListener(this.bLe);
        this.bnn.addView(this.bLh, 1);
        this.bLi = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bLi.setId(d.h.card_god_feed_like_btn);
        this.bLi.setFanNumCallBack(this.bLk);
        this.bKb = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bLi);
        this.bKb.setFromType("0");
        this.bKb.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
        this.bLi.setGravity(21);
        this.bLi.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bLi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        boolean z = false;
        super.a(bhVar);
        if (bhVar != null) {
            this.ajg = bhVar;
            if (bhVar.getAuthor() != null) {
                hP(bhVar.getAuthor().getFansNum());
                this.bKb.a(bhVar.getAuthor());
                if (this.ajg.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajg.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bLi.setVisibility(8);
                    return;
                } else if (this.ajg.getAuthor().getGodUserData().getIsLike()) {
                    if (this.ajg.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bLi.setVisibility(8);
                    } else {
                        this.bLi.setVisibility(0);
                        this.bLi.aP(true);
                    }
                } else {
                    this.bLi.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bno.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLi.getLayoutParams();
            if (!z && bhVar.rQ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bLh, d.e.cp_cont_d);
            this.bLi.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(int i) {
        if (this.bLh != null) {
            this.bLh.setText(String.format(this.mG.getResources().getString(d.l.fans_default_name_god_user), am.t(i)));
        }
    }
}
