package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private CommonTabWidgetView.a asA;
    private LinearLayout.LayoutParams asB;
    private int asC;
    private int asD;
    private TextView asE;
    private View asF;
    private f asy;
    private int asz;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.asz = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asz = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.asz = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.asy = new f(getContext());
        this.asy.setOrientation(0);
        this.asy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.asy.setBaselineAligned(false);
        addView(this.asy);
        this.asC = getResources().getDimensionPixelSize(t.e.face_tab_widget_tb_padding);
        this.asD = getResources().getDimensionPixelSize(t.e.face_tab_widget_lr_padding);
        this.asy.setPadding(0, getResources().getDimensionPixelSize(t.e.default_gap_6), 0, 0);
        this.asB = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.face_tab_widget_width), -1);
        this.asF = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.asF.setLayoutParams(layoutParams);
        at.k(this.asF, t.f.bg_expression_bar_n);
        this.asy.addView(this.asF);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0041b c0041b) {
        if (c0041b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        at.k(linearLayout, t.f.bg_expression_bar);
        tbImageView.setPadding(this.asD, this.asC, this.asD, this.asC);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        at.c(tbImageView, c0041b.asx);
        linearLayout.setOnClickListener(new a(this, this.asy.getChildCount() - 1, null));
        this.asy.addView(linearLayout, this.asy.getChildCount() - 1, this.asB);
        return tbImageView;
    }

    public void c(b.C0041b c0041b) {
        b(c0041b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.asz) {
            if (this.asz != -1) {
                LinearLayout linearLayout = (LinearLayout) this.asy.getChildAt(this.asz);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.asz).Cm().asx);
                } else {
                    return;
                }
            }
            this.asz = i;
            LinearLayout linearLayout2 = (LinearLayout) this.asy.getChildAt(this.asz);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                at.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.asz).Cm().asw);
            }
        }
    }

    public void reset() {
        this.asz = -1;
        this.asy.removeAllViews();
    }

    public void cW(int i) {
        if (this.asE != null) {
            at.k(this.asE, t.f.icon_news_head_prompt_one);
            this.asE.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.asy.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.asy.getChildAt(i2);
            if (childAt != null) {
                at.k(childAt, t.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.asz) {
                            at.c(tbImageView, this.mDatas.get(i2).Cm().asw);
                        } else {
                            at.c(tbImageView, this.mDatas.get(i2).Cm().asx);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.asA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Vw;

        private a(int i) {
            this.Vw = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.asA.ew(this.Vw);
        }
    }
}
