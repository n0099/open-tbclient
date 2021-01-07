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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bz aim;
    private View.OnClickListener alk;
    private View.OnClickListener fmS;
    private TextView fnP;
    private View fnQ;
    public TextView fni;
    public TextView fnj;
    private View.OnClickListener fnm;
    public ClickableHeaderImageView fnt;
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
        this.fnm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aim != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aim.brv())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aim.brv(), m.brd())));
                    if (ConcernForumThreadUserInfoLayout.this.fmS != null) {
                        ConcernForumThreadUserInfoLayout.this.fmS.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.fnt = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.fni = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.fnj = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.fnP = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fnQ = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.fni.setOnClickListener(this.fnm);
    }

    private void initHeaderImg() {
        if (this.fnt != null) {
            this.fnt.setDefaultResource(17170445);
            this.fnt.setDefaultBgResource(R.color.CAM_X0205);
            this.fnt.setIsRound(true);
            this.fnt.setOnClickListener(this.fnm);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alk = onClickListener;
        if (this.fnt != null) {
            this.fnt.setAfterClickListener(this.alk);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fmS = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fnt != null) {
            this.fnt.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fnt;
    }

    public TextView getUserName() {
        return this.fnj;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
