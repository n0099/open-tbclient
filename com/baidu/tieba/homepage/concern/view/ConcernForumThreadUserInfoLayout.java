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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.f {
    private bb aFI;
    private View.OnClickListener aJa;
    public ClickableHeaderImageView aKR;
    private TextView aKW;
    private View aKX;
    public TextView aKo;
    public TextView aKp;
    private View.OnClickListener aKs;
    private View.OnClickListener aLe;
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
        this.aKs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aFI != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aFI.zZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aFI.zZ(), o.zH())));
                    if (ConcernForumThreadUserInfoLayout.this.aJa != null) {
                        ConcernForumThreadUserInfoLayout.this.aJa.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aKR = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aKo = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aKp = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aKW = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKX = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aKo.setOnClickListener(this.aKs);
    }

    private void initHeaderImg() {
        if (this.aKR != null) {
            this.aKR.setDefaultResource(17170445);
            this.aKR.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKR.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKR.setIsRound(true);
            this.aKR.setOnClickListener(this.aKs);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.aFI = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.zT() == null || StringUtils.isNull(bbVar.zT().getPortrait())) {
            this.aKR.setVisibility(8);
        } else {
            this.aKR.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.zZ())) {
            this.aKo.setVisibility(4);
            return;
        }
        this.aKo.setText(ao.d(this.aFI.zZ(), 16, "...") + getResources().getString(e.j.forum));
        this.aKo.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFI.zT().getName_show())) {
            this.aKp.setText(getContext().getString(e.j.user_name_and_publish_time, gG(this.aFI.zT().getName_show()), ao.M(bbVar.getCreateTime())));
            this.aKp.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKW.setVisibility(8);
            this.aKX.setVisibility(8);
            return;
        }
        this.aKW.setText(this.aFI.getAddress());
        this.aKW.setVisibility(0);
        this.aKX.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aLe = onClickListener;
        if (this.aKR != null) {
            this.aKR.setAfterClickListener(this.aLe);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJa = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKR != null) {
            this.aKR.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aKo, e.d.cp_link_tip_c);
            al.h(this.aKp, e.d.cp_cont_d);
            al.h(this.aKW, e.d.cp_cont_d);
            al.j(this.aKX, e.d.cp_cont_e);
        }
    }

    protected String gG(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFI);
        } else {
            this.aKo.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKR;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aKp;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
