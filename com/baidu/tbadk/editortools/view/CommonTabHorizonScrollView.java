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
    private c aEY;
    private int aEZ;
    private CommonTabWidgetView.a aFa;
    private LinearLayout.LayoutParams aFb;
    private int aFc;
    private int aFd;
    private TextView aFe;
    private View aFf;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aEZ = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aEY = new c(getContext());
        this.aEY.setOrientation(0);
        this.aEY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aEY.setBaselineAligned(false);
        addView(this.aEY);
        this.aFc = getResources().getDimensionPixelSize(d.f.ds8);
        this.aFd = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEY.setPadding(0, getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
        this.aFb = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1);
        this.aFf = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aFf.setLayoutParams(layoutParams);
        ai.j(this.aFf, d.g.bg_expression_bar_n);
        this.aEY.addView(this.aFf);
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
        tbImageView.setPadding(this.aFd, this.aFc, this.aFd, this.aFc);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ai.c(tbImageView, bVar.aEX);
        linearLayout.setOnClickListener(new a(this.aEY.getChildCount() - 1));
        this.aEY.addView(linearLayout, this.aEY.getChildCount() - 1, this.aFb);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aEZ) {
            if (this.aEZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aEY.getChildAt(this.aEZ);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aEZ).Ea().aEX);
                } else {
                    return;
                }
            }
            this.aEZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aEY.getChildAt(this.aEZ);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ai.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aEZ).Ea().aEW);
            }
        }
    }

    public void reset() {
        this.aEZ = -1;
        this.aEY.removeAllViews();
    }

    public void dt(int i) {
        if (this.aFe != null) {
            ai.j(this.aFe, d.g.icon_news_head_prompt_one);
            this.aFe.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aEY.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aEY.getChildAt(i2);
            if (childAt != null) {
                ai.j(childAt, d.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aEZ) {
                            ai.c(tbImageView, this.mDatas.get(i2).Ea().aEW);
                        } else {
                            ai.c(tbImageView, this.mDatas.get(i2).Ea().aEX);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aFa = aVar;
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
            CommonTabHorizonScrollView.this.aFa.eT(this.afS);
        }
    }
}
