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
    private c aEW;
    private int aEX;
    private CommonTabWidgetView.a aEY;
    private LinearLayout.LayoutParams aEZ;
    private int aFa;
    private int aFb;
    private TextView aFc;
    private View aFd;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEX = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEX = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEX = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEW = new c(getContext());
        this.aEW.setOrientation(0);
        this.aEW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEW.setBaselineAligned(false);
        addView(this.aEW);
        this.aFa = getResources().getDimensionPixelSize(d.f.ds8);
        this.aFb = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEW.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aEZ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aFd = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aFd.setLayoutParams(layoutParams);
        ai.j(this.aFd, d.g.bg_expression_bar_n);
        this.aEW.addView(this.aFd);
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
        tbImageView.setPadding(this.aFb, this.aFa, this.aFb, this.aFa);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ai.c(tbImageView, bVar.aEV);
        linearLayout.setOnClickListener(new a(this.aEW.getChildCount() - 1));
        this.aEW.addView(linearLayout, this.aEW.getChildCount() - 1, this.aEZ);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEX) {
            if (this.aEX != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEW.getChildAt(this.aEX);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEX).Ea().aEV);
                } else {
                    return;
                }
            }
            this.aEX = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEW.getChildAt(this.aEX);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ai.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEX).Ea().aEU);
            }
        }
    }

    public void reset() {
        this.aEX = -1;
        this.aEW.removeAllViews();
    }

    public void dt(int i) {
        if (this.aFc != null) {
            ai.j(this.aFc, d.g.icon_news_head_prompt_one);
            this.aFc.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEW.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEW.getChildAt(i2);
            if (childAt != null) {
                ai.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEX) {
                            ai.c(tbImageView, this.mDatas.get(i2).Ea().aEU);
                        } else {
                            ai.c(tbImageView, this.mDatas.get(i2).Ea().aEV);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int afQ;

        private a(int i) {
            this.afQ = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aEY.eT(this.afQ);
        }
    }
}
