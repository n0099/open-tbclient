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
    private IndicatorView aEH;
    private int aEI;
    private b aEJ;
    private int aEK;
    private c aEL;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEI = 0;
        this.aEK = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aEL != null && CommonTabContentView.this.aEJ != null) {
                    if (CommonTabContentView.this.aEJ.H(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aEL.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aEI = 0;
        this.aEK = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aEL != null && CommonTabContentView.this.aEJ != null) {
                    if (CommonTabContentView.this.aEJ.H(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aEL.a(view, i, j);
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
        this.aEH = (IndicatorView) findViewById(d.h.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.mViewPager.getChildCount() > 0 && this.aEI == count) {
                for (int i2 = 0; i2 < this.mViewPager.getChildCount(); i2++) {
                    View childAt = this.mViewPager.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.mViewPager.setAdapter(null);
            this.aEI = count;
            int Ec = aVar.Ec();
            int row = aVar.getRow();
            if (count != 0 && Ec != 0 && row != 0) {
                this.aEK = row * Ec;
                int i3 = count / this.aEK;
                int i4 = count % this.aEK == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aEH.setVisibility(0);
                    this.aEH.setCount(i4);
                    this.aEH.setPosition(0.0f);
                } else {
                    this.aEH.setVisibility(4);
                }
                this.aEL = aVar.Ef();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.Ed() == 0) {
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
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.Ed(), (ViewGroup) null);
                    }
                    if (this.aEL != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Ec);
                    if (i5 < i4 - 1) {
                        i = this.aEK;
                    } else {
                        i = count - (this.aEK * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aEK, aVar.Eb()));
                    arrayList.add(gridView);
                }
                this.aEJ = new b(arrayList);
                this.mViewPager.setAdapter(this.aEJ);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEH != null) {
            this.aEH.setPosition(i + f);
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

    public void a(int i, com.baidu.tbadk.editortools.view.a aVar) {
        if (aVar != null && this.mViewPager != null) {
            this.mViewPager.setCurrentItem(i / (aVar.Ec() * aVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public IndicatorView getIndicatorView() {
        return this.aEH;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aEN;
        private a.InterfaceC0055a aEO;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0055a interfaceC0055a) {
            this.count = i;
            this.aEN = i2;
            this.aEO = interfaceC0055a;
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
            return this.aEO.getView(this.aEN + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aEP;

        public b(ArrayList<View> arrayList) {
            this.aEP = new ArrayList<>();
            this.aEP = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aEP.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aEP.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aEP.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int H(View view) {
            if (this.aEP == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aEP.size()) {
                    return -1;
                }
                if (this.aEP.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
