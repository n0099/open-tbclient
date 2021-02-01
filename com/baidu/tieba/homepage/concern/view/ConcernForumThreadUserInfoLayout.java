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
    private cb ahi;
    private View.OnClickListener aki;
    public TextView fkQ;
    public TextView fkR;
    private View.OnClickListener fkU;
    private View.OnClickListener fkz;
    public ClickableHeaderImageView flb;
    private TextView flx;
    private View fly;
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
        this.fkU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.ahi != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.ahi.bnU())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.ahi.bnU(), m.bnC())));
                    if (ConcernForumThreadUserInfoLayout.this.fkz != null) {
                        ConcernForumThreadUserInfoLayout.this.fkz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.flb = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.fkQ = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.fkR = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.flx = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fly = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.fkQ.setOnClickListener(this.fkU);
    }

    private void initHeaderImg() {
        if (this.flb != null) {
            this.flb.setDefaultResource(17170445);
            this.flb.setDefaultBgResource(R.color.CAM_X0205);
            this.flb.setIsRound(true);
            this.flb.setOnClickListener(this.fkU);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aki = onClickListener;
        if (this.flb != null) {
            this.flb.setAfterClickListener(this.aki);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fkz = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.flb != null) {
            this.flb.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.flb;
    }

    public TextView getUserName() {
        return this.fkR;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
