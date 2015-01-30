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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalScrollView {
    private View YA;
    private int Yk;
    private g Yq;
    private ArrayList<ae> Yr;
    private t Ys;
    private int Yt;
    private int Yu;
    private LinearLayout Yv;
    private ImageView Yw;
    private TextView Yx;
    private LinearLayout.LayoutParams Yy;
    private boolean Yz;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.Yz = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.Yz = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.Yz = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.Yq = new g(getContext());
        this.Yq.setOrientation(0);
        this.Yq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.Yq.setBaselineAligned(false);
        addView(this.Yq);
        this.Yt = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_tb_padding);
        this.Yu = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_lr_padding);
        this.Yy = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1);
        this.Yq.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_6), 0, 0);
        vp();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setDatas(ArrayList<ae> arrayList) {
        this.Yr = arrayList;
    }

    private TbImageView c(ae aeVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        tbImageView.setPadding(this.Yu, this.Yt, this.Yu, this.Yt);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        bc.i(linearLayout, com.baidu.tieba.v.bg_expression_bar);
        this.Yq.addView(linearLayout, this.Yq.getChildCount() - 1, this.Yy);
        EmotionGroupType vl = aeVar.vl();
        if (vl == EmotionGroupType.LOCAL) {
            if (aeVar.vK() != null) {
                aeVar.vK().a(tbImageView);
            }
            linearLayout.setOnClickListener(new p(this, this.Yq.getChildCount() - 3, null));
        } else if (vl == EmotionGroupType.PROMOTION) {
            if (aeVar.vk() != null) {
                aeVar.vk().a(tbImageView);
            }
            linearLayout.setOnClickListener(new q(this, aeVar.getGroupId(), null));
        } else if (vl == EmotionGroupType.BIG_EMOTION) {
            if (this.Yz) {
                if (aeVar.vK() != null) {
                    aeVar.vK().a(tbImageView);
                }
                linearLayout.setOnClickListener(new p(this, this.Yq.getChildCount() - 3, null));
            } else {
                if (aeVar.vk() != null) {
                    aeVar.vk().a(tbImageView);
                }
                linearLayout.setOnClickListener(new m(this));
            }
        }
        return tbImageView;
    }

    public void vp() {
        this.Yw = new ImageView(getContext());
        bc.c(this.Yw, com.baidu.tieba.v.icon_store);
        this.Yw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.Yw.setPadding(this.Yu, this.Yt, this.Yu, this.Yt);
        this.Yv = new LinearLayout(getContext());
        this.Yv.addView(this.Yw, new LinearLayout.LayoutParams(-1, -1));
        bc.i(this.Yv, com.baidu.tieba.v.bg_expression_bar);
        this.Yx = new TextView(getContext());
        this.Yx.setGravity(17);
        this.Yx.setTextSize(10.0f);
        this.Yx.setText("N");
        this.Yx.setTextColor(this.Yk == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        bc.i((View) this.Yx, com.baidu.tieba.v.icon_news_head_prompt_one);
        this.Yx.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.Yq.addView(this.Yv, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1));
        this.Yq.setNewView(this.Yx);
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            this.Yq.setNewViewVisible(true);
        } else {
            this.Yq.setNewViewVisible(false);
        }
        this.Yv.setOnClickListener(new n(this));
        this.YA = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.YA.setLayoutParams(layoutParams);
        bc.i(this.YA, com.baidu.tieba.v.bg_expression_bar_n);
        this.Yq.addView(this.YA);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2902010)) {
            this.Yv.setVisibility(8);
        }
    }

    public void d(ae aeVar) {
        c(aeVar);
    }

    public void f(int i, boolean z) {
        this.Yz = z;
        int i2 = i + 1;
        int childCount = this.Yq.getChildCount();
        ae aeVar = this.Yr.get(i2 - 1);
        if (i2 < childCount && aeVar.vl() == EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.Yq.getChildAt(i2);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (!this.Yz) {
                linearLayout.setOnClickListener(new o(this));
                if (aeVar.vk() != null) {
                    aeVar.vk().a(tbImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new p(this, i2 - 1, null));
            if (aeVar.vK() != null) {
                aeVar.vK().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                ((LinearLayout) this.Yq.getChildAt(this.mCurrentIndex + 1)).setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout = (LinearLayout) this.Yq.getChildAt(this.mCurrentIndex + 1);
            linearLayout.setSelected(true);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            ae aeVar = this.Yr.get(this.mCurrentIndex);
            if (aeVar.vK() != null) {
                aeVar.vK().a(tbImageView);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.Yq.removeAllViews();
        vp();
    }

    public void ct(int i) {
        this.Yk = i;
        if (this.Yw != null) {
            bc.a(this.Yw, com.baidu.tieba.v.icon_store, i);
        }
        if (this.Yv != null) {
            bc.c(this.Yv, com.baidu.tieba.v.bg_expression_bar, i);
        }
        if (this.Yx != null) {
            bc.c(this.Yx, com.baidu.tieba.v.icon_news_head_prompt_one, i);
            this.Yx.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.Yq.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.Yq.getChildAt(i2);
            if (childAt != null) {
                bc.c(childAt, com.baidu.tieba.v.bg_expression_bar, i);
            }
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        this.Ys = tVar;
    }
}
