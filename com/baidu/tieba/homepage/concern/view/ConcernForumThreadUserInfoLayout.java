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
    private bg XT;
    private View.OnClickListener ZI;
    private View.OnClickListener bRC;
    private TextView bTH;
    private View bTI;
    public TextView bTb;
    public TextView bTc;
    private View.OnClickListener bTf;
    public ClickableHeaderImageView bTm;
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
        this.bTf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.XT != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.XT.YT())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.XT.YT(), n.YB())));
                    if (ConcernForumThreadUserInfoLayout.this.bRC != null) {
                        ConcernForumThreadUserInfoLayout.this.bRC.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.bTm = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bTb = (TextView) inflate.findViewById(d.g.thread_info_forum_name);
        this.bTc = (TextView) inflate.findViewById(d.g.thread_user_name_and_reply_time);
        this.bTH = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bTI = inflate.findViewById(d.g.divider);
        setGravity(16);
        initHeaderImg();
        this.bTb.setOnClickListener(this.bTf);
    }

    private void initHeaderImg() {
        if (this.bTm != null) {
            this.bTm.setDefaultResource(17170445);
            this.bTm.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bTm.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.bTm.setIsRound(true);
            this.bTm.setOnClickListener(this.bTf);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        this.XT = bgVar;
        ao(bgVar);
        B(bgVar);
        y(bgVar);
        A(bgVar);
        return true;
    }

    private void ao(bg bgVar) {
        if (bgVar == null || bgVar.YO() == null || StringUtils.isNull(bgVar.YO().getPortrait())) {
            this.bTm.setVisibility(8);
        } else {
            this.bTm.setVisibility(0);
        }
    }

    public void B(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.YT())) {
            this.bTb.setVisibility(4);
            return;
        }
        this.bTb.setText(ap.g(this.XT.YT(), 16, "...") + getResources().getString(d.j.forum));
        this.bTb.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XT.YO().getName_show())) {
            this.bTc.setText(getContext().getString(d.j.user_name_and_publish_time, nt(this.XT.YO().getName_show()), ap.ao(bgVar.getCreateTime())));
            this.bTc.setVisibility(0);
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.bTH.setVisibility(8);
            this.bTI.setVisibility(8);
            return;
        }
        this.bTH.setText(this.XT.getAddress());
        this.bTH.setVisibility(0);
        this.bTI.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZI = onClickListener;
        if (this.bTm != null) {
            this.bTm.setAfterClickListener(this.ZI);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRC = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTm != null) {
            this.bTm.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bTb, d.C0277d.cp_link_tip_c);
            al.j(this.bTc, d.C0277d.cp_cont_d);
            al.j(this.bTH, d.C0277d.cp_cont_d);
            al.l(this.bTI, d.C0277d.cp_cont_e);
        }
    }

    protected String nt(String str) {
        return ap.g(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void dN(boolean z) {
        if (z) {
            B(this.XT);
        } else {
            this.bTb.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.bTm;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.bTc;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
