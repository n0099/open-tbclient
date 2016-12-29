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
    private final AdapterView.OnItemClickListener BH;
    private ViewPager aid;
    private IndicatorView aie;
    private int awL;
    private b awM;
    private int awN;
    private c awO;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awL = 0;
        this.awN = 0;
        this.BH = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.awL = 0;
        this.awN = 0;
        this.BH = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.h.common_tab_content, (ViewGroup) this, true);
        this.aid = (ViewPager) findViewById(r.g.privilege_tab_viewpager);
        this.aid.setFadingEdgeLength(0);
        this.aid.setOnPageChangeListener(this);
        this.aie = (IndicatorView) findViewById(r.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.aid.getChildCount() > 0 && this.awL == count) {
                for (int i2 = 0; i2 < this.aid.getChildCount(); i2++) {
                    View childAt = this.aid.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aid.setAdapter(null);
            this.awL = count;
            int DE = bVar.DE();
            int row = bVar.getRow();
            if (count != 0 && DE != 0 && row != 0) {
                this.awN = row * DE;
                int i3 = count / this.awN;
                int i4 = count % this.awN == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aie.setVisibility(0);
                    this.aie.setCount(i4);
                    this.aie.setPosition(0.0f);
                } else {
                    this.aie.setVisibility(4);
                }
                this.awO = bVar.DH();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.DF() == 0) {
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
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.DF(), (ViewGroup) null);
                    }
                    if (this.awO != null) {
                        gridView.setOnItemClickListener(this.BH);
                    }
                    gridView.setNumColumns(DE);
                    if (i5 < i4 - 1) {
                        i = this.awN;
                    } else {
                        i = count - (this.awN * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.awN, bVar.DD()));
                    arrayList.add(gridView);
                }
                this.awM = new b(arrayList);
                this.aid.setAdapter(this.awM);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aie != null) {
            this.aie.setPosition(i + f);
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
            if (i3 < this.aid.getChildCount()) {
                View childAt = this.aid.getChildAt(i3);
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
        if (bVar != null && this.aid != null) {
            this.aid.setCurrentItem(i / (bVar.DE() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.aid;
    }

    public IndicatorView getIndicatorView() {
        return this.aie;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int awQ;
        private b.a awR;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.awQ = i2;
            this.awR = aVar;
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
            return this.awR.getView(this.awQ + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> awS;

        public b(ArrayList<View> arrayList) {
            this.awS = new ArrayList<>();
            this.awS = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.awS.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.awS.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.awS.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int L(View view) {
            if (this.awS == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.awS.size()) {
                    return -1;
                }
                if (this.awS.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
