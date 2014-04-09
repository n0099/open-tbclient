package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PrivilegeTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager a;
    private boolean b;
    private GridView c;
    private int d;
    private IndicatorView e;
    private final Point f;
    private com.baidu.tbadk.editortool.x g;
    private int h;
    private LayoutInflater i;

    public PrivilegeTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        this.f = new Point();
        this.g = null;
        this.h = 0;
        a(context);
    }

    public PrivilegeTabContentView(Context context) {
        super(context);
        this.d = -1;
        this.f = new Point();
        this.g = null;
        this.h = 0;
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        this.i = (LayoutInflater) context.getSystemService("layout_inflater");
        this.i.inflate(com.baidu.tieba.a.i.privilege_tab_content, (ViewGroup) this, true);
        this.a = (ViewPager) findViewById(com.baidu.tieba.a.h.privilege_tab_viewpager);
        this.a.setFadingEdgeLength(0);
        this.a.setOnPageChangeListener(this);
        this.e = (IndicatorView) findViewById(com.baidu.tieba.a.h.privilege_tab_indicator);
    }

    public final void a(ag agVar) {
        int i;
        int i2 = 0;
        if (agVar != null) {
            int a = agVar.a();
            if (this.a.getChildCount() <= 0 || this.h != a) {
                this.a.setAdapter(null);
                this.h = a;
                int e = agVar.e();
                int f = agVar.f();
                if (a != 0 && e != 0 && f != 0) {
                    int i3 = a / (e * f);
                    int i4 = a % (e * f) == 0 ? i3 : i3 + 1;
                    if (i4 > 1) {
                        this.e.setVisibility(0);
                        this.e.setCount(i4);
                        this.e.setPosition(0.0f);
                    } else {
                        this.e.setVisibility(4);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        GridView gridView = new GridView(getContext());
                        gridView.setNumColumns(e);
                        gridView.setVerticalSpacing(agVar.g());
                        gridView.setGravity(17);
                        gridView.setHorizontalSpacing(agVar.h());
                        gridView.setSelector(com.baidu.tieba.a.e.transparent);
                        gridView.setSelection(-1);
                        if (i5 < i4 - 1) {
                            i = e * f;
                        } else {
                            i = a - ((e * f) * (i4 - 1));
                        }
                        getContext();
                        gridView.setAdapter((ListAdapter) new ae(this, i, i5 * e * f, agVar.d()));
                        arrayList.add(gridView);
                    }
                    this.a.setAdapter(new af(this, arrayList));
                    return;
                }
                return;
            }
            while (true) {
                int i6 = i2;
                if (i6 < this.a.getChildCount()) {
                    View childAt = this.a.getChildAt(i6);
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.f.set(x, y);
                break;
            case 1:
            case 3:
                if (this.b && this.c != null) {
                    this.c.setSelection(-1);
                    if (this.d != -1) {
                        ((LinearLayout) this.c.getChildAt(this.d - this.c.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                    }
                    this.d = -1;
                    this.c = null;
                    break;
                }
                break;
            case 2:
                this.f.set(x, y);
                if (this.b && this.c != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.e != null) {
            this.e.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public final void a(int i) {
        setBackgroundColor(getResources().getColor(i == 1 ? com.baidu.tieba.a.e.editor_tool_container_bg_1 : com.baidu.tieba.a.e.editor_tool_container_bg));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.a.getChildCount()) {
                View childAt = this.a.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.x xVar) {
        this.g = xVar;
    }
}
