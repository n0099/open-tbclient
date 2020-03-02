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
    private View.OnClickListener dhJ;
    private TextView diM;
    private View diN;
    public TextView dic;
    public TextView die;
    private View.OnClickListener dih;
    public ClickableHeaderImageView dio;
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
        this.dih = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.KJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.KJ.aCt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.KJ.aCt(), l.aCa())));
                    if (ConcernForumThreadUserInfoLayout.this.dhJ != null) {
                        ConcernForumThreadUserInfoLayout.this.dhJ.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.dio = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.dic = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.die = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.diM = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.diN = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.dic.setOnClickListener(this.dih);
    }

    private void initHeaderImg() {
        if (this.dio != null) {
            this.dio.setDefaultResource(17170445);
            this.dio.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dio.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dio.setIsRound(true);
            this.dio.setOnClickListener(this.dih);
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
            this.dio.setVisibility(8);
        } else {
            this.dio.setVisibility(0);
        }
    }

    public void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aCt())) {
            this.dic.setVisibility(4);
            return;
        }
        this.dic.setText(aq.cutChineseAndEnglishWithSuffix(this.KJ.aCt(), 16, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dic.setVisibility(0);
    }

    public void F(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCo().getName_show())) {
            this.die.setText(getContext().getString(R.string.user_name_and_publish_time, tY(this.KJ.aCo().getName_show()), aq.getFormatTime(bjVar.getCreateTime())));
            this.die.setVisibility(0);
        }
    }

    private void I(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.diM.setVisibility(8);
            this.diN.setVisibility(8);
            return;
        }
        this.diM.setText(this.KJ.getAddress());
        this.diM.setVisibility(0);
        this.diN.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
        if (this.dio != null) {
            this.dio.setAfterClickListener(this.Nw);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhJ = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dio != null) {
            this.dio.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.dic, (int) R.color.cp_link_tip_c);
            am.setViewTextColor(this.die, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.diM, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.diN, R.color.cp_cont_e);
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 10, StringHelper.STRING_MORE);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fR(boolean z) {
        if (z) {
            J(this.KJ);
        } else {
            this.dic.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dio;
    }

    public TextView getUserName() {
        return this.die;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
