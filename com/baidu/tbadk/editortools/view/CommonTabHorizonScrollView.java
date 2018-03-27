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
    private c bvh;
    private int bvi;
    private CommonTabWidgetView.a bvj;
    private LinearLayout.LayoutParams bvk;
    private int bvl;
    private int bvm;
    private TextView bvn;
    private View bvo;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvi = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvi = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bvi = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bvh = new c(getContext());
        this.bvh.setOrientation(0);
        this.bvh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bvh.setBaselineAligned(false);
        addView(this.bvh);
        this.bvl = getResources().getDimensionPixelSize(d.e.ds8);
        this.bvm = getResources().getDimensionPixelSize(d.e.ds10);
        this.bvh.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bvk = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.bvo = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bvo.setLayoutParams(layoutParams);
        aj.s(this.bvo, d.f.bg_expression_bar_n);
        this.bvh.addView(this.bvo);
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
        tbImageView.setPadding(this.bvm, this.bvl, this.bvm, this.bvl);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.bvg);
        linearLayout.setOnClickListener(new a(this.bvh.getChildCount() - 1));
        this.bvh.addView(linearLayout, this.bvh.getChildCount() - 1, this.bvk);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bvi) {
            if (this.bvi != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bvh.getChildAt(this.bvi);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bvi).Mc().bvg);
                } else {
                    return;
                }
            }
            this.bvi = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bvh.getChildAt(this.bvi);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bvi).Mc().bvf);
            }
        }
    }

    public void reset() {
        this.bvi = -1;
        this.bvh.removeAllViews();
    }

    public void gB(int i) {
        if (this.bvn != null) {
            aj.s(this.bvn, d.f.icon_news_head_prompt_one);
            this.bvn.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bvh.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bvh.getChildAt(i2);
            if (childAt != null) {
                aj.s(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bvi) {
                            aj.c(tbImageView, this.mDatas.get(i2).Mc().bvf);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Mc().bvg);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bvj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aUI;

        private a(int i) {
            this.aUI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bvj.hT(this.aUI);
        }
    }
}
