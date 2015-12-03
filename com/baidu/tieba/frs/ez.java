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
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ez extends com.baidu.adp.base.f<FrsActivity> {
    private View Mk;
    private TextView bfA;
    private TextView bfB;
    private TextView bfC;
    private LinearLayout bfD;
    public TextView bfE;
    private TextView bfF;
    private View bfG;
    private View bfH;
    private TextView bfI;
    private TextView bfJ;
    private TextView bfK;
    private View.OnClickListener bfL;
    private boolean bfM;
    private final BdSwitchView.a bfN;
    private RelativeLayout bft;
    private BdSwitchView bfu;
    private BdSwitchView bfv;
    private TextView bfw;
    private LinearLayout bfx;
    private LinearLayout bfy;
    private LinearLayout bfz;

    /* loaded from: classes.dex */
    public class a {
        public String bfP;
        public String name;
    }

    public ez(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bft = null;
        this.bfu = null;
        this.bfv = null;
        this.Mk = null;
        this.bfw = null;
        this.bfx = null;
        this.bfy = null;
        this.bfz = null;
        this.bfA = null;
        this.bfB = null;
        this.bfC = null;
        this.bfD = null;
        this.bfE = null;
        this.bfF = null;
        this.bfG = null;
        this.bfL = null;
        this.bfN = new fa(this);
        initUI();
    }

    public View getView() {
        return this.Mk;
    }

    public void init() {
        On();
        Oo();
    }

    private void Oj() {
    }

    private void initUI() {
        this.Mk = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.frs_sidebar, (ViewGroup) null);
        Oj();
        this.bfx = (LinearLayout) this.Mk.findViewById(n.f.post_search_ll);
        this.bfy = (LinearLayout) this.Mk.findViewById(n.f.show_content);
        this.bfF = (TextView) this.Mk.findViewById(n.f.add_recommend);
        this.bfG = this.Mk.findViewById(n.f.recommend_forum_layout_line);
        this.bfE = (TextView) this.Mk.findViewById(n.f.forum_manager_center);
        this.bfE.setVisibility(8);
        this.bfv = (BdSwitchView) this.Mk.findViewById(n.f.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bfv, 10, 10, 10, 10);
        this.bft = (RelativeLayout) this.Mk.findViewById(n.f.eyeshield_mode);
        this.bfu = (BdSwitchView) this.Mk.findViewById(n.f.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bfu, 10, 10, 10, 10);
        this.bfu.a(com.baidu.tbadk.core.util.as.cE(n.e.s_switch_open_bg), com.baidu.tbadk.core.util.as.cE(n.e.s_switch_close_bg), com.baidu.tbadk.core.util.as.cE(n.e.btn_game_handle_2));
        this.bfv.a(com.baidu.tbadk.core.util.as.cE(n.e.s_switch_open_bg), com.baidu.tbadk.core.util.as.cE(n.e.s_switch_close_bg), com.baidu.tbadk.core.util.as.cE(n.e.btn_game_handle_2));
        this.bfw = (TextView) this.Mk.findViewById(n.f.message_btn);
        this.bfz = (LinearLayout) this.Mk.findViewById(n.f.message_layout);
        this.bfA = (TextView) this.Mk.findViewById(n.f.history_tv);
        this.bfB = (TextView) this.Mk.findViewById(n.f.bar_info_tv);
        this.bfC = (TextView) this.Mk.findViewById(n.f.bar_live_tv);
        this.bfD = (LinearLayout) this.Mk.findViewById(n.f.recommend_forum_layout);
        this.bfI = (TextView) this.Mk.findViewById(n.f.frs_sidebar_good_tv);
        this.bfK = (TextView) this.Mk.findViewById(n.f.bar_share_tv);
        this.bfJ = (TextView) this.Mk.findViewById(n.f.frs_sidebar_add_to_desktop);
        this.bfH = this.Mk.findViewById(n.f.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bfA.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bfB.setVisibility(8);
        }
        if (!Ok()) {
            this.bft.setVisibility(8);
            this.bfu.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bfy.addView(createStateBarFillView(), 0);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.bfC.setVisibility(8);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.Mk != null) {
            this.Mk.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean Ok() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void cv(boolean z) {
        this.bfH.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.bfE.setVisibility(0);
        } else {
            this.bfE.setVisibility(8);
        }
    }

    public BdSwitchView Ol() {
        return this.bfu;
    }

    public boolean Om() {
        return this.bfM;
    }

    public void cw(boolean z) {
        this.bfM = z;
    }

    public void On() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bfu.mG();
        } else {
            this.bfu.mH();
        }
    }

    public void Oo() {
        this.bfv.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.rh().rn()) {
            this.bfv.mG();
        } else {
            this.bfv.mH();
        }
        this.bfv.setOnSwitchStateChangeListener(this.bfN);
    }

    public void a(dw dwVar, boolean z) {
        if (!z) {
            this.bfw.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (dwVar != null) {
                j = dwVar.Oc() - dwVar.Od();
            }
            c(this.bfw, j);
            return;
        }
        this.bfw.setVisibility(4);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.as.i((View) textView, n.e.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.as.i((View) textView, n.e.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.as.i((View) textView, n.e.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bfL = onClickListener;
        this.bfz.setOnClickListener(this.bfL);
        this.bfA.setOnClickListener(this.bfL);
        this.bfB.setOnClickListener(this.bfL);
        this.bfE.setOnClickListener(this.bfL);
        this.bfH.setOnClickListener(this.bfL);
        this.bfx.setOnClickListener(this.bfL);
        this.bfI.setOnClickListener(this.bfL);
        this.bfJ.setOnClickListener(this.bfL);
        this.bfK.setOnClickListener(this.bfL);
        this.bfC.setOnClickListener(this.bfL);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.af(i == 1);
        layoutMode.k(this.Mk);
        if (i == 1) {
            this.bfu.mG();
        } else {
            this.bfu.mH();
        }
        this.Mk.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.as.cF(n.e.s_rightbar_bg)));
        this.bfu.a(com.baidu.tbadk.core.util.as.cE(n.e.s_switch_open_bg), com.baidu.tbadk.core.util.as.cE(n.e.s_switch_close_bg), com.baidu.tbadk.core.util.as.cE(n.e.btn_game_handle_2));
        this.bfv.a(com.baidu.tbadk.core.util.as.cE(n.e.s_switch_open_bg), com.baidu.tbadk.core.util.as.cE(n.e.s_switch_close_bg), com.baidu.tbadk.core.util.as.cE(n.e.btn_game_handle_2));
    }
}
