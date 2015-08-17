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
    private int apO;
    private int apQ;
    private int apR;
    private TextView apU;
    private LinearLayout.LayoutParams apV;
    private View apX;
    private e asE;
    private CommonTabWidgetView.a asF;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apO = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apO = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.apO = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.asE = new e(getContext());
        this.asE.setOrientation(0);
        this.asE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.asE.setBaselineAligned(false);
        addView(this.asE);
        this.apQ = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.apR = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.asE.setPadding(0, getResources().getDimensionPixelSize(i.d.default_gap_6), 0, 0);
        this.apV = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1);
        this.apX = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.apX.setLayoutParams(layoutParams);
        al.i(this.apX, i.e.bg_expression_bar_n);
        this.asE.addView(this.apX);
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
        al.i(linearLayout, i.e.bg_expression_bar);
        tbImageView.setPadding(this.apR, this.apQ, this.apR, this.apQ);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.asD);
        linearLayout.setOnClickListener(new a(this, this.asE.getChildCount() - 1, null));
        this.asE.addView(linearLayout, this.asE.getChildCount() - 1, this.apV);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.apO) {
            if (this.apO != -1) {
                LinearLayout linearLayout = (LinearLayout) this.asE.getChildAt(this.apO);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.apO).BM().asD);
                } else {
                    return;
                }
            }
            this.apO = i;
            LinearLayout linearLayout2 = (LinearLayout) this.asE.getChildAt(this.apO);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.apO).BM().asC);
            }
        }
    }

    public void reset() {
        this.apO = -1;
        this.asE.removeAllViews();
    }

    public void cI(int i) {
        if (this.apU != null) {
            al.i((View) this.apU, i.e.icon_news_head_prompt_one);
            this.apU.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.asE.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.asE.getChildAt(i2);
            if (childAt != null) {
                al.i(childAt, i.e.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.apO) {
                            al.c(tbImageView, this.mDatas.get(i2).BM().asC);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).BM().asD);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.asF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YP;

        private a(int i) {
            this.YP = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.asF.dR(this.YP);
        }
    }
}
