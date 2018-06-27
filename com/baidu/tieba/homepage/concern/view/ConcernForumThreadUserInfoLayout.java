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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.c {
    private bc atZ;
    private View.OnClickListener axT;
    private TextView ayN;
    private View ayO;
    public TextView ayV;
    public ClickableHeaderImageView aye;
    private View.OnClickListener ayi;
    public TextView dRw;
    private View.OnClickListener dRx;
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
        this.dRx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.atZ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.atZ.vB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.atZ.vB(), o.vk())));
                    if (ConcernForumThreadUserInfoLayout.this.axT != null) {
                        ConcernForumThreadUserInfoLayout.this.axT.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aye = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ayV = (TextView) inflate.findViewById(d.g.thread_info_forum_name);
        this.dRw = (TextView) inflate.findViewById(d.g.thread_user_name_and_reply_time);
        this.ayN = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.ayO = inflate.findViewById(d.g.divider);
        setGravity(16);
        initHeaderImg();
        this.ayV.setOnClickListener(this.dRx);
    }

    private void initHeaderImg() {
        if (this.aye != null) {
            this.aye.setDefaultResource(17170445);
            this.aye.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.aye.setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.aye.setIsRound(true);
            this.aye.setOnClickListener(this.dRx);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        this.atZ = bcVar;
        ae(bcVar);
        updateForumName(bcVar);
        af(bcVar);
        p(bcVar);
        return true;
    }

    private void ae(bc bcVar) {
        if (bcVar == null || bcVar.vw() == null || StringUtils.isNull(bcVar.vw().getPortrait())) {
            this.aye.setVisibility(8);
        } else {
            this.aye.setVisibility(0);
        }
    }

    public void updateForumName(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.vB())) {
            this.ayV.setVisibility(4);
            return;
        }
        this.ayV.setText(ap.e(this.atZ.vB(), 16, "...") + getResources().getString(d.k.forum));
        this.ayV.setVisibility(0);
    }

    public void af(bc bcVar) {
        if (bcVar != null && !StringUtils.isNull(this.atZ.vw().getName_show())) {
            this.dRw.setText(getContext().getString(d.k.user_name_and_publish_time, fs(this.atZ.vw().getName_show()), ap.w(bcVar.getCreateTime())));
            this.dRw.setVisibility(0);
        }
    }

    private void p(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAddress())) {
            this.ayN.setVisibility(8);
            this.ayO.setVisibility(8);
            return;
        }
        this.ayN.setText(this.atZ.getAddress());
        this.ayN.setVisibility(0);
        this.ayO.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ayi = onClickListener;
        if (this.aye != null) {
            this.aye.setAfterClickListener(this.ayi);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axT = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aye != null) {
            this.aye.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.ayV, d.C0142d.cp_link_tip_c);
            am.h(this.dRw, d.C0142d.cp_cont_d);
            am.h(this.ayN, d.C0142d.cp_cont_d);
            am.j(this.ayO, d.C0142d.cp_cont_e);
        }
    }

    protected String fs(String str) {
        return ap.e(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.c
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atZ);
        } else {
            this.ayV.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.aye;
    }

    @Override // com.baidu.tbadk.core.view.c
    public TextView getUserName() {
        return this.dRw;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
