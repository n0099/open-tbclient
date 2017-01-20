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
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cn extends com.baidu.adp.base.e<FrsActivity> {
    private View Fo;
    private LinearLayout aCL;
    private View bJA;
    private TextView bJB;
    private TextView bJC;
    private TextView bJD;
    private boolean bJE;
    private long bJF;
    private boolean bJm;
    private FrameLayout bJn;
    private BdSwitchView bJo;
    private FrameLayout bJp;
    private BdSwitchView bJq;
    private BdSwitchView bJr;
    private BdSwitchView bJs;
    private TextView bJt;
    private LinearLayout bJu;
    private LinearLayout bJv;
    private TextView bJw;
    private TextView bJx;
    private TextView bJy;
    private TextView bJz;

    public cn(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.Fo = null;
        this.bJn = null;
        this.bJo = null;
        this.bJp = null;
        this.bJq = null;
        this.bJr = null;
        this.bJs = null;
        this.bJt = null;
        this.bJu = null;
        this.bJv = null;
        this.bJw = null;
        this.bJx = null;
        this.bJy = null;
        this.bJz = null;
        this.bJF = 0L;
        this.aCL = new LinearLayout(this.mContext.getPageActivity());
    }

    public View getView() {
        return this.aCL;
    }

    public void Zi() {
        this.Fo = LayoutInflater.from(this.mContext.getPageActivity()).inflate(r.j.frs_sidebar, (ViewGroup) null);
        this.aCL.removeAllViews();
        this.aCL.addView(this.Fo);
        this.bJu = (LinearLayout) this.Fo.findViewById(r.h.post_search_ll);
        this.bJr = (BdSwitchView) this.Fo.findViewById(r.h.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bJr, 10, 10, 10, 10);
        this.bJn = (FrameLayout) this.Fo.findViewById(r.h.eyeshield_mode);
        this.bJo = (BdSwitchView) this.Fo.findViewById(r.h.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bJo, 10, 10, 10, 10);
        this.bJp = (FrameLayout) this.Fo.findViewById(r.h.frequently_forum_switch);
        this.bJq = (BdSwitchView) this.Fo.findViewById(r.h.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bJq, 10, 10, 10, 10);
        this.bJs = (BdSwitchView) this.Fo.findViewById(r.h.switch_guess_like);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bJs, 10, 10, 10, 10);
        this.bJt = (TextView) this.Fo.findViewById(r.h.message_btn);
        this.bJv = (LinearLayout) this.Fo.findViewById(r.h.message_layout);
        this.bJw = (TextView) this.Fo.findViewById(r.h.history_tv);
        this.bJx = (TextView) this.Fo.findViewById(r.h.bar_info_tv);
        this.bJy = (TextView) this.Fo.findViewById(r.h.forum_member);
        this.bJz = (TextView) this.Fo.findViewById(r.h.frs_group);
        this.bJB = (TextView) this.Fo.findViewById(r.h.frs_sidebar_good_tv);
        this.bJD = (TextView) this.Fo.findViewById(r.h.bar_share_tv);
        this.bJC = (TextView) this.Fo.findViewById(r.h.frs_sidebar_add_to_desktop);
        this.bJA = this.Fo.findViewById(r.h.unfollow_layout);
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bJw.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bJx.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bJy.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bJz.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bJB.setVisibility(8);
        }
        if (!Zk()) {
            this.bJn.setVisibility(8);
            this.bJo.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.Fo).addView(createStateBarFillView(), 0);
        }
        Zj();
        this.bJm = true;
    }

    private void Zj() {
        Zq();
        Zr();
        dR(b.tQ().getBoolean(b.cP("frs_guess_like_switch"), true));
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.Fo != null) {
            this.Fo.setBackgroundDrawable(null);
        }
        if (this.aCL != null) {
            this.aCL.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean Zk() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dO(boolean z) {
        if (this.bJA != null) {
            this.bJA.setVisibility(z ? 0 : 8);
        }
    }

    public void dP(boolean z) {
        if (this.bJp != null) {
            this.bJp.setVisibility(z ? 0 : 8);
        }
    }

    public BdSwitchView Zl() {
        return this.bJo;
    }

    public BdSwitchView Zm() {
        return this.bJq;
    }

    public BdSwitchView Zn() {
        return this.bJs;
    }

    public BdSwitchView Zo() {
        return this.bJr;
    }

    public boolean Zp() {
        return this.bJE;
    }

    public void dQ(boolean z) {
        this.bJE = z;
    }

    private void Zq() {
        if (this.bJo != null) {
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.bJo.jt();
                this.bJo.setContentDescription(String.valueOf(this.mContext.getString(r.l.eyeshield_mode)) + this.mContext.getString(r.l.now_state_on));
                return;
            }
            this.bJo.ju();
            this.bJo.setContentDescription(String.valueOf(this.mContext.getString(r.l.eyeshield_mode)) + this.mContext.getString(r.l.now_state_off));
        }
    }

    private void Zr() {
        if (this.bJr != null) {
            if (com.baidu.tbadk.core.l.oC().oI()) {
                this.bJr.jt();
                this.bJr.setContentDescription(String.valueOf(this.mContext.getString(r.l.image_show_setting)) + this.mContext.getString(r.l.now_state_on));
                return;
            }
            this.bJr.ju();
            this.bJr.setContentDescription(String.valueOf(this.mContext.getString(r.l.image_show_setting)) + this.mContext.getString(r.l.now_state_off));
        }
    }

    private void dR(boolean z) {
        if (this.bJs != null) {
            if (z) {
                this.bJs.jt();
                this.bJs.setContentDescription(String.valueOf(this.mContext.getString(r.l.frs_guess_like)) + this.mContext.getString(r.l.now_state_on));
                return;
            }
            this.bJs.ju();
            this.bJs.setContentDescription(String.valueOf(this.mContext.getString(r.l.frs_guess_like)) + this.mContext.getString(r.l.now_state_off));
        }
    }

    public void a(boolean z, BdSwitchView.a aVar) {
        if (this.bJq != null) {
            this.bJq.setOnSwitchStateChangeListener(null);
            if (z) {
                this.bJq.jt();
                this.bJq.setContentDescription(String.valueOf(this.mContext.getString(r.l.frequently_forum_setting)) + this.mContext.getString(r.l.now_state_on));
            } else {
                this.bJq.ju();
                this.bJq.setContentDescription(String.valueOf(this.mContext.getString(r.l.frequently_forum_setting)) + this.mContext.getString(r.l.now_state_on));
            }
            this.bJq.setOnSwitchStateChangeListener(aVar);
        }
    }

    public void a(bo boVar, boolean z) {
        long j = 0;
        if (this.bJt != null) {
            if (!z) {
                this.bJt.setVisibility(4);
                this.bJF = 0L;
                return;
            }
            if (boVar != null) {
                j = boVar.Zb() - boVar.Zc();
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().zk()) {
                    j -= boVar.Zd();
                }
            }
            this.bJF = j;
            d(this.bJt, j);
        }
    }

    private void d(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ap.j((View) textView, r.g.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ap.j((View) textView, r.g.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.ap.j((View) textView, r.g.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (!this.bJm) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.bJr.setOnSwitchStateChangeListener(aVar);
        this.bJs.setOnSwitchStateChangeListener(aVar);
        this.bJo.setOnSwitchStateChangeListener(aVar);
        this.bJq.setOnSwitchStateChangeListener(aVar);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        if (!this.bJm) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.Fo.setOnClickListener(onClickListener);
        this.bJv.setOnClickListener(onClickListener);
        this.bJw.setOnClickListener(onClickListener);
        this.bJx.setOnClickListener(onClickListener);
        this.bJA.setOnClickListener(onClickListener);
        this.bJu.setOnClickListener(onClickListener);
        this.bJB.setOnClickListener(onClickListener);
        this.bJC.setOnClickListener(onClickListener);
        this.bJD.setOnClickListener(onClickListener);
        this.bJy.setOnClickListener(onClickListener);
        this.bJz.setOnClickListener(onClickListener);
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = tbPageContext.getLayoutMode();
        layoutMode.ai(i == 1);
        if (this.aCL != null) {
            layoutMode.v(this.aCL);
            this.aCL.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ap.cQ(r.g.s_rightbar_bg)));
        }
        if (this.bJt != null) {
            d(this.bJt, this.bJF);
        }
        if (this.bJo != null) {
            if (i == 1) {
                this.bJo.jt();
                this.bJo.setContentDescription(String.valueOf(this.mContext.getString(r.l.eyeshield_mode)) + this.mContext.getString(r.l.now_state_on));
            } else {
                this.bJo.ju();
                this.bJo.setContentDescription(String.valueOf(this.mContext.getString(r.l.eyeshield_mode)) + this.mContext.getString(r.l.now_state_off));
            }
            this.bJo.a(com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_open_bg), com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_close_bg), com.baidu.tbadk.core.util.ap.cP(r.g.btn_game_handle_2));
        }
        if (this.bJq != null) {
            this.bJq.a(com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_open_bg), com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_close_bg), com.baidu.tbadk.core.util.ap.cP(r.g.btn_game_handle_2));
        }
        if (this.bJr != null) {
            this.bJr.a(com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_open_bg), com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_close_bg), com.baidu.tbadk.core.util.ap.cP(r.g.btn_game_handle_2));
        }
        if (this.bJs != null) {
            this.bJs.a(com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_open_bg), com.baidu.tbadk.core.util.ap.cP(r.g.s_switch_close_bg), com.baidu.tbadk.core.util.ap.cP(r.g.btn_game_handle_2));
        }
    }
}
