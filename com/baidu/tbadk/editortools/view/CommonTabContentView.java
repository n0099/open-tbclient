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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager asW;
    private IndicatorView asX;
    private int asY;
    private b asZ;
    private int ata;
    private c atb;
    private final AdapterView.OnItemClickListener yQ;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asY = 0;
        this.ata = 0;
        this.yQ = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.asY = 0;
        this.ata = 0;
        this.yQ = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(u.h.common_tab_content, (ViewGroup) this, true);
        this.asW = (ViewPager) findViewById(u.g.privilege_tab_viewpager);
        this.asW.setFadingEdgeLength(0);
        this.asW.setOnPageChangeListener(this);
        this.asX = (IndicatorView) findViewById(u.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.asW.getChildCount() > 0 && this.asY == count) {
                for (int i2 = 0; i2 < this.asW.getChildCount(); i2++) {
                    View childAt = this.asW.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.asW.setAdapter(null);
            this.asY = count;
            int Cx = bVar.Cx();
            int row = bVar.getRow();
            if (count != 0 && Cx != 0 && row != 0) {
                this.ata = row * Cx;
                int i3 = count / this.ata;
                int i4 = count % this.ata == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.asX.setVisibility(0);
                    this.asX.setCount(i4);
                    this.asX.setPosition(0.0f);
                } else {
                    this.asX.setVisibility(4);
                }
                this.atb = bVar.CA();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.Cy() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(bVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(bVar.getHorizontalSpacing());
                        if (bVar.getPaddingLeft() != 0 || bVar.getPaddingRight() != 0) {
                            gridView2.setPadding(bVar.getPaddingLeft(), 0, bVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(u.d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.Cy(), (ViewGroup) null);
                    }
                    if (this.atb != null) {
                        gridView.setOnItemClickListener(this.yQ);
                    }
                    gridView.setNumColumns(Cx);
                    if (i5 < i4 - 1) {
                        i = this.ata;
                    } else {
                        i = count - (this.ata * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.ata, bVar.Cw()));
                    arrayList.add(gridView);
                }
                this.asZ = new b(arrayList);
                this.asW.setAdapter(this.asZ);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.asX != null) {
            this.asX.setPosition(i + f);
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
            if (i3 < this.asW.getChildCount()) {
                View childAt = this.asW.getChildAt(i3);
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
        if (bVar != null && this.asW != null) {
            this.asW.setCurrentItem(i / (bVar.Cx() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.asW;
    }

    public IndicatorView getIndicatorView() {
        return this.asX;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int atd;
        private b.a ate;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.atd = i2;
            this.ate = aVar;
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
            return this.ate.getView(this.atd + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> atf;

        public b(ArrayList<View> arrayList) {
            this.atf = new ArrayList<>();
            this.atf = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.atf.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.atf.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.atf.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int J(View view) {
            if (this.atf == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.atf.size()) {
                    return -1;
                }
                if (this.atf.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
