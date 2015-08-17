package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private IndicatorView apo;
    private int asu;
    private ViewPager mViewPager;

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asu = 0;
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.asu = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(i.g.common_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(i.f.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.apo = (IndicatorView) findViewById(i.f.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        int i;
        int i2 = 0;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.mViewPager.getChildCount() <= 0 || this.asu != count) {
                this.mViewPager.setAdapter(null);
                this.asu = count;
                int BO = aVar.BO();
                int row = aVar.getRow();
                if (count != 0 && BO != 0 && row != 0) {
                    int i3 = count / (BO * row);
                    int i4 = count % (BO * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.apo.setVisibility(0);
                        this.apo.setCount(i4);
                        this.apo.setPosition(0.0f);
                    } else {
                        this.apo.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(BO);
                        gridView.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        gridView.setSelector(i.c.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = BO * row;
                        } else {
                            i = count - ((BO * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * BO * row, aVar.BN()));
                        arrayList.add(gridView);
                    }
                    this.mViewPager.setAdapter(new b(arrayList));
                    return;
                }
                return;
            }
            while (true) {
                int i6 = i2;
                if (i6 < this.mViewPager.getChildCount()) {
                    View childAt = this.mViewPager.getChildAt(i6);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                    i2 = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.apo != null) {
            this.apo.setPosition(i + f);
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

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int asv;
        private a.InterfaceC0048a asw;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0048a interfaceC0048a) {
            this.count = i;
            this.asv = i2;
            this.asw = interfaceC0048a;
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
            return this.asw.getView(this.asv + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> asy;

        public b(ArrayList<View> arrayList) {
            this.asy = new ArrayList<>();
            this.asy = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.asy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.asy.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.asy.get(i);
            viewGroup.addView(view);
            return view;
        }
    }
}
