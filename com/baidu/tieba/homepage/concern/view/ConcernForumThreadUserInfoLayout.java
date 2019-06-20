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
    private bg VJ;
    private View.OnClickListener Xz;
    private View.OnClickListener bZu;
    public TextView caU;
    public TextView caV;
    private View.OnClickListener caY;
    private TextView cbC;
    private View cbD;
    public ClickableHeaderImageView cbf;
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
        this.caY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.VJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.VJ.adA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.VJ.adA(), n.adi())));
                    if (ConcernForumThreadUserInfoLayout.this.bZu != null) {
                        ConcernForumThreadUserInfoLayout.this.bZu.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.cbf = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.caU = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.caV = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.cbC = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.cbD = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.caU.setOnClickListener(this.caY);
    }

    private void initHeaderImg() {
        if (this.cbf != null) {
            this.cbf.setDefaultResource(17170445);
            this.cbf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cbf.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cbf.setIsRound(true);
            this.cbf.setOnClickListener(this.caY);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        this.VJ = bgVar;
        an(bgVar);
        B(bgVar);
        y(bgVar);
        A(bgVar);
        return true;
    }

    private void an(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || StringUtils.isNull(bgVar.adv().getPortrait())) {
            this.cbf.setVisibility(8);
        } else {
            this.cbf.setVisibility(0);
        }
    }

    public void B(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.adA())) {
            this.caU.setVisibility(4);
            return;
        }
        this.caU.setText(ap.j(this.VJ.adA(), 16, "...") + getResources().getString(R.string.forum));
        this.caU.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.VJ.adv().getName_show())) {
            this.caV.setText(getContext().getString(R.string.user_name_and_publish_time, oC(this.VJ.adv().getName_show()), ap.aC(bgVar.getCreateTime())));
            this.caV.setVisibility(0);
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.cbC.setVisibility(8);
            this.cbD.setVisibility(8);
            return;
        }
        this.cbC.setText(this.VJ.getAddress());
        this.cbC.setVisibility(0);
        this.cbD.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Xz = onClickListener;
        if (this.cbf != null) {
            this.cbf.setAfterClickListener(this.Xz);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZu = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbf != null) {
            this.cbf.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.caU, R.color.cp_link_tip_c);
            al.j(this.caV, R.color.cp_cont_d);
            al.j(this.cbC, R.color.cp_cont_d);
            al.l(this.cbD, R.color.cp_cont_e);
        }
    }

    protected String oC(String str) {
        return ap.j(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void ej(boolean z) {
        if (z) {
            B(this.VJ);
        } else {
            this.caU.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cbf;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.caV;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
