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
    private IndicatorView buQ;
    private int buR;
    private b buS;
    private int buT;
    private c buU;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewPager qV;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buR = 0;
        this.buT = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.buU != null && CommonTabContentView.this.buS != null) {
                    if (CommonTabContentView.this.buS.bj(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.buU.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.buR = 0;
        this.buT = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.buU != null && CommonTabContentView.this.buS != null) {
                    if (CommonTabContentView.this.buS.bj(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.buU.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.qV = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.qV.setFadingEdgeLength(0);
        this.qV.setOnPageChangeListener(this);
        this.buQ = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.qV.getChildCount() > 0 && this.buR == count) {
                for (int i2 = 0; i2 < this.qV.getChildCount(); i2++) {
                    View childAt = this.qV.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.qV.setAdapter(null);
            this.buR = count;
            int Me = aVar.Me();
            int row = aVar.getRow();
            if (count != 0 && Me != 0 && row != 0) {
                this.buT = row * Me;
                int i3 = count / this.buT;
                int i4 = count % this.buT == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.buQ.setVisibility(0);
                    this.buQ.setCount(i4);
                    this.buQ.setPosition(0.0f);
                } else {
                    this.buQ.setVisibility(4);
                }
                this.buU = aVar.Mh();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.Mf() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(d.C0141d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.Mf(), (ViewGroup) null);
                    }
                    if (this.buU != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(Me);
                    if (i5 < i4 - 1) {
                        i = this.buT;
                    } else {
                        i = count - (this.buT * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.buT, aVar.Md()));
                    arrayList.add(gridView);
                }
                this.buS = new b(arrayList);
                this.qV.setAdapter(this.buS);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.buQ != null) {
            this.buQ.setPosition(i + f);
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
            if (i3 < this.qV.getChildCount()) {
                View childAt = this.qV.getChildAt(i3);
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
        return this.qV;
    }

    public IndicatorView getIndicatorView() {
        return this.buQ;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int buW;
        private a.InterfaceC0107a buX;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0107a interfaceC0107a) {
            this.count = i;
            this.buW = i2;
            this.buX = interfaceC0107a;
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
            return this.buX.getView(this.buW + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> buY;

        public b(ArrayList<View> arrayList) {
            this.buY = new ArrayList<>();
            this.buY = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.buY.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.buY.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.buY.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int bj(View view) {
            if (this.buY == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.buY.size()) {
                    return -1;
                }
                if (this.buY.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
