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
    private DeskLinearLayout aFF;
    private int aFG;
    private CommonTabWidgetView.a aFH;
    private LinearLayout.LayoutParams aFI;
    private int aFJ;
    private int aFK;
    private TextView aFL;
    private View aFM;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFG = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFG = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aFG = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aFF = new DeskLinearLayout(getContext());
        this.aFF.setOrientation(0);
        this.aFF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aFF.setBaselineAligned(false);
        addView(this.aFF);
        this.aFJ = getResources().getDimensionPixelSize(d.e.ds8);
        this.aFK = getResources().getDimensionPixelSize(d.e.ds10);
        this.aFF.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aFI = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aFM = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aFM.setLayoutParams(layoutParams);
        ak.i(this.aFM, d.f.bg_expression_bar_n);
        this.aFF.addView(this.aFM);
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
        tbImageView.setPadding(this.aFK, this.aFJ, this.aFK, this.aFJ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ak.c(tbImageView, bVar.aFE);
        linearLayout.setOnClickListener(new a(this.aFF.getChildCount() - 1));
        this.aFF.addView(linearLayout, this.aFF.getChildCount() - 1, this.aFI);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aFG) {
            if (this.aFG != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aFF.getChildAt(this.aFG);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aFG).EF().aFE);
                } else {
                    return;
                }
            }
            this.aFG = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aFF.getChildAt(this.aFG);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ak.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aFG).EF().aFD);
            }
        }
    }

    public void reset() {
        this.aFG = -1;
        this.aFF.removeAllViews();
    }

    public void dz(int i) {
        if (this.aFL != null) {
            ak.i(this.aFL, d.f.icon_news_head_prompt_one);
            this.aFL.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aFF.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aFF.getChildAt(i2);
            if (childAt != null) {
                ak.i(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aFG) {
                            ak.c(tbImageView, this.mDatas.get(i2).EF().aFD);
                        } else {
                            ak.c(tbImageView, this.mDatas.get(i2).EF().aFE);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aFH = aVar;
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
            CommonTabHorizonScrollView.this.aFH.eS(this.agb);
        }
    }
}
