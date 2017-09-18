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
    private c aEm;
    private int aEn;
    private CommonTabWidgetView.a aEo;
    private LinearLayout.LayoutParams aEp;
    private int aEq;
    private int aEr;
    private TextView aEs;
    private View aEt;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEn = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEn = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEn = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEm = new c(getContext());
        this.aEm.setOrientation(0);
        this.aEm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEm.setBaselineAligned(false);
        addView(this.aEm);
        this.aEq = getResources().getDimensionPixelSize(d.f.ds8);
        this.aEr = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEm.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aEp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aEt = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aEt.setLayoutParams(layoutParams);
        aj.j(this.aEt, d.g.bg_expression_bar_n);
        this.aEm.addView(this.aEt);
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
        tbImageView.setPadding(this.aEr, this.aEq, this.aEr, this.aEq);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aEl);
        linearLayout.setOnClickListener(new a(this.aEm.getChildCount() - 1));
        this.aEm.addView(linearLayout, this.aEm.getChildCount() - 1, this.aEp);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEn) {
            if (this.aEn != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEm.getChildAt(this.aEn);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEn).DX().aEl);
                } else {
                    return;
                }
            }
            this.aEn = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEm.getChildAt(this.aEn);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEn).DX().aEk);
            }
        }
    }

    public void reset() {
        this.aEn = -1;
        this.aEm.removeAllViews();
    }

    public void du(int i) {
        if (this.aEs != null) {
            aj.j(this.aEs, d.g.icon_news_head_prompt_one);
            this.aEs.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEm.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEm.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEn) {
                            aj.c(tbImageView, this.mDatas.get(i2).DX().aEk);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).DX().aEl);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int afb;

        private a(int i) {
            this.afb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aEo.eT(this.afb);
        }
    }
}
