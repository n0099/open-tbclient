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
    private bl aiQ;
    private TbPageContext ako;
    private com.baidu.tbadk.core.view.userLike.c bFk;
    private View.OnClickListener bGd;
    private View.OnClickListener bGe;
    public TextView bGg;
    public EntelechyUserLikeButton bGh;
    private CommonUserLikeButton.a bGj;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bGj = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void du(int i) {
                c.this.hs(i);
            }
        };
        this.bGd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiQ != null && c.this.aiQ.getAuthor() != null && !StringUtils.isNull(c.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(c.this.aiQ.getAuthor().getUserId()) && c.this.aiQ.rA() != null) {
                    if (c.this.VZ() != null) {
                        c.this.VZ().a(view, c.this.aiQ);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.ako.getPageActivity(), c.this.aiQ.getAuthor().getUserId(), c.this.aiQ.getAuthor().getName_show(), c.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bGe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.aiQ);
                }
            }
        };
        this.ako = tbPageContext;
        this.any.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGA.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds4);
        this.bGA.setLayoutParams(layoutParams);
        this.bGg = new TextView(tbPageContext.getPageActivity());
        this.bGg.setId(d.h.fans_num);
        this.bGg.setIncludeFontPadding(false);
        this.bGg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds14);
        this.bGg.setLayoutParams(layoutParams2);
        this.bGg.setOnClickListener(this.bGd);
        this.bjT.addView(this.bGg, 1);
        this.bGh = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bGh.setId(d.h.card_god_feed_like_btn);
        this.bGh.setFanNumCallBack(this.bGj);
        this.bFk = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bGh);
        this.bFk.i(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.h.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
        this.bGh.setGravity(21);
        this.bGh.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.bGh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        boolean z = false;
        super.a(blVar);
        if (blVar != null) {
            this.aiQ = blVar;
            if (blVar.getAuthor() != null) {
                hs(blVar.getAuthor().getFansNum());
                this.bFk.a(blVar.getAuthor());
                if (this.aiQ.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiQ.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bGh.setVisibility(8);
                    return;
                } else if (this.aiQ.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiQ.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bGh.setVisibility(8);
                    } else {
                        this.bGh.setVisibility(0);
                        this.bGh.aQ(true);
                    }
                } else {
                    this.bGh.setVisibility(0);
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
            int i = ((RelativeLayout.LayoutParams) this.bjU.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bGh.getLayoutParams();
            if (!z && blVar.rQ() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bGg, d.e.cp_cont_d);
            this.bGh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(int i) {
        if (this.bGg != null) {
            this.bGg.setText(String.format(this.ako.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
