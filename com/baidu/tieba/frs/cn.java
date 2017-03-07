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
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cn extends com.baidu.adp.base.e<FrsActivity> {
    private LinearLayout aIi;
    private View aWX;
    private BdSwitchView bQA;
    private TextView bQB;
    private LinearLayout bQC;
    private LinearLayout bQD;
    private TextView bQE;
    private TextView bQF;
    private TextView bQG;
    private View bQH;
    private TextView bQI;
    private TextView bQJ;
    private boolean bQK;
    private long bQL;
    private boolean bQv;
    private FrameLayout bQw;
    private BdSwitchView bQx;
    private FrameLayout bQy;
    private BdSwitchView bQz;

    public cn(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aWX = null;
        this.bQw = null;
        this.bQx = null;
        this.bQy = null;
        this.bQz = null;
        this.bQA = null;
        this.bQB = null;
        this.bQC = null;
        this.bQD = null;
        this.bQE = null;
        this.bQF = null;
        this.bQG = null;
        this.bQL = 0L;
        this.aIi = new LinearLayout(this.mContext.getPageActivity());
    }

    public View getView() {
        return this.aIi;
    }

    public void aah() {
        this.aWX = LayoutInflater.from(this.mContext.getPageActivity()).inflate(w.j.frs_sidebar, (ViewGroup) null);
        this.aIi.removeAllViews();
        this.aIi.addView(this.aWX);
        this.bQC = (LinearLayout) this.aWX.findViewById(w.h.post_search_ll);
        this.bQw = (FrameLayout) this.aWX.findViewById(w.h.eyeshield_mode);
        this.bQx = (BdSwitchView) this.aWX.findViewById(w.h.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bQx, 10, 10, 10, 10);
        this.bQy = (FrameLayout) this.aWX.findViewById(w.h.frequently_forum_switch);
        this.bQz = (BdSwitchView) this.aWX.findViewById(w.h.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bQz, 10, 10, 10, 10);
        this.bQA = (BdSwitchView) this.aWX.findViewById(w.h.switch_guess_like);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bQA, 10, 10, 10, 10);
        this.bQB = (TextView) this.aWX.findViewById(w.h.message_btn);
        this.bQD = (LinearLayout) this.aWX.findViewById(w.h.message_layout);
        this.bQE = (TextView) this.aWX.findViewById(w.h.history_tv);
        this.bQF = (TextView) this.aWX.findViewById(w.h.forum_member);
        this.bQG = (TextView) this.aWX.findViewById(w.h.frs_group);
        this.bQJ = (TextView) this.aWX.findViewById(w.h.bar_share_tv);
        this.bQI = (TextView) this.aWX.findViewById(w.h.frs_sidebar_add_to_desktop);
        this.bQH = this.aWX.findViewById(w.h.unfollow_layout);
        if (com.baidu.adp.lib.b.e.eT().ab("android_share_forum") == 1) {
            this.bQJ.setVisibility(0);
        } else {
            this.bQJ.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.e.eT().ab("android_add_to_desk") == 1) {
            this.bQI.setVisibility(0);
        } else {
            this.bQI.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bQE.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bQF.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bQG.setVisibility(8);
        }
        if (!aaj()) {
            this.bQw.setVisibility(8);
            this.bQx.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.aWX).addView(createStateBarFillView(), 0);
        }
        aai();
        this.bQv = true;
    }

    private void aai() {
        aao();
        dR(b.uo().getBoolean(b.cI("frs_guess_like_switch"), true));
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.aWX != null) {
            this.aWX.setBackgroundDrawable(null);
        }
        if (this.aIi != null) {
            this.aIi.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean aaj() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dO(boolean z) {
        if (this.bQH != null) {
            this.bQH.setVisibility(z ? 0 : 8);
        }
    }

    public void dP(boolean z) {
        if (this.bQy != null) {
            this.bQy.setVisibility(z ? 0 : 8);
        }
    }

    public BdSwitchView aak() {
        return this.bQx;
    }

    public BdSwitchView aal() {
        return this.bQz;
    }

    public BdSwitchView aam() {
        return this.bQA;
    }

    public boolean aan() {
        return this.bQK;
    }

    public void dQ(boolean z) {
        this.bQK = z;
    }

    private void aao() {
        if (this.bQx != null) {
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.bQx.kn();
                this.bQx.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_on));
                return;
            }
            this.bQx.ko();
            this.bQx.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_off));
        }
    }

    private void dR(boolean z) {
        if (this.bQA != null) {
            if (z) {
                this.bQA.kn();
                this.bQA.setContentDescription(String.valueOf(this.mContext.getString(w.l.frs_guess_like)) + this.mContext.getString(w.l.now_state_on));
                return;
            }
            this.bQA.ko();
            this.bQA.setContentDescription(String.valueOf(this.mContext.getString(w.l.frs_guess_like)) + this.mContext.getString(w.l.now_state_off));
        }
    }

    public void a(boolean z, BdSwitchView.a aVar) {
        if (this.bQz != null) {
            this.bQz.setOnSwitchStateChangeListener(null);
            if (z) {
                this.bQz.kn();
                this.bQz.setContentDescription(String.valueOf(this.mContext.getString(w.l.frequently_forum_setting)) + this.mContext.getString(w.l.now_state_on));
            } else {
                this.bQz.ko();
                this.bQz.setContentDescription(String.valueOf(this.mContext.getString(w.l.frequently_forum_setting)) + this.mContext.getString(w.l.now_state_on));
            }
            this.bQz.setOnSwitchStateChangeListener(aVar);
        }
    }

    public void a(bo boVar, boolean z) {
        long j = 0;
        if (this.bQB != null) {
            if (!z) {
                this.bQB.setVisibility(4);
                this.bQL = 0L;
                return;
            }
            if (boVar != null) {
                j = boVar.aaa() - boVar.aab();
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zB()) {
                    j -= boVar.aac();
                }
            }
            this.bQL = j;
            d(this.bQB, j);
        }
    }

    private void d(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.aq.j(textView, w.g.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.aq.j(textView, w.g.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.aq.j(textView, w.g.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (!this.bQv) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.bQA.setOnSwitchStateChangeListener(aVar);
        this.bQx.setOnSwitchStateChangeListener(aVar);
        this.bQz.setOnSwitchStateChangeListener(aVar);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        if (!this.bQv) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.aWX.setOnClickListener(onClickListener);
        this.bQD.setOnClickListener(onClickListener);
        this.bQE.setOnClickListener(onClickListener);
        this.bQH.setOnClickListener(onClickListener);
        this.bQC.setOnClickListener(onClickListener);
        this.bQI.setOnClickListener(onClickListener);
        this.bQJ.setOnClickListener(onClickListener);
        this.bQF.setOnClickListener(onClickListener);
        this.bQG.setOnClickListener(onClickListener);
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = tbPageContext.getLayoutMode();
        layoutMode.ah(i == 1);
        if (this.aIi != null) {
            layoutMode.t(this.aIi);
            this.aIi.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cM(w.g.s_rightbar_bg)));
        }
        if (this.bQB != null) {
            d(this.bQB, this.bQL);
        }
        if (this.bQx != null) {
            if (i == 1) {
                this.bQx.kn();
                this.bQx.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_on));
            } else {
                this.bQx.ko();
                this.bQx.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_off));
            }
            this.bQx.a(com.baidu.tbadk.core.util.aq.cL(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cL(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cL(w.g.btn_game_handle_2));
        }
        if (this.bQz != null) {
            this.bQz.a(com.baidu.tbadk.core.util.aq.cL(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cL(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cL(w.g.btn_game_handle_2));
        }
        if (this.bQA != null) {
            this.bQA.a(com.baidu.tbadk.core.util.aq.cL(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cL(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cL(w.g.btn_game_handle_2));
        }
    }
}
