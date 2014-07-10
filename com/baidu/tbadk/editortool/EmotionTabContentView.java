package com.baidu.tbadk.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.gif.GifView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager a;
    private ae b;
    private WindowManager c;
    private WindowManager.LayoutParams d;
    private GifView e;
    private boolean f;
    private final Rect g;
    private ViewGroup h;
    private int i;
    private int j;
    private int k;
    private GridView l;
    private int m;
    private IndicatorView n;
    private final Point o;
    private w p;
    private int q;
    private aa r;
    private LayoutInflater s;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Rect();
        this.m = -1;
        this.o = new Point();
        this.p = null;
        a(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.g = new Rect();
        this.m = -1;
        this.o = new Point();
        this.p = null;
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        this.s = (LayoutInflater) context.getSystemService("layout_inflater");
        this.s.inflate(com.baidu.tieba.w.emotion_tab_content, (ViewGroup) this, true);
        this.r = new aa(context);
        this.a = (ViewPager) findViewById(com.baidu.tieba.v.face_tab_viewpager);
        this.a.setFadingEdgeLength(0);
        this.a.setOnPageChangeListener(this);
        this.e = new GifView(context);
        if (this.q == 1) {
            this.e.setBackgroundResource(com.baidu.tieba.u.bg_expression_bubble_1);
        } else {
            this.e.setBackgroundResource(com.baidu.tieba.u.bg_expression_bubble);
        }
        this.e.setVisibility(8);
        this.c = (WindowManager) context.getSystemService("window");
        this.d = new WindowManager.LayoutParams();
        this.i = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_width);
        this.j = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_height);
        this.k = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_space);
        this.d.width = this.i;
        this.d.height = this.j;
        this.d.gravity = 51;
        this.d.format = -3;
        this.d.type = 1000;
        this.d.flags |= 56;
        this.h = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.n = (IndicatorView) findViewById(com.baidu.tieba.v.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.d.type = 1000;
            this.d.flags = 25165832;
        }
    }

    public void a(ae aeVar) {
        int i;
        this.b = aeVar;
        int d = this.b.d();
        int k = aeVar.k();
        int l = aeVar.l();
        if (k != 0 && l != 0) {
            int i2 = d / (k * l);
            int i3 = d % (k * l) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.n.setVisibility(0);
                this.n.setCount(i3);
                this.n.setPosition(0.0f);
            } else {
                this.n.setVisibility(4);
            }
            this.a.setAdapter(null);
            System.gc();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(aeVar.k());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.s.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = k * l;
                } else {
                    i = d - ((k * l) * (i3 - 1));
                }
                int i5 = i4 * k * l;
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this, i5));
                gridView.setAdapter((ListAdapter) new j(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.a.setAdapter(new l(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.m != i) {
            String a = this.b.a(((j) gridView.getAdapter()).a() + i);
            this.e.setTag(a);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.b = a;
            this.e.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.g);
            this.h.offsetDescendantRectToMyCoords(linearLayout, this.g);
            this.d.x = this.g.left - ((this.d.width - linearLayout.getWidth()) / 2);
            this.d.y = (this.g.top - this.d.height) + this.k;
            this.e.setVisibility(0);
            if (!this.f) {
                this.c.addView(this.e, this.d);
                this.f = true;
            } else {
                this.c.updateViewLayout(this.e, this.d);
            }
            gridView.setSelection(i);
            if (this.m != -1) {
                ((LinearLayout) gridView.getChildAt(this.m - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.m = i;
            this.l = gridView;
        }
    }

    private void b() {
        if (this.f && this.e.getVisibility() != 8 && this.l != null) {
            this.l.setSelection(-1);
            this.e.setVisibility(8);
            if (this.m != -1) {
                ((LinearLayout) this.l.getChildAt(this.m - this.l.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.m = -1;
            this.l = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.o.set(x, y);
                break;
            case 1:
            case 3:
                b();
                break;
            case 2:
                this.o.set(x, y);
                if (this.f && this.e.getVisibility() != 8 && this.l != null) {
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.o.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                b();
                break;
            case 2:
                getFocusedRect(this.g);
                if (!this.g.contains(x, y)) {
                    b();
                    break;
                } else {
                    this.g.set(x, y, x + 1, y + 1);
                    if (this.l != null) {
                        offsetRectIntoDescendantCoords(this.l, this.g);
                        int pointToPosition = this.l.pointToPosition(this.g.left, this.g.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.l);
                            break;
                        }
                    }
                }
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f) {
            this.c.removeView(this.e);
            this.f = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.n != null) {
            this.n.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(int i) {
        this.q = i;
        if (i == 1) {
            this.e.setBackgroundResource(com.baidu.tieba.u.bg_expression_bubble_1);
        } else {
            this.e.setBackgroundResource(com.baidu.tieba.u.bg_expression_bubble);
        }
        setBackgroundColor(getResources().getColor(i == 1 ? com.baidu.tieba.s.editor_tool_container_bg_1 : com.baidu.tieba.s.editor_tool_container_bg));
    }

    public void a() {
        b();
    }

    public void setOnDataSelected(w wVar) {
        this.p = wVar;
    }
}
