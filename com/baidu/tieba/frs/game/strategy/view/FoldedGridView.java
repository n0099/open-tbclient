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
import d.b.i0.q0.s1.a.e.e;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements e, AdapterView.OnItemClickListener {
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);

    /* renamed from: e  reason: collision with root package name */
    public View f16001e;

    /* renamed from: f  reason: collision with root package name */
    public int f16002f;

    /* renamed from: g  reason: collision with root package name */
    public int f16003g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16004h;
    public d.b.i0.q0.s1.a.e.a i;
    public a j;
    public int k;
    public Drawable l;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16002f = 0;
        this.f16003g = 0;
        this.f16004h = true;
        this.k = 0;
        c();
    }

    @Override // d.b.i0.q0.s1.a.e.e
    public void a(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() <= 0 || !(frameLayout.getChildAt(0) instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) frameLayout.getChildAt(0);
            if (this.f16004h) {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f16002f));
            } else {
                imageView.setImageDrawable(SkinManager.getDrawable(this.f16003g));
            }
        }
    }

    @Override // d.b.i0.q0.s1.a.e.e
    public boolean b() {
        return getNumColumns() > 0;
    }

    public final void c() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void d(int i) {
        View view = this.f16001e;
        if (view != null) {
            a(view);
        }
        int i2 = this.k;
        if (i2 != 0) {
            this.l = SkinManager.getDrawable(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (this.f16004h || (drawable = this.l) == null) {
            return;
        }
        drawable.setBounds(0, (height - m) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
        this.l.draw(canvas);
    }

    public final void e() {
        this.f16004h = !this.f16004h;
        a(this.f16001e);
        d.b.i0.q0.s1.a.e.a aVar = this.i;
        if (aVar != null) {
            aVar.k(this.f16004h);
            this.i.notifyDataSetChanged();
            invalidate();
        }
    }

    @Override // d.b.i0.q0.s1.a.e.e
    public int getArrowIndex() {
        if (b()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    @Override // d.b.i0.q0.s1.a.e.e
    public View getArrowView() {
        if (this.f16001e == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.f16001e = frameLayout;
        }
        return this.f16001e;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d.b.i0.q0.s1.a.e.a aVar;
        if (view == this.f16001e) {
            d.b.i0.q0.s1.a.e.a aVar2 = this.i;
            if (aVar2 == null || !aVar2.h()) {
                return;
            }
            e();
        } else if (this.j == null || (aVar = this.i) == null) {
        } else {
            int f2 = aVar.f(i);
            this.i.j(f2);
            this.j.a(f2, this.i.getItem(i));
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.f16002f = i;
        this.f16003g = i2;
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.k = i;
        if (i == 0) {
            this.l = SkinManager.getDrawable(i);
        } else {
            this.l = null;
        }
    }

    public void setFoldAdapter(d.b.i0.q0.s1.a.e.a aVar) {
        this.i = aVar;
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
        this.f16002f = 0;
        this.f16003g = 0;
        this.f16004h = true;
        this.k = 0;
        c();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.f16002f = 0;
        this.f16003g = 0;
        this.f16004h = true;
        this.k = 0;
        c();
    }
}
