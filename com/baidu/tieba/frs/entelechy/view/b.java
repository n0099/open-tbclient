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
    public TextView iTB;
    public EntelechyUserLikeButton iTC;
    private CommonUserLikeButton.a iTD;
    private View.OnClickListener iTE;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.iTD = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void qs(int i) {
                b.this.zA(i);
            }
        };
        this.iTE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.agx != null && b.this.agx.bmA() != null && !StringUtils.isNull(b.this.agx.bmA().getName_show()) && !StringUtils.isNull(b.this.agx.bmA().getUserId()) && b.this.agx.bmE() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.agx.bmA().getUserId(), b.this.agx.bmA().getName_show(), b.this.agx.bmE(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iTB = new TextView(tbPageContext.getPageActivity());
        this.iTB.setIncludeFontPadding(false);
        this.iTB.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.iTB.setLayoutParams(layoutParams);
        this.iTB.setOnClickListener(this.iTE);
        this.fXV.addView(this.iTB, 1);
        this.iTC = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.iTC.setFanNumCallBack(this.iTD);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.iTC.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.iTC);
        this.ajW = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iTC);
        this.ajW.Ba("1");
        this.ajW.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bw bwVar) {
        super.a(bwVar);
        if (bwVar != null) {
            this.agx = bwVar;
            if (bwVar.bmA() != null) {
                this.ajW.a(bwVar.bmA());
                zA(bwVar.bmA().getFansNum());
                if (!this.agx.bmD()) {
                    this.iTC.setVisibility(8);
                } else if (this.agx.bmA().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.agx.bmA().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.iTC.setVisibility(8);
                    return;
                } else if (this.agx.bmA().getGodUserData() != null && this.agx.bmA().getGodUserData().getIsLike()) {
                    if (this.agx.bmA().getGodUserData().getIsFromNetWork()) {
                        this.iTC.setVisibility(8);
                    } else {
                        this.iTC.setVisibility(0);
                        this.iTC.s(true, 1);
                    }
                } else {
                    this.iTC.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.gTO.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iTC.getLayoutParams();
            if (bwVar.bmW() != null) {
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
            ap.setViewTextColor(this.iTB, R.color.cp_cont_d);
            this.iTC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        if (this.iTB != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.agx != null && !StringUtils.isNull(this.agx.bmE()) && this.agx.bmE().equals(this.mForumName)) {
                if (this.agx.bmD()) {
                    String format = String.format(string, at.numberUniformFormat(i));
                    this.iTB.setVisibility(0);
                    this.iTB.setText(format);
                    return;
                }
                this.iTB.setVisibility(8);
                return;
            }
            this.iTB.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
