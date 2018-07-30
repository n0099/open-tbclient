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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.c {
    private bb atD;
    public ClickableHeaderImageView axK;
    private View.OnClickListener axO;
    public TextView axT;
    public TextView axU;
    private View.OnClickListener axX;
    private View.OnClickListener axz;
    private TextView ayA;
    private View ayB;
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
        this.axX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.atD != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.atD.vq())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.atD.vq(), o.uY())));
                    if (ConcernForumThreadUserInfoLayout.this.axz != null) {
                        ConcernForumThreadUserInfoLayout.this.axz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.axK = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.axT = (TextView) inflate.findViewById(d.g.thread_info_forum_name);
        this.axU = (TextView) inflate.findViewById(d.g.thread_user_name_and_reply_time);
        this.ayA = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.ayB = inflate.findViewById(d.g.divider);
        setGravity(16);
        initHeaderImg();
        this.axT.setOnClickListener(this.axX);
    }

    private void initHeaderImg() {
        if (this.axK != null) {
            this.axK.setDefaultResource(17170445);
            this.axK.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.axK.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.axK.setIsRound(true);
            this.axK.setOnClickListener(this.axX);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.atD = bbVar;
        ag(bbVar);
        updateForumName(bbVar);
        i(bbVar);
        r(bbVar);
        return true;
    }

    private void ag(bb bbVar) {
        if (bbVar == null || bbVar.vk() == null || StringUtils.isNull(bbVar.vk().getPortrait())) {
            this.axK.setVisibility(8);
        } else {
            this.axK.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.vq())) {
            this.axT.setVisibility(4);
            return;
        }
        this.axT.setText(ap.e(this.atD.vq(), 16, "...") + getResources().getString(d.j.forum));
        this.axT.setVisibility(0);
    }

    public void i(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.atD.vk().getName_show())) {
            this.axU.setText(getContext().getString(d.j.user_name_and_publish_time, fp(this.atD.vk().getName_show()), ap.w(bbVar.getCreateTime())));
            this.axU.setVisibility(0);
        }
    }

    private void r(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.ayA.setVisibility(8);
            this.ayB.setVisibility(8);
            return;
        }
        this.ayA.setText(this.atD.getAddress());
        this.ayA.setVisibility(0);
        this.ayB.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axO = onClickListener;
        if (this.axK != null) {
            this.axK.setAfterClickListener(this.axO);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axz = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axK != null) {
            this.axK.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.axT, d.C0140d.cp_link_tip_c);
            am.h(this.axU, d.C0140d.cp_cont_d);
            am.h(this.ayA, d.C0140d.cp_cont_d);
            am.j(this.ayB, d.C0140d.cp_cont_e);
        }
    }

    protected String fp(String str) {
        return ap.e(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.c
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atD);
        } else {
            this.axT.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.axK;
    }

    @Override // com.baidu.tbadk.core.view.c
    public TextView getUserName() {
        return this.axU;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
