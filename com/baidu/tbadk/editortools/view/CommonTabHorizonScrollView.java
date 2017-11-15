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
    private c aEl;
    private int aEm;
    private CommonTabWidgetView.a aEn;
    private LinearLayout.LayoutParams aEo;
    private int aEp;
    private int aEq;
    private TextView aEr;
    private View aEs;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEm = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEm = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEm = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEl = new c(getContext());
        this.aEl.setOrientation(0);
        this.aEl.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEl.setBaselineAligned(false);
        addView(this.aEl);
        this.aEp = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEq = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEl.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aEo = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aEs = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aEs.setLayoutParams(layoutParams);
        aj.j(this.aEs, d.f.bg_expression_bar_n);
        this.aEl.addView(this.aEs);
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
        tbImageView.setPadding(this.aEq, this.aEp, this.aEq, this.aEp);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aEk);
        linearLayout.setOnClickListener(new a(this.aEl.getChildCount() - 1));
        this.aEl.addView(linearLayout, this.aEl.getChildCount() - 1, this.aEo);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEm) {
            if (this.aEm != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEl.getChildAt(this.aEm);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEm).DW().aEk);
                } else {
                    return;
                }
            }
            this.aEm = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEl.getChildAt(this.aEm);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEm).DW().aEj);
            }
        }
    }

    public void reset() {
        this.aEm = -1;
        this.aEl.removeAllViews();
    }

    public void dD(int i) {
        if (this.aEr != null) {
            aj.j(this.aEr, d.f.icon_news_head_prompt_one);
            this.aEr.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEl.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEl.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEm) {
                            aj.c(tbImageView, this.mDatas.get(i2).DW().aEj);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).DW().aEk);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aeH;

        private a(int i) {
            this.aeH = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aEn.fc(this.aeH);
        }
    }
}
