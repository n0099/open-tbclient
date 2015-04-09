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
    private GridView aie;
    private IndicatorView aif;
    private WindowManager.LayoutParams aig;
    private GifView aih;
    private final Rect aii;
    private ViewGroup aij;
    private int aik;
    private int ail;
    private int aim;
    private boolean ain;
    private int aio;
    private u aip;
    private List<ad> aiq;
    private List<u> air;
    private int ais;
    private int ait;
    private j aiu;
    private int aiv;
    private final Point aiw;
    private v aix;
    private int aiy;
    private com.baidu.adp.lib.e.b<GridView> aiz;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aii = new Rect();
        this.aio = -1;
        this.ais = 0;
        this.ait = -1;
        this.currentPosition = -1;
        this.aiw = new Point();
        this.aix = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.aii = new Rect();
        this.aio = -1;
        this.ais = 0;
        this.ait = -1;
        this.currentPosition = -1;
        this.aiw = new Point();
        this.aix = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aiq = new ArrayList();
        this.air = new ArrayList();
        this.aiz = new com.baidu.adp.lib.e.b<>(new d(this), 3, 0);
        setOrientation(1);
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.emotion_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.v.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.aih = new GifView(context);
        ba.c(this.aih, com.baidu.tieba.u.bg_expression_bubble, this.aiy);
        this.aih.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.aig = new WindowManager.LayoutParams();
        this.aik = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds240);
        this.ail = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds252);
        this.aim = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.face_tab_content_float_space);
        this.aig.width = this.aik;
        this.aig.height = this.ail;
        this.aig.gravity = 51;
        this.aig.format = -3;
        this.aig.type = 1000;
        this.aig.flags |= 56;
        this.aij = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.aif = (IndicatorView) findViewById(com.baidu.tieba.v.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.aig.type = 1000;
            this.aig.flags = 25165832;
        }
    }

    private void o(List<ad> list) {
        int i;
        int i2;
        this.aiq.clear();
        this.air.clear();
        if (list != null && !list.isEmpty()) {
            this.aiq.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ad adVar = list.get(i3);
                if (adVar != null) {
                    int emotionsCount = adVar.getEmotionsCount();
                    int zl = adVar.zl();
                    int zm = adVar.zm();
                    int i4 = emotionsCount / (zl * zm);
                    if (emotionsCount % (zl * zm) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        u uVar = new u();
                        if (i5 < i4 - 1) {
                            i = zl * zm;
                        } else {
                            i = emotionsCount - ((zl * zm) * (i4 - 1));
                        }
                        uVar.e(adVar);
                        uVar.dy(i3);
                        uVar.b(adVar.yO());
                        uVar.ds(zm);
                        uVar.dt(zl);
                        uVar.du(i4);
                        uVar.dv(i5);
                        uVar.dw(i);
                        uVar.dx(i5 * zl * zm);
                        uVar.setEndIndex((i + i2) - 1);
                        this.air.add(uVar);
                    }
                }
            }
            this.ais = this.air.size();
            for (int i6 = 0; i6 < this.ais; i6++) {
                if (this.air != null && this.air.get(i6) != null) {
                    this.air.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dn(int i) {
        if (this.air != null) {
            int size = this.air.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    u uVar = this.air.get(i2);
                    if (uVar != null && uVar.yN() == i) {
                        this.aiv = uVar.getIndex();
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
                this.mViewPager.setCurrentItem(this.aiv, true);
                if (this.aiu != null) {
                    this.aiu.dq(i);
                    this.ait = i;
                }
            }
        }
    }

    public void dp(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.air.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    u uVar = this.air.get(i3);
                    if (uVar == null || uVar.yN() != i) {
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
        if (this.aio != i && gridView != null && (eVar = (e) gridView.getAdapter()) != null && eVar.yD() != null) {
            String dz = eVar.yD().yG().dz(eVar.yC() + i);
            this.aih.setTag(dz);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.aks = dz;
            this.aih.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.aii);
            this.aij.offsetDescendantRectToMyCoords(linearLayout, this.aii);
            this.aig.x = this.aii.left - ((this.aig.width - linearLayout.getWidth()) / 2);
            this.aig.y = (this.aii.top - this.aig.height) + this.aim;
            this.aih.setVisibility(0);
            if (!this.ain) {
                this.mWindowManager.addView(this.aih, this.aig);
                this.ain = true;
            } else {
                this.mWindowManager.updateViewLayout(this.aih, this.aig);
            }
            gridView.setSelection(i);
            if (this.aio != -1) {
                ((LinearLayout) gridView.getChildAt(this.aio - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.aio = i;
            this.aie = gridView;
        }
    }

    private void yA() {
        if (this.ain && this.aih.getVisibility() != 8 && this.aie != null) {
            this.aie.setSelection(-1);
            this.aih.setVisibility(8);
            if (this.aio != -1) {
                ((LinearLayout) this.aie.getChildAt(this.aio - this.aie.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.aio = -1;
            this.aie = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.aiw.set(x, y);
                break;
            case 1:
            case 3:
                yA();
                break;
            case 2:
                this.aiw.set(x, y);
                if (this.ain && this.aih.getVisibility() != 8 && this.aie != null) {
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
                this.aiw.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                yA();
                break;
            case 2:
                getFocusedRect(this.aii);
                if (!this.aii.contains(x, y)) {
                    yA();
                    break;
                } else {
                    this.aii.set(x, y, x + 1, y + 1);
                    if (this.aie != null) {
                        offsetRectIntoDescendantCoords(this.aie, this.aii);
                        int pointToPosition = this.aie.pointToPosition(this.aii.left, this.aii.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aie);
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
        if (this.ain) {
            this.mWindowManager.removeView(this.aih);
            this.ain = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.air != null) {
            int size = this.air.size();
            if (i >= 0 && i < size) {
                this.aip = this.air.get(i);
                if (this.aif != null && this.aip != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.aif.setVisibility(0);
                        this.aif.setCount(this.aip.yJ());
                        if (this.aip != null && this.aip.yN() != this.ait) {
                            this.ait = this.aip.yN();
                            if (this.aiu != null) {
                                this.aiu.dq(this.aip.yN());
                            }
                        }
                    }
                    this.aif.setPosition(this.aip.yK() + f);
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
        this.aiy = i;
        ba.c(this.aih, com.baidu.tieba.u.bg_expression_bubble, i);
        ba.d(this, com.baidu.tieba.s.write_editor_background, i);
        this.aif.setSelector(ba.n(i, com.baidu.tieba.u.dot_pb_expression_s));
        this.aif.setDrawable(ba.n(i, com.baidu.tieba.u.dot_pb_expression_n));
    }

    public void reset() {
        yA();
    }

    public void setOnEmotionSwitchedListener(j jVar) {
        this.aiu = jVar;
    }

    public void setOnDataSelected(v vVar) {
        this.aix = vVar;
    }
}
