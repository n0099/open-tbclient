package com.baidu.tbadk.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.gif.GifView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager Ct;
    private IndicatorView RA;
    private final Point RB;
    private w RC;
    private int RD;
    private ad Rp;
    private WindowManager.LayoutParams Rq;
    private GifView Rr;
    private boolean Rs;
    private final Rect Rt;
    private ViewGroup Ru;
    private int Rv;
    private int Rw;
    private int Rx;
    private GridView Ry;
    private int Rz;
    private WindowManager go;
    private Context mContext;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rt = new Rect();
        this.Rz = -1;
        this.RB = new Point();
        this.RC = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.Rt = new Rect();
        this.Rz = -1;
        this.RB = new Point();
        this.RC = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.emotion_tab_content, this, true);
        this.Ct = (ViewPager) findViewById(com.baidu.tieba.v.face_tab_viewpager);
        this.Ct.setFadingEdgeLength(0);
        this.Ct.setOnPageChangeListener(this);
        this.Rr = new GifView(context);
        aw.c(this.Rr, com.baidu.tieba.u.bg_expression_bubble, this.RD);
        this.Rr.setVisibility(8);
        this.go = (WindowManager) context.getSystemService("window");
        this.Rq = new WindowManager.LayoutParams();
        this.Rv = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_width);
        this.Rw = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_height);
        this.Rx = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_space);
        this.Rq.width = this.Rv;
        this.Rq.height = this.Rw;
        this.Rq.gravity = 51;
        this.Rq.format = -3;
        this.Rq.type = 1000;
        this.Rq.flags |= 56;
        this.Ru = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.RA = (IndicatorView) findViewById(com.baidu.tieba.v.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.Rq.type = 1000;
            this.Rq.flags = 25165832;
        }
    }

    public void b(ad adVar) {
        int i;
        this.Rp = adVar;
        int emotionsCount = this.Rp.getEmotionsCount();
        int rQ = adVar.rQ();
        int rR = adVar.rR();
        if (rQ != 0 && rR != 0) {
            int i2 = emotionsCount / (rQ * rR);
            int i3 = emotionsCount % (rQ * rR) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.RA.setVisibility(0);
                this.RA.setCount(i3);
                this.RA.setPosition(0.0f);
            } else {
                this.RA.setVisibility(4);
            }
            this.Ct.setAdapter(null);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(adVar.rQ());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.s.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = rQ * rR;
                } else {
                    i = emotionsCount - ((rQ * rR) * (i3 - 1));
                }
                int i5 = i4 * rQ * rR;
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this, i5));
                gridView.setAdapter((ListAdapter) new j(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.Ct.setAdapter(new l(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.Rz != i) {
            String cG = this.Rp.cG(((j) gridView.getAdapter()).ru() + i);
            this.Rr.setTag(cG);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.Tf = cG;
            this.Rr.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.Rt);
            this.Ru.offsetDescendantRectToMyCoords(linearLayout, this.Rt);
            this.Rq.x = this.Rt.left - ((this.Rq.width - linearLayout.getWidth()) / 2);
            this.Rq.y = (this.Rt.top - this.Rq.height) + this.Rx;
            this.Rr.setVisibility(0);
            if (!this.Rs) {
                this.go.addView(this.Rr, this.Rq);
                this.Rs = true;
            } else {
                this.go.updateViewLayout(this.Rr, this.Rq);
            }
            gridView.setSelection(i);
            if (this.Rz != -1) {
                ((LinearLayout) gridView.getChildAt(this.Rz - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.Rz = i;
            this.Ry = gridView;
        }
    }

    private void rt() {
        if (this.Rs && this.Rr.getVisibility() != 8 && this.Ry != null) {
            this.Ry.setSelection(-1);
            this.Rr.setVisibility(8);
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
                if (this.Rs && this.Rr.getVisibility() != 8 && this.Ry != null) {
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
                this.RB.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                rt();
                break;
            case 2:
                getFocusedRect(this.Rt);
                if (!this.Rt.contains(x, y)) {
                    rt();
                    break;
                } else {
                    this.Rt.set(x, y, x + 1, y + 1);
                    if (this.Ry != null) {
                        offsetRectIntoDescendantCoords(this.Ry, this.Rt);
                        int pointToPosition = this.Ry.pointToPosition(this.Rt.left, this.Rt.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.Ry);
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
        if (this.Rs) {
            this.go.removeView(this.Rr);
            this.Rs = false;
        }
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
        this.RD = i;
        aw.c(this.Rr, com.baidu.tieba.u.bg_expression_bubble, i);
        aw.d(this, com.baidu.tieba.s.editor_tool_container_bg, i);
    }

    public void reset() {
        rt();
    }

    public void setOnDataSelected(w wVar) {
        this.RC = wVar;
    }
}
