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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private final AdapterView.OnItemClickListener BG;
    private c awA;
    private ViewPager awv;
    private IndicatorView aww;
    private int awx;
    private b awy;
    private int awz;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awx = 0;
        this.awz = 0;
        this.BG = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.awx = 0;
        this.awz = 0;
        this.BG = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.h.common_tab_content, (ViewGroup) this, true);
        this.awv = (ViewPager) findViewById(r.g.privilege_tab_viewpager);
        this.awv.setFadingEdgeLength(0);
        this.awv.setOnPageChangeListener(this);
        this.aww = (IndicatorView) findViewById(r.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.awv.getChildCount() > 0 && this.awx == count) {
                for (int i2 = 0; i2 < this.awv.getChildCount(); i2++) {
                    View childAt = this.awv.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.awv.setAdapter(null);
            this.awx = count;
            int DR = bVar.DR();
            int row = bVar.getRow();
            if (count != 0 && DR != 0 && row != 0) {
                this.awz = row * DR;
                int i3 = count / this.awz;
                int i4 = count % this.awz == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aww.setVisibility(0);
                    this.aww.setCount(i4);
                    this.aww.setPosition(0.0f);
                } else {
                    this.aww.setVisibility(4);
                }
                this.awA = bVar.DU();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.DS() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(bVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(bVar.getHorizontalSpacing());
                        if (bVar.getPaddingLeft() != 0 || bVar.getPaddingRight() != 0) {
                            gridView2.setPadding(bVar.getPaddingLeft(), 0, bVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(r.d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.DS(), (ViewGroup) null);
                    }
                    if (this.awA != null) {
                        gridView.setOnItemClickListener(this.BG);
                    }
                    gridView.setNumColumns(DR);
                    if (i5 < i4 - 1) {
                        i = this.awz;
                    } else {
                        i = count - (this.awz * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.awz, bVar.DQ()));
                    arrayList.add(gridView);
                }
                this.awy = new b(arrayList);
                this.awv.setAdapter(this.awy);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aww != null) {
            this.aww.setPosition(i + f);
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
            if (i3 < this.awv.getChildCount()) {
                View childAt = this.awv.getChildAt(i3);
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
        if (bVar != null && this.awv != null) {
            this.awv.setCurrentItem(i / (bVar.DR() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.awv;
    }

    public IndicatorView getIndicatorView() {
        return this.aww;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int awC;
        private b.a awD;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.awC = i2;
            this.awD = aVar;
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
            return this.awD.getView(this.awC + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> awE;

        public b(ArrayList<View> arrayList) {
            this.awE = new ArrayList<>();
            this.awE = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.awE.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.awE.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.awE.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int K(View view) {
            if (this.awE == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.awE.size()) {
                    return -1;
                }
                if (this.awE.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
