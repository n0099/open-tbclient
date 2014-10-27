package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager Ct;
    private IndicatorView RA;
    private final Point RB;
    private com.baidu.tbadk.editortool.w RC;
    private boolean Rs;
    private GridView Ry;
    private int Rz;
    private int amx;

    public PrivilegeTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rz = -1;
        this.RB = new Point();
        this.RC = null;
        this.amx = 0;
        init(context);
    }

    public PrivilegeTabContentView(Context context) {
        super(context);
        this.Rz = -1;
        this.RB = new Point();
        this.RC = null;
        this.amx = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.privilege_tab_content, this, true);
        this.Ct = (ViewPager) findViewById(com.baidu.tieba.v.privilege_tab_viewpager);
        this.Ct.setFadingEdgeLength(0);
        this.Ct.setOnPageChangeListener(this);
        this.RA = (IndicatorView) findViewById(com.baidu.tieba.v.privilege_tab_indicator);
    }

    public void a(an anVar) {
        int i;
        int i2 = 0;
        if (anVar != null) {
            int count = anVar.getCount();
            if (this.Ct.getChildCount() <= 0 || this.amx != count) {
                this.Ct.setAdapter(null);
                this.amx = count;
                int Cr = anVar.Cr();
                int row = anVar.getRow();
                if (count != 0 && Cr != 0 && row != 0) {
                    int i3 = count / (Cr * row);
                    int i4 = count % (Cr * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.RA.setVisibility(0);
                        this.RA.setCount(i4);
                        this.RA.setPosition(0.0f);
                    } else {
                        this.RA.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(Cr);
                        gridView.setVerticalSpacing(anVar.Cs());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(anVar.Ct());
                        gridView.setSelector(com.baidu.tieba.s.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = Cr * row;
                        } else {
                            i = count - ((Cr * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new al(this, getContext(), i, i5 * Cr * row, anVar.Cq()));
                        arrayList.add(gridView);
                    }
                    this.Ct.setAdapter(new am(this, arrayList));
                    return;
                }
                return;
            }
            while (true) {
                int i6 = i2;
                if (i6 < this.Ct.getChildCount()) {
                    View childAt = this.Ct.getChildAt(i6);
                    if (childAt instanceof GridView) {
                        ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                    }
                    i2 = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void rt() {
        if (this.Rs && this.Ry != null) {
            this.Ry.setSelection(-1);
            if (this.Rz != -1) {
                ((LinearLayout) this.Ry.getChildAt(this.Rz - this.Ry.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.Rz = -1;
            this.Ry = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.RB.set(x, y);
                break;
            case 1:
            case 3:
                rt();
                break;
            case 2:
                this.RB.set(x, y);
                if (this.Rs && this.Ry != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.RA != null) {
            this.RA.setPosition(i + f);
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
            if (i3 < this.Ct.getChildCount()) {
                View childAt = this.Ct.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        this.RC = wVar;
    }
}
