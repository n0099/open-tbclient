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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends e {
    private bd ajM;
    private com.baidu.tbadk.core.view.userLike.c bZO;
    public TextView cOZ;
    public EntelechyUserLikeButton cPa;
    private CommonUserLikeButton.a cPb;
    private View.OnClickListener cPc;
    private View.OnClickListener cPd;
    private TbPageContext mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.cPb = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                c.this.km(i);
            }
        };
        this.cPc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ajM != null && c.this.ajM.rv() != null && !StringUtils.isNull(c.this.ajM.rv().getName_show()) && !StringUtils.isNull(c.this.ajM.rv().getUserId()) && c.this.ajM.rB() != null) {
                    if (c.this.abt() != null) {
                        c.this.abt().a(view, c.this.ajM);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), c.this.ajM.rv().getUserId(), c.this.ajM.rv().getName_show(), c.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.cPd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.ajM);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.aob.setGodIconMargin(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPh.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds4);
        this.cPh.setLayoutParams(layoutParams);
        this.cOZ = new TextView(tbPageContext.getPageActivity());
        this.cOZ.setId(d.g.fans_num);
        this.cOZ.setIncludeFontPadding(false);
        this.cOZ.setTextSize(0, com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds14);
        this.cOZ.setLayoutParams(layoutParams2);
        this.cOZ.setOnClickListener(this.cPc);
        this.bvP.addView(this.cOZ, 1);
        this.cPa = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.cPa.setId(d.g.card_god_feed_like_btn);
        this.cPa.setFanNumCallBack(this.cPb);
        this.bZO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cPa);
        this.bZO.setFromType("0");
        this.bZO.h(bdUniqueId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams3.addRule(11);
        layoutParams3.addRule(3, d.g.header_divider);
        layoutParams3.rightMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds36);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
        this.cPa.setGravity(21);
        this.cPa.setLayoutParams(layoutParams3);
        ((ViewGroup) getView()).addView(this.cPa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        boolean z = false;
        super.a(bdVar);
        if (bdVar != null) {
            this.ajM = bdVar;
            if (bdVar.rv() != null) {
                km(bdVar.rv().getFansNum());
                this.bZO.a(bdVar.rv());
                if (this.ajM.rv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ajM.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.cPa.setVisibility(8);
                    return;
                } else if (this.ajM.rv().getGodUserData().getIsLike()) {
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
            MetaData rv = bdVar.rv();
            ThemeCardInUserData themeCardInUserData = null;
            if (rv != null) {
                themeCardInUserData = rv.getThemeCard();
            }
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                z = true;
            }
            int i = ((RelativeLayout.LayoutParams) this.bvQ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPa.getLayoutParams();
            if (!z && bdVar.rR() != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds12) + i;
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            aj.i(this.cOZ, d.C0095d.cp_cont_d);
            this.cPa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(int i) {
        if (this.cOZ != null) {
            this.cOZ.setText(String.format(this.mPageContext.getResources().getString(d.j.fans_default_name_god_user), am.u(i)));
        }
    }
}
