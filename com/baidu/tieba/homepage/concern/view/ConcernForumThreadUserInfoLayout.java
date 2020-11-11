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
import com.baidu.tieba.card.n;
/* loaded from: classes22.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bw agx;
    private View.OnClickListener ajG;
    private View.OnClickListener eWC;
    public TextView eWV;
    public TextView eWW;
    private View.OnClickListener eWZ;
    private TextView eXC;
    private View eXD;
    public ClickableHeaderImageView eXg;
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
        this.eWZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.agx != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.agx.bmE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.agx.bmE(), n.bmm())));
                    if (ConcernForumThreadUserInfoLayout.this.eWC != null) {
                        ConcernForumThreadUserInfoLayout.this.eWC.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.eXg = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.eWV = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eWW = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.eXC = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eXD = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.eWV.setOnClickListener(this.eWZ);
    }

    private void initHeaderImg() {
        if (this.eXg != null) {
            this.eXg.setDefaultResource(17170445);
            this.eXg.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eXg.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eXg.setIsRound(true);
            this.eXg.setOnClickListener(this.eWZ);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
        if (this.eXg != null) {
            this.eXg.setAfterClickListener(this.ajG);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eWC = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eXg != null) {
            this.eXg.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eXg;
    }

    public TextView getUserName() {
        return this.eWW;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
