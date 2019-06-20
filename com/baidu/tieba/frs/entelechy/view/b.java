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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends a {
    private bg VJ;
    private com.baidu.tbadk.core.view.userLike.c ewY;
    public TextView fyL;
    public EntelechyUserLikeButton fyM;
    private CommonUserLikeButton.a fyN;
    private View.OnClickListener fyO;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fyN = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void iZ(int i) {
                b.this.rH(i);
            }
        };
        this.fyO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.VJ != null && b.this.VJ.adv() != null && !StringUtils.isNull(b.this.VJ.adv().getName_show()) && !StringUtils.isNull(b.this.VJ.adv().getUserId()) && b.this.VJ.adA() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.VJ.adv().getUserId(), b.this.VJ.adv().getName_show(), b.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fyL = new TextView(tbPageContext.getPageActivity());
        this.fyL.setIncludeFontPadding(false);
        this.fyL.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fyL.setLayoutParams(layoutParams);
        this.fyL.setOnClickListener(this.fyO);
        this.dCe.addView(this.fyL, 1);
        this.fyM = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fyM.setFanNumCallBack(this.fyN);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fyM.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fyM);
        this.ewY = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fyM);
        this.ewY.setFromType("1");
        this.ewY.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        super.a(bgVar);
        if (bgVar != null) {
            this.VJ = bgVar;
            if (bgVar.adv() != null) {
                this.ewY.a(bgVar.adv());
                rH(bgVar.adv().getFansNum());
                if (!this.VJ.ady()) {
                    this.fyM.setVisibility(8);
                } else if (this.VJ.adv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.VJ.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fyM.setVisibility(8);
                    return;
                } else if (this.VJ.adv().getGodUserData() != null && this.VJ.adv().getGodUserData().getIsLike()) {
                    if (this.VJ.adv().getGodUserData().getIsFromNetWork()) {
                        this.fyM.setVisibility(8);
                    } else {
                        this.fyM.setVisibility(0);
                        this.fyM.f(true, 1);
                    }
                } else {
                    this.fyM.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dCf.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fyM.getLayoutParams();
            if (bgVar.adQ() != null) {
                layoutParams.topMargin = i + l.g(this.mPageContext.getPageActivity(), R.dimen.ds4);
            } else {
                layoutParams.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            al.j(this.fyL, R.color.cp_cont_d);
            this.fyM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(int i) {
        if (this.fyL != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.VJ != null && !StringUtils.isNull(this.VJ.adA()) && this.VJ.adA().equals(this.mForumName)) {
                if (this.VJ.ady()) {
                    String format = String.format(string, ap.aG(i));
                    this.fyL.setVisibility(0);
                    this.fyL.setText(format);
                    return;
                }
                this.fyL.setVisibility(8);
                return;
            }
            this.fyL.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
