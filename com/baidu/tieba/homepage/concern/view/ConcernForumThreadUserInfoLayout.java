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
    private bb aAQ;
    private View.OnClickListener aEh;
    public ClickableHeaderImageView aFX;
    public TextView aFu;
    public TextView aFv;
    private View.OnClickListener aFy;
    private TextView aGc;
    private View aGd;
    private View.OnClickListener aGk;
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
        this.aFy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aAQ != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aAQ.yB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aAQ.yB(), o.yj())));
                    if (ConcernForumThreadUserInfoLayout.this.aEh != null) {
                        ConcernForumThreadUserInfoLayout.this.aEh.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aFX = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aFu = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aFv = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aGc = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aGd = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aFu.setOnClickListener(this.aFy);
    }

    private void initHeaderImg() {
        if (this.aFX != null) {
            this.aFX.setDefaultResource(17170445);
            this.aFX.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aFX.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aFX.setIsRound(true);
            this.aFX.setOnClickListener(this.aFy);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.aAQ = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.yv() == null || StringUtils.isNull(bbVar.yv().getPortrait())) {
            this.aFX.setVisibility(8);
        } else {
            this.aFX.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.yB())) {
            this.aFu.setVisibility(4);
            return;
        }
        this.aFu.setText(ao.d(this.aAQ.yB(), 16, "...") + getResources().getString(e.j.forum));
        this.aFu.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aAQ.yv().getName_show())) {
            this.aFv.setText(getContext().getString(e.j.user_name_and_publish_time, fY(this.aAQ.yv().getName_show()), ao.C(bbVar.getCreateTime())));
            this.aFv.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aGc.setVisibility(8);
            this.aGd.setVisibility(8);
            return;
        }
        this.aGc.setText(this.aAQ.getAddress());
        this.aGc.setVisibility(0);
        this.aGd.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aGk = onClickListener;
        if (this.aFX != null) {
            this.aFX.setAfterClickListener(this.aGk);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aFX != null) {
            this.aFX.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aFu, e.d.cp_link_tip_c);
            al.h(this.aFv, e.d.cp_cont_d);
            al.h(this.aGc, e.d.cp_cont_d);
            al.j(this.aGd, e.d.cp_cont_e);
        }
    }

    protected String fY(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aAQ);
        } else {
            this.aFu.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aFX;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aFv;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
