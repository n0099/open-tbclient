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
    private e auY;
    private int auZ;
    private CommonTabWidgetView.a ava;
    private LinearLayout.LayoutParams avb;
    private int avc;
    private int avd;
    private TextView ave;
    private View avf;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.auZ = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.auY = new e(getContext());
        this.auY.setOrientation(0);
        this.auY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.auY.setBaselineAligned(false);
        addView(this.auY);
        this.avc = getResources().getDimensionPixelSize(n.e.face_tab_widget_tb_padding);
        this.avd = getResources().getDimensionPixelSize(n.e.face_tab_widget_lr_padding);
        this.auY.setPadding(0, getResources().getDimensionPixelSize(n.e.default_gap_6), 0, 0);
        this.avb = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.e.face_tab_widget_width), -1);
        this.avf = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.avf.setLayoutParams(layoutParams);
        as.i(this.avf, n.f.bg_expression_bar_n);
        this.auY.addView(this.avf);
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
        as.i(linearLayout, n.f.bg_expression_bar);
        tbImageView.setPadding(this.avd, this.avc, this.avd, this.avc);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        as.c(tbImageView, bVar.auX);
        linearLayout.setOnClickListener(new a(this, this.auY.getChildCount() - 1, null));
        this.auY.addView(linearLayout, this.auY.getChildCount() - 1, this.avb);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.auZ) {
            if (this.auZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.auY.getChildAt(this.auZ);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.auZ).Ct().auX);
                } else {
                    return;
                }
            }
            this.auZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.auY.getChildAt(this.auZ);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                as.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.auZ).Ct().auW);
            }
        }
    }

    public void reset() {
        this.auZ = -1;
        this.auY.removeAllViews();
    }

    public void cR(int i) {
        if (this.ave != null) {
            as.i((View) this.ave, n.f.icon_news_head_prompt_one);
            this.ave.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.auY.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.auY.getChildAt(i2);
            if (childAt != null) {
                as.i(childAt, n.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.auZ) {
                            as.c(tbImageView, this.mDatas.get(i2).Ct().auW);
                        } else {
                            as.c(tbImageView, this.mDatas.get(i2).Ct().auX);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.ava = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aan;

        private a(int i) {
            this.aan = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.ava.eq(this.aan);
        }
    }
}
