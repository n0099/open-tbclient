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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
/* loaded from: classes6.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.c {
    private bj Ki;
    private View.OnClickListener MT;
    public TextView ddN;
    public TextView ddO;
    private View.OnClickListener ddR;
    public ClickableHeaderImageView ddY;
    private View.OnClickListener ddt;
    private TextView dev;
    private View dew;
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
        this.ddR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.Ki != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.Ki.azJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.Ki.azJ(), l.azq())));
                    if (ConcernForumThreadUserInfoLayout.this.ddt != null) {
                        ConcernForumThreadUserInfoLayout.this.ddt.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.ddY = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ddN = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.ddO = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.dev = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dew = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.ddN.setOnClickListener(this.ddR);
    }

    private void initHeaderImg() {
        if (this.ddY != null) {
            this.ddY.setDefaultResource(17170445);
            this.ddY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ddY.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ddY.setIsRound(true);
            this.ddY.setOnClickListener(this.ddR);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        this.Ki = bjVar;
        at(bjVar);
        H(bjVar);
        E(bjVar);
        G(bjVar);
        return true;
    }

    private void at(bj bjVar) {
        if (bjVar == null || bjVar.azE() == null || StringUtils.isNull(bjVar.azE().getPortrait())) {
            this.ddY.setVisibility(8);
        } else {
            this.ddY.setVisibility(0);
        }
    }

    public void H(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.azJ())) {
            this.ddN.setVisibility(4);
            return;
        }
        this.ddN.setText(aq.cutChineseAndEnglishWithSuffix(this.Ki.azJ(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.ddN.setVisibility(0);
    }

    public void E(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.Ki.azE().getName_show())) {
            this.ddO.setText(getContext().getString(R.string.user_name_and_publish_time, tE(this.Ki.azE().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.ddO.setVisibility(0);
        }
    }

    private void G(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.dev.setVisibility(8);
            this.dew.setVisibility(8);
            return;
        }
        this.dev.setText(this.Ki.getAddress());
        this.dev.setVisibility(0);
        this.dew.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
        if (this.ddY != null) {
            this.ddY.setAfterClickListener(this.MT);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ddt = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddY != null) {
            this.ddY.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.ddN, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.ddO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dev, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.dew, R.color.cp_cont_e);
        }
    }

    protected String tE(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fF(boolean z) {
        if (z) {
            H(this.Ki);
        } else {
            this.ddN.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.ddY;
    }

    public TextView getUserName() {
        return this.ddO;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
