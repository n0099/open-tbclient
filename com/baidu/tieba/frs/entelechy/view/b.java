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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends a {
    private bv aeA;
    private com.baidu.tbadk.core.view.userLike.c ahO;
    public TextView hQW;
    public EntelechyUserLikeButton hQX;
    private CommonUserLikeButton.a hQY;
    private View.OnClickListener hQZ;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.hQY = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void nd(int i) {
                b.this.vw(i);
            }
        };
        this.hQZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aeA != null && b.this.aeA.aWl() != null && !StringUtils.isNull(b.this.aeA.aWl().getName_show()) && !StringUtils.isNull(b.this.aeA.aWl().getUserId()) && b.this.aeA.aWp() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aeA.aWl().getUserId(), b.this.aeA.aWl().getName_show(), b.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hQW = new TextView(tbPageContext.getPageActivity());
        this.hQW.setIncludeFontPadding(false);
        this.hQW.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.hQW.setLayoutParams(layoutParams);
        this.hQW.setOnClickListener(this.hQZ);
        this.fiQ.addView(this.hQW, 1);
        this.hQX = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.hQX.setFanNumCallBack(this.hQY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.hQX.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.hQX);
        this.ahO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hQX);
        this.ahO.wX("1");
        this.ahO.m(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bv bvVar) {
        super.a(bvVar);
        if (bvVar != null) {
            this.aeA = bvVar;
            if (bvVar.aWl() != null) {
                this.ahO.a(bvVar.aWl());
                vw(bvVar.aWl().getFansNum());
                if (!this.aeA.aWo()) {
                    this.hQX.setVisibility(8);
                } else if (this.aeA.aWl().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aeA.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hQX.setVisibility(8);
                    return;
                } else if (this.aeA.aWl().getGodUserData() != null && this.aeA.aWl().getGodUserData().getIsLike()) {
                    if (this.aeA.aWl().getGodUserData().getIsFromNetWork()) {
                        this.hQX.setVisibility(8);
                    } else {
                        this.hQX.setVisibility(0);
                        this.hQX.r(true, 1);
                    }
                } else {
                    this.hQX.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.fXY.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hQX.getLayoutParams();
            if (bvVar.aWH() != null) {
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
            ao.setViewTextColor(this.hQW, R.color.cp_cont_d);
            this.hQX.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void p(BdUniqueId bdUniqueId) {
        super.p(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vw(int i) {
        if (this.hQW != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.aeA != null && !StringUtils.isNull(this.aeA.aWp()) && this.aeA.aWp().equals(this.mForumName)) {
                if (this.aeA.aWo()) {
                    String format = String.format(string, as.numberUniformFormat(i));
                    this.hQW.setVisibility(0);
                    this.hQW.setText(format);
                    return;
                }
                this.hQW.setVisibility(8);
                return;
            }
            this.hQW.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
