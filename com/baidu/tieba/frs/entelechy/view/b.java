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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends a {
    private bz ahu;
    private com.baidu.tbadk.core.view.userLike.c akK;
    public TextView jne;
    public EntelechyUserLikeButton jnf;
    private CommonUserLikeButton.a jng;
    private View.OnClickListener jnh;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.jng = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void pX(int i) {
                b.this.zj(i);
            }
        };
        this.jnh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ahu != null && b.this.ahu.bnx() != null && !StringUtils.isNull(b.this.ahu.bnx().getName_show()) && !StringUtils.isNull(b.this.ahu.bnx().getUserId()) && b.this.ahu.bnB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.ahu.bnx().getUserId(), b.this.ahu.bnx().getName_show(), b.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jne = new TextView(tbPageContext.getPageActivity());
        this.jne.setIncludeFontPadding(false);
        this.jne.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.jne.setLayoutParams(layoutParams);
        this.jne.setOnClickListener(this.jnh);
        this.gln.addView(this.jne, 1);
        this.jnf = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.jnf.setFanNumCallBack(this.jng);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.jnf.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.jnf);
        this.akK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jnf);
        this.akK.zP("1");
        this.akK.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bz bzVar) {
        super.a(bzVar);
        if (bzVar != null) {
            this.ahu = bzVar;
            if (bzVar.bnx() != null) {
                this.akK.a(bzVar.bnx());
                zj(bzVar.bnx().getFansNum());
                if (!this.ahu.bnA()) {
                    this.jnf.setVisibility(8);
                } else if (this.ahu.bnx().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahu.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jnf.setVisibility(8);
                    return;
                } else if (this.ahu.bnx().getGodUserData() != null && this.ahu.bnx().getGodUserData().getIsLike()) {
                    if (this.ahu.bnx().getGodUserData().getIsFromNetWork()) {
                        this.jnf.setVisibility(8);
                    } else {
                        this.jnf.setVisibility(0);
                        this.jnf.r(true, 1);
                    }
                } else {
                    this.jnf.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.hjQ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jnf.getLayoutParams();
            if (bzVar.bnS() != null) {
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
            ao.setViewTextColor(this.jne, R.color.CAM_X0109);
            this.jnf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        if (this.jne != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.ahu != null && !StringUtils.isNull(this.ahu.bnB()) && this.ahu.bnB().equals(this.mForumName)) {
                if (this.ahu.bnA()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.jne.setVisibility(0);
                    this.jne.setText(format);
                    return;
                }
                this.jne.setVisibility(8);
                return;
            }
            this.jne.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
