package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private IndicatorView aDb;
    private int aDc;
    private b aDd;
    private int aDe;
    private c aDf;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDc = 0;
        this.aDe = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aDf != null && CommonTabContentView.this.aDd != null) {
                    if (CommonTabContentView.this.aDd.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aDf.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aDc = 0;
        this.aDe = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aDf != null && CommonTabContentView.this.aDd != null) {
                    if (CommonTabContentView.this.aDd.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aDf.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.j.common_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(d.h.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.aDb = (IndicatorView) findViewById(d.h.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.mViewPager.getChildCount() > 0 && this.aDc == count) {
                for (int i2 = 0; i2 < this.mViewPager.getChildCount(); i2++) {
                    View childAt = this.mViewPager.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.mViewPager.setAdapter(null);
            this.aDc = count;
            int Dx = aVar.Dx();
            int row = aVar.getRow();
            if (count != 0 && Dx != 0 && row != 0) {
                this.aDe = row * Dx;
                int i3 = count / this.aDe;
                int i4 = count % this.aDe == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aDb.setVisibility(0);
                    this.aDb.setCount(i4);
                    this.aDb.setPosition(0.0f);
                } else {
                    this.aDb.setVisibility(4);
                }
                this.aDf = aVar.DA();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.Dy() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(d.e.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.Dy(), (ViewGroup) null);
                    }
                    if (this.aDf != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Dx);
                    if (i5 < i4 - 1) {
                        i = this.aDe;
                    } else {
                        i = count - (this.aDe * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aDe, aVar.Dw()));
                    arrayList.add(gridView);
                }
                this.aDd = new b(arrayList);
                this.mViewPager.setAdapter(this.aDd);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aDb != null) {
            this.aDb.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mViewPager.getChildCount()) {
                View childAt = this.mViewPager.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public IndicatorView getIndicatorView() {
        return this.aDb;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aDh;
        private a.InterfaceC0056a aDi;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0056a interfaceC0056a) {
            this.count = i;
            this.aDh = i2;
            this.aDi = interfaceC0056a;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.count;
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
            return this.aDi.getView(this.aDh + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aDj;

        public b(ArrayList<View> arrayList) {
            this.aDj = new ArrayList<>();
            this.aDj = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aDj.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aDj.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aDj.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int N(View view) {
            if (this.aDj == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aDj.size()) {
                    return -1;
                }
                if (this.aDj.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
