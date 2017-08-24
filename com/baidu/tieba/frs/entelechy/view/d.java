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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bl akl;
    private View.OnClickListener bHX;
    private com.baidu.tbadk.core.view.userLike.c bHe;
    public TextView bIa;
    public EntelechyUserLikeButton bIb;
    private CommonUserLikeButton.a bId;
    private int mSkinType;
    private TbPageContext oW;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bId = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                d.this.hu(i);
            }
        };
        this.bHX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akl != null && d.this.akl.getAuthor() != null && !StringUtils.isNull(d.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(d.this.akl.getAuthor().getUserId()) && d.this.akl.rL() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.oW.getPageActivity(), d.this.akl.getAuthor().getUserId(), d.this.akl.getAuthor().getName_show(), d.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.oW = tbPageContext;
        this.bIa = new TextView(tbPageContext.getPageActivity());
        this.bIa.setIncludeFontPadding(false);
        this.bIa.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds6);
        this.bIa.setLayoutParams(layoutParams);
        this.bIa.setOnClickListener(this.bHX);
        this.bli.addView(this.bIa, 1);
        this.bIb = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bIb.setFanNumCallBack(this.bId);
        this.bIb.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds24);
        this.bIb.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bIb);
        this.bHe = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bIb);
        this.bHe.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        super.a(blVar);
        if (blVar != null) {
            this.akl = blVar;
            if (blVar.getAuthor() != null) {
                this.bHe.a(blVar.getAuthor());
                hu(blVar.getAuthor().getFansNum());
                if (!this.akl.rJ()) {
                    this.bIb.setVisibility(8);
                } else if (this.akl.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.akl.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bIb.setVisibility(8);
                    return;
                } else if (this.akl.getAuthor().getGodUserData() != null && this.akl.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.blj.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bIb.getLayoutParams();
            if (blVar.sb() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bIa, d.e.cp_cont_d);
            this.bIb.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        if (this.bIa != null) {
            String string = this.oW.getResources().getString(d.l.fans_default_name_god_user);
            if (this.akl != null && !StringUtils.isNull(this.akl.rL()) && this.akl.rL().equals(this.mForumName)) {
                if (this.akl.rJ()) {
                    String format = String.format(string, al.u(i));
                    this.bIa.setVisibility(0);
                    this.bIa.setText(format);
                    return;
                }
                this.bIa.setVisibility(8);
                return;
            }
            this.bIa.setText(this.oW.getResources().getString(d.l.default_personalized_name));
        }
    }
}
