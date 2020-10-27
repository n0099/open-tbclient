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
    private View.OnClickListener eQN;
    private TextView eRN;
    private View eRO;
    public TextView eRg;
    public TextView eRh;
    private View.OnClickListener eRk;
    public ClickableHeaderImageView eRr;
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
        this.eRk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.agx != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.agx.bke())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.agx.bke(), n.bjM())));
                    if (ConcernForumThreadUserInfoLayout.this.eQN != null) {
                        ConcernForumThreadUserInfoLayout.this.eQN.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.eRr = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.eRg = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eRh = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.eRN = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eRO = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.eRg.setOnClickListener(this.eRk);
    }

    private void initHeaderImg() {
        if (this.eRr != null) {
            this.eRr.setDefaultResource(17170445);
            this.eRr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eRr.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eRr.setIsRound(true);
            this.eRr.setOnClickListener(this.eRk);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
        if (this.eRr != null) {
            this.eRr.setAfterClickListener(this.ajG);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eQN = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eRr != null) {
            this.eRr.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eRr;
    }

    public TextView getUserName() {
        return this.eRh;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
