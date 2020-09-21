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
/* loaded from: classes21.dex */
public class b extends a {
    private bw agf;
    private com.baidu.tbadk.core.view.userLike.c ajD;
    public TextView imo;
    public EntelechyUserLikeButton imp;
    private CommonUserLikeButton.a imq;
    private View.OnClickListener imr;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.imq = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void pz(int i) {
                b.this.yo(i);
            }
        };
        this.imr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agf != null && b.this.agf.bfy() != null && !StringUtils.isNull(b.this.agf.bfy().getName_show()) && !StringUtils.isNull(b.this.agf.bfy().getUserId()) && b.this.agf.bfC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.agf.bfy().getUserId(), b.this.agf.bfy().getName_show(), b.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.imo = new TextView(tbPageContext.getPageActivity());
        this.imo.setIncludeFontPadding(false);
        this.imo.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.imo.setLayoutParams(layoutParams);
        this.imo.setOnClickListener(this.imr);
        this.fxB.addView(this.imo, 1);
        this.imp = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.imp.setFanNumCallBack(this.imq);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.imp.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.imp);
        this.ajD = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.imp);
        this.ajD.zH("1");
        this.ajD.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        super.a(bwVar);
        if (bwVar != null) {
            this.agf = bwVar;
            if (bwVar.bfy() != null) {
                this.ajD.a(bwVar.bfy());
                yo(bwVar.bfy().getFansNum());
                if (!this.agf.bfB()) {
                    this.imp.setVisibility(8);
                } else if (this.agf.bfy().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.agf.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.imp.setVisibility(8);
                    return;
                } else if (this.agf.bfy().getGodUserData() != null && this.agf.bfy().getGodUserData().getIsLike()) {
                    if (this.agf.bfy().getGodUserData().getIsFromNetWork()) {
                        this.imp.setVisibility(8);
                    } else {
                        this.imp.setVisibility(0);
                        this.imp.r(true, 1);
                    }
                } else {
                    this.imp.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gni.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.imp.getLayoutParams();
            if (bwVar.bfU() != null) {
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
            ap.setViewTextColor(this.imo, R.color.cp_cont_d);
            this.imp.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(int i) {
        if (this.imo != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.agf != null && !StringUtils.isNull(this.agf.bfC()) && this.agf.bfC().equals(this.mForumName)) {
                if (this.agf.bfB()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.imo.setVisibility(0);
                    this.imo.setText(format);
                    return;
                }
                this.imo.setVisibility(8);
                return;
            }
            this.imo.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
