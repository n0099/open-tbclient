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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes9.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bu aeK;
    private View.OnClickListener ahM;
    private View.OnClickListener edU;
    private TextView eeU;
    private View eeV;
    public TextView een;
    public TextView eeo;
    private View.OnClickListener eer;
    public ClickableHeaderImageView eey;
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
        this.eer = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aeK != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aeK.aSt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aeK.aSt(), m.aSb())));
                    if (ConcernForumThreadUserInfoLayout.this.edU != null) {
                        ConcernForumThreadUserInfoLayout.this.edU.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.eey = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.een = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eeo = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.eeU = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eeV = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.een.setOnClickListener(this.eer);
    }

    private void initHeaderImg() {
        if (this.eey != null) {
            this.eey.setDefaultResource(17170445);
            this.eey.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eey.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eey.setIsRound(true);
            this.eey.setOnClickListener(this.eer);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahM = onClickListener;
        if (this.eey != null) {
            this.eey.setAfterClickListener(this.ahM);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.edU = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eey != null) {
            this.eey.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eey;
    }

    public TextView getUserName() {
        return this.eeo;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
