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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams bqN;
    private int bqk;
    private DeskLinearLayout cvX;
    private CommonTabWidgetView.a cvY;
    private int cvZ;
    private int cwa;
    private TextView cwb;
    private View cwc;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqk = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqk = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.bqk = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cvX = new DeskLinearLayout(getContext());
        this.cvX.setOrientation(0);
        this.cvX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cvX.setBaselineAligned(false);
        addView(this.cvX);
        this.cvZ = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cwa = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cvX.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.bqN = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.cwc = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cwc.setLayoutParams(layoutParams);
        am.k(this.cwc, R.drawable.bg_expression_bar_n);
        this.cvX.addView(this.cwc);
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
        am.k(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.cwa, this.cvZ, this.cwa, this.cvZ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.cvW);
        linearLayout.setOnClickListener(new a(this.cvX.getChildCount() - 1));
        this.cvX.addView(linearLayout, this.cvX.getChildCount() - 1, this.bqN);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.bqk) {
            if (this.bqk != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cvX.getChildAt(this.bqk);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.bqk).ato().cvW);
                } else {
                    return;
                }
            }
            this.bqk = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cvX.getChildAt(this.bqk);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.bqk).ato().cvV);
            }
        }
    }

    public void reset() {
        this.bqk = -1;
        this.cvX.removeAllViews();
    }

    public void jg(int i) {
        if (this.cwb != null) {
            am.k(this.cwb, R.drawable.icon_news_head_prompt_one);
            this.cwb.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.cvX.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.cvX.getChildAt(i2);
            if (childAt != null) {
                am.k(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.bqk) {
                            am.c(tbImageView, this.mDatas.get(i2).ato().cvV);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).ato().cvW);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.cvY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bRM;

        private a(int i) {
            this.bRM = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.cvY.kE(this.bRM);
        }
    }
}
