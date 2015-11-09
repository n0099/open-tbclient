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
public class eh extends com.baidu.adp.base.f<FrsActivity> {
    private View LT;
    private LinearLayout aZA;
    public TextView aZB;
    private TextView aZC;
    private View aZD;
    private View aZE;
    private TextView aZF;
    private TextView aZG;
    private TextView aZH;
    private View.OnClickListener aZI;
    private boolean aZJ;
    private final BdSwitchView.a aZK;
    private RelativeLayout aZo;
    private BdSwitchView aZp;
    private BdSwitchView aZq;
    private TextView aZr;
    private TextView aZs;
    private LinearLayout aZt;
    private LinearLayout aZu;
    private LinearLayout aZv;
    private LinearLayout aZw;
    private TextView aZx;
    private TextView aZy;
    private TextView aZz;
    private View mRootView;

    /* loaded from: classes.dex */
    public class a {
        public String aZM;
        public String name;
    }

    public eh(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aZo = null;
        this.aZp = null;
        this.aZq = null;
        this.LT = null;
        this.aZr = null;
        this.aZs = null;
        this.aZt = null;
        this.aZu = null;
        this.aZv = null;
        this.aZw = null;
        this.aZx = null;
        this.aZy = null;
        this.aZz = null;
        this.aZA = null;
        this.aZB = null;
        this.aZC = null;
        this.aZD = null;
        this.aZI = null;
        this.aZK = new ei(this);
        initUI();
    }

    public View getView() {
        return this.LT;
    }

    public void init() {
        MO();
        MP();
    }

    private void MK() {
        this.mRootView = this.LT.findViewById(i.f.scroll_view);
        this.mRootView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cz(i.e.s_leftbar_bg)));
    }

    private void initUI() {
        this.LT = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_sidebar, (ViewGroup) null);
        MK();
        this.LT.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cz(i.e.s_rightbar_bg)));
        this.aZt = (LinearLayout) this.LT.findViewById(i.f.post_search_ll);
        this.aZu = (LinearLayout) this.LT.findViewById(i.f.show_content);
        this.aZC = (TextView) this.LT.findViewById(i.f.add_recommend);
        this.aZD = this.LT.findViewById(i.f.recommend_forum_layout_line);
        this.aZB = (TextView) this.LT.findViewById(i.f.forum_manager_center);
        this.aZB.setVisibility(8);
        this.aZq = (BdSwitchView) this.LT.findViewById(i.f.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aZq, 10, 10, 10, 10);
        this.aZo = (RelativeLayout) this.LT.findViewById(i.f.eyeshield_mode);
        this.aZp = (BdSwitchView) this.LT.findViewById(i.f.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aZp, 10, 10, 10, 10);
        this.aZp.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
        this.aZq.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
        this.aZr = (TextView) this.LT.findViewById(i.f.message_btn);
        this.aZs = (TextView) this.LT.findViewById(i.f.mention_btn);
        this.aZv = (LinearLayout) this.LT.findViewById(i.f.message_layout);
        this.aZw = (LinearLayout) this.LT.findViewById(i.f.mention_layout);
        this.aZx = (TextView) this.LT.findViewById(i.f.history_tv);
        this.aZy = (TextView) this.LT.findViewById(i.f.bar_info_tv);
        this.aZz = (TextView) this.LT.findViewById(i.f.bar_live_tv);
        this.aZA = (LinearLayout) this.LT.findViewById(i.f.recommend_forum_layout);
        this.aZF = (TextView) this.LT.findViewById(i.f.frs_sidebar_good_tv);
        this.aZH = (TextView) this.LT.findViewById(i.f.bar_share_tv);
        this.aZG = (TextView) this.LT.findViewById(i.f.frs_sidebar_add_to_desktop);
        this.aZE = this.LT.findViewById(i.f.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aZx.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aZy.setVisibility(8);
        }
        if (!ML()) {
            this.aZo.setVisibility(8);
            this.aZp.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aZu.addView(createStateBarFillView(), 0);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aZz.setVisibility(8);
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

    public boolean ML() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void ci(boolean z) {
        this.aZE.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aZB.setVisibility(0);
        } else {
            this.aZB.setVisibility(8);
        }
    }

    public BdSwitchView MM() {
        return this.aZp;
    }

    public boolean MN() {
        return this.aZJ;
    }

    public void cj(boolean z) {
        this.aZJ = z;
    }

    public void MO() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aZp.mC();
        } else {
            this.aZp.mD();
        }
    }

    public void MP() {
        this.aZq.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qV().qZ()) {
            this.aZq.mC();
        } else {
            this.aZq.mD();
        }
        this.aZq.setOnSwitchStateChangeListener(this.aZK);
    }

    public void a(dg dgVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aZr.setVisibility(4);
            this.aZs.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (dgVar != null) {
                j = dgVar.MG();
            }
            c(this.aZr, j);
        } else {
            this.aZr.setVisibility(4);
        }
        if (z2) {
            if (dgVar != null) {
                j = dgVar.MF();
            }
            c(this.aZs, j);
            return;
        }
        this.aZs.setVisibility(4);
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
        this.aZI = onClickListener;
        this.aZv.setOnClickListener(this.aZI);
        this.aZw.setOnClickListener(this.aZI);
        this.aZx.setOnClickListener(this.aZI);
        this.aZy.setOnClickListener(this.aZI);
        this.aZB.setOnClickListener(this.aZI);
        this.aZE.setOnClickListener(this.aZI);
        this.aZt.setOnClickListener(this.aZI);
        this.aZF.setOnClickListener(this.aZI);
        this.aZG.setOnClickListener(this.aZI);
        this.aZH.setOnClickListener(this.aZI);
        this.aZz.setOnClickListener(this.aZI);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(this.LT);
        if (i == 1) {
            this.aZp.mC();
        } else {
            this.aZp.mD();
        }
        this.LT.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cz(i.e.s_rightbar_bg)));
        this.aZp.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
        this.aZq.a(com.baidu.tbadk.core.util.an.cw(i.e.s_switch_open_bg), com.baidu.tbadk.core.util.an.cw(i.e.s_switch_close_bg), com.baidu.tbadk.core.util.an.cw(i.e.btn_game_handle_2));
    }
}
