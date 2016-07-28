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
    private View DP;
    private FrameLayout bIH;
    private BdSwitchView bII;
    private FrameLayout bIJ;
    private BdSwitchView bIK;
    private BdSwitchView bIL;
    private TextView bIM;
    private LinearLayout bIN;
    private LinearLayout bIO;
    private TextView bIP;
    private TextView bIQ;
    private TextView bIR;
    private TextView bIS;
    public TextView bIT;
    private View bIU;
    private TextView bIV;
    private TextView bIW;
    private TextView bIX;
    private boolean bIY;
    private long bIZ;
    private final BdSwitchView.a bJa;

    public dw(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bIH = null;
        this.bII = null;
        this.bIJ = null;
        this.bIK = null;
        this.bIL = null;
        this.DP = null;
        this.bIM = null;
        this.bIN = null;
        this.bIO = null;
        this.bIP = null;
        this.bIQ = null;
        this.bIR = null;
        this.bIS = null;
        this.bIT = null;
        this.bIZ = 0L;
        this.bJa = new dx(this);
        initUI();
    }

    public View getView() {
        return this.DP;
    }

    public void init() {
        XJ();
        XK();
    }

    private void initUI() {
        this.DP = LayoutInflater.from(this.mContext.getPageActivity()).inflate(u.h.frs_sidebar, (ViewGroup) null);
        this.bIN = (LinearLayout) this.DP.findViewById(u.g.post_search_ll);
        this.bIT = (TextView) this.DP.findViewById(u.g.forum_manager_center);
        this.bIT.setVisibility(8);
        this.bIL = (BdSwitchView) this.DP.findViewById(u.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bIL, 10, 10, 10, 10);
        this.bIH = (FrameLayout) this.DP.findViewById(u.g.eyeshield_mode);
        this.bII = (BdSwitchView) this.DP.findViewById(u.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bII, 10, 10, 10, 10);
        this.bII.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bIJ = (FrameLayout) this.DP.findViewById(u.g.frequently_forum_switch);
        this.bIK = (BdSwitchView) this.DP.findViewById(u.g.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bIK, 10, 10, 10, 10);
        this.bIK.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bIL.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bIM = (TextView) this.DP.findViewById(u.g.message_btn);
        this.bIO = (LinearLayout) this.DP.findViewById(u.g.message_layout);
        this.bIP = (TextView) this.DP.findViewById(u.g.history_tv);
        this.bIQ = (TextView) this.DP.findViewById(u.g.bar_info_tv);
        this.bIR = (TextView) this.DP.findViewById(u.g.forum_member);
        this.bIS = (TextView) this.DP.findViewById(u.g.frs_group);
        this.bIV = (TextView) this.DP.findViewById(u.g.frs_sidebar_good_tv);
        this.bIX = (TextView) this.DP.findViewById(u.g.bar_share_tv);
        this.bIW = (TextView) this.DP.findViewById(u.g.frs_sidebar_add_to_desktop);
        this.bIU = this.DP.findViewById(u.g.unfollow_layout);
        if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bIP.setVisibility(8);
        }
        if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bIQ.setVisibility(8);
        }
        if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bIR.setVisibility(8);
        }
        if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bIS.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bIV.setVisibility(8);
        }
        if (!XE()) {
            this.bIH.setVisibility(8);
            this.bII.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.DP).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.DP != null) {
            this.DP.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean XE() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dt(boolean z) {
        this.bIU.setVisibility(z ? 0 : 8);
    }

    public void du(boolean z) {
        if (z) {
            this.bIK.iA();
        } else {
            this.bIK.iB();
        }
    }

    public FrameLayout XF() {
        return this.bIJ;
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.bIT.setVisibility(0);
        } else {
            this.bIT.setVisibility(8);
        }
    }

    public BdSwitchView XG() {
        return this.bII;
    }

    public BdSwitchView XH() {
        return this.bIK;
    }

    public boolean XI() {
        return this.bIY;
    }

    public void dv(boolean z) {
        this.bIY = z;
    }

    public void XJ() {
        if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
            this.bII.iA();
            this.bII.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_on));
            return;
        }
        this.bII.iB();
        this.bII.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_off));
    }

    public void XK() {
        this.bIL.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.nL().nR()) {
            this.bIL.iA();
            this.bIL.setContentDescription(String.valueOf(this.mContext.getString(u.j.image_show_setting)) + this.mContext.getString(u.j.now_state_on));
        } else {
            this.bIL.iB();
            this.bIL.setContentDescription(String.valueOf(this.mContext.getString(u.j.image_show_setting)) + this.mContext.getString(u.j.now_state_off));
        }
        this.bIL.setOnSwitchStateChangeListener(this.bJa);
    }

    public void a(cx cxVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bIM.setVisibility(4);
            this.bIZ = 0L;
            return;
        }
        if (cxVar != null) {
            j = cxVar.Xl() - cxVar.Xm();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                j -= cxVar.Xn();
            }
        }
        this.bIZ = j;
        c(this.bIM, j);
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
        this.DP.setOnClickListener(onClickListener);
        this.bIO.setOnClickListener(onClickListener);
        this.bIP.setOnClickListener(onClickListener);
        this.bIQ.setOnClickListener(onClickListener);
        this.bIT.setOnClickListener(onClickListener);
        this.bIU.setOnClickListener(onClickListener);
        this.bIN.setOnClickListener(onClickListener);
        this.bIV.setOnClickListener(onClickListener);
        this.bIW.setOnClickListener(onClickListener);
        this.bIX.setOnClickListener(onClickListener);
        this.bIR.setOnClickListener(onClickListener);
        this.bIS.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.af(i == 1);
        layoutMode.w(this.DP);
        c(this.bIM, this.bIZ);
        if (i == 1) {
            this.bII.iA();
            this.bII.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_on));
        } else {
            this.bII.iB();
            this.bII.setContentDescription(String.valueOf(this.mContext.getString(u.j.eyeshield_mode)) + this.mContext.getString(u.j.now_state_off));
        }
        this.DP.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cB(u.f.s_rightbar_bg)));
        this.bII.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bIK.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
        this.bIL.a(com.baidu.tbadk.core.util.av.cA(u.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cA(u.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cA(u.f.btn_game_handle_2));
    }
}
