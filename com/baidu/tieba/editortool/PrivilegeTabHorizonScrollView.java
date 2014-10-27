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
    private int RK;
    private int RN;
    private int RO;
    private TextView RR;
    private LinearLayout.LayoutParams RS;
    private View RU;
    private ak arG;
    private av arH;
    private List<an> mDatas;

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RK = -1;
        init();
    }

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RK = -1;
        init();
    }

    public PrivilegeTabHorizonScrollView(Context context) {
        super(context);
        this.RK = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.arG = new ak(getContext());
        this.arG.setOrientation(0);
        this.arG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.arG.setBaselineAligned(false);
        addView(this.arG);
        this.RN = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_tb_padding);
        this.RO = getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_lr_padding);
        this.arG.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_6), 0, 0);
        this.RS = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_widget_width), -1);
        this.RU = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.RU.setLayoutParams(layoutParams);
        com.baidu.tbadk.core.util.aw.h(this.RU, com.baidu.tieba.u.bg_expression_bar_n);
        this.arG.addView(this.RU);
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
        tbImageView.setPadding(this.RO, this.RN, this.RO, this.RN);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        com.baidu.tbadk.core.util.aw.c(tbImageView, apVar.arF);
        linearLayout.setOnClickListener(new aq(this, this.arG.getChildCount() - 1, null));
        this.arG.addView(linearLayout, this.arG.getChildCount() - 1, this.RS);
        return tbImageView;
    }

    public void c(ap apVar) {
        b(apVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.RK) {
            if (this.RK != -1) {
                LinearLayout linearLayout = (LinearLayout) this.arG.getChildAt(this.RK);
                linearLayout.setSelected(false);
                ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.RK).Cp().arF);
            }
            this.RK = i;
            LinearLayout linearLayout2 = (LinearLayout) this.arG.getChildAt(this.RK);
            linearLayout2.setSelected(true);
            com.baidu.tbadk.core.util.aw.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.RK).Cp().arE);
        }
    }

    public void reset() {
        this.RK = -1;
        this.arG.removeAllViews();
    }

    public void bN(int i) {
        if (this.RR != null) {
            com.baidu.tbadk.core.util.aw.h((View) this.RR, com.baidu.tieba.u.icon_news_head_prompt_one);
            this.RR.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.arG.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.arG.getChildAt(i2);
            if (childAt != null) {
                com.baidu.tbadk.core.util.aw.h(childAt, com.baidu.tieba.u.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.RK) {
                            com.baidu.tbadk.core.util.aw.c(tbImageView, this.mDatas.get(i2).Cp().arE);
                        } else {
                            com.baidu.tbadk.core.util.aw.c(tbImageView, this.mDatas.get(i2).Cp().arF);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(av avVar) {
        this.arH = avVar;
    }
}
