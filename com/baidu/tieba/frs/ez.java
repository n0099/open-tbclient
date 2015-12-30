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
    private View MA;
    private TextView bjA;
    private TextView bjB;
    private TextView bjC;
    private View.OnClickListener bjD;
    private boolean bjE;
    private final BdSwitchView.a bjF;
    private RelativeLayout bjl;
    private BdSwitchView bjm;
    private BdSwitchView bjn;
    private TextView bjo;
    private LinearLayout bjp;
    private LinearLayout bjq;
    private LinearLayout bjr;
    private TextView bjs;
    private TextView bjt;
    private TextView bju;
    private LinearLayout bjv;
    public TextView bjw;
    private TextView bjx;
    private View bjy;
    private View bjz;

    /* loaded from: classes.dex */
    public class a {
        public String bjH;
        public String name;
    }

    public ez(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bjl = null;
        this.bjm = null;
        this.bjn = null;
        this.MA = null;
        this.bjo = null;
        this.bjp = null;
        this.bjq = null;
        this.bjr = null;
        this.bjs = null;
        this.bjt = null;
        this.bju = null;
        this.bjv = null;
        this.bjw = null;
        this.bjx = null;
        this.bjy = null;
        this.bjD = null;
        this.bjF = new fa(this);
        initUI();
    }

    public View getView() {
        return this.MA;
    }

    public void init() {
        OF();
        OG();
    }

    private void OB() {
    }

    private void initUI() {
        this.MA = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.frs_sidebar, (ViewGroup) null);
        OB();
        this.bjp = (LinearLayout) this.MA.findViewById(n.g.post_search_ll);
        this.bjq = (LinearLayout) this.MA.findViewById(n.g.show_content);
        this.bjx = (TextView) this.MA.findViewById(n.g.add_recommend);
        this.bjy = this.MA.findViewById(n.g.recommend_forum_layout_line);
        this.bjw = (TextView) this.MA.findViewById(n.g.forum_manager_center);
        this.bjw.setVisibility(8);
        this.bjn = (BdSwitchView) this.MA.findViewById(n.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bjn, 10, 10, 10, 10);
        this.bjl = (RelativeLayout) this.MA.findViewById(n.g.eyeshield_mode);
        this.bjm = (BdSwitchView) this.MA.findViewById(n.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bjm, 10, 10, 10, 10);
        this.bjm.a(com.baidu.tbadk.core.util.as.cx(n.f.s_switch_open_bg), com.baidu.tbadk.core.util.as.cx(n.f.s_switch_close_bg), com.baidu.tbadk.core.util.as.cx(n.f.btn_game_handle_2));
        this.bjn.a(com.baidu.tbadk.core.util.as.cx(n.f.s_switch_open_bg), com.baidu.tbadk.core.util.as.cx(n.f.s_switch_close_bg), com.baidu.tbadk.core.util.as.cx(n.f.btn_game_handle_2));
        this.bjo = (TextView) this.MA.findViewById(n.g.message_btn);
        this.bjr = (LinearLayout) this.MA.findViewById(n.g.message_layout);
        this.bjs = (TextView) this.MA.findViewById(n.g.history_tv);
        this.bjt = (TextView) this.MA.findViewById(n.g.bar_info_tv);
        this.bju = (TextView) this.MA.findViewById(n.g.bar_live_tv);
        this.bjv = (LinearLayout) this.MA.findViewById(n.g.recommend_forum_layout);
        this.bjA = (TextView) this.MA.findViewById(n.g.frs_sidebar_good_tv);
        this.bjC = (TextView) this.MA.findViewById(n.g.bar_share_tv);
        this.bjB = (TextView) this.MA.findViewById(n.g.frs_sidebar_add_to_desktop);
        this.bjz = this.MA.findViewById(n.g.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bjs.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bjt.setVisibility(8);
        }
        if (!OC()) {
            this.bjl.setVisibility(8);
            this.bjm.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.MA).addView(createStateBarFillView(), 0);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.bju.setVisibility(8);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.MA != null) {
            this.MA.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean OC() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void cw(boolean z) {
        this.bjz.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.bjw.setVisibility(0);
        } else {
            this.bjw.setVisibility(8);
        }
    }

    public BdSwitchView OD() {
        return this.bjm;
    }

    public boolean OE() {
        return this.bjE;
    }

    public void cx(boolean z) {
        this.bjE = z;
    }

    public void OF() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bjm.me();
        } else {
            this.bjm.mf();
        }
    }

    public void OG() {
        this.bjn.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qQ().qW()) {
            this.bjn.me();
        } else {
            this.bjn.mf();
        }
        this.bjn.setOnSwitchStateChangeListener(this.bjF);
    }

    public void a(dw dwVar, boolean z) {
        if (!z) {
            this.bjo.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (dwVar != null) {
                j = dwVar.Ov() - dwVar.Ow();
            }
            c(this.bjo, j);
            return;
        }
        this.bjo.setVisibility(4);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.as.i((View) textView, n.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.as.i((View) textView, n.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.as.i((View) textView, n.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
        this.bjr.setOnClickListener(this.bjD);
        this.bjs.setOnClickListener(this.bjD);
        this.bjt.setOnClickListener(this.bjD);
        this.bjw.setOnClickListener(this.bjD);
        this.bjz.setOnClickListener(this.bjD);
        this.bjp.setOnClickListener(this.bjD);
        this.bjA.setOnClickListener(this.bjD);
        this.bjB.setOnClickListener(this.bjD);
        this.bjC.setOnClickListener(this.bjD);
        this.bju.setOnClickListener(this.bjD);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ac(i == 1);
        layoutMode.k(this.MA);
        if (i == 1) {
            this.bjm.me();
        } else {
            this.bjm.mf();
        }
        this.MA.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.as.cy(n.f.s_rightbar_bg)));
        this.bjm.a(com.baidu.tbadk.core.util.as.cx(n.f.s_switch_open_bg), com.baidu.tbadk.core.util.as.cx(n.f.s_switch_close_bg), com.baidu.tbadk.core.util.as.cx(n.f.btn_game_handle_2));
        this.bjn.a(com.baidu.tbadk.core.util.as.cx(n.f.s_switch_open_bg), com.baidu.tbadk.core.util.as.cx(n.f.s_switch_close_bg), com.baidu.tbadk.core.util.as.cx(n.f.btn_game_handle_2));
    }
}
