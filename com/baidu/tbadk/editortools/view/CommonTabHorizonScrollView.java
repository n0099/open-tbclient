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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams awA;
    private int awB;
    private int awC;
    private TextView awD;
    private View awE;
    private f awx;
    private int awy;
    private CommonTabWidgetView.a awz;
    private List<b> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awy = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awy = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.awy = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.awx = new f(getContext());
        this.awx.setOrientation(0);
        this.awx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.awx.setBaselineAligned(false);
        addView(this.awx);
        this.awB = getResources().getDimensionPixelSize(t.e.face_tab_widget_tb_padding);
        this.awC = getResources().getDimensionPixelSize(t.e.face_tab_widget_lr_padding);
        this.awx.setPadding(0, getResources().getDimensionPixelSize(t.e.default_gap_6), 0, 0);
        this.awA = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.face_tab_widget_width), -1);
        this.awE = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.awE.setLayoutParams(layoutParams);
        at.k(this.awE, t.f.bg_expression_bar_n);
        this.awx.addView(this.awE);
    }

    public void setDatas(List<b> list) {
        this.mDatas = list;
    }

    private TbImageView b(b.C0050b c0050b) {
        if (c0050b == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        at.k(linearLayout, t.f.bg_expression_bar);
        tbImageView.setPadding(this.awC, this.awB, this.awC, this.awB);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        at.c(tbImageView, c0050b.aww);
        linearLayout.setOnClickListener(new a(this, this.awx.getChildCount() - 1, null));
        this.awx.addView(linearLayout, this.awx.getChildCount() - 1, this.awA);
        return tbImageView;
    }

    public void c(b.C0050b c0050b) {
        b(c0050b);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.awy) {
            if (this.awy != -1) {
                LinearLayout linearLayout = (LinearLayout) this.awx.getChildAt(this.awy);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.awy).Et().aww);
                } else {
                    return;
                }
            }
            this.awy = i;
            LinearLayout linearLayout2 = (LinearLayout) this.awx.getChildAt(this.awy);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                at.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.awy).Et().awv);
            }
        }
    }

    public void reset() {
        this.awy = -1;
        this.awx.removeAllViews();
    }

    public void dn(int i) {
        if (this.awD != null) {
            at.k(this.awD, t.f.icon_news_head_prompt_one);
            this.awD.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.awx.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.awx.getChildAt(i2);
            if (childAt != null) {
                at.k(childAt, t.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.awy) {
                            at.c(tbImageView, this.mDatas.get(i2).Et().awv);
                        } else {
                            at.c(tbImageView, this.mDatas.get(i2).Et().aww);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.awz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int ZX;

        private a(int i) {
            this.ZX = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.awz.eQ(this.ZX);
        }
    }
}
