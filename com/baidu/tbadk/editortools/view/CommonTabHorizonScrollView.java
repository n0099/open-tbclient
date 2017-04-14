package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f aBQ;
    private int aBR;
    private CommonTabWidgetView.a aBS;
    private LinearLayout.LayoutParams aBT;
    private int aBU;
    private int aBV;
    private TextView aBW;
    private View aBX;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBR = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBR = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aBR = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aBQ = new f(getContext());
        this.aBQ.setOrientation(0);
        this.aBQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aBQ.setBaselineAligned(false);
        addView(this.aBQ);
        this.aBU = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBV = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBQ.setPadding(0, getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
        this.aBT = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1);
        this.aBX = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aBX.setLayoutParams(layoutParams);
        aq.j(this.aBX, w.g.bg_expression_bar_n);
        this.aBQ.addView(this.aBX);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0040b c0040b) {
        if (c0040b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        aq.j(linearLayout, w.g.bg_expression_bar);
        tbImageView.setPadding(this.aBV, this.aBU, this.aBV, this.aBU);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aq.c(tbImageView, c0040b.aBP);
        linearLayout.setOnClickListener(new a(this, this.aBQ.getChildCount() - 1, null));
        this.aBQ.addView(linearLayout, this.aBQ.getChildCount() - 1, this.aBT);
        return tbImageView;
    }

    public void c(b.C0040b c0040b) {
        b(c0040b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aBR) {
            if (this.aBR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aBQ.getChildAt(this.aBR);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aBR).Eo().aBP);
                } else {
                    return;
                }
            }
            this.aBR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aBQ.getChildAt(this.aBR);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aq.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aBR).Eo().aBO);
            }
        }
    }

    public void reset() {
        this.aBR = -1;
        this.aBQ.removeAllViews();
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(int i) {
        if (this.aBW != null) {
            aq.j(this.aBW, w.g.icon_news_head_prompt_one);
            this.aBW.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aBQ.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aBQ.getChildAt(i2);
            if (childAt != null) {
                aq.j(childAt, w.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aBR) {
                            aq.c(tbImageView, this.mDatas.get(i2).Eo().aBO);
                        } else {
                            aq.c(tbImageView, this.mDatas.get(i2).Eo().aBP);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aBS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aef;

        private a(int i) {
            this.aef = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aBS.eQ(this.aef);
        }
    }
}
