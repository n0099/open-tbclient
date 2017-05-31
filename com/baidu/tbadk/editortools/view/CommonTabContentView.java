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
import com.baidu.tbadk.editortools.view.b;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private IndicatorView aBn;
    private int aBo;
    private b aBp;
    private int aBq;
    private c aBr;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBo = 0;
        this.aBq = 0;
        this.mOnItemClickListener = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aBo = 0;
        this.aBq = 0;
        this.mOnItemClickListener = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(w.j.common_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(w.h.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.aBn = (IndicatorView) findViewById(w.h.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.mViewPager.getChildCount() > 0 && this.aBo == count) {
                for (int i2 = 0; i2 < this.mViewPager.getChildCount(); i2++) {
                    View childAt = this.mViewPager.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.mViewPager.setAdapter(null);
            this.aBo = count;
            int Do = bVar.Do();
            int row = bVar.getRow();
            if (count != 0 && Do != 0 && row != 0) {
                this.aBq = row * Do;
                int i3 = count / this.aBq;
                int i4 = count % this.aBq == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aBn.setVisibility(0);
                    this.aBn.setCount(i4);
                    this.aBn.setPosition(0.0f);
                } else {
                    this.aBn.setVisibility(4);
                }
                this.aBr = bVar.Dr();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.Dp() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(bVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(bVar.getHorizontalSpacing());
                        if (bVar.getPaddingLeft() != 0 || bVar.getPaddingRight() != 0) {
                            gridView2.setPadding(bVar.getPaddingLeft(), 0, bVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(w.e.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.Dp(), (ViewGroup) null);
                    }
                    if (this.aBr != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Do);
                    if (i5 < i4 - 1) {
                        i = this.aBq;
                    } else {
                        i = count - (this.aBq * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aBq, bVar.Dn()));
                    arrayList.add(gridView);
                }
                this.aBp = new b(arrayList);
                this.mViewPager.setAdapter(this.aBp);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aBn != null) {
            this.aBn.setPosition(i + f);
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

    public void a(int i, com.baidu.tbadk.editortools.view.b bVar) {
        if (bVar != null && this.mViewPager != null) {
            this.mViewPager.setCurrentItem(i / (bVar.Do() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public IndicatorView getIndicatorView() {
        return this.aBn;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aBt;
        private b.a aBu;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.aBt = i2;
            this.aBu = aVar;
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
            return this.aBu.getView(this.aBt + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aBv;

        public b(ArrayList<View> arrayList) {
            this.aBv = new ArrayList<>();
            this.aBv = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aBv.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aBv.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aBv.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int G(View view) {
            if (this.aBv == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aBv.size()) {
                    return -1;
                }
                if (this.aBv.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
