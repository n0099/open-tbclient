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
    private bl akj;
    private TbPageContext alI;
    private com.baidu.tbadk.core.view.userLike.c bGu;
    private View.OnClickListener bHn;
    private View.OnClickListener bHo;
    public TextView bHq;
    public EntelechyUserLikeButton bHr;
    private CommonUserLikeButton.a bHt;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bHt = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                c.this.ht(i);
            }
        };
        this.bHn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akj != null && c.this.akj.getAuthor() != null && !StringUtils.isNull(c.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(c.this.akj.getAuthor().getUserId()) && c.this.akj.rK() != null) {
                    if (c.this.We() != null) {
                        c.this.We().a(view, c.this.akj);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.alI.getPageActivity(), c.this.akj.getAuthor().getUserId(), c.this.akj.getAuthor().getName_show(), c.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bHo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.We() != null) {
                    c.this.We().a(view, c.this.akj);
                }
            }
        };
        this.alI = tbPageContext;
        this.aoR.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHK.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds4);
        this.bHK.setLayoutParams(layoutParams);
        this.bHq = new TextView(tbPageContext.getPageActivity());
        this.bHq.setId(d.h.fans_num);
        this.bHq.setIncludeFontPadding(false);
        this.bHq.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds14);
        this.bHq.setLayoutParams(layoutParams2);
        this.bHq.setOnClickListener(this.bHn);
        this.bld.addView(this.bHq, 1);
        this.bHr = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bHr.setId(d.h.card_god_feed_like_btn);
        this.bHr.setFanNumCallBack(this.bHt);
        this.bGu = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bHr);
        this.bGu.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
        this.bHr.setGravity(21);
        this.bHr.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bHr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        boolean z = false;
        super.a(blVar);
        if (blVar != null) {
            this.akj = blVar;
            if (blVar.getAuthor() != null) {
                ht(blVar.getAuthor().getFansNum());
                this.bGu.a(blVar.getAuthor());
                if (this.akj.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.akj.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bHr.setVisibility(8);
                    return;
                } else if (this.akj.getAuthor().getGodUserData().getIsLike()) {
                    if (this.akj.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bHr.setVisibility(8);
                    } else {
                        this.bHr.setVisibility(0);
                        this.bHr.aQ(true);
                    }
                } else {
                    this.bHr.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.ble.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bHr.getLayoutParams();
            if (!z && blVar.sa() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bHq, d.e.cp_cont_d);
            this.bHr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(int i) {
        if (this.bHq != null) {
            this.bHq.setText(String.format(this.alI.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
