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
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.gif.GifView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private GridView ahW;
    private IndicatorView ahX;
    private WindowManager.LayoutParams ahY;
    private GifView ahZ;
    private final Rect aia;
    private ViewGroup aib;
    private int aic;
    private int aid;
    private int aie;
    private boolean aif;
    private int aig;
    private u aih;
    private List<ad> aii;
    private List<u> aij;
    private int aik;
    private int ail;
    private j aim;
    private int ain;
    private final Point aio;
    private v aip;
    private int aiq;
    private com.baidu.adp.lib.e.b<GridView> air;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aia = new Rect();
        this.aig = -1;
        this.aik = 0;
        this.ail = -1;
        this.currentPosition = -1;
        this.aio = new Point();
        this.aip = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.aia = new Rect();
        this.aig = -1;
        this.aik = 0;
        this.ail = -1;
        this.currentPosition = -1;
        this.aio = new Point();
        this.aip = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aii = new ArrayList();
        this.aij = new ArrayList();
        this.air = new com.baidu.adp.lib.e.b<>(new d(this), 3, 0);
        setOrientation(1);
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.emotion_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.v.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.ahZ = new GifView(context);
        ba.c(this.ahZ, com.baidu.tieba.u.bg_expression_bubble, this.aiq);
        this.ahZ.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ahY = new WindowManager.LayoutParams();
        this.aic = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds240);
        this.aid = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds252);
        this.aie = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_space);
        this.ahY.width = this.aic;
        this.ahY.height = this.aid;
        this.ahY.gravity = 51;
        this.ahY.format = -3;
        this.ahY.type = 1000;
        this.ahY.flags |= 56;
        this.aib = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ahX = (IndicatorView) findViewById(com.baidu.tieba.v.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ahY.type = 1000;
            this.ahY.flags = 25165832;
        }
    }

    private void o(List<ad> list) {
        int i;
        int i2;
        this.aii.clear();
        this.aij.clear();
        if (list != null && !list.isEmpty()) {
            this.aii.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ad adVar = list.get(i3);
                if (adVar != null) {
                    int emotionsCount = adVar.getEmotionsCount();
                    int zf = adVar.zf();
                    int zg = adVar.zg();
                    int i4 = emotionsCount / (zf * zg);
                    if (emotionsCount % (zf * zg) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        u uVar = new u();
                        if (i5 < i4 - 1) {
                            i = zf * zg;
                        } else {
                            i = emotionsCount - ((zf * zg) * (i4 - 1));
                        }
                        uVar.e(adVar);
                        uVar.dy(i3);
                        uVar.b(adVar.yI());
                        uVar.ds(zg);
                        uVar.dt(zf);
                        uVar.du(i4);
                        uVar.dv(i5);
                        uVar.dw(i);
                        uVar.dx(i5 * zf * zg);
                        uVar.setEndIndex((i + i2) - 1);
                        this.aij.add(uVar);
                    }
                }
            }
            this.aik = this.aij.size();
            for (int i6 = 0; i6 < this.aik; i6++) {
                if (this.aij != null && this.aij.get(i6) != null) {
                    this.aij.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dn(int i) {
        if (this.aij != null) {
            int size = this.aij.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    u uVar = this.aij.get(i2);
                    if (uVar != null && uVar.yH() == i) {
                        this.ain = uVar.getIndex();
                        return;
                    }
                }
            }
        }
    }

    public void b(List<ad> list, int i) {
        if (list != null) {
            int size = list.size();
            if (i >= 0 && i < size) {
                o(list);
                dn(i);
                this.mViewPager.setAdapter(new g(this));
                this.mViewPager.setCurrentItem(this.ain, true);
                if (this.aim != null) {
                    this.aim.dq(i);
                    this.ail = i;
                }
            }
        }
    }

    public void dp(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.aij.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    u uVar = this.aij.get(i3);
                    if (uVar == null || uVar.yH() != i) {
                        i3++;
                    } else {
                        i2 = uVar.getIndex();
                        break;
                    }
                }
                this.mViewPager.setCurrentItem(i2, true);
            }
        }
    }

    public void a(int i, GridView gridView) {
        e eVar;
        if (this.aig != i && gridView != null && (eVar = (e) gridView.getAdapter()) != null && eVar.yx() != null) {
            String dz = eVar.yx().yA().dz(eVar.yw() + i);
            this.ahZ.setTag(dz);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.akk = dz;
            this.ahZ.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.aia);
            this.aib.offsetDescendantRectToMyCoords(linearLayout, this.aia);
            this.ahY.x = this.aia.left - ((this.ahY.width - linearLayout.getWidth()) / 2);
            this.ahY.y = (this.aia.top - this.ahY.height) + this.aie;
            this.ahZ.setVisibility(0);
            if (!this.aif) {
                this.mWindowManager.addView(this.ahZ, this.ahY);
                this.aif = true;
            } else {
                this.mWindowManager.updateViewLayout(this.ahZ, this.ahY);
            }
            gridView.setSelection(i);
            if (this.aig != -1) {
                ((LinearLayout) gridView.getChildAt(this.aig - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aig = i;
            this.ahW = gridView;
        }
    }

    private void yu() {
        if (this.aif && this.ahZ.getVisibility() != 8 && this.ahW != null) {
            this.ahW.setSelection(-1);
            this.ahZ.setVisibility(8);
            if (this.aig != -1) {
                ((LinearLayout) this.ahW.getChildAt(this.aig - this.ahW.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aig = -1;
            this.ahW = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aio.set(x, y);
                break;
            case 1:
            case 3:
                yu();
                break;
            case 2:
                this.aio.set(x, y);
                if (this.aif && this.ahZ.getVisibility() != 8 && this.ahW != null) {
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
                this.aio.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                yu();
                break;
            case 2:
                getFocusedRect(this.aia);
                if (!this.aia.contains(x, y)) {
                    yu();
                    break;
                } else {
                    this.aia.set(x, y, x + 1, y + 1);
                    if (this.ahW != null) {
                        offsetRectIntoDescendantCoords(this.ahW, this.aia);
                        int pointToPosition = this.ahW.pointToPosition(this.aia.left, this.aia.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.ahW);
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
        if (this.aif) {
            this.mWindowManager.removeView(this.ahZ);
            this.aif = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aij != null) {
            int size = this.aij.size();
            if (i >= 0 && i < size) {
                this.aih = this.aij.get(i);
                if (this.ahX != null && this.aih != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ahX.setVisibility(0);
                        this.ahX.setCount(this.aih.yD());
                        if (this.aih != null && this.aih.yH() != this.ail) {
                            this.ail = this.aih.yH();
                            if (this.aim != null) {
                                this.aim.dq(this.aih.yH());
                            }
                        }
                    }
                    this.ahX.setPosition(this.aih.yE() + f);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void onChangeSkinType(int i) {
        this.aiq = i;
        ba.c(this.ahZ, com.baidu.tieba.u.bg_expression_bubble, i);
        ba.d(this, com.baidu.tieba.s.write_editor_background, i);
        this.ahX.setSelector(ba.n(i, com.baidu.tieba.u.dot_pb_expression_s));
        this.ahX.setDrawable(ba.n(i, com.baidu.tieba.u.dot_pb_expression_n));
    }

    public void reset() {
        yu();
    }

    public void setOnEmotionSwitchedListener(j jVar) {
        this.aim = jVar;
    }

    public void setOnDataSelected(v vVar) {
        this.aip = vVar;
    }
}
