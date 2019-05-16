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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements d {
    private bg VK;
    private View.OnClickListener XA;
    private View.OnClickListener bZt;
    public TextView caT;
    public TextView caU;
    private View.OnClickListener caX;
    private TextView cbB;
    private View cbC;
    public ClickableHeaderImageView cbe;
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
        this.caX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.VK != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.VK.adA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.VK.adA(), n.adi())));
                    if (ConcernForumThreadUserInfoLayout.this.bZt != null) {
                        ConcernForumThreadUserInfoLayout.this.bZt.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.cbe = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.caT = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.caU = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.cbB = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.cbC = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.caT.setOnClickListener(this.caX);
    }

    private void initHeaderImg() {
        if (this.cbe != null) {
            this.cbe.setDefaultResource(17170445);
            this.cbe.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cbe.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cbe.setIsRound(true);
            this.cbe.setOnClickListener(this.caX);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        this.VK = bgVar;
        an(bgVar);
        B(bgVar);
        y(bgVar);
        A(bgVar);
        return true;
    }

    private void an(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || StringUtils.isNull(bgVar.adv().getPortrait())) {
            this.cbe.setVisibility(8);
        } else {
            this.cbe.setVisibility(0);
        }
    }

    public void B(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.adA())) {
            this.caT.setVisibility(4);
            return;
        }
        this.caT.setText(ap.j(this.VK.adA(), 16, "...") + getResources().getString(R.string.forum));
        this.caT.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.VK.adv().getName_show())) {
            this.caU.setText(getContext().getString(R.string.user_name_and_publish_time, oD(this.VK.adv().getName_show()), ap.aC(bgVar.getCreateTime())));
            this.caU.setVisibility(0);
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.cbB.setVisibility(8);
            this.cbC.setVisibility(8);
            return;
        }
        this.cbB.setText(this.VK.getAddress());
        this.cbB.setVisibility(0);
        this.cbC.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XA = onClickListener;
        if (this.cbe != null) {
            this.cbe.setAfterClickListener(this.XA);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZt = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbe != null) {
            this.cbe.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.caT, R.color.cp_link_tip_c);
            al.j(this.caU, R.color.cp_cont_d);
            al.j(this.cbB, R.color.cp_cont_d);
            al.l(this.cbC, R.color.cp_cont_e);
        }
    }

    protected String oD(String str) {
        return ap.j(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void ej(boolean z) {
        if (z) {
            B(this.VK);
        } else {
            this.caT.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cbe;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.caU;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
