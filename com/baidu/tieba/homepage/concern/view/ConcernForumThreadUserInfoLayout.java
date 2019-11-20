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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements d {
    private bh Fs;
    private View.OnClickListener Ho;
    private View.OnClickListener coV;
    public ClickableHeaderImageView cqE;
    public TextView cqt;
    public TextView cqu;
    private View.OnClickListener cqx;
    private TextView crb;
    private View crd;
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
        this.cqx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.Fs != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.Fs.aiJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.Fs.aiJ(), n.air())));
                    if (ConcernForumThreadUserInfoLayout.this.coV != null) {
                        ConcernForumThreadUserInfoLayout.this.coV.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.cqE = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.cqt = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.cqu = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.crb = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.crd = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.cqt.setOnClickListener(this.cqx);
    }

    private void initHeaderImg() {
        if (this.cqE != null) {
            this.cqE.setDefaultResource(17170445);
            this.cqE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cqE.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cqE.setIsRound(true);
            this.cqE.setOnClickListener(this.cqx);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        this.Fs = bhVar;
        an(bhVar);
        D(bhVar);
        A(bhVar);
        C(bhVar);
        return true;
    }

    private void an(bh bhVar) {
        if (bhVar == null || bhVar.aiE() == null || StringUtils.isNull(bhVar.aiE().getPortrait())) {
            this.cqE.setVisibility(8);
        } else {
            this.cqE.setVisibility(0);
        }
    }

    public void D(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.aiJ())) {
            this.cqt.setVisibility(4);
            return;
        }
        this.cqt.setText(aq.cutChineseAndEnglishWithSuffix(this.Fs.aiJ(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.cqt.setVisibility(0);
    }

    public void A(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.Fs.aiE().getName_show())) {
            this.cqu.setText(getContext().getString(R.string.user_name_and_publish_time, oA(this.Fs.aiE().getName_show()), aq.getFormatTime(bhVar.getCreateTime())));
            this.cqu.setVisibility(0);
        }
    }

    private void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.crb.setVisibility(8);
            this.crd.setVisibility(8);
            return;
        }
        this.crb.setText(this.Fs.getAddress());
        this.crb.setVisibility(0);
        this.crd.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Ho = onClickListener;
        if (this.cqE != null) {
            this.cqE.setAfterClickListener(this.Ho);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.coV = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cqE != null) {
            this.cqE.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.cqt, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.cqu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.crb, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.crd, R.color.cp_cont_e);
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void et(boolean z) {
        if (z) {
            D(this.Fs);
        } else {
            this.cqt.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cqE;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.cqu;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
