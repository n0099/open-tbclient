package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private DeskLinearLayout aOU;
    private int aOV;
    private CommonTabWidgetView.a aOW;
    private LinearLayout.LayoutParams aOX;
    private int aOY;
    private int aOZ;
    private TextView aPa;
    private View aPb;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aOV = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aOU = new DeskLinearLayout(getContext());
        this.aOU.setOrientation(0);
        this.aOU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aOU.setBaselineAligned(false);
        addView(this.aOU);
        this.aOY = getResources().getDimensionPixelSize(f.e.ds8);
        this.aOZ = getResources().getDimensionPixelSize(f.e.ds10);
        this.aOU.setPadding(0, getResources().getDimensionPixelSize(f.e.ds10), 0, 0);
        this.aOX = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(f.e.ds106), -1);
        this.aPb = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aPb.setLayoutParams(layoutParams);
        am.i(this.aPb, f.C0146f.bg_expression_bar_n);
        this.aOU.addView(this.aPb);
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
        am.i(linearLayout, f.C0146f.bg_expression_bar);
        tbImageView.setPadding(this.aOZ, this.aOY, this.aOZ, this.aOY);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.aOT);
        linearLayout.setOnClickListener(new a(this.aOU.getChildCount() - 1));
        this.aOU.addView(linearLayout, this.aOU.getChildCount() - 1, this.aOX);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aOV) {
            if (this.aOV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aOU.getChildAt(this.aOV);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aOV).Iu().aOT);
                } else {
                    return;
                }
            }
            this.aOV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aOU.getChildAt(this.aOV);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aOV).Iu().aOS);
            }
        }
    }

    public void reset() {
        this.aOV = -1;
        this.aOU.removeAllViews();
    }

    public void dF(int i) {
        if (this.aPa != null) {
            am.i(this.aPa, f.C0146f.icon_news_head_prompt_one);
            this.aPa.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aOU.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aOU.getChildAt(i2);
            if (childAt != null) {
                am.i(childAt, f.C0146f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aOV) {
                            am.c(tbImageView, this.mDatas.get(i2).Iu().aOS);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).Iu().aOT);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aOW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aoj;

        private a(int i) {
            this.aoj = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aOW.eY(this.aoj);
        }
    }
}
