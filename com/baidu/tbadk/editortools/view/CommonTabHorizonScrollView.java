package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f axE;
    private int axF;
    private CommonTabWidgetView.a axG;
    private LinearLayout.LayoutParams axH;
    private int axI;
    private int axJ;
    private TextView axK;
    private View axL;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axF = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axF = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.axF = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.axE = new f(getContext());
        this.axE.setOrientation(0);
        this.axE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.axE.setBaselineAligned(false);
        addView(this.axE);
        this.axI = getResources().getDimensionPixelSize(r.e.ds8);
        this.axJ = getResources().getDimensionPixelSize(r.e.ds10);
        this.axE.setPadding(0, getResources().getDimensionPixelSize(r.e.ds10), 0, 0);
        this.axH = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds106), -1);
        this.axL = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.axL.setLayoutParams(layoutParams);
        at.k(this.axL, r.f.bg_expression_bar_n);
        this.axE.addView(this.axL);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0042b c0042b) {
        if (c0042b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        at.k(linearLayout, r.f.bg_expression_bar);
        tbImageView.setPadding(this.axJ, this.axI, this.axJ, this.axI);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        at.c(tbImageView, c0042b.axD);
        linearLayout.setOnClickListener(new a(this, this.axE.getChildCount() - 1, null));
        this.axE.addView(linearLayout, this.axE.getChildCount() - 1, this.axH);
        return tbImageView;
    }

    public void c(b.C0042b c0042b) {
        b(c0042b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.axF) {
            if (this.axF != -1) {
                LinearLayout linearLayout = (LinearLayout) this.axE.getChildAt(this.axF);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.axF).DU().axD);
                } else {
                    return;
                }
            }
            this.axF = i;
            LinearLayout linearLayout2 = (LinearLayout) this.axE.getChildAt(this.axF);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                at.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.axF).DU().axC);
            }
        }
    }

    public void reset() {
        this.axF = -1;
        this.axE.removeAllViews();
    }

    public void dm(int i) {
        if (this.axK != null) {
            at.k(this.axK, r.f.icon_news_head_prompt_one);
            this.axK.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.axE.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.axE.getChildAt(i2);
            if (childAt != null) {
                at.k(childAt, r.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.axF) {
                            at.c(tbImageView, this.mDatas.get(i2).DU().axC);
                        } else {
                            at.c(tbImageView, this.mDatas.get(i2).DU().axD);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.axG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int ZU;

        private a(int i) {
            this.ZU = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.axG.eQ(this.ZU);
        }
    }
}
