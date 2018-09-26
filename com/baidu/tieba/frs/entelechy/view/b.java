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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class b extends a {
    private bb awf;
    private com.baidu.tbadk.core.view.userLike.c cEg;
    public TextView dBG;
    public EntelechyUserLikeButton dBH;
    private CommonUserLikeButton.a dBI;
    private View.OnClickListener dBJ;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dBI = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dT(int i) {
                b.this.lx(i);
            }
        };
        this.dBJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.awf != null && b.this.awf.wm() != null && !StringUtils.isNull(b.this.awf.wm().getName_show()) && !StringUtils.isNull(b.this.awf.wm().getUserId()) && b.this.awf.ws() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.awf.wm().getUserId(), b.this.awf.wm().getName_show(), b.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dBG = new TextView(tbPageContext.getPageActivity());
        this.dBG.setIncludeFontPadding(false);
        this.dBG.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0141e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.h(tbPageContext.getPageActivity(), e.C0141e.ds6);
        this.dBG.setLayoutParams(layoutParams);
        this.dBG.setOnClickListener(this.dBJ);
        this.bOC.addView(this.dBG, 1);
        this.dBH = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dBH.setFanNumCallBack(this.dBI);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.h(this.mPageContext.getPageActivity(), e.C0141e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, e.g.header_divider);
        layoutParams2.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds32);
        layoutParams2.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds24);
        this.dBH.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dBH);
        this.cEg = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dBH);
        this.cEg.setFromType("1");
        this.cEg.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.awf = bbVar;
            if (bbVar.wm() != null) {
                this.cEg.a(bbVar.wm());
                lx(bbVar.wm().getFansNum());
                if (!this.awf.wp()) {
                    this.dBH.setVisibility(8);
                } else if (this.awf.wm().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.awf.wm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dBH.setVisibility(8);
                    return;
                } else if (this.awf.wm().getGodUserData() != null && this.awf.wm().getGodUserData().getIsLike()) {
                    if (this.awf.wm().getGodUserData().getIsFromNetWork()) {
                        this.dBH.setVisibility(8);
                    } else {
                        this.dBH.setVisibility(0);
                        this.dBH.d(true, 1);
                    }
                } else {
                    this.dBH.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bOD.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dBH.getLayoutParams();
            if (bbVar.wI() != null) {
                layoutParams.topMargin = i + l.h(this.mPageContext.getPageActivity(), e.C0141e.ds4);
            } else {
                layoutParams.topMargin = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            al.h(this.dBG, e.d.cp_cont_d);
            this.dBH.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx(int i) {
        if (this.dBG != null) {
            String string = this.mPageContext.getResources().getString(e.j.fans_default_name_god_user);
            if (this.awf != null && !StringUtils.isNull(this.awf.ws()) && this.awf.ws().equals(this.mForumName)) {
                if (this.awf.wp()) {
                    String format = String.format(string, ao.E(i));
                    this.dBG.setVisibility(0);
                    this.dBG.setText(format);
                    return;
                }
                this.dBG.setVisibility(8);
                return;
            }
            this.dBG.setText(this.mPageContext.getResources().getString(e.j.default_personalized_name));
        }
    }
}
