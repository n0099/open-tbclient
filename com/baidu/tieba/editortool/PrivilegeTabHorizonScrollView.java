package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class PrivilegeTabHorizonScrollView extends HorizontalScrollView {
    private int RO;
    private int RR;
    private int RS;
    private TextView RV;
    private LinearLayout.LayoutParams RW;
    private View RY;
    private ak arP;
    private av arQ;
    private List<an> mDatas;

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RO = -1;
        init();
    }

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RO = -1;
        init();
    }

    public PrivilegeTabHorizonScrollView(Context context) {
        super(context);
        this.RO = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.arP = new ak(getContext());
        this.arP.setOrientation(0);
        this.arP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.arP.setBaselineAligned(false);
        addView(this.arP);
        this.RR = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_tb_padding);
        this.RS = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_lr_padding);
        this.arP.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_6), 0, 0);
        this.RW = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1);
        this.RY = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.RY.setLayoutParams(layoutParams);
        com.baidu.tbadk.core.util.aw.h(this.RY, com.baidu.tieba.u.bg_expression_bar_n);
        this.arP.addView(this.RY);
    }

    public void setDatas(List<an> list) {
        this.mDatas = list;
    }

    private TbImageView b(ap apVar) {
        if (apVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        com.baidu.tbadk.core.util.aw.h(linearLayout, com.baidu.tieba.u.bg_expression_bar);
        tbImageView.setPadding(this.RS, this.RR, this.RS, this.RR);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        com.baidu.tbadk.core.util.aw.c(tbImageView, apVar.arO);
        linearLayout.setOnClickListener(new aq(this, this.arP.getChildCount() - 1, null));
        this.arP.addView(linearLayout, this.arP.getChildCount() - 1, this.RW);
        return tbImageView;
    }

    public void c(ap apVar) {
        b(apVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.RO) {
            if (this.RO != -1) {
                LinearLayout linearLayout = (LinearLayout) this.arP.getChildAt(this.RO);
                linearLayout.setSelected(false);
                ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.RO).Cr().arO);
            }
            this.RO = i;
            LinearLayout linearLayout2 = (LinearLayout) this.arP.getChildAt(this.RO);
            linearLayout2.setSelected(true);
            com.baidu.tbadk.core.util.aw.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.RO).Cr().arN);
        }
    }

    public void reset() {
        this.RO = -1;
        this.arP.removeAllViews();
    }

    public void bN(int i) {
        if (this.RV != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.RV, com.baidu.tieba.u.icon_news_head_prompt_one);
            this.RV.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.arP.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.arP.getChildAt(i2);
            if (childAt != null) {
                com.baidu.tbadk.core.util.aw.h(childAt, com.baidu.tieba.u.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.RO) {
                            com.baidu.tbadk.core.util.aw.c(tbImageView, this.mDatas.get(i2).Cr().arN);
                        } else {
                            com.baidu.tbadk.core.util.aw.c(tbImageView, this.mDatas.get(i2).Cr().arO);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(av avVar) {
        this.arQ = avVar;
    }
}
