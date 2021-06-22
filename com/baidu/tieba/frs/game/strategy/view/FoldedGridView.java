package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
import d.a.o0.r0.s1.a.e.e;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements e, AdapterView.OnItemClickListener {
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);

    /* renamed from: e  reason: collision with root package name */
    public View f15570e;

    /* renamed from: f  reason: collision with root package name */
    public int f15571f;

    /* renamed from: g  reason: collision with root package name */
    public int f15572g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15573h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.r0.s1.a.e.a f15574i;
    public a j;
    public int k;
    public Drawable l;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15571f = 0;
        this.f15572g = 0;
        this.f15573h = true;
        this.k = 0;
        c();
    }

    @Override // d.a.o0.r0.s1.a.e.e
    public void a(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() <= 0 || !(frameLayout.getChildAt(0) instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
            if (this.f15573h) {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f15571f));
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f15572g));
            }
        }
    }

    @Override // d.a.o0.r0.s1.a.e.e
    public boolean b() {
        return getNumColumns() > 0;
    }

    public final void c() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void d(int i2) {
        View view = this.f15570e;
        if (view != null) {
            a(view);
        }
        int i3 = this.k;
        if (i3 != 0) {
            this.l = SkinManager.getDrawable(i2, i3);
        }
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (this.f15573h || (drawable = this.l) == null) {
            return;
        }
        drawable.setBounds(0, (height - m) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
        this.l.draw(canvas);
    }

    public final void e() {
        this.f15573h = !this.f15573h;
        a(this.f15570e);
        d.a.o0.r0.s1.a.e.a aVar = this.f15574i;
        if (aVar != null) {
            aVar.k(this.f15573h);
            this.f15574i.notifyDataSetChanged();
            invalidate();
        }
    }

    @Override // d.a.o0.r0.s1.a.e.e
    public int getArrowIndex() {
        if (b()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    @Override // d.a.o0.r0.s1.a.e.e
    public View getArrowView() {
        if (this.f15570e == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.f15570e = frameLayout;
        }
        return this.f15570e;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        d.a.o0.r0.s1.a.e.a aVar;
        if (view == this.f15570e) {
            d.a.o0.r0.s1.a.e.a aVar2 = this.f15574i;
            if (aVar2 == null || !aVar2.h()) {
                return;
            }
            e();
        } else if (this.j == null || (aVar = this.f15574i) == null) {
        } else {
            int f2 = aVar.f(i2);
            this.f15574i.j(f2);
            this.j.a(f2, this.f15574i.getItem(i2));
        }
    }

    public void setArrowResouceId(int i2, int i3) {
        this.f15571f = i2;
        this.f15572g = i3;
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i2) {
        this.k = i2;
        if (i2 == 0) {
            this.l = SkinManager.getDrawable(i2);
        } else {
            this.l = null;
        }
    }

    public void setFoldAdapter(d.a.o0.r0.s1.a.e.a aVar) {
        this.f15574i = aVar;
        if (aVar != null) {
            aVar.i(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.j = aVar;
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15571f = 0;
        this.f15572g = 0;
        this.f15573h = true;
        this.k = 0;
        c();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.f15571f = 0;
        this.f15572g = 0;
        this.f15573h = true;
        this.k = 0;
        c();
    }
}
