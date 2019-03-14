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
    private bg XS;
    private View.OnClickListener ZG;
    private View.OnClickListener bRz;
    public TextView bSY;
    public TextView bSZ;
    private TextView bTE;
    private View bTF;
    private View.OnClickListener bTc;
    public ClickableHeaderImageView bTj;
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
        this.bTc = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.XS != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.XS.YW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.XS.YW(), n.YE())));
                    if (ConcernForumThreadUserInfoLayout.this.bRz != null) {
                        ConcernForumThreadUserInfoLayout.this.bRz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.bTj = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bSY = (TextView) inflate.findViewById(d.g.thread_info_forum_name);
        this.bSZ = (TextView) inflate.findViewById(d.g.thread_user_name_and_reply_time);
        this.bTE = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bTF = inflate.findViewById(d.g.divider);
        setGravity(16);
        initHeaderImg();
        this.bSY.setOnClickListener(this.bTc);
    }

    private void initHeaderImg() {
        if (this.bTj != null) {
            this.bTj.setDefaultResource(17170445);
            this.bTj.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bTj.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.bTj.setIsRound(true);
            this.bTj.setOnClickListener(this.bTc);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        this.XS = bgVar;
        ap(bgVar);
        B(bgVar);
        y(bgVar);
        A(bgVar);
        return true;
    }

    private void ap(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || StringUtils.isNull(bgVar.YR().getPortrait())) {
            this.bTj.setVisibility(8);
        } else {
            this.bTj.setVisibility(0);
        }
    }

    public void B(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.YW())) {
            this.bSY.setVisibility(4);
            return;
        }
        this.bSY.setText(ap.g(this.XS.YW(), 16, "...") + getResources().getString(d.j.forum));
        this.bSY.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XS.YR().getName_show())) {
            this.bSZ.setText(getContext().getString(d.j.user_name_and_publish_time, ns(this.XS.YR().getName_show()), ap.ao(bgVar.getCreateTime())));
            this.bSZ.setVisibility(0);
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.bTE.setVisibility(8);
            this.bTF.setVisibility(8);
            return;
        }
        this.bTE.setText(this.XS.getAddress());
        this.bTE.setVisibility(0);
        this.bTF.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZG = onClickListener;
        if (this.bTj != null) {
            this.bTj.setAfterClickListener(this.ZG);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRz = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTj != null) {
            this.bTj.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bSY, d.C0277d.cp_link_tip_c);
            al.j(this.bSZ, d.C0277d.cp_cont_d);
            al.j(this.bTE, d.C0277d.cp_cont_d);
            al.l(this.bTF, d.C0277d.cp_cont_e);
        }
    }

    protected String ns(String str) {
        return ap.g(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void dN(boolean z) {
        if (z) {
            B(this.XS);
        } else {
            this.bSY.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.bTj;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.bSZ;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
