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
    private bw agx;
    private com.baidu.tbadk.core.view.userLike.c ajW;
    public TextView iNE;
    public EntelechyUserLikeButton iNF;
    private CommonUserLikeButton.a iNG;
    private View.OnClickListener iNH;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.iNG = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void qi(int i) {
                b.this.zn(i);
            }
        };
        this.iNH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agx != null && b.this.agx.bka() != null && !StringUtils.isNull(b.this.agx.bka().getName_show()) && !StringUtils.isNull(b.this.agx.bka().getUserId()) && b.this.agx.bke() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.agx.bka().getUserId(), b.this.agx.bka().getName_show(), b.this.agx.bke(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iNE = new TextView(tbPageContext.getPageActivity());
        this.iNE.setIncludeFontPadding(false);
        this.iNE.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.iNE.setLayoutParams(layoutParams);
        this.iNE.setOnClickListener(this.iNH);
        this.fSf.addView(this.iNE, 1);
        this.iNF = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.iNF.setFanNumCallBack(this.iNG);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.iNF.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.iNF);
        this.ajW = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iNF);
        this.ajW.AM("1");
        this.ajW.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        super.a(bwVar);
        if (bwVar != null) {
            this.agx = bwVar;
            if (bwVar.bka() != null) {
                this.ajW.a(bwVar.bka());
                zn(bwVar.bka().getFansNum());
                if (!this.agx.bkd()) {
                    this.iNF.setVisibility(8);
                } else if (this.agx.bka().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.agx.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iNF.setVisibility(8);
                    return;
                } else if (this.agx.bka().getGodUserData() != null && this.agx.bka().getGodUserData().getIsLike()) {
                    if (this.agx.bka().getGodUserData().getIsFromNetWork()) {
                        this.iNF.setVisibility(8);
                    } else {
                        this.iNF.setVisibility(0);
                        this.iNF.s(true, 1);
                    }
                } else {
                    this.iNF.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gNp.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iNF.getLayoutParams();
            if (bwVar.bkw() != null) {
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
            ap.setViewTextColor(this.iNE, R.color.cp_cont_d);
            this.iNF.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        if (this.iNE != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.agx != null && !StringUtils.isNull(this.agx.bke()) && this.agx.bke().equals(this.mForumName)) {
                if (this.agx.bkd()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.iNE.setVisibility(0);
                    this.iNE.setText(format);
                    return;
                }
                this.iNE.setVisibility(8);
                return;
            }
            this.iNE.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
