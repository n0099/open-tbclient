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
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int arA;
    private int arB;
    private TextView arE;
    private LinearLayout.LayoutParams arF;
    private View arH;
    private int ary;
    private e auo;
    private CommonTabWidgetView.a aup;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ary = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ary = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.ary = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.auo = new e(getContext());
        this.auo.setOrientation(0);
        this.auo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.auo.setBaselineAligned(false);
        addView(this.auo);
        this.arA = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.arB = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.auo.setPadding(0, getResources().getDimensionPixelSize(i.d.default_gap_6), 0, 0);
        this.arF = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1);
        this.arH = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.arH.setLayoutParams(layoutParams);
        al.h(this.arH, i.e.bg_expression_bar_n);
        this.auo.addView(this.arH);
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
        al.h(linearLayout, i.e.bg_expression_bar);
        tbImageView.setPadding(this.arB, this.arA, this.arB, this.arA);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.aun);
        linearLayout.setOnClickListener(new a(this, this.auo.getChildCount() - 1, null));
        this.auo.addView(linearLayout, this.auo.getChildCount() - 1, this.arF);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.ary) {
            if (this.ary != -1) {
                LinearLayout linearLayout = (LinearLayout) this.auo.getChildAt(this.ary);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.ary).Ca().aun);
                } else {
                    return;
                }
            }
            this.ary = i;
            LinearLayout linearLayout2 = (LinearLayout) this.auo.getChildAt(this.ary);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.ary).Ca().aum);
            }
        }
    }

    public void reset() {
        this.ary = -1;
        this.auo.removeAllViews();
    }

    public void cO(int i) {
        if (this.arE != null) {
            al.h((View) this.arE, i.e.icon_news_head_prompt_one);
            this.arE.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.auo.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.auo.getChildAt(i2);
            if (childAt != null) {
                al.h(childAt, i.e.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.ary) {
                            al.c(tbImageView, this.mDatas.get(i2).Ca().aum);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).Ca().aun);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aup = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YY;

        private a(int i) {
            this.YY = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aup.dZ(this.YY);
        }
    }
}
