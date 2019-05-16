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
    private bg VK;
    private com.baidu.tbadk.core.view.userLike.c ewX;
    public TextView fyK;
    public EntelechyUserLikeButton fyL;
    private CommonUserLikeButton.a fyM;
    private View.OnClickListener fyN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fyM = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void iZ(int i) {
                b.this.rH(i);
            }
        };
        this.fyN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.VK != null && b.this.VK.adv() != null && !StringUtils.isNull(b.this.VK.adv().getName_show()) && !StringUtils.isNull(b.this.VK.adv().getUserId()) && b.this.VK.adA() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.VK.adv().getUserId(), b.this.VK.adv().getName_show(), b.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fyK = new TextView(tbPageContext.getPageActivity());
        this.fyK.setIncludeFontPadding(false);
        this.fyK.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(tbPageContext.getPageActivity(), R.dimen.ds6);
        this.fyK.setLayoutParams(layoutParams);
        this.fyK.setOnClickListener(this.fyN);
        this.dCd.addView(this.fyK, 1);
        this.fyL = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fyL.setFanNumCallBack(this.fyM);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.g(this.mPageContext.getPageActivity(), R.dimen.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
        layoutParams2.topMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.ds24);
        this.fyL.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fyL);
        this.ewX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fyL);
        this.ewX.setFromType("1");
        this.ewX.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        super.a(bgVar);
        if (bgVar != null) {
            this.VK = bgVar;
            if (bgVar.adv() != null) {
                this.ewX.a(bgVar.adv());
                rH(bgVar.adv().getFansNum());
                if (!this.VK.ady()) {
                    this.fyL.setVisibility(8);
                } else if (this.VK.adv().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.VK.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fyL.setVisibility(8);
                    return;
                } else if (this.VK.adv().getGodUserData() != null && this.VK.adv().getGodUserData().getIsLike()) {
                    if (this.VK.adv().getGodUserData().getIsFromNetWork()) {
                        this.fyL.setVisibility(8);
                    } else {
                        this.fyL.setVisibility(0);
                        this.fyL.f(true, 1);
                    }
                } else {
                    this.fyL.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.dCe.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fyL.getLayoutParams();
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
            al.j(this.fyK, R.color.cp_cont_d);
            this.fyL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(int i) {
        if (this.fyK != null) {
            String string = this.mPageContext.getResources().getString(R.string.fans_default_name_god_user);
            if (this.VK != null && !StringUtils.isNull(this.VK.adA()) && this.VK.adA().equals(this.mForumName)) {
                if (this.VK.ady()) {
                    String format = String.format(string, ap.aG(i));
                    this.fyK.setVisibility(0);
                    this.fyK.setText(format);
                    return;
                }
                this.fyK.setVisibility(8);
                return;
            }
            this.fyK.setText(this.mPageContext.getResources().getString(R.string.default_personalized_name));
        }
    }
}
