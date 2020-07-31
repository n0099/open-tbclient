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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes16.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bv aeA;
    private View.OnClickListener ahD;
    private View.OnClickListener ekB;
    public ClickableHeaderImageView ekI;
    private View.OnClickListener eke;
    public TextView ekx;
    public TextView eky;
    private TextView ele;
    private View elf;
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
        this.ekB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aeA != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aeA.aWp())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aeA.aWp(), m.aVX())));
                    if (ConcernForumThreadUserInfoLayout.this.eke != null) {
                        ConcernForumThreadUserInfoLayout.this.eke.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.ekI = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ekx = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eky = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.ele = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.elf = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.ekx.setOnClickListener(this.ekB);
    }

    private void initHeaderImg() {
        if (this.ekI != null) {
            this.ekI.setDefaultResource(17170445);
            this.ekI.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ekI.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ekI.setIsRound(true);
            this.ekI.setOnClickListener(this.ekB);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
        if (this.ekI != null) {
            this.ekI.setAfterClickListener(this.ahD);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eke = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ekI != null) {
            this.ekI.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.ekI;
    }

    public TextView getUserName() {
        return this.eky;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
