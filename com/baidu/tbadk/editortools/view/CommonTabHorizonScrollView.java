package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private int apZ;
    private int aqb;
    private int aqc;
    private TextView aqf;
    private LinearLayout.LayoutParams aqg;
    private View aqi;
    private e asM;
    private CommonTabWidgetView.a asN;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apZ = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.apZ = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.asM = new e(getContext());
        this.asM.setOrientation(0);
        this.asM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.asM.setBaselineAligned(false);
        addView(this.asM);
        this.aqb = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.aqc = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.asM.setPadding(0, getResources().getDimensionPixelSize(i.d.default_gap_6), 0, 0);
        this.aqg = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1);
        this.aqi = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aqi.setLayoutParams(layoutParams);
        an.i(this.aqi, i.e.bg_expression_bar_n);
        this.asM.addView(this.aqi);
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
        an.i(linearLayout, i.e.bg_expression_bar);
        tbImageView.setPadding(this.aqc, this.aqb, this.aqc, this.aqb);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        an.c(tbImageView, bVar.asL);
        linearLayout.setOnClickListener(new a(this, this.asM.getChildCount() - 1, null));
        this.asM.addView(linearLayout, this.asM.getChildCount() - 1, this.aqg);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.apZ) {
            if (this.apZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.asM.getChildAt(this.apZ);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.apZ).BK().asL);
                } else {
                    return;
                }
            }
            this.apZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.asM.getChildAt(this.apZ);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                an.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.apZ).BK().asK);
            }
        }
    }

    public void reset() {
        this.apZ = -1;
        this.asM.removeAllViews();
    }

    public void cP(int i) {
        if (this.aqf != null) {
            an.i((View) this.aqf, i.e.icon_news_head_prompt_one);
            this.aqf.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.asM.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.asM.getChildAt(i2);
            if (childAt != null) {
                an.i(childAt, i.e.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.apZ) {
                            an.c(tbImageView, this.mDatas.get(i2).BK().asK);
                        } else {
                            an.c(tbImageView, this.mDatas.get(i2).BK().asL);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.asN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YT;

        private a(int i) {
            this.YT = i;
        }

        /* synthetic */ a(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.asN.ea(this.YT);
        }
    }
}
