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
    private DeskLinearLayout aOY;
    private int aOZ;
    private CommonTabWidgetView.a aPa;
    private LinearLayout.LayoutParams aPb;
    private int aPc;
    private int aPd;
    private TextView aPe;
    private View aPf;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aOZ = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aOY = new DeskLinearLayout(getContext());
        this.aOY.setOrientation(0);
        this.aOY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aOY.setBaselineAligned(false);
        addView(this.aOY);
        this.aPc = getResources().getDimensionPixelSize(d.e.ds8);
        this.aPd = getResources().getDimensionPixelSize(d.e.ds10);
        this.aOY.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aPb = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aPf = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aPf.setLayoutParams(layoutParams);
        am.i(this.aPf, d.f.bg_expression_bar_n);
        this.aOY.addView(this.aPf);
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
        tbImageView.setPadding(this.aPd, this.aPc, this.aPd, this.aPc);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.aOX);
        linearLayout.setOnClickListener(new a(this.aOY.getChildCount() - 1));
        this.aOY.addView(linearLayout, this.aOY.getChildCount() - 1, this.aPb);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aOZ) {
            if (this.aOZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aOY.getChildAt(this.aOZ);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aOZ).Iz().aOX);
                } else {
                    return;
                }
            }
            this.aOZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aOY.getChildAt(this.aOZ);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aOZ).Iz().aOW);
            }
        }
    }

    public void reset() {
        this.aOZ = -1;
        this.aOY.removeAllViews();
    }

    public void dD(int i) {
        if (this.aPe != null) {
            am.i(this.aPe, d.f.icon_news_head_prompt_one);
            this.aPe.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aOY.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aOY.getChildAt(i2);
            if (childAt != null) {
                am.i(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aOZ) {
                            am.c(tbImageView, this.mDatas.get(i2).Iz().aOW);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).Iz().aOX);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aPa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aoG;

        private a(int i) {
            this.aoG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aPa.eY(this.aoG);
        }
    }
}
