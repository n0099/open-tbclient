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
/* loaded from: classes22.dex */
public class b extends a {
    private bw agw;
    private com.baidu.tbadk.core.view.userLike.c ajV;
    public TextView iBi;
    public EntelechyUserLikeButton iBj;
    private CommonUserLikeButton.a iBk;
    private View.OnClickListener iBl;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.iBk = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void pX(int i) {
                b.this.yU(i);
            }
        };
        this.iBl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agw != null && b.this.agw.bih() != null && !StringUtils.isNull(b.this.agw.bih().getName_show()) && !StringUtils.isNull(b.this.agw.bih().getUserId()) && b.this.agw.bil() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.agw.bih().getUserId(), b.this.agw.bih().getName_show(), b.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iBi = new TextView(tbPageContext.getPageActivity());
        this.iBi.setIncludeFontPadding(false);
        this.iBi.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.iBi.setLayoutParams(layoutParams);
        this.iBi.setOnClickListener(this.iBl);
        this.fJK.addView(this.iBi, 1);
        this.iBj = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.iBj.setFanNumCallBack(this.iBk);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.iBj.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.iBj);
        this.ajV = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iBj);
        this.ajV.At("1");
        this.ajV.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        super.a(bwVar);
        if (bwVar != null) {
            this.agw = bwVar;
            if (bwVar.bih() != null) {
                this.ajV.a(bwVar.bih());
                yU(bwVar.bih().getFansNum());
                if (!this.agw.bik()) {
                    this.iBj.setVisibility(8);
                } else if (this.agw.bih().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.agw.bih().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iBj.setVisibility(8);
                    return;
                } else if (this.agw.bih().getGodUserData() != null && this.agw.bih().getGodUserData().getIsLike()) {
                    if (this.agw.bih().getGodUserData().getIsFromNetWork()) {
                        this.iBj.setVisibility(8);
                    } else {
                        this.iBj.setVisibility(0);
                        this.iBj.s(true, 1);
                    }
                } else {
                    this.iBj.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gBB.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iBj.getLayoutParams();
            if (bwVar.biD() != null) {
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
            ap.setViewTextColor(this.iBi, R.color.cp_cont_d);
            this.iBj.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yU(int i) {
        if (this.iBi != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.agw != null && !StringUtils.isNull(this.agw.bil()) && this.agw.bil().equals(this.mForumName)) {
                if (this.agw.bik()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.iBi.setVisibility(0);
                    this.iBi.setText(format);
                    return;
                }
                this.iBi.setVisibility(8);
                return;
            }
            this.iBi.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
