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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends a {
    private bw afJ;
    private com.baidu.tbadk.core.view.userLike.c ajc;
    public TextView ifh;
    public EntelechyUserLikeButton ifi;
    private CommonUserLikeButton.a ifj;
    private View.OnClickListener ifk;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.ifj = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void pl(int i) {
                b.this.xP(i);
            }
        };
        this.ifk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.afJ != null && b.this.afJ.beE() != null && !StringUtils.isNull(b.this.afJ.beE().getName_show()) && !StringUtils.isNull(b.this.afJ.beE().getUserId()) && b.this.afJ.beI() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.afJ.beE().getUserId(), b.this.afJ.beE().getName_show(), b.this.afJ.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ifh = new TextView(tbPageContext.getPageActivity());
        this.ifh.setIncludeFontPadding(false);
        this.ifh.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.ifh.setLayoutParams(layoutParams);
        this.ifh.setOnClickListener(this.ifk);
        this.fum.addView(this.ifh, 1);
        this.ifi = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.ifi.setFanNumCallBack(this.ifj);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.ifi.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.ifi);
        this.ajc = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ifi);
        this.ajc.zl("1");
        this.ajc.m(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        super.a(bwVar);
        if (bwVar != null) {
            this.afJ = bwVar;
            if (bwVar.beE() != null) {
                this.ajc.a(bwVar.beE());
                xP(bwVar.beE().getFansNum());
                if (!this.afJ.beH()) {
                    this.ifi.setVisibility(8);
                } else if (this.afJ.beE().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.afJ.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ifi.setVisibility(8);
                    return;
                } else if (this.afJ.beE().getGodUserData() != null && this.afJ.beE().getGodUserData().getIsLike()) {
                    if (this.afJ.beE().getGodUserData().getIsFromNetWork()) {
                        this.ifi.setVisibility(8);
                    } else {
                        this.ifi.setVisibility(0);
                        this.ifi.r(true, 1);
                    }
                } else {
                    this.ifi.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gjX.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifi.getLayoutParams();
            if (bwVar.bfa() != null) {
                layoutParams.topMargin = i + l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ifh, R.color.cp_cont_d);
            this.ifi.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void p(BdUniqueId bdUniqueId) {
        super.p(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP(int i) {
        if (this.ifh != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.afJ != null && !StringUtils.isNull(this.afJ.beI()) && this.afJ.beI().equals(this.mForumName)) {
                if (this.afJ.beH()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.ifh.setVisibility(0);
                    this.ifh.setText(format);
                    return;
                }
                this.ifh.setVisibility(8);
                return;
            }
            this.ifh.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
