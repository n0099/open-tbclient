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
    private bj adJ;
    private View.OnClickListener agl;
    public TextView dIC;
    public TextView dID;
    private View.OnClickListener dIG;
    public ClickableHeaderImageView dIN;
    private View.OnClickListener dIj;
    private TextView dJj;
    private View dJk;
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
        this.dIG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.adJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.adJ.aKH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.adJ.aKH(), l.aKo())));
                    if (ConcernForumThreadUserInfoLayout.this.dIj != null) {
                        ConcernForumThreadUserInfoLayout.this.dIj.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.dIN = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.dIC = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.dID = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.dJj = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dJk = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.dIC.setOnClickListener(this.dIG);
    }

    private void initHeaderImg() {
        if (this.dIN != null) {
            this.dIN.setDefaultResource(17170445);
            this.dIN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dIN.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dIN.setIsRound(true);
            this.dIN.setOnClickListener(this.dIG);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        this.adJ = bjVar;
        aA(bjVar);
        K(bjVar);
        G(bjVar);
        J(bjVar);
        return true;
    }

    private void aA(bj bjVar) {
        if (bjVar == null || bjVar.aKC() == null || StringUtils.isNull(bjVar.aKC().getPortrait())) {
            this.dIN.setVisibility(8);
        } else {
            this.dIN.setVisibility(0);
        }
    }

    public void K(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aKH())) {
            this.dIC.setVisibility(4);
            return;
        }
        this.dIC.setText(aq.cutChineseAndEnglishWithSuffix(this.adJ.aKH(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dIC.setVisibility(0);
    }

    public void G(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.adJ.aKC().getName_show())) {
            this.dID.setText(getContext().getString(R.string.user_name_and_publish_time, vp(this.adJ.aKC().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.dID.setVisibility(0);
        }
    }

    private void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.dJj.setVisibility(8);
            this.dJk.setVisibility(8);
            return;
        }
        this.dJj.setText(this.adJ.getAddress());
        this.dJj.setVisibility(0);
        this.dJk.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agl = onClickListener;
        if (this.dIN != null) {
            this.dIN.setAfterClickListener(this.agl);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dIj = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dIN != null) {
            this.dIN.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.dIC, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.dID, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dJj, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.dJk, R.color.cp_cont_e);
        }
    }

    protected String vp(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void gQ(boolean z) {
        if (z) {
            K(this.adJ);
        } else {
            this.dIC.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dIN;
    }

    public TextView getUserName() {
        return this.dID;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
