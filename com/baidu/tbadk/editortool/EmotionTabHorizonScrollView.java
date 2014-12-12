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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalScrollView {
    private int XE;
    private g XK;
    private ArrayList<ae> XL;
    private t XM;
    private int XN;
    private int XO;
    private LinearLayout XP;
    private ImageView XQ;
    private TextView XR;
    private LinearLayout.LayoutParams XS;
    private boolean XT;
    private View XU;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.XT = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.XT = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.XT = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.XK = new g(getContext());
        this.XK.setOrientation(0);
        this.XK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.XK.setBaselineAligned(false);
        addView(this.XK);
        this.XN = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_tb_padding);
        this.XO = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_lr_padding);
        this.XS = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1);
        this.XK.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_6), 0, 0);
        uY();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setDatas(ArrayList<ae> arrayList) {
        this.XL = arrayList;
    }

    private TbImageView c(ae aeVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        tbImageView.setPadding(this.XO, this.XN, this.XO, this.XN);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ax.i(linearLayout, com.baidu.tieba.v.bg_expression_bar);
        this.XK.addView(linearLayout, this.XK.getChildCount() - 1, this.XS);
        EmotionGroupType uU = aeVar.uU();
        if (uU == EmotionGroupType.LOCAL) {
            if (aeVar.vs() != null) {
                aeVar.vs().a(tbImageView);
            }
            linearLayout.setOnClickListener(new p(this, this.XK.getChildCount() - 3, null));
        } else if (uU == EmotionGroupType.PROMOTION) {
            if (aeVar.uT() != null) {
                aeVar.uT().a(tbImageView);
            }
            linearLayout.setOnClickListener(new q(this, aeVar.getGroupId(), null));
        } else if (uU == EmotionGroupType.BIG_EMOTION) {
            if (this.XT) {
                if (aeVar.vs() != null) {
                    aeVar.vs().a(tbImageView);
                }
                linearLayout.setOnClickListener(new p(this, this.XK.getChildCount() - 3, null));
            } else {
                if (aeVar.uT() != null) {
                    aeVar.uT().a(tbImageView);
                }
                linearLayout.setOnClickListener(new m(this));
            }
        }
        return tbImageView;
    }

    public void uY() {
        this.XQ = new ImageView(getContext());
        ax.c(this.XQ, com.baidu.tieba.v.icon_store);
        this.XQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.XQ.setPadding(this.XO, this.XN, this.XO, this.XN);
        this.XP = new LinearLayout(getContext());
        this.XP.addView(this.XQ, new LinearLayout.LayoutParams(-1, -1));
        ax.i(this.XP, com.baidu.tieba.v.bg_expression_bar);
        this.XR = new TextView(getContext());
        this.XR.setGravity(17);
        this.XR.setTextSize(10.0f);
        this.XR.setText("N");
        this.XR.setTextColor(this.XE == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        ax.i((View) this.XR, com.baidu.tieba.v.icon_news_head_prompt_one);
        this.XR.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.XK.addView(this.XP, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1));
        this.XK.setNewView(this.XR);
        if (TbadkCoreApplication.m255getInst().isFaceShopNew()) {
            this.XK.setNewViewVisible(true);
        } else {
            this.XK.setNewViewVisible(false);
        }
        this.XP.setOnClickListener(new n(this));
        this.XU = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.XU.setLayoutParams(layoutParams);
        ax.i(this.XU, com.baidu.tieba.v.bg_expression_bar_n);
        this.XK.addView(this.XU);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2902010)) {
            this.XP.setVisibility(8);
        }
    }

    public void d(ae aeVar) {
        c(aeVar);
    }

    public void f(int i, boolean z) {
        this.XT = z;
        int i2 = i + 1;
        int childCount = this.XK.getChildCount();
        ae aeVar = this.XL.get(i2 - 1);
        if (i2 < childCount && aeVar.uU() == EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.XK.getChildAt(i2);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (!this.XT) {
                linearLayout.setOnClickListener(new o(this));
                if (aeVar.uT() != null) {
                    aeVar.uT().a(tbImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new p(this, i2 - 1, null));
            if (aeVar.vs() != null) {
                aeVar.vs().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                ((LinearLayout) this.XK.getChildAt(this.mCurrentIndex + 1)).setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout = (LinearLayout) this.XK.getChildAt(this.mCurrentIndex + 1);
            linearLayout.setSelected(true);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            ae aeVar = this.XL.get(this.mCurrentIndex);
            if (aeVar.vs() != null) {
                aeVar.vs().a(tbImageView);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.XK.removeAllViews();
        uY();
    }

    public void cm(int i) {
        this.XE = i;
        if (this.XQ != null) {
            ax.a(this.XQ, com.baidu.tieba.v.icon_store, i);
        }
        if (this.XP != null) {
            ax.c(this.XP, com.baidu.tieba.v.bg_expression_bar, i);
        }
        if (this.XR != null) {
            ax.c(this.XR, com.baidu.tieba.v.icon_news_head_prompt_one, i);
            this.XR.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.XK.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.XK.getChildAt(i2);
            if (childAt != null) {
                ax.c(childAt, com.baidu.tieba.v.bg_expression_bar, i);
            }
        }
    }

    public void setOnTabSelectedListener(t tVar) {
        this.XM = tVar;
    }
}
