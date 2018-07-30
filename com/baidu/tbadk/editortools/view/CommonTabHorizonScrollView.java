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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private DeskLinearLayout aOX;
    private int aOY;
    private CommonTabWidgetView.a aOZ;
    private LinearLayout.LayoutParams aPa;
    private int aPb;
    private int aPc;
    private TextView aPd;
    private View aPe;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOY = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOY = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aOY = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aOX = new DeskLinearLayout(getContext());
        this.aOX.setOrientation(0);
        this.aOX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aOX.setBaselineAligned(false);
        addView(this.aOX);
        this.aPb = getResources().getDimensionPixelSize(d.e.ds8);
        this.aPc = getResources().getDimensionPixelSize(d.e.ds10);
        this.aOX.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aPa = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aPe = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aPe.setLayoutParams(layoutParams);
        am.i(this.aPe, d.f.bg_expression_bar_n);
        this.aOX.addView(this.aPe);
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
        am.i(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.aPc, this.aPb, this.aPc, this.aPb);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.aOW);
        linearLayout.setOnClickListener(new a(this.aOX.getChildCount() - 1));
        this.aOX.addView(linearLayout, this.aOX.getChildCount() - 1, this.aPa);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aOY) {
            if (this.aOY != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aOX.getChildAt(this.aOY);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aOY).Iu().aOW);
                } else {
                    return;
                }
            }
            this.aOY = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aOX.getChildAt(this.aOY);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aOY).Iu().aOV);
            }
        }
    }

    public void reset() {
        this.aOY = -1;
        this.aOX.removeAllViews();
    }

    public void dG(int i) {
        if (this.aPd != null) {
            am.i(this.aPd, d.f.icon_news_head_prompt_one);
            this.aPd.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aOX.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aOX.getChildAt(i2);
            if (childAt != null) {
                am.i(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aOY) {
                            am.c(tbImageView, this.mDatas.get(i2).Iu().aOV);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).Iu().aOW);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aOZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aoi;

        private a(int i) {
            this.aoi = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aOZ.eZ(this.aoi);
        }
    }
}
