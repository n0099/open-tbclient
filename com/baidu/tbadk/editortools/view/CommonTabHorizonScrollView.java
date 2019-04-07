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
    private int biV;
    private LinearLayout.LayoutParams bjy;
    private View clA;
    private DeskLinearLayout clv;
    private CommonTabWidgetView.a clw;
    private int clx;
    private int cly;
    private TextView clz;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biV = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.biV = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.clv = new DeskLinearLayout(getContext());
        this.clv.setOrientation(0);
        this.clv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.clv.setBaselineAligned(false);
        addView(this.clv);
        this.clx = getResources().getDimensionPixelSize(d.e.ds8);
        this.cly = getResources().getDimensionPixelSize(d.e.ds10);
        this.clv.setPadding(0, getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
        this.bjy = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1);
        this.clA = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.clA.setLayoutParams(layoutParams);
        al.k(this.clA, d.f.bg_expression_bar_n);
        this.clv.addView(this.clA);
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
        tbImageView.setPadding(this.cly, this.clx, this.cly, this.clx);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        al.c(tbImageView, bVar.clu);
        linearLayout.setOnClickListener(new a(this.clv.getChildCount() - 1));
        this.clv.addView(linearLayout, this.clv.getChildCount() - 1, this.bjy);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.biV) {
            if (this.biV != -1) {
                LinearLayout linearLayout = (LinearLayout) this.clv.getChildAt(this.biV);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.biV).amR().clu);
                } else {
                    return;
                }
            }
            this.biV = i;
            LinearLayout linearLayout2 = (LinearLayout) this.clv.getChildAt(this.biV);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                al.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.biV).amR().clt);
            }
        }
    }

    public void reset() {
        this.biV = -1;
        this.clv.removeAllViews();
    }

    public void ii(int i) {
        if (this.clz != null) {
            al.k(this.clz, d.f.icon_news_head_prompt_one);
            this.clz.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.clv.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.clv.getChildAt(i2);
            if (childAt != null) {
                al.k(childAt, d.f.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.biV) {
                            al.c(tbImageView, this.mDatas.get(i2).amR().clt);
                        } else {
                            al.c(tbImageView, this.mDatas.get(i2).amR().clu);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.clw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int bIt;

        private a(int i) {
            this.bIt = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.clw.jG(this.bIt);
        }
    }
}
