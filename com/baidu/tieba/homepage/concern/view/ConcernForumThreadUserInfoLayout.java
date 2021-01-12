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
    private bz ahu;
    private View.OnClickListener akt;
    public TextView fiA;
    private View.OnClickListener fiD;
    public ClickableHeaderImageView fiK;
    private View.OnClickListener fih;
    public TextView fiz;
    private TextView fjg;
    private View fjh;
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
        this.fiD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.ahu != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.ahu.bnB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.ahu.bnB(), m.bnj())));
                    if (ConcernForumThreadUserInfoLayout.this.fih != null) {
                        ConcernForumThreadUserInfoLayout.this.fih.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.fiK = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.fiz = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.fiA = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.fjg = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fjh = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.fiz.setOnClickListener(this.fiD);
    }

    private void initHeaderImg() {
        if (this.fiK != null) {
            this.fiK.setDefaultResource(17170445);
            this.fiK.setDefaultBgResource(R.color.CAM_X0205);
            this.fiK.setIsRound(true);
            this.fiK.setOnClickListener(this.fiD);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
        if (this.fiK != null) {
            this.fiK.setAfterClickListener(this.akt);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fih = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fiK != null) {
            this.fiK.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fiK;
    }

    public TextView getUserName() {
        return this.fiA;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
