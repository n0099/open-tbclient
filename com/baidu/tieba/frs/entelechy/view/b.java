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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends a {
    private bj adG;
    private com.baidu.tbadk.core.view.userLike.c agm;
    public TextView hiV;
    public EntelechyUserLikeButton hiW;
    private CommonUserLikeButton.a hiX;
    private View.OnClickListener hiY;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.hiX = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void lM(int i) {
                b.this.tS(i);
            }
        };
        this.hiY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.adG != null && b.this.adG.aKE() != null && !StringUtils.isNull(b.this.adG.aKE().getName_show()) && !StringUtils.isNull(b.this.adG.aKE().getUserId()) && b.this.adG.aKJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.adG.aKE().getUserId(), b.this.adG.aKE().getName_show(), b.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hiV = new TextView(tbPageContext.getPageActivity());
        this.hiV.setIncludeFontPadding(false);
        this.hiV.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.hiV.setLayoutParams(layoutParams);
        this.hiV.setOnClickListener(this.hiY);
        this.eGZ.addView(this.hiV, 1);
        this.hiW = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.hiW.setFanNumCallBack(this.hiX);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.hiW.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.hiW);
        this.agm = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hiW);
        this.agm.tR("1");
        this.agm.j(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bj bjVar) {
        super.a(bjVar);
        if (bjVar != null) {
            this.adG = bjVar;
            if (bjVar.aKE() != null) {
                this.agm.a(bjVar.aKE());
                tS(bjVar.aKE().getFansNum());
                if (!this.adG.aKH()) {
                    this.hiW.setVisibility(8);
                } else if (this.adG.aKE().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.adG.aKE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hiW.setVisibility(8);
                    return;
                } else if (this.adG.aKE().getGodUserData() != null && this.adG.aKE().getGodUserData().getIsLike()) {
                    if (this.adG.aKE().getGodUserData().getIsFromNetWork()) {
                        this.hiW.setVisibility(8);
                    } else {
                        this.hiW.setVisibility(0);
                        this.hiW.n(true, 1);
                    }
                } else {
                    this.hiW.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.fto.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hiW.getLayoutParams();
            if (bjVar.aKZ() != null) {
                layoutParams.topMargin = i + l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            am.setViewTextColor(this.hiV, (int) R.color.cp_cont_d);
            this.hiW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void m(BdUniqueId bdUniqueId) {
        super.m(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(int i) {
        if (this.hiV != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.adG != null && !StringUtils.isNull(this.adG.aKJ()) && this.adG.aKJ().equals(this.mForumName)) {
                if (this.adG.aKH()) {
                    String format = String.format(string, aq.numberUniformFormat(i));
                    this.hiV.setVisibility(0);
                    this.hiV.setText(format);
                    return;
                }
                this.hiV.setVisibility(8);
                return;
            }
            this.hiV.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
