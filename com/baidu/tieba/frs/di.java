package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class di extends com.baidu.adp.base.f {
    private LinearLayout aEC;
    private BdSwitchView aED;
    private BdSwitchView aEE;
    private TextView aEF;
    private TextView aEG;
    private LinearLayout aEH;
    private LinearLayout aEI;
    private LinearLayout aEJ;
    private LinearLayout aEK;
    public LinearLayout aEL;
    private View aEM;
    private TextView aEN;
    private View aEO;
    private View.OnClickListener aEP;
    private boolean aEQ;
    private final com.baidu.adp.widget.BdSwitchView.c aER;
    private View agI;

    public di(Context context) {
        super(context);
        this.aEC = null;
        this.aED = null;
        this.aEE = null;
        this.agI = null;
        this.aEF = null;
        this.aEG = null;
        this.aEH = null;
        this.aEI = null;
        this.aEJ = null;
        this.aEK = null;
        this.aEL = null;
        this.aEM = null;
        this.aEN = null;
        this.aEO = null;
        this.aEP = null;
        this.aER = new dj(this);
        initUI();
    }

    public View getView() {
        return this.agI;
    }

    public void init() {
        GR();
        GS();
    }

    private void initUI() {
        this.agI = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_sidebar, null);
        this.aEN = (TextView) this.agI.findViewById(com.baidu.tieba.v.add_recommend);
        this.aEO = this.agI.findViewById(com.baidu.tieba.v.recommend_forum_layout_line);
        this.aEL = (LinearLayout) this.agI.findViewById(com.baidu.tieba.v.forum_manager_center);
        this.aEL.setVisibility(8);
        this.aEM = this.agI.findViewById(com.baidu.tieba.v.forum_manager_center_line);
        this.aEM.setVisibility(8);
        this.aEE = (BdSwitchView) this.agI.findViewById(com.baidu.tieba.v.thrift_mode_switch);
        this.aEE.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aEC = (LinearLayout) this.agI.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.aED = (BdSwitchView) this.agI.findViewById(com.baidu.tieba.v.eyeshield_mode_switch);
        this.aED.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext);
        this.aED.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aEF = (TextView) this.agI.findViewById(com.baidu.tieba.v.message_btn);
        this.aEG = (TextView) this.agI.findViewById(com.baidu.tieba.v.mention_btn);
        this.aEH = (LinearLayout) this.agI.findViewById(com.baidu.tieba.v.message_layout);
        this.aEI = (LinearLayout) this.agI.findViewById(com.baidu.tieba.v.mention_layout);
        this.aEJ = (LinearLayout) this.agI.findViewById(com.baidu.tieba.v.history_layout);
        this.aEK = (LinearLayout) this.agI.findViewById(com.baidu.tieba.v.recommend_forum_layout);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aEL.setVisibility(0);
            this.aEM.setVisibility(0);
            return;
        }
        this.aEL.setVisibility(8);
        this.aEM.setVisibility(8);
    }

    public BdSwitchView GP() {
        return this.aED;
    }

    public boolean GQ() {
        return this.aEQ;
    }

    public void ch(boolean z) {
        this.aEQ = z;
    }

    public void GR() {
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.aED.gN();
        } else {
            this.aED.gO();
        }
    }

    public void GS() {
        this.aEE.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.js().jw()) {
            this.aEE.gN();
        } else {
            this.aEE.gO();
        }
        this.aEE.setOnSwitchStateChangeListener(this.aER);
    }

    public void a(cz czVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aEF.setVisibility(4);
            this.aEG.setVisibility(4);
            return;
        }
        if (z) {
            a(this.aEF, czVar.GO());
        } else {
            this.aEF.setVisibility(4);
        }
        if (z2) {
            a(this.aEG, czVar.GN());
            return;
        }
        this.aEG.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            TbadkApplication.m251getInst().getSkinType();
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aEP = onClickListener;
        this.aEH.setOnClickListener(this.aEP);
        this.aEI.setOnClickListener(this.aEP);
        this.aEJ.setOnClickListener(this.aEP);
        this.aEL.setOnClickListener(this.aEP);
    }

    public void u(ArrayList<com.baidu.tbadk.core.data.n> arrayList) {
        this.aEK.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aEN.setVisibility(8);
            this.aEO.setVisibility(0);
            return;
        }
        this.aEN.setVisibility(0);
        this.aEO.setVisibility(8);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkApplication.m251getInst().getSkinType();
            com.baidu.tbadk.core.d layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
            layoutMode.L(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_sidebar_item, null);
                layoutMode.h(linearLayout);
                String str = arrayList.get(i2).mForumName;
                String str2 = arrayList.get(i2).zY;
                String str3 = arrayList.get(i2).Aa;
                dk dkVar = new dk(this);
                dkVar.name = str;
                dkVar.aET = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aEP);
                linearLayout2.setTag(dkVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_image)).c(str2, 10, false);
                this.aEK.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.d layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
        layoutMode.L(i == 1);
        layoutMode.h(this.agI);
    }
}
