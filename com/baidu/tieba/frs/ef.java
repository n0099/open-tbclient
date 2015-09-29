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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ef extends com.baidu.adp.base.f<FrsActivity> {
    private View LR;
    private RelativeLayout aYR;
    private BdSwitchView aYS;
    private BdSwitchView aYT;
    private TextView aYU;
    private TextView aYV;
    private LinearLayout aYW;
    private LinearLayout aYX;
    private LinearLayout aYY;
    private LinearLayout aYZ;
    private TextView aZa;
    private TextView aZb;
    private TextView aZc;
    private LinearLayout aZd;
    public TextView aZe;
    private TextView aZf;
    private View aZg;
    private View aZh;
    private TextView aZi;
    private TextView aZj;
    private TextView aZk;
    private View.OnClickListener aZl;
    private boolean aZm;
    private final BdSwitchView.a aZn;
    private View mRootView;

    /* loaded from: classes.dex */
    public class a {
        public String aZp;
        public String name;
    }

    public ef(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aYR = null;
        this.aYS = null;
        this.aYT = null;
        this.LR = null;
        this.aYU = null;
        this.aYV = null;
        this.aYW = null;
        this.aYX = null;
        this.aYY = null;
        this.aYZ = null;
        this.aZa = null;
        this.aZb = null;
        this.aZc = null;
        this.aZd = null;
        this.aZe = null;
        this.aZf = null;
        this.aZg = null;
        this.aZl = null;
        this.aZn = new eg(this);
        initUI();
    }

    public View getView() {
        return this.LR;
    }

    public void init() {
        MC();
        MD();
    }

    private void My() {
        this.mRootView = this.LR.findViewById(i.f.scroll_view);
        this.mRootView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.am.cz(i.e.s_leftbar_bg)));
    }

    private void initUI() {
        this.LR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_sidebar, (ViewGroup) null);
        My();
        this.LR.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.am.cz(i.e.s_rightbar_bg)));
        this.aYW = (LinearLayout) this.LR.findViewById(i.f.post_search_ll);
        this.aYX = (LinearLayout) this.LR.findViewById(i.f.show_content);
        this.aZf = (TextView) this.LR.findViewById(i.f.add_recommend);
        this.aZg = this.LR.findViewById(i.f.recommend_forum_layout_line);
        this.aZe = (TextView) this.LR.findViewById(i.f.forum_manager_center);
        this.aZe.setVisibility(8);
        this.aYT = (BdSwitchView) this.LR.findViewById(i.f.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aYT, 10, 10, 10, 10);
        this.aYR = (RelativeLayout) this.LR.findViewById(i.f.eyeshield_mode);
        this.aYS = (BdSwitchView) this.LR.findViewById(i.f.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aYS, 10, 10, 10, 10);
        this.aYS.a(com.baidu.tbadk.core.util.am.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.am.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.am.cw(i.e.btn_game_handle_2));
        this.aYT.a(com.baidu.tbadk.core.util.am.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.am.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.am.cw(i.e.btn_game_handle_2));
        this.aYU = (TextView) this.LR.findViewById(i.f.message_btn);
        this.aYV = (TextView) this.LR.findViewById(i.f.mention_btn);
        this.aYY = (LinearLayout) this.LR.findViewById(i.f.message_layout);
        this.aYZ = (LinearLayout) this.LR.findViewById(i.f.mention_layout);
        this.aZa = (TextView) this.LR.findViewById(i.f.history_tv);
        this.aZb = (TextView) this.LR.findViewById(i.f.bar_info_tv);
        this.aZc = (TextView) this.LR.findViewById(i.f.bar_live_tv);
        this.aZd = (LinearLayout) this.LR.findViewById(i.f.recommend_forum_layout);
        this.aZi = (TextView) this.LR.findViewById(i.f.frs_sidebar_good_tv);
        this.aZk = (TextView) this.LR.findViewById(i.f.bar_share_tv);
        this.aZj = (TextView) this.LR.findViewById(i.f.frs_sidebar_add_to_desktop);
        this.aZh = this.LR.findViewById(i.f.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aZa.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aZb.setVisibility(8);
        }
        if (!Mz()) {
            this.aYR.setVisibility(8);
            this.aYS.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aYX.addView(createStateBarFillView(), 0);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aZc.setVisibility(8);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean Mz() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void cg(boolean z) {
        this.aZh.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aZe.setVisibility(0);
        } else {
            this.aZe.setVisibility(8);
        }
    }

    public BdSwitchView MA() {
        return this.aYS;
    }

    public boolean MB() {
        return this.aZm;
    }

    public void ch(boolean z) {
        this.aZm = z;
    }

    public void MC() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aYS.mB();
        } else {
            this.aYS.mC();
        }
    }

    public void MD() {
        this.aYT.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qX().rb()) {
            this.aYT.mB();
        } else {
            this.aYT.mC();
        }
        this.aYT.setOnSwitchStateChangeListener(this.aZn);
    }

    public void a(dg dgVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aYU.setVisibility(4);
            this.aYV.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (dgVar != null) {
                j = dgVar.Mu();
            }
            c(this.aYU, j);
        } else {
            this.aYU.setVisibility(4);
        }
        if (z2) {
            if (dgVar != null) {
                j = dgVar.Mt();
            }
            c(this.aYV, j);
            return;
        }
        this.aYV.setVisibility(4);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.am.i((View) textView, i.e.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.am.i((View) textView, i.e.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.am.i((View) textView, i.e.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZl = onClickListener;
        this.aYY.setOnClickListener(this.aZl);
        this.aYZ.setOnClickListener(this.aZl);
        this.aZa.setOnClickListener(this.aZl);
        this.aZb.setOnClickListener(this.aZl);
        this.aZe.setOnClickListener(this.aZl);
        this.aZh.setOnClickListener(this.aZl);
        this.aYW.setOnClickListener(this.aZl);
        this.aZi.setOnClickListener(this.aZl);
        this.aZj.setOnClickListener(this.aZl);
        this.aZk.setOnClickListener(this.aZl);
        this.aZc.setOnClickListener(this.aZl);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(this.LR);
        if (i == 1) {
            this.aYS.mB();
        } else {
            this.aYS.mC();
        }
        this.LR.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.am.cz(i.e.s_rightbar_bg)));
        this.aYS.a(com.baidu.tbadk.core.util.am.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.am.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.am.cw(i.e.btn_game_handle_2));
        this.aYT.a(com.baidu.tbadk.core.util.am.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.am.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.am.cw(i.e.btn_game_handle_2));
    }
}
