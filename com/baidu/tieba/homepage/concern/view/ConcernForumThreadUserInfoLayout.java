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
    private bj adG;
    private View.OnClickListener agi;
    private View.OnClickListener dIC;
    public ClickableHeaderImageView dIJ;
    private View.OnClickListener dIf;
    public TextView dIy;
    public TextView dIz;
    private TextView dJf;
    private View dJg;
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
        this.dIC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.adG != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.adG.aKJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.adG.aKJ(), l.aKq())));
                    if (ConcernForumThreadUserInfoLayout.this.dIf != null) {
                        ConcernForumThreadUserInfoLayout.this.dIf.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.dIJ = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.dIy = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.dIz = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.dJf = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dJg = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.dIy.setOnClickListener(this.dIC);
    }

    private void initHeaderImg() {
        if (this.dIJ != null) {
            this.dIJ.setDefaultResource(17170445);
            this.dIJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dIJ.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dIJ.setIsRound(true);
            this.dIJ.setOnClickListener(this.dIC);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            return false;
        }
        this.adG = bjVar;
        aA(bjVar);
        K(bjVar);
        G(bjVar);
        J(bjVar);
        return true;
    }

    private void aA(bj bjVar) {
        if (bjVar == null || bjVar.aKE() == null || StringUtils.isNull(bjVar.aKE().getPortrait())) {
            this.dIJ.setVisibility(8);
        } else {
            this.dIJ.setVisibility(0);
        }
    }

    public void K(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aKJ())) {
            this.dIy.setVisibility(4);
            return;
        }
        this.dIy.setText(aq.cutChineseAndEnglishWithSuffix(this.adG.aKJ(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dIy.setVisibility(0);
    }

    public void G(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.adG.aKE().getName_show())) {
            this.dIz.setText(getContext().getString(R.string.user_name_and_publish_time, vm(this.adG.aKE().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.dIz.setVisibility(0);
        }
    }

    private void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.dJf.setVisibility(8);
            this.dJg.setVisibility(8);
            return;
        }
        this.dJf.setText(this.adG.getAddress());
        this.dJf.setVisibility(0);
        this.dJg.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agi = onClickListener;
        if (this.dIJ != null) {
            this.dIJ.setAfterClickListener(this.agi);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dIf = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dIJ != null) {
            this.dIJ.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.dIy, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.dIz, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dJf, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.dJg, R.color.cp_cont_e);
        }
    }

    protected String vm(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void gQ(boolean z) {
        if (z) {
            K(this.adG);
        } else {
            this.dIy.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dIJ;
    }

    public TextView getUserName() {
        return this.dIz;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
