package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int biO;
    private boolean biP;
    private int biQ;
    private boolean biR;
    private boolean biS;
    private GestureDetector biT;
    private GestureDetector biU;
    private int biV;
    private int biW;
    private int biX;
    private int biY;
    private int biZ;
    private int bja;
    private int bjb;
    private boolean bjc;
    private float bjd;
    private int bje;
    private int bjf;
    private int bjg;
    private boolean bjh;
    private a bji;
    private int bjj;
    private GestureDetector.OnGestureListener bjk;
    private GestureDetector mDetector;
    private ListView mListView;
    private int[] mTempLoc;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.biO = 0;
        this.biP = true;
        this.biR = false;
        this.biS = false;
        this.biV = -1;
        this.biW = -1;
        this.biX = -1;
        this.mTempLoc = new int[2];
        this.bjc = false;
        this.bjd = 500.0f;
        this.bjk = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.biR && b.this.biS) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bjd) {
                        if (b.this.bjj > (-width)) {
                            b.this.bji.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bjd) && b.this.bjj < width) {
                        b.this.bji.stopDragWithVelocity(true, f);
                    }
                    b.this.biS = false;
                }
                return false;
            }
        };
        this.bji = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.biT = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bji.isDragEnabled() || b.this.bji.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bja = (int) motionEvent.getX();
                b.this.bjb = (int) motionEvent.getY();
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                b.this.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
        this.biU = new GestureDetector(listView.getContext(), this.bjk);
        this.biU.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bje = i;
        this.bjf = i4;
        this.bjg = i5;
        gm(i3);
        gl(i2);
    }

    public GestureDetector PU() {
        return this.biT;
    }

    public void gl(int i) {
        this.biO = i;
    }

    public void cU(boolean z) {
        this.biP = z;
    }

    public void gm(int i) {
        this.biQ = i;
    }

    public void cV(boolean z) {
        this.biR = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.biP && !this.biS) {
            i4 = 12;
        }
        if (this.biR && this.biS) {
            i4 = i4 | 1 | 2;
        }
        this.bjc = this.bji.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bjc;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bji.isDragEnabled() && !this.bji.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.biR && this.bjc && this.biQ == 1) {
                this.biU.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bja = (int) motionEvent.getX();
                    this.bjb = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.biR && this.biS) {
                        if ((this.bjj >= 0 ? this.bjj : -this.bjj) > this.mListView.getWidth() / 2) {
                            this.bji.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.biS = false;
                    this.bjc = false;
                    break;
                case 3:
                    this.biS = false;
                    this.bjc = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.biR && this.biS) {
            this.bjj = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.biQ == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bje);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.bjg);
    }

    public int b(MotionEvent motionEvent, int i) {
        int pointToPosition = this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int count = this.mListView.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.mListView.getChildAt(pointToPosition - this.mListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[0] && rawY > this.mTempLoc[1] && rawX < this.mTempLoc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.mTempLoc[1]) {
                        this.biY = childAt.getLeft();
                        this.biZ = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.biR && this.biQ == 0) {
            this.biX = b(motionEvent, this.bjf);
        }
        this.biV = v(motionEvent);
        if (this.biV != -1 && this.biO == 0) {
            p(this.biV, ((int) motionEvent.getX()) - this.biY, ((int) motionEvent.getY()) - this.biZ);
        }
        this.biS = false;
        this.bjh = true;
        this.bjj = 0;
        this.biW = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.biY;
            int i2 = y2 - this.biZ;
            if (this.bjh && !this.bjc && (this.biV != -1 || this.biW != -1)) {
                if (this.biV != -1) {
                    if (this.biO == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.biP) {
                        p(this.biV, i, i2);
                    } else if (this.biO != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.biR) {
                        this.biS = true;
                        p(this.biW, i, i2);
                    }
                } else if (this.biW != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.biR) {
                        this.biS = true;
                        p(this.biW, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bjh = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.biV != -1 && this.biO == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.biV, this.bja - this.biY, this.bjb - this.biZ);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.biR && this.biQ == 0 && this.biX != -1) {
            this.bji.removeItem(this.biX - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
