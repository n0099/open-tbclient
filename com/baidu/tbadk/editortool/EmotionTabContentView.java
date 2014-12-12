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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.gif.GifView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int XA;
    private IndicatorView XB;
    private final Point XC;
    private w XD;
    private int XE;
    private ae Xq;
    private WindowManager.LayoutParams Xr;
    private GifView Xs;
    private boolean Xt;
    private final Rect Xu;
    private ViewGroup Xv;
    private int Xw;
    private int Xx;
    private int Xy;
    private GridView Xz;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xu = new Rect();
        this.XA = -1;
        this.XC = new Point();
        this.XD = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.Xu = new Rect();
        this.XA = -1;
        this.XC = new Point();
        this.XD = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.x.emotion_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.w.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.Xs = new GifView(context);
        ax.c(this.Xs, com.baidu.tieba.v.bg_expression_bubble, this.XE);
        this.Xs.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.Xr = new WindowManager.LayoutParams();
        this.Xw = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_width);
        this.Xx = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_height);
        this.Xy = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_space);
        this.Xr.width = this.Xw;
        this.Xr.height = this.Xx;
        this.Xr.gravity = 51;
        this.Xr.format = -3;
        this.Xr.type = 1000;
        this.Xr.flags |= 56;
        this.Xv = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.XB = (IndicatorView) findViewById(com.baidu.tieba.w.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.Xr.type = 1000;
            this.Xr.flags = 25165832;
        }
    }

    public void b(ae aeVar) {
        int i;
        this.Xq = aeVar;
        int emotionsCount = this.Xq.getEmotionsCount();
        int vt = aeVar.vt();
        int vu = aeVar.vu();
        if (vt != 0 && vu != 0) {
            int i2 = emotionsCount / (vt * vu);
            int i3 = emotionsCount % (vt * vu) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.XB.setVisibility(0);
                this.XB.setCount(i3);
                this.XB.setPosition(0.0f);
            } else {
                this.XB.setVisibility(4);
            }
            this.mViewPager.setAdapter(null);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(aeVar.vt());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.t.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = vt * vu;
                } else {
                    i = emotionsCount - ((vt * vu) * (i3 - 1));
                }
                int i5 = i4 * vt * vu;
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this, i5));
                gridView.setAdapter((ListAdapter) new j(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.mViewPager.setAdapter(new l(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.XA != i) {
            String de = this.Xq.de(((j) gridView.getAdapter()).uX() + i);
            this.Xs.setTag(de);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.Zo = de;
            this.Xs.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.Xu);
            this.Xv.offsetDescendantRectToMyCoords(linearLayout, this.Xu);
            this.Xr.x = this.Xu.left - ((this.Xr.width - linearLayout.getWidth()) / 2);
            this.Xr.y = (this.Xu.top - this.Xr.height) + this.Xy;
            this.Xs.setVisibility(0);
            if (!this.Xt) {
                this.mWindowManager.addView(this.Xs, this.Xr);
                this.Xt = true;
            } else {
                this.mWindowManager.updateViewLayout(this.Xs, this.Xr);
            }
            gridView.setSelection(i);
            if (this.XA != -1) {
                ((LinearLayout) gridView.getChildAt(this.XA - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.XA = i;
            this.Xz = gridView;
        }
    }

    private void uW() {
        if (this.Xt && this.Xs.getVisibility() != 8 && this.Xz != null) {
            this.Xz.setSelection(-1);
            this.Xs.setVisibility(8);
            if (this.XA != -1) {
                ((LinearLayout) this.Xz.getChildAt(this.XA - this.Xz.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.XA = -1;
            this.Xz = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.XC.set(x, y);
                break;
            case 1:
            case 3:
                uW();
                break;
            case 2:
                this.XC.set(x, y);
                if (this.Xt && this.Xs.getVisibility() != 8 && this.Xz != null) {
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
                this.XC.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                uW();
                break;
            case 2:
                getFocusedRect(this.Xu);
                if (!this.Xu.contains(x, y)) {
                    uW();
                    break;
                } else {
                    this.Xu.set(x, y, x + 1, y + 1);
                    if (this.Xz != null) {
                        offsetRectIntoDescendantCoords(this.Xz, this.Xu);
                        int pointToPosition = this.Xz.pointToPosition(this.Xu.left, this.Xu.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.Xz);
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
        if (this.Xt) {
            this.mWindowManager.removeView(this.Xs);
            this.Xt = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.XB != null) {
            this.XB.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        this.XE = i;
        ax.c(this.Xs, com.baidu.tieba.v.bg_expression_bubble, i);
        ax.d(this, com.baidu.tieba.t.editor_tool_container_bg, i);
    }

    public void reset() {
        uW();
    }

    public void setOnDataSelected(w wVar) {
        this.XD = wVar;
    }
}
