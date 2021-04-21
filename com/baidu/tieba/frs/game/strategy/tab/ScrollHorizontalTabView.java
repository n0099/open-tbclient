package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollHorizontalTabView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public final List<d.b.j0.q0.s1.a.d.e> f15991e;

    /* renamed from: f  reason: collision with root package name */
    public final List<TextView> f15992f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15993g;

    /* renamed from: h  reason: collision with root package name */
    public final int f15994h;
    public boolean i;
    public int j;
    public int k;
    public float l;
    public int m;
    public int n;
    public LinearLayout o;
    public Paint p;
    public ViewPager q;
    public final e r;
    public f s;
    public View.OnClickListener t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = ScrollHorizontalTabView.this.f15992f.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (view == ScrollHorizontalTabView.this.f15992f.get(i2)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            ScrollHorizontalTabView.this.i = true;
            if (ScrollHorizontalTabView.this.q != null) {
                ScrollHorizontalTabView.this.q.setCurrentItem(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ScrollHorizontalTabView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
            scrollHorizontalTabView.j = scrollHorizontalTabView.q.getCurrentItem();
            ScrollHorizontalTabView scrollHorizontalTabView2 = ScrollHorizontalTabView.this;
            scrollHorizontalTabView2.scrollToChild(scrollHorizontalTabView2.j, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15997e;

        public c(int i) {
            this.f15997e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollHorizontalTabView.this.scrollBy(0 - this.f15997e, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
            scrollHorizontalTabView.scrollBy(scrollHorizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ViewPager.OnPageChangeListener {
        public e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ScrollHorizontalTabView.this.o.getChildCount() == 0 || ScrollHorizontalTabView.this.q == null || i != 0) {
                return;
            }
            ScrollHorizontalTabView.this.l = 0.0f;
            ScrollHorizontalTabView.this.i = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (ScrollHorizontalTabView.this.o.getChildCount() == 0 || ScrollHorizontalTabView.this.i) {
                return;
            }
            if (ScrollHorizontalTabView.this.j != i) {
                int unused = ScrollHorizontalTabView.this.j;
            }
            ScrollHorizontalTabView.this.j = i;
            ScrollHorizontalTabView.this.l = f2;
            ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
            scrollHorizontalTabView.scrollToChild(i, (int) (f2 * scrollHorizontalTabView.o.getChildAt(i).getWidth()));
            ScrollHorizontalTabView.this.updateTabStyles();
            ScrollHorizontalTabView.this.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            d.b.j0.q0.s1.a.d.e eVar = (d.b.j0.q0.s1.a.d.e) ListUtils.getItem(ScrollHorizontalTabView.this.f15991e, i);
            if (ScrollHorizontalTabView.this.s == null || ScrollHorizontalTabView.this.s.b(i, eVar)) {
                if (ScrollHorizontalTabView.this.s != null) {
                    ScrollHorizontalTabView.this.s.a(i, eVar);
                }
                if (ScrollHorizontalTabView.this.i) {
                    if (ScrollHorizontalTabView.this.j != i) {
                        int unused = ScrollHorizontalTabView.this.j;
                    }
                    ScrollHorizontalTabView.this.j = i;
                    ScrollHorizontalTabView scrollHorizontalTabView = ScrollHorizontalTabView.this;
                    scrollHorizontalTabView.scrollToChild(i, (int) (scrollHorizontalTabView.l * ScrollHorizontalTabView.this.o.getChildAt(i).getWidth()));
                    ScrollHorizontalTabView.this.updateTabStyles();
                    ScrollHorizontalTabView.this.invalidate();
                }
            }
        }

        public /* synthetic */ e(ScrollHorizontalTabView scrollHorizontalTabView, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i, d.b.j0.q0.s1.a.d.e eVar);

        boolean b(int i, d.b.j0.q0.s1.a.d.e eVar);
    }

    public ScrollHorizontalTabView(Context context) {
        super(context);
        this.f15991e = new ArrayList();
        this.f15992f = new ArrayList();
        this.f15993g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f15994h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        this.i = false;
        this.j = 0;
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        this.l = 0.0f;
        this.m = 52;
        this.n = 0;
        this.r = new e(this, null);
        this.t = new a();
        init();
    }

    public final void fillTabData() {
        int size = this.f15991e.size();
        int size2 = this.f15992f.size();
        for (int i = 0; i < size && i < size2; i++) {
            d.b.j0.q0.s1.a.d.e eVar = this.f15991e.get(i);
            TextView textView = this.f15992f.get(i);
            if (eVar != null && textView != null) {
                textView.setText(eVar.f60643b);
            }
        }
    }

    public int getCurrentIndex() {
        return this.j;
    }

    public final void init() {
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.o = linearLayout;
        linearLayout.setGravity(16);
        this.o.setOrientation(0);
        this.o.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.o);
        Paint paint = new Paint();
        this.p = paint;
        paint.setAntiAlias(true);
        this.p.setStyle(Paint.Style.FILL);
        this.m = (int) TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics());
    }

    public void onChangeSkinType(int i) {
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        updateTabStyles();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.f15992f.isEmpty()) {
            return;
        }
        int height = getHeight();
        this.p.setColor(this.k);
        View childAt = this.o.getChildAt(this.j);
        int width = (childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight();
        int left = this.o.getLeft() + childAt.getLeft() + childAt.getPaddingLeft();
        int i = this.f15994h;
        float f2 = left + ((width - i) / 2);
        float f3 = i + f2;
        if (this.l > 0.0f && this.j < this.o.getChildCount() - 1) {
            View childAt2 = this.o.getChildAt(this.j + 1);
            int width2 = (childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft();
            int left2 = childAt2.getLeft() + childAt2.getPaddingLeft() + this.o.getLeft();
            int i2 = this.f15994h;
            float f4 = left2 + ((width2 - i2) / 2);
            float f5 = this.l;
            f2 = (f4 * f5) + ((1.0f - f5) * f2);
            f3 = ((i2 + f4) * f5) + ((1.0f - f5) * f3);
        }
        canvas.drawRect(f2, height - this.f15993g, f3, height, this.p);
    }

    public final void scrollToChild(int i, int i2) {
        if (this.f15992f.isEmpty()) {
            return;
        }
        int left = this.f15992f.get(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.m;
        }
        if (left != this.n) {
            this.n = left;
            scrollTo(left, 0);
        }
    }

    public void setCurrentIndex(int i) {
        setCurrentIndex(i, true);
    }

    public void setData(List<d.b.j0.q0.s1.a.d.e> list) {
        this.f15991e.clear();
        if (!ListUtils.isEmpty(list)) {
            this.f15991e.addAll(list);
        }
        setupTabItems();
        fillTabData();
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public void setScrollTabPageListener(f fVar) {
        this.s = fVar;
    }

    public final void setTabStatus(TextView textView, boolean z) {
        if (textView == null) {
            return;
        }
        if (z) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.q = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.r);
    }

    public final void setupTabItems() {
        int size = this.f15991e.size();
        int size2 = this.f15992f.size();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds4);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
        if (size > size2) {
            while (size2 < size) {
                TextView textView = new TextView(getContext());
                textView.setOnClickListener(this.t);
                textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
                textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                textView.setGravity(17);
                this.f15992f.add(textView);
                size2++;
            }
        } else if (size < size2) {
            for (int i = size2 - 1; i >= size; i--) {
                this.f15992f.remove(i);
            }
        }
        this.o.removeAllViews();
        int size3 = this.f15992f.size();
        for (int i2 = 0; i2 < size3; i2++) {
            this.o.addView(this.f15992f.get(i2));
        }
    }

    public final void updateTabStyles() {
        int size = this.f15992f.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.f15992f.get(i);
            if (textView instanceof TextView) {
                TextView textView2 = textView;
                if (i == this.j) {
                    setTabStatus(textView2, true);
                } else {
                    setTabStatus(textView2, false);
                }
            }
        }
    }

    public void setCurrentIndex(int i, boolean z) {
        if (z) {
            int[] iArr = new int[2];
            ((View) ListUtils.getItem(this.f15992f, i)).getLocationOnScreen(iArr);
            int k = l.k(getContext()) - iArr[0];
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
            if (iArr[0] < 0) {
                post(new c(dimensionPixelSize));
            } else if (k < dimensionPixelSize) {
                post(new d());
            }
        }
        ViewPager viewPager = this.q;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
        updateTabStyles();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15991e = new ArrayList();
        this.f15992f = new ArrayList();
        this.f15993g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f15994h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        this.i = false;
        this.j = 0;
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        this.l = 0.0f;
        this.m = 52;
        this.n = 0;
        this.r = new e(this, null);
        this.t = new a();
        init();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15991e = new ArrayList();
        this.f15992f = new ArrayList();
        this.f15993g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f15994h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        this.i = false;
        this.j = 0;
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        this.l = 0.0f;
        this.m = 52;
        this.n = 0;
        this.r = new e(this, null);
        this.t = new a();
        init();
    }
}
