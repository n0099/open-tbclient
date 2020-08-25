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
    private bw afJ;
    private View.OnClickListener aiR;
    private View.OnClickListener etZ;
    public ClickableHeaderImageView euD;
    private TextView euZ;
    public TextView eus;
    public TextView eut;
    private View.OnClickListener euw;
    private View eva;
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
        this.euw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.afJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.afJ.beI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.afJ.beI(), m.beq())));
                    if (ConcernForumThreadUserInfoLayout.this.etZ != null) {
                        ConcernForumThreadUserInfoLayout.this.etZ.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.euD = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.eus = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eut = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.euZ = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eva = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.eus.setOnClickListener(this.euw);
    }

    private void initHeaderImg() {
        if (this.euD != null) {
            this.euD.setDefaultResource(17170445);
            this.euD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.euD.setDefaultBgResource(R.color.cp_bg_line_e);
            this.euD.setIsRound(true);
            this.euD.setOnClickListener(this.euw);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiR = onClickListener;
        if (this.euD != null) {
            this.euD.setAfterClickListener(this.aiR);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.etZ = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euD != null) {
            this.euD.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.euD;
    }

    public TextView getUserName() {
        return this.eut;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
