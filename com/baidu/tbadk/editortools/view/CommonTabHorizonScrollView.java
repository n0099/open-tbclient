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
    private int biW;
    private LinearLayout.LayoutParams bjz;
    private TextView clA;
    private View clB;
    private DeskLinearLayout clw;
    private CommonTabWidgetView.a clx;
    private int cly;
    private int clz;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biW = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biW = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.biW = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.clw = new DeskLinearLayout(getContext());
        this.clw.setOrientation(0);
        this.clw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.clw.setBaselineAligned(false);
        addView(this.clw);
        this.cly = getResources().getDimensionPixelSize(d.e.ds8);
        this.clz = getResources().getDimensionPixelSize(d.e.ds10);
        this.clw.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bjz = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.clB = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.clB.setLayoutParams(layoutParams);
        al.k(this.clB, d.f.bg_expression_bar_n);
        this.clw.addView(this.clB);
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
        tbImageView.setPadding(this.clz, this.cly, this.clz, this.cly);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.clv);
        linearLayout.setOnClickListener(new a(this.clw.getChildCount() - 1));
        this.clw.addView(linearLayout, this.clw.getChildCount() - 1, this.bjz);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.biW) {
            if (this.biW != -1) {
                LinearLayout linearLayout = (LinearLayout) this.clw.getChildAt(this.biW);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.biW).amR().clv);
                } else {
                    return;
                }
            }
            this.biW = i;
            LinearLayout linearLayout2 = (LinearLayout) this.clw.getChildAt(this.biW);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.biW).amR().clu);
            }
        }
    }

    public void reset() {
        this.biW = -1;
        this.clw.removeAllViews();
    }

    public void ii(int i) {
        if (this.clA != null) {
            al.k(this.clA, d.f.icon_news_head_prompt_one);
            this.clA.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.clw.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.clw.getChildAt(i2);
            if (childAt != null) {
                al.k(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.biW) {
                            al.c(tbImageView, this.mDatas.get(i2).amR().clu);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).amR().clv);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.clx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bIu;

        private a(int i) {
            this.bIu = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.clx.jG(this.bIu);
        }
    }
}
