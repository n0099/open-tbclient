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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class dr extends com.baidu.adp.base.f<FrsActivity> {
    private View Gc;
    private FrameLayout bTC;
    private BdSwitchView bTD;
    private FrameLayout bTE;
    private BdSwitchView bTF;
    private BdSwitchView bTG;
    private TextView bTH;
    private LinearLayout bTI;
    private LinearLayout bTJ;
    private TextView bTK;
    private TextView bTL;
    private TextView bTM;
    private TextView bTN;
    private View bTO;
    private TextView bTP;
    private TextView bTQ;
    private TextView bTR;
    private boolean bTS;
    private long bTT;
    private final BdSwitchView.a bTU;

    public dr(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bTC = null;
        this.bTD = null;
        this.bTE = null;
        this.bTF = null;
        this.bTG = null;
        this.Gc = null;
        this.bTH = null;
        this.bTI = null;
        this.bTJ = null;
        this.bTK = null;
        this.bTL = null;
        this.bTM = null;
        this.bTN = null;
        this.bTT = 0L;
        this.bTU = new ds(this);
        initUI();
    }

    public View getView() {
        return this.Gc;
    }

    public void init() {
        acG();
        acH();
    }

    private void initUI() {
        this.Gc = LayoutInflater.from(this.mContext.getPageActivity()).inflate(r.h.frs_sidebar, (ViewGroup) null);
        this.bTI = (LinearLayout) this.Gc.findViewById(r.g.post_search_ll);
        this.bTG = (BdSwitchView) this.Gc.findViewById(r.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bTG, 10, 10, 10, 10);
        this.bTC = (FrameLayout) this.Gc.findViewById(r.g.eyeshield_mode);
        this.bTD = (BdSwitchView) this.Gc.findViewById(r.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bTD, 10, 10, 10, 10);
        this.bTD.a(com.baidu.tbadk.core.util.av.cN(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(r.f.btn_game_handle_2));
        this.bTE = (FrameLayout) this.Gc.findViewById(r.g.frequently_forum_switch);
        this.bTF = (BdSwitchView) this.Gc.findViewById(r.g.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bTF, 10, 10, 10, 10);
        this.bTF.a(com.baidu.tbadk.core.util.av.cN(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(r.f.btn_game_handle_2));
        this.bTG.a(com.baidu.tbadk.core.util.av.cN(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(r.f.btn_game_handle_2));
        this.bTH = (TextView) this.Gc.findViewById(r.g.message_btn);
        this.bTJ = (LinearLayout) this.Gc.findViewById(r.g.message_layout);
        this.bTK = (TextView) this.Gc.findViewById(r.g.history_tv);
        this.bTL = (TextView) this.Gc.findViewById(r.g.bar_info_tv);
        this.bTM = (TextView) this.Gc.findViewById(r.g.forum_member);
        this.bTN = (TextView) this.Gc.findViewById(r.g.frs_group);
        this.bTP = (TextView) this.Gc.findViewById(r.g.frs_sidebar_good_tv);
        this.bTR = (TextView) this.Gc.findViewById(r.g.bar_share_tv);
        this.bTQ = (TextView) this.Gc.findViewById(r.g.frs_sidebar_add_to_desktop);
        this.bTO = this.Gc.findViewById(r.g.unfollow_layout);
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bTK.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bTL.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bTM.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bTN.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bTP.setVisibility(8);
        }
        if (!acB()) {
            this.bTC.setVisibility(8);
            this.bTD.setVisibility(8);
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

    public boolean acB() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dQ(boolean z) {
        this.bTO.setVisibility(z ? 0 : 8);
    }

    public void dR(boolean z) {
        if (z) {
            this.bTF.jv();
        } else {
            this.bTF.jw();
        }
    }

    public FrameLayout acC() {
        return this.bTE;
    }

    public BdSwitchView acD() {
        return this.bTD;
    }

    public BdSwitchView acE() {
        return this.bTF;
    }

    public boolean acF() {
        return this.bTS;
    }

    public void dS(boolean z) {
        this.bTS = z;
    }

    public void acG() {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.bTD.jv();
            this.bTD.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_on));
            return;
        }
        this.bTD.jw();
        this.bTD.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_off));
    }

    public void acH() {
        this.bTG.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.oH().oN()) {
            this.bTG.jv();
            this.bTG.setContentDescription(String.valueOf(this.mContext.getString(r.j.image_show_setting)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bTG.jw();
            this.bTG.setContentDescription(String.valueOf(this.mContext.getString(r.j.image_show_setting)) + this.mContext.getString(r.j.now_state_off));
        }
        this.bTG.setOnSwitchStateChangeListener(this.bTU);
    }

    public void a(ct ctVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bTH.setVisibility(4);
            this.bTT = 0L;
            return;
        }
        if (ctVar != null) {
            j = ctVar.acv() - ctVar.acw();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zv()) {
                j -= ctVar.acx();
            }
        }
        this.bTT = j;
        c(this.bTH, j);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.av.k(textView, r.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.av.k(textView, r.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.av.k(textView, r.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.Gc.setOnClickListener(onClickListener);
        this.bTJ.setOnClickListener(onClickListener);
        this.bTK.setOnClickListener(onClickListener);
        this.bTL.setOnClickListener(onClickListener);
        this.bTO.setOnClickListener(onClickListener);
        this.bTI.setOnClickListener(onClickListener);
        this.bTP.setOnClickListener(onClickListener);
        this.bTQ.setOnClickListener(onClickListener);
        this.bTR.setOnClickListener(onClickListener);
        this.bTM.setOnClickListener(onClickListener);
        this.bTN.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ah(i == 1);
        layoutMode.x(this.Gc);
        c(this.bTH, this.bTT);
        if (i == 1) {
            this.bTD.jv();
            this.bTD.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bTD.jw();
            this.bTD.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_off));
        }
        this.Gc.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cO(r.f.s_rightbar_bg)));
        this.bTD.a(com.baidu.tbadk.core.util.av.cN(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(r.f.btn_game_handle_2));
        this.bTF.a(com.baidu.tbadk.core.util.av.cN(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(r.f.btn_game_handle_2));
        this.bTG.a(com.baidu.tbadk.core.util.av.cN(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.av.cN(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.av.cN(r.f.btn_game_handle_2));
    }
}
