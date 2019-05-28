package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cFO;
    private boolean cFP;
    private int cFQ;
    private boolean cFR;
    private boolean cFS;
    private GestureDetector cFT;
    private GestureDetector cFU;
    private int cFV;
    private int cFW;
    private int cFX;
    private int cFY;
    private int cFZ;
    private int cGa;
    private int cGb;
    private boolean cGc;
    private float cGd;
    private int cGe;
    private int cGf;
    private int cGg;
    private boolean cGh;
    private a cGi;
    private int cGj;
    private GestureDetector.OnGestureListener cGk;
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
        this.cFO = 0;
        this.cFP = true;
        this.cFR = false;
        this.cFS = false;
        this.cFV = -1;
        this.cFW = -1;
        this.cFX = -1;
        this.mTempLoc = new int[2];
        this.cGc = false;
        this.cGd = 500.0f;
        this.cGk = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cFR && b.this.cFS) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cGd) {
                        if (b.this.cGj > (-width)) {
                            b.this.cGi.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cGd) && b.this.cGj < width) {
                        b.this.cGi.stopDragWithVelocity(true, f);
                    }
                    b.this.cFS = false;
                }
                return false;
            }
        };
        this.cGi = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cFT = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cGi.isDragEnabled() || b.this.cGi.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cGa = (int) motionEvent.getX();
                b.this.cGb = (int) motionEvent.getY();
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
        this.cFU = new GestureDetector(listView.getContext(), this.cGk);
        this.cFU.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cGe = i;
        this.cGf = i4;
        this.cGg = i5;
        ld(i3);
        lc(i2);
    }

    public GestureDetector aww() {
        return this.cFT;
    }

    public void lc(int i) {
        this.cFO = i;
    }

    public void fL(boolean z) {
        this.cFP = z;
    }

    public void ld(int i) {
        this.cFQ = i;
    }

    public void fM(boolean z) {
        this.cFR = z;
    }

    public boolean t(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cFP && !this.cFS) {
            i4 = 12;
        }
        if (this.cFR && this.cFS) {
            i4 = i4 | 1 | 2;
        }
        this.cGc = this.cGi.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cGc;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cGi.isDragEnabled() && !this.cGi.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cFR && this.cGc && this.cFQ == 1) {
                this.cFU.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cGa = (int) motionEvent.getX();
                    this.cGb = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cFR && this.cFS) {
                        if ((this.cGj >= 0 ? this.cGj : -this.cGj) > this.mListView.getWidth() / 2) {
                            this.cGi.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cFS = false;
                    this.cGc = false;
                    break;
                case 3:
                    this.cFS = false;
                    this.cGc = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cFR && this.cFS) {
            this.cGj = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cFQ == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cGe);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cGg);
    }

    public int c(MotionEvent motionEvent, int i) {
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
                        this.cFY = childAt.getLeft();
                        this.cFZ = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cFR && this.cFQ == 0) {
            this.cFX = c(motionEvent, this.cGf);
        }
        this.cFV = z(motionEvent);
        if (this.cFV != -1 && this.cFO == 0) {
            t(this.cFV, ((int) motionEvent.getX()) - this.cFY, ((int) motionEvent.getY()) - this.cFZ);
        }
        this.cFS = false;
        this.cGh = true;
        this.cGj = 0;
        this.cFW = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cFY;
            int i2 = y2 - this.cFZ;
            if (this.cGh && !this.cGc && (this.cFV != -1 || this.cFW != -1)) {
                if (this.cFV != -1) {
                    if (this.cFO == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cFP) {
                        t(this.cFV, i, i2);
                    } else if (this.cFO != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cFR) {
                        this.cFS = true;
                        t(this.cFW, i, i2);
                    }
                } else if (this.cFW != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cFR) {
                        this.cFS = true;
                        t(this.cFW, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cGh = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cFV != -1 && this.cFO == 2) {
            this.mListView.performHapticFeedback(0);
            t(this.cFV, this.cGa - this.cFY, this.cGb - this.cFZ);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cFR && this.cFQ == 0 && this.cFX != -1) {
            this.cGi.removeItem(this.cFX - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
