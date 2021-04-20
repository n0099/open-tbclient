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
import d.b.h0.w.y.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f13565e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f13566f;

    /* renamed from: g  reason: collision with root package name */
    public int f13567g;

    /* renamed from: h  reason: collision with root package name */
    public CommonViewPagerAdapter f13568h;
    public int i;
    public final AdapterView.OnItemClickListener j;
    public c k;

    /* loaded from: classes3.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f13569a;

        public CommonViewPagerAdapter(ArrayList<View> arrayList) {
            this.f13569a = new ArrayList<>();
            this.f13569a = arrayList;
        }

        public int a(View view) {
            if (this.f13569a == null) {
                return -1;
            }
            for (int i = 0; i < this.f13569a.size(); i++) {
                if (this.f13569a.get(i) == view) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.f13569a.get(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f13569a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.f13569a.get(i);
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (CommonTabContentView.this.k == null || CommonTabContentView.this.f13568h == null) {
                return;
            }
            if (CommonTabContentView.this.f13568h.a(adapterView) != 0) {
                i = -1;
            }
            CommonTabContentView.this.k.a(view, i, j);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final int f13572e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13573f;

        /* renamed from: g  reason: collision with root package name */
        public a.InterfaceC1125a f13574g;

        public b(Context context, int i, int i2, a.InterfaceC1125a interfaceC1125a) {
            this.f13572e = i;
            this.f13573f = i2;
            this.f13574g = interfaceC1125a;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f13572e;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return this.f13574g.getView(this.f13573f + i, view, viewGroup);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13567g = 0;
        this.i = 0;
        this.j = new a();
        c(context);
    }

    public final void c(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.common_tab_content, (ViewGroup) this, true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.privilege_tab_viewpager);
        this.f13565e = viewPager;
        viewPager.setFadingEdgeLength(0);
        this.f13565e.setOnPageChangeListener(this);
        this.f13566f = (IndicatorView) findViewById(R.id.privilege_tab_indicator);
    }

    public void d(int i) {
        for (int i2 = 0; i2 < this.f13565e.getChildCount(); i2++) {
            View childAt = this.f13565e.getChildAt(i2);
            if (childAt instanceof GridView) {
                ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public void e(d.b.h0.w.y.a aVar) {
        GridView gridView;
        int i;
        if (aVar == null) {
            return;
        }
        int f2 = aVar.f();
        if (this.f13565e.getChildCount() > 0 && this.f13567g == f2) {
            for (int i2 = 0; i2 < this.f13565e.getChildCount(); i2++) {
                View childAt = this.f13565e.getChildAt(i2);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
            return;
        }
        this.f13565e.setAdapter(null);
        this.f13567g = f2;
        int c2 = aVar.c();
        int n = aVar.n();
        if (f2 == 0 || c2 == 0 || n == 0) {
            return;
        }
        int i3 = n * c2;
        this.i = i3;
        int i4 = f2 / i3;
        if (f2 % i3 != 0) {
            i4++;
        }
        int i5 = i4;
        if (i5 > 1) {
            this.f13566f.setVisibility(0);
            this.f13566f.setCount(i5);
            this.f13566f.setPosition(0.0f);
        } else {
            this.f13566f.setVisibility(4);
        }
        this.k = aVar.j();
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < i5; i6++) {
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
            int i7 = i5 - 1;
            if (i6 < i7) {
                i = this.i;
            } else {
                i = f2 - (this.i * i7);
            }
            gridView2.setAdapter((ListAdapter) new b(getContext(), i, i6 * this.i, aVar.p()));
            arrayList.add(gridView2);
        }
        CommonViewPagerAdapter commonViewPagerAdapter = new CommonViewPagerAdapter(arrayList);
        this.f13568h = commonViewPagerAdapter;
        this.f13565e.setAdapter(commonViewPagerAdapter);
    }

    public IndicatorView getIndicatorView() {
        return this.f13566f;
    }

    public ViewPager getViewPager() {
        return this.f13565e;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        IndicatorView indicatorView = this.f13566f;
        if (indicatorView != null) {
            indicatorView.setPosition(i + f2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.f13567g = 0;
        this.i = 0;
        this.j = new a();
        c(context);
    }
}
