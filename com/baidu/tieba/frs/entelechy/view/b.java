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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends a {
    private bu aeK;
    private com.baidu.tbadk.core.view.userLike.c ahX;
    public TextView hKX;
    public EntelechyUserLikeButton hKY;
    private CommonUserLikeButton.a hKZ;
    private View.OnClickListener hLa;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.hKZ = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void mL(int i) {
                b.this.ve(i);
            }
        };
        this.hLa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aeK != null && b.this.aeK.aSp() != null && !StringUtils.isNull(b.this.aeK.aSp().getName_show()) && !StringUtils.isNull(b.this.aeK.aSp().getUserId()) && b.this.aeK.aSt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.aeK.aSp().getUserId(), b.this.aeK.aSp().getName_show(), b.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hKX = new TextView(tbPageContext.getPageActivity());
        this.hKX.setIncludeFontPadding(false);
        this.hKX.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.hKX.setLayoutParams(layoutParams);
        this.hKX.setOnClickListener(this.hLa);
        this.fdX.addView(this.hKX, 1);
        this.hKY = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.hKY.setFanNumCallBack(this.hKZ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.hKY.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.hKY);
        this.ahX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hKY);
        this.ahX.vQ("1");
        this.ahX.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(bu buVar) {
        super.a(buVar);
        if (buVar != null) {
            this.aeK = buVar;
            if (buVar.aSp() != null) {
                this.ahX.a(buVar.aSp());
                ve(buVar.aSp().getFansNum());
                if (!this.aeK.aSs()) {
                    this.hKY.setVisibility(8);
                } else if (this.aeK.aSp().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aeK.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hKY.setVisibility(8);
                    return;
                } else if (this.aeK.aSp().getGodUserData() != null && this.aeK.aSp().getGodUserData().getIsLike()) {
                    if (this.aeK.aSp().getGodUserData().getIsFromNetWork()) {
                        this.hKY.setVisibility(8);
                    } else {
                        this.hKY.setVisibility(0);
                        this.hKY.r(true, 1);
                    }
                } else {
                    this.hKY.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.fSF.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKY.getLayoutParams();
            if (buVar.aSL() != null) {
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
            an.setViewTextColor(this.hKX, (int) R.color.cp_cont_d);
            this.hKY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(int i) {
        if (this.hKX != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.aeK != null && !StringUtils.isNull(this.aeK.aSt()) && this.aeK.aSt().equals(this.mForumName)) {
                if (this.aeK.aSs()) {
                    String format = String.format(string, ar.numberUniformFormat(i));
                    this.hKX.setVisibility(0);
                    this.hKX.setText(format);
                    return;
                }
                this.hKX.setVisibility(8);
                return;
            }
            this.hKX.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
