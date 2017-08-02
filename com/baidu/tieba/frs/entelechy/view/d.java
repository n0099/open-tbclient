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
    private bl aiQ;
    private TbPageContext ako;
    private com.baidu.tbadk.core.view.userLike.c bFk;
    private View.OnClickListener bGd;
    public TextView bGg;
    public EntelechyUserLikeButton bGh;
    private CommonUserLikeButton.a bGj;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.bGj = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.d.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void du(int i) {
                d.this.hs(i);
            }
        };
        this.bGd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiQ != null && d.this.aiQ.getAuthor() != null && !StringUtils.isNull(d.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(d.this.aiQ.getAuthor().getUserId()) && d.this.aiQ.rA() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.ako.getPageActivity(), d.this.aiQ.getAuthor().getUserId(), d.this.aiQ.getAuthor().getName_show(), d.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.ako = tbPageContext;
        this.bGg = new TextView(tbPageContext.getPageActivity());
        this.bGg.setIncludeFontPadding(false);
        this.bGg.setTextSize(0, com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), d.f.ds6);
        this.bGg.setLayoutParams(layoutParams);
        this.bGg.setOnClickListener(this.bGd);
        this.bjT.addView(this.bGg, 1);
        this.bGh = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.bGh.setFanNumCallBack(this.bGj);
        this.bGh.setId(d.h.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.h.header_divider);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds32);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds24);
        this.bGh.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bGh);
        this.bFk = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bGh);
        this.bFk.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        super.a(blVar);
        if (blVar != null) {
            this.aiQ = blVar;
            if (blVar.getAuthor() != null) {
                this.bFk.a(blVar.getAuthor());
                hs(blVar.getAuthor().getFansNum());
                if (!this.aiQ.ry()) {
                    this.bGh.setVisibility(8);
                } else if (this.aiQ.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aiQ.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bGh.setVisibility(8);
                    return;
                } else if (this.aiQ.getAuthor().getGodUserData() != null && this.aiQ.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aiQ.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bGh.setVisibility(8);
                    } else {
                        this.bGh.setVisibility(0);
                        this.bGh.aQ(true);
                    }
                } else {
                    this.bGh.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bjU.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bGh.getLayoutParams();
            if (blVar.rQ() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds4);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ai.i(this.bGg, d.e.cp_cont_d);
            this.bGh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(int i) {
        if (this.bGg != null) {
            String string = this.ako.getResources().getString(d.l.fans_default_name_god_user);
            if (this.aiQ != null && !StringUtils.isNull(this.aiQ.rA()) && this.aiQ.rA().equals(this.mForumName)) {
                if (this.aiQ.ry()) {
                    String format = String.format(string, al.u(i));
                    this.bGg.setVisibility(0);
                    this.bGg.setText(format);
                    return;
                }
                this.bGg.setVisibility(8);
                return;
            }
            this.bGg.setText(this.ako.getResources().getString(d.l.default_personalized_name));
        }
    }
}
