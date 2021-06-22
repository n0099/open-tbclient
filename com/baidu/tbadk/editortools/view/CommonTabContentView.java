package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.R;
import d.a.n0.w.y.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f12958e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f12959f;

    /* renamed from: g  reason: collision with root package name */
    public int f12960g;

    /* renamed from: h  reason: collision with root package name */
    public CommonViewPagerAdapter f12961h;

    /* renamed from: i  reason: collision with root package name */
    public int f12962i;
    public final AdapterView.OnItemClickListener j;
    public c k;

    /* loaded from: classes3.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f12963a;

        public CommonViewPagerAdapter(ArrayList<View> arrayList) {
            this.f12963a = new ArrayList<>();
            this.f12963a = arrayList;
        }

        public int a(View view) {
            if (this.f12963a == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f12963a.size(); i2++) {
                if (this.f12963a.get(i2) == view) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.f12963a.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f12963a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view = this.f12963a.get(i2);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (CommonTabContentView.this.k == null || CommonTabContentView.this.f12961h == null) {
                return;
            }
            if (CommonTabContentView.this.f12961h.a(adapterView) != 0) {
                i2 = -1;
            }
            CommonTabContentView.this.k.a(view, i2, j);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final int f12966e;

        /* renamed from: f  reason: collision with root package name */
        public final int f12967f;

        /* renamed from: g  reason: collision with root package name */
        public a.InterfaceC1229a f12968g;

        public b(Context context, int i2, int i3, a.InterfaceC1229a interfaceC1229a) {
            this.f12966e = i2;
            this.f12967f = i3;
            this.f12968g = interfaceC1229a;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f12966e;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            return this.f12968g.getView(this.f12967f + i2, view, viewGroup);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view, int i2, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12960g = 0;
        this.f12962i = 0;
        this.j = new a();
        c(context);
    }

    public final void c(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.common_tab_content, (ViewGroup) this, true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.privilege_tab_viewpager);
        this.f12958e = viewPager;
        viewPager.setFadingEdgeLength(0);
        this.f12958e.setOnPageChangeListener(this);
        this.f12959f = (IndicatorView) findViewById(R.id.privilege_tab_indicator);
    }

    public void d(int i2) {
        for (int i3 = 0; i3 < this.f12958e.getChildCount(); i3++) {
            View childAt = this.f12958e.getChildAt(i3);
            if (childAt instanceof GridView) {
                ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public void e(d.a.n0.w.y.a aVar) {
        GridView gridView;
        int i2;
        if (aVar == null) {
            return;
        }
        int f2 = aVar.f();
        if (this.f12958e.getChildCount() > 0 && this.f12960g == f2) {
            for (int i3 = 0; i3 < this.f12958e.getChildCount(); i3++) {
                View childAt = this.f12958e.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
            return;
        }
        this.f12958e.setAdapter(null);
        this.f12960g = f2;
        int c2 = aVar.c();
        int n = aVar.n();
        if (f2 == 0 || c2 == 0 || n == 0) {
            return;
        }
        int i4 = n * c2;
        this.f12962i = i4;
        int i5 = f2 / i4;
        if (f2 % i4 != 0) {
            i5++;
        }
        int i6 = i5;
        if (i6 > 1) {
            this.f12959f.setVisibility(0);
            this.f12959f.setCount(i6);
            this.f12959f.setPosition(0.0f);
        } else {
            this.f12959f.setVisibility(4);
        }
        this.k = aVar.j();
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < i6; i7++) {
            if (aVar.g() == 0) {
                gridView = new GridView(getContext());
                gridView.setVerticalSpacing(aVar.o());
                gridView.setGravity(17);
                gridView.setHorizontalSpacing(aVar.h());
                if (aVar.l() != 0 || aVar.m() != 0) {
                    gridView.setPadding(aVar.l(), 0, aVar.m(), 0);
                }
                gridView.setSelector(R.color.common_color_10022);
                gridView.setSelection(-1);
            } else {
                gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.g(), (ViewGroup) null);
            }
            GridView gridView2 = gridView;
            if (this.k != null) {
                gridView2.setOnItemClickListener(this.j);
            }
            gridView2.setNumColumns(c2);
            int i8 = i6 - 1;
            if (i7 < i8) {
                i2 = this.f12962i;
            } else {
                i2 = f2 - (this.f12962i * i8);
            }
            gridView2.setAdapter((ListAdapter) new b(getContext(), i2, i7 * this.f12962i, aVar.p()));
            arrayList.add(gridView2);
        }
        CommonViewPagerAdapter commonViewPagerAdapter = new CommonViewPagerAdapter(arrayList);
        this.f12961h = commonViewPagerAdapter;
        this.f12958e.setAdapter(commonViewPagerAdapter);
    }

    public IndicatorView getIndicatorView() {
        return this.f12959f;
    }

    public ViewPager getViewPager() {
        return this.f12958e;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        IndicatorView indicatorView = this.f12959f;
        if (indicatorView != null) {
            indicatorView.setPosition(i2 + f2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.f12960g = 0;
        this.f12962i = 0;
        this.j = new a();
        c(context);
    }
}
