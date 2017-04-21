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
public class cp extends com.baidu.adp.base.e<FrsActivity> {
    private LinearLayout aIA;
    private View aXo;
    private boolean bSB;
    private FrameLayout bSC;
    private BdSwitchView bSD;
    private FrameLayout bSE;
    private BdSwitchView bSF;
    private BdSwitchView bSG;
    private TextView bSH;
    private LinearLayout bSI;
    private LinearLayout bSJ;
    private TextView bSK;
    private TextView bSL;
    private TextView bSM;
    private View bSN;
    private TextView bSO;
    private TextView bSP;
    private boolean bSQ;
    private long bSR;

    public cp(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aXo = null;
        this.bSC = null;
        this.bSD = null;
        this.bSE = null;
        this.bSF = null;
        this.bSG = null;
        this.bSH = null;
        this.bSI = null;
        this.bSJ = null;
        this.bSK = null;
        this.bSL = null;
        this.bSM = null;
        this.bSR = 0L;
        this.aIA = new LinearLayout(this.mContext.getPageActivity());
    }

    public View getView() {
        return this.aIA;
    }

    public void abG() {
        this.aXo = LayoutInflater.from(this.mContext.getPageActivity()).inflate(w.j.frs_sidebar, (ViewGroup) null);
        this.aIA.removeAllViews();
        this.aIA.addView(this.aXo);
        this.bSI = (LinearLayout) this.aXo.findViewById(w.h.post_search_ll);
        this.bSC = (FrameLayout) this.aXo.findViewById(w.h.eyeshield_mode);
        this.bSD = (BdSwitchView) this.aXo.findViewById(w.h.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bSD, 10, 10, 10, 10);
        this.bSE = (FrameLayout) this.aXo.findViewById(w.h.frequently_forum_switch);
        this.bSF = (BdSwitchView) this.aXo.findViewById(w.h.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bSF, 10, 10, 10, 10);
        this.bSG = (BdSwitchView) this.aXo.findViewById(w.h.switch_guess_like);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bSG, 10, 10, 10, 10);
        this.bSH = (TextView) this.aXo.findViewById(w.h.message_btn);
        this.bSJ = (LinearLayout) this.aXo.findViewById(w.h.message_layout);
        this.bSK = (TextView) this.aXo.findViewById(w.h.history_tv);
        this.bSL = (TextView) this.aXo.findViewById(w.h.forum_member);
        this.bSM = (TextView) this.aXo.findViewById(w.h.frs_group);
        this.bSP = (TextView) this.aXo.findViewById(w.h.bar_share_tv);
        this.bSO = (TextView) this.aXo.findViewById(w.h.frs_sidebar_add_to_desktop);
        this.bSN = this.aXo.findViewById(w.h.unfollow_layout);
        if (com.baidu.adp.lib.b.e.eZ().Y("android_share_forum") == 1) {
            this.bSP.setVisibility(0);
        } else {
            this.bSP.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.e.eZ().Y("android_add_to_desk") == 1) {
            this.bSO.setVisibility(0);
        } else {
            this.bSO.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bSK.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bSL.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bSM.setVisibility(8);
        }
        if (!abI()) {
            this.bSC.setVisibility(8);
            this.bSD.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.aXo).addView(createStateBarFillView(), 0);
        }
        abH();
        this.bSB = true;
    }

    private void abH() {
        abN();
        ed(b.uL().getBoolean(b.cP("frs_guess_like_switch"), true));
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.aXo != null) {
            this.aXo.setBackgroundDrawable(null);
        }
        if (this.aIA != null) {
            this.aIA.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean abI() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void ea(boolean z) {
        if (this.bSN != null) {
            this.bSN.setVisibility(z ? 0 : 8);
        }
    }

    public void eb(boolean z) {
        if (this.bSE != null) {
            this.bSE.setVisibility(z ? 0 : 8);
        }
    }

    public BdSwitchView abJ() {
        return this.bSD;
    }

    public BdSwitchView abK() {
        return this.bSF;
    }

    public BdSwitchView abL() {
        return this.bSG;
    }

    public boolean abM() {
        return this.bSQ;
    }

    public void ec(boolean z) {
        this.bSQ = z;
    }

    private void abN() {
        if (this.bSD != null) {
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.bSD.ks();
                this.bSD.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_on));
                return;
            }
            this.bSD.kt();
            this.bSD.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_off));
        }
    }

    private void ed(boolean z) {
        if (this.bSG != null) {
            if (z) {
                this.bSG.ks();
                this.bSG.setContentDescription(String.valueOf(this.mContext.getString(w.l.frs_guess_like)) + this.mContext.getString(w.l.now_state_on));
                return;
            }
            this.bSG.kt();
            this.bSG.setContentDescription(String.valueOf(this.mContext.getString(w.l.frs_guess_like)) + this.mContext.getString(w.l.now_state_off));
        }
    }

    public void a(boolean z, BdSwitchView.a aVar) {
        if (this.bSF != null) {
            this.bSF.setOnSwitchStateChangeListener(null);
            if (z) {
                this.bSF.ks();
                this.bSF.setContentDescription(String.valueOf(this.mContext.getString(w.l.frequently_forum_setting)) + this.mContext.getString(w.l.now_state_on));
            } else {
                this.bSF.kt();
                this.bSF.setContentDescription(String.valueOf(this.mContext.getString(w.l.frequently_forum_setting)) + this.mContext.getString(w.l.now_state_on));
            }
            this.bSF.setOnSwitchStateChangeListener(aVar);
        }
    }

    public void a(bq bqVar, boolean z) {
        long j = 0;
        if (this.bSH != null) {
            if (!z) {
                this.bSH.setVisibility(4);
                this.bSR = 0L;
                return;
            }
            if (bqVar != null) {
                j = bqVar.abz() - bqVar.abA();
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().Aa()) {
                    j -= bqVar.abB();
                }
            }
            this.bSR = j;
            d(this.bSH, j);
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
        if (!this.bSB) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.bSG.setOnSwitchStateChangeListener(aVar);
        this.bSD.setOnSwitchStateChangeListener(aVar);
        this.bSF.setOnSwitchStateChangeListener(aVar);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        if (!this.bSB) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.aXo.setOnClickListener(onClickListener);
        this.bSJ.setOnClickListener(onClickListener);
        this.bSK.setOnClickListener(onClickListener);
        this.bSN.setOnClickListener(onClickListener);
        this.bSI.setOnClickListener(onClickListener);
        this.bSO.setOnClickListener(onClickListener);
        this.bSP.setOnClickListener(onClickListener);
        this.bSL.setOnClickListener(onClickListener);
        this.bSM.setOnClickListener(onClickListener);
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = tbPageContext.getLayoutMode();
        layoutMode.aj(i == 1);
        if (this.aIA != null) {
            layoutMode.t(this.aIA);
            this.aIA.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cP(w.g.s_rightbar_bg)));
        }
        if (this.bSH != null) {
            d(this.bSH, this.bSR);
        }
        if (this.bSD != null) {
            if (i == 1) {
                this.bSD.ks();
                this.bSD.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_on));
            } else {
                this.bSD.kt();
                this.bSD.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_off));
            }
            this.bSD.a(com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cO(w.g.btn_game_handle_2));
        }
        if (this.bSF != null) {
            this.bSF.a(com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cO(w.g.btn_game_handle_2));
        }
        if (this.bSG != null) {
            this.bSG.a(com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cO(w.g.btn_game_handle_2));
        }
    }
}
