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
    private View LO;
    private LinearLayout aMK;
    private BdSwitchView aML;
    private BdSwitchView aMM;
    private TextView aMN;
    private TextView aMO;
    private LinearLayout aMP;
    private LinearLayout aMQ;
    private LinearLayout aMR;
    private LinearLayout aMS;
    private LinearLayout aMT;
    public LinearLayout aMU;
    private View aMV;
    private TextView aMW;
    private View aMX;
    private View aMY;
    private View aMZ;
    private View.OnClickListener aNa;
    private boolean aNb;
    private final com.baidu.adp.widget.BdSwitchView.b aNc;

    public cj(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aMK = null;
        this.aML = null;
        this.aMM = null;
        this.LO = null;
        this.aMN = null;
        this.aMO = null;
        this.aMP = null;
        this.aMQ = null;
        this.aMR = null;
        this.aMS = null;
        this.aMT = null;
        this.aMU = null;
        this.aMV = null;
        this.aMW = null;
        this.aMX = null;
        this.aNa = null;
        this.aNc = new ck(this);
        initUI();
    }

    public View getView() {
        return this.LO;
    }

    public void init() {
        KI();
        KJ();
    }

    private void initUI() {
        this.LO = com.baidu.adp.lib.g.b.hH().inflate(this.mContext.getPageActivity(), com.baidu.tieba.w.frs_sidebar, null);
        this.aMW = (TextView) this.LO.findViewById(com.baidu.tieba.v.add_recommend);
        this.aMX = this.LO.findViewById(com.baidu.tieba.v.recommend_forum_layout_line);
        this.aMU = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.forum_manager_center);
        this.aMU.setVisibility(8);
        this.aMV = this.LO.findViewById(com.baidu.tieba.v.forum_manager_center_line);
        this.aMV.setVisibility(8);
        this.aMM = (BdSwitchView) this.LO.findViewById(com.baidu.tieba.v.thrift_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aMM, 10, 10, 10, 10);
        this.aMK = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.aML = (BdSwitchView) this.LO.findViewById(com.baidu.tieba.v.eyeshield_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aML, 10, 10, 10, 10);
        this.aMN = (TextView) this.LO.findViewById(com.baidu.tieba.v.message_btn);
        this.aMO = (TextView) this.LO.findViewById(com.baidu.tieba.v.mention_btn);
        this.aMP = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.message_layout);
        this.aMQ = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.mention_layout);
        this.aMR = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.history_layout);
        this.aMS = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.bar_info_layout);
        this.aMT = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.recommend_forum_layout);
        this.aMY = this.LO.findViewById(com.baidu.tieba.v.unfollow_layout_line);
        this.aMZ = this.LO.findViewById(com.baidu.tieba.v.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aMR.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aMS.setVisibility(8);
        }
        TextView textView = (TextView) this.LO.findViewById(com.baidu.tieba.v.content_title);
        if (this.aMR.getVisibility() == 8 && this.aMS.getVisibility() == 8) {
            textView.setVisibility(8);
        }
        if (!KF()) {
            this.aMK.setVisibility(8);
            this.aML.setVisibility(8);
        }
    }

    public boolean KF() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void bU(boolean z) {
        this.aMY.setVisibility(z ? 0 : 8);
        this.aMZ.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aMU.setVisibility(0);
            this.aMV.setVisibility(0);
            return;
        }
        this.aMU.setVisibility(8);
        this.aMV.setVisibility(8);
    }

    public BdSwitchView KG() {
        return this.aML;
    }

    public boolean KH() {
        return this.aNb;
    }

    public void bV(boolean z) {
        this.aNb = z;
    }

    public void KI() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aML.ma();
        } else {
            this.aML.mb();
        }
        this.aML.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
        this.aMM.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
    }

    public void KJ() {
        this.aMM.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.px().pB()) {
            this.aMM.ma();
        } else {
            this.aMM.mb();
        }
        this.aMM.setOnSwitchStateChangeListener(this.aNc);
    }

    public void a(cf cfVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aMN.setVisibility(4);
            this.aMO.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (cfVar != null) {
                j = cfVar.KE();
            }
            a(this.aMN, j);
        } else {
            this.aMN.setVisibility(4);
        }
        if (z2) {
            if (cfVar != null) {
                j = cfVar.KD();
            }
            a(this.aMO, j);
            return;
        }
        this.aMO.setVisibility(4);
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
        this.aNa = onClickListener;
        this.aMP.setOnClickListener(this.aNa);
        this.aMQ.setOnClickListener(this.aNa);
        this.aMR.setOnClickListener(this.aNa);
        this.aMS.setOnClickListener(this.aNa);
        this.aMU.setOnClickListener(this.aNa);
        this.aMZ.setOnClickListener(this.aNa);
    }

    public void z(ArrayList<com.baidu.tbadk.core.data.r> arrayList) {
        this.aMT.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aMW.setVisibility(8);
            this.aMX.setVisibility(0);
            return;
        }
        this.aMW.setVisibility(0);
        this.aMX.setVisibility(8);
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
                String str2 = arrayList.get(i2).PY;
                String str3 = arrayList.get(i2).Qa;
                cl clVar = new cl(this);
                clVar.name = str;
                clVar.aNe = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aNa);
                linearLayout2.setTag(clVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_image)).c(str2, 10, false);
                this.aMT.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.X(i == 1);
        layoutMode.h(this.LO);
        if (i == 1) {
            this.aML.ma();
        } else {
            this.aML.mb();
        }
        this.aML.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
        this.aMM.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close_2), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle_2));
    }
}
