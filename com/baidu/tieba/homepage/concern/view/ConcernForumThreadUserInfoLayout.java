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
    private bh We;
    private View.OnClickListener XU;
    private View.OnClickListener caC;
    private TextView ccM;
    private View ccN;
    public TextView ccd;
    public TextView cce;
    private View.OnClickListener cch;
    public ClickableHeaderImageView cco;
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
        this.cch = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.We != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.We.aeD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.We.aeD(), n.ael())));
                    if (ConcernForumThreadUserInfoLayout.this.caC != null) {
                        ConcernForumThreadUserInfoLayout.this.caC.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.cco = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ccd = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.cce = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.ccM = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.ccN = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.ccd.setOnClickListener(this.cch);
    }

    private void initHeaderImg() {
        if (this.cco != null) {
            this.cco.setDefaultResource(17170445);
            this.cco.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cco.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cco.setIsRound(true);
            this.cco.setOnClickListener(this.cch);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        this.We = bhVar;
        ao(bhVar);
        C(bhVar);
        z(bhVar);
        B(bhVar);
        return true;
    }

    private void ao(bh bhVar) {
        if (bhVar == null || bhVar.aey() == null || StringUtils.isNull(bhVar.aey().getPortrait())) {
            this.cco.setVisibility(8);
        } else {
            this.cco.setVisibility(0);
        }
    }

    public void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.aeD())) {
            this.ccd.setVisibility(4);
            return;
        }
        this.ccd.setText(aq.j(this.We.aeD(), 16, "...") + getResources().getString(R.string.forum));
        this.ccd.setVisibility(0);
    }

    public void z(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.We.aey().getName_show())) {
            this.cce.setText(getContext().getString(R.string.user_name_and_publish_time, oT(this.We.aey().getName_show()), aq.aD(bhVar.getCreateTime())));
            this.cce.setVisibility(0);
        }
    }

    private void B(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.ccM.setVisibility(8);
            this.ccN.setVisibility(8);
            return;
        }
        this.ccM.setText(this.We.getAddress());
        this.ccM.setVisibility(0);
        this.ccN.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
        if (this.cco != null) {
            this.cco.setAfterClickListener(this.XU);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caC = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cco != null) {
            this.cco.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.ccd, R.color.cp_link_tip_c);
            am.j(this.cce, R.color.cp_cont_d);
            am.j(this.ccM, R.color.cp_cont_d);
            am.l(this.ccN, R.color.cp_cont_e);
        }
    }

    protected String oT(String str) {
        return aq.j(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void en(boolean z) {
        if (z) {
            C(this.We);
        } else {
            this.ccd.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cco;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.cce;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
