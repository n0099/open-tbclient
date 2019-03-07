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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b extends a {
    private bg XR;
    private com.baidu.tbadk.core.view.userLike.c ehB;
    public TextView fiE;
    public EntelechyUserLikeButton fiF;
    private CommonUserLikeButton.a fiG;
    private View.OnClickListener fiH;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.fiG = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void im(int i) {
                b.this.qD(i);
            }
        };
        this.fiH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.XR != null && b.this.XR.YR() != null && !StringUtils.isNull(b.this.XR.YR().getName_show()) && !StringUtils.isNull(b.this.XR.YR().getUserId()) && b.this.XR.YW() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.XR.YR().getUserId(), b.this.XR.YR().getName_show(), b.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fiE = new TextView(tbPageContext.getPageActivity());
        this.fiE.setIncludeFontPadding(false);
        this.fiE.setTextSize(0, l.h(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), d.e.ds6);
        this.fiE.setLayoutParams(layoutParams);
        this.fiE.setOnClickListener(this.fiH);
        this.drz.addView(this.fiE, 1);
        this.fiF = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.fiF.setFanNumCallBack(this.fiG);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds24);
        this.fiF.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.fiF);
        this.ehB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fiF);
        this.ehB.setFromType("1");
        this.ehB.i(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void a(bg bgVar) {
        super.a(bgVar);
        if (bgVar != null) {
            this.XR = bgVar;
            if (bgVar.YR() != null) {
                this.ehB.a(bgVar.YR());
                qD(bgVar.YR().getFansNum());
                if (!this.XR.YU()) {
                    this.fiF.setVisibility(8);
                } else if (this.XR.YR().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.XR.YR().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fiF.setVisibility(8);
                    return;
                } else if (this.XR.YR().getGodUserData() != null && this.XR.YR().getGodUserData().getIsLike()) {
                    if (this.XR.YR().getGodUserData().getIsFromNetWork()) {
                        this.fiF.setVisibility(8);
                    } else {
                        this.fiF.setVisibility(0);
                        this.fiF.f(true, 1);
                    }
                } else {
                    this.fiF.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.drA.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiF.getLayoutParams();
            if (bgVar.Zm() != null) {
                layoutParams.topMargin = i + l.h(this.mPageContext.getPageActivity(), d.e.ds4);
            } else {
                layoutParams.topMargin = l.h(this.mPageContext.getPageActivity(), d.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            al.j(this.fiE, d.C0236d.cp_cont_d);
            this.fiF.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD(int i) {
        if (this.fiE != null) {
            String string = this.mPageContext.getResources().getString(d.j.fans_default_name_god_user);
            if (this.XR != null && !StringUtils.isNull(this.XR.YW()) && this.XR.YW().equals(this.mForumName)) {
                if (this.XR.YU()) {
                    String format = String.format(string, ap.as(i));
                    this.fiE.setVisibility(0);
                    this.fiE.setText(format);
                    return;
                }
                this.fiE.setVisibility(8);
                return;
            }
            this.fiE.setText(this.mPageContext.getResources().getString(d.j.default_personalized_name));
        }
    }
}
