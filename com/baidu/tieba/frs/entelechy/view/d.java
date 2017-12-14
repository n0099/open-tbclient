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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bd ajJ;
    private com.baidu.tbadk.core.view.userLike.c bZK;
    public TextView cOV;
    public EntelechyUserLikeButton cOW;
    private CommonUserLikeButton.a cOX;
    private View.OnClickListener cOY;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cOX = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                d.this.km(i);
            }
        };
        this.cOY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajJ != null && d.this.ajJ.rv() != null && !StringUtils.isNull(d.this.ajJ.rv().getName_show()) && !StringUtils.isNull(d.this.ajJ.rv().getUserId()) && d.this.ajJ.rB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.ajJ.rv().getUserId(), d.this.ajJ.rv().getName_show(), d.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.cOV = new TextView(tbPageContext.getPageActivity());
        this.cOV.setIncludeFontPadding(false);
        this.cOV.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds6);
        this.cOV.setLayoutParams(layoutParams);
        this.cOV.setOnClickListener(this.cOY);
        this.bvL.addView(this.cOV, 1);
        this.cOW = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.cOW.setFanNumCallBack(this.cOX);
        this.cOW.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds24);
        this.cOW.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.cOW);
        this.bZK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cOW);
        this.bZK.setFromType("1");
        this.bZK.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.ajJ = bdVar;
            if (bdVar.rv() != null) {
                this.bZK.a(bdVar.rv());
                km(bdVar.rv().getFansNum());
                if (!this.ajJ.rz()) {
                    this.cOW.setVisibility(8);
                } else if (this.ajJ.rv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajJ.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.cOW.setVisibility(8);
                    return;
                } else if (this.ajJ.rv().getGodUserData() != null && this.ajJ.rv().getGodUserData().getIsLike()) {
                    if (this.ajJ.rv().getGodUserData().getIsFromNetWork()) {
                        this.cOW.setVisibility(8);
                    } else {
                        this.cOW.setVisibility(0);
                        this.cOW.aN(true);
                    }
                } else {
                    this.cOW.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bvM.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOW.getLayoutParams();
            if (bdVar.rR() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.cOV, d.C0096d.cp_cont_d);
            this.cOW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        if (this.cOV != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.ajJ != null && !StringUtils.isNull(this.ajJ.rB()) && this.ajJ.rB().equals(this.mForumName)) {
                if (this.ajJ.rz()) {
                    String format = String.format(string, am.u(i));
                    this.cOV.setVisibility(0);
                    this.cOV.setText(format);
                    return;
                }
                this.cOV.setVisibility(8);
                return;
            }
            this.cOV.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
