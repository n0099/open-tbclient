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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes16.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bw afL;
    private View.OnClickListener aiT;
    private View.OnClickListener euA;
    public ClickableHeaderImageView euH;
    private View.OnClickListener eud;
    public TextView euw;
    public TextView eux;
    private TextView evd;
    private View eve;
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
        this.euA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.afL != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.afL.beI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.afL.beI(), m.beq())));
                    if (ConcernForumThreadUserInfoLayout.this.eud != null) {
                        ConcernForumThreadUserInfoLayout.this.eud.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.euH = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.euw = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eux = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.evd = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eve = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.euw.setOnClickListener(this.euA);
    }

    private void initHeaderImg() {
        if (this.euH != null) {
            this.euH.setDefaultResource(17170445);
            this.euH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.euH.setDefaultBgResource(R.color.cp_bg_line_e);
            this.euH.setIsRound(true);
            this.euH.setOnClickListener(this.euA);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiT = onClickListener;
        if (this.euH != null) {
            this.euH.setAfterClickListener(this.aiT);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eud = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euH != null) {
            this.euH.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.euH;
    }

    public TextView getUserName() {
        return this.eux;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
