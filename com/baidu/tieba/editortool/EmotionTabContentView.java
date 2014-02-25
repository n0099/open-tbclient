package com.baidu.tieba.editortool;

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
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager a;
    private WritableEmotionGroup b;
    private WindowManager c;
    private WindowManager.LayoutParams d;
    private GifView e;
    private boolean f;
    private Rect g;
    private ViewGroup h;
    private int i;
    private int j;
    private int k;
    private GridView l;
    private int m;
    private IndicatorView n;
    private Point o;
    private z p;
    private int q;
    private com.baidu.tieba.util.i r;
    private LinearLayout.LayoutParams s;
    private LayoutInflater t;

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
        this.t = (LayoutInflater) context.getSystemService("layout_inflater");
        this.t.inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
        this.r = new com.baidu.tieba.util.i(context);
        this.a = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.a.setFadingEdgeLength(0);
        this.a.setOnPageChangeListener(this);
        this.e = new GifView(context);
        if (this.q == 1) {
            this.e.setBackgroundResource(R.drawable.bg_expression_bubble_1);
        } else {
            this.e.setBackgroundResource(R.drawable.bg_expression_bubble);
        }
        this.e.setVisibility(8);
        this.c = (WindowManager) context.getSystemService("window");
        this.d = new WindowManager.LayoutParams();
        this.i = context.getResources().getDimensionPixelSize(R.dimen.face_tab_content_float_width);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.face_tab_content_float_height);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.face_tab_content_float_space);
        this.d.width = this.i;
        this.d.height = this.j;
        this.d.gravity = 51;
        this.d.format = -3;
        this.d.type = LocationClientOption.MIN_SCAN_SPAN;
        this.d.flags |= 56;
        if (TiebaApplication.g().bu()) {
            this.d.type = LocationClientOption.MIN_SCAN_SPAN;
            this.d.flags = 25165832;
        }
        this.h = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.n = (IndicatorView) findViewById(R.id.face_tab_indicator);
        this.s = new LinearLayout.LayoutParams(-1, -1);
    }

    public void a(WritableEmotionGroup writableEmotionGroup) {
        int i;
        this.b = writableEmotionGroup;
        int d = this.b.d();
        int j = writableEmotionGroup.j();
        int k = writableEmotionGroup.k();
        if (j != 0 && k != 0) {
            int i2 = d / (j * k);
            int i3 = d % (j * k) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.n.setVisibility(0);
                this.n.setCount(i3);
                this.n.setPosition(0.0f);
            } else {
                this.n.setVisibility(4);
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(writableEmotionGroup.j());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(R.color.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = j * k;
                } else {
                    i = d - ((j * k) * (i3 - 1));
                }
                int i5 = i4 * j * k;
                gridView.setOnItemLongClickListener(new l(this));
                gridView.setOnItemClickListener(new m(this, i5));
                gridView.setAdapter((ListAdapter) new o(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.a.setAdapter(new q(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.m != i) {
            String a = this.b.a(((o) gridView.getAdapter()).a() + i);
            this.e.setTag(a);
            com.baidu.adp.widget.ImageView.b a2 = this.r.a(a, com.baidu.tieba.util.i.c(), new n(this));
            if (a2 != null) {
                this.e.setGif(a2);
            }
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
            this.e.setBackgroundResource(R.drawable.bg_expression_bubble_1);
        } else {
            this.e.setBackgroundResource(R.drawable.bg_expression_bubble);
        }
        setBackgroundColor(getResources().getColor(i == 1 ? R.color.editor_tool_container_bg_1 : R.color.editor_tool_container_bg));
    }

    public void a() {
        b();
    }

    public void setOnDataSelected(z zVar) {
        this.p = zVar;
    }
}
