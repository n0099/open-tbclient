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
    private c aEd;
    private int aEe;
    private CommonTabWidgetView.a aEf;
    private LinearLayout.LayoutParams aEg;
    private int aEh;
    private int aEi;
    private TextView aEj;
    private View aEk;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEe = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEe = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEe = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEd = new c(getContext());
        this.aEd.setOrientation(0);
        this.aEd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEd.setBaselineAligned(false);
        addView(this.aEd);
        this.aEh = getResources().getDimensionPixelSize(d.e.ds8);
        this.aEi = getResources().getDimensionPixelSize(d.e.ds10);
        this.aEd.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aEg = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aEk = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aEk.setLayoutParams(layoutParams);
        aj.j(this.aEk, d.f.bg_expression_bar_n);
        this.aEd.addView(this.aEk);
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
        tbImageView.setPadding(this.aEi, this.aEh, this.aEi, this.aEh);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.aEc);
        linearLayout.setOnClickListener(new a(this.aEd.getChildCount() - 1));
        this.aEd.addView(linearLayout, this.aEd.getChildCount() - 1, this.aEg);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEe) {
            if (this.aEe != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEd.getChildAt(this.aEe);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEe).DK().aEc);
                } else {
                    return;
                }
            }
            this.aEe = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEd.getChildAt(this.aEe);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEe).DK().aEb);
            }
        }
    }

    public void reset() {
        this.aEe = -1;
        this.aEd.removeAllViews();
    }

    public void dE(int i) {
        if (this.aEj != null) {
            aj.j(this.aEj, d.f.icon_news_head_prompt_one);
            this.aEj.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEd.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEd.getChildAt(i2);
            if (childAt != null) {
                aj.j(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEe) {
                            aj.c(tbImageView, this.mDatas.get(i2).DK().aEb);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).DK().aEc);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEf = aVar;
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
            CommonTabHorizonScrollView.this.aEf.fd(this.aeH);
        }
    }
}
