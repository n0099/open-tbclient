package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private c aDG;
    private int aDH;
    private CommonTabWidgetView.a aDI;
    private LinearLayout.LayoutParams aDJ;
    private int aDK;
    private int aDL;
    private TextView aDM;
    private View aDN;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDH = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDH = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aDH = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aDG = new c(getContext());
        this.aDG.setOrientation(0);
        this.aDG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aDG.setBaselineAligned(false);
        addView(this.aDG);
        this.aDK = getResources().getDimensionPixelSize(d.f.ds8);
        this.aDL = getResources().getDimensionPixelSize(d.f.ds10);
        this.aDG.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aDJ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aDN = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aDN.setLayoutParams(layoutParams);
        ai.j(this.aDN, d.g.bg_expression_bar_n);
        this.aDG.addView(this.aDN);
    }

    public void setDatas(List<com.baidu.tbadk.editortools.view.a> list) {
        this.mDatas = list;
    }

    private TbImageView b(a.b bVar) {
        if (bVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        ai.j(linearLayout, d.g.bg_expression_bar);
        tbImageView.setPadding(this.aDL, this.aDK, this.aDL, this.aDK);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ai.c(tbImageView, bVar.aDF);
        linearLayout.setOnClickListener(new a(this.aDG.getChildCount() - 1));
        this.aDG.addView(linearLayout, this.aDG.getChildCount() - 1, this.aDJ);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aDH) {
            if (this.aDH != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aDG.getChildAt(this.aDH);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aDH).DS().aDF);
                } else {
                    return;
                }
            }
            this.aDH = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aDG.getChildAt(this.aDH);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ai.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aDH).DS().aDE);
            }
        }
    }

    public void reset() {
        this.aDH = -1;
        this.aDG.removeAllViews();
    }

    public void dr(int i) {
        if (this.aDM != null) {
            ai.j(this.aDM, d.g.icon_news_head_prompt_one);
            this.aDM.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aDG.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aDG.getChildAt(i2);
            if (childAt != null) {
                ai.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aDH) {
                            ai.c(tbImageView, this.mDatas.get(i2).DS().aDE);
                        } else {
                            ai.c(tbImageView, this.mDatas.get(i2).DS().aDF);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aDI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aev;

        private a(int i) {
            this.aev = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aDI.eR(this.aev);
        }
    }
}
