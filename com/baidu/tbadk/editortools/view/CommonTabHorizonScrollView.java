package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.w.y.a;
import java.util.List;
/* loaded from: classes3.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public DeskLinearLayout f13584e;

    /* renamed from: f  reason: collision with root package name */
    public int f13585f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.w.y.a> f13586g;

    /* renamed from: h  reason: collision with root package name */
    public CommonTabWidgetView.b f13587h;
    public LinearLayout.LayoutParams i;
    public int j;
    public int k;
    public TextView l;
    public View m;

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f13588e;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.f13587h.a(this.f13588e);
        }

        public b(int i) {
            this.f13588e = i;
        }
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13585f = -1;
        d();
    }

    public void b(a.b bVar) {
        c(bVar);
        invalidate();
    }

    public final TbImageView c(a.b bVar) {
        if (bVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        int i = this.k;
        int i2 = this.j;
        tbImageView.setPadding(i, i2, i, i2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        SkinManager.setImageResource(tbImageView, bVar.f52369b);
        linearLayout.setOnClickListener(new b(this.f13584e.getChildCount() - 1));
        this.f13584e.addView(linearLayout, this.f13584e.getChildCount() - 1, this.i);
        return tbImageView;
    }

    public final void d() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        DeskLinearLayout deskLinearLayout = new DeskLinearLayout(getContext());
        this.f13584e = deskLinearLayout;
        deskLinearLayout.setOrientation(0);
        this.f13584e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f13584e.setBaselineAligned(false);
        addView(this.f13584e);
        this.j = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.f13584e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.i = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.m = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.m.setLayoutParams(layoutParams);
        SkinManager.setBackgroundResource(this.m, R.drawable.bg_expression_bar_n);
        this.f13584e.addView(this.m);
    }

    public void e(int i) {
        TextView textView = this.l;
        if (textView != null) {
            SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
            this.l.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.f13584e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f13584e.getChildAt(i2);
            if (childAt != null) {
                SkinManager.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 == childCount - 1) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                if (tbImageView != null) {
                    if (i2 == this.f13585f) {
                        SkinManager.setImageResource(tbImageView, this.f13586g.get(i2).i().f52368a, i);
                    } else {
                        SkinManager.setImageResource(tbImageView, this.f13586g.get(i2).i().f52369b, i);
                    }
                }
            }
        }
    }

    public void f() {
        this.f13585f = -1;
        this.f13584e.removeAllViews();
    }

    public void setCurrentTab(int i) {
        int i2 = this.f13585f;
        if (i == i2) {
            return;
        }
        if (i2 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f13584e.getChildAt(i2);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setSelected(false);
            ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.f13586g.get(this.f13585f).i().f52369b);
        }
        this.f13585f = i;
        LinearLayout linearLayout2 = (LinearLayout) this.f13584e.getChildAt(i);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setSelected(true);
        SkinManager.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.f13586g.get(this.f13585f).i().f52368a);
    }

    public void setDatas(List<d.b.i0.w.y.a> list) {
        this.f13586g = list;
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.b bVar) {
        this.f13587h = bVar;
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13585f = -1;
        d();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.f13585f = -1;
        d();
    }
}
