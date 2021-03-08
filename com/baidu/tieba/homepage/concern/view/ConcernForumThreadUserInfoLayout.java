package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private cb aiB;
    private View.OnClickListener alB;
    private View.OnClickListener flY;
    public ClickableHeaderImageView fmB;
    private TextView fmX;
    private View fmY;
    public TextView fmq;
    public TextView fmr;
    private View.OnClickListener fmu;
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
        this.fmu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aiB != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aiB.bnW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aiB.bnW(), m.bnE())));
                    if (ConcernForumThreadUserInfoLayout.this.flY != null) {
                        ConcernForumThreadUserInfoLayout.this.flY.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.fmB = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.fmq = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.fmr = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.fmX = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fmY = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.fmq.setOnClickListener(this.fmu);
    }

    private void initHeaderImg() {
        if (this.fmB != null) {
            this.fmB.setDefaultResource(17170445);
            this.fmB.setDefaultBgResource(R.color.CAM_X0205);
            this.fmB.setIsRound(true);
            this.fmB.setOnClickListener(this.fmu);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alB = onClickListener;
        if (this.fmB != null) {
            this.fmB.setAfterClickListener(this.alB);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.flY = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fmB != null) {
            this.fmB.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fmB;
    }

    public TextView getUserName() {
        return this.fmr;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
