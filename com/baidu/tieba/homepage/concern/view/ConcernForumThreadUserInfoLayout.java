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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes22.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private by ahA;
    private View.OnClickListener akI;
    public TextView fdA;
    private View.OnClickListener fdD;
    public ClickableHeaderImageView fdK;
    private View.OnClickListener fdj;
    public TextView fdz;
    private TextView feg;
    private View feh;
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
        this.fdD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.ahA != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.ahA.boT())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.ahA.boT(), n.boB())));
                    if (ConcernForumThreadUserInfoLayout.this.fdj != null) {
                        ConcernForumThreadUserInfoLayout.this.fdj.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.fdK = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.fdz = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.fdA = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.feg = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.feh = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.fdz.setOnClickListener(this.fdD);
    }

    private void initHeaderImg() {
        if (this.fdK != null) {
            this.fdK.setDefaultResource(17170445);
            this.fdK.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fdK.setDefaultBgResource(R.color.CAM_X0205);
            this.fdK.setIsRound(true);
            this.fdK.setOnClickListener(this.fdD);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
        if (this.fdK != null) {
            this.fdK.setAfterClickListener(this.akI);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fdj = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fdK != null) {
            this.fdK.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fdK;
    }

    public TextView getUserName() {
        return this.fdA;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
