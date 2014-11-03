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
    private int RH;
    private g RN;
    private int RO;
    private ArrayList<ad> RP;
    private t RQ;
    private int RR;
    private int RS;
    private LinearLayout RT;
    private ImageView RU;
    private TextView RV;
    private LinearLayout.LayoutParams RW;
    private boolean RX;
    private View RY;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RO = -1;
        this.RX = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RO = -1;
        this.RX = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.RO = -1;
        this.RX = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.RN = new g(getContext());
        this.RN.setOrientation(0);
        this.RN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.RN.setBaselineAligned(false);
        addView(this.RN);
        this.RR = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_tb_padding);
        this.RS = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_lr_padding);
        this.RW = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1);
        this.RN.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_6), 0, 0);
        rx();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setDatas(ArrayList<ad> arrayList) {
        this.RP = arrayList;
    }

    private TbImageView c(ad adVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        tbImageView.setPadding(this.RS, this.RR, this.RS, this.RR);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aw.h(linearLayout, com.baidu.tieba.u.bg_expression_bar);
        this.RN.addView(linearLayout, this.RN.getChildCount() - 1, this.RW);
        EmotionGroupType rt = adVar.rt();
        if (rt == EmotionGroupType.LOCAL) {
            if (adVar.rR() != null) {
                adVar.rR().a(tbImageView);
            }
            linearLayout.setOnClickListener(new p(this, this.RN.getChildCount() - 3, null));
        } else if (rt == EmotionGroupType.PROMOTION) {
            if (adVar.rr() != null) {
                adVar.rr().a(tbImageView);
            }
            linearLayout.setOnClickListener(new q(this, adVar.getGroupId(), null));
        } else if (rt == EmotionGroupType.BIG_EMOTION) {
            if (this.RX) {
                if (adVar.rR() != null) {
                    adVar.rR().a(tbImageView);
                }
                linearLayout.setOnClickListener(new p(this, this.RN.getChildCount() - 3, null));
            } else {
                if (adVar.rr() != null) {
                    adVar.rr().a(tbImageView);
                }
                linearLayout.setOnClickListener(new m(this));
            }
        }
        return tbImageView;
    }

    public void rx() {
        this.RU = new ImageView(getContext());
        aw.c(this.RU, com.baidu.tieba.u.icon_store);
        this.RU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.RU.setPadding(this.RS, this.RR, this.RS, this.RR);
        this.RT = new LinearLayout(getContext());
        this.RT.addView(this.RU, new LinearLayout.LayoutParams(-1, -1));
        aw.h(this.RT, com.baidu.tieba.u.bg_expression_bar);
        this.RV = new TextView(getContext());
        this.RV.setGravity(17);
        this.RV.setTextSize(10.0f);
        this.RV.setText("N");
        this.RV.setTextColor(this.RH == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        aw.h((View) this.RV, com.baidu.tieba.u.icon_news_head_prompt_one);
        this.RV.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.RN.addView(this.RT, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1));
        this.RN.setNewView(this.RV);
        if (TbadkApplication.m251getInst().isFaceShopNew()) {
            this.RN.setNewViewVisible(true);
        } else {
            this.RN.setNewViewVisible(false);
        }
        this.RT.setOnClickListener(new n(this));
        this.RY = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.RY.setLayoutParams(layoutParams);
        aw.h(this.RY, com.baidu.tieba.u.bg_expression_bar_n);
        this.RN.addView(this.RY);
    }

    public void d(ad adVar) {
        c(adVar);
    }

    public void f(int i, boolean z) {
        this.RX = z;
        int i2 = i + 1;
        int childCount = this.RN.getChildCount();
        ad adVar = this.RP.get(i2 - 1);
        if (i2 < childCount && adVar.rt() == EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.RN.getChildAt(i2);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (!this.RX) {
                linearLayout.setOnClickListener(new o(this));
                if (adVar.rr() != null) {
                    adVar.rr().a(tbImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new p(this, i2 - 1, null));
            if (adVar.rR() != null) {
                adVar.rR().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i != this.RO) {
            if (this.RO != -1) {
                ((LinearLayout) this.RN.getChildAt(this.RO + 1)).setSelected(false);
            }
            this.RO = i;
            LinearLayout linearLayout = (LinearLayout) this.RN.getChildAt(this.RO + 1);
            linearLayout.setSelected(true);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            ad adVar = this.RP.get(this.RO);
            if (adVar.rR() != null) {
                adVar.rR().a(tbImageView);
            }
        }
    }

    public void reset() {
        this.RO = -1;
        this.RN.removeAllViews();
        rx();
    }

    public void bN(int i) {
        this.RH = i;
        if (this.RU != null) {
            aw.a(this.RU, com.baidu.tieba.u.icon_store, i);
        }
        if (this.RT != null) {
            aw.c(this.RT, com.baidu.tieba.u.bg_expression_bar, i);
        }
        if (this.RV != null) {
            aw.c(this.RV, com.baidu.tieba.u.icon_news_head_prompt_one, i);
            this.RV.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.RN.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.RN.getChildAt(i2);
            if (childAt != null) {
                aw.c(childAt, com.baidu.tieba.u.bg_expression_bar, i);
            }
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        this.RQ = tVar;
    }
}
