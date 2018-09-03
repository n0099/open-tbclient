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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout implements com.baidu.tbadk.core.view.c {
    private bb atE;
    public ClickableHeaderImageView axH;
    private View.OnClickListener axL;
    public TextView axQ;
    public TextView axR;
    private View.OnClickListener axU;
    private View.OnClickListener axw;
    private TextView ayx;
    private View ayy;
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
        this.axU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernForumThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernForumThreadUserInfoLayout.this.atE != null && !StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.atE.vp())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.atE.vp(), o.uX())));
                    if (ConcernForumThreadUserInfoLayout.this.axw != null) {
                        ConcernForumThreadUserInfoLayout.this.axw.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.h.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.axH = (ClickableHeaderImageView) inflate.findViewById(f.g.card_home_page_normal_thread_user_header);
        this.axQ = (TextView) inflate.findViewById(f.g.thread_info_forum_name);
        this.axR = (TextView) inflate.findViewById(f.g.thread_user_name_and_reply_time);
        this.ayx = (TextView) inflate.findViewById(f.g.thread_info_address);
        this.ayy = inflate.findViewById(f.g.divider);
        setGravity(16);
        initHeaderImg();
        this.axQ.setOnClickListener(this.axU);
    }

    private void initHeaderImg() {
        if (this.axH != null) {
            this.axH.setDefaultResource(17170445);
            this.axH.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.axH.setDefaultBgResource(f.d.cp_bg_line_e);
            this.axH.setIsRound(true);
            this.axH.setOnClickListener(this.axU);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        this.atE = bbVar;
        ag(bbVar);
        updateForumName(bbVar);
        i(bbVar);
        r(bbVar);
        return true;
    }

    private void ag(bb bbVar) {
        if (bbVar == null || bbVar.vj() == null || StringUtils.isNull(bbVar.vj().getPortrait())) {
            this.axH.setVisibility(8);
        } else {
            this.axH.setVisibility(0);
        }
    }

    public void updateForumName(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.vp())) {
            this.axQ.setVisibility(4);
            return;
        }
        this.axQ.setText(ap.d(this.atE.vp(), 16, "...") + getResources().getString(f.j.forum));
        this.axQ.setVisibility(0);
    }

    public void i(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.atE.vj().getName_show())) {
            this.axR.setText(getContext().getString(f.j.user_name_and_publish_time, fp(this.atE.vj().getName_show()), ap.w(bbVar.getCreateTime())));
            this.axR.setVisibility(0);
        }
    }

    private void r(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.ayx.setVisibility(8);
            this.ayy.setVisibility(8);
            return;
        }
        this.ayx.setText(this.atE.getAddress());
        this.ayx.setVisibility(0);
        this.ayy.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axL = onClickListener;
        if (this.axH != null) {
            this.axH.setAfterClickListener(this.axL);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axw = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axH != null) {
            this.axH.setPageId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.axQ, f.d.cp_link_tip_c);
            am.h(this.axR, f.d.cp_cont_d);
            am.h(this.ayx, f.d.cp_cont_d);
            am.j(this.ayy, f.d.cp_cont_e);
        }
    }

    protected String fp(String str) {
        return ap.d(str, 10, "...");
    }

    @Override // com.baidu.tbadk.core.view.c
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atE);
        } else {
            this.axQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.axH;
    }

    @Override // com.baidu.tbadk.core.view.c
    public TextView getUserName() {
        return this.axR;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return false;
    }
}
