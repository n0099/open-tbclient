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
    private bh Wd;
    private View.OnClickListener XU;
    private View.OnClickListener cbv;
    public TextView ccX;
    public TextView ccY;
    private TextView cdF;
    private View cdG;
    private View.OnClickListener cdb;
    public ClickableHeaderImageView cdi;
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
        this.cdb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.Wd != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.Wd.aeH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.Wd.aeH(), n.aep())));
                    if (ConcernForumThreadUserInfoLayout.this.cbv != null) {
                        ConcernForumThreadUserInfoLayout.this.cbv.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.cdi = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ccX = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.ccY = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.cdF = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.cdG = inflate.findViewById(R.id.divider);
        setGravity(16);
        initHeaderImg();
        this.ccX.setOnClickListener(this.cdb);
    }

    private void initHeaderImg() {
        if (this.cdi != null) {
            this.cdi.setDefaultResource(17170445);
            this.cdi.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cdi.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cdi.setIsRound(true);
            this.cdi.setOnClickListener(this.cdb);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        this.Wd = bhVar;
        ap(bhVar);
        D(bhVar);
        A(bhVar);
        C(bhVar);
        return true;
    }

    private void ap(bh bhVar) {
        if (bhVar == null || bhVar.aeC() == null || StringUtils.isNull(bhVar.aeC().getPortrait())) {
            this.cdi.setVisibility(8);
        } else {
            this.cdi.setVisibility(0);
        }
    }

    public void D(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.aeH())) {
            this.ccX.setVisibility(4);
            return;
        }
        this.ccX.setText(aq.j(this.Wd.aeH(), 16, "...") + getResources().getString(R.string.forum));
        this.ccX.setVisibility(0);
    }

    public void A(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.Wd.aeC().getName_show())) {
            this.ccY.setText(getContext().getString(R.string.user_name_and_publish_time, pb(this.Wd.aeC().getName_show()), aq.aD(bhVar.getCreateTime())));
            this.ccY.setVisibility(0);
        }
    }

    private void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.cdF.setVisibility(8);
            this.cdG.setVisibility(8);
            return;
        }
        this.cdF.setText(this.Wd.getAddress());
        this.cdF.setVisibility(0);
        this.cdG.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
        if (this.cdi != null) {
            this.cdi.setAfterClickListener(this.XU);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cbv = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cdi != null) {
            this.cdi.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.ccX, R.color.cp_link_tip_c);
            am.j(this.ccY, R.color.cp_cont_d);
            am.j(this.cdF, R.color.cp_cont_d);
            am.l(this.cdG, R.color.cp_cont_e);
        }
    }

    protected String pb(String str) {
        return aq.j(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.d
    public void eq(boolean z) {
        if (z) {
            D(this.Wd);
        } else {
            this.ccX.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cdi;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.ccY;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return false;
    }
}
