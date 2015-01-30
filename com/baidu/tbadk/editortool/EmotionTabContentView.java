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
    private ae XW;
    private WindowManager.LayoutParams XX;
    private GifView XY;
    private boolean XZ;
    private final Rect Ya;
    private ViewGroup Yb;
    private int Yc;
    private int Yd;
    private int Ye;
    private GridView Yf;
    private int Yg;
    private IndicatorView Yh;
    private final Point Yi;
    private w Yj;
    private int Yk;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ya = new Rect();
        this.Yg = -1;
        this.Yi = new Point();
        this.Yj = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.Ya = new Rect();
        this.Yg = -1;
        this.Yi = new Point();
        this.Yj = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.emotion_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.w.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.XY = new GifView(context);
        bc.c(this.XY, com.baidu.tieba.v.bg_expression_bubble, this.Yk);
        this.XY.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.XX = new WindowManager.LayoutParams();
        this.Yc = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_width);
        this.Yd = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_height);
        this.Ye = context.getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_content_float_space);
        this.XX.width = this.Yc;
        this.XX.height = this.Yd;
        this.XX.gravity = 51;
        this.XX.format = -3;
        this.XX.type = 1000;
        this.XX.flags |= 56;
        this.Yb = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.Yh = (IndicatorView) findViewById(com.baidu.tieba.w.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.XX.type = 1000;
            this.XX.flags = 25165832;
        }
    }

    public void b(ae aeVar) {
        int i;
        this.XW = aeVar;
        int emotionsCount = this.XW.getEmotionsCount();
        int vL = aeVar.vL();
        int vM = aeVar.vM();
        if (vL != 0 && vM != 0) {
            int i2 = emotionsCount / (vL * vM);
            int i3 = emotionsCount % (vL * vM) == 0 ? i2 : i2 + 1;
            if (i3 > 1) {
                this.Yh.setVisibility(0);
                this.Yh.setCount(i3);
                this.Yh.setPosition(0.0f);
            } else {
                this.Yh.setVisibility(4);
            }
            this.mViewPager.setAdapter(null);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i3; i4++) {
                GridView gridView = new GridView(getContext());
                gridView.setNumColumns(aeVar.vL());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(com.baidu.tieba.t.transparent);
                gridView.setSelection(-1);
                if (i4 < i3 - 1) {
                    i = vL * vM;
                } else {
                    i = emotionsCount - ((vL * vM) * (i3 - 1));
                }
                int i5 = i4 * vL * vM;
                gridView.setOnItemLongClickListener(new h(this));
                gridView.setOnItemClickListener(new i(this, i5));
                gridView.setAdapter((ListAdapter) new j(this, getContext(), i, i5));
                arrayList.add(gridView);
            }
            this.mViewPager.setAdapter(new l(this, arrayList));
        }
    }

    public void a(int i, GridView gridView) {
        if (this.Yg != i) {
            String dl = this.XW.dl(((j) gridView.getAdapter()).vo() + i);
            this.XY.setTag(dl);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.ZP = dl;
            this.XY.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.Ya);
            this.Yb.offsetDescendantRectToMyCoords(linearLayout, this.Ya);
            this.XX.x = this.Ya.left - ((this.XX.width - linearLayout.getWidth()) / 2);
            this.XX.y = (this.Ya.top - this.XX.height) + this.Ye;
            this.XY.setVisibility(0);
            if (!this.XZ) {
                this.mWindowManager.addView(this.XY, this.XX);
                this.XZ = true;
            } else {
                this.mWindowManager.updateViewLayout(this.XY, this.XX);
            }
            gridView.setSelection(i);
            if (this.Yg != -1) {
                ((LinearLayout) gridView.getChildAt(this.Yg - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.Yg = i;
            this.Yf = gridView;
        }
    }

    private void vn() {
        if (this.XZ && this.XY.getVisibility() != 8 && this.Yf != null) {
            this.Yf.setSelection(-1);
            this.XY.setVisibility(8);
            if (this.Yg != -1) {
                ((LinearLayout) this.Yf.getChildAt(this.Yg - this.Yf.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.Yg = -1;
            this.Yf = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.Yi.set(x, y);
                break;
            case 1:
            case 3:
                vn();
                break;
            case 2:
                this.Yi.set(x, y);
                if (this.XZ && this.XY.getVisibility() != 8 && this.Yf != null) {
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
                this.Yi.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                vn();
                break;
            case 2:
                getFocusedRect(this.Ya);
                if (!this.Ya.contains(x, y)) {
                    vn();
                    break;
                } else {
                    this.Ya.set(x, y, x + 1, y + 1);
                    if (this.Yf != null) {
                        offsetRectIntoDescendantCoords(this.Yf, this.Ya);
                        int pointToPosition = this.Yf.pointToPosition(this.Ya.left, this.Ya.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.Yf);
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
        if (this.XZ) {
            this.mWindowManager.removeView(this.XY);
            this.XZ = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.Yh != null) {
            this.Yh.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        this.Yk = i;
        bc.c(this.XY, com.baidu.tieba.v.bg_expression_bubble, i);
        bc.d(this, com.baidu.tieba.t.editor_tool_container_bg, i);
    }

    public void reset() {
        vn();
    }

    public void setOnDataSelected(w wVar) {
        this.Yj = wVar;
    }
}
