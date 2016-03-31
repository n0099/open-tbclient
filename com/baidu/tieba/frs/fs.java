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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class fs extends com.baidu.adp.base.f<FrsActivity> {
    private View MW;
    private LinearLayout aTs;
    private LinearLayout brA;
    private TextView brB;
    private TextView brC;
    private LinearLayout brD;
    public TextView brE;
    private TextView brF;
    private View brG;
    private View brH;
    private TextView brI;
    private TextView brJ;
    private TextView brK;
    private View.OnClickListener brL;
    private boolean brM;
    private long brN;
    private final BdSwitchView.a brO;
    private RelativeLayout brv;
    private BdSwitchView brw;
    private BdSwitchView brx;
    private TextView bry;
    private LinearLayout brz;

    /* loaded from: classes.dex */
    public class a {
        public String brQ;
        public String name;
    }

    public fs(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.brv = null;
        this.brw = null;
        this.brx = null;
        this.MW = null;
        this.bry = null;
        this.brz = null;
        this.aTs = null;
        this.brA = null;
        this.brB = null;
        this.brC = null;
        this.brD = null;
        this.brE = null;
        this.brF = null;
        this.brG = null;
        this.brL = null;
        this.brN = 0L;
        this.brO = new ft(this);
        pU();
    }

    public View getView() {
        return this.MW;
    }

    public void init() {
        SA();
        SB();
    }

    private void Sw() {
    }

    private void pU() {
        this.MW = LayoutInflater.from(this.mContext.getPageActivity()).inflate(t.h.frs_sidebar, (ViewGroup) null);
        Sw();
        this.brz = (LinearLayout) this.MW.findViewById(t.g.post_search_ll);
        this.aTs = (LinearLayout) this.MW.findViewById(t.g.show_content);
        this.brF = (TextView) this.MW.findViewById(t.g.add_recommend);
        this.brG = this.MW.findViewById(t.g.recommend_forum_layout_line);
        this.brE = (TextView) this.MW.findViewById(t.g.forum_manager_center);
        this.brE.setVisibility(8);
        this.brx = (BdSwitchView) this.MW.findViewById(t.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.brx, 10, 10, 10, 10);
        this.brv = (RelativeLayout) this.MW.findViewById(t.g.eyeshield_mode);
        this.brw = (BdSwitchView) this.MW.findViewById(t.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.brw, 10, 10, 10, 10);
        this.brw.a(com.baidu.tbadk.core.util.at.cR(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cR(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cR(t.f.btn_game_handle_2));
        this.brx.a(com.baidu.tbadk.core.util.at.cR(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cR(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cR(t.f.btn_game_handle_2));
        this.bry = (TextView) this.MW.findViewById(t.g.message_btn);
        this.brA = (LinearLayout) this.MW.findViewById(t.g.message_layout);
        this.brB = (TextView) this.MW.findViewById(t.g.history_tv);
        this.brC = (TextView) this.MW.findViewById(t.g.bar_info_tv);
        this.brD = (LinearLayout) this.MW.findViewById(t.g.recommend_forum_layout);
        this.brI = (TextView) this.MW.findViewById(t.g.frs_sidebar_good_tv);
        this.brK = (TextView) this.MW.findViewById(t.g.bar_share_tv);
        this.brJ = (TextView) this.MW.findViewById(t.g.frs_sidebar_add_to_desktop);
        this.brH = this.MW.findViewById(t.g.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.brB.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.brC.setVisibility(8);
        }
        if (!Sx()) {
            this.brv.setVisibility(8);
            this.brw.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.MW).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.MW != null) {
            this.MW.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean Sx() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void cI(boolean z) {
        this.brH.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.brE.setVisibility(0);
        } else {
            this.brE.setVisibility(8);
        }
    }

    public BdSwitchView Sy() {
        return this.brw;
    }

    public boolean Sz() {
        return this.brM;
    }

    public void cJ(boolean z) {
        this.brM = z;
    }

    public void SA() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.brw.mk();
            this.brw.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_on));
            return;
        }
        this.brw.ml();
        this.brw.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_off));
    }

    public void SB() {
        this.brx.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.qE().qK()) {
            this.brx.mk();
            this.brx.setContentDescription(String.valueOf(this.mContext.getString(t.j.image_show_setting)) + this.mContext.getString(t.j.now_state_on));
        } else {
            this.brx.ml();
            this.brx.setContentDescription(String.valueOf(this.mContext.getString(t.j.image_show_setting)) + this.mContext.getString(t.j.now_state_off));
        }
        this.brx.setOnSwitchStateChangeListener(this.brO);
    }

    public void a(ei eiVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bry.setVisibility(4);
            this.brN = 0L;
            return;
        }
        if (eiVar != null) {
            j = eiVar.Sq() - eiVar.Sr();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ah()) {
                j -= eiVar.Ss();
            }
        }
        this.brN = j;
        c(this.bry, j);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
        this.brA.setOnClickListener(this.brL);
        this.brB.setOnClickListener(this.brL);
        this.brC.setOnClickListener(this.brL);
        this.brE.setOnClickListener(this.brL);
        this.brH.setOnClickListener(this.brL);
        this.brz.setOnClickListener(this.brL);
        this.brI.setOnClickListener(this.brL);
        this.brJ.setOnClickListener(this.brL);
        this.brK.setOnClickListener(this.brL);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.x(this.MW);
        c(this.bry, this.brN);
        if (i == 1) {
            this.brw.mk();
            this.brw.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_on));
        } else {
            this.brw.ml();
            this.brw.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_off));
        }
        this.MW.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.at.cS(t.f.s_rightbar_bg)));
        this.brw.a(com.baidu.tbadk.core.util.at.cR(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cR(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cR(t.f.btn_game_handle_2));
        this.brx.a(com.baidu.tbadk.core.util.at.cR(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cR(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cR(t.f.btn_game_handle_2));
    }
}
