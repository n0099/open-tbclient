package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private f awN;
    private int awO;
    private CommonTabWidgetView.a awP;
    private LinearLayout.LayoutParams awQ;
    private int awR;
    private int awS;
    private TextView awT;
    private View awU;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awO = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awO = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.awO = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.awN = new f(getContext());
        this.awN.setOrientation(0);
        this.awN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.awN.setBaselineAligned(false);
        addView(this.awN);
        this.awR = getResources().getDimensionPixelSize(r.e.ds8);
        this.awS = getResources().getDimensionPixelSize(r.e.ds10);
        this.awN.setPadding(0, getResources().getDimensionPixelSize(r.e.ds10), 0, 0);
        this.awQ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds106), -1);
        this.awU = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.awU.setLayoutParams(layoutParams);
        av.k(this.awU, r.f.bg_expression_bar_n);
        this.awN.addView(this.awU);
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
        av.k(linearLayout, r.f.bg_expression_bar);
        tbImageView.setPadding(this.awS, this.awR, this.awS, this.awR);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        av.c(tbImageView, c0042b.awM);
        linearLayout.setOnClickListener(new a(this, this.awN.getChildCount() - 1, null));
        this.awN.addView(linearLayout, this.awN.getChildCount() - 1, this.awQ);
        return tbImageView;
    }

    public void c(b.C0042b c0042b) {
        b(c0042b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.awO) {
            if (this.awO != -1) {
                LinearLayout linearLayout = (LinearLayout) this.awN.getChildAt(this.awO);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.awO).DP().awM);
                } else {
                    return;
                }
            }
            this.awO = i;
            LinearLayout linearLayout2 = (LinearLayout) this.awN.getChildAt(this.awO);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                av.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.awO).DP().awL);
            }
        }
    }

    public void reset() {
        this.awO = -1;
        this.awN.removeAllViews();
    }

    public void dl(int i) {
        if (this.awT != null) {
            av.k(this.awT, r.f.icon_news_head_prompt_one);
            this.awT.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.awN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.awN.getChildAt(i2);
            if (childAt != null) {
                av.k(childAt, r.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.awO) {
                            av.c(tbImageView, this.mDatas.get(i2).DP().awL);
                        } else {
                            av.c(tbImageView, this.mDatas.get(i2).DP().awM);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.awP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Zw;

        private a(int i) {
            this.Zw = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.awP.eN(this.Zw);
        }
    }
}
