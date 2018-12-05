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
    private bb aFf;
    private View.OnClickListener aIx;
    public TextView aJK;
    public TextView aJL;
    private View.OnClickListener aJO;
    private View.OnClickListener aKA;
    public ClickableHeaderImageView aKn;
    private TextView aKs;
    private View aKt;
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
        this.aJO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aFf != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aFf.zM())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aFf.zM(), o.zu())));
                    if (ConcernForumThreadUserInfoLayout.this.aIx != null) {
                        ConcernForumThreadUserInfoLayout.this.aIx.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aKn = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aJK = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aJL = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aKs = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKt = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aJK.setOnClickListener(this.aJO);
    }

    private void initHeaderImg() {
        if (this.aKn != null) {
            this.aKn.setDefaultResource(17170445);
            this.aKn.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKn.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKn.setIsRound(true);
            this.aKn.setOnClickListener(this.aJO);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.aFf = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.zG() == null || StringUtils.isNull(bbVar.zG().getPortrait())) {
            this.aKn.setVisibility(8);
        } else {
            this.aKn.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.zM())) {
            this.aJK.setVisibility(4);
            return;
        }
        this.aJK.setText(ao.d(this.aFf.zM(), 16, "...") + getResources().getString(e.j.forum));
        this.aJK.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFf.zG().getName_show())) {
            this.aJL.setText(getContext().getString(e.j.user_name_and_publish_time, gr(this.aFf.zG().getName_show()), ao.L(bbVar.getCreateTime())));
            this.aJL.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKs.setVisibility(8);
            this.aKt.setVisibility(8);
            return;
        }
        this.aKs.setText(this.aFf.getAddress());
        this.aKs.setVisibility(0);
        this.aKt.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aKA = onClickListener;
        if (this.aKn != null) {
            this.aKn.setAfterClickListener(this.aKA);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIx = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKn != null) {
            this.aKn.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aJK, e.d.cp_link_tip_c);
            al.h(this.aJL, e.d.cp_cont_d);
            al.h(this.aKs, e.d.cp_cont_d);
            al.j(this.aKt, e.d.cp_cont_e);
        }
    }

    protected String gr(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFf);
        } else {
            this.aJK.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKn;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aJL;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
