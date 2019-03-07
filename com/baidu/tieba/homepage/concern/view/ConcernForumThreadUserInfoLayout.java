package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.d {
    private bg XR;
    private View.OnClickListener ZF;
    private View.OnClickListener bRy;
    public TextView bSX;
    public TextView bSY;
    private TextView bTD;
    private View bTE;
    private View.OnClickListener bTb;
    public ClickableHeaderImageView bTi;
    private int mSkinType;

    public ConcernForumThreadUserInfoLayout(Context context) {
        this(context, null);
    }

    public ConcernForumThreadUserInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConcernForumThreadUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bTb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.XR != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.XR.YW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.XR.YW(), n.YE())));
                    if (ConcernForumThreadUserInfoLayout.this.bRy != null) {
                        ConcernForumThreadUserInfoLayout.this.bRy.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.bTi = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bSX = (TextView) inflate.findViewById(d.g.thread_info_forum_name);
        this.bSY = (TextView) inflate.findViewById(d.g.thread_user_name_and_reply_time);
        this.bTD = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bTE = inflate.findViewById(d.g.divider);
        setGravity(16);
        initHeaderImg();
        this.bSX.setOnClickListener(this.bTb);
    }

    private void initHeaderImg() {
        if (this.bTi != null) {
            this.bTi.setDefaultResource(17170445);
            this.bTi.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bTi.setDefaultBgResource(d.C0236d.cp_bg_line_e);
            this.bTi.setIsRound(true);
            this.bTi.setOnClickListener(this.bTb);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        this.XR = bgVar;
        ap(bgVar);
        B(bgVar);
        y(bgVar);
        A(bgVar);
        return true;
    }

    private void ap(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || StringUtils.isNull(bgVar.YR().getPortrait())) {
            this.bTi.setVisibility(8);
        } else {
            this.bTi.setVisibility(0);
        }
    }

    public void B(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.YW())) {
            this.bSX.setVisibility(4);
            return;
        }
        this.bSX.setText(ap.g(this.XR.YW(), 16, "...") + getResources().getString(d.j.forum));
        this.bSX.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XR.YR().getName_show())) {
            this.bSY.setText(getContext().getString(d.j.user_name_and_publish_time, ns(this.XR.YR().getName_show()), ap.ao(bgVar.getCreateTime())));
            this.bSY.setVisibility(0);
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.bTD.setVisibility(8);
            this.bTE.setVisibility(8);
            return;
        }
        this.bTD.setText(this.XR.getAddress());
        this.bTD.setVisibility(0);
        this.bTE.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
        if (this.bTi != null) {
            this.bTi.setAfterClickListener(this.ZF);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRy = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTi != null) {
            this.bTi.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bSX, d.C0236d.cp_link_tip_c);
            al.j(this.bSY, d.C0236d.cp_cont_d);
            al.j(this.bTD, d.C0236d.cp_cont_d);
            al.l(this.bTE, d.C0236d.cp_cont_e);
        }
    }

    protected String ns(String str) {
        return ap.g(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void dN(boolean z) {
        if (z) {
            B(this.XR);
        } else {
            this.bSX.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.bTi;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.bSY;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
