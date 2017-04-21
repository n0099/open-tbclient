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
    private f aBS;
    private int aBT;
    private CommonTabWidgetView.a aBU;
    private LinearLayout.LayoutParams aBV;
    private int aBW;
    private int aBX;
    private TextView aBY;
    private View aBZ;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBT = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBT = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aBT = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aBS = new f(getContext());
        this.aBS.setOrientation(0);
        this.aBS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aBS.setBaselineAligned(false);
        addView(this.aBS);
        this.aBW = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBX = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBS.setPadding(0, getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
        this.aBV = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1);
        this.aBZ = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aBZ.setLayoutParams(layoutParams);
        aq.j(this.aBZ, w.g.bg_expression_bar_n);
        this.aBS.addView(this.aBZ);
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
        tbImageView.setPadding(this.aBX, this.aBW, this.aBX, this.aBW);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aq.c(tbImageView, c0040b.aBR);
        linearLayout.setOnClickListener(new a(this, this.aBS.getChildCount() - 1, null));
        this.aBS.addView(linearLayout, this.aBS.getChildCount() - 1, this.aBV);
        return tbImageView;
    }

    public void c(b.C0040b c0040b) {
        b(c0040b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aBT) {
            if (this.aBT != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aBS.getChildAt(this.aBT);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aBT).Eo().aBR);
                } else {
                    return;
                }
            }
            this.aBT = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aBS.getChildAt(this.aBT);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aq.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aBT).Eo().aBQ);
            }
        }
    }

    public void reset() {
        this.aBT = -1;
        this.aBS.removeAllViews();
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(int i) {
        if (this.aBY != null) {
            aq.j(this.aBY, w.g.icon_news_head_prompt_one);
            this.aBY.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aBS.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aBS.getChildAt(i2);
            if (childAt != null) {
                aq.j(childAt, w.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aBT) {
                            aq.c(tbImageView, this.mDatas.get(i2).Eo().aBQ);
                        } else {
                            aq.c(tbImageView, this.mDatas.get(i2).Eo().aBR);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aBU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aeg;

        private a(int i) {
            this.aeg = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aBU.eQ(this.aeg);
        }
    }
}
