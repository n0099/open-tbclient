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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b extends a {
    private bb atE;
    private com.baidu.tbadk.core.view.userLike.c cyq;
    public TextView duX;
    public EntelechyUserLikeButton duY;
    private CommonUserLikeButton.a duZ;
    private View.OnClickListener dva;
    private TbPageContext mPageContext;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mSkinType = 3;
        this.duZ = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.entelechy.view.b.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dI(int i) {
                b.this.kU(i);
            }
        };
        this.dva = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.atE != null && b.this.atE.vj() != null && !StringUtils.isNull(b.this.atE.vj().getName_show()) && !StringUtils.isNull(b.this.atE.vj().getUserId()) && b.this.atE.vp() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(b.this.mPageContext.getPageActivity(), b.this.atE.vj().getUserId(), b.this.atE.vj().getName_show(), b.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.duX = new TextView(tbPageContext.getPageActivity());
        this.duX.setIncludeFontPadding(false);
        this.duX.setTextSize(0, l.f(tbPageContext.getPageActivity(), f.e.ds24));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.f(tbPageContext.getPageActivity(), f.e.ds6);
        this.duX.setLayoutParams(layoutParams);
        this.duX.setOnClickListener(this.dva);
        this.bIN.addView(this.duX, 1);
        this.duY = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.duY.setFanNumCallBack(this.duZ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, l.f(this.mPageContext.getPageActivity(), f.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, f.g.header_divider);
        layoutParams2.rightMargin = l.f(this.mPageContext.getPageActivity(), f.e.ds32);
        layoutParams2.topMargin = l.f(this.mPageContext.getPageActivity(), f.e.ds24);
        this.duY.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.duY);
        this.cyq = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.duY);
        this.cyq.setFromType("1");
        this.cyq.h(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        super.a(bbVar);
        if (bbVar != null) {
            this.atE = bbVar;
            if (bbVar.vj() != null) {
                this.cyq.a(bbVar.vj());
                kU(bbVar.vj().getFansNum());
                if (!this.atE.vm()) {
                    this.duY.setVisibility(8);
                } else if (this.atE.vj().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.atE.vj().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.duY.setVisibility(8);
                    return;
                } else if (this.atE.vj().getGodUserData() != null && this.atE.vj().getGodUserData().getIsLike()) {
                    if (this.atE.vj().getGodUserData().getIsFromNetWork()) {
                        this.duY.setVisibility(8);
                    } else {
                        this.duY.setVisibility(0);
                        this.duY.d(true, 1);
                    }
                } else {
                    this.duY.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bIO.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.duY.getLayoutParams();
            if (bbVar.vE() != null) {
                layoutParams.topMargin = i + l.f(this.mPageContext.getPageActivity(), f.e.ds4);
            } else {
                layoutParams.topMargin = l.f(this.mPageContext.getPageActivity(), f.e.ds24);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.mSkinType != i) {
            am.h(this.duX, f.d.cp_cont_d);
            this.duY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(int i) {
        if (this.duX != null) {
            String string = this.mPageContext.getResources().getString(f.j.fans_default_name_god_user);
            if (this.atE != null && !StringUtils.isNull(this.atE.vp()) && this.atE.vp().equals(this.mForumName)) {
                if (this.atE.vm()) {
                    String format = String.format(string, ap.A(i));
                    this.duX.setVisibility(0);
                    this.duX.setText(format);
                    return;
                }
                this.duX.setVisibility(8);
                return;
            }
            this.duX.setText(this.mPageContext.getResources().getString(f.j.default_personalized_name));
        }
    }
}
