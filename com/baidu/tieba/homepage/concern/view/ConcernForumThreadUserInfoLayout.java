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
    private bb aFg;
    private View.OnClickListener aIy;
    public TextView aJM;
    public TextView aJN;
    private View.OnClickListener aJQ;
    private View.OnClickListener aKC;
    public ClickableHeaderImageView aKp;
    private TextView aKu;
    private View aKv;
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
        this.aJQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.aFg != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.aFg.zM())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.aFg.zM(), o.zu())));
                    if (ConcernForumThreadUserInfoLayout.this.aIy != null) {
                        ConcernForumThreadUserInfoLayout.this.aIy.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.aKp = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aJM = (TextView) inflate.findViewById(e.g.thread_info_forum_name);
        this.aJN = (TextView) inflate.findViewById(e.g.thread_user_name_and_reply_time);
        this.aKu = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKv = inflate.findViewById(e.g.divider);
        setGravity(16);
        initHeaderImg();
        this.aJM.setOnClickListener(this.aJQ);
    }

    private void initHeaderImg() {
        if (this.aKp != null) {
            this.aKp.setDefaultResource(17170445);
            this.aKp.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKp.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKp.setIsRound(true);
            this.aKp.setOnClickListener(this.aJQ);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.aFg = bbVar;
        ah(bbVar);
        updateForumName(bbVar);
        j(bbVar);
        s(bbVar);
        return true;
    }

    private void ah(bb bbVar) {
        if (bbVar == null || bbVar.zG() == null || StringUtils.isNull(bbVar.zG().getPortrait())) {
            this.aKp.setVisibility(8);
        } else {
            this.aKp.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.zM())) {
            this.aJM.setVisibility(4);
            return;
        }
        this.aJM.setText(ao.d(this.aFg.zM(), 16, "...") + getResources().getString(e.j.forum));
        this.aJM.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFg.zG().getName_show())) {
            this.aJN.setText(getContext().getString(e.j.user_name_and_publish_time, gt(this.aFg.zG().getName_show()), ao.M(bbVar.getCreateTime())));
            this.aJN.setVisibility(0);
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKu.setVisibility(8);
            this.aKv.setVisibility(8);
            return;
        }
        this.aKu.setText(this.aFg.getAddress());
        this.aKu.setVisibility(0);
        this.aKv.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aKC = onClickListener;
        if (this.aKp != null) {
            this.aKp.setAfterClickListener(this.aKC);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIy = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKp != null) {
            this.aKp.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aJM, e.d.cp_link_tip_c);
            al.h(this.aJN, e.d.cp_cont_d);
            al.h(this.aKu, e.d.cp_cont_d);
            al.j(this.aKv, e.d.cp_cont_e);
        }
    }

    protected String gt(String str) {
        return ao.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFg);
        } else {
            this.aJM.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKp;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aJN;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return false;
    }
}
