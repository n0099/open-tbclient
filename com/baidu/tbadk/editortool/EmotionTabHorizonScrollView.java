package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalScrollView {
    private int RD;
    private g RJ;
    private int RK;
    private ArrayList<ad> RL;
    private t RM;
    private int RN;
    private int RO;
    private LinearLayout RP;
    private ImageView RQ;
    private TextView RR;
    private LinearLayout.LayoutParams RS;
    private boolean RT;
    private View RU;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RK = -1;
        this.RT = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RK = -1;
        this.RT = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.RK = -1;
        this.RT = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.RJ = new g(getContext());
        this.RJ.setOrientation(0);
        this.RJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.RJ.setBaselineAligned(false);
        addView(this.RJ);
        this.RN = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_tb_padding);
        this.RO = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_lr_padding);
        this.RS = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1);
        this.RJ.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_6), 0, 0);
        rv();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.RL = arrayList;
    }

    private TbImageView c(ad adVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        tbImageView.setPadding(this.RO, this.RN, this.RO, this.RN);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aw.h(linearLayout, com.baidu.tieba.u.bg_expression_bar);
        this.RJ.addView(linearLayout, this.RJ.getChildCount() - 1, this.RS);
        EmotionGroupType rr = adVar.rr();
        if (rr == EmotionGroupType.LOCAL) {
            if (adVar.rP() != null) {
                adVar.rP().a(tbImageView);
            }
            linearLayout.setOnClickListener(new p(this, this.RJ.getChildCount() - 3, null));
        } else if (rr == EmotionGroupType.PROMOTION) {
            if (adVar.rp() != null) {
                adVar.rp().a(tbImageView);
            }
            linearLayout.setOnClickListener(new q(this, adVar.getGroupId(), null));
        } else if (rr == EmotionGroupType.BIG_EMOTION) {
            if (this.RT) {
                if (adVar.rP() != null) {
                    adVar.rP().a(tbImageView);
                }
                linearLayout.setOnClickListener(new p(this, this.RJ.getChildCount() - 3, null));
            } else {
                if (adVar.rp() != null) {
                    adVar.rp().a(tbImageView);
                }
                linearLayout.setOnClickListener(new m(this));
            }
        }
        return tbImageView;
    }

    public void rv() {
        this.RQ = new ImageView(getContext());
        aw.c(this.RQ, com.baidu.tieba.u.icon_store);
        this.RQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.RQ.setPadding(this.RO, this.RN, this.RO, this.RN);
        this.RP = new LinearLayout(getContext());
        this.RP.addView(this.RQ, new LinearLayout.LayoutParams(-1, -1));
        aw.h(this.RP, com.baidu.tieba.u.bg_expression_bar);
        this.RR = new TextView(getContext());
        this.RR.setGravity(17);
        this.RR.setTextSize(10.0f);
        this.RR.setText("N");
        this.RR.setTextColor(this.RD == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        aw.h((View) this.RR, com.baidu.tieba.u.icon_news_head_prompt_one);
        this.RR.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.RJ.addView(this.RP, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1));
        this.RJ.setNewView(this.RR);
        if (TbadkApplication.m251getInst().isFaceShopNew()) {
            this.RJ.setNewViewVisible(true);
        } else {
            this.RJ.setNewViewVisible(false);
        }
        this.RP.setOnClickListener(new n(this));
        this.RU = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.RU.setLayoutParams(layoutParams);
        aw.h(this.RU, com.baidu.tieba.u.bg_expression_bar_n);
        this.RJ.addView(this.RU);
    }

    public void d(ad adVar) {
        c(adVar);
    }

    public void f(int i, boolean z) {
        this.RT = z;
        int i2 = i + 1;
        int childCount = this.RJ.getChildCount();
        ad adVar = this.RL.get(i2 - 1);
        if (i2 < childCount && adVar.rr() == EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.RJ.getChildAt(i2);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (!this.RT) {
                linearLayout.setOnClickListener(new o(this));
                if (adVar.rp() != null) {
                    adVar.rp().a(tbImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new p(this, i2 - 1, null));
            if (adVar.rP() != null) {
                adVar.rP().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i != this.RK) {
            if (this.RK != -1) {
                ((LinearLayout) this.RJ.getChildAt(this.RK + 1)).setSelected(false);
            }
            this.RK = i;
            LinearLayout linearLayout = (LinearLayout) this.RJ.getChildAt(this.RK + 1);
            linearLayout.setSelected(true);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            ad adVar = this.RL.get(this.RK);
            if (adVar.rP() != null) {
                adVar.rP().a(tbImageView);
            }
        }
    }

    public void reset() {
        this.RK = -1;
        this.RJ.removeAllViews();
        rv();
    }

    public void bN(int i) {
        this.RD = i;
        if (this.RQ != null) {
            aw.a(this.RQ, com.baidu.tieba.u.icon_store, i);
        }
        if (this.RP != null) {
            aw.c(this.RP, com.baidu.tieba.u.bg_expression_bar, i);
        }
        if (this.RR != null) {
            aw.c(this.RR, com.baidu.tieba.u.icon_news_head_prompt_one, i);
            this.RR.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.RJ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.RJ.getChildAt(i2);
            if (childAt != null) {
                aw.c(childAt, com.baidu.tieba.u.bg_expression_bar, i);
            }
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        this.RM = tVar;
    }
}
