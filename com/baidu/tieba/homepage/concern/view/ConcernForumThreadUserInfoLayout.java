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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.b {
    private bd atn;
    private TextView axW;
    private View axX;
    private View.OnClickListener axg;
    public ClickableHeaderImageView axn;
    private View.OnClickListener axr;
    public TextView ayc;
    public TextView dOf;
    private View.OnClickListener dOg;
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
        this.dOg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.atn != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.atn.vr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.atn.vr(), o.vb())));
                    if (ConcernForumThreadUserInfoLayout.this.axg != null) {
                        ConcernForumThreadUserInfoLayout.this.axg.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.axn = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ayc = (TextView) inflate.findViewById(d.g.thread_info_forum_name);
        this.dOf = (TextView) inflate.findViewById(d.g.thread_user_name_and_reply_time);
        this.axW = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.axX = inflate.findViewById(d.g.divider);
        setGravity(16);
        initHeaderImg();
        this.ayc.setOnClickListener(this.dOg);
    }

    private void initHeaderImg() {
        if (this.axn != null) {
            this.axn.setDefaultResource(17170445);
            this.axn.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.axn.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.axn.setIsRound(true);
            this.axn.setOnClickListener(this.dOg);
        }
    }

    @Override // com.baidu.tbadk.core.view.b
    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        this.atn = bdVar;
        Z(bdVar);
        updateForumName(bdVar);
        aa(bdVar);
        n(bdVar);
        return true;
    }

    private void Z(bd bdVar) {
        if (bdVar == null || bdVar.vm() == null || StringUtils.isNull(bdVar.vm().getPortrait())) {
            this.axn.setVisibility(8);
        } else {
            this.axn.setVisibility(0);
        }
    }

    public void updateForumName(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.vr())) {
            this.ayc.setVisibility(4);
            return;
        }
        this.ayc.setText(ao.e(this.atn.vr(), 16, "...") + getResources().getString(d.k.forum));
        this.ayc.setVisibility(0);
    }

    public void aa(bd bdVar) {
        if (bdVar != null && !StringUtils.isNull(this.atn.vm().getName_show())) {
            this.dOf.setText(getContext().getString(d.k.user_name_and_publish_time, fo(this.atn.vm().getName_show()), ao.v(bdVar.getCreateTime())));
            this.dOf.setVisibility(0);
        }
    }

    private void n(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.axW.setVisibility(8);
            this.axX.setVisibility(8);
            return;
        }
        this.axW.setText(this.atn.getAddress());
        this.axW.setVisibility(0);
        this.axX.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.b
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axr = onClickListener;
        if (this.axn != null) {
            this.axn.setAfterClickListener(this.axr);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axg = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axn != null) {
            this.axn.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.ayc, d.C0141d.cp_link_tip_c);
            al.h(this.dOf, d.C0141d.cp_cont_d);
            al.h(this.axW, d.C0141d.cp_cont_d);
            al.j(this.axX, d.C0141d.cp_cont_e);
        }
    }

    protected String fo(String str) {
        return ao.e(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.b
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atn);
        } else {
            this.ayc.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.b
    public ClickableHeaderImageView getHeaderImg() {
        return this.axn;
    }

    @Override // com.baidu.tbadk.core.view.b
    public TextView getUserName() {
        return this.dOf;
    }

    @Override // com.baidu.tbadk.core.view.b
    public boolean getIsSimpleThread() {
        return false;
    }
}
