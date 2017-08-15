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
    private c aEX;
    private int aEY;
    private CommonTabWidgetView.a aEZ;
    private LinearLayout.LayoutParams aFa;
    private int aFb;
    private int aFc;
    private TextView aFd;
    private View aFe;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEY = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEY = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEY = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEX = new c(getContext());
        this.aEX.setOrientation(0);
        this.aEX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEX.setBaselineAligned(false);
        addView(this.aEX);
        this.aFb = getResources().getDimensionPixelSize(d.f.ds8);
        this.aFc = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEX.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aFa = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aFe = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aFe.setLayoutParams(layoutParams);
        ai.j(this.aFe, d.g.bg_expression_bar_n);
        this.aEX.addView(this.aFe);
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
        tbImageView.setPadding(this.aFc, this.aFb, this.aFc, this.aFb);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ai.c(tbImageView, bVar.aEW);
        linearLayout.setOnClickListener(new a(this.aEX.getChildCount() - 1));
        this.aEX.addView(linearLayout, this.aEX.getChildCount() - 1, this.aFa);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEY) {
            if (this.aEY != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEX.getChildAt(this.aEY);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEY).Ea().aEW);
                } else {
                    return;
                }
            }
            this.aEY = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEX.getChildAt(this.aEY);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ai.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEY).Ea().aEV);
            }
        }
    }

    public void reset() {
        this.aEY = -1;
        this.aEX.removeAllViews();
    }

    public void dt(int i) {
        if (this.aFd != null) {
            ai.j(this.aFd, d.g.icon_news_head_prompt_one);
            this.aFd.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEX.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEX.getChildAt(i2);
            if (childAt != null) {
                ai.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEY) {
                            ai.c(tbImageView, this.mDatas.get(i2).Ea().aEV);
                        } else {
                            ai.c(tbImageView, this.mDatas.get(i2).Ea().aEW);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aEZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int afS;

        private a(int i) {
            this.afS = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aEZ.eT(this.afS);
        }
    }
}
