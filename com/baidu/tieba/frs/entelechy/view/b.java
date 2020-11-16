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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b extends a {
    private bx agB;
    private com.baidu.tbadk.core.view.userLike.c ajZ;
    public TextView iUn;
    public EntelechyUserLikeButton iUo;
    private CommonUserLikeButton.a iUp;
    private View.OnClickListener iUq;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.iUp = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void qQ(int i) {
                b.this.zY(i);
            }
        };
        this.iUq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agB != null && b.this.agB.blC() != null && !StringUtils.isNull(b.this.agB.blC().getName_show()) && !StringUtils.isNull(b.this.agB.blC().getUserId()) && b.this.agB.blG() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.agB.blC().getUserId(), b.this.agB.blC().getName_show(), b.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iUn = new TextView(tbPageContext.getPageActivity());
        this.iUn.setIncludeFontPadding(false);
        this.iUn.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.iUn.setLayoutParams(layoutParams);
        this.iUn.setOnClickListener(this.iUq);
        this.fXC.addView(this.iUn, 1);
        this.iUo = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.iUo.setFanNumCallBack(this.iUp);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.iUo.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.iUo);
        this.ajZ = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iUo);
        this.ajZ.Av("1");
        this.ajZ.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bx bxVar) {
        super.a(bxVar);
        if (bxVar != null) {
            this.agB = bxVar;
            if (bxVar.blC() != null) {
                this.ajZ.a(bxVar.blC());
                zY(bxVar.blC().getFansNum());
                if (!this.agB.blF()) {
                    this.iUo.setVisibility(8);
                } else if (this.agB.blC().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.agB.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iUo.setVisibility(8);
                    return;
                } else if (this.agB.blC().getGodUserData() != null && this.agB.blC().getGodUserData().getIsLike()) {
                    if (this.agB.blC().getGodUserData().getIsFromNetWork()) {
                        this.iUo.setVisibility(8);
                    } else {
                        this.iUo.setVisibility(0);
                        this.iUo.s(true, 1);
                    }
                } else {
                    this.iUo.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gTv.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iUo.getLayoutParams();
            if (bxVar.blY() != null) {
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
            ap.setViewTextColor(this.iUn, R.color.CAM_X0109);
            this.iUo.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(int i) {
        if (this.iUn != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.agB != null && !StringUtils.isNull(this.agB.blG()) && this.agB.blG().equals(this.mForumName)) {
                if (this.agB.blF()) {
                    String format = String.format(string, au.numberUniformFormat(i));
                    this.iUn.setVisibility(0);
                    this.iUn.setText(format);
                    return;
                }
                this.iUn.setVisibility(8);
                return;
            }
            this.iUn.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
