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
    private bl akj;
    private TbPageContext alI;
    private com.baidu.tbadk.core.view.userLike.c bGu;
    private View.OnClickListener bHn;
    public TextView bHq;
    public EntelechyUserLikeButton bHr;
    private CommonUserLikeButton.a bHt;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bHt = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                d.this.ht(i);
            }
        };
        this.bHn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akj != null && d.this.akj.getAuthor() != null && !StringUtils.isNull(d.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(d.this.akj.getAuthor().getUserId()) && d.this.akj.rK() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.alI.getPageActivity(), d.this.akj.getAuthor().getUserId(), d.this.akj.getAuthor().getName_show(), d.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.alI = tbPageContext;
        this.bHq = new TextView(tbPageContext.getPageActivity());
        this.bHq.setIncludeFontPadding(false);
        this.bHq.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds6);
        this.bHq.setLayoutParams(layoutParams);
        this.bHq.setOnClickListener(this.bHn);
        this.bld.addView(this.bHq, 1);
        this.bHr = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bHr.setFanNumCallBack(this.bHt);
        this.bHr.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds24);
        this.bHr.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bHr);
        this.bGu = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bHr);
        this.bGu.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        super.a(blVar);
        if (blVar != null) {
            this.akj = blVar;
            if (blVar.getAuthor() != null) {
                this.bGu.a(blVar.getAuthor());
                ht(blVar.getAuthor().getFansNum());
                if (!this.akj.rI()) {
                    this.bHr.setVisibility(8);
                } else if (this.akj.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.akj.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bHr.setVisibility(8);
                    return;
                } else if (this.akj.getAuthor().getGodUserData() != null && this.akj.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.ble.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bHr.getLayoutParams();
            if (blVar.sa() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bHq, d.e.cp_cont_d);
            this.bHr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(int i) {
        if (this.bHq != null) {
            String string = this.alI.getResources().getString(d.l.fans_default_name_god_user);
            if (this.akj != null && !StringUtils.isNull(this.akj.rK()) && this.akj.rK().equals(this.mForumName)) {
                if (this.akj.rI()) {
                    String format = String.format(string, al.u(i));
                    this.bHq.setVisibility(0);
                    this.bHq.setText(format);
                    return;
                }
                this.bHq.setVisibility(8);
                return;
            }
            this.bHq.setText(this.alI.getResources().getString(d.l.default_personalized_name));
        }
    }
}
