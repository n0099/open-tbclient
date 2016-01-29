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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager ahW;
    private IndicatorView ahX;
    private int avG;

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avG = 0;
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.avG = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.common_tab_content, (ViewGroup) this, true);
        this.ahW = (ViewPager) findViewById(t.g.privilege_tab_viewpager);
        this.ahW.setFadingEdgeLength(0);
        this.ahW.setOnPageChangeListener(this);
        this.ahX = (IndicatorView) findViewById(t.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        int i;
        int i2 = 0;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.ahW.getChildCount() <= 0 || this.avG != count) {
                this.ahW.setAdapter(null);
                this.avG = count;
                int DL = aVar.DL();
                int row = aVar.getRow();
                if (count != 0 && DL != 0 && row != 0) {
                    int i3 = count / (DL * row);
                    int i4 = count % (DL * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.ahX.setVisibility(0);
                        this.ahX.setCount(i4);
                        this.ahX.setPosition(0.0f);
                    } else {
                        this.ahX.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(DL);
                        gridView.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        gridView.setSelector(t.d.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = DL * row;
                        } else {
                            i = count - ((DL * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * DL * row, aVar.DK()));
                        arrayList.add(gridView);
                    }
                    this.ahW.setAdapter(new b(arrayList));
                    return;
                }
                return;
            }
            while (true) {
                int i6 = i2;
                if (i6 < this.ahW.getChildCount()) {
                    View childAt = this.ahW.getChildAt(i6);
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
        if (this.ahX != null) {
            this.ahX.setPosition(i + f);
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
            if (i3 < this.ahW.getChildCount()) {
                View childAt = this.ahW.getChildAt(i3);
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
        private final int avH;
        private a.InterfaceC0050a avI;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0050a interfaceC0050a) {
            this.count = i;
            this.avH = i2;
            this.avI = interfaceC0050a;
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
            return this.avI.getView(this.avH + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> avK;

        public b(ArrayList<View> arrayList) {
            this.avK = new ArrayList<>();
            this.avK = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.avK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.avK.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.avK.get(i);
            viewGroup.addView(view);
            return view;
        }
    }
}
