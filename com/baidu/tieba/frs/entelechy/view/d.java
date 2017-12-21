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
    private bd ajM;
    private com.baidu.tbadk.core.view.userLike.c bZO;
    public TextView cOZ;
    public EntelechyUserLikeButton cPa;
    private CommonUserLikeButton.a cPb;
    private View.OnClickListener cPc;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cPb = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                d.this.km(i);
            }
        };
        this.cPc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ajM != null && d.this.ajM.rv() != null && !StringUtils.isNull(d.this.ajM.rv().getName_show()) && !StringUtils.isNull(d.this.ajM.rv().getUserId()) && d.this.ajM.rB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.ajM.rv().getUserId(), d.this.ajM.rv().getName_show(), d.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.cOZ = new TextView(tbPageContext.getPageActivity());
        this.cOZ.setIncludeFontPadding(false);
        this.cOZ.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds6);
        this.cOZ.setLayoutParams(layoutParams);
        this.cOZ.setOnClickListener(this.cPc);
        this.bvP.addView(this.cOZ, 1);
        this.cPa = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.cPa.setFanNumCallBack(this.cPb);
        this.cPa.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds24);
        this.cPa.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.cPa);
        this.bZO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cPa);
        this.bZO.setFromType("1");
        this.bZO.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.ajM = bdVar;
            if (bdVar.rv() != null) {
                this.bZO.a(bdVar.rv());
                km(bdVar.rv().getFansNum());
                if (!this.ajM.rz()) {
                    this.cPa.setVisibility(8);
                } else if (this.ajM.rv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajM.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.cPa.setVisibility(8);
                    return;
                } else if (this.ajM.rv().getGodUserData() != null && this.ajM.rv().getGodUserData().getIsLike()) {
                    if (this.ajM.rv().getGodUserData().getIsFromNetWork()) {
                        this.cPa.setVisibility(8);
                    } else {
                        this.cPa.setVisibility(0);
                        this.cPa.aN(true);
                    }
                } else {
                    this.cPa.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bvQ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPa.getLayoutParams();
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
            aj.i(this.cOZ, d.C0095d.cp_cont_d);
            this.cPa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        if (this.cOZ != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.ajM != null && !StringUtils.isNull(this.ajM.rB()) && this.ajM.rB().equals(this.mForumName)) {
                if (this.ajM.rz()) {
                    String format = String.format(string, am.u(i));
                    this.cOZ.setVisibility(0);
                    this.cOZ.setText(format);
                    return;
                }
                this.cOZ.setVisibility(8);
                return;
            }
            this.cOZ.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
