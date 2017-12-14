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
    private c aER;
    private int aES;
    private CommonTabWidgetView.a aET;
    private LinearLayout.LayoutParams aEU;
    private int aEV;
    private int aEW;
    private TextView aEX;
    private View aEY;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aES = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aES = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aES = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aER = new c(getContext());
        this.aER.setOrientation(0);
        this.aER.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aER.setBaselineAligned(false);
        addView(this.aER);
        this.aEV = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEW = getResources().getDimensionPixelSize(d.e.ds10);
        this.aER.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aEU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aEY = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aEY.setLayoutParams(layoutParams);
        aj.j(this.aEY, d.f.bg_expression_bar_n);
        this.aER.addView(this.aEY);
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
        aj.j(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.aEW, this.aEV, this.aEW, this.aEV);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aEQ);
        linearLayout.setOnClickListener(new a(this.aER.getChildCount() - 1));
        this.aER.addView(linearLayout, this.aER.getChildCount() - 1, this.aEU);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aES) {
            if (this.aES != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aER.getChildAt(this.aES);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aES).Ef().aEQ);
                } else {
                    return;
                }
            }
            this.aES = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aER.getChildAt(this.aES);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aES).Ef().aEP);
            }
        }
    }

    public void reset() {
        this.aES = -1;
        this.aER.removeAllViews();
    }

    public void dE(int i) {
        if (this.aEX != null) {
            aj.j(this.aEX, d.f.icon_news_head_prompt_one);
            this.aEX.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aER.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aER.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aES) {
                            aj.c(tbImageView, this.mDatas.get(i2).Ef().aEP);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Ef().aEQ);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aET = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aeX;

        private a(int i) {
            this.aeX = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aET.fb(this.aeX);
        }
    }
}
