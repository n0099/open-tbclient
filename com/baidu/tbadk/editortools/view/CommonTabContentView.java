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
    private ViewPager aEB;
    private IndicatorView aEC;
    private int aED;
    private b aEE;
    private int aEF;
    private c aEG;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aED = 0;
        this.aEF = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aEG != null && CommonTabContentView.this.aEE != null) {
                    if (CommonTabContentView.this.aEE.O(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aEG.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aED = 0;
        this.aEF = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aEG != null && CommonTabContentView.this.aEE != null) {
                    if (CommonTabContentView.this.aEE.O(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aEG.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.aEB = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.aEB.setFadingEdgeLength(0);
        this.aEB.setOnPageChangeListener(this);
        this.aEC = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.aEB.getChildCount() > 0 && this.aED == count) {
                for (int i2 = 0; i2 < this.aEB.getChildCount(); i2++) {
                    View childAt = this.aEB.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aEB.setAdapter(null);
            this.aED = count;
            int Eh = aVar.Eh();
            int row = aVar.getRow();
            if (count != 0 && Eh != 0 && row != 0) {
                this.aEF = row * Eh;
                int i3 = count / this.aEF;
                int i4 = count % this.aEF == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aEC.setVisibility(0);
                    this.aEC.setCount(i4);
                    this.aEC.setPosition(0.0f);
                } else {
                    this.aEC.setVisibility(4);
                }
                this.aEG = aVar.Ek();
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
                        gridView2.setSelector(d.C0095d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.Ei(), (ViewGroup) null);
                    }
                    if (this.aEG != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Eh);
                    if (i5 < i4 - 1) {
                        i = this.aEF;
                    } else {
                        i = count - (this.aEF * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aEF, aVar.Eg()));
                    arrayList.add(gridView);
                }
                this.aEE = new b(arrayList);
                this.aEB.setAdapter(this.aEE);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEC != null) {
            this.aEC.setPosition(i + f);
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
            if (i3 < this.aEB.getChildCount()) {
                View childAt = this.aEB.getChildAt(i3);
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
        return this.aEB;
    }

    public IndicatorView getIndicatorView() {
        return this.aEC;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aEI;
        private a.InterfaceC0069a aEJ;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0069a interfaceC0069a) {
            this.count = i;
            this.aEI = i2;
            this.aEJ = interfaceC0069a;
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
            return this.aEJ.getView(this.aEI + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aEK;

        public b(ArrayList<View> arrayList) {
            this.aEK = new ArrayList<>();
            this.aEK = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aEK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aEK.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aEK.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int O(View view) {
            if (this.aEK == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aEK.size()) {
                    return -1;
                }
                if (this.aEK.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
