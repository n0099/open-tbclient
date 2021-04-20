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
import d.b.h0.w.y.a;
import java.util.List;
/* loaded from: classes3.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public DeskLinearLayout f13576e;

    /* renamed from: f  reason: collision with root package name */
    public int f13577f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.h0.w.y.a> f13578g;

    /* renamed from: h  reason: collision with root package name */
    public CommonTabWidgetView.b f13579h;
    public LinearLayout.LayoutParams i;
    public int j;
    public int k;
    public TextView l;
    public View m;

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f13580e;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.f13579h.a(this.f13580e);
        }

        public b(int i) {
            this.f13580e = i;
        }
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13577f = -1;
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
        SkinManager.setImageResource(tbImageView, bVar.f52033b);
        linearLayout.setOnClickListener(new b(this.f13576e.getChildCount() - 1));
        this.f13576e.addView(linearLayout, this.f13576e.getChildCount() - 1, this.i);
        return tbImageView;
    }

    public final void d() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        DeskLinearLayout deskLinearLayout = new DeskLinearLayout(getContext());
        this.f13576e = deskLinearLayout;
        deskLinearLayout.setOrientation(0);
        this.f13576e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f13576e.setBaselineAligned(false);
        addView(this.f13576e);
        this.j = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.f13576e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.i = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.m = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.m.setLayoutParams(layoutParams);
        SkinManager.setBackgroundResource(this.m, R.drawable.bg_expression_bar_n);
        this.f13576e.addView(this.m);
    }

    public void e(int i) {
        TextView textView = this.l;
        if (textView != null) {
            SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
            this.l.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.f13576e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f13576e.getChildAt(i2);
            if (childAt != null) {
                SkinManager.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 == childCount - 1) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                if (tbImageView != null) {
                    if (i2 == this.f13577f) {
                        SkinManager.setImageResource(tbImageView, this.f13578g.get(i2).i().f52032a, i);
                    } else {
                        SkinManager.setImageResource(tbImageView, this.f13578g.get(i2).i().f52033b, i);
                    }
                }
            }
        }
    }

    public void f() {
        this.f13577f = -1;
        this.f13576e.removeAllViews();
    }

    public void setCurrentTab(int i) {
        int i2 = this.f13577f;
        if (i == i2) {
            return;
        }
        if (i2 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f13576e.getChildAt(i2);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setSelected(false);
            ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.f13578g.get(this.f13577f).i().f52033b);
        }
        this.f13577f = i;
        LinearLayout linearLayout2 = (LinearLayout) this.f13576e.getChildAt(i);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setSelected(true);
        SkinManager.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.f13578g.get(this.f13577f).i().f52032a);
    }

    public void setDatas(List<d.b.h0.w.y.a> list) {
        this.f13578g = list;
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.b bVar) {
        this.f13579h = bVar;
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13577f = -1;
        d();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.f13577f = -1;
        d();
    }
}
