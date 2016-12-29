package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.f;
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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cp extends f<FrsActivity> {
    private View Ge;
    private FrameLayout bBU;
    private BdSwitchView bBV;
    private FrameLayout bBW;
    private BdSwitchView bBX;
    private BdSwitchView bBY;
    private BdSwitchView bBZ;
    private TextView bCa;
    private LinearLayout bCb;
    private LinearLayout bCc;
    private TextView bCd;
    private TextView bCe;
    private TextView bCf;
    private TextView bCg;
    private View bCh;
    private TextView bCi;
    private TextView bCj;
    private TextView bCk;
    private boolean bCl;
    private long bCm;
    private final BdSwitchView.a bCn;
    private final BdSwitchView.a bCo;

    public cp(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bBU = null;
        this.bBV = null;
        this.bBW = null;
        this.bBX = null;
        this.bBY = null;
        this.bBZ = null;
        this.Ge = null;
        this.bCa = null;
        this.bCb = null;
        this.bCc = null;
        this.bCd = null;
        this.bCe = null;
        this.bCf = null;
        this.bCg = null;
        this.bCm = 0L;
        this.bCn = new cq(this);
        this.bCo = new cr(this);
        initUI();
    }

    public View getView() {
        return this.Ge;
    }

    public void init() {
        Yh();
        Yi();
        dL(com.baidu.tbadk.core.sharedPref.b.tW().getBoolean(com.baidu.tbadk.core.sharedPref.b.cR("frs_guess_like_switch"), true));
    }

    private void initUI() {
        this.Ge = LayoutInflater.from(this.mContext.getPageActivity()).inflate(r.h.frs_sidebar, (ViewGroup) null);
        this.bCb = (LinearLayout) this.Ge.findViewById(r.g.post_search_ll);
        this.bBY = (BdSwitchView) this.Ge.findViewById(r.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bBY, 10, 10, 10, 10);
        this.bBY.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bBU = (FrameLayout) this.Ge.findViewById(r.g.eyeshield_mode);
        this.bBV = (BdSwitchView) this.Ge.findViewById(r.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bBV, 10, 10, 10, 10);
        this.bBV.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bBW = (FrameLayout) this.Ge.findViewById(r.g.frequently_forum_switch);
        this.bBX = (BdSwitchView) this.Ge.findViewById(r.g.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bBX, 10, 10, 10, 10);
        this.bBX.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bBZ = (BdSwitchView) this.Ge.findViewById(r.g.switch_guess_like);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bBZ, 10, 10, 10, 10);
        this.bBZ.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bCa = (TextView) this.Ge.findViewById(r.g.message_btn);
        this.bCc = (LinearLayout) this.Ge.findViewById(r.g.message_layout);
        this.bCd = (TextView) this.Ge.findViewById(r.g.history_tv);
        this.bCe = (TextView) this.Ge.findViewById(r.g.bar_info_tv);
        this.bCf = (TextView) this.Ge.findViewById(r.g.forum_member);
        this.bCg = (TextView) this.Ge.findViewById(r.g.frs_group);
        this.bCi = (TextView) this.Ge.findViewById(r.g.frs_sidebar_good_tv);
        this.bCk = (TextView) this.Ge.findViewById(r.g.bar_share_tv);
        this.bCj = (TextView) this.Ge.findViewById(r.g.frs_sidebar_add_to_desktop);
        this.bCh = this.Ge.findViewById(r.g.unfollow_layout);
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bCd.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bCe.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bCf.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bCg.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bCi.setVisibility(8);
        }
        if (!Yb()) {
            this.bBU.setVisibility(8);
            this.bBV.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.Ge).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.Ge != null) {
            this.Ge.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean Yb() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dI(boolean z) {
        this.bCh.setVisibility(z ? 0 : 8);
    }

    public void dJ(boolean z) {
        if (z) {
            this.bBX.jv();
        } else {
            this.bBX.jw();
        }
    }

    public FrameLayout Yc() {
        return this.bBW;
    }

    public BdSwitchView Yd() {
        return this.bBV;
    }

    public BdSwitchView Ye() {
        return this.bBX;
    }

    public BdSwitchView Yf() {
        return this.bBZ;
    }

    public boolean Yg() {
        return this.bCl;
    }

    public void dK(boolean z) {
        this.bCl = z;
    }

    public void Yh() {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.bBV.jv();
            this.bBV.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_on));
            return;
        }
        this.bBV.jw();
        this.bBV.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_off));
    }

    public void Yi() {
        this.bBY.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.oJ().oP()) {
            this.bBY.jv();
            this.bBY.setContentDescription(String.valueOf(this.mContext.getString(r.j.image_show_setting)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bBY.jw();
            this.bBY.setContentDescription(String.valueOf(this.mContext.getString(r.j.image_show_setting)) + this.mContext.getString(r.j.now_state_off));
        }
        this.bBY.setOnSwitchStateChangeListener(this.bCn);
    }

    public void dL(boolean z) {
        this.bBZ.setOnSwitchStateChangeListener(null);
        if (z) {
            this.bBZ.jv();
            this.bBZ.setContentDescription(String.valueOf(this.mContext.getString(r.j.frs_guess_like)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bBZ.jw();
            this.bBZ.setContentDescription(String.valueOf(this.mContext.getString(r.j.frs_guess_like)) + this.mContext.getString(r.j.now_state_off));
        }
        this.bBZ.setOnSwitchStateChangeListener(this.bCo);
    }

    public void a(bq bqVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bCa.setVisibility(4);
            this.bCm = 0L;
            return;
        }
        if (bqVar != null) {
            j = bqVar.XU() - bqVar.XV();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zp()) {
                j -= bqVar.XW();
            }
        }
        this.bCm = j;
        d(this.bCa, j);
    }

    private void d(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ar.k(textView, r.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ar.k(textView, r.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.ar.k(textView, r.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.Ge.setOnClickListener(onClickListener);
        this.bCc.setOnClickListener(onClickListener);
        this.bCd.setOnClickListener(onClickListener);
        this.bCe.setOnClickListener(onClickListener);
        this.bCh.setOnClickListener(onClickListener);
        this.bCb.setOnClickListener(onClickListener);
        this.bCi.setOnClickListener(onClickListener);
        this.bCj.setOnClickListener(onClickListener);
        this.bCk.setOnClickListener(onClickListener);
        this.bCf.setOnClickListener(onClickListener);
        this.bCg.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ai(i == 1);
        layoutMode.x(this.Ge);
        d(this.bCa, this.bCm);
        this.Ge.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ar.cR(r.f.s_rightbar_bg)));
        if (i == 1) {
            this.bBV.jv();
            this.bBV.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bBV.jw();
            this.bBV.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_off));
        }
        this.bBV.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bBX.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bBY.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
        this.bBZ.a(com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cQ(r.f.btn_game_handle_2));
    }
}
