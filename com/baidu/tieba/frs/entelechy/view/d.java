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
    private bd aZM;
    private com.baidu.tbadk.core.view.userLike.c cWj;
    public TextView dLM;
    public EntelechyUserLikeButton dLN;
    private CommonUserLikeButton.a dLO;
    private View.OnClickListener dLP;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dLO = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                d.this.nl(i);
            }
        };
        this.dLP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZM != null && d.this.aZM.zn() != null && !StringUtils.isNull(d.this.aZM.zn().getName_show()) && !StringUtils.isNull(d.this.aZM.zn().getUserId()) && d.this.aZM.zt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.aZM.zn().getUserId(), d.this.aZM.zn().getName_show(), d.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dLM = new TextView(tbPageContext.getPageActivity());
        this.dLM.setIncludeFontPadding(false);
        this.dLM.setTextSize(0, com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds6);
        this.dLM.setLayoutParams(layoutParams);
        this.dLM.setOnClickListener(this.dLP);
        this.cnj.addView(this.dLM, 1);
        this.dLN = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dLN.setFanNumCallBack(this.dLO);
        this.dLN.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dLN.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dLN);
        this.cWj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dLN);
        this.cWj.setFromType("1");
        this.cWj.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.aZM = bdVar;
            if (bdVar.zn() != null) {
                this.cWj.a(bdVar.zn());
                nl(bdVar.zn().getFansNum());
                if (!this.aZM.zr()) {
                    this.dLN.setVisibility(8);
                } else if (this.aZM.zn().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aZM.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dLN.setVisibility(8);
                    return;
                } else if (this.aZM.zn().getGodUserData() != null && this.aZM.zn().getGodUserData().getIsLike()) {
                    if (this.aZM.zn().getGodUserData().getIsFromNetWork()) {
                        this.dLN.setVisibility(8);
                    } else {
                        this.dLN.setVisibility(0);
                        this.dLN.f(true, 1);
                    }
                } else {
                    this.dLN.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cnk.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLN.getLayoutParams();
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
            aj.r(this.dLM, d.C0140d.cp_cont_d);
            this.dLN.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.dLM != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.aZM != null && !StringUtils.isNull(this.aZM.zt()) && this.aZM.zt().equals(this.mForumName)) {
                if (this.aZM.zr()) {
                    String format = String.format(string, am.C(i));
                    this.dLM.setVisibility(0);
                    this.dLM.setText(format);
                    return;
                }
                this.dLM.setVisibility(8);
                return;
            }
            this.dLM.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
