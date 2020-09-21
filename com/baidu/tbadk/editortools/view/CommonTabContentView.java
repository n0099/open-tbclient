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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private IndicatorView eAy;
    private int eQh;
    private CommonViewPagerAdapter eQi;
    private int eQj;
    private b eQk;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private ViewPager mViewPager;

    /* loaded from: classes.dex */
    public interface b {
        void b(View view, int i, long j);
    }

    public CommonTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQh = 0;
        this.eQj = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.eQk != null && CommonTabContentView.this.eQi != null) {
                    if (CommonTabContentView.this.eQi.bv(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.eQk.b(view, i, j);
                }
            }
        };
        init(context);
    }

    public CommonTabContentView(Context context) {
        super(context);
        this.eQh = 0;
        this.eQj = 0;
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tbadk.editortools.view.CommonTabContentView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (CommonTabContentView.this.eQk != null && CommonTabContentView.this.eQi != null) {
                    if (CommonTabContentView.this.eQi.bv(adapterView) != 0) {
                        i = -1;
                    }
                    CommonTabContentView.this.eQk.b(view, i, j);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.common_tab_content, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(R.id.privilege_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.eAy = (IndicatorView) findViewById(R.id.privilege_tab_indicator);
    }

    public void a(com.baidu.tbadk.editortools.view.a aVar) {
        GridView gridView;
        int i;
        if (aVar != null) {
            int count = aVar.getCount();
            if (this.mViewPager.getChildCount() > 0 && this.eQh == count) {
                for (int i2 = 0; i2 < this.mViewPager.getChildCount(); i2++) {
                    View childAt = this.mViewPager.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                }
                return;
            }
            this.mViewPager.setAdapter(null);
            this.eQh = count;
            int column = aVar.getColumn();
            int row = aVar.getRow();
            if (count != 0 && column != 0 && row != 0) {
                this.eQj = row * column;
                int i3 = count / this.eQj;
                int i4 = count % this.eQj == 0 ? i3 : i3 + 1;
                if (i4 > 1) {
                    this.eAy.setVisibility(0);
                    this.eAy.setCount(i4);
                    this.eAy.setPosition(0.0f);
                } else {
                    this.eAy.setVisibility(4);
                }
                this.eQk = aVar.btN();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    if (aVar.btL() == 0) {
                        GridView gridView2 = new GridView(getContext());
                        gridView2.setVerticalSpacing(aVar.getVerticalSpacing());
                        gridView2.setGravity(17);
                        gridView2.setHorizontalSpacing(aVar.getHorizontalSpacing());
                        if (aVar.getPaddingLeft() != 0 || aVar.getPaddingRight() != 0) {
                            gridView2.setPadding(aVar.getPaddingLeft(), 0, aVar.getPaddingRight(), 0);
                        }
                        gridView2.setSelector(R.color.common_color_10022);
                        gridView2.setSelection(-1);
                        gridView = gridView2;
                    } else {
                        gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.btL(), (ViewGroup) null);
                    }
                    if (this.eQk != null) {
                        gridView.setOnItemClickListener(this.mOnItemClickListener);
                    }
                    gridView.setNumColumns(column);
                    if (i5 < i4 - 1) {
                        i = this.eQj;
                    } else {
                        i = count - (this.eQj * (i4 - 1));
                    }
                    gridView.setAdapter((ListAdapter) new a(getContext(), i, i5 * this.eQj, aVar.btK()));
                    arrayList.add(gridView);
                }
                this.eQi = new CommonViewPagerAdapter(arrayList);
                this.mViewPager.setAdapter(this.eQi);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.eAy != null) {
            this.eAy.setPosition(i + f);
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

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public IndicatorView getIndicatorView() {
        return this.eAy;
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private final int count;
        private final int eQm;
        private a.InterfaceC0549a eQn;

        public a(Context context, int i, int i2, a.InterfaceC0549a interfaceC0549a) {
            this.count = i;
            this.eQm = i2;
            this.eQn = interfaceC0549a;
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
            return this.eQn.getView(this.eQm + i, view, viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        private ArrayList<View> eQo;

        public CommonViewPagerAdapter(ArrayList<View> arrayList) {
            this.eQo = new ArrayList<>();
            this.eQo = arrayList;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.eQo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.eQo.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.eQo.get(i);
            viewGroup.addView(view);
            return view;
        }

        public int bv(View view) {
            if (this.eQo == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eQo.size()) {
                    return -1;
                }
                if (this.eQo.get(i2) != view) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
    }
}
