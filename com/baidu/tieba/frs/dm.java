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
public class dm extends com.baidu.adp.base.f<FrsActivity> {
    private View LR;
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
    private View.OnClickListener aZv;
    private boolean aZw;
    private final BdSwitchView.a aZx;
    private View mRootView;

    /* loaded from: classes.dex */
    public class a {
        public String aZz;
        public String name;
    }

    public dm(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aZc = null;
        this.aZd = null;
        this.aZe = null;
        this.LR = null;
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
        this.aZv = null;
        this.aZx = new dn(this);
        initUI();
    }

    public View getView() {
        return this.LR;
    }

    public void init() {
        MD();
        ME();
    }

    private void Mz() {
        this.mRootView = this.LR.findViewById(i.f.scroll_view);
        this.mRootView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.al.cx(i.e.bg_home)));
    }

    private void initUI() {
        this.LR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_sidebar, (ViewGroup) null);
        Mz();
        this.aZh = (LinearLayout) this.LR.findViewById(i.f.post_search_ll);
        this.aZi = (LinearLayout) this.LR.findViewById(i.f.show_content);
        this.aZq = (TextView) this.LR.findViewById(i.f.add_recommend);
        this.aZr = this.LR.findViewById(i.f.recommend_forum_layout_line);
        this.aZp = (TextView) this.LR.findViewById(i.f.forum_manager_center);
        this.aZp.setVisibility(8);
        this.aZe = (BdSwitchView) this.LR.findViewById(i.f.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aZe, 10, 10, 10, 10);
        this.aZc = (RelativeLayout) this.LR.findViewById(i.f.eyeshield_mode);
        this.aZd = (BdSwitchView) this.LR.findViewById(i.f.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aZd, 10, 10, 10, 10);
        this.aZf = (TextView) this.LR.findViewById(i.f.message_btn);
        this.aZg = (TextView) this.LR.findViewById(i.f.mention_btn);
        this.aZj = (LinearLayout) this.LR.findViewById(i.f.message_layout);
        this.aZk = (LinearLayout) this.LR.findViewById(i.f.mention_layout);
        this.aZl = (TextView) this.LR.findViewById(i.f.history_tv);
        this.aZm = (TextView) this.LR.findViewById(i.f.bar_info_tv);
        this.aZn = (TextView) this.LR.findViewById(i.f.bar_live_tv);
        this.aZo = (LinearLayout) this.LR.findViewById(i.f.recommend_forum_layout);
        this.aZt = (TextView) this.LR.findViewById(i.f.frs_sidebar_good_tv);
        this.aZu = (TextView) this.LR.findViewById(i.f.frs_sidebar_add_to_desktop);
        this.aZs = this.LR.findViewById(i.f.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aZl.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aZm.setVisibility(8);
        }
        if (!MA()) {
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

    public boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void cj(boolean z) {
        this.aZs.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aZp.setVisibility(0);
        } else {
            this.aZp.setVisibility(8);
        }
    }

    public BdSwitchView MB() {
        return this.aZd;
    }

    public boolean MC() {
        return this.aZw;
    }

    public void ck(boolean z) {
        this.aZw = z;
    }

    public void MD() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aZd.mA();
        } else {
            this.aZd.mB();
        }
    }

    public void ME() {
        this.aZe.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.rb().rf()) {
            this.aZe.mA();
        } else {
            this.aZe.mB();
        }
        this.aZe.setOnSwitchStateChangeListener(this.aZx);
    }

    public void a(cr crVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aZf.setVisibility(4);
            this.aZg.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (crVar != null) {
                j = crVar.Mv();
            }
            b(this.aZf, j);
        } else {
            this.aZf.setVisibility(4);
        }
        if (z2) {
            if (crVar != null) {
                j = crVar.Mu();
            }
            b(this.aZg, j);
            return;
        }
        this.aZg.setVisibility(4);
    }

    private void b(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.al.h((View) textView, i.e.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.al.h((View) textView, i.e.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.al.h((View) textView, i.e.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZv = onClickListener;
        this.aZj.setOnClickListener(this.aZv);
        this.aZk.setOnClickListener(this.aZv);
        this.aZl.setOnClickListener(this.aZv);
        this.aZm.setOnClickListener(this.aZv);
        this.aZp.setOnClickListener(this.aZv);
        this.aZs.setOnClickListener(this.aZv);
        this.aZh.setOnClickListener(this.aZv);
        this.aZt.setOnClickListener(this.aZv);
        this.aZu.setOnClickListener(this.aZv);
        this.aZn.setOnClickListener(this.aZv);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(this.LR);
        if (i == 1) {
            this.aZd.mA();
        } else {
            this.aZd.mB();
        }
        this.aZd.a(com.baidu.tbadk.core.util.al.cu(i.e.bg_game_switch_open_2), com.baidu.tbadk.core.util.al.cu(i.e.bg_game_switch_close_2), com.baidu.tbadk.core.util.al.cu(i.e.btn_game_handle_2));
        this.aZe.a(com.baidu.tbadk.core.util.al.cu(i.e.bg_game_switch_open_2), com.baidu.tbadk.core.util.al.cu(i.e.bg_game_switch_close_2), com.baidu.tbadk.core.util.al.cu(i.e.btn_game_handle_2));
    }
}
