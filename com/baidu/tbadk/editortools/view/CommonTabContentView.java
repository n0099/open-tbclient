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
    private ViewPager aEt;
    private IndicatorView aEu;
    private int aEv;
    private b aEw;
    private int aEx;
    private c aEy;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEv = 0;
        this.aEx = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aEy != null && CommonTabContentView.this.aEw != null) {
                    if (CommonTabContentView.this.aEw.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aEy.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aEv = 0;
        this.aEx = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aEy != null && CommonTabContentView.this.aEw != null) {
                    if (CommonTabContentView.this.aEw.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aEy.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.aEt = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.aEt.setFadingEdgeLength(0);
        this.aEt.setOnPageChangeListener(this);
        this.aEu = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.aEt.getChildCount() > 0 && this.aEv == count) {
                for (int i2 = 0; i2 < this.aEt.getChildCount(); i2++) {
                    View childAt = this.aEt.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aEt.setAdapter(null);
            this.aEv = count;
            int Eg = aVar.Eg();
            int row = aVar.getRow();
            if (count != 0 && Eg != 0 && row != 0) {
                this.aEx = row * Eg;
                int i3 = count / this.aEx;
                int i4 = count % this.aEx == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aEu.setVisibility(0);
                    this.aEu.setCount(i4);
                    this.aEu.setPosition(0.0f);
                } else {
                    this.aEu.setVisibility(4);
                }
                this.aEy = aVar.Ej();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.Eh() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(d.C0082d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.Eh(), (ViewGroup) null);
                    }
                    if (this.aEy != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Eg);
                    if (i5 < i4 - 1) {
                        i = this.aEx;
                    } else {
                        i = count - (this.aEx * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aEx, aVar.Ef()));
                    arrayList.add(gridView);
                }
                this.aEw = new b(arrayList);
                this.aEt.setAdapter(this.aEw);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEu != null) {
            this.aEu.setPosition(i + f);
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
            if (i3 < this.aEt.getChildCount()) {
                View childAt = this.aEt.getChildAt(i3);
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
        return this.aEt;
    }

    public IndicatorView getIndicatorView() {
        return this.aEu;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aEA;
        private a.InterfaceC0056a aEB;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0056a interfaceC0056a) {
            this.count = i;
            this.aEA = i2;
            this.aEB = interfaceC0056a;
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
            return this.aEB.getView(this.aEA + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aEC;

        public b(ArrayList<View> arrayList) {
            this.aEC = new ArrayList<>();
            this.aEC = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aEC.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aEC.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aEC.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int N(View view) {
            if (this.aEC == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aEC.size()) {
                    return -1;
                }
                if (this.aEC.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
