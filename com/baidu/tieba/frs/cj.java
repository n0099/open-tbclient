package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cj extends com.baidu.adp.base.g<FrsActivity> {
    private View LM;
    private BdSwitchView aMA;
    private BdSwitchView aMB;
    private TextView aMC;
    private TextView aMD;
    private LinearLayout aME;
    private LinearLayout aMF;
    private LinearLayout aMG;
    private LinearLayout aMH;
    private LinearLayout aMI;
    public LinearLayout aMJ;
    private View aMK;
    private TextView aML;
    private View aMM;
    private View aMN;
    private View aMO;
    private View.OnClickListener aMP;
    private boolean aMQ;
    private final com.baidu.adp.widget.BdSwitchView.b aMR;
    private LinearLayout aMz;

    public cj(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aMz = null;
        this.aMA = null;
        this.aMB = null;
        this.LM = null;
        this.aMC = null;
        this.aMD = null;
        this.aME = null;
        this.aMF = null;
        this.aMG = null;
        this.aMH = null;
        this.aMI = null;
        this.aMJ = null;
        this.aMK = null;
        this.aML = null;
        this.aMM = null;
        this.aMP = null;
        this.aMR = new ck(this);
        initUI();
    }

    public View getView() {
        return this.LM;
    }

    public void init() {
        Ky();
        Kz();
    }

    private void initUI() {
        this.LM = com.baidu.adp.lib.g.b.hH().inflate(this.mContext.getPageActivity(), com.baidu.tieba.w.frs_sidebar, null);
        this.aML = (TextView) this.LM.findViewById(com.baidu.tieba.v.add_recommend);
        this.aMM = this.LM.findViewById(com.baidu.tieba.v.recommend_forum_layout_line);
        this.aMJ = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.forum_manager_center);
        this.aMJ.setVisibility(8);
        this.aMK = this.LM.findViewById(com.baidu.tieba.v.forum_manager_center_line);
        this.aMK.setVisibility(8);
        this.aMB = (BdSwitchView) this.LM.findViewById(com.baidu.tieba.v.thrift_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aMB, 10, 10, 10, 10);
        this.aMz = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.aMA = (BdSwitchView) this.LM.findViewById(com.baidu.tieba.v.eyeshield_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aMA, 10, 10, 10, 10);
        this.aMC = (TextView) this.LM.findViewById(com.baidu.tieba.v.message_btn);
        this.aMD = (TextView) this.LM.findViewById(com.baidu.tieba.v.mention_btn);
        this.aME = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.message_layout);
        this.aMF = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.mention_layout);
        this.aMG = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.history_layout);
        this.aMH = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.bar_info_layout);
        this.aMI = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.recommend_forum_layout);
        this.aMN = this.LM.findViewById(com.baidu.tieba.v.unfollow_layout_line);
        this.aMO = this.LM.findViewById(com.baidu.tieba.v.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aMG.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aMH.setVisibility(8);
        }
        TextView textView = (TextView) this.LM.findViewById(com.baidu.tieba.v.content_title);
        if (this.aMG.getVisibility() == 8 && this.aMH.getVisibility() == 8) {
            textView.setVisibility(8);
        }
        if (!Kv()) {
            this.aMz.setVisibility(8);
            this.aMA.setVisibility(8);
        }
    }

    public boolean Kv() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void bW(boolean z) {
        this.aMN.setVisibility(z ? 0 : 8);
        this.aMO.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aMJ.setVisibility(0);
            this.aMK.setVisibility(0);
            return;
        }
        this.aMJ.setVisibility(8);
        this.aMK.setVisibility(8);
    }

    public BdSwitchView Kw() {
        return this.aMA;
    }

    public boolean Kx() {
        return this.aMQ;
    }

    public void bX(boolean z) {
        this.aMQ = z;
    }

    public void Ky() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aMA.ma();
        } else {
            this.aMA.mb();
        }
        this.aMA.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
        this.aMB.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
    }

    public void Kz() {
        this.aMB.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.px().pB()) {
            this.aMB.ma();
        } else {
            this.aMB.mb();
        }
        this.aMB.setOnSwitchStateChangeListener(this.aMR);
    }

    public void a(cf cfVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aMC.setVisibility(4);
            this.aMD.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (cfVar != null) {
                j = cfVar.Ku();
            }
            a(this.aMC, j);
        } else {
            this.aMC.setVisibility(4);
        }
        if (z2) {
            if (cfVar != null) {
                j = cfVar.Kt();
            }
            a(this.aMD, j);
            return;
        }
        this.aMD.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.aMP = onClickListener;
        this.aME.setOnClickListener(this.aMP);
        this.aMF.setOnClickListener(this.aMP);
        this.aMG.setOnClickListener(this.aMP);
        this.aMH.setOnClickListener(this.aMP);
        this.aMJ.setOnClickListener(this.aMP);
        this.aMO.setOnClickListener(this.aMP);
    }

    public void y(ArrayList<com.baidu.tbadk.core.data.r> arrayList) {
        this.aMI.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aML.setVisibility(8);
            this.aMM.setVisibility(0);
            return;
        }
        this.aML.setVisibility(0);
        this.aMM.setVisibility(8);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
            layoutMode.X(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hH().inflate(this.mContext.getPageActivity(), com.baidu.tieba.w.frs_sidebar_item, null);
                layoutMode.h(linearLayout);
                String str = arrayList.get(i2).mForumName;
                String str2 = arrayList.get(i2).PW;
                String str3 = arrayList.get(i2).PY;
                cl clVar = new cl(this);
                clVar.name = str;
                clVar.aMT = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aMP);
                linearLayout2.setTag(clVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_image)).c(str2, 10, false);
                this.aMI.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.X(i == 1);
        layoutMode.h(this.LM);
        if (i == 1) {
            this.aMA.ma();
        } else {
            this.aMA.mb();
        }
        this.aMA.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
        this.aMB.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
    }
}
