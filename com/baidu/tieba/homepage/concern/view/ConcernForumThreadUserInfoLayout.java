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
    private bb aFJ;
    private View.OnClickListener aJb;
    public ClickableHeaderImageView aKS;
    private TextView aKX;
    private View aKY;
    public TextView aKp;
    public TextView aKq;
    private View.OnClickListener aKt;
    private View.OnClickListener aLf;
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
        this.aKt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aFJ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aFJ.zZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aFJ.zZ(), o.zH())));
                    if (ConcernForumThreadUserInfoLayout.this.aJb != null) {
                        ConcernForumThreadUserInfoLayout.this.aJb.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aKS = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aKp = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aKq = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aKX = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKY = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aKp.setOnClickListener(this.aKt);
    }

    private void initHeaderImg() {
        if (this.aKS != null) {
            this.aKS.setDefaultResource(17170445);
            this.aKS.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKS.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKS.setIsRound(true);
            this.aKS.setOnClickListener(this.aKt);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.aFJ = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.zT() == null || StringUtils.isNull(bbVar.zT().getPortrait())) {
            this.aKS.setVisibility(8);
        } else {
            this.aKS.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.zZ())) {
            this.aKp.setVisibility(4);
            return;
        }
        this.aKp.setText(ao.d(this.aFJ.zZ(), 16, "...") + getResources().getString(e.j.forum));
        this.aKp.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFJ.zT().getName_show())) {
            this.aKq.setText(getContext().getString(e.j.user_name_and_publish_time, gG(this.aFJ.zT().getName_show()), ao.M(bbVar.getCreateTime())));
            this.aKq.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKX.setVisibility(8);
            this.aKY.setVisibility(8);
            return;
        }
        this.aKX.setText(this.aFJ.getAddress());
        this.aKX.setVisibility(0);
        this.aKY.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aLf = onClickListener;
        if (this.aKS != null) {
            this.aKS.setAfterClickListener(this.aLf);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJb = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKS != null) {
            this.aKS.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aKp, e.d.cp_link_tip_c);
            al.h(this.aKq, e.d.cp_cont_d);
            al.h(this.aKX, e.d.cp_cont_d);
            al.j(this.aKY, e.d.cp_cont_e);
        }
    }

    protected String gG(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFJ);
        } else {
            this.aKp.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKS;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aKq;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
