package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class fj extends com.baidu.adp.base.f<FrsActivity> {
    private View MQ;
    private long bmA;
    private final BdSwitchView.a bmB;
    private RelativeLayout bmg;
    private BdSwitchView bmh;
    private BdSwitchView bmi;
    private TextView bmj;
    private LinearLayout bmk;
    private LinearLayout bml;
    private LinearLayout bmm;
    private TextView bmn;
    private TextView bmo;
    private LinearLayout bmq;
    public TextView bmr;
    private TextView bms;
    private View bmt;
    private View bmu;
    private TextView bmv;
    private TextView bmw;
    private TextView bmx;
    private View.OnClickListener bmy;
    private boolean bmz;

    /* loaded from: classes.dex */
    public class a {
        public String bmD;
        public String name;
    }

    public fj(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bmg = null;
        this.bmh = null;
        this.bmi = null;
        this.MQ = null;
        this.bmj = null;
        this.bmk = null;
        this.bml = null;
        this.bmm = null;
        this.bmn = null;
        this.bmo = null;
        this.bmq = null;
        this.bmr = null;
        this.bms = null;
        this.bmt = null;
        this.bmy = null;
        this.bmA = 0L;
        this.bmB = new fk(this);
        qD();
    }

    public View getView() {
        return this.MQ;
    }

    public void init() {
        QH();
        QI();
    }

    private void QD() {
    }

    private void qD() {
        this.MQ = LayoutInflater.from(this.mContext.getPageActivity()).inflate(t.h.frs_sidebar, (ViewGroup) null);
        QD();
        this.bmk = (LinearLayout) this.MQ.findViewById(t.g.post_search_ll);
        this.bml = (LinearLayout) this.MQ.findViewById(t.g.show_content);
        this.bms = (TextView) this.MQ.findViewById(t.g.add_recommend);
        this.bmt = this.MQ.findViewById(t.g.recommend_forum_layout_line);
        this.bmr = (TextView) this.MQ.findViewById(t.g.forum_manager_center);
        this.bmr.setVisibility(8);
        this.bmi = (BdSwitchView) this.MQ.findViewById(t.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bmi, 10, 10, 10, 10);
        this.bmg = (RelativeLayout) this.MQ.findViewById(t.g.eyeshield_mode);
        this.bmh = (BdSwitchView) this.MQ.findViewById(t.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bmh, 10, 10, 10, 10);
        this.bmh.a(com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cO(t.f.btn_game_handle_2));
        this.bmi.a(com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cO(t.f.btn_game_handle_2));
        this.bmj = (TextView) this.MQ.findViewById(t.g.message_btn);
        this.bmm = (LinearLayout) this.MQ.findViewById(t.g.message_layout);
        this.bmn = (TextView) this.MQ.findViewById(t.g.history_tv);
        this.bmo = (TextView) this.MQ.findViewById(t.g.bar_info_tv);
        this.bmq = (LinearLayout) this.MQ.findViewById(t.g.recommend_forum_layout);
        this.bmv = (TextView) this.MQ.findViewById(t.g.frs_sidebar_good_tv);
        this.bmx = (TextView) this.MQ.findViewById(t.g.bar_share_tv);
        this.bmw = (TextView) this.MQ.findViewById(t.g.frs_sidebar_add_to_desktop);
        this.bmu = this.MQ.findViewById(t.g.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bmn.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bmo.setVisibility(8);
        }
        if (!QE()) {
            this.bmg.setVisibility(8);
            this.bmh.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.MQ).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.MQ != null) {
            this.MQ.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean QE() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void cw(boolean z) {
        this.bmu.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.bmr.setVisibility(0);
        } else {
            this.bmr.setVisibility(8);
        }
    }

    public BdSwitchView QF() {
        return this.bmh;
    }

    public boolean QG() {
        return this.bmz;
    }

    public void cx(boolean z) {
        this.bmz = z;
    }

    public void QH() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bmh.ms();
        } else {
            this.bmh.mt();
        }
    }

    public void QI() {
        this.bmi.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.rn().rt()) {
            this.bmi.ms();
        } else {
            this.bmi.mt();
        }
        this.bmi.setOnSwitchStateChangeListener(this.bmB);
    }

    public void a(eb ebVar, boolean z) {
        if (!z) {
            this.bmj.setVisibility(4);
            this.bmA = 0L;
        } else if (z) {
            long Qx = ebVar != null ? ebVar.Qx() - ebVar.Qy() : 0L;
            this.bmA = Qx;
            c(this.bmj, Qx);
        } else {
            this.bmA = 0L;
            this.bmj.setVisibility(4);
        }
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ar.k(textView, t.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ar.k(textView, t.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.ar.k(textView, t.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
        this.bmm.setOnClickListener(this.bmy);
        this.bmn.setOnClickListener(this.bmy);
        this.bmo.setOnClickListener(this.bmy);
        this.bmr.setOnClickListener(this.bmy);
        this.bmu.setOnClickListener(this.bmy);
        this.bmk.setOnClickListener(this.bmy);
        this.bmv.setOnClickListener(this.bmy);
        this.bmw.setOnClickListener(this.bmy);
        this.bmx.setOnClickListener(this.bmy);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ac(i == 1);
        layoutMode.x(this.MQ);
        c(this.bmj, this.bmA);
        if (i == 1) {
            this.bmh.ms();
        } else {
            this.bmh.mt();
        }
        this.MQ.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ar.cP(t.f.s_rightbar_bg)));
        this.bmh.a(com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cO(t.f.btn_game_handle_2));
        this.bmi.a(com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.ar.cO(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.ar.cO(t.f.btn_game_handle_2));
    }
}
