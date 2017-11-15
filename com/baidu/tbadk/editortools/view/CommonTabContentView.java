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
    private ViewPager aDT;
    private IndicatorView aDU;
    private int aDV;
    private b aDW;
    private int aDX;
    private c aDY;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDV = 0;
        this.aDX = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aDY != null && CommonTabContentView.this.aDW != null) {
                    if (CommonTabContentView.this.aDW.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aDY.a(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.aDV = 0;
        this.aDX = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.aDY != null && CommonTabContentView.this.aDW != null) {
                    if (CommonTabContentView.this.aDW.N(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.aDY.a(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.common_tab_content, (ViewGroup) this, true);
        this.aDT = (ViewPager) findViewById(d.g.privilege_tab_viewpager);
        this.aDT.setFadingEdgeLength(0);
        this.aDT.setOnPageChangeListener(this);
        this.aDU = (IndicatorView) findViewById(d.g.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.aDT.getChildCount() > 0 && this.aDV == count) {
                for (int i2 = 0; i2 < this.aDT.getChildCount(); i2++) {
                    View childAt = this.aDT.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.aDT.setAdapter(null);
            this.aDV = count;
            int DY = aVar.DY();
            int row = aVar.getRow();
            if (count != 0 && DY != 0 && row != 0) {
                this.aDX = row * DY;
                int i3 = count / this.aDX;
                int i4 = count % this.aDX == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.aDU.setVisibility(0);
                    this.aDU.setCount(i4);
                    this.aDU.setPosition(0.0f);
                } else {
                    this.aDU.setVisibility(4);
                }
                this.aDY = aVar.Eb();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.DZ() == 0) {
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
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.DZ(), (ViewGroup) null);
                    }
                    if (this.aDY != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(DY);
                    if (i5 < i4 - 1) {
                        i = this.aDX;
                    } else {
                        i = count - (this.aDX * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.aDX, aVar.DX()));
                    arrayList.add(gridView);
                }
                this.aDW = new b(arrayList);
                this.aDT.setAdapter(this.aDW);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aDU != null) {
            this.aDU.setPosition(i + f);
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
            if (i3 < this.aDT.getChildCount()) {
                View childAt = this.aDT.getChildAt(i3);
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
        return this.aDT;
    }

    public IndicatorView getIndicatorView() {
        return this.aDU;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int aEa;
        private a.InterfaceC0056a aEb;
        private final int count;

        public a(Context context, int i, int i2, a.InterfaceC0056a interfaceC0056a) {
            this.count = i;
            this.aEa = i2;
            this.aEb = interfaceC0056a;
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
            return this.aEb.getView(this.aEa + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class b extends PagerAdapter {
        private ArrayList<View> aEc;

        public b(ArrayList<View> arrayList) {
            this.aEc = new ArrayList<>();
            this.aEc = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aEc.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.aEc.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.aEc.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int N(View view) {
            if (this.aEc == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aEc.size()) {
                    return -1;
                }
                if (this.aEc.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
