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
import d.a.n0.w.y.a;
import java.util.List;
/* loaded from: classes3.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public DeskLinearLayout f12970e;

    /* renamed from: f  reason: collision with root package name */
    public int f12971f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.n0.w.y.a> f12972g;

    /* renamed from: h  reason: collision with root package name */
    public CommonTabWidgetView.b f12973h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout.LayoutParams f12974i;
    public int j;
    public int k;
    public TextView l;
    public View m;

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final int f12975e;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.f12973h.a(this.f12975e);
        }

        public b(int i2) {
            this.f12975e = i2;
        }
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12971f = -1;
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
        int i2 = this.k;
        int i3 = this.j;
        tbImageView.setPadding(i2, i3, i2, i3);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        SkinManager.setImageResource(tbImageView, bVar.f54721b);
        linearLayout.setOnClickListener(new b(this.f12970e.getChildCount() - 1));
        this.f12970e.addView(linearLayout, this.f12970e.getChildCount() - 1, this.f12974i);
        return tbImageView;
    }

    public final void d() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        DeskLinearLayout deskLinearLayout = new DeskLinearLayout(getContext());
        this.f12970e = deskLinearLayout;
        deskLinearLayout.setOrientation(0);
        this.f12970e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f12970e.setBaselineAligned(false);
        addView(this.f12970e);
        this.j = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.f12970e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.f12974i = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.m = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.m.setLayoutParams(layoutParams);
        SkinManager.setBackgroundResource(this.m, R.drawable.bg_expression_bar_n);
        this.f12970e.addView(this.m);
    }

    public void e(int i2) {
        TextView textView = this.l;
        if (textView != null) {
            SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i2);
            this.l.setTextColor((i2 == 1 || i2 == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.f12970e.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f12970e.getChildAt(i3);
            if (childAt != null) {
                SkinManager.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i2);
                if (i3 == childCount - 1) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                if (tbImageView != null) {
                    if (i3 == this.f12971f) {
                        SkinManager.setImageResource(tbImageView, this.f12972g.get(i3).i().f54720a, i2);
                    } else {
                        SkinManager.setImageResource(tbImageView, this.f12972g.get(i3).i().f54721b, i2);
                    }
                }
            }
        }
    }

    public void f() {
        this.f12971f = -1;
        this.f12970e.removeAllViews();
    }

    public void setCurrentTab(int i2) {
        int i3 = this.f12971f;
        if (i2 == i3) {
            return;
        }
        if (i3 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f12970e.getChildAt(i3);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setSelected(false);
            ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.f12972g.get(this.f12971f).i().f54721b);
        }
        this.f12971f = i2;
        LinearLayout linearLayout2 = (LinearLayout) this.f12970e.getChildAt(i2);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setSelected(true);
        SkinManager.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.f12972g.get(this.f12971f).i().f54720a);
    }

    public void setDatas(List<d.a.n0.w.y.a> list) {
        this.f12972g = list;
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.b bVar) {
        this.f12973h = bVar;
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12971f = -1;
        d();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.f12971f = -1;
        d();
    }
}
