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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes9.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bk aee;
    private View.OnClickListener agI;
    public TextView dWR;
    public TextView dWS;
    private View.OnClickListener dWV;
    private View.OnClickListener dWy;
    public ClickableHeaderImageView dXc;
    private TextView dXy;
    private View dXz;
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
        this.dWV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aee != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aee.aQC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aee.aQC(), m.aQj())));
                    if (ConcernForumThreadUserInfoLayout.this.dWy != null) {
                        ConcernForumThreadUserInfoLayout.this.dWy.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.dXc = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.dWR = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.dWS = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.dXy = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dXz = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.dWR.setOnClickListener(this.dWV);
    }

    private void initHeaderImg() {
        if (this.dXc != null) {
            this.dXc.setDefaultResource(17170445);
            this.dXc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dXc.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dXc.setIsRound(true);
            this.dXc.setOnClickListener(this.dWV);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agI = onClickListener;
        if (this.dXc != null) {
            this.dXc.setAfterClickListener(this.agI);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dWy = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dXc != null) {
            this.dXc.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.dXc;
    }

    public TextView getUserName() {
        return this.dWS;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
