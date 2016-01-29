package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private e avQ;
    private int avR;
    private CommonTabWidgetView.a avS;
    private LinearLayout.LayoutParams avT;
    private int avU;
    private int avV;
    private TextView avW;
    private View avX;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avR = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avR = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.avR = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.avQ = new e(getContext());
        this.avQ.setOrientation(0);
        this.avQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.avQ.setBaselineAligned(false);
        addView(this.avQ);
        this.avU = getResources().getDimensionPixelSize(t.e.face_tab_widget_tb_padding);
        this.avV = getResources().getDimensionPixelSize(t.e.face_tab_widget_lr_padding);
        this.avQ.setPadding(0, getResources().getDimensionPixelSize(t.e.default_gap_6), 0, 0);
        this.avT = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.face_tab_widget_width), -1);
        this.avX = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.avX.setLayoutParams(layoutParams);
        ar.k(this.avX, t.f.bg_expression_bar_n);
        this.avQ.addView(this.avX);
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
        ar.k(linearLayout, t.f.bg_expression_bar);
        tbImageView.setPadding(this.avV, this.avU, this.avV, this.avU);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ar.c(tbImageView, bVar.avP);
        linearLayout.setOnClickListener(new a(this, this.avQ.getChildCount() - 1, null));
        this.avQ.addView(linearLayout, this.avQ.getChildCount() - 1, this.avT);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.avR) {
            if (this.avR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.avQ.getChildAt(this.avR);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.avR).DJ().avP);
                } else {
                    return;
                }
            }
            this.avR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.avQ.getChildAt(this.avR);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ar.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.avR).DJ().avO);
            }
        }
    }

    public void reset() {
        this.avR = -1;
        this.avQ.removeAllViews();
    }

    public void dk(int i) {
        if (this.avW != null) {
            ar.k(this.avW, t.f.icon_news_head_prompt_one);
            this.avW.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.avQ.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.avQ.getChildAt(i2);
            if (childAt != null) {
                ar.k(childAt, t.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.avR) {
                            ar.c(tbImageView, this.mDatas.get(i2).DJ().avO);
                        } else {
                            ar.c(tbImageView, this.mDatas.get(i2).DJ().avP);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.avS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aaL;

        private a(int i) {
            this.aaL = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.avS.eK(this.aaL);
        }
    }
}
