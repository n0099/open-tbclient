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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager asg;
    private IndicatorView ash;
    private int asi;
    private b asj;
    private int ask;
    private c asl;
    private final AdapterView.OnItemClickListener yR;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asi = 0;
        this.ask = 0;
        this.yR = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.asi = 0;
        this.ask = 0;
        this.yR = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.common_tab_content, (ViewGroup) this, true);
        this.asg = (ViewPager) findViewById(t.g.privilege_tab_viewpager);
        this.asg.setFadingEdgeLength(0);
        this.asg.setOnPageChangeListener(this);
        this.ash = (IndicatorView) findViewById(t.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.asg.getChildCount() > 0 && this.asi == count) {
                for (int i2 = 0; i2 < this.asg.getChildCount(); i2++) {
                    View childAt = this.asg.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.asg.setAdapter(null);
            this.asi = count;
            int Cp = bVar.Cp();
            int row = bVar.getRow();
            if (count != 0 && Cp != 0 && row != 0) {
                this.ask = row * Cp;
                int i3 = count / this.ask;
                int i4 = count % this.ask == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.ash.setVisibility(0);
                    this.ash.setCount(i4);
                    this.ash.setPosition(0.0f);
                } else {
                    this.ash.setVisibility(4);
                }
                this.asl = bVar.Cs();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.Cq() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(bVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(bVar.getHorizontalSpacing());
                        if (bVar.getPaddingLeft() != 0 || bVar.getPaddingRight() != 0) {
                            gridView2.setPadding(bVar.getPaddingLeft(), 0, bVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(t.d.transparent);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.Cq(), (ViewGroup) null);
                    }
                    if (this.asl != null) {
                        gridView.setOnItemClickListener(this.yR);
                    }
                    gridView.setNumColumns(Cp);
                    if (i5 < i4 - 1) {
                        i = this.ask;
                    } else {
                        i = count - (this.ask * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.ask, bVar.Co()));
                    arrayList.add(gridView);
                }
                this.asj = new b(arrayList);
                this.asg.setAdapter(this.asj);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ash != null) {
            this.ash.setPosition(i + f);
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
            if (i3 < this.asg.getChildCount()) {
                View childAt = this.asg.getChildAt(i3);
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
        if (bVar != null && this.asg != null) {
            this.asg.setCurrentItem(i / (bVar.Cp() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.asg;
    }

    public IndicatorView getIndicatorView() {
        return this.ash;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int asn;
        private b.a aso;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.asn = i2;
            this.aso = aVar;
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
            return this.aso.getView(this.asn + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> asp;

        public b(ArrayList<View> arrayList) {
            this.asp = new ArrayList<>();
            this.asp = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.asp.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.asp.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.asp.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int K(View view) {
            if (this.asp == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.asp.size()) {
                    return -1;
                }
                if (this.asp.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
