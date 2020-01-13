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
/* loaded from: classes7.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.c {
    private bj Kn;
    private View.OnClickListener MX;
    private View.OnClickListener ddE;
    public TextView ddX;
    public TextView ddY;
    private TextView deF;
    private View deG;
    private View.OnClickListener deb;
    public ClickableHeaderImageView dei;
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
        this.deb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.Kn != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.Kn.aAc())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.Kn.aAc(), l.azJ())));
                    if (ConcernForumThreadUserInfoLayout.this.ddE != null) {
                        ConcernForumThreadUserInfoLayout.this.ddE.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.dei = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ddX = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.ddY = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.deF = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.deG = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.ddX.setOnClickListener(this.deb);
    }

    private void initHeaderImg() {
        if (this.dei != null) {
            this.dei.setDefaultResource(17170445);
            this.dei.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dei.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dei.setIsRound(true);
            this.dei.setOnClickListener(this.deb);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        this.Kn = bjVar;
        au(bjVar);
        I(bjVar);
        E(bjVar);
        H(bjVar);
        return true;
    }

    private void au(bj bjVar) {
        if (bjVar == null || bjVar.azX() == null || StringUtils.isNull(bjVar.azX().getPortrait())) {
            this.dei.setVisibility(8);
        } else {
            this.dei.setVisibility(0);
        }
    }

    public void I(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aAc())) {
            this.ddX.setVisibility(4);
            return;
        }
        this.ddX.setText(aq.cutChineseAndEnglishWithSuffix(this.Kn.aAc(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.ddX.setVisibility(0);
    }

    public void E(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.Kn.azX().getName_show())) {
            this.ddY.setText(getContext().getString(R.string.user_name_and_publish_time, tI(this.Kn.azX().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.ddY.setVisibility(0);
        }
    }

    private void H(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.deF.setVisibility(8);
            this.deG.setVisibility(8);
            return;
        }
        this.deF.setText(this.Kn.getAddress());
        this.deF.setVisibility(0);
        this.deG.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MX = onClickListener;
        if (this.dei != null) {
            this.dei.setAfterClickListener(this.MX);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ddE = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dei != null) {
            this.dei.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.ddX, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.ddY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.deF, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.deG, R.color.cp_cont_e);
        }
    }

    protected String tI(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fK(boolean z) {
        if (z) {
            I(this.Kn);
        } else {
            this.ddX.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dei;
    }

    public TextView getUserName() {
        return this.ddY;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
