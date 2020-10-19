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
/* loaded from: classes22.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bw agw;
    private View.OnClickListener ajF;
    public TextView eIK;
    public TextView eIL;
    private View.OnClickListener eIO;
    public ClickableHeaderImageView eIV;
    private View.OnClickListener eIr;
    private TextView eJr;
    private View eJs;
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
        this.eIO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.agw != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.agw.bil())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.agw.bil(), m.bhT())));
                    if (ConcernForumThreadUserInfoLayout.this.eIr != null) {
                        ConcernForumThreadUserInfoLayout.this.eIr.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.eIV = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.eIK = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eIL = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.eJr = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eJs = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.eIK.setOnClickListener(this.eIO);
    }

    private void initHeaderImg() {
        if (this.eIV != null) {
            this.eIV.setDefaultResource(17170445);
            this.eIV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eIV.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eIV.setIsRound(true);
            this.eIV.setOnClickListener(this.eIO);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajF = onClickListener;
        if (this.eIV != null) {
            this.eIV.setAfterClickListener(this.ajF);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eIr = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eIV != null) {
            this.eIV.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eIV;
    }

    public TextView getUserName() {
        return this.eIL;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
