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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements d {
    private bg We;
    private View.OnClickListener XU;
    private View.OnClickListener caw;
    public TextView cbW;
    public TextView cbX;
    private TextView ccF;
    private View ccG;
    private View.OnClickListener cca;
    public ClickableHeaderImageView cch;
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
        this.cca = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.We != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.We.aeC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.We.aeC(), n.aek())));
                    if (ConcernForumThreadUserInfoLayout.this.caw != null) {
                        ConcernForumThreadUserInfoLayout.this.caw.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.cch = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.cbW = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.cbX = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.ccF = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.ccG = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.cbW.setOnClickListener(this.cca);
    }

    private void initHeaderImg() {
        if (this.cch != null) {
            this.cch.setDefaultResource(17170445);
            this.cch.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cch.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cch.setIsRound(true);
            this.cch.setOnClickListener(this.cca);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        this.We = bgVar;
        an(bgVar);
        B(bgVar);
        y(bgVar);
        A(bgVar);
        return true;
    }

    private void an(bg bgVar) {
        if (bgVar == null || bgVar.aex() == null || StringUtils.isNull(bgVar.aex().getPortrait())) {
            this.cch.setVisibility(8);
        } else {
            this.cch.setVisibility(0);
        }
    }

    public void B(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.aeC())) {
            this.cbW.setVisibility(4);
            return;
        }
        this.cbW.setText(aq.j(this.We.aeC(), 16, "...") + getResources().getString(R.string.forum));
        this.cbW.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.We.aex().getName_show())) {
            this.cbX.setText(getContext().getString(R.string.user_name_and_publish_time, oT(this.We.aex().getName_show()), aq.aD(bgVar.getCreateTime())));
            this.cbX.setVisibility(0);
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.ccF.setVisibility(8);
            this.ccG.setVisibility(8);
            return;
        }
        this.ccF.setText(this.We.getAddress());
        this.ccF.setVisibility(0);
        this.ccG.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
        if (this.cch != null) {
            this.cch.setAfterClickListener(this.XU);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caw = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cch != null) {
            this.cch.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.cbW, R.color.cp_link_tip_c);
            am.j(this.cbX, R.color.cp_cont_d);
            am.j(this.ccF, R.color.cp_cont_d);
            am.l(this.ccG, R.color.cp_cont_e);
        }
    }

    protected String oT(String str) {
        return aq.j(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void en(boolean z) {
        if (z) {
            B(this.We);
        } else {
            this.cbW.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cch;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.cbX;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
