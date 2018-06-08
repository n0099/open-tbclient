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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private DeskLinearLayout aOc;
    private int aOd;
    private CommonTabWidgetView.a aOe;
    private LinearLayout.LayoutParams aOf;
    private int aOg;
    private int aOh;
    private TextView aOi;
    private View aOj;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOd = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOd = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.aOd = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aOc = new DeskLinearLayout(getContext());
        this.aOc.setOrientation(0);
        this.aOc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aOc.setBaselineAligned(false);
        addView(this.aOc);
        this.aOg = getResources().getDimensionPixelSize(d.e.ds8);
        this.aOh = getResources().getDimensionPixelSize(d.e.ds10);
        this.aOc.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.aOf = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.aOj = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aOj.setLayoutParams(layoutParams);
        al.i(this.aOj, d.f.bg_expression_bar_n);
        this.aOc.addView(this.aOj);
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
        al.i(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.aOh, this.aOg, this.aOh, this.aOg);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.aOb);
        linearLayout.setOnClickListener(new a(this.aOc.getChildCount() - 1));
        this.aOc.addView(linearLayout, this.aOc.getChildCount() - 1, this.aOf);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.aOd) {
            if (this.aOd != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aOc.getChildAt(this.aOd);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.aOd).Ih().aOb);
                } else {
                    return;
                }
            }
            this.aOd = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aOc.getChildAt(this.aOd);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.aOd).Ih().aOa);
            }
        }
    }

    public void reset() {
        this.aOd = -1;
        this.aOc.removeAllViews();
    }

    public void dC(int i) {
        if (this.aOi != null) {
            al.i(this.aOi, d.f.icon_news_head_prompt_one);
            this.aOi.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.aOc.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.aOc.getChildAt(i2);
            if (childAt != null) {
                al.i(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.aOd) {
                            al.c(tbImageView, this.mDatas.get(i2).Ih().aOa);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).Ih().aOb);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.aOe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int aog;

        private a(int i) {
            this.aog = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.aOe.eX(this.aog);
        }
    }
}
