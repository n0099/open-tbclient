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
/* loaded from: classes9.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.c {
    private bj KJ;
    private View.OnClickListener Nw;
    private View.OnClickListener dhW;
    public ClickableHeaderImageView diD;
    private TextView diZ;
    public TextView diq;
    public TextView dit;
    private View.OnClickListener diw;
    private View dja;
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
        this.diw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.KJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.KJ.aCt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.KJ.aCt(), l.aCa())));
                    if (ConcernForumThreadUserInfoLayout.this.dhW != null) {
                        ConcernForumThreadUserInfoLayout.this.dhW.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.diD = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.diq = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.dit = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.diZ = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dja = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.diq.setOnClickListener(this.diw);
    }

    private void initHeaderImg() {
        if (this.diD != null) {
            this.diD.setDefaultResource(17170445);
            this.diD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.diD.setDefaultBgResource(R.color.cp_bg_line_e);
            this.diD.setIsRound(true);
            this.diD.setOnClickListener(this.diw);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        this.KJ = bjVar;
        ay(bjVar);
        J(bjVar);
        F(bjVar);
        I(bjVar);
        return true;
    }

    private void ay(bj bjVar) {
        if (bjVar == null || bjVar.aCo() == null || StringUtils.isNull(bjVar.aCo().getPortrait())) {
            this.diD.setVisibility(8);
        } else {
            this.diD.setVisibility(0);
        }
    }

    public void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aCt())) {
            this.diq.setVisibility(4);
            return;
        }
        this.diq.setText(aq.cutChineseAndEnglishWithSuffix(this.KJ.aCt(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.diq.setVisibility(0);
    }

    public void F(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCo().getName_show())) {
            this.dit.setText(getContext().getString(R.string.user_name_and_publish_time, tZ(this.KJ.aCo().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.dit.setVisibility(0);
        }
    }

    private void I(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.diZ.setVisibility(8);
            this.dja.setVisibility(8);
            return;
        }
        this.diZ.setText(this.KJ.getAddress());
        this.diZ.setVisibility(0);
        this.dja.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
        if (this.diD != null) {
            this.diD.setAfterClickListener(this.Nw);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhW = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.diD != null) {
            this.diD.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.diq, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.dit, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.diZ, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.dja, R.color.cp_cont_e);
        }
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fR(boolean z) {
        if (z) {
            J(this.KJ);
        } else {
            this.diq.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.diD;
    }

    public TextView getUserName() {
        return this.dit;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
