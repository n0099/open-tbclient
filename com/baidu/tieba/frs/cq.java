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
public class cq extends com.baidu.adp.base.f<FrsActivity> {
    private View Ge;
    private FrameLayout bVM;
    private BdSwitchView bVN;
    private FrameLayout bVO;
    private BdSwitchView bVP;
    private BdSwitchView bVQ;
    private TextView bVR;
    private LinearLayout bVS;
    private LinearLayout bVT;
    private TextView bVU;
    private TextView bVV;
    private TextView bVW;
    private TextView bVX;
    private View bVY;
    private TextView bVZ;
    private TextView bWa;
    private TextView bWb;
    private boolean bWc;
    private long bWd;
    private final BdSwitchView.a bWe;

    public cq(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bVM = null;
        this.bVN = null;
        this.bVO = null;
        this.bVP = null;
        this.bVQ = null;
        this.Ge = null;
        this.bVR = null;
        this.bVS = null;
        this.bVT = null;
        this.bVU = null;
        this.bVV = null;
        this.bVW = null;
        this.bVX = null;
        this.bWd = 0L;
        this.bWe = new cr(this);
        initUI();
    }

    public View getView() {
        return this.Ge;
    }

    public void init() {
        adN();
        adO();
    }

    private void initUI() {
        this.Ge = LayoutInflater.from(this.mContext.getPageActivity()).inflate(r.h.frs_sidebar, (ViewGroup) null);
        this.bVS = (LinearLayout) this.Ge.findViewById(r.g.post_search_ll);
        this.bVQ = (BdSwitchView) this.Ge.findViewById(r.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bVQ, 10, 10, 10, 10);
        this.bVM = (FrameLayout) this.Ge.findViewById(r.g.eyeshield_mode);
        this.bVN = (BdSwitchView) this.Ge.findViewById(r.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bVN, 10, 10, 10, 10);
        this.bVN.a(com.baidu.tbadk.core.util.at.cO(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cO(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cO(r.f.btn_game_handle_2));
        this.bVO = (FrameLayout) this.Ge.findViewById(r.g.frequently_forum_switch);
        this.bVP = (BdSwitchView) this.Ge.findViewById(r.g.frequently_forum__mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bVP, 10, 10, 10, 10);
        this.bVP.a(com.baidu.tbadk.core.util.at.cO(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cO(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cO(r.f.btn_game_handle_2));
        this.bVQ.a(com.baidu.tbadk.core.util.at.cO(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cO(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cO(r.f.btn_game_handle_2));
        this.bVR = (TextView) this.Ge.findViewById(r.g.message_btn);
        this.bVT = (LinearLayout) this.Ge.findViewById(r.g.message_layout);
        this.bVU = (TextView) this.Ge.findViewById(r.g.history_tv);
        this.bVV = (TextView) this.Ge.findViewById(r.g.bar_info_tv);
        this.bVW = (TextView) this.Ge.findViewById(r.g.forum_member);
        this.bVX = (TextView) this.Ge.findViewById(r.g.frs_group);
        this.bVZ = (TextView) this.Ge.findViewById(r.g.frs_sidebar_good_tv);
        this.bWb = (TextView) this.Ge.findViewById(r.g.bar_share_tv);
        this.bWa = (TextView) this.Ge.findViewById(r.g.frs_sidebar_add_to_desktop);
        this.bVY = this.Ge.findViewById(r.g.unfollow_layout);
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bVU.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bVV.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bVW.setVisibility(8);
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bVX.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bVZ.setVisibility(8);
        }
        if (!adI()) {
            this.bVM.setVisibility(8);
            this.bVN.setVisibility(8);
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

    public boolean adI() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void dZ(boolean z) {
        this.bVY.setVisibility(z ? 0 : 8);
    }

    public void ea(boolean z) {
        if (z) {
            this.bVP.jv();
        } else {
            this.bVP.jw();
        }
    }

    public FrameLayout adJ() {
        return this.bVO;
    }

    public BdSwitchView adK() {
        return this.bVN;
    }

    public BdSwitchView adL() {
        return this.bVP;
    }

    public boolean adM() {
        return this.bWc;
    }

    public void eb(boolean z) {
        this.bWc = z;
    }

    public void adN() {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.bVN.jv();
            this.bVN.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_on));
            return;
        }
        this.bVN.jw();
        this.bVN.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_off));
    }

    public void adO() {
        this.bVQ.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.oJ().oP()) {
            this.bVQ.jv();
            this.bVQ.setContentDescription(String.valueOf(this.mContext.getString(r.j.image_show_setting)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bVQ.jw();
            this.bVQ.setContentDescription(String.valueOf(this.mContext.getString(r.j.image_show_setting)) + this.mContext.getString(r.j.now_state_off));
        }
        this.bVQ.setOnSwitchStateChangeListener(this.bWe);
    }

    public void a(br brVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bVR.setVisibility(4);
            this.bWd = 0L;
            return;
        }
        if (brVar != null) {
            j = brVar.adB() - brVar.adC();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zC()) {
                j -= brVar.adD();
            }
        }
        this.bWd = j;
        c(this.bVR, j);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.Ge.setOnClickListener(onClickListener);
        this.bVT.setOnClickListener(onClickListener);
        this.bVU.setOnClickListener(onClickListener);
        this.bVV.setOnClickListener(onClickListener);
        this.bVY.setOnClickListener(onClickListener);
        this.bVS.setOnClickListener(onClickListener);
        this.bVZ.setOnClickListener(onClickListener);
        this.bWa.setOnClickListener(onClickListener);
        this.bWb.setOnClickListener(onClickListener);
        this.bVW.setOnClickListener(onClickListener);
        this.bVX.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ai(i == 1);
        layoutMode.x(this.Ge);
        c(this.bVR, this.bWd);
        if (i == 1) {
            this.bVN.jv();
            this.bVN.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_on));
        } else {
            this.bVN.jw();
            this.bVN.setContentDescription(String.valueOf(this.mContext.getString(r.j.eyeshield_mode)) + this.mContext.getString(r.j.now_state_off));
        }
        this.Ge.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.at.cP(r.f.s_rightbar_bg)));
        this.bVN.a(com.baidu.tbadk.core.util.at.cO(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cO(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cO(r.f.btn_game_handle_2));
        this.bVP.a(com.baidu.tbadk.core.util.at.cO(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cO(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cO(r.f.btn_game_handle_2));
        this.bVQ.a(com.baidu.tbadk.core.util.at.cO(r.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cO(r.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cO(r.f.btn_game_handle_2));
    }
}
