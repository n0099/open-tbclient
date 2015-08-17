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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dg extends com.baidu.adp.base.f<FrsActivity> {
    private View LR;
    private RelativeLayout aYK;
    private BdSwitchView aYL;
    private BdSwitchView aYM;
    private TextView aYN;
    private TextView aYO;
    private LinearLayout aYP;
    private LinearLayout aYQ;
    private LinearLayout aYR;
    private LinearLayout aYS;
    private TextView aYT;
    private TextView aYU;
    private LinearLayout aYV;
    public TextView aYW;
    private TextView aYX;
    private View aYY;
    private View aYZ;
    private TextView aZa;
    private TextView aZb;
    private View.OnClickListener aZc;
    private boolean aZd;
    private final BdSwitchView.a aZe;
    private View mRootView;

    /* loaded from: classes.dex */
    public class a {
        public String aZg;
        public String name;
    }

    public dg(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aYK = null;
        this.aYL = null;
        this.aYM = null;
        this.LR = null;
        this.aYN = null;
        this.aYO = null;
        this.aYP = null;
        this.aYQ = null;
        this.aYR = null;
        this.aYS = null;
        this.aYT = null;
        this.aYU = null;
        this.aYV = null;
        this.aYW = null;
        this.aYX = null;
        this.aYY = null;
        this.aZc = null;
        this.aZe = new dh(this);
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
        this.mRootView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.al.cs(i.e.bg_home)));
    }

    private void initUI() {
        this.LR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_sidebar, (ViewGroup) null);
        Mz();
        this.aYP = (LinearLayout) this.LR.findViewById(i.f.post_search_ll);
        this.aYQ = (LinearLayout) this.LR.findViewById(i.f.show_content);
        this.aYX = (TextView) this.LR.findViewById(i.f.add_recommend);
        this.aYY = this.LR.findViewById(i.f.recommend_forum_layout_line);
        this.aYW = (TextView) this.LR.findViewById(i.f.forum_manager_center);
        this.aYW.setVisibility(8);
        this.aYM = (BdSwitchView) this.LR.findViewById(i.f.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aYM, 10, 10, 10, 10);
        this.aYK = (RelativeLayout) this.LR.findViewById(i.f.eyeshield_mode);
        this.aYL = (BdSwitchView) this.LR.findViewById(i.f.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.aYL, 10, 10, 10, 10);
        this.aYN = (TextView) this.LR.findViewById(i.f.message_btn);
        this.aYO = (TextView) this.LR.findViewById(i.f.mention_btn);
        this.aYR = (LinearLayout) this.LR.findViewById(i.f.message_layout);
        this.aYS = (LinearLayout) this.LR.findViewById(i.f.mention_layout);
        this.aYT = (TextView) this.LR.findViewById(i.f.history_tv);
        this.aYU = (TextView) this.LR.findViewById(i.f.bar_info_tv);
        this.aYV = (LinearLayout) this.LR.findViewById(i.f.recommend_forum_layout);
        this.aZa = (TextView) this.LR.findViewById(i.f.frs_sidebar_good_tv);
        this.aZb = (TextView) this.LR.findViewById(i.f.frs_sidebar_add_to_desktop);
        this.aYZ = this.LR.findViewById(i.f.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aYT.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aYU.setVisibility(8);
        }
        if (!MA()) {
            this.aYK.setVisibility(8);
            this.aYL.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aYQ.addView(createStateBarFillView(), 0);
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

    public void ce(boolean z) {
        this.aYZ.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aYW.setVisibility(0);
        } else {
            this.aYW.setVisibility(8);
        }
    }

    public BdSwitchView MB() {
        return this.aYL;
    }

    public boolean MC() {
        return this.aZd;
    }

    public void cf(boolean z) {
        this.aZd = z;
    }

    public void MD() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aYL.mD();
        } else {
            this.aYL.mE();
        }
    }

    public void ME() {
        this.aYM.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.rd().rh()) {
            this.aYM.mD();
        } else {
            this.aYM.mE();
        }
        this.aYM.setOnSwitchStateChangeListener(this.aZe);
    }

    public void a(cn cnVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aYN.setVisibility(4);
            this.aYO.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (cnVar != null) {
                j = cnVar.Mw();
            }
            a(this.aYN, j);
        } else {
            this.aYN.setVisibility(4);
        }
        if (z2) {
            if (cnVar != null) {
                j = cnVar.Mv();
            }
            a(this.aYO, j);
            return;
        }
        this.aYO.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.al.i((View) textView, i.e.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.al.i((View) textView, i.e.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.al.i((View) textView, i.e.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.aZc = onClickListener;
        this.aYR.setOnClickListener(this.aZc);
        this.aYS.setOnClickListener(this.aZc);
        this.aYT.setOnClickListener(this.aZc);
        this.aYU.setOnClickListener(this.aZc);
        this.aYW.setOnClickListener(this.aZc);
        this.aYZ.setOnClickListener(this.aZc);
        this.aYP.setOnClickListener(this.aZc);
        this.aZa.setOnClickListener(this.aZc);
        this.aZb.setOnClickListener(this.aZc);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(this.LR);
        if (i == 1) {
            this.aYL.mD();
        } else {
            this.aYL.mE();
        }
        this.aYL.a(com.baidu.tbadk.core.util.al.cq(i.e.bg_game_switch_open_2), com.baidu.tbadk.core.util.al.cq(i.e.bg_game_switch_close_2), com.baidu.tbadk.core.util.al.cq(i.e.btn_game_handle_2));
        this.aYM.a(com.baidu.tbadk.core.util.al.cq(i.e.bg_game_switch_open_2), com.baidu.tbadk.core.util.al.cq(i.e.bg_game_switch_close_2), com.baidu.tbadk.core.util.al.cq(i.e.btn_game_handle_2));
    }
}
