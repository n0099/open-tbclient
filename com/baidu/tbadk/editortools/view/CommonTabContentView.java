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
    private ViewPager aDL;
    private IndicatorView aDM;
    private int aDN;
    private b aDO;
    private int aDP;
    private c aDQ;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDN = 0;
        this.aDP = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aDQ != null && CommonTabContentView.this.aDO != null) {
                    if (CommonTabContentView.this.aDO.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aDQ.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aDN = 0;
        this.aDP = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aDQ != null && CommonTabContentView.this.aDO != null) {
                    if (CommonTabContentView.this.aDO.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aDQ.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.aDL = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.aDL.setFadingEdgeLength(0);
        this.aDL.setOnPageChangeListener(this);
        this.aDM = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.aDL.getChildCount() > 0 && this.aDN == count) {
                for (int i2 = 0; i2 < this.aDL.getChildCount(); i2++) {
                    View childAt = this.aDL.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aDL.setAdapter(null);
            this.aDN = count;
            int DM = aVar.DM();
            int row = aVar.getRow();
            if (count != 0 && DM != 0 && row != 0) {
                this.aDP = row * DM;
                int i3 = count / this.aDP;
                int i4 = count % this.aDP == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aDM.setVisibility(0);
                    this.aDM.setCount(i4);
                    this.aDM.setPosition(0.0f);
                } else {
                    this.aDM.setVisibility(4);
                }
                this.aDQ = aVar.DP();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.DN() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(d.C0080d.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.DN(), (ViewGroup) null);
                    }
                    if (this.aDQ != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(DM);
                    if (i5 < i4 - 1) {
                        i = this.aDP;
                    } else {
                        i = count - (this.aDP * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aDP, aVar.DL()));
                    arrayList.add(gridView);
                }
                this.aDO = new b(arrayList);
                this.aDL.setAdapter(this.aDO);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aDM != null) {
            this.aDM.setPosition(i + f);
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
            if (i3 < this.aDL.getChildCount()) {
                View childAt = this.aDL.getChildAt(i3);
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
        return this.aDL;
    }

    public IndicatorView getIndicatorView() {
        return this.aDM;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aDS;
        private a.InterfaceC0056a aDT;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0056a interfaceC0056a) {
            this.count = i;
            this.aDS = i2;
            this.aDT = interfaceC0056a;
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
            return this.aDT.getView(this.aDS + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aDU;

        public b(ArrayList<View> arrayList) {
            this.aDU = new ArrayList<>();
            this.aDU = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aDU.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aDU.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aDU.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int N(View view) {
            if (this.aDU == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aDU.size()) {
                    return -1;
                }
                if (this.aDU.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
