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
    private c aEU;
    private int aEV;
    private CommonTabWidgetView.a aEW;
    private LinearLayout.LayoutParams aEX;
    private int aEY;
    private int aEZ;
    private TextView aFa;
    private View aFb;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEV = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEU = new c(getContext());
        this.aEU.setOrientation(0);
        this.aEU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEU.setBaselineAligned(false);
        addView(this.aEU);
        this.aEY = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEZ = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEU.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aEX = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aFb = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aFb.setLayoutParams(layoutParams);
        aj.j(this.aFb, d.f.bg_expression_bar_n);
        this.aEU.addView(this.aFb);
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
        tbImageView.setPadding(this.aEZ, this.aEY, this.aEZ, this.aEY);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aET);
        linearLayout.setOnClickListener(new a(this.aEU.getChildCount() - 1));
        this.aEU.addView(linearLayout, this.aEU.getChildCount() - 1, this.aEX);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEV) {
            if (this.aEV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEU.getChildAt(this.aEV);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEV).Ef().aET);
                } else {
                    return;
                }
            }
            this.aEV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEU.getChildAt(this.aEV);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEV).Ef().aES);
            }
        }
    }

    public void reset() {
        this.aEV = -1;
        this.aEU.removeAllViews();
    }

    public void dE(int i) {
        if (this.aFa != null) {
            aj.j(this.aFa, d.f.icon_news_head_prompt_one);
            this.aFa.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEU.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEU.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEV) {
                            aj.c(tbImageView, this.mDatas.get(i2).Ef().aES);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Ef().aET);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int afa;

        private a(int i) {
            this.afa = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aEW.fb(this.afa);
        }
    }
}
