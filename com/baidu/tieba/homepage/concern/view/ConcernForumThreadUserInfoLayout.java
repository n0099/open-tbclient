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
    private bb aBF;
    private View.OnClickListener aEX;
    public ClickableHeaderImageView aGN;
    private TextView aGS;
    private View aGT;
    public TextView aGk;
    public TextView aGl;
    private View.OnClickListener aGo;
    private View.OnClickListener aHa;
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
        this.aGo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aBF != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aBF.yI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aBF.yI(), o.yq())));
                    if (ConcernForumThreadUserInfoLayout.this.aEX != null) {
                        ConcernForumThreadUserInfoLayout.this.aEX.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aGN = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aGk = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aGl = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aGS = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aGT = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aGk.setOnClickListener(this.aGo);
    }

    private void initHeaderImg() {
        if (this.aGN != null) {
            this.aGN.setDefaultResource(17170445);
            this.aGN.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aGN.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aGN.setIsRound(true);
            this.aGN.setOnClickListener(this.aGo);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.aBF = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.yC() == null || StringUtils.isNull(bbVar.yC().getPortrait())) {
            this.aGN.setVisibility(8);
        } else {
            this.aGN.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.yI())) {
            this.aGk.setVisibility(4);
            return;
        }
        this.aGk.setText(ao.d(this.aBF.yI(), 16, "...") + getResources().getString(e.j.forum));
        this.aGk.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aBF.yC().getName_show())) {
            this.aGl.setText(getContext().getString(e.j.user_name_and_publish_time, fZ(this.aBF.yC().getName_show()), ao.E(bbVar.getCreateTime())));
            this.aGl.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aGS.setVisibility(8);
            this.aGT.setVisibility(8);
            return;
        }
        this.aGS.setText(this.aBF.getAddress());
        this.aGS.setVisibility(0);
        this.aGT.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aHa = onClickListener;
        if (this.aGN != null) {
            this.aGN.setAfterClickListener(this.aHa);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEX = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aGN != null) {
            this.aGN.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aGk, e.d.cp_link_tip_c);
            al.h(this.aGl, e.d.cp_cont_d);
            al.h(this.aGS, e.d.cp_cont_d);
            al.j(this.aGT, e.d.cp_cont_e);
        }
    }

    protected String fZ(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aBF);
        } else {
            this.aGk.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aGN;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aGl;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
