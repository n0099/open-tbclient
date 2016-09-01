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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dr extends com.baidu.adp.base.f<FrsActivity> {
    private View Gc;
    private FrameLayout bTJ;
    private BdSwitchView bTK;
    private FrameLayout bTL;
    private BdSwitchView bTM;
    private BdSwitchView bTN;
    private TextView bTO;
    private LinearLayout bTP;
    private LinearLayout bTQ;
    private TextView bTR;
    private TextView bTS;
    private TextView bTT;
    private TextView bTU;
    private View bTV;
    private TextView bTW;
    private TextView bTX;
    private TextView bTY;
    private boolean bTZ;
    private long bUa;
    private final BdSwitchView.a bUb;

    public dr(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bTJ = null;
        this.bTK = null;
        this.bTL = null;
        this.bTM = null;
        this.bTN = null;
        this.Gc = null;
        this.bTO = null;
        this.bTP = null;
        this.bTQ = null;
        this.bTR = null;
        this.bTS = null;
        this.bTT = null;
        this.bTU = null;
        this.bUa = 0L;
        this.bUb = new ds(this);
        initUI();
    }

    public View getView() {
        return this.Gc;
    }

    public void init() {
        acu();
        acv();
    }

    private void initUI() {
        this.Gc = LayoutInflater.from(this.mContext.getPageActivity()).inflate(t.h.frs_sidebar, (ViewGroup) null);
        this.bTP = (LinearLayout) this.Gc.findViewById(t.g.post_search_ll);
        this.bTN = (BdSwitchView) this.Gc.findViewById(t.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bTN, 10, 10, 10, 10);
        this.bTJ = (FrameLayout) this.Gc.findViewById(t.g.eyeshield_mode);
        this.bTK = (BdSwitchView) this.Gc.findViewById(t.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bTK, 10, 10, 10, 10);
        this.bTK.a(com.baidu.tbadk.core.util.av.cN(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(t.f.btn_game_handle_2));
        this.bTL = (FrameLayout) this.Gc.findViewById(t.g.frequently_forum_switch);
        this.bTM = (BdSwitchView) this.Gc.findViewById(t.g.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bTM, 10, 10, 10, 10);
        this.bTM.a(com.baidu.tbadk.core.util.av.cN(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(t.f.btn_game_handle_2));
        this.bTN.a(com.baidu.tbadk.core.util.av.cN(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(t.f.btn_game_handle_2));
        this.bTO = (TextView) this.Gc.findViewById(t.g.message_btn);
        this.bTQ = (LinearLayout) this.Gc.findViewById(t.g.message_layout);
        this.bTR = (TextView) this.Gc.findViewById(t.g.history_tv);
        this.bTS = (TextView) this.Gc.findViewById(t.g.bar_info_tv);
        this.bTT = (TextView) this.Gc.findViewById(t.g.forum_member);
        this.bTU = (TextView) this.Gc.findViewById(t.g.frs_group);
        this.bTW = (TextView) this.Gc.findViewById(t.g.frs_sidebar_good_tv);
        this.bTY = (TextView) this.Gc.findViewById(t.g.bar_share_tv);
        this.bTX = (TextView) this.Gc.findViewById(t.g.frs_sidebar_add_to_desktop);
        this.bTV = this.Gc.findViewById(t.g.unfollow_layout);
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bTR.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bTS.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bTT.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bTU.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bTW.setVisibility(8);
        }
        if (!acp()) {
            this.bTJ.setVisibility(8);
            this.bTK.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.Gc).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.Gc != null) {
            this.Gc.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean acp() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dP(boolean z) {
        this.bTV.setVisibility(z ? 0 : 8);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bTM.jv();
        } else {
            this.bTM.jw();
        }
    }

    public FrameLayout acq() {
        return this.bTL;
    }

    public BdSwitchView acr() {
        return this.bTK;
    }

    public BdSwitchView acs() {
        return this.bTM;
    }

    public boolean act() {
        return this.bTZ;
    }

    public void dR(boolean z) {
        this.bTZ = z;
    }

    public void acu() {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.bTK.jv();
            this.bTK.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_on));
            return;
        }
        this.bTK.jw();
        this.bTK.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_off));
    }

    public void acv() {
        this.bTN.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.oG().oM()) {
            this.bTN.jv();
            this.bTN.setContentDescription(String.valueOf(this.mContext.getString(t.j.image_show_setting)) + this.mContext.getString(t.j.now_state_on));
        } else {
            this.bTN.jw();
            this.bTN.setContentDescription(String.valueOf(this.mContext.getString(t.j.image_show_setting)) + this.mContext.getString(t.j.now_state_off));
        }
        this.bTN.setOnSwitchStateChangeListener(this.bUb);
    }

    public void a(ct ctVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bTO.setVisibility(4);
            this.bUa = 0L;
            return;
        }
        if (ctVar != null) {
            j = ctVar.aci() - ctVar.acj();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zs()) {
                j -= ctVar.ack();
            }
        }
        this.bUa = j;
        c(this.bTO, j);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.av.k(textView, t.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.av.k(textView, t.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.av.k(textView, t.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.Gc.setOnClickListener(onClickListener);
        this.bTQ.setOnClickListener(onClickListener);
        this.bTR.setOnClickListener(onClickListener);
        this.bTS.setOnClickListener(onClickListener);
        this.bTV.setOnClickListener(onClickListener);
        this.bTP.setOnClickListener(onClickListener);
        this.bTW.setOnClickListener(onClickListener);
        this.bTX.setOnClickListener(onClickListener);
        this.bTY.setOnClickListener(onClickListener);
        this.bTT.setOnClickListener(onClickListener);
        this.bTU.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ah(i == 1);
        layoutMode.x(this.Gc);
        c(this.bTO, this.bUa);
        if (i == 1) {
            this.bTK.jv();
            this.bTK.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_on));
        } else {
            this.bTK.jw();
            this.bTK.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_off));
        }
        this.Gc.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cO(t.f.s_rightbar_bg)));
        this.bTK.a(com.baidu.tbadk.core.util.av.cN(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(t.f.btn_game_handle_2));
        this.bTM.a(com.baidu.tbadk.core.util.av.cN(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(t.f.btn_game_handle_2));
        this.bTN.a(com.baidu.tbadk.core.util.av.cN(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(t.f.btn_game_handle_2));
    }
}
