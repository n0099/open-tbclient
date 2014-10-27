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
    private LinearLayout aEA;
    public LinearLayout aEB;
    private View aEC;
    private TextView aED;
    private View aEE;
    private View.OnClickListener aEF;
    private boolean aEG;
    private final com.baidu.adp.widget.BdSwitchView.c aEH;
    private LinearLayout aEs;
    private BdSwitchView aEt;
    private BdSwitchView aEu;
    private TextView aEv;
    private TextView aEw;
    private LinearLayout aEx;
    private LinearLayout aEy;
    private LinearLayout aEz;
    private View agA;

    public di(Context context) {
        super(context);
        this.aEs = null;
        this.aEt = null;
        this.aEu = null;
        this.agA = null;
        this.aEv = null;
        this.aEw = null;
        this.aEx = null;
        this.aEy = null;
        this.aEz = null;
        this.aEA = null;
        this.aEB = null;
        this.aEC = null;
        this.aED = null;
        this.aEE = null;
        this.aEF = null;
        this.aEH = new dj(this);
        initUI();
    }

    public View getView() {
        return this.agA;
    }

    public void init() {
        GP();
        GQ();
    }

    private void initUI() {
        this.agA = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_sidebar, null);
        this.aED = (TextView) this.agA.findViewById(com.baidu.tieba.v.add_recommend);
        this.aEE = this.agA.findViewById(com.baidu.tieba.v.recommend_forum_layout_line);
        this.aEB = (LinearLayout) this.agA.findViewById(com.baidu.tieba.v.forum_manager_center);
        this.aEB.setVisibility(8);
        this.aEC = this.agA.findViewById(com.baidu.tieba.v.forum_manager_center_line);
        this.aEC.setVisibility(8);
        this.aEu = (BdSwitchView) this.agA.findViewById(com.baidu.tieba.v.thrift_mode_switch);
        this.aEu.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aEs = (LinearLayout) this.agA.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.aEt = (BdSwitchView) this.agA.findViewById(com.baidu.tieba.v.eyeshield_mode_switch);
        this.aEt.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext);
        this.aEt.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aEv = (TextView) this.agA.findViewById(com.baidu.tieba.v.message_btn);
        this.aEw = (TextView) this.agA.findViewById(com.baidu.tieba.v.mention_btn);
        this.aEx = (LinearLayout) this.agA.findViewById(com.baidu.tieba.v.message_layout);
        this.aEy = (LinearLayout) this.agA.findViewById(com.baidu.tieba.v.mention_layout);
        this.aEz = (LinearLayout) this.agA.findViewById(com.baidu.tieba.v.history_layout);
        this.aEA = (LinearLayout) this.agA.findViewById(com.baidu.tieba.v.recommend_forum_layout);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aEB.setVisibility(0);
            this.aEC.setVisibility(0);
            return;
        }
        this.aEB.setVisibility(8);
        this.aEC.setVisibility(8);
    }

    public BdSwitchView GN() {
        return this.aEt;
    }

    public boolean GO() {
        return this.aEG;
    }

    public void ch(boolean z) {
        this.aEG = z;
    }

    public void GP() {
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.aEt.gN();
        } else {
            this.aEt.gO();
        }
    }

    public void GQ() {
        this.aEu.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.k.js().jw()) {
            this.aEu.gN();
        } else {
            this.aEu.gO();
        }
        this.aEu.setOnSwitchStateChangeListener(this.aEH);
    }

    public void a(cz czVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aEv.setVisibility(4);
            this.aEw.setVisibility(4);
            return;
        }
        if (z) {
            a(this.aEv, czVar.GM());
        } else {
            this.aEv.setVisibility(4);
        }
        if (z2) {
            a(this.aEw, czVar.GL());
            return;
        }
        this.aEw.setVisibility(4);
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
        this.aEF = onClickListener;
        this.aEx.setOnClickListener(this.aEF);
        this.aEy.setOnClickListener(this.aEF);
        this.aEz.setOnClickListener(this.aEF);
        this.aEB.setOnClickListener(this.aEF);
    }

    public void t(ArrayList<com.baidu.tbadk.core.data.n> arrayList) {
        this.aEA.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aED.setVisibility(8);
            this.aEE.setVisibility(0);
            return;
        }
        this.aED.setVisibility(0);
        this.aEE.setVisibility(8);
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
                dkVar.aEJ = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aEF);
                linearLayout2.setTag(dkVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_image)).c(str2, 10, false);
                this.aEA.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.d layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
        layoutMode.L(i == 1);
        layoutMode.h(this.agA);
    }
}
