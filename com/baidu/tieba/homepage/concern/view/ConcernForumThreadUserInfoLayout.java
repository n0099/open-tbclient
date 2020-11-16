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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes21.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    private bx agB;
    private View.OnClickListener ajJ;
    private View.OnClickListener eVM;
    private TextView eWJ;
    private View eWK;
    public TextView eWc;
    public TextView eWd;
    private View.OnClickListener eWg;
    public ClickableHeaderImageView eWn;
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
        this.eWg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.agB != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.agB.blG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.agB.blG(), n.blo())));
                    if (ConcernForumThreadUserInfoLayout.this.eVM != null) {
                        ConcernForumThreadUserInfoLayout.this.eVM.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.eWn = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.eWc = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.eWd = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.eWJ = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eWK = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.eWc.setOnClickListener(this.eWg);
    }

    private void initHeaderImg() {
        if (this.eWn != null) {
            this.eWn.setDefaultResource(17170445);
            this.eWn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eWn.setDefaultBgResource(R.color.CAM_X0205);
            this.eWn.setIsRound(true);
            this.eWn.setOnClickListener(this.eWg);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajJ = onClickListener;
        if (this.eWn != null) {
            this.eWn.setAfterClickListener(this.ajJ);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eVM = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWn != null) {
            this.eWn.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eWn;
    }

    public TextView getUserName() {
        return this.eWd;
    }

    public boolean getIsSimpleThread() {
        return false;
    }
}
