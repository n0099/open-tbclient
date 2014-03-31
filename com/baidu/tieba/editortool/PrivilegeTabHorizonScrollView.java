package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import java.util.List;
/* loaded from: classes.dex */
public class PrivilegeTabHorizonScrollView extends HorizontalScrollView {
    private ad a;
    private int b;
    private List<ag> c;
    private an d;
    private LinearLayout.LayoutParams e;
    private int f;
    private int g;
    private TextView h;
    private View i;

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        b();
    }

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        b();
    }

    public PrivilegeTabHorizonScrollView(Context context) {
        super(context);
        this.b = -1;
        b();
    }

    private void b() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.a = new ad(getContext());
        this.a.setOrientation(0);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setBaselineAligned(false);
        addView(this.a);
        this.f = getResources().getDimensionPixelSize(com.baidu.tieba.a.f.face_tab_widget_tb_padding);
        this.g = getResources().getDimensionPixelSize(com.baidu.tieba.a.f.face_tab_widget_lr_padding);
        this.a.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_6), 0, 0);
        this.e = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.a.f.face_tab_widget_width), -1);
        this.i = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.i.setLayoutParams(layoutParams);
        ba.f(this.i, com.baidu.tieba.a.g.bg_expression_bar_n);
        this.a.addView(this.i);
    }

    public void setDatas(List<ag> list) {
        this.c = list;
    }

    public final void a(ai aiVar) {
        if (aiVar != null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            BDImageView bDImageView = new BDImageView(getContext());
            linearLayout.addView(bDImageView, new LinearLayout.LayoutParams(-1, -1));
            if (TbadkApplication.j().l() == 1) {
                linearLayout.setBackgroundResource(com.baidu.tieba.a.g.bg_expression_bar_1);
            } else {
                linearLayout.setBackgroundResource(com.baidu.tieba.a.g.bg_expression_bar);
            }
            bDImageView.setPadding(this.g, this.f, this.g, this.f);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            ba.c((ImageView) bDImageView, aiVar.b);
            linearLayout.setOnClickListener(new aj(this, this.a.getChildCount() - 1, (byte) 0));
            this.a.addView(linearLayout, this.a.getChildCount() - 1, this.e);
        }
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.b) {
            if (this.b != -1) {
                LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(this.b);
                linearLayout.setSelected(false);
                ((BDImageView) linearLayout.getChildAt(0)).setImageResource(this.c.get(this.b).c().b);
            }
            this.b = i;
            LinearLayout linearLayout2 = (LinearLayout) this.a.getChildAt(this.b);
            linearLayout2.setSelected(true);
            ba.c((ImageView) ((BDImageView) linearLayout2.getChildAt(0)), this.c.get(this.b).c().a);
        }
    }

    public final void a() {
        this.b = -1;
        this.a.removeAllViews();
    }

    public final void a(int i) {
        if (this.h != null) {
            this.h.setBackgroundResource(i == 1 ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
            this.h.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.a.getChildAt(i2);
            if (childAt != null) {
                if (i == 1) {
                    childAt.setBackgroundResource(com.baidu.tieba.a.g.bg_expression_bar_1);
                } else {
                    childAt.setBackgroundResource(com.baidu.tieba.a.g.bg_expression_bar);
                }
                if (i2 != childCount - 1) {
                    BDImageView bDImageView = (BDImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (bDImageView != null) {
                        if (i2 == this.b) {
                            ba.c((ImageView) bDImageView, this.c.get(i2).c().a);
                        } else {
                            ba.c((ImageView) bDImageView, this.c.get(i2).c().b);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(an anVar) {
        this.d = anVar;
    }
}
