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
    private View LS;
    private RelativeLayout aZc;
    private BdSwitchView aZd;
    private BdSwitchView aZe;
    private TextView aZf;
    private TextView aZg;
    private LinearLayout aZh;
    private LinearLayout aZi;
    private LinearLayout aZj;
    private LinearLayout aZk;
    private TextView aZl;
    private TextView aZm;
    private TextView aZn;
    private LinearLayout aZo;
    public TextView aZp;
    private TextView aZq;
    private View aZr;
    private View aZs;
    private TextView aZt;
    private TextView aZu;
    private TextView aZv;
    private View.OnClickListener aZw;
    private boolean aZx;
    private final BdSwitchView.a aZy;
    private View mRootView;

    /* loaded from: classes.dex */
    public class a {
        public String aZA;
        public String name;
    }

    public ef(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aZc = null;
        this.aZd = null;
        this.aZe = null;
        this.LS = null;
        this.aZf = null;
        this.aZg = null;
        this.aZh = null;
        this.aZi = null;
        this.aZj = null;
        this.aZk = null;
        this.aZl = null;
        this.aZm = null;
        this.aZn = null;
        this.aZo = null;
        this.aZp = null;
        this.aZq = null;
        this.aZr = null;
        this.aZw = null;
        this.aZy = new eg(this);
        initUI();
    }

    public View getView() {
        return this.LS;
    }

    public void init() {
        MC();
        MD();
    }

    private void My() {
        this.mRootView = this.LS.findViewById(i.f.scroll_view);
        this.mRootView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cz(i.e.s_leftbar_bg)));
    }

    private void initUI() {
        this.LS = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_sidebar, (ViewGroup) null);
        My();
        this.LS.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cz(i.e.s_rightbar_bg)));
        this.aZh = (LinearLayout) this.LS.findViewById(i.f.post_search_ll);
        this.aZi = (LinearLayout) this.LS.findViewById(i.f.show_content);
        this.aZq = (TextView) this.LS.findViewById(i.f.add_recommend);
        this.aZr = this.LS.findViewById(i.f.recommend_forum_layout_line);
        this.aZp = (TextView) this.LS.findViewById(i.f.forum_manager_center);
        this.aZp.setVisibility(8);
        this.aZe = (BdSwitchView) this.LS.findViewById(i.f.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aZe, 10, 10, 10, 10);
        this.aZc = (RelativeLayout) this.LS.findViewById(i.f.eyeshield_mode);
        this.aZd = (BdSwitchView) this.LS.findViewById(i.f.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aZd, 10, 10, 10, 10);
        this.aZd.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
        this.aZe.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
        this.aZf = (TextView) this.LS.findViewById(i.f.message_btn);
        this.aZg = (TextView) this.LS.findViewById(i.f.mention_btn);
        this.aZj = (LinearLayout) this.LS.findViewById(i.f.message_layout);
        this.aZk = (LinearLayout) this.LS.findViewById(i.f.mention_layout);
        this.aZl = (TextView) this.LS.findViewById(i.f.history_tv);
        this.aZm = (TextView) this.LS.findViewById(i.f.bar_info_tv);
        this.aZn = (TextView) this.LS.findViewById(i.f.bar_live_tv);
        this.aZo = (LinearLayout) this.LS.findViewById(i.f.recommend_forum_layout);
        this.aZt = (TextView) this.LS.findViewById(i.f.frs_sidebar_good_tv);
        this.aZv = (TextView) this.LS.findViewById(i.f.bar_share_tv);
        this.aZu = (TextView) this.LS.findViewById(i.f.frs_sidebar_add_to_desktop);
        this.aZs = this.LS.findViewById(i.f.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aZl.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aZm.setVisibility(8);
        }
        if (!Mz()) {
            this.aZc.setVisibility(8);
            this.aZd.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aZi.addView(createStateBarFillView(), 0);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aZn.setVisibility(8);
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
        this.aZs.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aZp.setVisibility(0);
        } else {
            this.aZp.setVisibility(8);
        }
    }

    public BdSwitchView MA() {
        return this.aZd;
    }

    public boolean MB() {
        return this.aZx;
    }

    public void ch(boolean z) {
        this.aZx = z;
    }

    public void MC() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aZd.mB();
        } else {
            this.aZd.mC();
        }
    }

    public void MD() {
        this.aZe.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qX().rb()) {
            this.aZe.mB();
        } else {
            this.aZe.mC();
        }
        this.aZe.setOnSwitchStateChangeListener(this.aZy);
    }

    public void a(dg dgVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aZf.setVisibility(4);
            this.aZg.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (dgVar != null) {
                j = dgVar.Mu();
            }
            c(this.aZf, j);
        } else {
            this.aZf.setVisibility(4);
        }
        if (z2) {
            if (dgVar != null) {
                j = dgVar.Mt();
            }
            c(this.aZg, j);
            return;
        }
        this.aZg.setVisibility(4);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.an.i((View) textView, i.e.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.an.i((View) textView, i.e.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.an.i((View) textView, i.e.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZw = onClickListener;
        this.aZj.setOnClickListener(this.aZw);
        this.aZk.setOnClickListener(this.aZw);
        this.aZl.setOnClickListener(this.aZw);
        this.aZm.setOnClickListener(this.aZw);
        this.aZp.setOnClickListener(this.aZw);
        this.aZs.setOnClickListener(this.aZw);
        this.aZh.setOnClickListener(this.aZw);
        this.aZt.setOnClickListener(this.aZw);
        this.aZu.setOnClickListener(this.aZw);
        this.aZv.setOnClickListener(this.aZw);
        this.aZn.setOnClickListener(this.aZw);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(this.LS);
        if (i == 1) {
            this.aZd.mB();
        } else {
            this.aZd.mC();
        }
        this.LS.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cz(i.e.s_rightbar_bg)));
        this.aZd.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
        this.aZe.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
    }
}
