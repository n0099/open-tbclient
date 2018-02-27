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
    private c bve;
    private int bvf;
    private CommonTabWidgetView.a bvg;
    private LinearLayout.LayoutParams bvh;
    private int bvi;
    private int bvj;
    private TextView bvk;
    private View bvl;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvf = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvf = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bvf = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bve = new c(getContext());
        this.bve.setOrientation(0);
        this.bve.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bve.setBaselineAligned(false);
        addView(this.bve);
        this.bvi = getResources().getDimensionPixelSize(d.e.ds8);
        this.bvj = getResources().getDimensionPixelSize(d.e.ds10);
        this.bve.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bvh = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.bvl = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bvl.setLayoutParams(layoutParams);
        aj.s(this.bvl, d.f.bg_expression_bar_n);
        this.bve.addView(this.bvl);
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
        aj.s(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.bvj, this.bvi, this.bvj, this.bvi);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.bvd);
        linearLayout.setOnClickListener(new a(this.bve.getChildCount() - 1));
        this.bve.addView(linearLayout, this.bve.getChildCount() - 1, this.bvh);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bvf) {
            if (this.bvf != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bve.getChildAt(this.bvf);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bvf).Mb().bvd);
                } else {
                    return;
                }
            }
            this.bvf = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bve.getChildAt(this.bvf);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bvf).Mb().bvc);
            }
        }
    }

    public void reset() {
        this.bvf = -1;
        this.bve.removeAllViews();
    }

    public void gB(int i) {
        if (this.bvk != null) {
            aj.s(this.bvk, d.f.icon_news_head_prompt_one);
            this.bvk.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bve.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bve.getChildAt(i2);
            if (childAt != null) {
                aj.s(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bvf) {
                            aj.c(tbImageView, this.mDatas.get(i2).Mb().bvc);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Mb().bvd);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bvg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aUG;

        private a(int i) {
            this.aUG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bvg.hT(this.aUG);
        }
    }
}
