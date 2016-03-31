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
    private final AdapterView.OnItemClickListener Iy;
    private ViewPager aim;
    private IndicatorView ain;
    private int awh;
    private b awi;
    private int awj;
    private c awk;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awh = 0;
        this.awj = 0;
        this.Iy = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.awh = 0;
        this.awj = 0;
        this.Iy = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(t.h.common_tab_content, (ViewGroup) this, true);
        this.aim = (ViewPager) findViewById(t.g.privilege_tab_viewpager);
        this.aim.setFadingEdgeLength(0);
        this.aim.setOnPageChangeListener(this);
        this.ain = (IndicatorView) findViewById(t.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.aim.getChildCount() > 0 && this.awh == count) {
                for (int i2 = 0; i2 < this.aim.getChildCount(); i2++) {
                    View childAt = this.aim.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aim.setAdapter(null);
            this.awh = count;
            int Ev = bVar.Ev();
            int row = bVar.getRow();
            if (count != 0 && Ev != 0 && row != 0) {
                this.awj = row * Ev;
                int i3 = count / this.awj;
                int i4 = count % this.awj == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.ain.setVisibility(0);
                    this.ain.setCount(i4);
                    this.ain.setPosition(0.0f);
                } else {
                    this.ain.setVisibility(4);
                }
                this.awk = bVar.Ey();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.Ew() == 0) {
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
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.Ew(), (ViewGroup) null);
                    }
                    if (this.awk != null) {
                        gridView.setOnItemClickListener(this.Iy);
                    }
                    gridView.setNumColumns(Ev);
                    if (i5 < i4 - 1) {
                        i = this.awj;
                    } else {
                        i = count - (this.awj * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.awj, bVar.Eu()));
                    arrayList.add(gridView);
                }
                this.awi = new b(arrayList);
                this.aim.setAdapter(this.awi);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ain != null) {
            this.ain.setPosition(i + f);
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
            if (i3 < this.aim.getChildCount()) {
                View childAt = this.aim.getChildAt(i3);
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
        if (bVar != null && this.aim != null) {
            this.aim.setCurrentItem(i / (bVar.Ev() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.aim;
    }

    public IndicatorView getIndicatorView() {
        return this.ain;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int awm;
        private b.a awn;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.awm = i2;
            this.awn = aVar;
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
            return this.awn.getView(this.awm + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> awo;

        public b(ArrayList<View> arrayList) {
            this.awo = new ArrayList<>();
            this.awo = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.awo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.awo.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.awo.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int J(View view) {
            if (this.awo == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.awo.size()) {
                    return -1;
                }
                if (this.awo.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
