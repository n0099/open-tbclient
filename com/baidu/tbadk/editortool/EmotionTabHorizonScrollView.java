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
    private int Yh;
    private g Yn;
    private ArrayList<ae> Yo;
    private t Yp;
    private int Yq;
    private int Yr;
    private LinearLayout Ys;
    private ImageView Yt;
    private TextView Yu;
    private LinearLayout.LayoutParams Yv;
    private boolean Yw;
    private View Yx;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.Yw = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.Yw = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.Yw = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.Yn = new g(getContext());
        this.Yn.setOrientation(0);
        this.Yn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.Yn.setBaselineAligned(false);
        addView(this.Yn);
        this.Yq = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_tb_padding);
        this.Yr = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_lr_padding);
        this.Yv = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1);
        this.Yn.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_6), 0, 0);
        vj();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setDatas(ArrayList<ae> arrayList) {
        this.Yo = arrayList;
    }

    private TbImageView c(ae aeVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        tbImageView.setPadding(this.Yr, this.Yq, this.Yr, this.Yq);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        bc.i(linearLayout, com.baidu.tieba.v.bg_expression_bar);
        this.Yn.addView(linearLayout, this.Yn.getChildCount() - 1, this.Yv);
        EmotionGroupType vf = aeVar.vf();
        if (vf == EmotionGroupType.LOCAL) {
            if (aeVar.vE() != null) {
                aeVar.vE().a(tbImageView);
            }
            linearLayout.setOnClickListener(new p(this, this.Yn.getChildCount() - 3, null));
        } else if (vf == EmotionGroupType.PROMOTION) {
            if (aeVar.ve() != null) {
                aeVar.ve().a(tbImageView);
            }
            linearLayout.setOnClickListener(new q(this, aeVar.getGroupId(), null));
        } else if (vf == EmotionGroupType.BIG_EMOTION) {
            if (this.Yw) {
                if (aeVar.vE() != null) {
                    aeVar.vE().a(tbImageView);
                }
                linearLayout.setOnClickListener(new p(this, this.Yn.getChildCount() - 3, null));
            } else {
                if (aeVar.ve() != null) {
                    aeVar.ve().a(tbImageView);
                }
                linearLayout.setOnClickListener(new m(this));
            }
        }
        return tbImageView;
    }

    public void vj() {
        this.Yt = new ImageView(getContext());
        bc.c(this.Yt, com.baidu.tieba.v.icon_store);
        this.Yt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.Yt.setPadding(this.Yr, this.Yq, this.Yr, this.Yq);
        this.Ys = new LinearLayout(getContext());
        this.Ys.addView(this.Yt, new LinearLayout.LayoutParams(-1, -1));
        bc.i(this.Ys, com.baidu.tieba.v.bg_expression_bar);
        this.Yu = new TextView(getContext());
        this.Yu.setGravity(17);
        this.Yu.setTextSize(10.0f);
        this.Yu.setText("N");
        this.Yu.setTextColor(this.Yh == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        bc.i((View) this.Yu, com.baidu.tieba.v.icon_news_head_prompt_one);
        this.Yu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.Yn.addView(this.Ys, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1));
        this.Yn.setNewView(this.Yu);
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            this.Yn.setNewViewVisible(true);
        } else {
            this.Yn.setNewViewVisible(false);
        }
        this.Ys.setOnClickListener(new n(this));
        this.Yx = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.Yx.setLayoutParams(layoutParams);
        bc.i(this.Yx, com.baidu.tieba.v.bg_expression_bar_n);
        this.Yn.addView(this.Yx);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2902010)) {
            this.Ys.setVisibility(8);
        }
    }

    public void d(ae aeVar) {
        c(aeVar);
    }

    public void f(int i, boolean z) {
        this.Yw = z;
        int i2 = i + 1;
        int childCount = this.Yn.getChildCount();
        ae aeVar = this.Yo.get(i2 - 1);
        if (i2 < childCount && aeVar.vf() == EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.Yn.getChildAt(i2);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (!this.Yw) {
                linearLayout.setOnClickListener(new o(this));
                if (aeVar.ve() != null) {
                    aeVar.ve().a(tbImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new p(this, i2 - 1, null));
            if (aeVar.vE() != null) {
                aeVar.vE().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                ((LinearLayout) this.Yn.getChildAt(this.mCurrentIndex + 1)).setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout = (LinearLayout) this.Yn.getChildAt(this.mCurrentIndex + 1);
            linearLayout.setSelected(true);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            ae aeVar = this.Yo.get(this.mCurrentIndex);
            if (aeVar.vE() != null) {
                aeVar.vE().a(tbImageView);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.Yn.removeAllViews();
        vj();
    }

    public void ct(int i) {
        this.Yh = i;
        if (this.Yt != null) {
            bc.a(this.Yt, com.baidu.tieba.v.icon_store, i);
        }
        if (this.Ys != null) {
            bc.c(this.Ys, com.baidu.tieba.v.bg_expression_bar, i);
        }
        if (this.Yu != null) {
            bc.c(this.Yu, com.baidu.tieba.v.icon_news_head_prompt_one, i);
            this.Yu.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.Yn.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.Yn.getChildAt(i2);
            if (childAt != null) {
                bc.c(childAt, com.baidu.tieba.v.bg_expression_bar, i);
            }
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        this.Yp = tVar;
    }
}
