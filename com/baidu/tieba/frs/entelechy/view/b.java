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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends a {
    private bd alf;
    private com.baidu.tbadk.core.view.userLike.c cpg;
    public TextView dfP;
    public EntelechyUserLikeButton dfQ;
    private CommonUserLikeButton.a dfR;
    private View.OnClickListener dfS;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dfR = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dD(int i) {
                b.this.ky(i);
            }
        };
        this.dfS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.alf != null && b.this.alf.rP() != null && !StringUtils.isNull(b.this.alf.rP().getName_show()) && !StringUtils.isNull(b.this.alf.rP().getUserId()) && b.this.alf.rU() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.alf.rP().getUserId(), b.this.alf.rP().getName_show(), b.this.alf.rU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dfP = new TextView(tbPageContext.getPageActivity());
        this.dfP.setIncludeFontPadding(false);
        this.dfP.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.e(tbPageContext.getPageActivity(), d.e.ds6);
        this.dfP.setLayoutParams(layoutParams);
        this.dfP.setOnClickListener(this.dfS);
        this.byb.addView(this.dfP, 1);
        this.dfQ = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dfQ.setFanNumCallBack(this.dfR);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.e(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dfQ.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dfQ);
        this.cpg = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dfQ);
        this.cpg.setFromType("1");
        this.cpg.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.alf = bdVar;
            if (bdVar.rP() != null) {
                this.cpg.a(bdVar.rP());
                ky(bdVar.rP().getFansNum());
                if (!this.alf.rS()) {
                    this.dfQ.setVisibility(8);
                } else if (this.alf.rP().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.alf.rP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dfQ.setVisibility(8);
                    return;
                } else if (this.alf.rP().getGodUserData() != null && this.alf.rP().getGodUserData().getIsLike()) {
                    if (this.alf.rP().getGodUserData().getIsFromNetWork()) {
                        this.dfQ.setVisibility(8);
                    } else {
                        this.dfQ.setVisibility(0);
                        this.dfQ.d(true, 1);
                    }
                } else {
                    this.dfQ.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.byc.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dfQ.getLayoutParams();
            if (bdVar.sj() != null) {
                layoutParams.topMargin = i + l.e(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            ak.h(this.dfP, d.C0126d.cp_cont_d);
            this.dfQ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(int i) {
        if (this.dfP != null) {
            String string = this.mPageContext.getResources().getString(d.k.fans_default_name_god_user);
            if (this.alf != null && !StringUtils.isNull(this.alf.rU()) && this.alf.rU().equals(this.mForumName)) {
                if (this.alf.rS()) {
                    String format = String.format(string, an.v(i));
                    this.dfP.setVisibility(0);
                    this.dfP.setText(format);
                    return;
                }
                this.dfP.setVisibility(8);
                return;
            }
            this.dfP.setText(this.mPageContext.getResources().getString(d.k.default_personalized_name));
        }
    }
}
