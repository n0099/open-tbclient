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
    private int aEA;
    private b aEB;
    private int aEC;
    private c aED;
    private ViewPager aEy;
    private IndicatorView aEz;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEA = 0;
        this.aEC = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aED != null && CommonTabContentView.this.aEB != null) {
                    if (CommonTabContentView.this.aEB.O(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aED.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aEA = 0;
        this.aEC = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aED != null && CommonTabContentView.this.aEB != null) {
                    if (CommonTabContentView.this.aEB.O(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aED.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.aEy = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.aEy.setFadingEdgeLength(0);
        this.aEy.setOnPageChangeListener(this);
        this.aEz = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.aEy.getChildCount() > 0 && this.aEA == count) {
                for (int i2 = 0; i2 < this.aEy.getChildCount(); i2++) {
                    View childAt = this.aEy.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aEy.setAdapter(null);
            this.aEA = count;
            int Eh = aVar.Eh();
            int row = aVar.getRow();
            if (count != 0 && Eh != 0 && row != 0) {
                this.aEC = row * Eh;
                int i3 = count / this.aEC;
                int i4 = count % this.aEC == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aEz.setVisibility(0);
                    this.aEz.setCount(i4);
                    this.aEz.setPosition(0.0f);
                } else {
                    this.aEz.setVisibility(4);
                }
                this.aED = aVar.Ek();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.Ei() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(d.C0096d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.Ei(), (ViewGroup) null);
                    }
                    if (this.aED != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Eh);
                    if (i5 < i4 - 1) {
                        i = this.aEC;
                    } else {
                        i = count - (this.aEC * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aEC, aVar.Eg()));
                    arrayList.add(gridView);
                }
                this.aEB = new b(arrayList);
                this.aEy.setAdapter(this.aEB);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEz != null) {
            this.aEz.setPosition(i + f);
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
            if (i3 < this.aEy.getChildCount()) {
                View childAt = this.aEy.getChildAt(i3);
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
        return this.aEy;
    }

    public IndicatorView getIndicatorView() {
        return this.aEz;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aEF;
        private a.InterfaceC0070a aEG;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0070a interfaceC0070a) {
            this.count = i;
            this.aEF = i2;
            this.aEG = interfaceC0070a;
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
            return this.aEG.getView(this.aEF + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aEH;

        public b(ArrayList<View> arrayList) {
            this.aEH = new ArrayList<>();
            this.aEH = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aEH.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aEH.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aEH.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int O(View view) {
            if (this.aEH == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aEH.size()) {
                    return -1;
                }
                if (this.aEH.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
