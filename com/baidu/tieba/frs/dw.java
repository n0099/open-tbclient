package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class dw extends com.baidu.adp.base.f<FrsActivity> {
    private View Do;
    private TextView bHA;
    private TextView bHB;
    private boolean bHC;
    private long bHD;
    private final BdSwitchView.a bHE;
    private FrameLayout bHl;
    private BdSwitchView bHm;
    private FrameLayout bHn;
    private BdSwitchView bHo;
    private BdSwitchView bHp;
    private TextView bHq;
    private LinearLayout bHr;
    private LinearLayout bHs;
    private TextView bHt;
    private TextView bHu;
    private TextView bHv;
    private TextView bHw;
    public TextView bHx;
    private View bHy;
    private TextView bHz;

    public dw(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bHl = null;
        this.bHm = null;
        this.bHn = null;
        this.bHo = null;
        this.bHp = null;
        this.Do = null;
        this.bHq = null;
        this.bHr = null;
        this.bHs = null;
        this.bHt = null;
        this.bHu = null;
        this.bHv = null;
        this.bHw = null;
        this.bHx = null;
        this.bHD = 0L;
        this.bHE = new dx(this);
        nl();
    }

    public View getView() {
        return this.Do;
    }

    public void init() {
        Xr();
        Xs();
    }

    private void nl() {
        this.Do = LayoutInflater.from(this.mContext.getPageActivity()).inflate(u.h.frs_sidebar, (ViewGroup) null);
        this.bHr = (LinearLayout) this.Do.findViewById(u.g.post_search_ll);
        this.bHx = (TextView) this.Do.findViewById(u.g.forum_manager_center);
        this.bHx.setVisibility(8);
        this.bHp = (BdSwitchView) this.Do.findViewById(u.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bHp, 10, 10, 10, 10);
        this.bHl = (FrameLayout) this.Do.findViewById(u.g.eyeshield_mode);
        this.bHm = (BdSwitchView) this.Do.findViewById(u.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bHm, 10, 10, 10, 10);
        this.bHm.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bHn = (FrameLayout) this.Do.findViewById(u.g.frequently_forum_switch);
        this.bHo = (BdSwitchView) this.Do.findViewById(u.g.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bHo, 10, 10, 10, 10);
        this.bHo.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bHp.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bHq = (TextView) this.Do.findViewById(u.g.message_btn);
        this.bHs = (LinearLayout) this.Do.findViewById(u.g.message_layout);
        this.bHt = (TextView) this.Do.findViewById(u.g.history_tv);
        this.bHu = (TextView) this.Do.findViewById(u.g.bar_info_tv);
        this.bHv = (TextView) this.Do.findViewById(u.g.forum_member);
        this.bHw = (TextView) this.Do.findViewById(u.g.frs_group);
        this.bHz = (TextView) this.Do.findViewById(u.g.frs_sidebar_good_tv);
        this.bHB = (TextView) this.Do.findViewById(u.g.bar_share_tv);
        this.bHA = (TextView) this.Do.findViewById(u.g.frs_sidebar_add_to_desktop);
        this.bHy = this.Do.findViewById(u.g.unfollow_layout);
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bHt.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bHu.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bHv.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bHw.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bHz.setVisibility(8);
        }
        if (!Xm()) {
            this.bHl.setVisibility(8);
            this.bHm.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.Do).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.Do != null) {
            this.Do.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean Xm() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dw(boolean z) {
        this.bHy.setVisibility(z ? 0 : 8);
    }

    public void dx(boolean z) {
        if (z) {
            this.bHo.iB();
        } else {
            this.bHo.iC();
        }
    }

    public FrameLayout Xn() {
        return this.bHn;
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.bHx.setVisibility(0);
        } else {
            this.bHx.setVisibility(8);
        }
    }

    public BdSwitchView Xo() {
        return this.bHm;
    }

    public BdSwitchView Xp() {
        return this.bHo;
    }

    public boolean Xq() {
        return this.bHC;
    }

    public void dy(boolean z) {
        this.bHC = z;
    }

    public void Xr() {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.bHm.iB();
            this.bHm.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_on));
            return;
        }
        this.bHm.iC();
        this.bHm.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_off));
    }

    public void Xs() {
        this.bHp.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.nW().oc()) {
            this.bHp.iB();
            this.bHp.setContentDescription(String.valueOf(this.mContext.getString(u.j.image_show_setting)) + this.mContext.getString(u.j.now_state_on));
        } else {
            this.bHp.iC();
            this.bHp.setContentDescription(String.valueOf(this.mContext.getString(u.j.image_show_setting)) + this.mContext.getString(u.j.now_state_off));
        }
        this.bHp.setOnSwitchStateChangeListener(this.bHE);
    }

    public void a(cx cxVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bHq.setVisibility(4);
            this.bHD = 0L;
            return;
        }
        if (cxVar != null) {
            j = cxVar.WT() - cxVar.WU();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                j -= cxVar.WV();
            }
        }
        this.bHD = j;
        c(this.bHq, j);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.av.k(textView, u.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.av.k(textView, u.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.av.k(textView, u.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.Do.setOnClickListener(onClickListener);
        this.bHs.setOnClickListener(onClickListener);
        this.bHt.setOnClickListener(onClickListener);
        this.bHu.setOnClickListener(onClickListener);
        this.bHx.setOnClickListener(onClickListener);
        this.bHy.setOnClickListener(onClickListener);
        this.bHr.setOnClickListener(onClickListener);
        this.bHz.setOnClickListener(onClickListener);
        this.bHA.setOnClickListener(onClickListener);
        this.bHB.setOnClickListener(onClickListener);
        this.bHv.setOnClickListener(onClickListener);
        this.bHw.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.w(this.Do);
        c(this.bHq, this.bHD);
        if (i == 1) {
            this.bHm.iB();
            this.bHm.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_on));
        } else {
            this.bHm.iC();
            this.bHm.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_off));
        }
        this.Do.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cB(u.f.s_rightbar_bg)));
        this.bHm.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bHo.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bHp.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
    }
}
