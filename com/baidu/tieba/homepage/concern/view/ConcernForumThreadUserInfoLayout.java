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
    private bh FT;
    private View.OnClickListener HO;
    private View.OnClickListener cpN;
    private TextView crT;
    private View crU;
    public TextView crl;
    public TextView crm;
    private View.OnClickListener crp;
    public ClickableHeaderImageView crw;
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
        this.crp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.FT != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.FT.aiL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.FT.aiL(), n.ait())));
                    if (ConcernForumThreadUserInfoLayout.this.cpN != null) {
                        ConcernForumThreadUserInfoLayout.this.cpN.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.crw = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.crl = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.crm = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.crT = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.crU = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.crl.setOnClickListener(this.crp);
    }

    private void initHeaderImg() {
        if (this.crw != null) {
            this.crw.setDefaultResource(17170445);
            this.crw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.crw.setDefaultBgResource(R.color.cp_bg_line_e);
            this.crw.setIsRound(true);
            this.crw.setOnClickListener(this.crp);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        this.FT = bhVar;
        an(bhVar);
        D(bhVar);
        A(bhVar);
        C(bhVar);
        return true;
    }

    private void an(bh bhVar) {
        if (bhVar == null || bhVar.aiG() == null || StringUtils.isNull(bhVar.aiG().getPortrait())) {
            this.crw.setVisibility(8);
        } else {
            this.crw.setVisibility(0);
        }
    }

    public void D(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.aiL())) {
            this.crl.setVisibility(4);
            return;
        }
        this.crl.setText(aq.cutChineseAndEnglishWithSuffix(this.FT.aiL(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.crl.setVisibility(0);
    }

    public void A(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.FT.aiG().getName_show())) {
            this.crm.setText(getContext().getString(R.string.user_name_and_publish_time, oA(this.FT.aiG().getName_show()), aq.getFormatTime(bhVar.getCreateTime())));
            this.crm.setVisibility(0);
        }
    }

    private void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.crT.setVisibility(8);
            this.crU.setVisibility(8);
            return;
        }
        this.crT.setText(this.FT.getAddress());
        this.crT.setVisibility(0);
        this.crU.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.HO = onClickListener;
        if (this.crw != null) {
            this.crw.setAfterClickListener(this.HO);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cpN = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.crw != null) {
            this.crw.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.crl, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.crm, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.crT, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.crU, R.color.cp_cont_e);
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void et(boolean z) {
        if (z) {
            D(this.FT);
        } else {
            this.crl.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.crw;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.crm;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
