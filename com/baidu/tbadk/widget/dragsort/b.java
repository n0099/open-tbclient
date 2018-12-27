package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bmA;
    private int bmB;
    private int bmC;
    private boolean bmD;
    private float bmE;
    private int bmF;
    private int bmG;
    private int bmH;
    private boolean bmI;
    private a bmJ;
    private int bmK;
    private GestureDetector.OnGestureListener bmL;
    private int bmo;
    private boolean bmq;
    private int bmr;
    private boolean bms;
    private boolean bmt;
    private GestureDetector bmu;
    private GestureDetector bmv;
    private int bmw;
    private int bmx;
    private int bmy;
    private int bmz;
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
        this.bmo = 0;
        this.bmq = true;
        this.bms = false;
        this.bmt = false;
        this.bmw = -1;
        this.bmx = -1;
        this.bmy = -1;
        this.mTempLoc = new int[2];
        this.bmD = false;
        this.bmE = 500.0f;
        this.bmL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bms && b.this.bmt) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bmE) {
                        if (b.this.bmK > (-width)) {
                            b.this.bmJ.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bmE) && b.this.bmK < width) {
                        b.this.bmJ.stopDragWithVelocity(true, f);
                    }
                    b.this.bmt = false;
                }
                return false;
            }
        };
        this.bmJ = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bmu = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bmJ.isDragEnabled() || b.this.bmJ.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bmB = (int) motionEvent.getX();
                b.this.bmC = (int) motionEvent.getY();
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
        this.bmv = new GestureDetector(listView.getContext(), this.bmL);
        this.bmv.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bmF = i;
        this.bmG = i4;
        this.bmH = i5;
        gB(i3);
        gA(i2);
    }

    public GestureDetector Rc() {
        return this.bmu;
    }

    public void gA(int i) {
        this.bmo = i;
    }

    public void cV(boolean z) {
        this.bmq = z;
    }

    public void gB(int i) {
        this.bmr = i;
    }

    public void cW(boolean z) {
        this.bms = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bmq && !this.bmt) {
            i4 = 12;
        }
        if (this.bms && this.bmt) {
            i4 = i4 | 1 | 2;
        }
        this.bmD = this.bmJ.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bmD;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bmJ.isDragEnabled() && !this.bmJ.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bms && this.bmD && this.bmr == 1) {
                this.bmv.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bmB = (int) motionEvent.getX();
                    this.bmC = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bms && this.bmt) {
                        if ((this.bmK >= 0 ? this.bmK : -this.bmK) > this.mListView.getWidth() / 2) {
                            this.bmJ.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bmt = false;
                    this.bmD = false;
                    break;
                case 3:
                    this.bmt = false;
                    this.bmD = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bms && this.bmt) {
            this.bmK = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bmr == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bmF);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.bmH);
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
                        this.bmz = childAt.getLeft();
                        this.bmA = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bms && this.bmr == 0) {
            this.bmy = b(motionEvent, this.bmG);
        }
        this.bmw = v(motionEvent);
        if (this.bmw != -1 && this.bmo == 0) {
            p(this.bmw, ((int) motionEvent.getX()) - this.bmz, ((int) motionEvent.getY()) - this.bmA);
        }
        this.bmt = false;
        this.bmI = true;
        this.bmK = 0;
        this.bmx = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bmz;
            int i2 = y2 - this.bmA;
            if (this.bmI && !this.bmD && (this.bmw != -1 || this.bmx != -1)) {
                if (this.bmw != -1) {
                    if (this.bmo == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bmq) {
                        p(this.bmw, i, i2);
                    } else if (this.bmo != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bms) {
                        this.bmt = true;
                        p(this.bmx, i, i2);
                    }
                } else if (this.bmx != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bms) {
                        this.bmt = true;
                        p(this.bmx, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bmI = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bmw != -1 && this.bmo == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.bmw, this.bmB - this.bmz, this.bmC - this.bmA);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bms && this.bmr == 0 && this.bmy != -1) {
            this.bmJ.removeItem(this.bmy - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
