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
    private c aEp;
    private int aEq;
    private CommonTabWidgetView.a aEr;
    private LinearLayout.LayoutParams aEs;
    private int aEt;
    private int aEu;
    private TextView aEv;
    private View aEw;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEq = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEq = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEq = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEp = new c(getContext());
        this.aEp.setOrientation(0);
        this.aEp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEp.setBaselineAligned(false);
        addView(this.aEp);
        this.aEt = getResources().getDimensionPixelSize(d.f.ds8);
        this.aEu = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEp.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aEs = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aEw = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aEw.setLayoutParams(layoutParams);
        aj.j(this.aEw, d.g.bg_expression_bar_n);
        this.aEp.addView(this.aEw);
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
        tbImageView.setPadding(this.aEu, this.aEt, this.aEu, this.aEt);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aEo);
        linearLayout.setOnClickListener(new a(this.aEp.getChildCount() - 1));
        this.aEp.addView(linearLayout, this.aEp.getChildCount() - 1, this.aEs);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEq) {
            if (this.aEq != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEp.getChildAt(this.aEq);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEq).DX().aEo);
                } else {
                    return;
                }
            }
            this.aEq = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEp.getChildAt(this.aEq);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEq).DX().aEn);
            }
        }
    }

    public void reset() {
        this.aEq = -1;
        this.aEp.removeAllViews();
    }

    public void du(int i) {
        if (this.aEv != null) {
            aj.j(this.aEv, d.g.icon_news_head_prompt_one);
            this.aEv.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEp.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEp.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEq) {
                            aj.c(tbImageView, this.mDatas.get(i2).DX().aEn);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).DX().aEo);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEr = aVar;
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
            CommonTabHorizonScrollView.this.aEr.eT(this.afb);
        }
    }
}
