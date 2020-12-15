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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends a {
    private by ahA;
    private com.baidu.tbadk.core.view.userLike.c akZ;
    public TextView jfl;
    public EntelechyUserLikeButton jfm;
    private CommonUserLikeButton.a jfn;
    private View.OnClickListener jfo;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.jfn = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void rr(int i) {
                b.this.AD(i);
            }
        };
        this.jfo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ahA != null && b.this.ahA.boP() != null && !StringUtils.isNull(b.this.ahA.boP().getName_show()) && !StringUtils.isNull(b.this.ahA.boP().getUserId()) && b.this.ahA.boT() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.ahA.boP().getUserId(), b.this.ahA.boP().getName_show(), b.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jfl = new TextView(tbPageContext.getPageActivity());
        this.jfl.setIncludeFontPadding(false);
        this.jfl.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.jfl.setLayoutParams(layoutParams);
        this.jfl.setOnClickListener(this.jfo);
        this.gfP.addView(this.jfl, 1);
        this.jfm = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.jfm.setFanNumCallBack(this.jfn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.jfm.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.jfm);
        this.akZ = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jfm);
        this.akZ.Bc("1");
        this.akZ.l(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.b
    public void a(by byVar) {
        super.a(byVar);
        if (byVar != null) {
            this.ahA = byVar;
            if (byVar.boP() != null) {
                this.akZ.a(byVar.boP());
                AD(byVar.boP().getFansNum());
                if (!this.ahA.boS()) {
                    this.jfm.setVisibility(8);
                } else if (this.ahA.boP().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.ahA.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.jfm.setVisibility(8);
                    return;
                } else if (this.ahA.boP().getGodUserData() != null && this.ahA.boP().getGodUserData().getIsLike()) {
                    if (this.ahA.boP().getGodUserData().getIsFromNetWork()) {
                        this.jfm.setVisibility(8);
                    } else {
                        this.jfm.setVisibility(0);
                        this.jfm.s(true, 1);
                    }
                } else {
                    this.jfm.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.hcK.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jfm.getLayoutParams();
            if (byVar.bpl() != null) {
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
            ap.setViewTextColor(this.jfl, R.color.CAM_X0109);
            this.jfm.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void o(BdUniqueId bdUniqueId) {
        super.o(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD(int i) {
        if (this.jfl != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.ahA != null && !StringUtils.isNull(this.ahA.boT()) && this.ahA.boT().equals(this.mForumName)) {
                if (this.ahA.boS()) {
                    String format = String.format(string, au.numberUniformFormat(i));
                    this.jfl.setVisibility(0);
                    this.jfl.setText(format);
                    return;
                }
                this.jfl.setVisibility(8);
                return;
            }
            this.jfl.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
