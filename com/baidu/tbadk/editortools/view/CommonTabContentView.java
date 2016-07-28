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
    private ViewPager atL;
    private IndicatorView atM;
    private int atN;
    private b atO;
    private int atP;
    private c atQ;
    private final AdapterView.OnItemClickListener zr;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atN = 0;
        this.atP = 0;
        this.zr = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.atN = 0;
        this.atP = 0;
        this.zr = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(u.h.common_tab_content, (ViewGroup) this, true);
        this.atL = (ViewPager) findViewById(u.g.privilege_tab_viewpager);
        this.atL.setFadingEdgeLength(0);
        this.atL.setOnPageChangeListener(this);
        this.atM = (IndicatorView) findViewById(u.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.atL.getChildCount() > 0 && this.atN == count) {
                for (int i2 = 0; i2 < this.atL.getChildCount(); i2++) {
                    View childAt = this.atL.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.atL.setAdapter(null);
            this.atN = count;
            int Cw = bVar.Cw();
            int row = bVar.getRow();
            if (count != 0 && Cw != 0 && row != 0) {
                this.atP = row * Cw;
                int i3 = count / this.atP;
                int i4 = count % this.atP == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.atM.setVisibility(0);
                    this.atM.setCount(i4);
                    this.atM.setPosition(0.0f);
                } else {
                    this.atM.setVisibility(4);
                }
                this.atQ = bVar.Cz();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.Cx() == 0) {
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
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.Cx(), (ViewGroup) null);
                    }
                    if (this.atQ != null) {
                        gridView.setOnItemClickListener(this.zr);
                    }
                    gridView.setNumColumns(Cw);
                    if (i5 < i4 - 1) {
                        i = this.atP;
                    } else {
                        i = count - (this.atP * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.atP, bVar.Cv()));
                    arrayList.add(gridView);
                }
                this.atO = new b(arrayList);
                this.atL.setAdapter(this.atO);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.atM != null) {
            this.atM.setPosition(i + f);
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
            if (i3 < this.atL.getChildCount()) {
                View childAt = this.atL.getChildAt(i3);
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
        if (bVar != null && this.atL != null) {
            this.atL.setCurrentItem(i / (bVar.Cw() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.atL;
    }

    public IndicatorView getIndicatorView() {
        return this.atM;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int atS;
        private b.a atT;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.atS = i2;
            this.atT = aVar;
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
            return this.atT.getView(this.atS + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> atU;

        public b(ArrayList<View> arrayList) {
            this.atU = new ArrayList<>();
            this.atU = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.atU.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.atU.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.atU.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int J(View view) {
            if (this.atU == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.atU.size()) {
                    return -1;
                }
                if (this.atU.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
