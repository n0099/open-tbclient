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
    private ViewPager Cu;
    private GridView RC;
    private int RD;
    private IndicatorView RE;
    private final Point RF;
    private com.baidu.tbadk.editortool.w RG;
    private boolean Rw;
    private int amG;

    public PrivilegeTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RD = -1;
        this.RF = new Point();
        this.RG = null;
        this.amG = 0;
        init(context);
    }

    public PrivilegeTabContentView(Context context) {
        super(context);
        this.RD = -1;
        this.RF = new Point();
        this.RG = null;
        this.amG = 0;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.privilege_tab_content, this, true);
        this.Cu = (ViewPager) findViewById(com.baidu.tieba.v.privilege_tab_viewpager);
        this.Cu.setFadingEdgeLength(0);
        this.Cu.setOnPageChangeListener(this);
        this.RE = (IndicatorView) findViewById(com.baidu.tieba.v.privilege_tab_indicator);
    }

    public void a(an anVar) {
        int i;
        int i2 = 0;
        if (anVar != null) {
            int count = anVar.getCount();
            if (this.Cu.getChildCount() <= 0 || this.amG != count) {
                this.Cu.setAdapter(null);
                this.amG = count;
                int Ct = anVar.Ct();
                int row = anVar.getRow();
                if (count != 0 && Ct != 0 && row != 0) {
                    int i3 = count / (Ct * row);
                    int i4 = count % (Ct * row) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.RE.setVisibility(0);
                        this.RE.setCount(i4);
                        this.RE.setPosition(0.0f);
                    } else {
                        this.RE.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(Ct);
                        gridView.setVerticalSpacing(anVar.Cu());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(anVar.Cv());
                        gridView.setSelector(com.baidu.tieba.s.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = Ct * row;
                        } else {
                            i = count - ((Ct * row) * (i4 - 1));
                        }
                        gridView.setAdapter((ListAdapter) new al(this, getContext(), i, i5 * Ct * row, anVar.Cs()));
                        arrayList.add(gridView);
                    }
                    this.Cu.setAdapter(new am(this, arrayList));
                    return;
                }
                return;
            }
            while (true) {
                int i6 = i2;
                if (i6 < this.Cu.getChildCount()) {
                    View childAt = this.Cu.getChildAt(i6);
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

    private void rv() {
        if (this.Rw && this.RC != null) {
            this.RC.setSelection(-1);
            if (this.RD != -1) {
                ((LinearLayout) this.RC.getChildAt(this.RD - this.RC.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.RD = -1;
            this.RC = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.RF.set(x, y);
                break;
            case 1:
            case 3:
                rv();
                break;
            case 2:
                this.RF.set(x, y);
                if (this.Rw && this.RC != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.RE != null) {
            this.RE.setPosition(i + f);
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
            if (i3 < this.Cu.getChildCount()) {
                View childAt = this.Cu.getChildAt(i3);
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
        this.RG = wVar;
    }
}
