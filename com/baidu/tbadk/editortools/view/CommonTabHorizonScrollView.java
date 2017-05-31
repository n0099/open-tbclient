package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f aBE;
    private int aBF;
    private CommonTabWidgetView.a aBG;
    private LinearLayout.LayoutParams aBH;
    private int aBI;
    private int aBJ;
    private TextView aBK;
    private View aBL;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBF = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBF = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aBF = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aBE = new f(getContext());
        this.aBE.setOrientation(0);
        this.aBE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aBE.setBaselineAligned(false);
        addView(this.aBE);
        this.aBI = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBJ = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBE.setPadding(0, getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
        this.aBH = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1);
        this.aBL = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aBL.setLayoutParams(layoutParams);
        aq.j(this.aBL, w.g.bg_expression_bar_n);
        this.aBE.addView(this.aBL);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0044b c0044b) {
        if (c0044b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        aq.j(linearLayout, w.g.bg_expression_bar);
        tbImageView.setPadding(this.aBJ, this.aBI, this.aBJ, this.aBI);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aq.c(tbImageView, c0044b.aBD);
        linearLayout.setOnClickListener(new a(this, this.aBE.getChildCount() - 1, null));
        this.aBE.addView(linearLayout, this.aBE.getChildCount() - 1, this.aBH);
        return tbImageView;
    }

    public void c(b.C0044b c0044b) {
        b(c0044b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aBF) {
            if (this.aBF != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aBE.getChildAt(this.aBF);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aBF).Dm().aBD);
                } else {
                    return;
                }
            }
            this.aBF = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aBE.getChildAt(this.aBF);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aq.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aBF).Dm().aBC);
            }
        }
    }

    public void reset() {
        this.aBF = -1;
        this.aBE.removeAllViews();
    }

    public void dn(int i) {
        if (this.aBK != null) {
            aq.j(this.aBK, w.g.icon_news_head_prompt_one);
            this.aBK.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aBE.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aBE.getChildAt(i2);
            if (childAt != null) {
                aq.j(childAt, w.g.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aBF) {
                            aq.c(tbImageView, this.mDatas.get(i2).Dm().aBC);
                        } else {
                            aq.c(tbImageView, this.mDatas.get(i2).Dm().aBD);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aBG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int adq;

        private a(int i) {
            this.adq = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aBG.eN(this.adq);
        }
    }
}
