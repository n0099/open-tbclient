package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private DeskLinearLayout aFG;
    private int aFH;
    private CommonTabWidgetView.a aFI;
    private LinearLayout.LayoutParams aFJ;
    private int aFK;
    private int aFL;
    private TextView aFM;
    private View aFN;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFH = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFH = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aFH = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aFG = new DeskLinearLayout(getContext());
        this.aFG.setOrientation(0);
        this.aFG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aFG.setBaselineAligned(false);
        addView(this.aFG);
        this.aFK = getResources().getDimensionPixelSize(d.e.ds8);
        this.aFL = getResources().getDimensionPixelSize(d.e.ds10);
        this.aFG.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aFJ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aFN = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aFN.setLayoutParams(layoutParams);
        ak.i(this.aFN, d.f.bg_expression_bar_n);
        this.aFG.addView(this.aFN);
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
        ak.i(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.aFL, this.aFK, this.aFL, this.aFK);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ak.c(tbImageView, bVar.aFF);
        linearLayout.setOnClickListener(new a(this.aFG.getChildCount() - 1));
        this.aFG.addView(linearLayout, this.aFG.getChildCount() - 1, this.aFJ);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aFH) {
            if (this.aFH != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aFG.getChildAt(this.aFH);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aFH).ED().aFF);
                } else {
                    return;
                }
            }
            this.aFH = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aFG.getChildAt(this.aFH);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ak.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aFH).ED().aFE);
            }
        }
    }

    public void reset() {
        this.aFH = -1;
        this.aFG.removeAllViews();
    }

    public void dA(int i) {
        if (this.aFM != null) {
            ak.i(this.aFM, d.f.icon_news_head_prompt_one);
            this.aFM.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aFG.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aFG.getChildAt(i2);
            if (childAt != null) {
                ak.i(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aFH) {
                            ak.c(tbImageView, this.mDatas.get(i2).ED().aFE);
                        } else {
                            ak.c(tbImageView, this.mDatas.get(i2).ED().aFF);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aFI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int agb;

        private a(int i) {
            this.agb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            CommonTabHorizonScrollView.this.aFI.eT(this.agb);
        }
    }
}
