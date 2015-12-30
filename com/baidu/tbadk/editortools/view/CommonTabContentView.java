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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private IndicatorView ahm;
    private int auO;
    private ViewPager mViewPager;

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auO = 0;
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.auO = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(n.h.common_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(n.g.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.ahm = (IndicatorView) findViewById(n.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        int i;
        int i2 = 0;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.mViewPager.getChildCount() <= 0 || this.auO != count) {
                this.mViewPager.setAdapter(null);
                this.auO = count;
                int Cv = aVar.Cv();
                int row = aVar.getRow();
                if (count != 0 && Cv != 0 && row != 0) {
                    int i3 = count / (Cv * row);
                    int i4 = count % (Cv * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.ahm.setVisibility(0);
                        this.ahm.setCount(i4);
                        this.ahm.setPosition(0.0f);
                    } else {
                        this.ahm.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(Cv);
                        gridView.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        gridView.setSelector(n.d.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = Cv * row;
                        } else {
                            i = count - ((Cv * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * Cv * row, aVar.Cu()));
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
        if (this.ahm != null) {
            this.ahm.setPosition(i + f);
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
        private final int auP;
        private a.InterfaceC0049a auQ;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0049a interfaceC0049a) {
            this.count = i;
            this.auP = i2;
            this.auQ = interfaceC0049a;
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
            return this.auQ.getView(this.auP + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> auS;

        public b(ArrayList<View> arrayList) {
            this.auS = new ArrayList<>();
            this.auS = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.auS.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.auS.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.auS.get(i);
            viewGroup.addView(view);
            return view;
        }
    }
}
