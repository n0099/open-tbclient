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
    private ViewPager Cu;
    private int RA;
    private int RB;
    private GridView RC;
    private int RD;
    private IndicatorView RE;
    private final Point RF;
    private w RG;
    private int RH;
    private ad Rt;
    private WindowManager.LayoutParams Ru;
    private GifView Rv;
    private boolean Rw;
    private final Rect Rx;
    private ViewGroup Ry;
    private int Rz;
    private WindowManager go;
    private Context mContext;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rx = new Rect();
        this.RD = -1;
        this.RF = new Point();
        this.RG = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.Rx = new Rect();
        this.RD = -1;
        this.RF = new Point();
        this.RG = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.emotion_tab_content, this, true);
        this.Cu = (ViewPager) findViewById(com.baidu.tieba.v.face_tab_viewpager);
        this.Cu.setFadingEdgeLength(0);
        this.Cu.setOnPageChangeListener(this);
        this.Rv = new GifView(context);
        aw.c(this.Rv, com.baidu.tieba.u.bg_expression_bubble, this.RH);
        this.Rv.setVisibility(8);
        this.go = (WindowManager) context.getSystemService("window");
        this.Ru = new WindowManager.LayoutParams();
        this.Rz = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_width);
        this.RA = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_height);
        this.RB = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_space);
        this.Ru.width = this.Rz;
        this.Ru.height = this.RA;
        this.Ru.gravity = 51;
        this.Ru.format = -3;
        this.Ru.type = 1000;
        this.Ru.flags |= 56;
        this.Ry = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.RE = (IndicatorView) findViewById(com.baidu.tieba.v.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.Ru.type = 1000;
            this.Ru.flags = 25165832;
        }
    }

    public void b(ad adVar) {
        int i;
        this.Rt = adVar;
        int emotionsCount = this.Rt.getEmotionsCount();
        int rS = adVar.rS();
        int rT = adVar.rT();
        if (rS != 0 && rT != 0) {
            int i2 = emotionsCount / (rS * rT);
            int i3 = emotionsCount % (rS * rT) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.RE.setVisibility(0);
                this.RE.setCount(i3);
                this.RE.setPosition(0.0f);
            } else {
                this.RE.setVisibility(4);
            }
            this.Cu.setAdapter(null);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(adVar.rS());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.s.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = rS * rT;
                } else {
                    i = emotionsCount - ((rS * rT) * (i3 - 1));
                }
                int i5 = i4 * rS * rT;
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this, i5));
                gridView.setAdapter((ListAdapter) new j(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.Cu.setAdapter(new l(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.RD != i) {
            String cG = this.Rt.cG(((j) gridView.getAdapter()).rw() + i);
            this.Rv.setTag(cG);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.Tj = cG;
            this.Rv.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.Rx);
            this.Ry.offsetDescendantRectToMyCoords(linearLayout, this.Rx);
            this.Ru.x = this.Rx.left - ((this.Ru.width - linearLayout.getWidth()) / 2);
            this.Ru.y = (this.Rx.top - this.Ru.height) + this.RB;
            this.Rv.setVisibility(0);
            if (!this.Rw) {
                this.go.addView(this.Rv, this.Ru);
                this.Rw = true;
            } else {
                this.go.updateViewLayout(this.Rv, this.Ru);
            }
            gridView.setSelection(i);
            if (this.RD != -1) {
                ((LinearLayout) gridView.getChildAt(this.RD - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.RD = i;
            this.RC = gridView;
        }
    }

    private void rv() {
        if (this.Rw && this.Rv.getVisibility() != 8 && this.RC != null) {
            this.RC.setSelection(-1);
            this.Rv.setVisibility(8);
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
                if (this.Rw && this.Rv.getVisibility() != 8 && this.RC != null) {
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
                this.RF.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                rv();
                break;
            case 2:
                getFocusedRect(this.Rx);
                if (!this.Rx.contains(x, y)) {
                    rv();
                    break;
                } else {
                    this.Rx.set(x, y, x + 1, y + 1);
                    if (this.RC != null) {
                        offsetRectIntoDescendantCoords(this.RC, this.Rx);
                        int pointToPosition = this.RC.pointToPosition(this.Rx.left, this.Rx.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.RC);
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
        if (this.Rw) {
            this.go.removeView(this.Rv);
            this.Rw = false;
        }
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
        this.RH = i;
        aw.c(this.Rv, com.baidu.tieba.u.bg_expression_bubble, i);
        aw.d(this, com.baidu.tieba.s.editor_tool_container_bg, i);
    }

    public void reset() {
        rv();
    }

    public void setOnDataSelected(w wVar) {
        this.RG = wVar;
    }
}
