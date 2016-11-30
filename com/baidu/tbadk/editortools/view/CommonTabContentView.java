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
    private final AdapterView.OnItemClickListener BG;
    private ViewPager aiC;
    private IndicatorView aiD;
    private int axo;
    private b axp;
    private int axq;
    private c axr;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axo = 0;
        this.axq = 0;
        this.BG = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.axo = 0;
        this.axq = 0;
        this.BG = new com.baidu.tbadk.editortools.view.a(this);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(r.h.common_tab_content, (ViewGroup) this, true);
        this.aiC = (ViewPager) findViewById(r.g.privilege_tab_viewpager);
        this.aiC.setFadingEdgeLength(0);
        this.aiC.setOnPageChangeListener(this);
        this.aiD = (IndicatorView) findViewById(r.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.b bVar) {
        GridView gridView;
        int i;
        if (bVar != null) {
            int count = bVar.getCount();
            if (this.aiC.getChildCount() > 0 && this.axo == count) {
                for (int i2 = 0; i2 < this.aiC.getChildCount(); i2++) {
                    View childAt = this.aiC.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aiC.setAdapter(null);
            this.axo = count;
            int DW = bVar.DW();
            int row = bVar.getRow();
            if (count != 0 && DW != 0 && row != 0) {
                this.axq = row * DW;
                int i3 = count / this.axq;
                int i4 = count % this.axq == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aiD.setVisibility(0);
                    this.aiD.setCount(i4);
                    this.aiD.setPosition(0.0f);
                } else {
                    this.aiD.setVisibility(4);
                }
                this.axr = bVar.DZ();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (bVar.DX() == 0) {
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
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(bVar.DX(), (ViewGroup) null);
                    }
                    if (this.axr != null) {
                        gridView.setOnItemClickListener(this.BG);
                    }
                    gridView.setNumColumns(DW);
                    if (i5 < i4 - 1) {
                        i = this.axq;
                    } else {
                        i = count - (this.axq * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.axq, bVar.DV()));
                    arrayList.add(gridView);
                }
                this.axp = new b(arrayList);
                this.aiC.setAdapter(this.axp);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aiD != null) {
            this.aiD.setPosition(i + f);
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
            if (i3 < this.aiC.getChildCount()) {
                View childAt = this.aiC.getChildAt(i3);
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
        if (bVar != null && this.aiC != null) {
            this.aiC.setCurrentItem(i / (bVar.DW() * bVar.getRow()));
        }
    }

    public ViewPager getViewPager() {
        return this.aiC;
    }

    public IndicatorView getIndicatorView() {
        return this.aiD;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int axt;
        private b.a axu;
        private final int count;

        public a(Context context, int i, int i2, b.a aVar) {
            this.count = i;
            this.axt = i2;
            this.axu = aVar;
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
            return this.axu.getView(this.axt + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> axv;

        public b(ArrayList<View> arrayList) {
            this.axv = new ArrayList<>();
            this.axv = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.axv.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.axv.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.axv.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int L(View view) {
            if (this.axv == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.axv.size()) {
                    return -1;
                }
                if (this.axv.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
