package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private TextView atA;
    private View atB;
    private e atu;
    private int atv;
    private CommonTabWidgetView.a atw;
    private LinearLayout.LayoutParams atx;
    private int aty;
    private int atz;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atv = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atv = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.atv = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.atu = new e(getContext());
        this.atu.setOrientation(0);
        this.atu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.atu.setBaselineAligned(false);
        addView(this.atu);
        this.aty = getResources().getDimensionPixelSize(n.d.face_tab_widget_tb_padding);
        this.atz = getResources().getDimensionPixelSize(n.d.face_tab_widget_lr_padding);
        this.atu.setPadding(0, getResources().getDimensionPixelSize(n.d.default_gap_6), 0, 0);
        this.atx = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.d.face_tab_widget_width), -1);
        this.atB = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.atB.setLayoutParams(layoutParams);
        as.i(this.atB, n.e.bg_expression_bar_n);
        this.atu.addView(this.atB);
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
        as.i(linearLayout, n.e.bg_expression_bar);
        tbImageView.setPadding(this.atz, this.aty, this.atz, this.aty);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        as.c(tbImageView, bVar.att);
        linearLayout.setOnClickListener(new a(this, this.atu.getChildCount() - 1, null));
        this.atu.addView(linearLayout, this.atu.getChildCount() - 1, this.atx);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.atv) {
            if (this.atv != -1) {
                LinearLayout linearLayout = (LinearLayout) this.atu.getChildAt(this.atv);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.atv).CE().att);
                } else {
                    return;
                }
            }
            this.atv = i;
            LinearLayout linearLayout2 = (LinearLayout) this.atu.getChildAt(this.atv);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                as.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.atv).CE().ats);
            }
        }
    }

    public void reset() {
        this.atv = -1;
        this.atu.removeAllViews();
    }

    public void cX(int i) {
        if (this.atA != null) {
            as.i((View) this.atA, n.e.icon_news_head_prompt_one);
            this.atA.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.atu.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.atu.getChildAt(i2);
            if (childAt != null) {
                as.i(childAt, n.e.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.atv) {
                            as.c(tbImageView, this.mDatas.get(i2).CE().ats);
                        } else {
                            as.c(tbImageView, this.mDatas.get(i2).CE().att);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.atw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int ZJ;

        private a(int i) {
            this.ZJ = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.atw.ew(this.ZJ);
        }
    }
}
