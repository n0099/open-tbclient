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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends a {
    private cb ahi;
    private com.baidu.tbadk.core.view.userLike.c akz;
    public TextView jsY;
    public EntelechyUserLikeButton jsZ;
    private CommonUserLikeButton.a jta;
    private View.OnClickListener jtb;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.jta = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void qc(int i) {
                b.this.zt(i);
            }
        };
        this.jtb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ahi != null && b.this.ahi.bnQ() != null && !StringUtils.isNull(b.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(b.this.ahi.bnQ().getUserId()) && b.this.ahi.bnU() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.ahi.bnQ().getUserId(), b.this.ahi.bnQ().getName_show(), b.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jsY = new TextView(tbPageContext.getPageActivity());
        this.jsY.setIncludeFontPadding(false);
        this.jsY.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.jsY.setLayoutParams(layoutParams);
        this.jsY.setOnClickListener(this.jtb);
        this.goh.addView(this.jsY, 1);
        this.jsZ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.jsZ.setFanNumCallBack(this.jta);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.jsZ.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.jsZ);
        this.akz = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jsZ);
        this.akz.Ag("1");
        this.akz.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(cb cbVar) {
        super.a(cbVar);
        if (cbVar != null) {
            this.ahi = cbVar;
            if (cbVar.bnQ() != null) {
                this.akz.a(cbVar.bnQ());
                zt(cbVar.bnQ().getFansNum());
                if (!this.ahi.bnT()) {
                    this.jsZ.setVisibility(8);
                } else if (this.ahi.bnQ().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahi.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jsZ.setVisibility(8);
                    return;
                } else if (this.ahi.bnQ().getGodUserData() != null && this.ahi.bnQ().getGodUserData().getIsLike()) {
                    if (this.ahi.bnQ().getGodUserData().getIsFromNetWork()) {
                        this.jsZ.setVisibility(8);
                    } else {
                        this.jsZ.setVisibility(0);
                        this.jsZ.r(true, 1);
                    }
                } else {
                    this.jsZ.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.hor.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsZ.getLayoutParams();
            if (cbVar.bol() != null) {
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
            ap.setViewTextColor(this.jsY, R.color.CAM_X0109);
            this.jsZ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(int i) {
        if (this.jsY != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.ahi != null && !StringUtils.isNull(this.ahi.bnU()) && this.ahi.bnU().equals(this.mForumName)) {
                if (this.ahi.bnT()) {
                    String format = String.format(string, au.numberUniformFormat(i));
                    this.jsY.setVisibility(0);
                    this.jsY.setText(format);
                    return;
                }
                this.jsY.setVisibility(8);
                return;
            }
            this.jsY.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
