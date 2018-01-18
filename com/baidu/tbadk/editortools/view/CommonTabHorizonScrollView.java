package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private c bsV;
    private int bsW;
    private CommonTabWidgetView.a bsX;
    private LinearLayout.LayoutParams bsY;
    private int bsZ;
    private int bta;
    private TextView btb;
    private View btc;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsW = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsW = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bsW = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bsV = new c(getContext());
        this.bsV.setOrientation(0);
        this.bsV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bsV.setBaselineAligned(false);
        addView(this.bsV);
        this.bsZ = getResources().getDimensionPixelSize(d.e.ds8);
        this.bta = getResources().getDimensionPixelSize(d.e.ds10);
        this.bsV.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bsY = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.btc = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.btc.setLayoutParams(layoutParams);
        aj.s(this.btc, d.f.bg_expression_bar_n);
        this.bsV.addView(this.btc);
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
        aj.s(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.bta, this.bsZ, this.bta, this.bsZ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        aj.c(tbImageView, bVar.bsU);
        linearLayout.setOnClickListener(new a(this.bsV.getChildCount() - 1));
        this.bsV.addView(linearLayout, this.bsV.getChildCount() - 1, this.bsY);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bsW) {
            if (this.bsW != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bsV.getChildAt(this.bsW);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bsW).Lu().bsU);
                } else {
                    return;
                }
            }
            this.bsW = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bsV.getChildAt(this.bsW);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                aj.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bsW).Lu().bsT);
            }
        }
    }

    public void reset() {
        this.bsW = -1;
        this.bsV.removeAllViews();
    }

    public void gz(int i) {
        if (this.btb != null) {
            aj.s(this.btb, d.f.icon_news_head_prompt_one);
            this.btb.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bsV.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bsV.getChildAt(i2);
            if (childAt != null) {
                aj.s(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bsW) {
                            aj.c(tbImageView, this.mDatas.get(i2).Lu().bsT);
                        } else {
                            aj.c(tbImageView, this.mDatas.get(i2).Lu().bsU);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bsX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aTk;

        private a(int i) {
            this.aTk = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bsX.hV(this.aTk);
        }
    }
}
