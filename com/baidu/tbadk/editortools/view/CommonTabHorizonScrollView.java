package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private DeskLinearLayout bbP;
    private CommonTabWidgetView.a bbQ;
    private int bbR;
    private int bbS;
    private TextView bbT;
    private View bbU;
    private int mCurrentIndex;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;
    private LinearLayout.LayoutParams mParams;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bbP = new DeskLinearLayout(getContext());
        this.bbP.setOrientation(0);
        this.bbP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bbP.setBaselineAligned(false);
        addView(this.bbP);
        this.bbR = getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.bbS = getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.bbP.setPadding(0, getResources().getDimensionPixelSize(e.C0210e.ds10), 0, 0);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds106), -1);
        this.bbU = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bbU.setLayoutParams(layoutParams);
        al.i(this.bbU, e.f.bg_expression_bar_n);
        this.bbP.addView(this.bbU);
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
        al.i(linearLayout, e.f.bg_expression_bar);
        tbImageView.setPadding(this.bbS, this.bbR, this.bbS, this.bbR);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.bbO);
        linearLayout.setOnClickListener(new a(this.bbP.getChildCount() - 1));
        this.bbP.addView(linearLayout, this.bbP.getChildCount() - 1, this.mParams);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bbP.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).Nq().bbO);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bbP.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).Nq().bbN);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.bbP.removeAllViews();
    }

    public void eD(int i) {
        if (this.bbT != null) {
            al.i(this.bbT, e.f.icon_news_head_prompt_one);
            this.bbT.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bbP.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bbP.getChildAt(i2);
            if (childAt != null) {
                al.i(childAt, e.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            al.c(tbImageView, this.mDatas.get(i2).Nq().bbN);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).Nq().bbO);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.bbQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aAw;

        private a(int i) {
            this.aAw = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.bbQ.fW(this.aAw);
        }
    }
}
