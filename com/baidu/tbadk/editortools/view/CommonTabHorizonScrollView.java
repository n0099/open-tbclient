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
    private f aBA;
    private int aBB;
    private CommonTabWidgetView.a aBC;
    private LinearLayout.LayoutParams aBD;
    private int aBE;
    private int aBF;
    private TextView aBG;
    private View aBH;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBB = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBB = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aBB = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aBA = new f(getContext());
        this.aBA.setOrientation(0);
        this.aBA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aBA.setBaselineAligned(false);
        addView(this.aBA);
        this.aBE = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBF = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBA.setPadding(0, getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
        this.aBD = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1);
        this.aBH = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aBH.setLayoutParams(layoutParams);
        aq.j(this.aBH, w.g.bg_expression_bar_n);
        this.aBA.addView(this.aBH);
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
        aq.j(linearLayout, w.g.bg_expression_bar);
        tbImageView.setPadding(this.aBF, this.aBE, this.aBF, this.aBE);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aq.c(tbImageView, c0041b.aBz);
        linearLayout.setOnClickListener(new a(this, this.aBA.getChildCount() - 1, null));
        this.aBA.addView(linearLayout, this.aBA.getChildCount() - 1, this.aBD);
        return tbImageView;
    }

    public void c(b.C0041b c0041b) {
        b(c0041b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aBB) {
            if (this.aBB != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aBA.getChildAt(this.aBB);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aBB).DQ().aBz);
                } else {
                    return;
                }
            }
            this.aBB = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aBA.getChildAt(this.aBB);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aq.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aBB).DQ().aBy);
            }
        }
    }

    public void reset() {
        this.aBB = -1;
        this.aBA.removeAllViews();
    }

    public void dl(int i) {
        if (this.aBG != null) {
            aq.j(this.aBG, w.g.icon_news_head_prompt_one);
            this.aBG.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aBA.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aBA.getChildAt(i2);
            if (childAt != null) {
                aq.j(childAt, w.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aBB) {
                            aq.c(tbImageView, this.mDatas.get(i2).DQ().aBy);
                        } else {
                            aq.c(tbImageView, this.mDatas.get(i2).DQ().aBz);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aBC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int adR;

        private a(int i) {
            this.adR = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aBC.eN(this.adR);
        }
    }
}
