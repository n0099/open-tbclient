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
    private int biS;
    private LinearLayout.LayoutParams bjv;
    private DeskLinearLayout clt;
    private CommonTabWidgetView.a clu;
    private int clv;
    private int clw;
    private TextView clx;
    private View cly;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biS = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biS = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.biS = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.clt = new DeskLinearLayout(getContext());
        this.clt.setOrientation(0);
        this.clt.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.clt.setBaselineAligned(false);
        addView(this.clt);
        this.clv = getResources().getDimensionPixelSize(d.e.ds8);
        this.clw = getResources().getDimensionPixelSize(d.e.ds10);
        this.clt.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bjv = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.cly = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cly.setLayoutParams(layoutParams);
        al.k(this.cly, d.f.bg_expression_bar_n);
        this.clt.addView(this.cly);
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
        al.k(linearLayout, d.f.bg_expression_bar);
        tbImageView.setPadding(this.clw, this.clv, this.clw, this.clv);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.cls);
        linearLayout.setOnClickListener(new a(this.clt.getChildCount() - 1));
        this.clt.addView(linearLayout, this.clt.getChildCount() - 1, this.bjv);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.biS) {
            if (this.biS != -1) {
                LinearLayout linearLayout = (LinearLayout) this.clt.getChildAt(this.biS);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.biS).amU().cls);
                } else {
                    return;
                }
            }
            this.biS = i;
            LinearLayout linearLayout2 = (LinearLayout) this.clt.getChildAt(this.biS);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.biS).amU().clr);
            }
        }
    }

    public void reset() {
        this.biS = -1;
        this.clt.removeAllViews();
    }

    public void ij(int i) {
        if (this.clx != null) {
            al.k(this.clx, d.f.icon_news_head_prompt_one);
            this.clx.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.clt.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.clt.getChildAt(i2);
            if (childAt != null) {
                al.k(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.biS) {
                            al.c(tbImageView, this.mDatas.get(i2).amU().clr);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).amU().cls);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.clu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bIr;

        private a(int i) {
            this.bIr = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.clu.jH(this.bIr);
        }
    }
}
