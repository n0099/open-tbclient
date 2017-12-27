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
    private IndicatorView bsv;
    private int bsw;
    private b bsx;
    private int bsy;
    private c bsz;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewPager qW;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsw = 0;
        this.bsy = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.bsz != null && CommonTabContentView.this.bsx != null) {
                    if (CommonTabContentView.this.bsx.bh(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.bsz.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.bsw = 0;
        this.bsy = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.bsz != null && CommonTabContentView.this.bsx != null) {
                    if (CommonTabContentView.this.bsx.bh(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.bsz.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.qW = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.qW.setFadingEdgeLength(0);
        this.qW.setOnPageChangeListener(this);
        this.bsv = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.qW.getChildCount() > 0 && this.bsw == count) {
                for (int i2 = 0; i2 < this.qW.getChildCount(); i2++) {
                    View childAt = this.qW.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.qW.setAdapter(null);
            this.bsw = count;
            int LI = aVar.LI();
            int row = aVar.getRow();
            if (count != 0 && LI != 0 && row != 0) {
                this.bsy = row * LI;
                int i3 = count / this.bsy;
                int i4 = count % this.bsy == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.bsv.setVisibility(0);
                    this.bsv.setCount(i4);
                    this.bsv.setPosition(0.0f);
                } else {
                    this.bsv.setVisibility(4);
                }
                this.bsz = aVar.LL();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.LJ() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(d.C0108d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.LJ(), (ViewGroup) null);
                    }
                    if (this.bsz != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(LI);
                    if (i5 < i4 - 1) {
                        i = this.bsy;
                    } else {
                        i = count - (this.bsy * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.bsy, aVar.LH()));
                    arrayList.add(gridView);
                }
                this.bsx = new b(arrayList);
                this.qW.setAdapter(this.bsx);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.bsv != null) {
            this.bsv.setPosition(i + f);
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
            if (i3 < this.qW.getChildCount()) {
                View childAt = this.qW.getChildAt(i3);
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
        return this.qW;
    }

    public IndicatorView getIndicatorView() {
        return this.bsv;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int bsB;
        private a.InterfaceC0083a bsC;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0083a interfaceC0083a) {
            this.count = i;
            this.bsB = i2;
            this.bsC = interfaceC0083a;
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
            return this.bsC.getView(this.bsB + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> bsD;

        public b(ArrayList<View> arrayList) {
            this.bsD = new ArrayList<>();
            this.bsD = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bsD.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.bsD.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.bsD.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int bh(View view) {
            if (this.bsD == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bsD.size()) {
                    return -1;
                }
                if (this.bsD.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
