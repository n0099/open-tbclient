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
    private f aBR;
    private int aBS;
    private CommonTabWidgetView.a aBT;
    private LinearLayout.LayoutParams aBU;
    private int aBV;
    private int aBW;
    private TextView aBX;
    private View aBY;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBS = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBS = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aBS = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aBR = new f(getContext());
        this.aBR.setOrientation(0);
        this.aBR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aBR.setBaselineAligned(false);
        addView(this.aBR);
        this.aBV = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBW = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBR.setPadding(0, getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
        this.aBU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1);
        this.aBY = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aBY.setLayoutParams(layoutParams);
        aq.j(this.aBY, w.g.bg_expression_bar_n);
        this.aBR.addView(this.aBY);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0044b c0044b) {
        if (c0044b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        aq.j(linearLayout, w.g.bg_expression_bar);
        tbImageView.setPadding(this.aBW, this.aBV, this.aBW, this.aBV);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aq.c(tbImageView, c0044b.aBQ);
        linearLayout.setOnClickListener(new a(this, this.aBR.getChildCount() - 1, null));
        this.aBR.addView(linearLayout, this.aBR.getChildCount() - 1, this.aBU);
        return tbImageView;
    }

    public void c(b.C0044b c0044b) {
        b(c0044b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aBS) {
            if (this.aBS != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aBR.getChildAt(this.aBS);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aBS).Ds().aBQ);
                } else {
                    return;
                }
            }
            this.aBS = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aBR.getChildAt(this.aBS);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aq.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aBS).Ds().aBP);
            }
        }
    }

    public void reset() {
        this.aBS = -1;
        this.aBR.removeAllViews();
    }

    public void dm(int i) {
        if (this.aBX != null) {
            aq.j(this.aBX, w.g.icon_news_head_prompt_one);
            this.aBX.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aBR.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aBR.getChildAt(i2);
            if (childAt != null) {
                aq.j(childAt, w.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aBS) {
                            aq.c(tbImageView, this.mDatas.get(i2).Ds().aBP);
                        } else {
                            aq.c(tbImageView, this.mDatas.get(i2).Ds().aBQ);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aBT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int ady;

        private a(int i) {
            this.ady = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aBT.eM(this.ady);
        }
    }
}
