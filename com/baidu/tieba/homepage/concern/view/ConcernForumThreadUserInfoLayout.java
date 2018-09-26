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
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.f {
    public TextView aAN;
    public TextView aAO;
    private View.OnClickListener aAR;
    private View.OnClickListener aBE;
    public ClickableHeaderImageView aBr;
    private TextView aBw;
    private View aBx;
    private bb awf;
    private View.OnClickListener azz;
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
        this.aAR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.awf != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.awf.ws())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.awf.ws(), o.wa())));
                    if (ConcernForumThreadUserInfoLayout.this.azz != null) {
                        ConcernForumThreadUserInfoLayout.this.azz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aBr = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aAN = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aAO = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aBw = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aBx = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aAN.setOnClickListener(this.aAR);
    }

    private void initHeaderImg() {
        if (this.aBr != null) {
            this.aBr.setDefaultResource(17170445);
            this.aBr.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aBr.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aBr.setIsRound(true);
            this.aBr.setOnClickListener(this.aAR);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.awf = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.wm() == null || StringUtils.isNull(bbVar.wm().getPortrait())) {
            this.aBr.setVisibility(8);
        } else {
            this.aBr.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.ws())) {
            this.aAN.setVisibility(4);
            return;
        }
        this.aAN.setText(ao.d(this.awf.ws(), 16, "...") + getResources().getString(e.j.forum));
        this.aAN.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.awf.wm().getName_show())) {
            this.aAO.setText(getContext().getString(e.j.user_name_and_publish_time, fK(this.awf.wm().getName_show()), ao.A(bbVar.getCreateTime())));
            this.aAO.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aBw.setVisibility(8);
            this.aBx.setVisibility(8);
            return;
        }
        this.aBw.setText(this.awf.getAddress());
        this.aBw.setVisibility(0);
        this.aBx.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aBE = onClickListener;
        if (this.aBr != null) {
            this.aBr.setAfterClickListener(this.aBE);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.azz = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aBr != null) {
            this.aBr.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aAN, e.d.cp_link_tip_c);
            al.h(this.aAO, e.d.cp_cont_d);
            al.h(this.aBw, e.d.cp_cont_d);
            al.j(this.aBx, e.d.cp_cont_e);
        }
    }

    protected String fK(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.awf);
        } else {
            this.aAN.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aBr;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aAO;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
