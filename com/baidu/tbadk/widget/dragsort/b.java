package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private boolean bmA;
    private float bmB;
    private int bmC;
    private int bmD;
    private int bmE;
    private boolean bmF;
    private a bmG;
    private int bmH;
    private GestureDetector.OnGestureListener bmI;
    private int bml;
    private boolean bmm;
    private int bmn;
    private boolean bmo;
    private boolean bmq;
    private GestureDetector bmr;
    private GestureDetector bms;
    private int bmt;
    private int bmu;
    private int bmv;
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
        this.bml = 0;
        this.bmm = true;
        this.bmo = false;
        this.bmq = false;
        this.bmt = -1;
        this.bmu = -1;
        this.bmv = -1;
        this.mTempLoc = new int[2];
        this.bmA = false;
        this.bmB = 500.0f;
        this.bmI = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bmo && b.this.bmq) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bmB) {
                        if (b.this.bmH > (-width)) {
                            b.this.bmG.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bmB) && b.this.bmH < width) {
                        b.this.bmG.stopDragWithVelocity(true, f);
                    }
                    b.this.bmq = false;
                }
                return false;
            }
        };
        this.bmG = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bmr = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bmG.isDragEnabled() || b.this.bmG.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bmy = (int) motionEvent.getX();
                b.this.bmz = (int) motionEvent.getY();
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
        this.bms = new GestureDetector(listView.getContext(), this.bmI);
        this.bms.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bmC = i;
        this.bmD = i4;
        this.bmE = i5;
        gA(i3);
        gz(i2);
    }

    public GestureDetector Ra() {
        return this.bmr;
    }

    public void gz(int i) {
        this.bml = i;
    }

    public void cV(boolean z) {
        this.bmm = z;
    }

    public void gA(int i) {
        this.bmn = i;
    }

    public void cW(boolean z) {
        this.bmo = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bmm && !this.bmq) {
            i4 = 12;
        }
        if (this.bmo && this.bmq) {
            i4 = i4 | 1 | 2;
        }
        this.bmA = this.bmG.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bmA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bmG.isDragEnabled() && !this.bmG.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bmo && this.bmA && this.bmn == 1) {
                this.bms.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bmy = (int) motionEvent.getX();
                    this.bmz = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bmo && this.bmq) {
                        if ((this.bmH >= 0 ? this.bmH : -this.bmH) > this.mListView.getWidth() / 2) {
                            this.bmG.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bmq = false;
                    this.bmA = false;
                    break;
                case 3:
                    this.bmq = false;
                    this.bmA = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bmo && this.bmq) {
            this.bmH = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bmn == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bmC);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.bmE);
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
                        this.bmw = childAt.getLeft();
                        this.bmx = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bmo && this.bmn == 0) {
            this.bmv = b(motionEvent, this.bmD);
        }
        this.bmt = v(motionEvent);
        if (this.bmt != -1 && this.bml == 0) {
            p(this.bmt, ((int) motionEvent.getX()) - this.bmw, ((int) motionEvent.getY()) - this.bmx);
        }
        this.bmq = false;
        this.bmF = true;
        this.bmH = 0;
        this.bmu = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bmw;
            int i2 = y2 - this.bmx;
            if (this.bmF && !this.bmA && (this.bmt != -1 || this.bmu != -1)) {
                if (this.bmt != -1) {
                    if (this.bml == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bmm) {
                        p(this.bmt, i, i2);
                    } else if (this.bml != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bmo) {
                        this.bmq = true;
                        p(this.bmu, i, i2);
                    }
                } else if (this.bmu != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bmo) {
                        this.bmq = true;
                        p(this.bmu, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bmF = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bmt != -1 && this.bml == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.bmt, this.bmy - this.bmw, this.bmz - this.bmx);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bmo && this.bmn == 0 && this.bmv != -1) {
            this.bmG.removeItem(this.bmv - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
