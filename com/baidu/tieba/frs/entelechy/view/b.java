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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends a {
    private bd atn;
    private com.baidu.tbadk.core.view.userLike.c cxK;
    public TextView dpe;
    public EntelechyUserLikeButton dpf;
    private CommonUserLikeButton.a dpg;
    private View.OnClickListener dph;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.dpg = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dF(int i) {
                b.this.kD(i);
            }
        };
        this.dph = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.atn != null && b.this.atn.vm() != null && !StringUtils.isNull(b.this.atn.vm().getName_show()) && !StringUtils.isNull(b.this.atn.vm().getUserId()) && b.this.atn.vr() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.atn.vm().getUserId(), b.this.atn.vm().getName_show(), b.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dpe = new TextView(tbPageContext.getPageActivity());
        this.dpe.setIncludeFontPadding(false);
        this.dpe.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.e(tbPageContext.getPageActivity(), d.e.ds6);
        this.dpe.setLayoutParams(layoutParams);
        this.dpe.setOnClickListener(this.dph);
        this.bGe.addView(this.dpe, 1);
        this.dpf = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.dpf.setFanNumCallBack(this.dpg);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.e(this.mPageContext.getPageActivity(), d.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, d.g.header_divider);
        layoutParams2.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
        layoutParams2.topMargin = l.e(this.mPageContext.getPageActivity(), d.e.ds24);
        this.dpf.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.dpf);
        this.cxK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dpf);
        this.cxK.setFromType("1");
        this.cxK.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        super.a(bdVar);
        if (bdVar != null) {
            this.atn = bdVar;
            if (bdVar.vm() != null) {
                this.cxK.a(bdVar.vm());
                kD(bdVar.vm().getFansNum());
                if (!this.atn.vp()) {
                    this.dpf.setVisibility(8);
                } else if (this.atn.vm().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.atn.vm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.dpf.setVisibility(8);
                    return;
                } else if (this.atn.vm().getGodUserData() != null && this.atn.vm().getGodUserData().getIsLike()) {
                    if (this.atn.vm().getGodUserData().getIsFromNetWork()) {
                        this.dpf.setVisibility(8);
                    } else {
                        this.dpf.setVisibility(0);
                        this.dpf.d(true, 1);
                    }
                } else {
                    this.dpf.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bGf.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dpf.getLayoutParams();
            if (bdVar.vG() != null) {
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
            al.h(this.dpe, d.C0141d.cp_cont_d);
            this.dpf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kD(int i) {
        if (this.dpe != null) {
            String string = this.mPageContext.getResources().getString(d.k.fans_default_name_god_user);
            if (this.atn != null && !StringUtils.isNull(this.atn.vr()) && this.atn.vr().equals(this.mForumName)) {
                if (this.atn.vp()) {
                    String format = String.format(string, ao.y(i));
                    this.dpe.setVisibility(0);
                    this.dpe.setText(format);
                    return;
                }
                this.dpe.setVisibility(8);
                return;
            }
            this.dpe.setText(this.mPageContext.getResources().getString(d.k.default_personalized_name));
        }
    }
}
