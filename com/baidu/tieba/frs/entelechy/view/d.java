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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends a {
    private bd aZA;
    private com.baidu.tbadk.core.view.userLike.c cVX;
    public TextView dLA;
    public EntelechyUserLikeButton dLB;
    private CommonUserLikeButton.a dLC;
    private View.OnClickListener dLD;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dLC = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                d.this.nl(i);
            }
        };
        this.dLD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZA != null && d.this.aZA.zn() != null && !StringUtils.isNull(d.this.aZA.zn().getName_show()) && !StringUtils.isNull(d.this.aZA.zn().getUserId()) && d.this.aZA.zt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.aZA.zn().getUserId(), d.this.aZA.zn().getName_show(), d.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dLA = new TextView(tbPageContext.getPageActivity());
        this.dLA.setIncludeFontPadding(false);
        this.dLA.setTextSize(0, com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds6);
        this.dLA.setLayoutParams(layoutParams);
        this.dLA.setOnClickListener(this.dLD);
        this.cmX.addView(this.dLA, 1);
        this.dLB = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dLB.setFanNumCallBack(this.dLC);
        this.dLB.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dLB.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dLB);
        this.cVX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dLB);
        this.cVX.setFromType("1");
        this.cVX.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.aZA = bdVar;
            if (bdVar.zn() != null) {
                this.cVX.a(bdVar.zn());
                nl(bdVar.zn().getFansNum());
                if (!this.aZA.zr()) {
                    this.dLB.setVisibility(8);
                } else if (this.aZA.zn().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aZA.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dLB.setVisibility(8);
                    return;
                } else if (this.aZA.zn().getGodUserData() != null && this.aZA.zn().getGodUserData().getIsLike()) {
                    if (this.aZA.zn().getGodUserData().getIsFromNetWork()) {
                        this.dLB.setVisibility(8);
                    } else {
                        this.dLB.setVisibility(0);
                        this.dLB.f(true, 1);
                    }
                } else {
                    this.dLB.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cmY.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLB.getLayoutParams();
            if (bdVar.zJ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.r(this.dLA, d.C0141d.cp_cont_d);
            this.dLB.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.dLA != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.aZA != null && !StringUtils.isNull(this.aZA.zt()) && this.aZA.zt().equals(this.mForumName)) {
                if (this.aZA.zr()) {
                    String format = String.format(string, am.C(i));
                    this.dLA.setVisibility(0);
                    this.dLA.setText(format);
                    return;
                }
                this.dLA.setVisibility(8);
                return;
            }
            this.dLA.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
