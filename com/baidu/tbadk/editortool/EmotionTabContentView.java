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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.gif.GifView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ae XT;
    private WindowManager.LayoutParams XU;
    private GifView XV;
    private boolean XW;
    private final Rect XX;
    private ViewGroup XY;
    private int XZ;
    private int Ya;
    private int Yb;
    private GridView Yc;
    private int Yd;
    private IndicatorView Ye;
    private final Point Yf;
    private w Yg;
    private int Yh;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XX = new Rect();
        this.Yd = -1;
        this.Yf = new Point();
        this.Yg = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.XX = new Rect();
        this.Yd = -1;
        this.Yf = new Point();
        this.Yg = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.emotion_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.w.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.XV = new GifView(context);
        bc.c(this.XV, com.baidu.tieba.v.bg_expression_bubble, this.Yh);
        this.XV.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.XU = new WindowManager.LayoutParams();
        this.XZ = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_width);
        this.Ya = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_height);
        this.Yb = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_space);
        this.XU.width = this.XZ;
        this.XU.height = this.Ya;
        this.XU.gravity = 51;
        this.XU.format = -3;
        this.XU.type = 1000;
        this.XU.flags |= 56;
        this.XY = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.Ye = (IndicatorView) findViewById(com.baidu.tieba.w.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.XU.type = 1000;
            this.XU.flags = 25165832;
        }
    }

    public void b(ae aeVar) {
        int i;
        this.XT = aeVar;
        int emotionsCount = this.XT.getEmotionsCount();
        int vF = aeVar.vF();
        int vG = aeVar.vG();
        if (vF != 0 && vG != 0) {
            int i2 = emotionsCount / (vF * vG);
            int i3 = emotionsCount % (vF * vG) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.Ye.setVisibility(0);
                this.Ye.setCount(i3);
                this.Ye.setPosition(0.0f);
            } else {
                this.Ye.setVisibility(4);
            }
            this.mViewPager.setAdapter(null);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(aeVar.vF());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.t.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = vF * vG;
                } else {
                    i = emotionsCount - ((vF * vG) * (i3 - 1));
                }
                int i5 = i4 * vF * vG;
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this, i5));
                gridView.setAdapter((ListAdapter) new j(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.mViewPager.setAdapter(new l(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.Yd != i) {
            String dl = this.XT.dl(((j) gridView.getAdapter()).vi() + i);
            this.XV.setTag(dl);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.ZM = dl;
            this.XV.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.XX);
            this.XY.offsetDescendantRectToMyCoords(linearLayout, this.XX);
            this.XU.x = this.XX.left - ((this.XU.width - linearLayout.getWidth()) / 2);
            this.XU.y = (this.XX.top - this.XU.height) + this.Yb;
            this.XV.setVisibility(0);
            if (!this.XW) {
                this.mWindowManager.addView(this.XV, this.XU);
                this.XW = true;
            } else {
                this.mWindowManager.updateViewLayout(this.XV, this.XU);
            }
            gridView.setSelection(i);
            if (this.Yd != -1) {
                ((LinearLayout) gridView.getChildAt(this.Yd - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.Yd = i;
            this.Yc = gridView;
        }
    }

    private void vh() {
        if (this.XW && this.XV.getVisibility() != 8 && this.Yc != null) {
            this.Yc.setSelection(-1);
            this.XV.setVisibility(8);
            if (this.Yd != -1) {
                ((LinearLayout) this.Yc.getChildAt(this.Yd - this.Yc.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.Yd = -1;
            this.Yc = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.Yf.set(x, y);
                break;
            case 1:
            case 3:
                vh();
                break;
            case 2:
                this.Yf.set(x, y);
                if (this.XW && this.XV.getVisibility() != 8 && this.Yc != null) {
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
                this.Yf.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                vh();
                break;
            case 2:
                getFocusedRect(this.XX);
                if (!this.XX.contains(x, y)) {
                    vh();
                    break;
                } else {
                    this.XX.set(x, y, x + 1, y + 1);
                    if (this.Yc != null) {
                        offsetRectIntoDescendantCoords(this.Yc, this.XX);
                        int pointToPosition = this.Yc.pointToPosition(this.XX.left, this.XX.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.Yc);
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
        if (this.XW) {
            this.mWindowManager.removeView(this.XV);
            this.XW = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.Ye != null) {
            this.Ye.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        this.Yh = i;
        bc.c(this.XV, com.baidu.tieba.v.bg_expression_bubble, i);
        bc.d(this, com.baidu.tieba.t.editor_tool_container_bg, i);
    }

    public void reset() {
        vh();
    }

    public void setOnDataSelected(w wVar) {
        this.Yg = wVar;
    }
}
