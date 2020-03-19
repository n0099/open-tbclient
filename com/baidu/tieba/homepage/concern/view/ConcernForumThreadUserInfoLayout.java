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
    private View.OnClickListener Nx;
    public TextView diF;
    public TextView diG;
    private View.OnClickListener diJ;
    public ClickableHeaderImageView diQ;
    private View.OnClickListener dik;
    private TextView djm;
    private View djn;
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
        this.diJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.KJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.KJ.aCw())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.KJ.aCw(), l.aCd())));
                    if (ConcernForumThreadUserInfoLayout.this.dik != null) {
                        ConcernForumThreadUserInfoLayout.this.dik.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.diQ = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.diF = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.diG = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.djm = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.djn = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.diF.setOnClickListener(this.diJ);
    }

    private void initHeaderImg() {
        if (this.diQ != null) {
            this.diQ.setDefaultResource(17170445);
            this.diQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.diQ.setDefaultBgResource(R.color.cp_bg_line_e);
            this.diQ.setIsRound(true);
            this.diQ.setOnClickListener(this.diJ);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        this.KJ = bjVar;
        az(bjVar);
        K(bjVar);
        G(bjVar);
        J(bjVar);
        return true;
    }

    private void az(bj bjVar) {
        if (bjVar == null || bjVar.aCr() == null || StringUtils.isNull(bjVar.aCr().getPortrait())) {
            this.diQ.setVisibility(8);
        } else {
            this.diQ.setVisibility(0);
        }
    }

    public void K(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aCw())) {
            this.diF.setVisibility(4);
            return;
        }
        this.diF.setText(aq.cutChineseAndEnglishWithSuffix(this.KJ.aCw(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.diF.setVisibility(0);
    }

    public void G(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCr().getName_show())) {
            this.diG.setText(getContext().getString(R.string.user_name_and_publish_time, tZ(this.KJ.aCr().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.diG.setVisibility(0);
        }
    }

    private void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.djm.setVisibility(8);
            this.djn.setVisibility(8);
            return;
        }
        this.djm.setText(this.KJ.getAddress());
        this.djm.setVisibility(0);
        this.djn.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nx = onClickListener;
        if (this.diQ != null) {
            this.diQ.setAfterClickListener(this.Nx);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dik = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.diQ != null) {
            this.diQ.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.diF, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.diG, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.djm, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.djn, R.color.cp_cont_e);
        }
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fS(boolean z) {
        if (z) {
            K(this.KJ);
        } else {
            this.diF.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.diQ;
    }

    public TextView getUserName() {
        return this.diG;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
