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
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int apY;
    private int aqa;
    private int aqb;
    private TextView aqe;
    private LinearLayout.LayoutParams aqf;
    private View aqh;
    private e asL;
    private CommonTabWidgetView.a asM;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apY = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apY = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.apY = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.asL = new e(getContext());
        this.asL.setOrientation(0);
        this.asL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.asL.setBaselineAligned(false);
        addView(this.asL);
        this.aqa = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.aqb = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.asL.setPadding(0, getResources().getDimensionPixelSize(i.d.default_gap_6), 0, 0);
        this.aqf = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1);
        this.aqh = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aqh.setLayoutParams(layoutParams);
        am.i(this.aqh, i.e.bg_expression_bar_n);
        this.asL.addView(this.aqh);
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
        am.i(linearLayout, i.e.bg_expression_bar);
        tbImageView.setPadding(this.aqb, this.aqa, this.aqb, this.aqa);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.c(tbImageView, bVar.asK);
        linearLayout.setOnClickListener(new a(this, this.asL.getChildCount() - 1, null));
        this.asL.addView(linearLayout, this.asL.getChildCount() - 1, this.aqf);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.apY) {
            if (this.apY != -1) {
                LinearLayout linearLayout = (LinearLayout) this.asL.getChildAt(this.apY);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.apY).BN().asK);
                } else {
                    return;
                }
            }
            this.apY = i;
            LinearLayout linearLayout2 = (LinearLayout) this.asL.getChildAt(this.apY);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.apY).BN().asJ);
            }
        }
    }

    public void reset() {
        this.apY = -1;
        this.asL.removeAllViews();
    }

    public void cP(int i) {
        if (this.aqe != null) {
            am.i((View) this.aqe, i.e.icon_news_head_prompt_one);
            this.aqe.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.asL.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.asL.getChildAt(i2);
            if (childAt != null) {
                am.i(childAt, i.e.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.apY) {
                            am.c(tbImageView, this.mDatas.get(i2).BN().asJ);
                        } else {
                            am.c(tbImageView, this.mDatas.get(i2).BN().asK);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.asM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YR;

        private a(int i) {
            this.YR = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.asM.ea(this.YR);
        }
    }
}
