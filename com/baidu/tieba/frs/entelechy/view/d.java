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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bh ajg;
    private com.baidu.tbadk.core.view.userLike.c bKb;
    private View.OnClickListener bLe;
    public TextView bLh;
    public EntelechyUserLikeButton bLi;
    private CommonUserLikeButton.a bLk;
    private TbPageContext mG;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bLk = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                d.this.hP(i);
            }
        };
        this.bLe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajg != null && d.this.ajg.getAuthor() != null && !StringUtils.isNull(d.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(d.this.ajg.getAuthor().getUserId()) && d.this.ajg.rA() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mG.getPageActivity(), d.this.ajg.getAuthor().getUserId(), d.this.ajg.getAuthor().getName_show(), d.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mG = tbPageContext;
        this.bLh = new TextView(tbPageContext.getPageActivity());
        this.bLh.setIncludeFontPadding(false);
        this.bLh.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.f.ds6);
        this.bLh.setLayoutParams(layoutParams);
        this.bLh.setOnClickListener(this.bLe);
        this.bnn.addView(this.bLh, 1);
        this.bLi = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bLi.setFanNumCallBack(this.bLk);
        this.bLi.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds24);
        this.bLi.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bLi);
        this.bKb = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bLi);
        this.bKb.setFromType("1");
        this.bKb.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        super.a(bhVar);
        if (bhVar != null) {
            this.ajg = bhVar;
            if (bhVar.getAuthor() != null) {
                this.bKb.a(bhVar.getAuthor());
                hP(bhVar.getAuthor().getFansNum());
                if (!this.ajg.ry()) {
                    this.bLi.setVisibility(8);
                } else if (this.ajg.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajg.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bLi.setVisibility(8);
                    return;
                } else if (this.ajg.getAuthor().getGodUserData() != null && this.ajg.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.bno.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLi.getLayoutParams();
            if (bhVar.rQ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bLh, d.e.cp_cont_d);
            this.bLi.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(int i) {
        if (this.bLh != null) {
            String string = this.mG.getResources().getString(d.l.fans_default_name_god_user);
            if (this.ajg != null && !StringUtils.isNull(this.ajg.rA()) && this.ajg.rA().equals(this.mForumName)) {
                if (this.ajg.ry()) {
                    String format = String.format(string, am.t(i));
                    this.bLh.setVisibility(0);
                    this.bLh.setText(format);
                    return;
                }
                this.bLh.setVisibility(8);
                return;
            }
            this.bLh.setText(this.mG.getResources().getString(d.l.default_personalized_name));
        }
    }
}
