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
    private bd aZC;
    private com.baidu.tbadk.core.view.userLike.c cWa;
    public TextView dLF;
    public EntelechyUserLikeButton dLG;
    private CommonUserLikeButton.a dLH;
    private View.OnClickListener dLI;
    private TbPageContext mPageContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dLH = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void gE(int i) {
                d.this.nl(i);
            }
        };
        this.dLI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZC != null && d.this.aZC.zn() != null && !StringUtils.isNull(d.this.aZC.zn().getName_show()) && !StringUtils.isNull(d.this.aZC.zn().getUserId()) && d.this.aZC.zt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(d.this.mPageContext.getPageActivity(), d.this.aZC.zn().getUserId(), d.this.aZC.zn().getName_show(), d.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dLF = new TextView(tbPageContext.getPageActivity());
        this.dLF.setIncludeFontPadding(false);
        this.dLF.setTextSize(0, com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds6);
        this.dLF.setLayoutParams(layoutParams);
        this.dLF.setOnClickListener(this.dLI);
        this.cna.addView(this.dLF, 1);
        this.dLG = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dLG.setFanNumCallBack(this.dLH);
        this.dLG.setId(d.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dLG.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dLG);
        this.cWa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dLG);
        this.cWa.setFromType("1");
        this.cWa.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.aZC = bdVar;
            if (bdVar.zn() != null) {
                this.cWa.a(bdVar.zn());
                nl(bdVar.zn().getFansNum());
                if (!this.aZC.zr()) {
                    this.dLG.setVisibility(8);
                } else if (this.aZC.zn().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aZC.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dLG.setVisibility(8);
                    return;
                } else if (this.aZC.zn().getGodUserData() != null && this.aZC.zn().getGodUserData().getIsLike()) {
                    if (this.aZC.zn().getGodUserData().getIsFromNetWork()) {
                        this.dLG.setVisibility(8);
                    } else {
                        this.dLG.setVisibility(0);
                        this.dLG.f(true, 1);
                    }
                } else {
                    this.dLG.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.cnb.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLG.getLayoutParams();
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
            aj.r(this.dLF, d.C0141d.cp_cont_d);
            this.dLG.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl(int i) {
        if (this.dLF != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.aZC != null && !StringUtils.isNull(this.aZC.zt()) && this.aZC.zt().equals(this.mForumName)) {
                if (this.aZC.zr()) {
                    String format = String.format(string, am.C(i));
                    this.dLF.setVisibility(0);
                    this.dLF.setText(format);
                    return;
                }
                this.dLF.setVisibility(8);
                return;
            }
            this.dLF.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
