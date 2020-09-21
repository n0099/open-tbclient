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
/* loaded from: classes21.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bw agf;
    private View.OnClickListener ajn;
    public TextView ewA;
    public TextView ewB;
    private View.OnClickListener ewE;
    public ClickableHeaderImageView ewL;
    private View.OnClickListener ewh;
    private TextView exh;
    private View exi;
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
        this.ewE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.agf != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.agf.bfC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.agf.bfC(), m.bfk())));
                    if (ConcernForumThreadUserInfoLayout.this.ewh != null) {
                        ConcernForumThreadUserInfoLayout.this.ewh.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.ewL = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ewA = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.ewB = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.exh = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.exi = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.ewA.setOnClickListener(this.ewE);
    }

    private void initHeaderImg() {
        if (this.ewL != null) {
            this.ewL.setDefaultResource(17170445);
            this.ewL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ewL.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ewL.setIsRound(true);
            this.ewL.setOnClickListener(this.ewE);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajn = onClickListener;
        if (this.ewL != null) {
            this.ewL.setAfterClickListener(this.ajn);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ewh = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ewL != null) {
            this.ewL.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.ewL;
    }

    public TextView getUserName() {
        return this.ewB;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
