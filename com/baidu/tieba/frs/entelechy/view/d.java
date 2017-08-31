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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends a {
    private bj ajF;
    private com.baidu.tbadk.core.view.userLike.c bJX;
    private View.OnClickListener bKR;
    public TextView bKU;
    public EntelechyUserLikeButton bKV;
    private CommonUserLikeButton.a bKX;
    private TbPageContext mF;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bKX = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dx(int i) {
                d.this.hF(i);
            }
        };
        this.bKR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajF != null && d.this.ajF.getAuthor() != null && !StringUtils.isNull(d.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(d.this.ajF.getAuthor().getUserId()) && d.this.ajF.rG() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mF.getPageActivity(), d.this.ajF.getAuthor().getUserId(), d.this.ajF.getAuthor().getName_show(), d.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mF = tbPageContext;
        this.bKU = new TextView(tbPageContext.getPageActivity());
        this.bKU.setIncludeFontPadding(false);
        this.bKU.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds6);
        this.bKU.setLayoutParams(layoutParams);
        this.bKU.setOnClickListener(this.bKR);
        this.blD.addView(this.bKU, 1);
        this.bKV = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bKV.setFanNumCallBack(this.bKX);
        this.bKV.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds24);
        this.bKV.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bKV);
        this.bJX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bKV);
        this.bJX.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.ajF = bjVar;
            if (bjVar.getAuthor() != null) {
                this.bJX.a(bjVar.getAuthor());
                hF(bjVar.getAuthor().getFansNum());
                if (!this.ajF.rE()) {
                    this.bKV.setVisibility(8);
                } else if (this.ajF.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajF.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bKV.setVisibility(8);
                    return;
                } else if (this.ajF.getAuthor().getGodUserData() != null && this.ajF.getAuthor().getGodUserData().getIsLike()) {
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
            int i = ((RelativeLayout.LayoutParams) this.blE.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bKV.getLayoutParams();
            if (bjVar.rW() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.bKU, d.e.cp_cont_d);
            this.bKV.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF(int i) {
        if (this.bKU != null) {
            String string = this.mF.getResources().getString(d.l.fans_default_name_god_user);
            if (this.ajF != null && !StringUtils.isNull(this.ajF.rG()) && this.ajF.rG().equals(this.mForumName)) {
                if (this.ajF.rE()) {
                    String format = String.format(string, am.u(i));
                    this.bKU.setVisibility(0);
                    this.bKU.setText(format);
                    return;
                }
                this.bKU.setVisibility(8);
                return;
            }
            this.bKU.setText(this.mF.getResources().getString(d.l.default_personalized_name));
        }
    }
}
