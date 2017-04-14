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
    private LinearLayout aIy;
    private View aXl;
    private long bQA;
    private boolean bQk;
    private FrameLayout bQl;
    private BdSwitchView bQm;
    private FrameLayout bQn;
    private BdSwitchView bQo;
    private BdSwitchView bQp;
    private TextView bQq;
    private LinearLayout bQr;
    private LinearLayout bQs;
    private TextView bQt;
    private TextView bQu;
    private TextView bQv;
    private View bQw;
    private TextView bQx;
    private TextView bQy;
    private boolean bQz;

    public cp(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aXl = null;
        this.bQl = null;
        this.bQm = null;
        this.bQn = null;
        this.bQo = null;
        this.bQp = null;
        this.bQq = null;
        this.bQr = null;
        this.bQs = null;
        this.bQt = null;
        this.bQu = null;
        this.bQv = null;
        this.bQA = 0L;
        this.aIy = new LinearLayout(this.mContext.getPageActivity());
    }

    public View getView() {
        return this.aIy;
    }

    public void aaF() {
        this.aXl = LayoutInflater.from(this.mContext.getPageActivity()).inflate(w.j.frs_sidebar, (ViewGroup) null);
        this.aIy.removeAllViews();
        this.aIy.addView(this.aXl);
        this.bQr = (LinearLayout) this.aXl.findViewById(w.h.post_search_ll);
        this.bQl = (FrameLayout) this.aXl.findViewById(w.h.eyeshield_mode);
        this.bQm = (BdSwitchView) this.aXl.findViewById(w.h.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bQm, 10, 10, 10, 10);
        this.bQn = (FrameLayout) this.aXl.findViewById(w.h.frequently_forum_switch);
        this.bQo = (BdSwitchView) this.aXl.findViewById(w.h.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bQo, 10, 10, 10, 10);
        this.bQp = (BdSwitchView) this.aXl.findViewById(w.h.switch_guess_like);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bQp, 10, 10, 10, 10);
        this.bQq = (TextView) this.aXl.findViewById(w.h.message_btn);
        this.bQs = (LinearLayout) this.aXl.findViewById(w.h.message_layout);
        this.bQt = (TextView) this.aXl.findViewById(w.h.history_tv);
        this.bQu = (TextView) this.aXl.findViewById(w.h.forum_member);
        this.bQv = (TextView) this.aXl.findViewById(w.h.frs_group);
        this.bQy = (TextView) this.aXl.findViewById(w.h.bar_share_tv);
        this.bQx = (TextView) this.aXl.findViewById(w.h.frs_sidebar_add_to_desktop);
        this.bQw = this.aXl.findViewById(w.h.unfollow_layout);
        if (com.baidu.adp.lib.b.e.eY().Y("android_share_forum") == 1) {
            this.bQy.setVisibility(0);
        } else {
            this.bQy.setVisibility(8);
        }
        if (com.baidu.adp.lib.b.e.eY().Y("android_add_to_desk") == 1) {
            this.bQx.setVisibility(0);
        } else {
            this.bQx.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bQt.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bQu.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bQv.setVisibility(8);
        }
        if (!aaH()) {
            this.bQl.setVisibility(8);
            this.bQm.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.aXl).addView(createStateBarFillView(), 0);
        }
        aaG();
        this.bQk = true;
    }

    private void aaG() {
        aaM();
        dT(b.uL().getBoolean(b.cP("frs_guess_like_switch"), true));
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.aXl != null) {
            this.aXl.setBackgroundDrawable(null);
        }
        if (this.aIy != null) {
            this.aIy.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean aaH() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dQ(boolean z) {
        if (this.bQw != null) {
            this.bQw.setVisibility(z ? 0 : 8);
        }
    }

    public void dR(boolean z) {
        if (this.bQn != null) {
            this.bQn.setVisibility(z ? 0 : 8);
        }
    }

    public BdSwitchView aaI() {
        return this.bQm;
    }

    public BdSwitchView aaJ() {
        return this.bQo;
    }

    public BdSwitchView aaK() {
        return this.bQp;
    }

    public boolean aaL() {
        return this.bQz;
    }

    public void dS(boolean z) {
        this.bQz = z;
    }

    private void aaM() {
        if (this.bQm != null) {
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.bQm.kr();
                this.bQm.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_on));
                return;
            }
            this.bQm.ks();
            this.bQm.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_off));
        }
    }

    private void dT(boolean z) {
        if (this.bQp != null) {
            if (z) {
                this.bQp.kr();
                this.bQp.setContentDescription(String.valueOf(this.mContext.getString(w.l.frs_guess_like)) + this.mContext.getString(w.l.now_state_on));
                return;
            }
            this.bQp.ks();
            this.bQp.setContentDescription(String.valueOf(this.mContext.getString(w.l.frs_guess_like)) + this.mContext.getString(w.l.now_state_off));
        }
    }

    public void a(boolean z, BdSwitchView.a aVar) {
        if (this.bQo != null) {
            this.bQo.setOnSwitchStateChangeListener(null);
            if (z) {
                this.bQo.kr();
                this.bQo.setContentDescription(String.valueOf(this.mContext.getString(w.l.frequently_forum_setting)) + this.mContext.getString(w.l.now_state_on));
            } else {
                this.bQo.ks();
                this.bQo.setContentDescription(String.valueOf(this.mContext.getString(w.l.frequently_forum_setting)) + this.mContext.getString(w.l.now_state_on));
            }
            this.bQo.setOnSwitchStateChangeListener(aVar);
        }
    }

    public void a(bq bqVar, boolean z) {
        long j = 0;
        if (this.bQq != null) {
            if (!z) {
                this.bQq.setVisibility(4);
                this.bQA = 0L;
                return;
            }
            if (bqVar != null) {
                j = bqVar.aay() - bqVar.aaz();
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().Aa()) {
                    j -= bqVar.aaA();
                }
            }
            this.bQA = j;
            d(this.bQq, j);
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
        if (!this.bQk) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.bQp.setOnSwitchStateChangeListener(aVar);
        this.bQm.setOnSwitchStateChangeListener(aVar);
        this.bQo.setOnSwitchStateChangeListener(aVar);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        if (!this.bQk) {
            throw new RuntimeException("view has not init InitInflated");
        }
        this.aXl.setOnClickListener(onClickListener);
        this.bQs.setOnClickListener(onClickListener);
        this.bQt.setOnClickListener(onClickListener);
        this.bQw.setOnClickListener(onClickListener);
        this.bQr.setOnClickListener(onClickListener);
        this.bQx.setOnClickListener(onClickListener);
        this.bQy.setOnClickListener(onClickListener);
        this.bQu.setOnClickListener(onClickListener);
        this.bQv.setOnClickListener(onClickListener);
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = tbPageContext.getLayoutMode();
        layoutMode.aj(i == 1);
        if (this.aIy != null) {
            layoutMode.t(this.aIy);
            this.aIy.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aq.cP(w.g.s_rightbar_bg)));
        }
        if (this.bQq != null) {
            d(this.bQq, this.bQA);
        }
        if (this.bQm != null) {
            if (i == 1) {
                this.bQm.kr();
                this.bQm.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_on));
            } else {
                this.bQm.ks();
                this.bQm.setContentDescription(String.valueOf(this.mContext.getString(w.l.eyeshield_mode)) + this.mContext.getString(w.l.now_state_off));
            }
            this.bQm.a(com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cO(w.g.btn_game_handle_2));
        }
        if (this.bQo != null) {
            this.bQo.a(com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cO(w.g.btn_game_handle_2));
        }
        if (this.bQp != null) {
            this.bQp.a(com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_open_bg), com.baidu.tbadk.core.util.aq.cO(w.g.s_switch_close_bg), com.baidu.tbadk.core.util.aq.cO(w.g.btn_game_handle_2));
        }
    }
}
