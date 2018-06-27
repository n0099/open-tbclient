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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends a {
    private bc atZ;
    private com.baidu.tbadk.core.view.userLike.c cvR;
    public TextView dsm;
    public EntelechyUserLikeButton dsn;
    private CommonUserLikeButton.a dso;
    private View.OnClickListener dsp;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dso = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dG(int i) {
                b.this.kK(i);
            }
        };
        this.dsp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.atZ != null && b.this.atZ.vw() != null && !StringUtils.isNull(b.this.atZ.vw().getName_show()) && !StringUtils.isNull(b.this.atZ.vw().getUserId()) && b.this.atZ.vB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.atZ.vw().getUserId(), b.this.atZ.vw().getName_show(), b.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dsm = new TextView(tbPageContext.getPageActivity());
        this.dsm.setIncludeFontPadding(false);
        this.dsm.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.e(tbPageContext.getPageActivity(), d.e.ds6);
        this.dsm.setLayoutParams(layoutParams);
        this.dsm.setOnClickListener(this.dsp);
        this.bHY.addView(this.dsm, 1);
        this.dsn = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dsn.setFanNumCallBack(this.dso);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.e(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dsn.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dsn);
        this.cvR = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dsn);
        this.cvR.setFromType("1");
        this.cvR.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(bc bcVar) {
        super.a(bcVar);
        if (bcVar != null) {
            this.atZ = bcVar;
            if (bcVar.vw() != null) {
                this.cvR.a(bcVar.vw());
                kK(bcVar.vw().getFansNum());
                if (!this.atZ.vz()) {
                    this.dsn.setVisibility(8);
                } else if (this.atZ.vw().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.atZ.vw().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dsn.setVisibility(8);
                    return;
                } else if (this.atZ.vw().getGodUserData() != null && this.atZ.vw().getGodUserData().getIsLike()) {
                    if (this.atZ.vw().getGodUserData().getIsFromNetWork()) {
                        this.dsn.setVisibility(8);
                    } else {
                        this.dsn.setVisibility(0);
                        this.dsn.d(true, 1);
                    }
                } else {
                    this.dsn.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bHZ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dsn.getLayoutParams();
            if (bcVar.vQ() != null) {
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
            am.h(this.dsm, d.C0142d.cp_cont_d);
            this.dsn.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(int i) {
        if (this.dsm != null) {
            String string = this.mPageContext.getResources().getString(d.k.fans_default_name_god_user);
            if (this.atZ != null && !StringUtils.isNull(this.atZ.vB()) && this.atZ.vB().equals(this.mForumName)) {
                if (this.atZ.vz()) {
                    String format = String.format(string, ap.z(i));
                    this.dsm.setVisibility(0);
                    this.dsm.setText(format);
                    return;
                }
                this.dsm.setVisibility(8);
                return;
            }
            this.dsm.setText(this.mPageContext.getResources().getString(d.k.default_personalized_name));
        }
    }
}
