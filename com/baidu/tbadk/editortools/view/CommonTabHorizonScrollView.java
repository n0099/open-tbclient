package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private c aDF;
    private int aDG;
    private CommonTabWidgetView.a aDH;
    private LinearLayout.LayoutParams aDI;
    private int aDJ;
    private int aDK;
    private TextView aDL;
    private View aDM;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDG = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDG = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aDG = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aDF = new c(getContext());
        this.aDF.setOrientation(0);
        this.aDF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aDF.setBaselineAligned(false);
        addView(this.aDF);
        this.aDJ = getResources().getDimensionPixelSize(d.f.ds8);
        this.aDK = getResources().getDimensionPixelSize(d.f.ds10);
        this.aDF.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aDI = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aDM = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aDM.setLayoutParams(layoutParams);
        aj.j(this.aDM, d.g.bg_expression_bar_n);
        this.aDF.addView(this.aDM);
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
        aj.j(linearLayout, d.g.bg_expression_bar);
        tbImageView.setPadding(this.aDK, this.aDJ, this.aDK, this.aDJ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aDE);
        linearLayout.setOnClickListener(new a(this.aDF.getChildCount() - 1));
        this.aDF.addView(linearLayout, this.aDF.getChildCount() - 1, this.aDI);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aDG) {
            if (this.aDG != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aDF.getChildAt(this.aDG);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aDG).DB().aDE);
                } else {
                    return;
                }
            }
            this.aDG = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aDF.getChildAt(this.aDG);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aDG).DB().aDD);
            }
        }
    }

    public void reset() {
        this.aDG = -1;
        this.aDF.removeAllViews();
    }

    public void dE(int i) {
        if (this.aDL != null) {
            aj.j(this.aDL, d.g.icon_news_head_prompt_one);
            this.aDL.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aDF.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aDF.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aDG) {
                            aj.c(tbImageView, this.mDatas.get(i2).DB().aDD);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).DB().aDE);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aDH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aey;

        private a(int i) {
            this.aey = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aDH.fd(this.aey);
        }
    }
}
