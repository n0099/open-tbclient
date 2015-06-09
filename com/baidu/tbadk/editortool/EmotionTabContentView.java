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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private GridView aje;
    private IndicatorView ajf;
    private WindowManager.LayoutParams ajg;
    private GifView ajh;
    private final Rect aji;
    private ViewGroup ajj;
    private int ajk;
    private int ajl;
    private int ajm;
    private boolean ajn;
    private int ajo;
    private u ajp;
    private List<ad> ajq;
    private List<u> ajr;
    private int ajs;
    private int ajt;
    private j aju;
    private int ajv;
    private final Point ajw;
    private v ajx;
    private int ajy;
    private com.baidu.adp.lib.e.b<GridView> ajz;
    private int currentPosition;
    private Context mContext;
    private ViewPager mViewPager;
    private WindowManager mWindowManager;

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aji = new Rect();
        this.ajo = -1;
        this.ajs = 0;
        this.ajt = -1;
        this.currentPosition = -1;
        this.ajw = new Point();
        this.ajx = null;
        init(context);
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.aji = new Rect();
        this.ajo = -1;
        this.ajs = 0;
        this.ajt = -1;
        this.currentPosition = -1;
        this.ajw = new Point();
        this.ajx = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ajq = new ArrayList();
        this.ajr = new ArrayList();
        this.ajz = new com.baidu.adp.lib.e.b<>(new d(this), 3, 0);
        setOrientation(1);
        com.baidu.adp.lib.g.b.hr().a(context, com.baidu.tieba.r.emotion_tab_content, this, true);
        this.mViewPager = (ViewPager) findViewById(com.baidu.tieba.q.face_tab_viewpager);
        this.mViewPager.setFadingEdgeLength(0);
        this.mViewPager.setOnPageChangeListener(this);
        this.ajh = new GifView(context);
        ay.c(this.ajh, com.baidu.tieba.p.bg_expression_bubble, this.ajy);
        this.ajh.setVisibility(8);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ajg = new WindowManager.LayoutParams();
        this.ajk = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds240);
        this.ajl = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds252);
        this.ajm = context.getResources().getDimensionPixelSize(com.baidu.tieba.o.face_tab_content_float_space);
        this.ajg.width = this.ajk;
        this.ajg.height = this.ajl;
        this.ajg.gravity = 51;
        this.ajg.format = -3;
        this.ajg.type = 1000;
        this.ajg.flags |= 56;
        this.ajj = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.ajf = (IndicatorView) findViewById(com.baidu.tieba.q.face_tab_indicator);
        if (MenuKeyUtils.hasSmartBar()) {
            this.ajg.type = 1000;
            this.ajg.flags = 25165832;
        }
    }

    private void p(List<ad> list) {
        int i;
        int i2;
        this.ajq.clear();
        this.ajr.clear();
        if (list != null && !list.isEmpty()) {
            this.ajq.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ad adVar = list.get(i3);
                if (adVar != null) {
                    int emotionsCount = adVar.getEmotionsCount();
                    int zZ = adVar.zZ();
                    int Aa = adVar.Aa();
                    int i4 = emotionsCount / (zZ * Aa);
                    if (emotionsCount % (zZ * Aa) != 0) {
                        i4++;
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        u uVar = new u();
                        if (i5 < i4 - 1) {
                            i = zZ * Aa;
                        } else {
                            i = emotionsCount - ((zZ * Aa) * (i4 - 1));
                        }
                        uVar.e(adVar);
                        uVar.dH(i3);
                        uVar.b(adVar.zC());
                        uVar.dB(Aa);
                        uVar.dC(zZ);
                        uVar.dD(i4);
                        uVar.dE(i5);
                        uVar.dF(i);
                        uVar.dG(i5 * zZ * Aa);
                        uVar.setEndIndex((i + i2) - 1);
                        this.ajr.add(uVar);
                    }
                }
            }
            this.ajs = this.ajr.size();
            for (int i6 = 0; i6 < this.ajs; i6++) {
                if (this.ajr != null && this.ajr.get(i6) != null) {
                    this.ajr.get(i6).setIndex(i6);
                }
            }
        }
    }

    private void dx(int i) {
        if (this.ajr != null) {
            int size = this.ajr.size();
            if (i >= 0 && i < size) {
                for (int i2 = 0; i2 < size; i2++) {
                    u uVar = this.ajr.get(i2);
                    if (uVar != null && uVar.zB() == i) {
                        this.ajv = uVar.getIndex();
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
                p(list);
                dx(i);
                this.mViewPager.setAdapter(new g(this));
                this.mViewPager.setCurrentItem(this.ajv, true);
                if (this.aju != null) {
                    this.aju.dz(i);
                    this.ajt = i;
                }
            }
        }
    }

    public void dy(int i) {
        int i2;
        if (this.mViewPager != null) {
            int size = this.ajr.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i2 = 0;
                        break;
                    }
                    u uVar = this.ajr.get(i3);
                    if (uVar == null || uVar.zB() != i) {
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
        if (this.ajo != i && gridView != null && (eVar = (e) gridView.getAdapter()) != null && eVar.zr() != null) {
            String dI = eVar.zr().zu().dI(eVar.zq() + i);
            this.ajh.setTag(dI);
            com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
            aVar.alt = dI;
            this.ajh.a(aVar);
            LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
            linearLayout.getDrawingRect(this.aji);
            this.ajj.offsetDescendantRectToMyCoords(linearLayout, this.aji);
            this.ajg.x = this.aji.left - ((this.ajg.width - linearLayout.getWidth()) / 2);
            this.ajg.y = (this.aji.top - this.ajg.height) + this.ajm;
            this.ajh.setVisibility(0);
            if (!this.ajn) {
                this.mWindowManager.addView(this.ajh, this.ajg);
                this.ajn = true;
            } else {
                this.mWindowManager.updateViewLayout(this.ajh, this.ajg);
            }
            gridView.setSelection(i);
            if (this.ajo != -1) {
                ((LinearLayout) gridView.getChildAt(this.ajo - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            linearLayout.getChildAt(0).setSelected(true);
            this.ajo = i;
            this.aje = gridView;
        }
    }

    private void zo() {
        if (this.ajn && this.ajh.getVisibility() != 8 && this.aje != null) {
            this.aje.setSelection(-1);
            this.ajh.setVisibility(8);
            if (this.ajo != -1) {
                ((LinearLayout) this.aje.getChildAt(this.ajo - this.aje.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.ajo = -1;
            this.aje = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.ajw.set(x, y);
                break;
            case 1:
            case 3:
                zo();
                break;
            case 2:
                this.ajw.set(x, y);
                if (this.ajn && this.ajh.getVisibility() != 8 && this.aje != null) {
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
                this.ajw.set(x, y);
                break;
            case 1:
            case 3:
            case 4:
                zo();
                break;
            case 2:
                getFocusedRect(this.aji);
                if (!this.aji.contains(x, y)) {
                    zo();
                    break;
                } else {
                    this.aji.set(x, y, x + 1, y + 1);
                    if (this.aje != null) {
                        offsetRectIntoDescendantCoords(this.aje, this.aji);
                        int pointToPosition = this.aje.pointToPosition(this.aji.left, this.aji.top);
                        if (pointToPosition != -1) {
                            a(pointToPosition, this.aje);
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
        if (this.ajn) {
            this.mWindowManager.removeView(this.ajh);
            this.ajn = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.ajr != null) {
            int size = this.ajr.size();
            if (i >= 0 && i < size) {
                this.ajp = this.ajr.get(i);
                if (this.ajf != null && this.ajp != null) {
                    if (this.currentPosition != i) {
                        this.currentPosition = i;
                        this.ajf.setVisibility(0);
                        this.ajf.setCount(this.ajp.zx());
                        if (this.ajp != null && this.ajp.zB() != this.ajt) {
                            this.ajt = this.ajp.zB();
                            if (this.aju != null) {
                                this.aju.dz(this.ajp.zB());
                            }
                        }
                    }
                    this.ajf.setPosition(this.ajp.zy() + f);
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
        this.ajy = i;
        ay.c(this.ajh, com.baidu.tieba.p.bg_expression_bubble, i);
        ay.d(this, com.baidu.tieba.n.write_editor_background, i);
        this.ajf.setSelector(ay.n(i, com.baidu.tieba.p.dot_pb_expression_s));
        this.ajf.setDrawable(ay.n(i, com.baidu.tieba.p.dot_pb_expression_n));
    }

    public void reset() {
        zo();
    }

    public void setOnEmotionSwitchedListener(j jVar) {
        this.aju = jVar;
    }

    public void setOnDataSelected(v vVar) {
        this.ajx = vVar;
    }
}
